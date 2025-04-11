package com.nursalim.spring.boot.basic.application;

import com.nursalim.spring.boot.basic.data.Bar;
import com.nursalim.spring.boot.basic.data.Foo;
import com.nursalim.spring.boot.basic.listener.AppStartingListener;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class FooApplication {
    @Bean
    public Bar bar() {
        return new Bar();
    }

    @Bean
    public Foo foo(Bar bar) {
        return new Foo();
    }

//    public static void main(String[] args) {
//        ConfigurableApplicationContext applicationContext = SpringApplication.run(FooApplication.class, args);
//        var foo = applicationContext.getBean("foo");
//        System.out.println(foo);
//    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(FooApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.setListeners(List.of(new AppStartingListener()));

        var run = application.run(args);
        run.getBean(Foo.class);

    }

}
