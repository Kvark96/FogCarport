-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema carport
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema carport
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `carport` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `carport` ;

-- -----------------------------------------------------
-- Table `carport`.`materials`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carport`.`materials` (
  `materials_id` INT NOT NULL,
  `name` VARCHAR(100) NULL DEFAULT NULL,
  `length` INT NULL DEFAULT NULL,
  `quantity` INT NULL DEFAULT NULL,
  `unit` VARCHAR(45) NULL DEFAULT NULL,
  `description` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`materials_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carport`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carport`.`users` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(90) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(20) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `carport`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carport`.`orders` (
  `ordre_id` INT NOT NULL,
  `created` TIMESTAMP NULL DEFAULT NULL,
  `orderline_id` INT NULL DEFAULT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  `user_id` INT NULL DEFAULT NULL,
  `customer_request` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`ordre_id`),
  UNIQUE INDEX `orderline_id_UNIQUE` (`orderline_id` ASC) VISIBLE,
  INDEX `fk_orders_users_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_orders_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `carport`.`users` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carport`.`orderline`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carport`.`orderline` (
  `order_id` INT NOT NULL,
  `orderline_id` INT NOT NULL AUTO_INCREMENT,
  `quantity` INT NOT NULL,
  `product_id` INT NOT NULL,
  PRIMARY KEY (`orderline_id`),
  UNIQUE INDEX `product_id_UNIQUE` (`product_id` ASC) VISIBLE,
  INDEX `fk_orderline_orders1` (`order_id` ASC) VISIBLE,
  CONSTRAINT `fk_orderline_orders1`
    FOREIGN KEY (`order_id`)
    REFERENCES `carport`.`orders` (`ordre_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carport`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carport`.`product` (
  `length` DOUBLE NULL DEFAULT NULL,
  `width` DOUBLE NULL DEFAULT NULL,
  `roof_type` VARCHAR(45) NULL DEFAULT NULL,
  `tool_room_length` DOUBLE NULL DEFAULT NULL,
  `tool_room_width` DOUBLE NULL DEFAULT NULL,
  `carport_id` INT NULL DEFAULT NULL,
  `product_id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`product_id`),
  UNIQUE INDEX `product_id_UNIQUE` (`product_id` ASC) VISIBLE,
  CONSTRAINT `fk_product_orderline1`
    FOREIGN KEY (`product_id`)
    REFERENCES `carport`.`orderline` (`product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carport`.`measures`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carport`.`measures` (
  `measure_id` INT NOT NULL AUTO_INCREMENT,
  `length` INT NULL,
  `width` INT NULL,
  PRIMARY KEY (`measure_id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;