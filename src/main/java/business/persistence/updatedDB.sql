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
                                                     `unit` VARCHAR(45) NULL DEFAULT NULL,
                                                     `description` VARCHAR(100) NULL DEFAULT NULL,
                                                     PRIMARY KEY (`materials_id`))
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
                                                 `name` VARCHAR(45) NOT NULL,
                                                 `email` VARCHAR(90) NOT NULL,
                                                 `password` VARCHAR(45) NOT NULL,
                                                 `role` VARCHAR(20) NOT NULL DEFAULT 'customer',
                                                 `phonenumber` INT NOT NULL,
                                                 `address` VARCHAR(100) NOT NULL,
                                                 `zipcode` INT NOT NULL,
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
                                                  `length` DOUBLE NULL DEFAULT NULL,
                                                  `width` DOUBLE NULL DEFAULT NULL,
                                                  `roof_type` VARCHAR(45) NULL DEFAULT NULL,
                                                  `tool_room_length` INT NULL DEFAULT NULL,
                                                  `tool_room:width` INT NULL DEFAULT NULL,
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
                                                     `orderline_id` INT NOT NULL AUTO_INCREMENT,
                                                     `quantity` INT NOT NULL,
                                                     `product_id` INT NOT NULL,
                                                     `materials_materials_id` INT NOT NULL,
                                                     PRIMARY KEY (`orderline_id`),
                                                     UNIQUE INDEX `product_id_UNIQUE` (`product_id` ASC) VISIBLE,
                                                     INDEX `fk_orderline_orders1` (`order_id` ASC) VISIBLE,
                                                     INDEX `fk_orderline_materials1_idx` (`materials_materials_id` ASC) VISIBLE,
                                                     CONSTRAINT `fk_orderline_materials1`
                                                         FOREIGN KEY (`materials_materials_id`)
                                                             REFERENCES `carport`.`materials` (`materials_id`),
                                                     CONSTRAINT `fk_orderline_orders1`
                                                         FOREIGN KEY (`order_id`)
                                                             REFERENCES `carport`.`orders` (`order_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carport`.`standardcarport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carport`.`standardcarport` (
                                                           `standard_id` INT NOT NULL AUTO_INCREMENT,
                                                           `name` TEXT(500) NULL DEFAULT NULL,
                                                           `description` TEXT(1000) NULL DEFAULT NULL,
                                                           `price` INT NULL DEFAULT NULL,
                                                           PRIMARY KEY (`standard_id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 1
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


UPDATE `carport`.`standardcarport` SET `description` = '3,00 x 4,80 mtr. Højde; 2,25 mtr. Trykimprægnerede stolper og stern. Leveres med: søm, skruer, beslag og plasttrapez tag m/bundskruer. NB! Leveres som Byg-selv sæt - usamlet, umalet og ubehandlet!' WHERE (`standard_id` = '1');
UPDATE `carport`.`standardcarport` SET `description` = '3,60 x 5,40 mtr. Uden redskabsrum Trykimprægnerede stolper & stern. Leveres med: Søm, skruer, beslag og betontagstenstag. Udførlig byggevejledning til carport og spær medfølger. Betontagsten i sort med 30 års garanti. NB! Leveres som Byg-selv sæt - usamlet og ubehandlet!' WHERE (`standard_id` = '2');
UPDATE `carport`.`standardcarport` SET `description` = 'Enkelt carport med høj rejsning. 3,60 x 9,10 m. Extra lang model. 3,20 x 3,55 m. redskabsrum. Højde; 3,05 m.. Trykimprægnerede stolper, stern og beklædning. Leveres med: Søm, skruer, beslag og betontagstenstag. Udførlig byggevejledning til carport og spær medfølger. Betontagsten i sort med 30 års garanti. NB! Leveres som Byg-selv sæt - usamlet og ubehandlet!' WHERE (`standard_id` = '3');
UPDATE `carport`.`standardcarport` SET `description` = 'Enkelt carport med høj rejsning. 3,90 x 7,80 m. Extra bred model. 3,30 x 2,40 mtr redskabsrum. Højde; 3,10 mtr. Trykimprægnerede stolper, stern og beklædning. Leveres med: Søm, skruer, beslag og betontagstenstag. Udførlig byggevejledning til carport og spær medfølger. Betontagsten i sort med 30 års garanti. NB! Leveres som Byg-selv sæt - usamlet og ubehandlet!' WHERE (`standard_id` = '4');



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


