package com.nursalim.spring.boot.basic.listener;

import com.nursalim.spring.boot.basic.event.LoginSuccessEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoginSuccessListener implements ApplicationListener<LoginSuccessEvent> {
    @Override
    public void onApplicationEvent(LoginSuccessEvent event) {
        log.info("success login for {}", event.getUser());
    }
}
