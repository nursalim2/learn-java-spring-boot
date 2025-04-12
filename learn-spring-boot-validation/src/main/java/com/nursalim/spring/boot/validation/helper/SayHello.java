package com.nursalim.spring.boot.validation.helper;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Validated
@Component
public class SayHello {

    public String sayHello(@NotBlank String name) {
        return "Hello " + name;
    }
}
