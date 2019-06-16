package com.hlhdidi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RibbonApp {

	public static void main(String[] args) {
		SpringApplication.run(RibbonApp.class);
	}
}
