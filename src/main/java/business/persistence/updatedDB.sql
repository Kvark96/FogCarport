-- MySQL Workbench Forward Engineering


drop DATABASE carport;

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
                                                     `material_id` INT NOT NULL,
                                                     `name` VARCHAR(100) NULL DEFAULT NULL,
                                                     `length` INT NULL DEFAULT NULL,
                                                     `unit` VARCHAR(45) NULL DEFAULT NULL,
                                                     `description` VARCHAR(100) NULL DEFAULT NULL,
                                                     PRIMARY KEY (`material_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carport`.`measures`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carport`.`measures` (
                                                    `measure_id` INT NOT NULL AUTO_INCREMENT,
                                                    `length` INT NULL DEFAULT NULL,
                                                    `width` INT NULL DEFAULT NULL,
                                                    PRIMARY KEY (`measure_id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 1
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
    AUTO_INCREMENT = 1
    DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `carport`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carport`.`orders` (
                                                  `order_id` INT NOT NULL AUTO_INCREMENT,
                                                  `created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
                                                  `price` DOUBLE NULL DEFAULT NULL,
                                                  `user_id` INT NULL DEFAULT NULL,
                                                  `customer_request` TINYINT NULL DEFAULT NULL,
                                                  `length` INT NULL DEFAULT NULL,
                                                  `width` INT NULL DEFAULT NULL,
                                                  `roof_type` VARCHAR(45) NULL DEFAULT NULL,
                                                  `tool_room_length` INT NULL DEFAULT NULL,
                                                  `tool_room_width` INT NULL DEFAULT NULL,
                                                  PRIMARY KEY (`order_id`),
                                                  UNIQUE INDEX `order_id` (`order_id` ASC) VISIBLE,
                                                  INDEX `fk_orders_users_idx` (`user_id` ASC) VISIBLE,
                                                  CONSTRAINT `fk_orders_users`
                                                      FOREIGN KEY (`user_id`)
                                                          REFERENCES `carport`.`users` (`user_id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 1
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carport`.`orderline`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carport`.`orderline` (
                                                     `order_id` INT NOT NULL,
                                                     `orderline_id` INT NOT NULL,
                                                     `quantity` INT NOT NULL,
                                                     `materials_materials_id` INT NOT NULL,
                                                     PRIMARY KEY (`orderline_id`),
                                                     INDEX `fk_orderline_orders1` (`order_id` ASC) VISIBLE,
                                                     INDEX `fk_orderline_materials1_idx` (`materials_materials_id` ASC) VISIBLE,
                                                     CONSTRAINT `fk_orderline_materials1`
                                                         FOREIGN KEY (`materials_materials_id`)
                                                             REFERENCES `carport`.`materials` (`material_id`),
                                                     CONSTRAINT `fk_orderline_orders1`
                                                         FOREIGN KEY (`order_id`)
                                                             REFERENCES `carport`.`orders` (`order_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



INSERT INTO carport.measures (measure_id, length, width)
VALUES ('1', '150', '150');
INSERT INTO carport.measures (measure_id, length, width)
VALUES ('2', '200', '200');
INSERT INTO carport.measures (measure_id, length, width)
VALUES ('3', '250', '250');
INSERT INTO carport.measures (measure_id, length, width)
VALUES ('4', '300', '300');
INSERT INTO carport.measures (measure_id, length, width)
VALUES ('5', '350', '350');
INSERT INTO carport.measures (measure_id, length, width)
VALUES ('6', '400', '400');
INSERT INTO carport.measures (measure_id, length, width)
VALUES ('7', '450', '450');
INSERT INTO carport.measures (measure_id, length, width)
VALUES ('8', '500', '500');
INSERT INTO carport.measures (measure_id, length, width)
VALUES ('9', '550', '550');
INSERT INTO carport.measures (measure_id, length, width)
VALUES ('10', '600', '600');


