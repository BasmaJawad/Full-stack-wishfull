package com.example.fullstackwishfull.WishPackage.service;

import com.example.fullstackwishfull.WishPackage.model.Wish;
import com.example.fullstackwishfull.WishPackage.model.Wishlist;
import com.example.fullstackwishfull.WishPackage.repository.WishlistRepository;
import com.example.fullstackwishfull.WishPackage.repository.wishRepository;
import org.springframework.ui.Model;
import org.springframework.web.context.request.WebRequest;

import java.util.List;


public class wishService {

    private int userID;
    private int wishlistID;

    private wishRepository wishRepo = new wishRepository();
    private WishlistRepository wishlistRepo = new WishlistRepository();

    public List<Wish> allwishes() {
        return wishRepo.allWishes();
    }

    // Vi får attibuten herovre, og sender den videre.

    public void createWishlist(WebRequest req) {

        // wishRepo.setNewWishlistTitle(String.valueOf(req.getParameter("title")));
        //return req.getParameter("wishlistTitle");

        Wishlist wishlist = new Wishlist(
                userID,
                wishlistID,
                req.getParameter("title"));

        wishlistRepo.create(wishlist);

    }


    public void createWish(WebRequest req) {

        // int UserID = 0; //skal ændres
        //int wishlistID = createWishlist(wishlistID);
        Wish wish = new Wish(
                userID,
                wishlistID,
                //req.getParameter("wishlistTitle"),
                req.getParameter("wishName"),
                req.getParameter("price"),
                req.getParameter("link"),
                req.getParameter("description"));

        wishRepo.create(wish);
    }

    public void findUserID(int id) {
        userID = id;
        generateID();
    }

    public void generateID() { //udregner id til næste wishlist ved at tage size og paluser det med 1000 da den første id startede på 1000

        wishlistID = wishlistRepo.userWishLists(userID).size() + 1;
    }
}
