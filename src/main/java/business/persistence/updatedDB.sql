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

                                                     `amount` INT NULL DEFAULT '0',

                                                     `description` VARCHAR(100) NULL DEFAULT NULL,
                                                     `unit` VARCHAR(45) NULL DEFAULT 'stk',
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
    AUTO_INCREMENT = 11
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
    DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `carport`.`standardcarport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carport`.`standardcarport` (
                                                           `standard_id` INT NOT NULL AUTO_INCREMENT,
                                                           `name` TEXT NULL DEFAULT NULL,
                                                           `description` TEXT NULL DEFAULT NULL,
                                                           `price` INT NULL DEFAULT NULL,
                                                           PRIMARY KEY (`standard_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


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
                                                  `standard_id` INT NOT NULL,
                                                  PRIMARY KEY (`order_id`),
                                                  UNIQUE INDEX `order_id` (`order_id` ASC) VISIBLE,
                                                  INDEX `fk_orders_users_idx` (`user_id` ASC) VISIBLE,
                                                  INDEX `fk_orders_standardcarport1_idx` (`standard_id` ASC) VISIBLE,
                                                  CONSTRAINT `fk_orders_users`
                                                      FOREIGN KEY (`user_id`)
                                                          REFERENCES `carport`.`users` (`user_id`),
                                                  CONSTRAINT `fk_orders_standardcarport1`
                                                      FOREIGN KEY (`standard_id`)
                                                          REFERENCES `carport`.`standardcarport` (`standard_id`)
                                                          ON DELETE NO ACTION
                                                          ON UPDATE NO ACTION)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carport`.`orderline`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carport`.`orderline` (
                                                     `order_id` INT NOT NULL,
                                                     `orderline_id` INT NOT NULL AUTO_INCREMENT,
                                                     `materials_materials_id` INT NOT NULL,
                                                     `materials_length` INT NULL DEFAULT NULL,
                                                     `materials_unit` INT NOT NULL,
                                                     PRIMARY KEY (`orderline_id`),
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


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


INSERT INTO `carport`.`standardcarport` (`standard_id`, `name`, `description`, `price`) VALUES ('1', 'CARPORT ENKELT 3,00X4,80M CAR01 FLADT TAG', '3,00 x 4,80 mtr. Højde; 2,25 mtr. Trykimprægnerede stolper og stern. Leveres med: søm, skruer, beslag og plasttrapez tag m/bundskruer. NB! Leveres som Byg-selv sæt - usamlet, umalet og ubehandlet!', '4998');
INSERT INTO `carport`.`standardcarport` (`standard_id`, `name`, `description`, `price`) VALUES ('2', 'CARPORT ENKELT 3,60X9,10M CRXL1HR MED REDSKABSRUM 3,20X3,55M', 'Enkelt carport med høj rejsning. 3,60 x 9,10 m. Extra lang model. 3,20 x 3,55 m. redskabsrum. Højde; 3,05 m.. Trykimprægnerede stolper, stern og beklædning. Leveres med: Søm, skruer, beslag og betontagstenstag. Udførlig byggevejledning til carport og spær medfølger. Betontagsten i sort med 30 års garanti. NB! Leveres som Byg-selv sæt - usamlet og ubehandlet!', '29998');
INSERT INTO `carport`.`standardcarport` (`standard_id`, `name`, `description`, `price`) VALUES ('3', 'CARPORT ENKELT 3,90X7,80M CPO01HR MED REDSKABSRUM 2,40X3,30M', 'Enkelt carport meEnkelt carport med høj rejsning. 3,90 x 7,80 m. Extra bred model. 3,30 x 2,40 mtr redskabsrum. Højde; 3,10 mtr. Trykimprægnerede stolper, stern og beklædning. Leveres med: Søm, skruer, beslag og betontagstenstag. Udførlig byggevejledning til carport og spær medfølger. Betontagsten i sort med 30 års garanti. NB! Leveres som Byg-selv sæt - usamlet og ubehandlet!d høj rejsning. 3,90 x 7,80 m.', '28998');
INSERT INTO `carport`.`standardcarport` (`standard_id`, `name`, `description`, `price`) VALUES ('4', 'CARPORT ENKELT 3,60X5,40M CAR01H HØJ REJSNING', '3,60 x 5,40 mtr. Uden redskabsrum Trykimprægnerede stolper & stern. Leveres med: Søm, skruer, beslag og betontagstenstag. Udførlig byggevejledning til carport og spær medfølger. Betontagsten i sort med 30 års garanti. NB! Leveres som Byg-selv sæt - usamlet og ubehandlet!', '18498');

INSERT INTO `carport`.`materials` (`materials_id`, `name`, `length`, `amount`, `description`) VALUES ('1', '25x200 mm. trykimp. Brædt 360  understernbrædder til for & bag ende', '360', '4', 'Tilskæres ved montage');
INSERT INTO `carport`.`materials` (`materials_id`, `name`, `length`, `amount`, `description`) VALUES ('2', '25x200 mm. trykimp. Brædt 540 understernbrædder til siderne', '540', '4', 'Tilskæres ved montage');
INSERT INTO `carport`.`materials` (`materials_id`, `name`, `length`, `amount`, `description`) VALUES ('3', '25x125mm. trykimp. Brædt 360 oversternbrædder til forenden', '360', '2', 'Tilskæres ved montage');
INSERT INTO `carport`.`materials` (`materials_id`, `name`, `length`, `amount`, `description`) VALUES ('4', '25x125mm. trykimp. Brædt 540 oversternbrædder til siderne', '540', '4', 'Tilskæres ved montage');
INSERT INTO `carport`.`materials` (`materials_id`, `name`, `length`, `amount`, `description`) VALUES ('5', '45x195 mm. spærtræ ubh.', '0', '2', 'Remme i sider, sadles ned i stolper');
INSERT INTO `carport`.`materials` (`materials_id`, `name`, `length`, `description`) VALUES ('6', '45x195 mm. spærtræ ubh', '0',  'Spær, monteres på rem');
INSERT INTO `carport`.`materials` (`materials_id`, `name`, `length`, `description`) VALUES ('7', '97x97 mm. trykimp. Stolpe 300', '300', 'nedgraves 90 cm i jord');
INSERT INTO `carport`.`materials` (`materials_id`, `name`, `length`, `amount`, `description`) VALUES ('8', '19x100 mm. trykimp. Brædt 540 vandbrædt på stern i sider', '540', '4', 'Tilskæres ved montage');
INSERT INTO `carport`.`materials` (`materials_id`, `name`, `length`, `amount`, `description`) VALUES ('9', '19x100 mm. trykimp. Brædt 360 vandbrædt på stern i forende', '360', '2', 'Tilskæres ved montage');
INSERT INTO `carport`.`materials` (`materials_id`, `name`, `description`) VALUES ('10', 'Plastmo Ecolite blåtonet', 'Tilskæres ved montage');
INSERT INTO `carport`.`materials` (`materials_id`, `name`, `description`) VALUES ('11', 'plastmo bundskruer 200 stk. 3 pakke Skruer til tagplader', '13 skruer per m2');
INSERT INTO `carport`.`materials` (`materials_id`, `name`, `length`, `amount`) VALUES ('12', 'hulbånd 1x20 mm. 10 mtr.  Til vindkryds på spær', '1000', '2');
INSERT INTO `carport`.`materials` (`materials_id`, `name`) VALUES ('13', 'universal 190 mm højre  Til montering af spær på rem');
INSERT INTO `carport`.`materials` (`materials_id`, `name`) VALUES ('14', 'universal 190 mm venstre Til montering af spær på rem');
INSERT INTO `carport`.`materials` (`materials_id`, `name`, `amount`) VALUES ('15', '4,5 x 60 mm. skruer 200 stk. 1 Pakke Til montering af stern&vandbrædt', '1');
INSERT INTO `carport`.`materials` (`materials_id`, `name`, `amount`) VALUES ('16', '4,0 x 50 mm. beslagskruer 250', '1');
INSERT INTO `carport`.`materials` (`materials_id`, `name`, `description`) VALUES ('17', 'bræddebolt 10 x 120 mm. Til montering af rem på stolper', '2 per stolpe');
INSERT INTO `carport`.`materials` (`materials_id`, `name`, `description`) VALUES ('18', 'firkantskiver 40x40x11mm Til montering af rem på stolper', '2 per stolpe');

INSERT INTO `carport`.`measures` (`length`, `width`) VALUES ('240', '240');
INSERT INTO `carport`.`measures` (`length`, `width`) VALUES ('270', '270');
INSERT INTO `carport`.`measures` (`length`, `width`) VALUES ('300', '300');
INSERT INTO `carport`.`measures` (`length`, `width`) VALUES ('330', '330');
INSERT INTO `carport`.`measures` (`length`, `width`) VALUES ('360', '360');
INSERT INTO `carport`.`measures` (`length`, `width`) VALUES ('390', '390');
INSERT INTO `carport`.`measures` (`length`, `width`) VALUES ('420', '420');
INSERT INTO `carport`.`measures` (`length`, `width`) VALUES ('450', '450');
INSERT INTO `carport`.`measures` (`length`, `width`) VALUES ('480', '480');
INSERT INTO `carport`.`measures` (`length`, `width`) VALUES ('510', '510');
INSERT INTO `carport`.`measures` (`length`, `width`) VALUES ('540', '540');
INSERT INTO `carport`.`measures` (`length`, `width`) VALUES ('570', '570');
INSERT INTO `carport`.`measures` (`length`, `width`) VALUES ('600', '600');
INSERT INTO `carport`.`measures` (`length`, `width`) VALUES ('630', '630');
INSERT INTO `carport`.`measures` (`length`, `width`) VALUES ('660', '660');
INSERT INTO `carport`.`measures` (`length`, `width`) VALUES ('690', '690');
INSERT INTO `carport`.`measures` (`length`, `width`) VALUES ('720', '720');
INSERT INTO `carport`.`measures` (`length`, `width`) VALUES ('750', '750');
INSERT INTO `carport`.`measures` (`length`, `width`) VALUES ('780', '780');

UPDATE `carport`.`materials` SET `amount` = '6' WHERE (`materials_id` = '7');
UPDATE `carport`.`materials` SET `length` = '600' WHERE (`materials_id` = '10');
UPDATE `carport`.`materials` SET `amount` = '12' WHERE (`materials_id` = '17');
UPDATE `carport`.`materials` SET `amount` = '12' WHERE (`materials_id` = '18');
UPDATE `carport`.`materials` SET `unit` = 'pakke(r)' WHERE (`materials_id` = '11');
UPDATE `carport`.`materials` SET `unit` = 'ruller' WHERE (`materials_id` = '12');
UPDATE `carport`.`materials` SET `unit` = 'pakke(r)' WHERE (`materials_id` = '15');
UPDATE `carport`.`materials` SET `unit` = 'pakke(r)' WHERE (`materials_id` = '16');

UPDATE `carport`.`materials` SET `name` = 'Universal 190 mm venstre', `description` = 'Til montering af spær på rem' WHERE (`materials_id` = '14');
UPDATE `carport`.`materials` SET `name` = 'Universal 190 mm højre', `description` = 'Til montering af spær på rem' WHERE (`materials_id` = '13');
UPDATE `carport`.`materials` SET `name` = 'Hulbånd 1x20 mm. 10 mtr.  ', `description` = 'Til vindkryds på spær' WHERE (`materials_id` = '12');
UPDATE `carport`.`materials` SET `name` = 'Plastmo bundskruer 200 stk.', `description` = 'Skruer til tagplader' WHERE (`materials_id` = '11');
UPDATE `carport`.`materials` SET `name` = '4,5 x 60 mm. skruer 200 stk.', `description` = 'Til montering af stern&vandbrædt' WHERE (`materials_id` = '15');
UPDATE `carport`.`materials` SET `name` = '4,0 x 50 mm. beslagskruer 250 stk.', `description` = 'Til montering af universalbeslag + hulbånd' WHERE (`materials_id` = '16');
UPDATE `carport`.`materials` SET `name` = 'Bræddebolt 10 x 120 mm', `description` = 'Til montering af rem på stolper' WHERE (`materials_id` = '17');
UPDATE `carport`.`materials` SET `name` = 'Firkantskiver 40x40x11mm', `description` = 'Til montering af rem på stolper' WHERE (`materials_id` = '18');
UPDATE `carport`.`materials` SET `name` = '25x200 mm. trykimp. Brædt', `description` = 'Understernbrædder til for & bag ende' WHERE (`materials_id` = '1');
UPDATE `carport`.`materials` SET `name` = '25x200 mm. trykimp. Brædt', `description` = 'Understernbrædder til siderne' WHERE (`materials_id` = '2');
UPDATE `carport`.`materials` SET `name` = '25x125mm. trykimp. Brædt', `description` = 'Oversternbrædder til forenden' WHERE (`materials_id` = '3');
UPDATE `carport`.`materials` SET `name` = '25x125mm. trykimp. Brædt', `description` = 'Oversternbrædder til siderne' WHERE (`materials_id` = '4');
UPDATE `carport`.`materials` SET `name` = '19x100 mm. trykimp. Brædt', `description` = 'Vandbrædt på stern i sider' WHERE (`materials_id` = '8');
UPDATE `carport`.`materials` SET `name` = '97x97 mm. trykimp. Stolpe' WHERE (`materials_id` = '7');
UPDATE `carport`.`materials` SET `name` = '19x100 mm. trykimp. Brædt ', `description` = 'Vandbrædt på stern i forende' WHERE (`materials_id` = '9');
UPDATE `carport`.`materials` SET `description` = 'Tagplader monteres på spær' WHERE (`materials_id` = '10');


