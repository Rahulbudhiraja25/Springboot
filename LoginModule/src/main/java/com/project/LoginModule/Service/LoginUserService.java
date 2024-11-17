package com.project.LoginModule.Service;

import com.project.LoginModule.Entity.LoginUser;
import com.project.LoginModule.Repository.LoginUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginUserService {

    @Autowired
    private LoginUserRepository loginUserRepository;

    // Method to find a user by email
//    public LoginUser findUserByEmail(String email) {
//        return loginUserRepository.findByEmail(email);
//    }
public List<email>
    // Method to save a user to the database
    public LoginUser saveUser(LoginUser loginUser) {
        return loginUserRepository.save(loginUser);
    }
}
