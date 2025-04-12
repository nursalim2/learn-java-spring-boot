package com.nursalim.spring.boot.validation;

import com.nursalim.spring.boot.validation.helper.SayHalo;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MethodOverridingTest {
    @Autowired
    public SayHalo sayHalo;
    @Test
    void testFailed() {
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            sayHalo.sayHello(" ");
        });
    }
}
