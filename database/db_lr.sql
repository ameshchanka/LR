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
  `id` BIGINT NOT NULL AUTO_INCREMENT,
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
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `country_id` BIGINT NOT NULL,
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
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `city_id` BIGINT NOT NULL,
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
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `street_id` BIGINT NOT NULL,
  `buildingNumberStr` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `buildingNumberStr_street_id_unique` (`buildingNumberStr` ASC, `street_id` ASC),
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
  `id` BIGINT NOT NULL AUTO_INCREMENT,
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
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `password` VARCHAR(1023) NOT NULL,
  `phoneNumber` VARCHAR(255) NULL DEFAULT NULL,
  `email` VARCHAR(255) NOT NULL,
  `role_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_unique` (`email` ASC),
  INDEX `fk_roles_users_idx` (`role_id` ASC),
  CONSTRAINT `fk_roles_users`
    FOREIGN KEY (`role_id`)
    REFERENCES `lr`.`crm_roles` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `lr`.`ls_shoppingcenters`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lr`.`ls_shoppingcenters` ;

CREATE TABLE IF NOT EXISTS `lr`.`ls_shoppingcenters` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `Lat` FLOAT NULL DEFAULT NULL,
  `Lng` FLOAT NULL DEFAULT NULL,
  `address_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_address_id_unique` (`name` ASC, `address_id` ASC),
  INDEX `fk_addresses_shoppingcenters_idx` (`address_id` ASC),
  CONSTRAINT `fk_addresses_shoppingcenters`
    FOREIGN KEY (`address_id`)
    REFERENCES `lr`.`addr_addresses` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `lr`.`ls_shoppingcenterinfo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lr`.`ls_shoppingcenterinformations` ;

CREATE TABLE IF NOT EXISTS `lr`.`ls_shoppingcenterinformations` (
  `shoppingcenter_id` BIGINT NOT NULL,
  `description` LONGTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`shoppingcenter_id`),
  CONSTRAINT `fk_shoppingcenters_shoppingcenterinformations`
    FOREIGN KEY (`shoppingcenter_id`)
    REFERENCES `lr`.`ls_shoppingcenters` (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `lr`.`ls_rooms`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lr`.`ls_rooms` ;

CREATE TABLE IF NOT EXISTS `lr`.`ls_rooms` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `square` FLOAT NULL DEFAULT NULL,
  `shoppingcenter_id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_shoppingcenter_id_unique` (`name` ASC, `shoppingcenter_id` ASC),
  INDEX `fk_shoppingcenters_rooms_idx` (`shoppingcenter_id` ASC),
  INDEX `fk_users_rooms_idx` (`user_id` ASC),
  CONSTRAINT `fk_shoppingcenters_rooms`
    FOREIGN KEY (`shoppingcenter_id`)
    REFERENCES `lr`.`ls_shoppingcenters` (`id`),
  CONSTRAINT `fk_users_rooms`
    FOREIGN KEY (`user_id`)
    REFERENCES `lr`.`crm_users` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `lr`.`ls_leaseads`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lr`.`ls_leaseads` ;

CREATE TABLE IF NOT EXISTS `lr`.`ls_leaseads` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `price` FLOAT NULL DEFAULT NULL,
  `dateStartLease` DATETIME NULL DEFAULT NULL,
  `dateStopLease` DATETIME NULL DEFAULT NULL,
  `room_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `dateStopLease_room_id_unique` (`dateStopLease` ASC, `room_id` ASC),
  INDEX `fk_rooms_leaseads_idx` (`room_id` ASC),
  CONSTRAINT `fk_rooms_leaseads`
    FOREIGN KEY (`room_id`)
    REFERENCES `lr`.`ls_rooms` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `lr`.`ls_leaseads`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lr`.`ls_messages` ;

CREATE TABLE IF NOT EXISTS `lr`.`ls_messages` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `sender_id` BIGINT NULL DEFAULT NULL,
  `recipient_id` BIGINT NOT NULL,
  `leasead_id` BIGINT NULL DEFAULT NULL,
  `text` LONGTEXT NULL DEFAULT NULL,
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
    REFERENCES `lr`.`ls_leaseads` (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `lr`.`crm_images`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lr`.`crm_images` ;

CREATE TABLE IF NOT EXISTS `lr`.`crm_images` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `path` LONGTEXT NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `lr`.`ls_shoppingcenterimages`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lr`.`ls_shoppingcenterimages` ;

CREATE TABLE IF NOT EXISTS `lr`.`ls_shoppingcenterimages` (
  `image_id` BIGINT NOT NULL,
  `shoppingcenter_id` BIGINT NOT NULL,
  PRIMARY KEY (`image_id`),
  CONSTRAINT `fk_images_shoppingcenterimages`
    FOREIGN KEY (`image_id`)
    REFERENCES `lr`.`crm_images` (`id`),
  CONSTRAINT `fk_shoppingcenters_shoppingcenterimages`
    FOREIGN KEY (`shoppingcenter_id`)
    REFERENCES `lr`.`ls_shoppingcenters` (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `lr`.`ls_roomimages`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lr`.`ls_roomimages` ;

CREATE TABLE IF NOT EXISTS `lr`.`ls_roomimages` (
  `image_id` BIGINT NOT NULL,
  `room_id` BIGINT NOT NULL,
  PRIMARY KEY (`image_id`),
  CONSTRAINT `fk_images_roomimages`
    FOREIGN KEY (`image_id`)
    REFERENCES `lr`.`crm_images` (`id`),
  CONSTRAINT `fk_rooms_roomimages`
    FOREIGN KEY (`room_id`)
    REFERENCES `lr`.`ls_rooms` (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;