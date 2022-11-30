package com.travel.availabilityapiss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class AvailabilityApIsApplication  extends SpringBootServletInitializer {
//public class AvailabilityApIsApplication   {

	public static void main(String[] args) {
		SpringApplication.run(AvailabilityApIsApplication.class, args);
		System.out.println("availabilityAPIs service running !");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AvailabilityApIsApplication.class);
	}

}
