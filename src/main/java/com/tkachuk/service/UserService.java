package com.tkachuk.service;

import com.tkachuk.entities.UserEntity;

public interface UserService {
    void save(UserEntity user);

    UserEntity findByLoginAndPassword(String login, String password);

    UserEntity findByLogin(String login);
}
