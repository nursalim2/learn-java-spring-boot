package com.nursalim.spring.web.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@SpringBootApplication
public class LearnSpringBootWebMvcApplication {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder
				.connectTimeout(Duration.ofSeconds(2))
				.readTimeout(Duration.ofSeconds(2))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootWebMvcApplication.class, args);
	}

}
