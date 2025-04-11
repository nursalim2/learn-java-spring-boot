package com.nursalim.spring.boot.config.environment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest(classes = EnvironmentTest.TestApplication.class)
public class EnvironmentTest {

    @Autowired
    private Environment environment;

    @Test
    void testEnvironment() {
        var javaHome = environment.getProperty("JAVA_HOME");
        Assertions.assertNotNull(javaHome);

    }

    @SpringBootApplication
    public static class TestApplication {

    }
}
