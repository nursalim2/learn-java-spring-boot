package com.nursalim.spring.boot.config;

import com.nursalim.spring.boot.config.converter.StringToDateConverter;
import com.nursalim.spring.boot.config.properties.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;

@SpringBootApplication
@EnableConfigurationProperties({
		ApplicationProperties.class
})
public class LearnSpringBootConfigPropertiesApplication {

	@Bean
	public ConversionService conversionService(StringToDateConverter stringToDateConverter) {
		ApplicationConversionService conversionService = new ApplicationConversionService();
		conversionService.addConverter(stringToDateConverter);
		return conversionService;
	}

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootConfigPropertiesApplication.class, args);
	}

}
