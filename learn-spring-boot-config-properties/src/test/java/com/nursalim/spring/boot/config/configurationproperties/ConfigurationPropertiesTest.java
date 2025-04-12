package com.nursalim.spring.boot.config.configurationproperties;

import com.nursalim.spring.boot.config.converter.StringToDateConverter;
import com.nursalim.spring.boot.config.properties.ApplicationProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.ConversionService;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = ConfigurationPropertiesTest.TestApplication.class)
public class ConfigurationPropertiesTest {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private ConversionService conversionService;

    @Test
    void test() {
        Assertions.assertEquals("Learn Spring Boot Config", applicationProperties.getName());
        Assertions.assertEquals("nursalim", applicationProperties.getDatabase().getUsername());

        Assertions.assertEquals(List.of("products","customers", "categories"), applicationProperties.getDatabase().getWhitelistTables());
        Assertions.assertEquals(Map.of("products", 100, "customers", 100, "categories", 100), applicationProperties.getDatabase().getMaxTableSize());

        Assertions.assertEquals("default", applicationProperties.getDefaultRoles().get(0).getId());
        Assertions.assertEquals("Default Role", applicationProperties.getDefaultRoles().get(0).getName());

        Assertions.assertEquals("admin", applicationProperties.getRoles().get("admin").getId());
        Assertions.assertEquals("Admin Role", applicationProperties.getRoles().get("admin").getName());

        Assertions.assertEquals(Duration.ofSeconds(10), applicationProperties.getDefaultTimeout());

        Assertions.assertEquals("2027-12-31", new SimpleDateFormat("yyyy-MM-dd").format(applicationProperties.getExpiryDate()));

    }

    @Test
    void testConversionService() {
        Assertions.assertTrue(conversionService.canConvert(String.class, Duration.class));
        Assertions.assertEquals(Duration.ofSeconds(10), conversionService.convert("10s", Duration.class));
    }

    @SpringBootApplication
    @EnableConfigurationProperties({ApplicationProperties.class})
    @Import(StringToDateConverter.class)
    public static class TestApplication {

        @Bean
        public ConversionService conversionService(StringToDateConverter stringToDateConverter) {
            ApplicationConversionService applicationConversionService = new ApplicationConversionService();
            applicationConversionService.addConverter(stringToDateConverter);
            return applicationConversionService;
        }
    }
}
