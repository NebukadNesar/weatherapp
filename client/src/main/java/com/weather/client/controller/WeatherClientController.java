package com.weather.client.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weather.data.Forecast;
import com.weather.data.Place;
import com.weather.publicdata.PublicDay;
import com.weather.publicdata.PublicForecast;
import com.weather.publicdata.PublicNight;
import com.weather.publicdata.PublicPlace;
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
	public PublicForecast getWeatherDataForACity(@RequestParam String date, @RequestParam String cityName)
			throws JAXBException {
		Forecast result = weatherRepository.findForecastByDate(date);
		PublicForecast forecast = convert(result);
		System.out.println("Reesult: "+ forecast);
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
		System.out.println(decodedCityName);

//		PublicPlace cityday = new PublicPlace();
//		PublicPlace citynight = new PublicPlace();
//
//		PublicDay pDay = forecast.getPday();
//		PublicNight pNight = forecast.getPnight();

		//todo
		return forecast;

	}

	private PublicForecast convert(Forecast fc) {
		PublicConverter pconverter = new PublicConverter();
		return pconverter.convertFrom(fc);
	}

}
