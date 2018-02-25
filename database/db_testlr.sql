-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALid_DATES';
-- -----------------------------------------------------
-- Schema testlr
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `testlr` ;

-- -----------------------------------------------------
-- Schema testlr
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `testlr` DEFAULT CHARACTER SET utf8 ;
USE `testlr` ;

-- -----------------------------------------------------
-- Table `testlr`.`addr_countries`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testlr`.`addr_countries` ;

CREATE TABLE IF NOT EXISTS `testlr`.`addr_countries` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_unique` (`name` ASC))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `testlr`.`addr_cities`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testlr`.`addr_cities` ;

CREATE TABLE IF NOT EXISTS `testlr`.`addr_cities` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `country_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_country_id_unique` (`name` ASC, `country_id` ASC),
  INDEX `fk_countries_cities_idx` (`country_id` ASC),
  CONSTRAINT `fk_countries_cities`
  FOREIGN KEY (`country_id`)
  REFERENCES `testlr`.`addr_countries` (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `testlr`.`addr_streets`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testlr`.`addr_streets` ;

CREATE TABLE IF NOT EXISTS `testlr`.`addr_streets` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `city_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_city_id_unique` (`name` ASC, `city_id` ASC),
  INDEX `fk_cities_streets_idx` (`city_id` ASC),
  CONSTRAINT `fk_cities_streets`
  FOREIGN KEY (`city_id`)
  REFERENCES `testlr`.`addr_cities` (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `testlr`.`addr_addresses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testlr`.`addr_addresses` ;

CREATE TABLE IF NOT EXISTS `testlr`.`addr_addresses` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `street_id` BIGINT UNSIGNED NOT NULL,
  `objectNumberStr` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `objectNumberStr_street_id_unique` (`objectNumberStr` ASC, `street_id` ASC),
  INDEX `fk_streets_addresses_idx` (`street_id` ASC),
  CONSTRAINT `fk_streets_addresses`
  FOREIGN KEY (`street_id`)
  REFERENCES `testlr`.`addr_streets` (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `testlr`.`crm_roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testlr`.`crm_roles` ;

CREATE TABLE IF NOT EXISTS `testlr`.`crm_roles` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(31) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `role_unique` (`role` ASC))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `testlr`.`crm_users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testlr`.`crm_users` ;

CREATE TABLE IF NOT EXISTS `testlr`.`crm_users` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(1023) NOT NULL,
  `phoneNumber` VARCHAR(255) NULL DEFAULT NULL,
  `skype` VARCHAR(255) NULL DEFAULT NULL,
  `telegram` VARCHAR(255) NULL DEFAULT NULL,
  `viber` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_unique` (`email` ASC))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `testlr`.`crm_usersroles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testlr`.`crm_users_roles` ;

CREATE TABLE IF NOT EXISTS `testlr`.`crm_users_roles` (
  `user_id` BIGINT UNSIGNED NOT NULL,
  `role_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  INDEX `fk_usersroles_users_idx` (`user_id`),
  UNIQUE INDEX `user_id_role_id_unique` (`user_id` ASC, role_id ASC),
  CONSTRAINT `fk_usersroles_users`
  FOREIGN KEY (`user_id`)
  REFERENCES `crm_users` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_usersroles_roles`
  FOREIGN KEY (`role_id`)
  REFERENCES `crm_roles` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE)
  ENGINE=InnoDB
  DEFAULT CHARSET=utf8;

-- -----------------------------------------------------
-- Table `testlr`.`lr_roomsobjects`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testlr`.`lr_roomsobjects` ;

CREATE TABLE IF NOT EXISTS `testlr`.`lr_roomsobjects` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `lat` FLOAT NULL DEFAULT NULL,
  `lng` FLOAT NULL DEFAULT NULL,
  `address_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `address_id_unique` (`address_id` ASC),
  INDEX `fk_addresses_roomsobjects_idx` (`address_id` ASC),
  CONSTRAINT `fk_addresses_roomsobjects`
  FOREIGN KEY (`address_id`)
  REFERENCES `testlr`.`addr_addresses` (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `testlr`.`lr_roomsobjectinformations`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testlr`.`lr_roomsobjectinformations` ;

CREATE TABLE IF NOT EXISTS `testlr`.`lr_roomsobjectinformations` (
  `roomsobject_id` BIGINT UNSIGNED NOT NULL,
  `description` VARCHAR(4095) NULL DEFAULT NULL,
  PRIMARY KEY (`roomsobject_id`),
  CONSTRAINT `fk_roomsobjects_roomsobjectinformations`
  FOREIGN KEY (`roomsobject_id`)
  REFERENCES `testlr`.`lr_roomsobjects` (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `testlr`.`lr_rooms`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testlr`.`lr_rooms` ;

CREATE TABLE IF NOT EXISTS `testlr`.`lr_rooms` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `square` FLOAT NULL DEFAULT NULL,
  `roomsobject_id` BIGINT UNSIGNED NOT NULL,
  `user_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_roomsobject_id_unique` (`name` ASC, `roomsobject_id` ASC),
  INDEX `fk_roomsobjects_rooms_idx` (`roomsobject_id` ASC),
  INDEX `fk_users_rooms_idx` (`user_id` ASC),
  CONSTRAINT `fk_roomsobjects_rooms`
  FOREIGN KEY (`roomsobject_id`)
  REFERENCES `testlr`.`lr_roomsobjects` (`id`),
  CONSTRAINT `fk_users_rooms`
  FOREIGN KEY (`user_id`)
  REFERENCES `testlr`.`crm_users` (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `testlr`.`lr_leaseads`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testlr`.`lr_leaseads` ;

CREATE TABLE IF NOT EXISTS `testlr`.`lr_leaseads` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `price` FLOAT NULL DEFAULT NULL,
  `dateStartLease` DATETIME NULL DEFAULT NULL,
  `dateStopLease` DATETIME NULL DEFAULT NULL,
  `room_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `dateStopLease_room_id_unique` (`dateStopLease` ASC, `room_id` ASC),
  INDEX `fk_rooms_leaseads_idx` (`room_id` ASC),
  CONSTRAINT `fk_rooms_leaseads`
  FOREIGN KEY (`room_id`)
  REFERENCES `testlr`.`lr_rooms` (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `testlr`.`lr_leaseads`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testlr`.`lr_messages` ;

CREATE TABLE IF NOT EXISTS `testlr`.`lr_messages` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `sender_id` BIGINT UNSIGNED NULL DEFAULT NULL,
  `recipient_id` BIGINT UNSIGNED NOT NULL,
  `leasead_id` BIGINT UNSIGNED NULL DEFAULT NULL,
  `text` TEXT NULL DEFAULT NULL,
  `dateSend` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_messages_sender_idx` (`sender_id` ASC),
  INDEX `fk_users_messages_recipient_idx` (`recipient_id` ASC),
  INDEX `fk_leaseads_messages_idx` (`leasead_id` ASC),
  CONSTRAINT `fk_users_messages_sender`
  FOREIGN KEY (`sender_id`)
  REFERENCES `testlr`.`crm_users` (`id`),
  CONSTRAINT `fk_users_messages_recipient`
  FOREIGN KEY (`recipient_id`)
  REFERENCES `testlr`.`crm_users` (`id`),
  CONSTRAINT `fk_leaseads_messages`
  FOREIGN KEY (`leasead_id`)
  REFERENCES `testlr`.`lr_leaseads` (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `testlr`.`crm_images`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testlr`.`crm_images` ;

CREATE TABLE IF NOT EXISTS `testlr`.`crm_images` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `path` TEXT NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `testlr`.`lr_roomsobjectimages`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testlr`.`lr_roomsobjectimages` ;

CREATE TABLE IF NOT EXISTS `testlr`.`lr_roomsobjectimages` (
  `image_id` BIGINT UNSIGNED NOT NULL,
  `roomsobject_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`image_id`),
  CONSTRAINT `fk_images_roomsobjectimages`
  FOREIGN KEY (`image_id`)
  REFERENCES `testlr`.`crm_images` (`id`),
  CONSTRAINT `fk_roomsobjects_roomsobjectimages`
  FOREIGN KEY (`roomsobject_id`)
  REFERENCES `testlr`.`lr_roomsobjects` (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `testlr`.`lr_roomimages`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testlr`.`lr_roomimages` ;

CREATE TABLE IF NOT EXISTS `testlr`.`lr_roomimages` (
  `image_id` BIGINT UNSIGNED NOT NULL,
  `room_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`image_id`),
  CONSTRAINT `fk_images_roomimages`
  FOREIGN KEY (`image_id`)
  REFERENCES `testlr`.`crm_images` (`id`),
  CONSTRAINT `fk_rooms_roomimages`
  FOREIGN KEY (`room_id`)
  REFERENCES `testlr`.`lr_rooms` (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



-- -----------------------------------------------------
-- INSERT VALUES
-- -----------------------------------------------------
INSERT INTO `testlr`.`crm_roles` (`id`, `role`)
VALUES
  (1, 'admin'),
  (2, 'manager'),
  (3, 'user');

INSERT INTO `testlr`.`crm_users` (`id`, `name`, `email`,
                              `password`, `phoneNumber`, `skype`, `telegram`, `viber`)
VALUES
  (1, 'NameAdmin', 'admin@admin.com', '123456789',
   '+375291111111', 'admin_skype', 'admin_telegram', 'admin_viber'),
  (2, 'NameManager', 'manager@mail.com', '123456789',
   '+375292222222', 'manager_skype', 'manager_telegram', 'manager_viber'),
  (3, 'NameUser', 'user@user.com', '123456789',
   '+375293333333', 'user_skype', 'user_telegram', 'user_viber');

INSERT INTO `testlr`.`crm_users_roles` (`user_id`, `role_id`)
VALUES
  (1, 1), (1, 2), (1, 3),
  (2, 2), (2, 3),
  (3, 3);

INSERT INTO `testlr`.`addr_countries` (`id`, `name`)
VALUES
  (1, 'Belarus');

INSERT INTO `testlr`.`addr_cities` (`id`, `name`, `country_id`)
VALUES
  (1, 'Minsk', 1);

INSERT INTO `testlr`.`addr_streets` (`id`, `name`, `city_id`)
VALUES
  (1, 'Prititskogo', 1),
  (2, 'Pobediteley', 1),
  (3, 'Bobruiskaya', 1),
  (4, 'P.Glebki', 1);

INSERT INTO `testlr`.`addr_addresses` (`id`, `street_id`, `objectNumberStr`)
VALUES
  (1, 1, '65'),
  (2, 2, '29'),
  (3, 3, '6'),
  (4, 4, '5');

INSERT INTO `testlr`.`lr_roomsobjects` (`id`, `name`, `lat`, `lng`, `address_id` )
VALUES
  (1, 'Zamok', 53.9307475, 27.5178348, 1),
  (2, 'Tivalli', 53.908061, 27.484856, 2),
  (3, 'Galileo', 53.908061, 27.484856, 3);

INSERT INTO `testlr`.`lr_roomsobjectinformations` (`roomsobject_id`, `description`)
VALUES
  (1, 'Торговый центр Замок – новый уровень шопинга и развлечений! К вашим услугам - магазины, кафе и рестораны, ледовый каток, кинотеатр, детский зал.'),
  (2, 'Современный Многофункциональный Торгово-Развлекательный Бизнес Комплекс. Представляет собой мощный проект, подчёркивающий современный этап развития Минска в качестве столицы европейского государства.');

INSERT INTO `testlr`.`lr_rooms` (`id`, `name`, `square`, `roomsobject_id`, `user_id` )
VALUES
  (1, 'A24', 524.6, 1, 2),
  (2, 'B67', 324.4, 1, 2),
  (3, 'C31', 724.4, 1, 2),
  (4, 'D15', 224.4, 1, 2);

INSERT INTO `testlr`.`lr_leaseads` (`id`, `price`, `room_id` )
VALUES
  (1, 1200.0, 1),
  (2, 700.0,  2);

INSERT INTO `testlr`.`lr_messages` (`id`, `text`, `sender_id`, `recipient_id`, leasead_id )
VALUES
  (1, 'Hi, where i can get your phone number?', 3, 2, 1);

INSERT INTO `testlr`.`crm_images` (`id`, `path`)
VALUES
  (1, 'img_sc_zamok001.jpg'),
  (2, 'mg_sc_zamok_room001.jpg');

INSERT INTO `testlr`.`lr_roomsobjectimages` (`image_id`, `roomsobject_id`)
VALUES
  (1, 1);

INSERT INTO `testlr`.`lr_roomimages` (`image_id`, `room_id`)
VALUES
  (2, 2);
