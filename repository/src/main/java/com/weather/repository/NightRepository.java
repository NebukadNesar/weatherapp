package com.weather.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.weather.data.Night;


/**
 weather=# select * from night;
 night_id | peipsi |        phenomenon        |  sea  | tempmax | tempmin | text  | forecast_id 
----------+--------+--------------------------+-------+---------+---------+-------+-------------
     1527 | 27421  | Cloudy                   | 27422 |       3 |      -2 | 27423 |        1516
     1539 |        | Cloudy with clear spells |       |       3 |      -4 | 27425 |        1537
     1542 |        | Cloudy with clear spells |       |       3 |      -2 | 27427 |        1540
     1545 |        | Light sleet              |       |       4 |      -1 | 27429 |        1543

 */
@Repository
public interface NightRepository extends JpaRepository<Night, String> {
	
	@Query("select peipsi, phenomenon, sea, tempmax, tempmin, text from Night where forecast_id =: forecastid")
	public List<Object[]> getNightAttributesByForecastId(@Param("forecastid") String forecastid);
	
}