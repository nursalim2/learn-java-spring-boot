package com.nursalim.spring.boot.basic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.nursalim.spring.boot.basic.service",
        "com.nursalim.spring.boot.basic.repository"
})
public class ComponentConfiguration {
}
