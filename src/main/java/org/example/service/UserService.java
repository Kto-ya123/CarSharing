package org.example.service;

import org.example.entity.User;

public interface UserService {
    User saveUser(String login, String password, String name, String surname);
}
