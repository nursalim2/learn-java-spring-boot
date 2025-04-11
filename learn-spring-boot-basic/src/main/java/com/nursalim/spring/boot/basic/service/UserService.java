package com.nursalim.spring.boot.basic.service;

import com.nursalim.spring.boot.basic.data.User;
import com.nursalim.spring.boot.basic.event.LoginSuccessEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class UserService implements ApplicationEventPublisherAware {
    public ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public Boolean login(String username, String password) {
        if (isLoginSuccess(username, password)) {
            applicationEventPublisher.publishEvent(new LoginSuccessEvent(new User(username)));
            return true;
        } else {
            return false;
        }
    }

    private boolean isLoginSuccess(String username, String password) {
        return "nursalim".equals(username) && "nursalim".equals(password);
    }
}
