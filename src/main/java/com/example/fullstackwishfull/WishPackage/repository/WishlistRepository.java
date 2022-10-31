package com.example.fullstackwishfull.WishPackage.repository;

import com.example.fullstackwishfull.DatabaseConnectionManager;
import com.example.fullstackwishfull.WishPackage.model.Wishlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WishlistRepository {


    private Connection conn = DatabaseConnectionManager.getConnection();

    public List<Wishlist> findUserWishListsSQL(int id) {
        List<Wishlist> userWishlists = new ArrayList<>();
        try {
            PreparedStatement psts = conn.prepareStatement("SELECT * FROM wishfulldb.allwishlists where userID =?");
            psts.setInt(1, id);
            ResultSet resultSet = psts.executeQuery();

            while (resultSet.next()) {
                userWishlists.add(new Wishlist(
                        resultSet.getInt("userID"),
                        resultSet.getInt("wishListID"),
                        resultSet.getString("wishListTitle")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return userWishlists;
    }


    public void create(Wishlist wishlist) {

        try {
            PreparedStatement psts = conn.prepareStatement("INSERT INTO wishfulldb.allwishlists (userID, wishListID,wishListTitle) VALUES (?,?,?)");
            psts.setInt(1, wishlist.getUserID());
            psts.setInt(2, wishlist.getWishListID());
            psts.setString(3, wishlist.getWishListTitle());

            psts.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Wishlist> allWishlists() {

        //læser fra db
        List<Wishlist> allWishlists = new ArrayList<>();

        try {
            PreparedStatement psts = conn.prepareStatement("SELECT * FROM wishfulldb.allwishlists");
            ResultSet resultSet = psts.executeQuery();

            while (resultSet.next()) {
                allWishlists.add(new Wishlist(
                        resultSet.getInt("userID"),
                        resultSet.getInt("wishListID"),
                        resultSet.getString("wishListTitle")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return allWishlists;
    }

    // Genere arrayliste for hver userID, og gemmer hele objektet
    // vi får fat i titlerne gennem her

}







