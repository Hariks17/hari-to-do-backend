package com.hari.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    public String hashPassword(String password){
        return BCrypt.hashpw(password,BCrypt.gensalt());
    }

    public boolean checkPassword(String hashPassword,String password){
        return BCrypt.checkpw(password,hashPassword);
    }

}
