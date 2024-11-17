package com.project.LoginModule.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    // This will make the login page the default page
    @RequestMapping("/")
    public String home() {
        return "redirect:/login.html";  // Serve login.html from /static
    }
}
