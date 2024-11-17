package com.project.LoginModule.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.project.LoginModule.Entity.LoginUser;
import com.project.LoginModule.Service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class loginController {

    @Autowired
    private LoginUserService loginUserService;

    // Endpoint to login user by email and password
    @PostMapping("/login")
    public String loginUser(@RequestBody LoginUser loginUser) {
        LoginUser foundUser = loginUserService.findUserByEmail(loginUser.getEmail());

        if (foundUser != null && foundUser.getPassword().equals(loginUser.getPassword())) {
            return "Login successful";
        } else {
            return "Invalid email or password";
        }
    }

    // Endpoint to save a new user to the database
    @PostMapping("/register")
    public String registerUser(@RequestBody LoginUser loginUser) {
        loginUserService.saveUser(loginUser);
        return "User registered successfully";
    }
}
