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
    public void create(User user)  {

        try {
            PreparedStatement psts = conn.prepareStatement("INSERT INTO wishfulldb.users (email, password) VALUES (?,?)");
            psts.setString(1, user.getEmail());
            psts.setString(2, user.getPassword());
            psts.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
