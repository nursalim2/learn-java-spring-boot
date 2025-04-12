package com.nursalim.spring.boot.validation;

import com.nursalim.spring.boot.validation.properties.DatabaseProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(DatabaseProperties.class)
public class LearnSpringBootValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootValidationApplication.class, args);
	}

}
