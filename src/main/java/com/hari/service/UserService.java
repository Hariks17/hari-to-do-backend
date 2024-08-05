package com.hari.service;

import com.hari.model.User;

public interface UserService {

    void registerUser(User user);
    void verifyUser(User user);
}
