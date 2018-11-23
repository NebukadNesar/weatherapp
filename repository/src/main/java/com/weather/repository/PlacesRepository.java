package com.weather.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.weather.data.Place;


/**
 place_id |    name    |        phenomenon        | tempmin | day_id | night_id 
----------+------------+--------------------------+---------+--------+----------
     1518 | Harku      | Cloudy with clear spells |       0 |   1517 |         
     1519 | Jõhvi      | Cloudy with clear spells |       0 |   1517 |         
     1520 | Tartu      | Cloudy with clear spells |       0 |   1517 |         
     1521 | Pärnu      | Cloudy with clear spells |       0 |   1517 |         
     1522 | Kuressaare | Cloudy with clear spells |       0 |   1517 |         
     1523 | Türi       | Cloudy with clear spells |       0 |   1517 |         
     1528 | Harku      | Cloudy                   |       2 |        |     1527
     1529 | Jõhvi      | Cloudy                   |      -1 |        |     1527
     1530 | Tartu      | Fog                      |      -2 |        |     1527
     1531 | Pärnu      | Cloudy                   |       0 |        |     1527
     1532 | Kuressaare | Cloudy                   |       2 |        |     1527
     1533 | Türi       | Cloudy                   |      -1 |        |     1527
     
     
                                                 ^
night_places table
 night_night_id | places_place_id 
----------------+-----------------
           1527 |            1528
           1527 |            1529
           1527 |            1530
           1527 |            1531
           1527 |            1532
           1527 |            1533
(6 rows)

 */
@Repository
public interface PlacesRepository extends JpaRepository<Place, String> {

	@Query("Select distinct name from Place")
	public List<String> findAllCityNames();

	
//	
//	@Query("select p from Place p  RIGHT JOIN Day d on d.day_id = p.day_id where p.name=:name and d.day_id=:dayId")
//	public Place getPlaceByDayID(@Param("dayId") String dayId, @Param("name") String cityName);

	
//	
//	@Query("select p from Place p where p.night_id=:nightId and p.name=:name")
//	public Place findPlaceByNightID(@Param("nightId") String nightId, @Param("name") String cityName);

}
