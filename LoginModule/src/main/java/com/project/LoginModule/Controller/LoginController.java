package com.project.LoginModule.Controller;

import com.project.LoginModule.Entity.LoginRequest;
import com.project.LoginModule.Entity.LoginUser;
import com.project.LoginModule.Service.LoginService;
import com.project.LoginModule.Entity.RahulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Call the login service with email and password
            String result = loginService.login(loginRequest.getEmail(), loginRequest.getPassword());
            return ResponseEntity.ok(result);  // Return success message with HTTP 200 OK status
        } catch (RahulException e) {
            // Handle the exception and return the error message with HTTP 401 Unauthorized
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

//    @PostMapping("/signup")
//        public ResponseEntity<String> signup(@RequestBody LoginUser loginuser){
//        try {
//            String result=loginService.signup(loginuser);
//            return ResponseEntity.ok(Map.of("message",result));
//        }catch (RahulException e){
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message",e.getMessage()));
//        }
//
//    }
@PostMapping("/signup")
public ResponseEntity<Map<String, String>> signup(@RequestBody LoginUser loginuser) {
    try {
        String result = loginService.signup(loginuser);
        // Return a JSON response with a "message" field
        return ResponseEntity.ok(Map.of("message", result));
    } catch (RahulException e) {
        // Return an error response with a "message" field
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", e.getMessage()));
    }
}

}
