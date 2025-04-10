package com.nursalim.spring.boot.basic;

import com.nursalim.spring.boot.basic.data.Bar;
import com.nursalim.spring.boot.basic.data.Foo;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ImportTest {
    @Test
    void testImport() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
        context.registerShutdownHook();
        var foo = context.getBean(Foo.class);
        var bar = context.getBean(Bar.class);

    }
}
