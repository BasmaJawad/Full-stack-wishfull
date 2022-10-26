CREATE TABLE IF NOT EXISTS `1000` (

    wishListID int,
    wishlistTitle  VARCHAR(100),
    wishTitle VARCHAR(100),
    price int,
    link VARCHAR(500),
    description  VARCHAR(500)


);

INSERT INTO `1000`(wishListID, wishlistTitle, wishTitle, price, link, description)
VALUES (1,'Birthday', 'Sko', 300,'https://www.aboutyou.dk/p/adidas-originals/sneaker-low-superstar-4545567', 'Sko jeg har ønsket mig i lang tid');

SELECT * FROM `1000`;
