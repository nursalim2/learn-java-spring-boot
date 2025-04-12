package com.nursalim.spring.boot.logging;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@Slf4j
@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
public class LoggingTest {

    @Test
    void testNothing() {
        log.info("Hello World");
        log.warn("Hello Spring");
        log.error("Hello Nursalim");
    }

    @Test
    void testLogging() {
        for (int i = 0; i < 100_000; i++) {
            log.warn("Learn Spring Boot logging - {}", i);
        }
    }
}
