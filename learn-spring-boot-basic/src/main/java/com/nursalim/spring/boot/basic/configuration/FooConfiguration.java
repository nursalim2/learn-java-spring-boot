package com.nursalim.spring.boot.basic.configuration;

import com.nursalim.spring.boot.basic.data.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FooConfiguration {

    @Bean
    public Foo foo() {
        return new Foo();
    }
}
