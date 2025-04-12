package com.nursalim.spring.boot.validation.helper;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Validated
@Component
public class SayHalo implements ISayHello{
    @Override
    public String sayHello(String name) {
        return "Halo " + name;
    }
}
