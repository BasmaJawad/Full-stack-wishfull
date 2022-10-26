CREATE DATABASE IF NOT EXISTS wishfulldb;

USE wishfulldb;

CREATE TABLE IF NOT EXISTS users
(
    firstName   VARCHAR(50),
    surName     VARCHAR(50),
    email       VARCHAR(50),
    password    VARCHAR(50),
    birthday    VARCHAR(50),
    phoneNumber VARCHAR(50),
    userID          int,
    PRIMARY KEY (email)
);

INSERT INTO users(firstName, surName, email, password, birthday, phoneNumber, userID)
VALUES ('Mahi', 'Yoga','m@gmail.com','mahi123','16/11/2002', 20908070,1000 );

SELECT * FROM users;






