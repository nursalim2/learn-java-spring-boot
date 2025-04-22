package com.nursalim.spring.boot.restful.api.controller;

import com.nursalim.spring.boot.restful.api.entity.User;
import com.nursalim.spring.boot.restful.api.model.LoginUserRequest;
import com.nursalim.spring.boot.restful.api.model.TokenResponse;
import com.nursalim.spring.boot.restful.api.model.WebResponse;
import com.nursalim.spring.boot.restful.api.service.AuthService;
import com.nursalim.spring.boot.restful.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(path = "/api/auth/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<TokenResponse> login(@RequestBody  LoginUserRequest request) {
        TokenResponse response = authService.login(request);

        return WebResponse.<TokenResponse>builder().data(response).build();
    }

    @DeleteMapping(path = "/api/auth/logout",
            produces = MediaType.APPLICATION_JSON_VALUE)
    private WebResponse<String> logout(User user) {
        authService.logout(user);
        return WebResponse.<String>builder()
                .data("Success")
                .build();
    }
}
