package com.example.fullstackwishfull.UserPackage.repository;

import com.example.fullstackwishfull.DatabaseConnectionManager;
import com.example.fullstackwishfull.UserPackage.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class userRepository {

    //Connecter til db
    private Connection conn = DatabaseConnectionManager.getConnection();

    public List<User> allUsers(){

        //læser fra db
        List<User> users = new ArrayList<>();

        try {
            PreparedStatement psts = conn.prepareStatement("SELECT * FROM wishfulldb.users");
            ResultSet resultSet = psts.executeQuery();

            while(resultSet.next()){
                users.add(new User(
                        resultSet.getString("firstName"),
                        resultSet.getString("surName"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("birthday"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getInt("userID")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return users;
    }

    //opretter en ny user
    //instanser af user oprettes i service
    //når der oprettes en user, skal der også oprettes en wishlist med samme userID
    public void create(User user)  {

        try {
            PreparedStatement psts = conn.prepareStatement("INSERT INTO wishfulldb.users (firstName, email, password, userID) VALUES (?,?,?,?)");
            psts.setString(1, user.getFirstname());
            psts.setString(2, user.getEmail());
            psts.setString(3, user.getPassword());
            psts.setInt(4, user.getUserID());
            psts.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
