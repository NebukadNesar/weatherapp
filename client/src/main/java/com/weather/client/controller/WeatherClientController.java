package com.weather.client.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weather.data.Forecast;
import com.weather.publicdata.PublicForecast;
import com.weather.repository.DayRepository;
import com.weather.repository.NightRepository;
import com.weather.repository.PlacesRepository;
import com.weather.repository.WeatherRepository;
import com.weather.utility.controller.PublicConverter;

@CrossOrigin(maxAge = 3600)
@RestController
public class WeatherClientController {

	@Autowired
	private WeatherRepository weatherRepository;

	@Autowired
	private DayRepository dayRepository;

	@Autowired
	private NightRepository nightRepository;

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
		/**
		 * Weather repository is a general purpose repository, and we should filter the
		 * sub entities until here. @DONE in converter utility
		 */
		Forecast forecast = weatherRepository.findForecastByDate(date);

		String decodedCityName = "";
		try {
			decodedCityName = URLDecoder.decode(cityName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("Exception occured..." + e.getMessage());
		}

		PublicForecast pforecast = convert(forecast, decodedCityName);
		System.out.println("cityName: " + cityName);
		System.out.println("forecast:" + forecast);

		return pforecast;

	}

	private PublicForecast convert(Forecast fc, String cityName) {
		PublicConverter pconverter = new PublicConverter();
		return pconverter.filterAndConvertFrom(fc, cityName);
	}

	private PublicForecast convert(Forecast fc) {
		PublicConverter pconverter = new PublicConverter();
		return pconverter.convertFrom(fc);
	}

}
