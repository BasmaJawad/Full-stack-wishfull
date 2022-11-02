package com.example.fullstackwishfull.WishPackage.repository;

import com.example.fullstackwishfull.database.DatabaseConnectionManager;
import com.example.fullstackwishfull.WishPackage.model.Wish;
import org.springframework.web.context.request.WebRequest;


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



    // Læser fra database
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
            psts.setInt(1, wish.getUserID());
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

    public List<Wish> findUserWishSQL(int uID , String wTitle  ) {
        List<Wish> userWishes = new ArrayList<>();
        try {
            PreparedStatement psts = conn.prepareStatement("SELECT * FROM wishfulldb.allwishes where userID=? AND wishlistTitle =?");
            psts.setInt(1, uID);
            psts.setString(2, wTitle);

            ResultSet resultSet = psts.executeQuery();

            while (resultSet.next()) {
                userWishes.add(new Wish(
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

        return userWishes;
    }

    public void deleteWish(int userID, WebRequest req) { //delete wish from sql

        System.out.println("her " + req.getParameter("wishlistID"));
        System.out.println(req.getParameter("wishName"));
        System.out.println(userID);
        try {
           PreparedStatement psts = conn.prepareStatement("DELETE FROM wishfulldb.allwishes where userID=? AND wishListID =? AND wishName =?");

            psts.setInt(1, userID);
            psts.setInt(2, Integer.parseInt(req.getParameter("wishlistID")));
            psts.setString(3, req.getParameter("wishName"));

            psts.executeUpdate();

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
