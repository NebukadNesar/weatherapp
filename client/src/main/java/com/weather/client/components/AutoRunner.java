package com.weather.client.components;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AutoRunner implements CommandLineRunner{
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Test Runner Example..");
	}
}
