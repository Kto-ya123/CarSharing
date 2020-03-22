package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public User saveUser(String login, String password, String name, String surname) {
        Optional<User> maybeUser = userRepository.findByLogin(login);
        if (maybeUser.isPresent()) {
            return maybeUser.get();
        } else {
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setName(name);
            user.setSurname(surname);
            userRepository.save(user);
            return user;
        }
    }
}

