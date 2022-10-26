package com.example.fullstackwishfull.UserPackage.model;

public class User {

    private String firstname;

    private String surname;
    private String email;
    private String password;
    private String birthday;
    private String phoneNumber;
    private int userID;

    //Der skal creates en tabel i databsen, hvergang der creates en ny bruger
    public User(String firstname, String surname, String email, String password, String birthday, String phoneNumber, int id) {
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.userID = id;
    }

    public User(String firstname, String email, String password){
        this.firstname = firstname;
        this.email = email;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String name) {
        this.firstname = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String name) {
        this.surname = name;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
