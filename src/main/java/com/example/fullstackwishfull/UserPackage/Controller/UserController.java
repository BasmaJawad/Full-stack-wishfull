package com.example.fullstackwishfull.UserPackage.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/login")
    public String login(){
        return "Login";
    }


    @GetMapping("/signup")
    public String signup(){
        return "SignUp";
    }

    @GetMapping("/profile")
    public String profile(){
        return "Profile";
    }


}
