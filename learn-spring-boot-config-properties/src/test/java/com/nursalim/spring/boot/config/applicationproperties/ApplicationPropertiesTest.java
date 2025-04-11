package com.nursalim.spring.boot.config.applicationproperties;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest(classes = ApplicationPropertiesTest.TestApplication.class)
public class ApplicationPropertiesTest {

    @Autowired
    Environment environment;

    @Test
    void testApplicationProperties() {
        String message = environment.getProperty("spring.application.name");
        Assertions.assertEquals("learn-spring-boot-config-properties", message);
    }

    @SpringBootApplication
    public static class TestApplication {

    }
}
