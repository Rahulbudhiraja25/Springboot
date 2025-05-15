package com.project.LoginModule.Service;


import com.project.LoginModule.Entity.LoginUser;
import com.project.LoginModule.Repository.LoginUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.project.LoginModule.Entity.RahulException;
@Service
public class LoginService {

    @Autowired
    LoginUserRepository loginUserRepository;
    public String Signup(LoginUser loginUser){
        loginUserRepository.save(loginUser);
        return "Signup Success";
    }

    public String login(@RequestBody String email ,@RequestBody String password) throws RahulException {
        if((loginUserRepository.findByEmail(email) )!= null){
//            String password2;
            LoginUser user=loginUserRepository.findByEmail(email);
//            password2= user.getPassword();
            if(password.equals(user.getPassword())){
                return "Login Success";
            }
            else{
                throw new RahulException("Login failed: Invalid password");
            }

        }
        else {
            throw new RahulException("Login failed: User not found");
        }
    }



    public  String signup(@RequestBody LoginUser loginUser) throws RahulException{
       try {
           loginUserRepository.save(loginUser);
           return "User Registered";
       }
    catch (Exception e){
           throw new RahulException("User not Registered due to some error");
//           return "User not Registered due to some error";
    }
    }
}
