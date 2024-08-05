package com.hari.service;

import com.hari.exception.UserAlreadyExistException;
import com.hari.exception.UserNotFoundException;
import com.hari.model.User;
import com.hari.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private PasswordService passwordService;


    @Autowired
    UserServiceImpl(UserRepository userRepository,PasswordService passwordService){
        this.userRepository = userRepository;
        this.passwordService = passwordService;
    }

    @Override
    public void registerUser(User user) {
        User user1 = userRepository.findByUseremail(user.getUseremail());
        if(user1 != null){
            throw  new UserAlreadyExistException("User already exist");
        }
        user.setPassword(passwordService.hashPassword(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void verifyUser(User user) {

        User user1 = userRepository.findByUseremail(user.getUseremail());

        if(user1 == null){
            throw new UserNotFoundException("User not found");
        }
        System.out.println(passwordService.checkPassword(user1.getPassword(),user.getPassword()));

        if(!passwordService.checkPassword(user1.getPassword(),user.getPassword())){
            throw new RuntimeException("Password Doesnt Match");
        }
    }
}
