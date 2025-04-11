package com.nursalim.spring.boot.basic;

import com.nursalim.spring.boot.basic.data.Foo;
import com.nursalim.spring.boot.basic.data.FooBar;
import com.nursalim.spring.boot.basic.repository.CustomerRepository;
import com.nursalim.spring.boot.basic.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OptionalTest {
    @Test
    void testOptional() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(OptionalConfiguration.class);
        context.registerShutdownHook();

        Foo foo = context.getBean(Foo.class);
        FooBar fooBar = context.getBean(FooBar.class);

        Assertions.assertNull(fooBar.getBar());
        Assertions.assertNotNull(fooBar.getFoo());
        Assertions.assertSame(foo, fooBar.getFoo());
    }
}
