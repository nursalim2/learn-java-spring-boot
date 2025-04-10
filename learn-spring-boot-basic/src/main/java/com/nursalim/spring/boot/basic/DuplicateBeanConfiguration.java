package com.nursalim.spring.boot.basic;

import com.nursalim.spring.boot.basic.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class DuplicateBeanConfiguration {

    @Bean
    public Foo foo1() {
        Foo foo = new Foo();
        log.info("Create new Foo 1");
        return foo;
    }

    @Bean
    public Foo foo2() {
        Foo foo = new Foo();
        log.info("Create new Foo 2");
        return foo;
    }
}
