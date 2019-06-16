package com.hlhdidi;

import com.hlhdidi.stream.ISender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding({ISender.class})
public class StreamApp {

	public static void main(String[] args) {
		SpringApplication.run(StreamApp.class);
	}
}
