package com.nursalim.spring.boot.config.resourceloader;

import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@SpringBootTest(classes = ResourceLoaderTest.TestApplication.class)
public class ResourceLoaderTest {

    @Autowired
    private TestApplication.SampleResouce sampleResouce;

    @Test
    void testResourceLoader() throws IOException {
        Assertions.assertEquals("nursalim", sampleResouce.getText().trim());
    }

    @SpringBootApplication
    public static class TestApplication {

        @Component
        public static class SampleResouce implements ResourceLoaderAware {

            @Setter
            private ResourceLoader resourceLoader;

            public String getText() throws IOException {
                Resource resource = resourceLoader.getResource("classpath:/text/resource.txt");
                InputStream inputStream = resource.getInputStream();

                return new String(inputStream.readAllBytes());
            }
        }
    }
}
