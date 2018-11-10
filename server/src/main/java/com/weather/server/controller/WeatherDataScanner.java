package com.weather.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.weather.data.Forecast;
import com.weather.repository.WeatherRepository;
import com.weather.utility.CommonData;
import com.weather.utility.XmlUtility;

@Component
@EnableScheduling
public class WeatherDataScanner implements CommandLineRunner {

	private WeatherDataScanner() {
	}

	XmlUtility xmlUtilityHelper = new XmlUtility();

	@Autowired
	private WeatherRepository weatherRepository;

	@Override
	public void run(String... args) throws Exception {
		getWeatherData();
	}

	@Scheduled(cron = CommonData.request_period)
	private void getWeatherData() {
		System.out.println("Test Runner Scanner...");
		List<Forecast> forecasts = xmlUtilityHelper.getForecasts();
		try {
			weatherRepository.deleteAll();
			weatherRepository.saveAll(forecasts);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
