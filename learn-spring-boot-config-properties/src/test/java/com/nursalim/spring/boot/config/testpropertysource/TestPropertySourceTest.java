package com.nursalim.spring.boot.config.testpropertysource;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;

@SpringBootTest(classes = TestPropertySourceTest.TestApplication.class)
@TestPropertySources({
        @TestPropertySource("classpath:/test.properties")
})
public class TestPropertySourceTest {

    @Autowired
    TestApplication.TestSampleProperties sampleProperty;

    @Test
    void testPropertySource() {
        Assertions.assertEquals("Sample Project", sampleProperty.getName());
        Assertions.assertEquals(1, sampleProperty.getVersion());
    }

    @SpringBootApplication
    public static class TestApplication {

        @Getter
        @Component
        public static class TestSampleProperties {
            @Value("${sample.name}")
            private String name;

            @Value("${sample.version}")
            private Integer version;
        }
    }
}
