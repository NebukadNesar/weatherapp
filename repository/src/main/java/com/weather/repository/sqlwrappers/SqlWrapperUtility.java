package com.weather.repository.sqlwrappers;

import org.springframework.beans.factory.annotation.Autowired;

import com.weather.repository.DayNightRepository;
import com.weather.repository.PlacesRepository;
import com.weather.repository.WeatherRepository;

public class SqlWrapperUtility {

	@Autowired
	private WeatherRepository weatherRepository;

	@Autowired
	private DayNightRepository dnRepository;

	@Autowired
	private PlacesRepository placesRepository;

	public SqlWrapperUtility(WeatherRepository weatherRepository, DayNightRepository dnRepository,
			PlacesRepository placesRepository) {
		super();
		this.weatherRepository = weatherRepository;
		this.dnRepository = dnRepository;
		this.placesRepository = placesRepository;
	}

}
