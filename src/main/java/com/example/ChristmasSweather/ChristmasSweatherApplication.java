package com.example.ChristmasSweather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"java.lang.String"})
public class ChristmasSweatherApplication {

	public static void main(String[] args) {

		SpringApplication.run(ChristmasSweatherApplication.class, args);
	}
}
