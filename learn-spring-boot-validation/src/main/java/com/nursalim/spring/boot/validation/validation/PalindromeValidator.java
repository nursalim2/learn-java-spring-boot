package com.nursalim.spring.boot.validation.validation;

import com.nursalim.spring.boot.validation.helper.StringHelper;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class PalindromeValidator implements ConstraintValidator<Palindrome, String> {

    @Autowired
    private StringHelper helper;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return helper.isPalindrome(value);
    }
}
