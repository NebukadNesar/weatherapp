package com.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weather.data.Forecast;

@Repository
public interface WeatherRepository extends JpaRepository<Forecast, Long> {
	public Forecast findForecastByDate(String date);
}
