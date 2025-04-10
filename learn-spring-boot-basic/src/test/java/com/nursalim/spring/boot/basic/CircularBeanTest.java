package com.nursalim.spring.boot.basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CircularBeanTest {
    @Test
    void testCircular() {
        ApplicationContext context = new AnnotationConfigApplicationContext(CyclicConfiguration.class);

        Assertions.assertThrows(UnsatisfiedDependencyException.class,() -> {});
    }
}
