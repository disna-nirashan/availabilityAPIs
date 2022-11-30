package com.travel.availabilityapiss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableCaching
@SpringBootApplication
@EnableSwagger2
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

	@Bean
	public Docket swaggerConfiguration(){
		return  new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/availability"))
				.apis(RequestHandlerSelectors.basePackage("com.travel"))
				.build()
				.apiInfo(apiDetails());
	}
	private ApiInfo apiDetails(){
		return new ApiInfo(
				"Rooms Availability API",
				"Sample API for Hotel Rooms Availability",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Disna","http://127.0.0.1:8080/swagger-ui.html#/rooms-controller","abc@gmail.com"),
				"API License",
				"http://127.0.0.1:8080/swagger-ui.html#/rooms-controller",
				Collections.emptyList()
		);
	}

}
