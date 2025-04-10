package com.nursalim.spring.boot.basic;

import com.nursalim.spring.boot.basic.data.Bar;
import com.nursalim.spring.boot.basic.data.Foo;
import com.nursalim.spring.boot.basic.data.FooBar;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class DependencyInjectionConfiguration {

    @Primary
    @Bean
    public Foo fooFirst() {
        return new Foo();
    }

    @Bean
    public Foo fooSecond() {
        return new Foo();
    }

    @Bean
    public Bar bar() {
        return new Bar();
    }

    @Bean
    public FooBar fooBar(@Qualifier("fooSecond") Foo foo, Bar bar) {
        return new FooBar(foo, bar);
    }

}
