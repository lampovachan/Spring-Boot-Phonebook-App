package com.tkachuk.repository;

import com.tkachuk.entities.UserEntity;

public interface UserRepository {
    void save(UserEntity user);
    UserEntity findByLoginAndPassword(String login, String password);
    UserEntity findByLogin(String login);
}
