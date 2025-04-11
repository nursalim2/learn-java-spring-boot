package com.nursalim.spring.boot.basic.application;

import com.nursalim.spring.boot.basic.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = FooApplication.class)
public class FooApplicationTest {
    @Autowired
    Foo foo;

    @Test
    void testFoo() {
        Assertions.assertNotNull(foo);
    }
}
