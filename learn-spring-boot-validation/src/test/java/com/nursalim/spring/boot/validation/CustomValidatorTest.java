package com.nursalim.spring.boot.validation;

import com.nursalim.spring.boot.validation.data.Foo;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
public class CustomValidatorTest {
    @Autowired
    private Validator validator;

    @Test
    void testValidatorFail() {
        Foo foo = new Foo("nur");
        Set<ConstraintViolation<Foo>> constraintViolations = validator.validate(foo);

        Assertions.assertFalse(constraintViolations.isEmpty());
    }

    @Test
    void testValidatorSuccess() {
        Foo foo = new Foo("ojo");
        Set<ConstraintViolation<Foo>> constraintViolations = validator.validate(foo);

        Assertions.assertTrue(constraintViolations.isEmpty());
    }

    @Test
    void testInvalidMessage() {
        Foo foo = new Foo("nur");
        Set<ConstraintViolation<Foo>> constraintViolations = validator.validate(foo);

        for (ConstraintViolation<Foo> violation : constraintViolations) {
            Assertions.assertEquals("Data bukan palindrome", violation.getMessage());
        }
    }
}
