INSERT INTO `shop_db`.`user_profile` (`id`, `TYPE`) VALUES ('1', 'USER');
INSERT INTO `shop_db`.`user_profile` (`id`, `TYPE`) VALUES ('2', 'ADMIN');

INSERT INTO `shop_db`.`user` (`id`, `dateOfBirth`, `emailAddress`, `firstName`, `lastName`, `password`) VALUES ('1', '1985-10-05', 'admin@shop.io', 'Bill', 'Night', '$10$8ocGQ3J3QpZlOXx8/ob3OeVY4yY1CTefI2kiAdo9FylnDsPIoaqUa');
INSERT INTO `shop_db`.`user` (`id`, `dateOfBirth`, `emailAddress`, `firstName`, `lastName`, `password`) VALUES ('2', '1990-05-02', 'dan@shop.io', 'Dan', 'Woo', '$2a$10$yaLJs2zM4sbO87uoXJmP4O3d2xykrO/SEW8e6hZmFuwFK9idzN0py');

INSERT INTO `shop_db`.`user_userprofile` (`user_id`, `user_profile_id`) VALUES ('1', '2');
INSERT INTO `shop_db`.`user_userprofile` (`user_id`, `user_profile_id`) VALUES ('2', '1');

INSERT INTO `shop_db`.`category` (`id`, `name`) VALUES ('1', 'Boots');
INSERT INTO `shop_db`.`category` (`id`, `name`) VALUES ('2', 'Moccasins');
INSERT INTO `shop_db`.`category` (`id`, `name`) VALUES ('3', 'Sandals');
INSERT INTO `shop_db`.`category` (`id`, `name`) VALUES ('4', 'Slippers');
INSERT INTO `shop_db`.`category` (`id`, `name`) VALUES ('5', 'Sneakers');

INSERT INTO `shop_db`.`product` (`id`, `name`, `price`, `stock`, `volume`, `weight`, `category_id`) VALUES ('1', 'Winter Boots', '85.99', '4', '4', '1.5', '1');
INSERT INTO `shop_db`.`product` (`id`, `name`, `price`, `stock`, `volume`, `weight`, `category_id`) VALUES ('2', 'Spring Boots', '49.99', '8', '3', '1.2', '1');
INSERT INTO `shop_db`.`product` (`id`, `name`, `price`, `stock`, `volume`, `weight`, `category_id`) VALUES ('3', 'Summer Boots', '29.99', '10', '2', '1', '1');
INSERT INTO `shop_db`.`product` (`id`, `name`, `price`, `stock`, `volume`, `weight`, `category_id`) VALUES ('4', 'Stylish Boots', '119.99', '1', '2', '0.8', '1');
INSERT INTO `shop_db`.`product` (`id`, `name`, `price`, `stock`, `volume`, `weight`, `category_id`) VALUES ('5', 'Red Moccassins', '199.99', '12', '2', '0.9', '2');
INSERT INTO `shop_db`.`product` (`id`, `name`, `price`, `stock`, `volume`, `weight`, `category_id`) VALUES ('6', 'Black Moccassins', '99.99', '2', '2', '0.9', '2');
INSERT INTO `shop_db`.`product` (`id`, `name`, `price`, `stock`, `volume`, `weight`, `category_id`) VALUES ('7', 'Stylish Sandals', '20.00', '10', '2', '0.5', '3');
INSERT INTO `shop_db`.`product` (`id`, `name`, `price`, `stock`, `volume`, `weight`, `category_id`) VALUES ('8', 'Kid\'s Sandals', '5.99', '3', '1', '0.2', '3');
INSERT INTO `shop_db`.`product` (`id`, `name`, `price`, `stock`, `volume`, `weight`, `category_id`) VALUES ('9', 'Women Slippers', '7.99', '12', '1', '0.3', '4');
INSERT INTO `shop_db`.`product` (`id`, `name`, `price`, `stock`, `volume`, `weight`, `category_id`) VALUES ('10', 'Men Slippers', '7.99', '5', '1', '0.4', '4');
INSERT INTO `shop_db`.`product` (`id`, `name`, `price`, `stock`, `volume`, `weight`, `category_id`) VALUES ('11', 'Skater Sneakers', '49.99', '4', '3', '1.2', '5');
INSERT INTO `shop_db`.`product` (`id`, `name`, `price`, `stock`, `volume`, `weight`, `category_id`) VALUES ('12', 'Sneakers for running', '99.99', '6', '3', '0.8', '5');

INSERT INTO `shop_db`.`user_address` (`id`, `apartmentNumber`, `city`, `country`, `street`, `zipCode`, `user_id`) VALUES ('1', '48 H', 'New York', 'USA', '27 E 65th Street', '10065', '1');
INSERT INTO `shop_db`.`user_address` (`id`, `apartmentNumber`, `city`, `country`, `street`, `zipCode`, `user_id`) VALUES ('2', '2', 'New York', 'USA', '620 6th Avenue', '10011', '1');
INSERT INTO `shop_db`.`user_address` (`id`, `apartmentNumber`, `city`, `country`, `street`, `zipCode`, `user_id`) VALUES ('3', '56', 'Montreal', 'Canada', '755 Rue Dominion', '2051', '2');
