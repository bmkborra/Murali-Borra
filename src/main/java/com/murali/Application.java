package com.murali;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.murali.service"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	public GroupedOpenApi api() {
	    return GroupedOpenApi.builder()
	            .group("api")
	            .packagesToScan("com.murali.rest")
	            .pathsToMatch("/api/**") // Adjust the base path here
	            .build();
	}

}
