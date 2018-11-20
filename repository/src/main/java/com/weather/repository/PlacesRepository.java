package com.weather.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.weather.data.Place;

@Repository
public interface PlacesRepository extends JpaRepository<Place, String> {

	@Query("Select distinct name from Place")
	public List<String> findAllCityNames();
}
