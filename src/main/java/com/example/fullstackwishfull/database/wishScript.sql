CREATE TABLE IF NOT EXISTS `allwishes` (

    userID int,
    wishListID int,
    wishListTitle  VARCHAR(100),
    wishName VARCHAR(100),
    price VARCHAR(50),
    link VARCHAR(500),
    description  VARCHAR(500)


);

INSERT INTO `allwishes`(userID, wishListID, wishlistTitle, wishName, price, link, description)
VALUES (1000, 1,'Birthday', 'Sko', '300','https://www.aboutyou.dk/p/adidas-originals/sneaker-low-superstar-4545567', 'Sko jeg har ønsket mig i lang tid');


TRUNCATE allwishes;