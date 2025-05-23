package com.nursalim.spring.boot.validation.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PalindromeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Palindrome {
    String message() default "{Palindrome.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
