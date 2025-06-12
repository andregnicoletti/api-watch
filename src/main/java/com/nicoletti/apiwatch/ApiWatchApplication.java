package com.nicoletti.apiwatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ApiWatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiWatchApplication.class, args);
	}

}
