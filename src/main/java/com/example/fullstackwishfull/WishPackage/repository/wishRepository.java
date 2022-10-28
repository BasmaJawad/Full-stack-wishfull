package com.example.fullstackwishfull.WishPackage.repository;

import com.example.fullstackwishfull.DatabaseConnectionManager;
import com.example.fullstackwishfull.UserPackage.model.User;
import com.example.fullstackwishfull.WishPackage.model.Wish;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class wishRepository {

    //læser fra db

    //Connecter til db
    private Connection conn = DatabaseConnectionManager.getConnection();

    public List<Wish> allWishes(){

        //læser fra db
        List<Wish> wishes = new ArrayList<>();

        try {
            PreparedStatement psts = conn.prepareStatement("SELECT * FROM wishfulldb.allwishes");
            ResultSet resultSet = psts.executeQuery();

            while(resultSet.next()){
                wishes.add(new Wish(
                        resultSet.getInt("userID"),
                        resultSet.getInt("wishListID"),
                        resultSet.getString("wishlistTitle"),
                        resultSet.getString("wishName"),
                        resultSet.getString("price"),
                        resultSet.getString("link"),
                        resultSet.getString("description")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return wishes;
    }

    //opretter en ny wish
    //instanser af wish oprettes i service
    public void create(Wish wish)  {

        try {
            PreparedStatement psts = conn.prepareStatement("INSERT INTO wishfulldb.allwishes (userID, wishListID,wishlistTitle,wishName,price,link,description) VALUES (?,?,?,?,?,?,?)");
            psts.setInt(1, User.getUserID());
            psts.setInt(2, wish.getWishListID());
            psts.setString(3, wish.getWishListTitle());
            psts.setString(4, wish.getWishName());
            psts.setString(5, wish.getPrice());
            psts.setString(6, wish.getLink());
            psts.setString(7, wish.getDescription());

            psts.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }




}
