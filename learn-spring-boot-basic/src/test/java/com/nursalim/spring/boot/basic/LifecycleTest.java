package com.nursalim.spring.boot.basic;

import com.nursalim.spring.boot.basic.data.Connection;
import com.nursalim.spring.boot.basic.data.Server;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifecycleTest {
    @Test
    void test() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(LifecycleConfiguration.class);
        context.registerShutdownHook();
        context.getBean(Connection.class);
//        context.close();
    }

    @Test
    void testAnnotation() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(LifecycleConfiguration.class);
        context.registerShutdownHook();
        context.getBean(Server.class);
    }
}
