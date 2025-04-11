package com.nursalim.spring.boot.basic;

import com.nursalim.spring.boot.basic.data.Car;
import com.nursalim.spring.boot.basic.processor.IdGeneratorBeanPostProcessor;
import com.nursalim.spring.boot.basic.processor.PrefixIdGeneratorBeanPostProcessor;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class OrderedTest {

    @Configuration
    @Import({Car.class, IdGeneratorBeanPostProcessor.class, PrefixIdGeneratorBeanPostProcessor.class})
    public static class TestConfiguration {
    }

    @Test
    void testBeanPostProcessor() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration.class);
        context.registerShutdownHook();

        Car bean = context.getBean(Car.class);
        System.out.println(bean.getId());

    }

}
