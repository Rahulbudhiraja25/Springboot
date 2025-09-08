package com.learn.apiIntegration.Controllers;

import com.learn.apiIntegration.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<Map<String, Object>> getUser() {
        return ResponseEntity.ok(userService.getUserData());
    }
}
