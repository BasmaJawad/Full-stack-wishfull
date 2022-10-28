package com.example.fullstackwishfull.UserPackage.Controller;


import com.example.fullstackwishfull.UserPackage.model.User;
import com.example.fullstackwishfull.UserPackage.service.userService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @PostMapping ("/login")
    public String userValidate(WebRequest req, Model model){
       //String val= uService.findUser(req, model);

        if(uService.findUser(req, model)==0)
            return "Login";
        else
            return "Profile";

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
