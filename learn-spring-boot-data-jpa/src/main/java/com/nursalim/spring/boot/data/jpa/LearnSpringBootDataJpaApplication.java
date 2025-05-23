package com.nursalim.spring.boot.data.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LearnSpringBootDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootDataJpaApplication.class, args);
	}

}
