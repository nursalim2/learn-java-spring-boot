package com.nursalim.spring.boot.basic.scope;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.nursalim.spring.boot.basic.configuration"
})
public class ScanConfiguration {
}
