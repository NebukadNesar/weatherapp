package com.weather.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.weather.data.DayNight;
import com.weather.data.Forecast;
import com.weather.repository.DayNightRepository;
import com.weather.repository.PlacesRepository;
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

	@Autowired
	private DayNightRepository dnRepository;

	@Autowired
	private PlacesRepository placesRepository;

	@Override
	public void run(String... args) throws Exception {
		getWeatherData();
	}

	@Scheduled(cron = CommonData.REQUEST_PERIOD)
	private void getWeatherData() {
		List<Forecast> forecasts = xmlUtilityHelper.getForecasts();
		try {
			weatherRepository.deleteAll();
			weatherRepository.saveAll(forecasts);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
