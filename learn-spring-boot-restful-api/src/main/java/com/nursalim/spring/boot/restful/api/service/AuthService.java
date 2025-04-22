package com.nursalim.spring.boot.restful.api.service;

import com.nursalim.spring.boot.restful.api.entity.User;
import com.nursalim.spring.boot.restful.api.model.LoginUserRequest;
import com.nursalim.spring.boot.restful.api.model.TokenResponse;
import com.nursalim.spring.boot.restful.api.repository.UserRepository;
import com.nursalim.spring.boot.restful.api.security.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public TokenResponse login(LoginUserRequest request) {
        validationService.validate(request);

        User user = userRepository.findById(request.getUsername()).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or password invalid"));

        if (BCrypt.checkpw(request.getPassword(), user.getPassword())) {
            // success
            user.setToken(UUID.randomUUID().toString());
            user.setTokenExpiredAt(next30Days());

            userRepository.save(user);

            return TokenResponse.builder()
                    .token(user.getToken())
                    .expiredAt(user.getTokenExpiredAt())
                    .build();
        } else {
            // gagal
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or password invalid");
        }

    }

    @Transactional
    public void logout(User user) {
        user.setToken(null);
        user.setTokenExpiredAt(null);

        userRepository.save(user);
    }

    private Long next30Days() {
        return System.currentTimeMillis() + (1_000 * 60 * 24 * 30);
    }
}
