package com.weather.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.weather.data.Forecast;
import com.weather.repository.WeatherRepository;
import com.weather.utility.XmlUtility;

@Component
public class WeatherDataScanner implements CommandLineRunner {

	XmlUtility xmlUtilityHelper = new XmlUtility();

	@Autowired
	private WeatherRepository weatherRepository;

	@Override
	public void run(String... args) throws Exception {
		getWeatherData();
	}

	private void getWeatherData() {
		System.out.println("Test Runner Here...");
		List<Forecast> forecasts = xmlUtilityHelper.getForecasts();
		try {
			weatherRepository.saveAll(forecasts);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
