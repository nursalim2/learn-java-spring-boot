package com.nursalim.spring.web.mvc.controller;

import com.nursalim.spring.web.mvc.model.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @PostMapping(path = "/auth/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> login(@RequestParam("username") String username,
                                        @RequestParam("password") String password,
                                        HttpServletRequest servletRequest,
                                        HttpServletResponse servletResponse) {
        if("nursalim".equals(username) && "rahasia".equals(password)) {
            HttpSession session = servletRequest.getSession(true);
            session.setAttribute("user", new User(username));

            Cookie cookie = new Cookie("username", username);
            cookie.setPath("/");
            servletResponse.addCookie(cookie);

            return new ResponseEntity<>("Success", HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Failed");
        }
    }

    @GetMapping(path = "/auth/user")
    public ResponseEntity<String> getUser(@CookieValue("username") String usename) {
        return ResponseEntity.ok("Hello " + usename);
    }
}
