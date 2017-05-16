INSERT INTO `shop_db`.`user` (`id`, `dateOfBirth`, `emailAddress`, `firstName`, `lastName`, `password`, `userName`) VALUES ('1', '1985-10-05', 'admin@shop.io', 'Bill', 'Night', '$2a$10$q.ISiDA/86gS/Ce343FMAuG3ZATMquaVn0nzwYnqOUCtNv7yBxM4W', 'admin');
INSERT INTO `shop_db`.`user` (`id`, `dateOfBirth`, `emailAddress`, `firstName`, `lastName`, `password`, `userName`) VALUES ('2', '1990-05-02', 'dan@shop.io', 'Dan', 'Woo', '$2a$10$q.ISiDA/86gS/Ce343FMAuG3ZATMquaVn0nzwYnqOUCtNv7yBxM4W', 'dan98');
INSERT INTO `shop_db`.`user` (`id`, `dateOfBirth`, `emailAddress`, `firstName`, `lastName`, `password`, `userName`) VALUES ('3', '1990-05-02', 'super@admin.io', 'Super', 'User', '$2a$10$q.ISiDA/86gS/Ce343FMAuG3ZATMquaVn0nzwYnqOUCtNv7yBxM4W', 'sa');

INSERT INTO `shop_db`.`user_roles` (`id`, `role`) VALUES ('1', 'ADMIN');
INSERT INTO `shop_db`.`user_roles` (`id`, `role`) VALUES ('1', 'USER');
INSERT INTO `shop_db`.`user_roles` (`id`, `role`) VALUES ('2', 'USER');
INSERT INTO `shop_db`.`user_roles` (`id`, `role`) VALUES ('3', 'ADMIN');
INSERT INTO `shop_db`.`user_roles` (`id`, `role`) VALUES ('3', 'USER');

INSERT INTO `shop_db`.`user_address` (`id`, `apartmentNumber`, `city`, `country`, `street`, `zipCode`, `user_id`) VALUES ('1', '48 H', 'New York', 'USA', '27 E 65th Street', '10065', '1');
INSERT INTO `shop_db`.`user_address` (`id`, `apartmentNumber`, `city`, `country`, `street`, `zipCode`, `user_id`) VALUES ('2', '2', 'New York', 'USA', '620 6th Avenue', '10011', '1');
INSERT INTO `shop_db`.`user_address` (`id`, `apartmentNumber`, `city`, `country`, `street`, `zipCode`, `user_id`) VALUES ('3', '56', 'Montreal', 'Canada', '755 Rue Dominion', '2051', '2');

INSERT INTO `shop_db`.`category` (`id`, `name`) VALUES ('1', 'Everyday');
INSERT INTO `shop_db`.`category` (`id`, `name`) VALUES ('2', 'Classical');
INSERT INTO `shop_db`.`category` (`id`, `name`) VALUES ('3', 'Designer');
INSERT INTO `shop_db`.`category` (`id`, `name`) VALUES ('4', 'Sports');
INSERT INTO `shop_db`.`category` (`id`, `name`) VALUES ('5', 'Military');

INSERT INTO `shop_db`.`brand` (`id`, `name`) VALUES ('1', 'Adidas');
INSERT INTO `shop_db`.`brand` (`id`, `name`) VALUES ('2', 'Casio');

INSERT INTO `shop_db`.`product` (`id`, `backlight`, `clockFace`, `description`, `gender`, `glass`, `name`, `price`, `stock`, `volume`, `waterResistant`, `weight`, `brand_id`, `category_id`) VALUES ('1', TRUE , 'Digital', 'Description', 'Male', 'Organic', 'WR-100', '120', '12', '1', 'WR200', '10', '2', '1');
INSERT INTO `shop_db`.`product` (`id`, `backlight`, `clockFace`, `description`, `gender`, `glass`, `name`, `price`, `stock`, `volume`, `waterResistant`, `weight`, `brand_id`, `category_id`) VALUES ('2', FALSE , 'Digital', 'Description', 'Male', 'Organic', 'WR-400', '280', '8', '1', 'WR200', '10', '2', '1');
INSERT INTO `shop_db`.`product` (`id`, `backlight`, `clockFace`, `description`, `gender`, `glass`, `name`, `price`, `stock`, `volume`, `waterResistant`, `weight`, `brand_id`, `category_id`) VALUES ('3', TRUE , 'Digital', 'Description', 'Male', 'Organic', 'WR-500', '400', '6', '1', 'WR200', '10', '2', '1');

