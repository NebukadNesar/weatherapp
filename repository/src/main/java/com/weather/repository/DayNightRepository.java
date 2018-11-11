package com.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weather.data.DayNight;

@Repository
public interface DayNightRepository extends JpaRepository<DayNight, String>{
}
