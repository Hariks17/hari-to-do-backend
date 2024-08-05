package com.hari.service;

import com.hari.exception.UserAlreadyExistException;
import com.hari.exception.UserNotFoundException;
import com.hari.model.User;
import com.hari.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        User user1 = userRepository.findByUseremail(user.getUseremail());
        if(user1 != null){
            throw  new UserAlreadyExistException("User already exist");
        }
        userRepository.save(user);
    }

    @Override
    public void verifyUser(User user) {

        User user1 = userRepository.findByUseremail(user.getUseremail());

        System.out.println(user.getPassword().equals(user1.getPassword()));

        if(user1 == null){
            throw new UserNotFoundException("User not found");
        }

        if(!user.getPassword().equals(user1.getPassword())){
            throw new RuntimeException("Password Doesnt Match");
        }
    }
}
