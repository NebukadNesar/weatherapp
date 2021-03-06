package com.weather.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.weather.data.Forecast;
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
			rearrangerelations(forecasts);
			weatherRepository.saveAll(forecasts);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * arrange the relations before saving database
	 * 
	 * @param forecasts
	 */
	private void rearrangerelations(List<Forecast> forecasts) {
		forecasts.stream().forEach(forecast -> {
			if (forecast.getDay() != null) {
				if (forecast.getDay().getPlaces() != null) {
					forecast.getDay().getPlaces().stream().forEach(place -> {
						place.setDay(forecast.getDay());
					});
				}
				if (forecast.getDay().getWinds() != null) {
					forecast.getDay().getWinds().stream().forEach(wind -> {
						wind.setDay(forecast.getDay());
					});
				}

				forecast.getDay().setForecast(forecast);
			}
			if (forecast.getNight() != null) {
				if (forecast.getNight().getPlaces() != null) {
					forecast.getNight().getPlaces().stream().forEach(place -> {
						place.setNight(forecast.getNight());
					});
				}
				if (forecast.getNight().getWinds() != null) {
					forecast.getNight().getWinds().stream().forEach(wind -> {
						wind.setNight(forecast.getNight());
					});
				}
				forecast.getNight().setForecast(forecast);
			}
		});
	}

}
