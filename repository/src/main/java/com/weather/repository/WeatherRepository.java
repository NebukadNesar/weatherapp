package com.weather.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.weather.data.Forecast;

/**
 weather=# select * from forecast;
 forecast_id |    date    | day_day_id | night_night_id 
-------------+------------+------------+----------------
        1516 | 2018-11-21 |       1517 |           1527
        1537 | 2018-11-22 |       1538 |           1539
        1540 | 2018-11-23 |       1541 |           1542
        1543 | 2018-11-24 |       1544 |           1545

 */
@Repository
public interface WeatherRepository extends JpaRepository<Forecast, String> {

	@Query("select date from Forecast")
	public List<String> findAllDates();

	public Forecast findForecastByDate(String date);

	@Query("select forecast_id from Forecast where date=:date")
	public List<Object[]> findForecastDetailsByDate(@Param("date") String date);

}
