package com.weather.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.weather.data.City;

@Repository
public interface PlacesRepository extends JpaRepository<City, String> {

	@Query("select distinct name from City")
	public List<String> findAllCityNames();
	
//	@Query("select fc.date, place.name, place.tempmin, dn.tempmin, dn.sea, dn.peipsi, dn.description ")
	public List<Object> findCityByName(String city);

}
