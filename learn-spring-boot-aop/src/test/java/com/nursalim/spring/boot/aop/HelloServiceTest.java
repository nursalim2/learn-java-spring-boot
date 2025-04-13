package com.nursalim.spring.boot.aop;

import com.nursalim.spring.boot.aop.service.HelloService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloServiceTest {
    @Autowired
    private HelloService helloService;

    @Test
    void test() {
        Assertions.assertEquals("Hello Nursalim", helloService.hello("Nursalim"));
        Assertions.assertEquals("Bye Nursalim", helloService.bye("Nursalim"));
        Assertions.assertEquals("Hello Nursalim Milasrun", helloService.hello("Nursalim", "Milasrun"));

        helloService.test();
    }

}
