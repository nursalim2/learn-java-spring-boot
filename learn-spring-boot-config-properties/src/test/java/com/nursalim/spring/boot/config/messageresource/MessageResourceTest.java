package com.nursalim.spring.boot.config.messageresource;

import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

@SpringBootTest(classes = MessageResourceTest.TestApplication.class)
public class MessageResourceTest {

    @Autowired
    TestApplication.SampleSource sampleSource;

    @Test
    void testMessageSource() {
        Assertions.assertEquals("Hello Nursalim", sampleSource.helloNursalim(Locale.getDefault()));
        Assertions.assertEquals("Halo Nursalim", sampleSource.helloNursalim(Locale.of("id_ID")));
    }

    @SpringBootApplication
    public static class TestApplication {

        @Component
        public static class SampleSource implements MessageSourceAware {

            @Setter
            private MessageSource messageSource;

            public String helloNursalim(Locale locale) {
                return messageSource.getMessage("hello", new Object[]{"Nursalim"}, locale);
            }
        }
    }
}
