package com.nursalim.spring.boot.validation;

import com.nursalim.spring.boot.validation.data.Person;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
public class ValidatorTest {
    @Autowired
    private Validator validator;

    @Test
    void testValidator() {
        var person = new Person("", "");

        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);

        Assertions.assertFalse(constraintViolations.isEmpty());
        Assertions.assertEquals(2, constraintViolations.size());
    }
}
