package com.weather.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.data.Forecast;
import com.weather.data.WeatherRepository;

@RestController
public class WeatherClientController {

	@Autowired
	private WeatherRepository weatherRepository;
	
	@RequestMapping(value="/")
	public String getIndex() {
		 return "index.html";
	}
	
	@RequestMapping("/forecasts")
	public List<Forecast> getWeatherData() {
		List<Forecast> list = weatherRepository.findAll();
		return list;
	}
}
