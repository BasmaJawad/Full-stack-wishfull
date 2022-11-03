package com.example.fullstackwishfull.WishPackage.service;

import com.example.fullstackwishfull.WishPackage.model.Wish;
import com.example.fullstackwishfull.WishPackage.model.Wishlist;
import com.example.fullstackwishfull.WishPackage.repository.WishlistRepository;
import com.example.fullstackwishfull.WishPackage.repository.wishRepository;
import org.springframework.web.context.request.WebRequest;

import java.util.List;


public class wishService {

    private int userID;
    private int wishlistID;
    private String wishlistTitle;


    private wishRepository wishRepo = new wishRepository();
    private WishlistRepository wishlistRepo = new WishlistRepository();

    // Vi får attibuten herovre, og sender den videre.

    public void createWishlist(WebRequest req) {


        Wishlist wishlist = new Wishlist(
                userID,
                wishlistID,
                req.getParameter("title"));

        wishlistRepo.create(wishlist);

        generateID();

    }


    public void createWish(WebRequest req) {

        Wish wish = new Wish(
                userID,
                wishlistID,
                wishlistTitle,
                req.getParameter("title"),
                req.getParameter("price"),
                req.getParameter("link"),
                req.getParameter("description"));

        wishRepo.create(wish);
    }

    public void findUserID(int id) {
        userID = id;
        generateID();

    }

    public void generateID() {//udregner id til næste ønskeliste ved at tage size og plusser det med 1000, da det første id startede på 1000

        wishlistID = userWishlist().size()+1;
        //wishlistID = wishlistRepo.getUserWishlists().size()+1;

    }

    public List<Wishlist> userWishlist(){ //Metoden returnerer ønskelisten, der tilhører brugeren -> Den bruges i controller
        return wishlistRepo.findUserWishList(userID);
    }

    public List<Wish> userWishes(){ //Metoden returnerer wishes, der tilhører brugeren -> Den bruges i controller

        return  wishRepo.findUserWishes(userID, wishlistTitle);
    }

     public void setWishlistTitle(String wishlistTitle) {
         this.wishlistTitle = wishlistTitle;
     }

    public String getWishlistTitle() {
        return wishlistTitle;
    }



    // Sletter ønsker
    public void deleteWish(WebRequest req) {
        wishRepo.deleteWish(userID, req);
    }
}
