package com.example.fullstackwishfull.UserPackage.service;

import com.example.fullstackwishfull.UserPackage.model.User;
import com.example.fullstackwishfull.UserPackage.repository.userRepository;
import com.example.fullstackwishfull.WishPackage.repository.wishRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

public class userService {

  private int id;
  userRepository userRepo = new userRepository();


  public List<User> allusers() {
    return userRepo.allUsers();
  }


  public int generateID() { //udregner id til næste user ved at tage size og paluser det med 1000 da den første id startede på 1000
    return allusers().size() + 1000;
  }

  public void create(WebRequest req) {

    int id = generateID();

    User user = new User(
        req.getParameter("name"),
        req.getParameter("email"),
        req.getParameter("password"),
        id);

    userRepo.create(user);
  }


  //metoden returnere hvilken html side den direct til, afhængig af om loggin er gennemført
  public int findUser(WebRequest req, Model model) {

    for (User user : allusers()) {
      if (req.getParameter("email").equals(user.getEmail()) &&
          req.getParameter("password").equals(user.getPassword())) {

        model.addAttribute("loggedUser",user); //sender user videre til html, ved navn loggedUser

        System.out.println("hej");
        id = user.getUserID();
        System.out.println(user.getUserID());
        return user.getUserID();
      }
      // Den metode verificerer email og password
      // User loggedUser = user
    }
    return 0;
  }

  public int getId() {
    return id;
  }
}