package com.example.fullstackwishfull.UserPackage.Controller;


import com.example.fullstackwishfull.UserPackage.service.userService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class UserController {

    userService uService = new userService();


    @GetMapping("/login")
    public String login(){
        return "Login";
    }


    @GetMapping("/signup")
    public String signup(){
        return "SignUp";
    }

    @PostMapping("/signup")
    public String create(WebRequest req) {

        uService.create(req);

        return "redirect:/wishlists";
    }

    @GetMapping("/profile")
    public String profile(){
        return "Profile";
    }


}
