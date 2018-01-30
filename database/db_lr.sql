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
  `Name` VARCHAR(255) NOT NULL,
  `Password` VARCHAR(1023) NOT NULL,
  `PhoneNumber` VARCHAR(255) NULL DEFAULT NULL,
  `Email` VARCHAR(255) NOT NULL,
  `EmailConfirmed` TINYINT(1) NOT NULL DEFAULT '0',
  `Roleid` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `Email_UNIQUE` ON `lr`.`crm_users` (`Email` ASC);

CREATE INDEX `Roleid` ON `lr`.`crm_users` (`Roleid` ASC);


-- -----------------------------------------------------
-- Table `lr`.`ls_shoppingcenters`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lr`.`ls_shoppingcenters` ;

CREATE TABLE IF NOT EXISTS `lr`.`ls_shoppingcenters` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(255) NOT NULL,
  `Addressid` BIGINT NOT NULL,
  `Lat` FLOAT NULL DEFAULT NULL,
  `Lng` FLOAT NULL DEFAULT NULL,
  `Description` LONGTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `Name_Addressid_UNIQUE` ON `lr`.`ls_shoppingcenters` (`Name` ASC, `Addressid` ASC);

CREATE INDEX `FK_Addresses_ShoppingCenters_idx` ON `lr`.`ls_shoppingcenters` (`Addressid` ASC);


-- -----------------------------------------------------
-- Table `lr`.`ls_rooms`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lr`.`ls_rooms` ;

CREATE TABLE IF NOT EXISTS `lr`.`ls_rooms` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(255) NOT NULL,
  `Square` FLOAT NULL DEFAULT NULL,
  `ShoppingCenterid` BIGINT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `Name_ShoppingCenterid_UNIQUE` ON `lr`.`ls_rooms` (`Name` ASC, `ShoppingCenterid` ASC);

CREATE INDEX `FK_ShoppingCenters_Rooms_idx` ON `lr`.`ls_rooms` (`ShoppingCenterid` ASC);


-- -----------------------------------------------------
-- Table `lr`.`ls_leaserooms`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lr`.`ls_leaserooms` ;

CREATE TABLE IF NOT EXISTS `lr`.`ls_leaserooms` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `Price` FLOAT NULL DEFAULT NULL,
  `DateStartLease` DATETIME NULL DEFAULT NULL,
  `DateStopLease` DATETIME NULL DEFAULT NULL,
  `Roomid` BIGINT NOT NULL,
  `Userid` BIGINT NOT NULL COMMENT 'owner of room',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `FK_Rooms_LeaseRooms_idx` ON `lr`.`ls_leaserooms` (`Roomid` ASC);

CREATE INDEX `FK_Users_LeaseRooms_idx` ON `lr`.`ls_leaserooms` (`Userid` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
