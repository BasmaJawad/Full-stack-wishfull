package com.example.fullstackwishfull.WishPackage.service;

import com.example.fullstackwishfull.WishPackage.model.Wish;
import com.example.fullstackwishfull.WishPackage.repository.wishRepository;
import org.springframework.ui.Model;
import org.springframework.web.context.request.WebRequest;

import java.util.List;


public class wishService {

    private int userID;

    private wishRepository wishRepo = new wishRepository();


    public List<Wish> allwishes() {
        return wishRepo.allWishes();
    }

    public int generateID() { //udregner id til næste wishlist ved at tage size og paluser det med 1000 da den første id startede på 1000
        return allwishes().size() + 1;
    }

    public void createWishlist(WebRequest req, Model model) {
        model.addAttribute("title", req);

        wishRepo.setNewWishlistTitle(String.valueOf(req));

        //return req.getParameter("wishlistTitle");
    }

    public String sendTitle(){



        return null;
    }



    public void createWish(WebRequest req) {

       // int UserID = 0; //skal ændres
        int WLid = generateID();

        Wish wish = new Wish(
                userID,
                WLid,
                //req.getParameter("wishlistTitle"),
                req.getParameter("wishName"),
                req.getParameter("price"),
                req.getParameter("link"),
                req.getParameter("description"));

        wishRepo.create(wish);
    }

public void findUserID(int id) {
    userID = id;
}

}
