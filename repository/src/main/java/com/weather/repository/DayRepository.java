package com.weather.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.weather.data.Day;

/**
 weather=# select * from day;
 day_id | peipsi |        phenomenon        |  sea  | tempmax | tempmin | text  | forecast_id 
--------+--------+--------------------------+-------+---------+---------+-------+-------------
   1427 | 27310  | Cloudy with clear spells | 27311 |       4 |      -1 | 27312 |        1426
   1448 |        | Cloudy with clear spells |       |       5 |       1 | 27316 |        1447
   1451 |        | Light rain               |       |       5 |       1 | 27318 |        1450
   1454 |        | Light shower             |       |       4 |       1 | 27320 |        1453

 */
@Repository
public interface DayRepository extends JpaRepository<Day, String> {

	@Query("select peipsi, phenomenon, sea, tempmax, tempmin, text from Day where forecast_id =: forecastid")
	public List<Object[]> getDayAttributesByForecastId(@Param("forecastid") String forecastid);
}
