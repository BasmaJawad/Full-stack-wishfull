package com.example.fullstackwishfull.WishPackage.service;
import com.example.fullstackwishfull.WishPackage.model.Wish;
import com.example.fullstackwishfull.WishPackage.repository.wishRepository;
import org.springframework.web.context.request.WebRequest;

import java.util.List;


public class wishService {



  wishRepository wishRepo = new wishRepository();




  public List<Wish> allwishes(){
    return wishRepo.allWishes();
  }


  public int generateID () { //udregner id til næste wishlist ved at tage size og paluser det med 1000 da den første id startede på 1000
    return allwishes().size() + 1;
  }

  public void createWish(WebRequest req){

    // int USid = userService.getId();
    // System.out.println(USid);
    int WLid = generateID();

    Wish wish = new Wish(
     //   USid,
        WLid,
        req.getParameter("wishlistTitle"),
        req.getParameter("wishName"),
        req.getParameter("price"),
        req.getParameter("link"),
        req.getParameter("description"));
  }


  public void createWishlist(WebRequest req){
    Wish wish = new Wish(req.getParameter("wishlistTitle"));
  }





}
