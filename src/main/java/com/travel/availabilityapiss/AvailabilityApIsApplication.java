package com.travel.availabilityapiss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class AvailabilityApIsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvailabilityApIsApplication.class, args);
		//System.out.println("availabilityAPIs service running !");
	}

}
