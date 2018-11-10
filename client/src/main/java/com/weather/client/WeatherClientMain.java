package com.weather.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = { "com.weather.data" })
@ComponentScan(basePackages = { "com.weather.server", "com.weather.client" })
@EntityScan(basePackages = { "com.weather.data" })
public class WeatherClientMain {

	public static void main(String[] args) {
		SpringApplication.run(WeatherClientMain.class, args);
	}
}
