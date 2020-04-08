package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.entity.UserInfo;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserInfo saveUser(String googleId, String login, String name, String surname) {
        Optional<UserInfo> maybeUser = userRepository.findByLogin(login);
        if (maybeUser.isPresent()) {
            UserInfo userInfo = maybeUser.get();
            userInfo.setLastVisit(Instant.now());
            return userInfo;
        } else {
            UserInfo userInfo = UserInfo.builder()
                    .login(login)
                    .externalUserId(googleId)
                    .name(name)
                    .surname(surname)
                    .lastVisit(Instant.now())
                    .build();
            userRepository.saveAndFlush(userInfo);
            return userInfo;
        }
    }
}

