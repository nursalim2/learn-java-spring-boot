package com.nursalim.spring.boot.basic.listener;

import com.nursalim.spring.boot.basic.event.LoginSuccessEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserListener {
    @EventListener(classes = LoginSuccessEvent.class)
    public void onLoginSuccessEvent1(LoginSuccessEvent event) {
        log.info("success login 1 for user {}", event.getUser());
    }

    @EventListener(classes = LoginSuccessEvent.class)
    public void onLoginSuccessEvent2(LoginSuccessEvent event) {
        log.info("success login 2 for user {}", event.getUser());
    }

    @EventListener(classes = LoginSuccessEvent.class)
    public void onLoginSuccessEvent3(LoginSuccessEvent event) {
        log.info("success login 3 for user {}", event.getUser());
    }
}
