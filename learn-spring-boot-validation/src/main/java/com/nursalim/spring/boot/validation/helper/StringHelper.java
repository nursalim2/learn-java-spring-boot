package com.nursalim.spring.boot.validation.helper;

import org.springframework.stereotype.Component;

@Component
public class StringHelper {

    public boolean isPalindrome(String value) {
        String reverse = new StringBuilder(value).reverse().toString();
        return reverse.equals(value);
    }
}
