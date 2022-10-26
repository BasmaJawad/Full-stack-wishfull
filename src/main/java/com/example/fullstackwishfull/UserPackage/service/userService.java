package com.example.fullstackwishfull.UserPackage.service;

import com.example.fullstackwishfull.UserPackage.model.User;
import com.example.fullstackwishfull.UserPackage.repository.userRepository;

import java.util.List;

public class userService {

    userRepository userRepo = new userRepository();

    public List<User> getAllpokemonCards() {
        return userRepo.allUsers();
    }

}