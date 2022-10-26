package com.example.fullstackwishfull.WishPackage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class wishlistController {

    @GetMapping("/wishlists")
    public String viewWishlists(){
        return "AllWishlists";
    }


    @GetMapping("/addwishlist")
    public String addWishList(){
        return "AddWishlist";
    }

    @GetMapping("/wishlist")
    public String viewWishlidt(){
        return "Wishlist";
    }

    @GetMapping("/addwish")
    public String addWish(){
        return "Addwish";
    }
}
