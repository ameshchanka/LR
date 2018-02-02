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
  `password` VARCHAR(1023) NOT NULL,
  `phoneNumber` VARCHAR(255) NULL DEFAULT NULL,
  `email` VARCHAR(255) NOT NULL,
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
  UNIQUE INDEX `name_address_id_unique` (`name` ASC, `address_id` ASC),
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
  `roomsobject_id` BIGINT UNSIGNED NOT NULL,
  `description` VARCHAR(4095) NULL DEFAULT NULL,
  PRIMARY KEY (`roomsobject_id`),
  CONSTRAINT `fk_roomsobjects_roomsobjectinformations`
    FOREIGN KEY (`roomsobject_id`)
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
    REFERENCES `lr`.`lr_roomsobjects` (`id`),
  CONSTRAINT `fk_users_rooms`
    FOREIGN KEY (`user_id`)
    REFERENCES `lr`.`crm_users` (`id`))
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
    REFERENCES `lr`.`lr_rooms` (`id`))
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
  PRIMARY KEY (`id`),
  INDEX `fk_users_messages_sender_idx` (`sender_id` ASC),
  INDEX `fk_users_messages_recipient_idx` (`recipient_id` ASC),
  INDEX `fk_leaseads_messages_idx` (`leasead_id` ASC),
  CONSTRAINT `fk_users_messages_sender`
    FOREIGN KEY (`sender_id`)
    REFERENCES `lr`.`crm_users` (`id`),
  CONSTRAINT `fk_users_messages_recipient`
    FOREIGN KEY (`recipient_id`)
    REFERENCES `lr`.`crm_users` (`id`),
  CONSTRAINT `fk_leaseads_messages`
    FOREIGN KEY (`leasead_id`)
    REFERENCES `lr`.`lr_leaseads` (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `lr`.`crm_images`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lr`.`crm_images` ;

CREATE TABLE IF NOT EXISTS `lr`.`crm_images` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `path` LONGTEXT NOT NULL,
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