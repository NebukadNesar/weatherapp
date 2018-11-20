package com.weather.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.weather.data.Forecast;
import com.weather.data.Forecasts;

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
			weatherUrl = new URL(CommonData.REQUEST_URI);
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
			weatherConn.setRequestProperty("Content-Type", CommonData.APPDATA_MIME_TYPE);
			weatherConn.setRequestProperty("Accept-Charset", CommonData.CHARSET_STANDART);
			weatherConn.setRequestProperty("User-Agent", CommonData.USER_AGENT_PROPERTY);
			weatherConn.connect();

			Charset charset = Charset.forName(CommonData.CHARSET_STANDART); // for special chars
			in = new BufferedReader(new InputStreamReader(weatherConn.getInputStream(), charset));

			File file = new File(DATA_FILE);

			FileOutputStream fos = new FileOutputStream(file);

			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				fos.write(inputLine.getBytes(CommonData.CHARSET_STANDART));
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
		File file = new File(dataFilePath);
		JAXBContext jaxbContext;
		Forecasts forecasts = null;
		try {
			jaxbContext = JAXBContext.newInstance(Forecasts.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			forecasts = (Forecasts) jaxbUnmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		System.out.println(forecasts.getForecasts());
		return forecasts.getForecasts();

	}

}
