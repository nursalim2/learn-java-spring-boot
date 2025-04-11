package com.nursalim.spring.boot.config.messagesource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

public class MessageSourceTest {

    @Test
    void testMessageSource() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration.class);
        MessageSource messageSource = context.getBean(MessageSource.class);

        String hello = messageSource.getMessage("hello", new Object[]{"Nursalim"}, Locale.getDefault());

        Assertions.assertEquals("Hello Nursalim", hello);
    }

    @Configuration
    public static class TestConfiguration {

        @Bean
        public MessageSource messageSource() {
            ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
            messageSource.setBasename("my");
            return messageSource;
        }
    }
}
