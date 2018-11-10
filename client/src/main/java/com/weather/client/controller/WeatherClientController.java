package com.weather.client.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.data.City;
import com.weather.data.DayNight;
import com.weather.data.Forecast;
import com.weather.repository.DayNightRepository;
import com.weather.repository.PlacesRepository;
import com.weather.repository.WeatherRepository;

@RestController
public class WeatherClientController {

	@Autowired
	private WeatherRepository weatherRepository;

	@Autowired
	private DayNightRepository dnRepository;

	@Autowired
	private PlacesRepository placesRepository;

	@Transactional
	@RequestMapping("/forecasts")
	public List<Forecast> getWeatherData() {
		List<Forecast> list = weatherRepository.findAll();
		System.out.println(list.get(0).toString());
		return list;
	}

	@Transactional
	@RequestMapping("/forecastByDate")
	public List<Forecast> getForecastByDate() {
		Forecast res = weatherRepository.findForecastByDate("2018-11-11");
		List<Forecast> list = new ArrayList<>();
		list.add(res);
		System.out.println(list.size());
		return list;
	}

	@RequestMapping("/daynight")
	public List<DayNight> getDayNight(String byForecastDate) {
		List<DayNight> list = dnRepository.findAll();
		return list;
	}

	@RequestMapping("/places")
	public List<City> getPlaces() {
		return placesRepository.findAll();
	}

	@RequestMapping("/place")
	public City getPlaces(String byCityName) {
		City city = new City();
		city.setName(byCityName);
		City list = placesRepository.findCityByName(city);
		return list;
	}
}
