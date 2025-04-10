package com.nursalim.spring.boot.basic;

import com.nursalim.spring.boot.basic.data.Foo;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DependsOnTest {
    @Test
    void testDependsOn() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DependsOnConfiguration.class);
        var bean = context.getBean(Foo.class);
    }
}
