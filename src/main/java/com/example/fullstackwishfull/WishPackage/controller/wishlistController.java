package com.example.fullstackwishfull.WishPackage.controller;

import com.example.fullstackwishfull.WishPackage.service.wishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class wishlistController {

    private final wishService wService;

    public wishlistController(wishService wService) {
        this.wService = wService;
    }

    @GetMapping("/wishlists")
    public String viewWishlists(){
        return "AllWishlists";
    }


    @GetMapping("/addwishlist")
    public String addWishList(WebRequest req){
        wService.createWishlist(req);
        return "AddWishlist";
    }

    @GetMapping("/wishlist")
    public String viewWishlidt(){
        return "Wishlist";
    }

    @GetMapping("/addwish")
    public String addWish(WebRequest req){

        wService.createWish(req);

        return "AddWish";
    }



}
