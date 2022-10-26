package com.example.fullstackwishfull.UserPackage.service;

import com.example.fullstackwishfull.UserPackage.model.User;
import com.example.fullstackwishfull.UserPackage.repository.userRepository;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

public class userService {

    userRepository userRepo = new userRepository();

    public List<User> allusers() {
        return userRepo.allUsers();
    }


    public int generateID(){ //udregner id til næste user ved at tage size og plluser det med 1000 da den første id startede på 1000
        return allusers().size()+1000;
    }
    public void create(WebRequest req) {

       int id = generateID();

        User user = new User(req.getParameter("name"),req.getParameter("email"),
                req.getParameter("password"), id);

        userRepo.create(user);
    }

}