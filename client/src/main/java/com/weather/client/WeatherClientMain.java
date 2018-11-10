package com.weather.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = { "com.weather.client", "com.weather.data" })
@ComponentScan(basePackages = { "com.weather.client", "com.weather.server", "com.weather.repository" })
@EntityScan(basePackages = { "com.weather.client", "com.weather.data" })
public class WeatherClientMain {

	public static void main(String[] args) {
		SpringApplication.run(WeatherClientMain.class, args);
	}
}
