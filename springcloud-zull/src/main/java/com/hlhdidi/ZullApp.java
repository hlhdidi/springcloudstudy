package com.hlhdidi;

import com.hlhdidi.conf.ErrorFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class ZullApp {

	public static void main(String[] args) {
		SpringApplication.run(ZullApp.class);
	}
}
