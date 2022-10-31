package com.example.fullstackwishfull.WishPackage.model;

public class Wish {

    private int userID;
    private int wishListID;
    private String wishlistTitle;
    private String wishName;
    private String price;
    private String link;
    private String description;

    public Wish(String wishlistTitle) {
        this.wishlistTitle = wishlistTitle;
    }

    public Wish(int userID, int wishListID, String wishListTitle, String wishName, String price, String link, String description) {
        this.userID = userID;
        this.wishListID = wishListID;
        this.wishlistTitle = wishListTitle;
        this.wishName = wishName;
        this.price = price;
        this.link = link;
        this.description = description;
    }

    public Wish(int userID, int wishListID, String wishName, String price, String link, String description) {
        this.userID = userID;
        this.wishListID = wishListID;
        this.wishName = wishName;
        this.price = price;
        this.link = link;
        this.description = description;
    }

    public Wish(int WLid, String wishListTitle, String wishName, String price, String link, String description) {
        this.wishListID = WLid;
        this.wishlistTitle = wishListTitle;
        this.wishName = wishName;
        this.price = price;
        this.link = link;
        this.description = description;
    }




  public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getWishListID() {
        return wishListID;
    }

    public void setWishListID(int wishListID) {
        this.wishListID = wishListID;
    }

    public String getWishListTitle() {
        return wishlistTitle;
    }

    public void setWishListTitle(String wishListTitle) {
        this.wishlistTitle = wishListTitle;
    }

    public String getWishName() {
        return wishName;
    }

    public void setWishName(String wishName) {
        this.wishName = wishName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}







