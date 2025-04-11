package com.nursalim.spring.boot.basic;

import com.nursalim.spring.boot.basic.data.MultiFoo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {
        "com.nursalim.spring.boot.basic.service",
        "com.nursalim.spring.boot.basic.repository",
        "com.nursalim.spring.boot.basic.configuration",
})
@Import(MultiFoo.class)
public class ComponentConfiguration {
}
