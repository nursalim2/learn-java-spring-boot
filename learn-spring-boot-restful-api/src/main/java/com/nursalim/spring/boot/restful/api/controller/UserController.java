package com.nursalim.spring.boot.restful.api.controller;

import com.nursalim.spring.boot.restful.api.entity.User;
import com.nursalim.spring.boot.restful.api.model.RegisterUserRequest;
import com.nursalim.spring.boot.restful.api.model.UpdateUserRequest;
import com.nursalim.spring.boot.restful.api.model.UserResponse;
import com.nursalim.spring.boot.restful.api.model.WebResponse;
import com.nursalim.spring.boot.restful.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/api/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<String> register(@RequestBody RegisterUserRequest request) {
        userService.register(request);

        return WebResponse.<String>builder().data("Success").build();
    }

    @GetMapping(path = "/api/users/current",
        produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<UserResponse> get(User user) {
        UserResponse userResponse = userService.get(user);

        return WebResponse.<UserResponse>builder().data(userResponse).build();
    }

    @PatchMapping(path = "/api/users/current",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<UserResponse> update(@RequestBody UpdateUserRequest request, User user) {
        UserResponse userResponse = userService.update(user, request);

        return WebResponse.<UserResponse>builder().data(userResponse).build();
    }
}
