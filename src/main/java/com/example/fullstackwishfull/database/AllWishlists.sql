USE wishfulldb;

CREATE TABLE IF NOT EXISTS allWishlists
    (
        userID int,
        wishListID int,
        wishListTitle VARCHAR(50)
);


insert into allWishlists(userID, wishListID,  wishListTitle)
VALUES (1000,1,'Birthday');

