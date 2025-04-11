package com.nursalim.spring.boot.basic;


import com.nursalim.spring.boot.basic.data.Car;
import com.nursalim.spring.boot.basic.processor.IdGeneratorBeanPostProcessor;
import com.nursalim.spring.boot.basic.processor.PrefixIdGeneratorBeanPostProcessor;
import com.nursalim.spring.boot.basic.service.AuthService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class AwareTest {
    @Configuration
    @Import({AuthService.class})
    public static class TestConfiguration {
    }

    @Test
    void testAware() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AwareTest.TestConfiguration.class);
        context.registerShutdownHook();

        AuthService bean = context.getBean(AuthService.class);
        System.out.println(bean.getBeanName());
        System.out.println(bean.getApplicationContext());

        Assertions.assertSame(context, bean.getApplicationContext());

    }
}
