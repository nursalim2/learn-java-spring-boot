package com.nursalim.spring.boot.validation.helper;

import jakarta.validation.constraints.NotBlank;

public interface ISayHello {
    String sayHello(@NotBlank  String name);
}
