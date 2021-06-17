package com.tkachuk.service.implementations;

import com.tkachuk.entities.UserEntity;
import com.tkachuk.repository.UserRepository;
import com.tkachuk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


    @Override
    public void save(UserEntity user) {
        if (user!=null) {
            userRepository.save(user);
        }
    }

    @Override
    public UserEntity findByLoginAndPassword(String login, String password) {
        UserEntity user = null;
        if (login!=null && password!=null) {
            user = userRepository.findByLoginAndPassword(login, password);
        }
        return user;
    }

    @Override
    public UserEntity findByLogin(String login) {
        if (login!=null) {
            return userRepository.findByLogin(login);
        }
        return null;
    }
}
