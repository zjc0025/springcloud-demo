package com.xxx.jwt.service;

import com.xxx.jwt.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    public User findUserById(String userId) {
        return new User("1", "username","123");
    }

    public User findByUsername(User user) {
        return new User("1", "username","123");
    }

}
