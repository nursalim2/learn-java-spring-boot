package com.nursalim.spring.boot.basic.configuration;

import com.nursalim.spring.boot.basic.data.Bar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BarConfiguration {

    @Bean
    public Bar bar() {
        return new Bar();
    }
}
