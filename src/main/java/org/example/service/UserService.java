package org.example.service;

import org.example.entity.UserInfo;

public interface UserService {
    UserInfo saveUser(String googleId, String login, String name, String surname);
}
