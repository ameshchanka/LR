-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALid_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema lr
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `lr` ;

-- -----------------------------------------------------
-- Schema lr
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lr` DEFAULT CHARACTER SET utf8 ;
USE `lr` ;

-- -----------------------------------------------------
-- Table `lr`.`addr_countries`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lr`.`addr_countries` ;

CREATE TABLE IF NOT EXISTS `lr`.`addr_countries` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_unique` (`name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `lr`.`addr_cities`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lr`.`addr_cities` ;

CREATE TABLE IF NOT EXISTS `lr`.`addr_cities` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `country_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_country_id_unique` (`name` ASC, `country_id` ASC),
  INDEX `fk_countries_cities_idx` (`country_id` ASC),
  CONSTRAINT `fk_countries_cities`
    FOREIGN KEY (`country_id`)
    REFERENCES `lr`.`addr_countries` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `lr`.`addr_streets`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lr`.`addr_streets` ;

CREATE TABLE IF NOT EXISTS `lr`.`addr_streets` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `city_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_city_id_unique` (`name` ASC, `city_id` ASC),
  INDEX `fk_cities_streets_idx` (`city_id` ASC),
  CONSTRAINT `fk_cities_streets`
    FOREIGN KEY (`city_id`)
    REFERENCES `lr`.`addr_cities` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `lr`.`addr_addresses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lr`.`addr_addresses` ;

CREATE TABLE IF NOT EXISTS `lr`.`addr_addresses` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `street_id` BIGINT UNSIGNED NOT NULL,
  `objectNumberStr` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `objectNumberStr_street_id_unique` (`objectNumberStr` ASC, `street_id` ASC),
  INDEX `fk_streets_addresses_idx` (`street_id` ASC),
  CONSTRAINT `fk_streets_addresses`
    FOREIGN KEY (`street_id`)
    REFERENCES `lr`.`addr_streets` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `lr`.`crm_roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lr`.`crm_roles` ;

CREATE TABLE IF NOT EXISTS `lr`.`crm_roles` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(31) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `role_unique` (`role` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `lr`.`crm_users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lr`.`crm_users` ;

CREATE TABLE IF NOT EXISTS `lr`.`crm_users` (
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
-- Table `lr`.`crm_usersroles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lr`.`crm_users_roles` ;

CREATE TABLE IF NOT EXISTS `lr`.`crm_users_roles` (
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
-- Table `lr`.`lr_roomsobjects`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lr`.`lr_roomsobjects` ;

CREATE TABLE IF NOT EXISTS `lr`.`lr_roomsobjects` (
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
    REFERENCES `lr`.`addr_addresses` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `lr`.`lr_roomsobjectinformations`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lr`.`lr_roomsobjectinformations` ;

CREATE TABLE IF NOT EXISTS `lr`.`lr_roomsobjectinformations` (
  `id` BIGINT UNSIGNED NOT NULL,
  `description` VARCHAR(4095) NULL DEFAULT NULL,
  `version` BIGINT UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_roomsobjects_roomsobjectinformations`
    FOREIGN KEY (`id`)
    REFERENCES `lr`.`lr_roomsobjects` (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `lr`.`lr_rooms`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lr`.`lr_rooms` ;

CREATE TABLE IF NOT EXISTS `lr`.`lr_rooms` (
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
    REFERENCES `lr`.`lr_roomsobjects` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_users_rooms`
    FOREIGN KEY (`user_id`)
    REFERENCES `lr`.`crm_users` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `lr`.`lr_leaseads`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lr`.`lr_leaseads` ;

CREATE TABLE IF NOT EXISTS `lr`.`lr_leaseads` (
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
    REFERENCES `lr`.`lr_rooms` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `lr`.`lr_leaseads`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lr`.`lr_messages` ;

CREATE TABLE IF NOT EXISTS `lr`.`lr_messages` (
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
    REFERENCES `lr`.`crm_users` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_users_messages_recipient`
    FOREIGN KEY (`recipient_id`)
    REFERENCES `lr`.`crm_users` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_leaseads_messages`
    FOREIGN KEY (`leasead_id`)
    REFERENCES `lr`.`lr_leaseads` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `lr`.`crm_images`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lr`.`crm_images` ;

CREATE TABLE IF NOT EXISTS `lr`.`crm_images` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `path` TEXT NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `lr`.`lr_roomsobjectimages`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lr`.`lr_roomsobjectimages` ;

CREATE TABLE IF NOT EXISTS `lr`.`lr_roomsobjectimages` (
  `image_id` BIGINT UNSIGNED NOT NULL,
  `roomsobject_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`image_id`),
  CONSTRAINT `fk_images_roomsobjectimages`
    FOREIGN KEY (`image_id`)
    REFERENCES `lr`.`crm_images` (`id`),
  CONSTRAINT `fk_roomsobjects_roomsobjectimages`
    FOREIGN KEY (`roomsobject_id`)
    REFERENCES `lr`.`lr_roomsobjects` (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `lr`.`lr_roomimages`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lr`.`lr_roomimages` ;

CREATE TABLE IF NOT EXISTS `lr`.`lr_roomimages` (
  `image_id` BIGINT UNSIGNED NOT NULL,
  `room_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`image_id`),
  CONSTRAINT `fk_images_roomimages`
    FOREIGN KEY (`image_id`)
    REFERENCES `lr`.`crm_images` (`id`),
  CONSTRAINT `fk_rooms_roomimages`
    FOREIGN KEY (`room_id`)
    REFERENCES `lr`.`lr_rooms` (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



-- -----------------------------------------------------
-- INSERT VALUES
-- -----------------------------------------------------
INSERT INTO `lr`.`crm_roles` (`id`, `role`)
VALUES
(1, 'admin'),
(2, 'owner'),
(3, 'user');

INSERT INTO `lr`.`crm_users` (`id`, `name`, `email`,
`password`, `phoneNumber`, `skype`, `telegram`, `viber`)
VALUES
(1, 'NameAdmin', 'admin@admin.com', '$2a$10$Hrydn4ljFkKong6gjpoGmeDqOzOxPDBmXeqcb4FMBxCcZCZb8o5wO',
 '+375291111111', 'admin_skype', 'admin_telegram', 'admin_viber'),
(2, 'NameManager', 'manager@mail.com', '$2a$10$Hrydn4ljFkKong6gjpoGmeDqOzOxPDBmXeqcb4FMBxCcZCZb8o5wO',
'+375292222222', 'manager_skype', 'manager_telegram', 'manager_viber'),
(3, 'NameManager', 'manager2@mail.com', '$2a$10$Hrydn4ljFkKong6gjpoGmeDqOzOxPDBmXeqcb4FMBxCcZCZb8o5wO',
'+375292222221', 'manager2_skype', 'manager2_telegram', 'manager2_viber'),
(4, 'NameUser', 'user@user.com', '$2a$10$Hrydn4ljFkKong6gjpoGmeDqOzOxPDBmXeqcb4FMBxCcZCZb8o5wO',
'+375293333333', 'user_skype', 'user_telegram', 'user_viber');

INSERT INTO `lr`.`crm_users_roles` (`user_id`, `role_id`)
VALUES
(1, 1), (1, 2), (1, 3),
(2, 2), (2, 3),
(3, 2), (3, 3),
(4, 3);

INSERT INTO `lr`.`addr_countries` (`id`, `name`)
VALUES
(1, 'Belarus');

INSERT INTO `lr`.`addr_cities` (`id`, `name`, `country_id`)
VALUES
(1, 'Minsk', 1);

INSERT INTO `lr`.`addr_streets` (`id`, `name`, `city_id`)
VALUES
(1, 'Pobediteley', 1),
(2, 'Prititskogo', 1);

INSERT INTO `lr`.`addr_addresses` (`id`, `street_id`, `objectNumberStr`)
VALUES
(1, 1, '65'),
(2, 2, '29');

INSERT INTO `lr`.`lr_roomsobjects` (`id`, `name`, `lat`, `lng`, `address_id` )
VALUES
(1, 'Zamok', 53.9307475, 27.5178348, 1),
(2, 'Tivalli', 53.908061, 27.484856, 2);

INSERT INTO `lr`.`lr_roomsobjectinformations` (`id`, `description`)
VALUES
  (1, 'Торговый центр Замок – новый уровень шопинга и развлечений! К вашим услугам - магазины, кафе и рестораны, ледовый каток, кинотеатр, детский зал.'),
  (2, 'Современный Многофункциональный Торгово-Развлекательный Бизнес Комплекс. Представляет собой мощный проект, подчёркивающий современный этап развития Минска в качестве столицы европейского государства.');

INSERT INTO `lr`.`lr_rooms` (`id`, `name`, `square`, `roomsobject_id`, `user_id` )
VALUES
(1, 'A11', 300.5, 1, 2),
(2, 'B22', 200.2, 1, 2),
(3, 'C33', 500.0, 1, 2),
(4, 'D44', 350.7, 1, 2),
(5, 'E55', 430.1, 1, 2),
(6, 'F66', 602.9, 1, 2),
(7, 'G77', 804.8, 1, 2),
(8, 'I88', 135.3, 1, 2),
(9, 'H99', 779.4, 1, 2),
(10, 'J1', 179.4, 2, 3),
(11, 'K2', 279.4, 2, 3),
(12, 'L3', 379.4, 2, 3),
(13, 'M4', 479.4, 2, 3),
(14, 'N5', 579.4, 2, 3),
(15, 'O6', 679.4, 2, 3),
(16, 'P7', 759.4, 2, 3),
(17, 'Q8', 879.4, 2, 3),
(18, 'R9', 979.4, 2, 3),
(19, 'S10', 719.4, 2, 3),
(20, 'T11', 739.4, 2, 3);

INSERT INTO `lr`.`lr_leaseads` (`id`, `price`, `room_id`,`dateStartLease`,`dateStopLease`)
VALUES
(1, 1500.5, 1,'2012-05-19', null),
(2, 900.9,  2,'2012-05-25', null),
(3, 1800.9, 3, null, null),
(4, 1282.9, 4, null, null),
(5, 899.9, 5, null, null),
(6, 1202.9, 6, null, null),
(7, 1604.8, 7, null, null),
(8, 608.3, 8, null, null),
(9, 1100.4, 9, null, null),
(10, 1100.4, 10, null, null),
(11, 1100.4, 11, null, null),
(12, 1100.4, 12, null, null),
(13, 1100.4, 13, null, null),
(14, 1100.4, 14, null, null),
(15, 1100.4, 15, null, null),
(16, 1100.4, 16, null, null),
(17, 1100.4, 17, null, null),
(18, 1100.4, 18, null, null),
(19, 1100.4, 19, null, null),
(20, 1100.4, 20, null, null);
INSERT INTO `lr`.`lr_leaseads` (`id`, `price`, `room_id`,`dateStartLease`,`dateStopLease`)
VALUES
(21, 1300.5, 1, '2010-11-15', '2011-01-23' ),
(22, 1300.5, 2, '2011-01-29', '2011-11-24' ),
(23, 1300.5, 1, '2011-02-13', '2012-04-16' );