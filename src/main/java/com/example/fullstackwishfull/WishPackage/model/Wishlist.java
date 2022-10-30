package com.example.fullstackwishfull.WishPackage.model;

public class Wishlist {

   private int userID;
   private int wishListID;
   private String wishListTitle;

   public Wishlist(int userID, int wishListID , String wishListTitle) {
      this.wishListID = wishListID;
      this.userID = userID;
      this.wishListTitle = wishListTitle;
   }

   public int getWishListID() {
      return wishListID;
   }

   public void setWishListID(int wishListID) {
      this.wishListID = wishListID;
   }

   public int getUserID() {
      return userID;
   }

   public void setUserID(int userID) {
      this.userID = userID;
   }

   public String getWishListTitle() {
      return wishListTitle;
   }

   public void setWishListTitle(String wishListTitle) {
      this.wishListTitle = wishListTitle;
   }
}
