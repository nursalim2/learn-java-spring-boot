package com.nursalim.spring.boot.validation.data;

import com.nursalim.spring.boot.validation.validation.Palindrome;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Foo {

    @Palindrome
    private String bar;
}
