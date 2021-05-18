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
DROP SCHEMA IF EXISTS `carport` ;

-- -----------------------------------------------------
-- Schema carport
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `carport` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `carport` ;

-- -----------------------------------------------------
-- Table `carport`.`materials`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carport`.`materials` ;

CREATE TABLE IF NOT EXISTS `carport`.`materials` (
                                                     `materials_id` INT NOT NULL,
                                                     `name` VARCHAR(100) NULL DEFAULT NULL,
                                                     `length` INT NULL DEFAULT NULL,
                                                     `unit` INT NULL DEFAULT 0,
                                                     `description` VARCHAR(100) NULL DEFAULT NULL,
                                                     PRIMARY KEY (`materials_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carport`.`measures`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carport`.`measures` ;

CREATE TABLE IF NOT EXISTS `carport`.`measures` (
                                                    `measure_id` INT NOT NULL AUTO_INCREMENT,
                                                    `length` INT NULL DEFAULT NULL,
                                                    `width` INT NULL DEFAULT NULL,
                                                    PRIMARY KEY (`measure_id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 11
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carport`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carport`.`users` ;

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
    AUTO_INCREMENT = 3
    DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `carport`.`orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carport`.`orders` ;

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
    AUTO_INCREMENT = 2
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carport`.`orderline`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carport`.`orderline` ;

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
DROP TABLE IF EXISTS `carport`.`standardcarport` ;

CREATE TABLE IF NOT EXISTS `carport`.`standardcarport` (
                                                           `standard_id` INT NOT NULL AUTO_INCREMENT,
                                                           `name` TEXT NULL DEFAULT NULL,
                                                           `description` TEXT NULL DEFAULT NULL,
                                                           `price` INT NULL DEFAULT NULL,
                                                           PRIMARY KEY (`standard_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


UPDATE `carport`.`standardcarport` SET `description` = '3,00 x 4,80 mtr. Højde; 2,25 mtr. Trykimprægnerede stolper og stern. Leveres med: søm, skruer, beslag og plasttrapez tag m/bundskruer. NB! Leveres som Byg-selv sæt - usamlet, umalet og ubehandlet!' WHERE (`standard_id` = '1');
UPDATE `carport`.`standardcarport` SET `description` = '3,60 x 5,40 mtr. Uden redskabsrum Trykimprægnerede stolper & stern. Leveres med: Søm, skruer, beslag og betontagstenstag. Udførlig byggevejledning til carport og spær medfølger. Betontagsten i sort med 30 års garanti. NB! Leveres som Byg-selv sæt - usamlet og ubehandlet!' WHERE (`standard_id` = '2');
UPDATE `carport`.`standardcarport` SET `description` = 'Enkelt carport med høj rejsning. 3,60 x 9,10 m. Extra lang model. 3,20 x 3,55 m. redskabsrum. Højde; 3,05 m.. Trykimprægnerede stolper, stern og beklædning. Leveres med: Søm, skruer, beslag og betontagstenstag. Udførlig byggevejledning til carport og spær medfølger. Betontagsten i sort med 30 års garanti. NB! Leveres som Byg-selv sæt - usamlet og ubehandlet!' WHERE (`standard_id` = '3');
UPDATE `carport`.`standardcarport` SET `description` = 'Enkelt carport med høj rejsning. 3,90 x 7,80 m. Extra bred model. 3,30 x 2,40 mtr redskabsrum. Højde; 3,10 mtr. Trykimprægnerede stolper, stern og beklædning. Leveres med: Søm, skruer, beslag og betontagstenstag. Udførlig byggevejledning til carport og spær medfølger. Betontagsten i sort med 30 års garanti. NB! Leveres som Byg-selv sæt - usamlet og ubehandlet!' WHERE (`standard_id` = '4');

INSERT INTO `carport`.`materials` (`materials_id`, `name`, `length`, `unit`, `description`) VALUES ('1', '25x200 mm. trykimp. Brædt 360  understernbrædder til for & bag ende', '360', '4', 'Tilskæres ved montage');
INSERT INTO `carport`.`materials` (`materials_id`, `name`, `length`, `unit`, `description`) VALUES ('2', '25x200 mm. trykimp. Brædt 540 understernbrædder til siderne', '540', '4', 'Tilskæres ved montage');
INSERT INTO `carport`.`materials` (`materials_id`, `name`, `length`, `unit`, `description`) VALUES ('3', '25x125mm. trykimp. Brædt 360 oversternbrædder til forenden', '360', '2', 'Tilskæres ved montage');
INSERT INTO `carport`.`materials` (`materials_id`, `name`, `length`, `unit`, `description`) VALUES ('4', '25x125mm. trykimp. Brædt 540 oversternbrædder til siderne', '540', '4', 'Tilskæres ved montage');
INSERT INTO `carport`.`materials` (`materials_id`, `name`, `length`, `unit`, `description`) VALUES ('5', '45x195 mm. spærtræ ubh.', '0', '2', 'Remme i sider, sadles ned i stolper');
INSERT INTO `carport`.`materials` (`materials_id`, `name`, `length`, `description`) VALUES ('6', '45x195 mm. spærtræ ubh', '0',  'Spær, monteres på rem');
INSERT INTO `carport`.`materials` (`materials_id`, `name`, `length`, `description`) VALUES ('7', '97x97 mm. trykimp. Stolpe 300', '300', 'nedgraves 90 cm i jord');
INSERT INTO `carport`.`materials` (`materials_id`, `name`, `length`, `unit`, `description`) VALUES ('8', '19x100 mm. trykimp. Brædt 540 vandbrædt på stern i sider', '540', '4', 'Tilskæres ved montage');
INSERT INTO `carport`.`materials` (`materials_id`, `name`, `length`, `unit`, `description`) VALUES ('9', '19x100 mm. trykimp. Brædt 360 vandbrædt på stern i forende', '360', '2', 'Tilskæres ved montage');
INSERT INTO `carport`.`materials` (`materials_id`, `name`, `description`) VALUES ('10', 'Plastmo Ecolite blåtonet', 'Tilskæres ved montage');
INSERT INTO `carport`.`materials` (`materials_id`, `name`, `description`) VALUES ('11', 'plastmo bundskruer 200 stk. 3 pakke Skruer til tagplader', '13 skruer per m2');
INSERT INTO `carport`.`materials` (`materials_id`, `name`, `length`, `unit`) VALUES ('12', 'hulbånd 1x20 mm. 10 mtr.  Til vindkryds på spær', '1000', '2');
INSERT INTO `carport`.`materials` (`materials_id`, `name`) VALUES ('13', 'universal 190 mm højre  Til montering af spær på rem');
INSERT INTO `carport`.`materials` (`materials_id`, `name`) VALUES ('14', 'universal 190 mm venstre Til montering af spær på rem');
INSERT INTO `carport`.`materials` (`materials_id`, `name`, `unit`) VALUES ('15', '4,5 x 60 mm. skruer 200 stk. 1 Pakke Til montering af stern&vandbrædt', '1');
INSERT INTO `carport`.`materials` (`materials_id`, `name`, `unit`) VALUES ('16', '4,0 x 50 mm. beslagskruer 250', '1');
INSERT INTO `carport`.`materials` (`materials_id`, `name`, `description`) VALUES ('17', 'bræddebolt 10 x 120 mm. Til montering af rem på stolper', '2 per stolpe');
INSERT INTO `carport`.`materials` (`materials_id`, `name`, `description`) VALUES ('18', 'firkantskiver 40x40x11mm Til montering af rem på stolper', '2 per stolpe');


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

UPDATE `carport`.`materials` SET `unit` = '6' WHERE (`materials_id` = '7');
UPDATE `carport`.`materials` SET `length` = '600' WHERE (`materials_id` = '10');
UPDATE `carport`.`materials` SET `unit` = '12' WHERE (`materials_id` = '17');
UPDATE `carport`.`materials` SET `unit` = '12' WHERE (`materials_id` = '18');

