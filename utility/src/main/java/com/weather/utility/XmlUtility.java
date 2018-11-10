package com.weather.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.weather.data.City;
import com.weather.data.DayNight;
import com.weather.data.Forecast;

/**
 * read requested url and get xml data </br>
 * parse xml data into logical entity data
 */
public class XmlUtility {

	private static URL weatherUrl;
	private static final String DATA_FILE = "DATA.xml";

	public XmlUtility() {
	}

	static {
		try {
			weatherUrl = new URL(CommonData.request_url);
		} catch (MalformedURLException e) {
			// some exception occurred
			e.printStackTrace();
		}
	}

	public List<Forecast> getForecasts() {
		String dataFilePath = getWeatherDataFilePath();
		List<Forecast> forecasts = generateWeatherDataFromXml(dataFilePath);
		return forecasts;
	}

	private String getWeatherDataFilePath() {
		try {

			HttpURLConnection weatherConn = null;
			BufferedReader in = null;

			weatherConn = (HttpURLConnection) weatherUrl.openConnection();
			weatherConn.setRequestMethod(CommonData.GET);
			weatherConn.setRequestProperty("Content-Type", CommonData.applicationReturnType);
			weatherConn.setRequestProperty("Accept-Charset", CommonData.charsetStandart);
			weatherConn.setRequestProperty("User-Agent", CommonData.userAgentProperty);
			weatherConn.connect();

			Charset charset = Charset.forName(CommonData.charsetStandart); // for special chars
			in = new BufferedReader(new InputStreamReader(weatherConn.getInputStream(), charset));

			File file = new File(DATA_FILE);

			FileOutputStream fos = new FileOutputStream(file);

			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				fos.write(inputLine.getBytes(CommonData.charsetStandart));
			}

			in.close();
			fos.flush();
			fos.close();
			weatherConn.disconnect();

			return file.getAbsolutePath();

		} catch (Exception e) {
		}
		return null;
	}

	private List<Forecast> generateWeatherDataFromXml(String dataFilePath) {
		try {
			File file = new File(dataFilePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = null;

			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			Element forecastElement = doc.getDocumentElement();
			NodeList nodeList = forecastElement.getElementsByTagName("forecast");

			List<Forecast> forecasts = new ArrayList<Forecast>();

			for (int i = 0; i < nodeList.getLength(); i++) {
				Forecast fc = new Forecast(nodeList.item(i).getAttributes().getNamedItem("date").getTextContent(), i);
				fc.setDayNightRounds(getPlacesForForecast(nodeList.item(i)));
				forecasts.add(fc);
			}
			return forecasts;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private ArrayList<DayNight> getPlacesForForecast(Node forecastNode) {
		System.out.println("\n");

		ArrayList<DayNight> dayNightNodes = new ArrayList<DayNight>();
		NodeList childredNodes = forecastNode.getChildNodes();

		for (int i = 0; i < childredNodes.getLength(); i++) {
			String dayNightNodeName = childredNodes.item(i).getNodeName();
			if (dayNightNodeName.equalsIgnoreCase("day") || dayNightNodeName.equalsIgnoreCase("night")) {
				DayNight dn = convertW3CNodeTo(childredNodes.item(i), dayNightNodeName);
				dayNightNodes.add(dn);
			}
		}

		return dayNightNodes;
	}

	public static DayNight convertW3CNodeTo(Node dayNightNode, String dayNightRound) {

		if (dayNightNode == null)
			return null;

		DayNight dayNightRoundEntity = new DayNight();
		dayNightRoundEntity.setDaynight(dayNightRound.equalsIgnoreCase("day") ? 1 : 0);

		NodeList dayNightRoundChildNodes = dayNightNode.getChildNodes();
		List<City> places = new ArrayList<City>();

		for (int i = 0; i < dayNightRoundChildNodes.getLength(); i++) {
			Node singlenode = dayNightRoundChildNodes.item(i);
			switch (singlenode.getNodeName()) {
			case "phenomenon":
				dayNightRoundEntity.setPhenomenon(singlenode.getTextContent());
				break;
			case "tempmin":
				int tempmin = Integer.parseInt(singlenode.getTextContent());
				dayNightRoundEntity.setTempmin(tempmin);
				break;
			case "tempmax":
				int tempmax = Integer.parseInt(singlenode.getTextContent());
				dayNightRoundEntity.setTempmax(tempmax);
				break;
			case "text":
				dayNightRoundEntity.setDescription(singlenode.getTextContent());
				break;
			case "sea":
				dayNightRoundEntity.setSea(singlenode.getTextContent());
				System.out.println(singlenode.getTextContent().toString());
				break;
			case "peipsi":
				dayNightRoundEntity.setPepsi(singlenode.getTextContent());
				break;
			case "place":
				places.add(extractCityInformation(singlenode));
				break;
			default:
				break;
			}
		}
		if (places.size() > 0)
			dayNightRoundEntity.setCities(places);
		return dayNightRoundEntity;

	}

	private static City extractCityInformation(Node singleNode) {
		City city = new City();
		NodeList placeAttributes = singleNode.getChildNodes();

		for (int i = 0; i < placeAttributes.getLength(); i++) {
			switch (placeAttributes.item(i).getNodeName()) {
			case "name":
				city.setName(placeAttributes.item(i).getTextContent());
				break;
			case "phenomenon":
				city.setPhenomenon(placeAttributes.item(i).getTextContent());
				break;
			case "tempmin":
				int tempmin = Integer.parseInt(placeAttributes.item(i).getTextContent());
				city.setTempmin(tempmin);
				break;

			default:
				break;
			}
		}
		return city;
	}
}
