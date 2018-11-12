package com.weather.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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
			placesRepository.deleteAll();
			dnRepository.deleteAll();
			rearrangerelations(forecasts); 

			weatherRepository.saveAll(forecasts);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void rearrangerelations(List<Forecast> forecasts) {
		forecasts.stream().forEach(forecast -> {
			if (forecast.getDayNightRounds() != null && forecast.getDayNightRounds().size() > 0) {
				forecast.getDayNightRounds().stream().forEach(daynight -> {
					daynight.setForecast(forecast);
					if (daynight.getCities() != null) {
						daynight.getCities().stream().forEach(city -> {
							city.setDayNight(daynight);
						});
					}
				});
			}
		});
	}

}
