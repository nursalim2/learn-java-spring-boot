package com.nursalim.spring.web.mvc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIntegrationTest {
    @LocalServerPort
    private int port;

    private final String LOCALHOST_URL = "http://localhost:";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void helloGuest() {
        String response = restTemplate.getForEntity(LOCALHOST_URL + port + "/hello", String.class).getBody();

        Assertions.assertNotNull(response);
        Assertions.assertEquals("Hello Guest", response.trim());
    }

    @Test
    void helloNursalim() {
        String response = restTemplate.getForEntity(LOCALHOST_URL + port + "/hello?name=Nursalim", String.class).getBody();

        Assertions.assertNotNull(response);
        Assertions.assertEquals("Hello Nursalim", response.trim());
    }
}
