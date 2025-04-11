package com.nursalim.spring.boot.basic;

import com.nursalim.spring.boot.basic.data.Foo;
import com.nursalim.spring.boot.basic.listener.LoginAgainSuccessListener;
import com.nursalim.spring.boot.basic.listener.LoginSuccessListener;
import com.nursalim.spring.boot.basic.listener.UserListener;
import com.nursalim.spring.boot.basic.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class EventListenerTest {
    @Configuration
    @Import({
            LoginSuccessListener.class,
            LoginAgainSuccessListener.class,
            UserListener.class,
            UserService.class})
    public static class TestConfiguration {

    }

    @Test
    void testEventListener() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(EventListenerTest.TestConfiguration.class);
        context.registerShutdownHook();

        UserService service = context.getBean(UserService.class);
        service.login("nursalim", "rahasia");
        service.login("milasrun", "rahasia");
        service.login("nursalim", "nursalim");
    }
}
