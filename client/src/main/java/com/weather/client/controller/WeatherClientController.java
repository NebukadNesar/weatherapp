package com.weather.client.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weather.data.Forecast;
import com.weather.publicdata.PublicCity;
import com.weather.publicdata.PublicDayNight;
import com.weather.publicdata.PublicForecast;
import com.weather.repository.DayNightRepository;
import com.weather.repository.PlacesRepository;
import com.weather.repository.WeatherRepository;
import com.weather.utility.controller.PublicConverter;

@CrossOrigin(maxAge = 3600)
@RestController
public class WeatherClientController {

	@Autowired
	private WeatherRepository weatherRepository;

	@Autowired
	private PlacesRepository placesRespository;

	@Autowired
	private DayNightRepository dayNightRepository;

	@Transactional
	@RequestMapping("/getforecastdates")
	public List<String> getWeatherData() {
		List<String> list = weatherRepository.findAllDates();
		System.out.println(list);
		return list;
	}

	@Transactional
	@RequestMapping("/getavailablecitynames")
	public List<String> getAvailableCityNames() {
		List<String> list = placesRespository.findAllCityNames();
		System.out.println(list);
		return list;
	}

	@Transactional
	@GetMapping("/getcity")
	public PublicForecast getWeatherDataForACity(@RequestParam String date, @RequestParam String cityName) {
		Forecast result = weatherRepository.findForecastByDate(date);

		PublicForecast forecast = convert(result);
		if (forecast == null) {
			return null;
		}
		System.out.println("cityName: " + cityName);
		String decodedCityName = "";
		try {
			decodedCityName = URLDecoder.decode(cityName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("Exception occured..." + e.getMessage());
		}

		PublicCity cityday = new PublicCity();
		PublicCity citynight = new PublicCity();

		List<PublicDayNight> dn = forecast.getDayNightRounds();
		if (dn.size() > 0) {
			for (int i = 0; i < dn.size(); i++) {
				List<PublicCity> cities = dn.get(i).getCities();
				for (PublicCity c : cities) {
					if (c.getName().equalsIgnoreCase(decodedCityName)) {
						if (dn.get(i).getDaynight() == 1) {
							cityday = c;
							cities.clear();
							dn.get(i).setCities(new ArrayList<>());
							dn.get(i).getCities().add(cityday);
							break;
						} else {
							citynight = c;
							cities.clear();
							dn.get(i).setCities(new ArrayList<>());
							dn.get(i).getCities().add(citynight);
							cities.clear();
							break;
						}
					}
				}
			}
		}

		return forecast;

	}

	private PublicForecast convert(Forecast fc) {
		PublicConverter pconverter = new PublicConverter();
		return pconverter.forecastTo(fc);

	}

}
