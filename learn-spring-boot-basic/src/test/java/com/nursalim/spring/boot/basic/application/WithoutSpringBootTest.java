package com.nursalim.spring.boot.basic.application;

import com.nursalim.spring.boot.basic.HelloWorldConfiguration;
import com.nursalim.spring.boot.basic.data.Foo;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class WithoutSpringBootTest {
    @Test
    void test() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(FooApplication.class);
        context.registerShutdownHook();

        var bean = context.getBean(Foo.class);


    }
}
