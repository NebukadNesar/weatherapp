package com.weather.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.weather.data.Forecast;

@Repository
public interface WeatherRepository extends JpaRepository<Forecast, String> {

	@Query("select date from Forecast")
	public List<String> findAllDates();

	public Forecast findForecastByDate(String date);
	
}
