DROP database carport_test;
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE =
        'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema carport
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `carport_test`;

-- -----------------------------------------------------
-- Schema carport
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `carport_test` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `carport_test`;

-- -----------------------------------------------------
-- Table `carport_test`.`materials`
-- -----------------------------------------------------

DROP TABLE IF EXISTS `carport_test`.`materials`;

CREATE TABLE IF NOT EXISTS `carport_test`.`materials`
(
    `materials_id` INT          NOT NULL,
    `name`         VARCHAR(100) NULL DEFAULT NULL,
    `length`       INT          NULL DEFAULT NULL,
    `amount`       INT          NULL DEFAULT '0',
    `description`  VARCHAR(100) NULL DEFAULT NULL,
    `unit`         VARCHAR(45)  NULL DEFAULT 'stk',
    PRIMARY KEY (`materials_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carport`.`measures`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carport_test`.`measures`;

CREATE TABLE IF NOT EXISTS `carport_test`.`measures`
(
    `measure_id` INT NOT NULL AUTO_INCREMENT,
    `length`     INT NULL DEFAULT NULL,
    `width`      INT NULL DEFAULT NULL,
    PRIMARY KEY (`measure_id`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 11
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carport`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carport_test`.`users`;

CREATE TABLE IF NOT EXISTS `carport_test`.`users`
(
    `user_id`     INT          NOT NULL AUTO_INCREMENT,
    `name`        VARCHAR(45)  NOT NULL,
    `email`       VARCHAR(90)  NOT NULL,
    `password`    VARCHAR(45)  NOT NULL,
    `role`        VARCHAR(20)  NOT NULL DEFAULT 'customer',
    `phonenumber` INT          NOT NULL,
    `address`     VARCHAR(100) NOT NULL,
    `zipcode`     INT          NOT NULL,
    PRIMARY KEY (`user_id`),
    UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 3
    DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `carport`.`orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carport_test`.`orders`;

CREATE TABLE IF NOT EXISTS `carport_test`.`orders`
(
    `order_id`         INT         NOT NULL AUTO_INCREMENT,
    `created`          TIMESTAMP   NULL DEFAULT CURRENT_TIMESTAMP,
    `price`            DOUBLE      NULL DEFAULT NULL,
    `user_id`          INT         NULL DEFAULT NULL,
    `customer_request` TINYINT     NULL DEFAULT NULL,
    `length`           DOUBLE      NULL DEFAULT NULL,
    `width`            DOUBLE      NULL DEFAULT NULL,
    `roof_type`        VARCHAR(45) NULL DEFAULT NULL,
    `tool_room_length` INT         NULL DEFAULT NULL,
    `tool_room:width`  INT         NULL DEFAULT NULL,
    `standard_id`      INT              DEFAULT NULL,
    PRIMARY KEY (`order_id`),
    UNIQUE INDEX `order_id` (`order_id` ASC) VISIBLE,
    INDEX `fk_orders_users_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `fk_orders_users`
        FOREIGN KEY (`user_id`)
            REFERENCES `carport_test`.`users` (`user_id`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 2
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carport`.`orderline`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carport_test`.`orderline`;

CREATE TABLE IF NOT EXISTS `carport_test`.`orderline`
(
    `order_id`         INT NOT NULL,
    `orderline_id`     INT NOT NULL AUTO_INCREMENT,
    `materials_id`     INT NOT NULL,
    `materials_length` INT NULL DEFAULT NULL,
    `quantity`         INT NOT NULL,
    PRIMARY KEY (`orderline_id`),
    INDEX `fk_orderline_orders1` (`order_id` ASC) VISIBLE,
    INDEX `fk_orderline_materials1_idx` (`materials_id` ASC) VISIBLE,
    CONSTRAINT `fk_orderline_materials1`
        FOREIGN KEY (`materials_id`)
            REFERENCES `carport_test`.`materials` (`materials_id`),
    CONSTRAINT `fk_orderline_orders1`
        FOREIGN KEY (`order_id`)
            REFERENCES `carport_test`.`orders` (`order_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `carport`.`standardcarport`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carport_test`.`standardcarport`;

CREATE TABLE IF NOT EXISTS `carport_test`.`standardcarport`
(
    `standard_id` INT  NOT NULL AUTO_INCREMENT,
    `name`        TEXT NULL DEFAULT NULL,
    `description` TEXT NULL DEFAULT NULL,
    `price`       INT  NULL DEFAULT NULL,
    PRIMARY KEY (`standard_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `carport`.`bomCalculator`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carport_test`.`bomCalculator` ;

CREATE TABLE IF NOT EXISTS `carport_test`.`bomCalculator` (
                                                         `bom_id` INT NOT NULL AUTO_INCREMENT,
                                                         `distance_Measure` FLOAT NOT NULL,
                                                         `screw_kvm` INT NOT NULL,
                                                         `post_length_for_amount` INT NOT NULL,
                                                         `screw_package_numbers` INT NOT NULL,
                                                         `minimum_number_of_posts` INT NOT NULL,
                                                         `max_number_of_posts` INT NOT NULL,
                                                         PRIMARY KEY (`bom_id`))
    ENGINE = InnoDB;


SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;

INSERT INTO `carport_test`.`bomcalculator` (`bom_id`, `distance_Measure`, `screw_kvm`, `post_length_for_amount`, `screw_package_numbers`,`minimum_number_of_posts`,`max_number_of_posts`)
VALUES ('1', '0.55', '13', '401', '200','4','6');

INSERT INTO `carport_test`.`standardcarport` (`standard_id`, `name`, `description`, `price`)
VALUES ('1', 'CARPORT ENKELT 3,00X4,80M CAR01 FLADT TAG',
        '3,00 x 4,80 mtr. H??jde; 2,25 mtr. Trykimpr??gnerede stolper og stern. Leveres med: s??m, skruer, beslag og plasttrapez tag m/bundskruer. NB! Leveres som Byg-selv s??t - usamlet, umalet og ubehandlet!',
        '4998');
INSERT INTO `carport_test`.`standardcarport` (`standard_id`, `name`, `description`, `price`)
VALUES ('2', 'CARPORT ENKELT 3,60X9,10M CRXL1HR MED REDSKABSRUM 3,20X3,55M',
        'Enkelt carport med h??j rejsning. 3,60 x 9,10 m. Extra lang model. 3,20 x 3,55 m. redskabsrum. H??jde; 3,05 m.. Trykimpr??gnerede stolper, stern og bekl??dning. Leveres med: S??m, skruer, beslag og betontagstenstag. Udf??rlig byggevejledning til carport og sp??r medf??lger. Betontagsten i sort med 30 ??rs garanti. NB! Leveres som Byg-selv s??t - usamlet og ubehandlet!',
        '29998');
INSERT INTO `carport_test`.`standardcarport` (`standard_id`, `name`, `description`, `price`)
VALUES ('3', 'CARPORT ENKELT 3,90X7,80M CPO01HR MED REDSKABSRUM 2,40X3,30M',
        'Enkelt carport meEnkelt carport med h??j rejsning. 3,90 x 7,80 m. Extra bred model. 3,30 x 2,40 mtr redskabsrum. H??jde; 3,10 mtr. Trykimpr??gnerede stolper, stern og bekl??dning. Leveres med: S??m, skruer, beslag og betontagstenstag. Udf??rlig byggevejledning til carport og sp??r medf??lger. Betontagsten i sort med 30 ??rs garanti. NB! Leveres som Byg-selv s??t - usamlet og ubehandlet!d h??j rejsning. 3,90 x 7,80 m.',
        '28998');
INSERT INTO `carport_test`.`standardcarport` (`standard_id`, `name`, `description`, `price`)
VALUES ('4', 'CARPORT ENKELT 3,60X5,40M CAR01H H??J REJSNING',
        '3,60 x 5,40 mtr. Uden redskabsrum Trykimpr??gnerede stolper & stern. Leveres med: S??m, skruer, beslag og betontagstenstag. Udf??rlig byggevejledning til carport og sp??r medf??lger. Betontagsten i sort med 30 ??rs garanti. NB! Leveres som Byg-selv s??t - usamlet og ubehandlet!',
        '18498');

INSERT INTO `carport_test`.`materials` (`materials_id`, `name`, `length`, `amount`, `description`)
VALUES ('1', '25x200 mm. trykimp. Br??dt 360  understernbr??dder til for & bag ende', '360', '4',
        'Tilsk??res ved montage');
INSERT INTO `carport_test`.`materials` (`materials_id`, `name`, `length`, `amount`, `description`)
VALUES ('2', '25x200 mm. trykimp. Br??dt 540 understernbr??dder til siderne', '540', '4', 'Tilsk??res ved montage');
INSERT INTO `carport_test`.`materials` (`materials_id`, `name`, `length`, `amount`, `description`)
VALUES ('3', '25x125mm. trykimp. Br??dt 360 oversternbr??dder til forenden', '360', '2', 'Tilsk??res ved montage');
INSERT INTO `carport_test`.`materials` (`materials_id`, `name`, `length`, `amount`, `description`)
VALUES ('4', '25x125mm. trykimp. Br??dt 540 oversternbr??dder til siderne', '540', '4', 'Tilsk??res ved montage');
INSERT INTO `carport_test`.`materials` (`materials_id`, `name`, `length`, `amount`, `description`)
VALUES ('5', '45x195 mm. sp??rtr?? ubh.', '0', '2', 'Remme i sider, sadles ned i stolper');
INSERT INTO `carport_test`.`materials` (`materials_id`, `name`, `length`, `description`)
VALUES ('6', '45x195 mm. sp??rtr?? ubh', '0', 'Sp??r, monteres p?? rem');
INSERT INTO `carport_test`.`materials` (`materials_id`, `name`, `length`, `description`)
VALUES ('7', '97x97 mm. trykimp. Stolpe 300', '300', 'nedgraves 90 cm i jord');
INSERT INTO `carport_test`.`materials` (`materials_id`, `name`, `length`, `amount`, `description`)
VALUES ('8', '19x100 mm. trykimp. Br??dt 540 vandbr??dt p?? stern i sider', '540', '4', 'Tilsk??res ved montage');
INSERT INTO `carport_test`.`materials` (`materials_id`, `name`, `length`, `amount`, `description`)
VALUES ('9', '19x100 mm. trykimp. Br??dt 360 vandbr??dt p?? stern i forende', '360', '2', 'Tilsk??res ved montage');
INSERT INTO `carport_test`.`materials` (`materials_id`, `name`, `description`)
VALUES ('10', 'Plastmo Ecolite bl??tonet', 'Tilsk??res ved montage');
INSERT INTO `carport_test`.`materials` (`materials_id`, `name`, `description`)
VALUES ('11', 'plastmo bundskruer 200 stk. 3 pakke Skruer til tagplader', '13 skruer per m2');
INSERT INTO `carport_test`.`materials` (`materials_id`, `name`, `length`, `amount`)
VALUES ('12', 'hulb??nd 1x20 mm. 10 mtr.  Til vindkryds p?? sp??r', '1000', '2');
INSERT INTO `carport_test`.`materials` (`materials_id`, `name`)
VALUES ('13', 'universal 190 mm h??jre  Til montering af sp??r p?? rem');
INSERT INTO `carport_test`.`materials` (`materials_id`, `name`)
VALUES ('14', 'universal 190 mm venstre Til montering af sp??r p?? rem');
INSERT INTO `carport_test`.`materials` (`materials_id`, `name`, `amount`)
VALUES ('15', '4,5 x 60 mm. skruer 200 stk. 1 Pakke Til montering af stern&vandbr??dt', '1');
INSERT INTO `carport_test`.`materials` (`materials_id`, `name`, `amount`)
VALUES ('16', '4,0 x 50 mm. beslagskruer 250', '1');
INSERT INTO `carport_test`.`materials` (`materials_id`, `name`, `description`)
VALUES ('17', 'br??ddebolt 10 x 120 mm. Til montering af rem p?? stolper', '2 per stolpe');
INSERT INTO `carport_test`.`materials` (`materials_id`, `name`, `description`)
VALUES ('18', 'firkantskiver 40x40x11mm Til montering af rem p?? stolper', '2 per stolpe');


INSERT INTO carport_test.measures (measure_id, length, width)
VALUES ('1', '240', '240');
INSERT INTO carport_test.measures (measure_id, length, width)
VALUES ('2', '270', '270');
INSERT INTO carport_test.measures (measure_id, length, width)
VALUES ('3', '300', '300');
INSERT INTO carport_test.measures (measure_id, length, width)
VALUES ('4', '330', '330');
INSERT INTO carport_test.measures (measure_id, length, width)
VALUES ('5', '360', '360');
INSERT INTO carport_test.measures (measure_id, length, width)
VALUES ('6', '390', '390');
INSERT INTO carport_test.measures (measure_id, length, width)
VALUES ('7', '420', '420');
INSERT INTO carport_test.measures (measure_id, length, width)
VALUES ('8', '450', '450');
INSERT INTO carport_test.measures (measure_id, length, width)
VALUES ('9', '480', '480');
INSERT INTO carport_test.measures (measure_id, length, width)
VALUES ('10', '510', '510');


INSERT INTO carport_test.measures (measure_id, length, width)
VALUES ('11', '540', '540');
INSERT INTO carport_test.measures (measure_id, length, width)
VALUES ('12', '570', '570');
INSERT INTO carport_test.measures (measure_id, length, width)
VALUES ('13', '600', '600');


INSERT INTO carport_test.measures (measure_id, length, width)
VALUES ('14', '630', '630');
INSERT INTO carport_test.measures (measure_id, length, width)
VALUES ('15', '660', '660');
INSERT INTO carport_test.measures (measure_id, length, width)
VALUES ('16', '690', '690');


INSERT INTO carport_test.measures (measure_id, length, width)
VALUES ('17', '720', '720');
INSERT INTO carport_test.measures (measure_id, length, width)
VALUES ('18', '750', '750');
INSERT INTO carport_test.measures (measure_id, length, width)
VALUES ('19', '780', '780');


UPDATE `carport_test`.`materials` SET `amount` = '6' WHERE (`materials_id` = '7');
UPDATE `carport_test`.`materials` SET `length` = '600' WHERE (`materials_id` = '10');
UPDATE `carport_test`.`materials` SET `amount` = '12' WHERE (`materials_id` = '17');
UPDATE `carport_test`.`materials` SET `amount` = '12' WHERE (`materials_id` = '18');
UPDATE `carport_test`.`materials` SET `unit` = 'pakke(r)' WHERE (`materials_id` = '11');
UPDATE `carport_test`.`materials` SET `unit` = 'ruller' WHERE (`materials_id` = '12');
UPDATE `carport_test`.`materials` SET `unit` = 'pakke(r)' WHERE (`materials_id` = '15');
UPDATE `carport_test`.`materials` SET `unit` = 'pakke(r)' WHERE (`materials_id` = '16');

UPDATE `carport_test`.`materials` SET `name` = 'Universal 190 mm venstre', `description` = 'Til montering af sp??r p?? rem' WHERE (`materials_id` = '14');
UPDATE `carport_test`.`materials` SET `name` = 'Universal 190 mm h??jre', `description` = 'Til montering af sp??r p?? rem' WHERE (`materials_id` = '13');
UPDATE `carport_test`.`materials` SET `name` = 'Hulb??nd 1x20 mm. 10 mtr.  ', `description` = 'Til vindkryds p?? sp??r' WHERE (`materials_id` = '12');
UPDATE `carport_test`.`materials` SET `name` = 'Plastmo bundskruer 200 stk.', `description` = 'Skruer til tagplader' WHERE (`materials_id` = '11');
UPDATE `carport_test`.`materials` SET `name` = '4, 5 x 60 mm. skruer 200 stk.', `description` = 'Til montering af stern&vandbr??dt' WHERE (`materials_id` = '15');
UPDATE `carport_test`.`materials` SET `name` = '4, 0 x 50 mm. beslagskruer 250 stk.', `description` = 'Til montering af universalbeslag + hulb??nd' WHERE (`materials_id` = '16');
UPDATE `carport_test`.`materials` SET `name` = 'Br??ddebolt 10 x 120 mm', `description` = 'Til montering af rem p?? stolper' WHERE (`materials_id` = '17');
UPDATE `carport_test`.`materials` SET `name` = 'Firkantskiver 40x40x11mm', `description` = 'Til montering af rem p?? stolper' WHERE (`materials_id` = '18');
UPDATE `carport_test`.`materials` SET `name` = '25x200 mm. trykimp. Br??dt', `description` = 'Understernbr??dder til for & bag ende' WHERE (`materials_id` = '1');
UPDATE `carport_test`.`materials` SET `name` = '25x200 mm. trykimp. Br??dt', `description` = 'Understernbr??dder til siderne' WHERE (`materials_id` = '2');
UPDATE `carport_test`.`materials` SET `name` = '25x125mm. trykimp. Br??dt', `description` = 'Oversternbr??dder til forenden' WHERE (`materials_id` = '3');
UPDATE `carport_test`.`materials` SET `name` = '25x125mm. trykimp. Br??dt', `description` = 'Oversternbr??dder til siderne' WHERE (`materials_id` = '4');
UPDATE `carport_test`.`materials` SET `name` = '19x100 mm. trykimp. Br??dt', `description` = 'Vandbr??dt p?? stern i sider' WHERE (`materials_id` = '8');
UPDATE `carport_test`.`materials` SET `name` = '97x97 mm. trykimp. Stolpe' WHERE (`materials_id` = '7');
UPDATE `carport_test`.`materials` SET `name` = '19x100 mm. trykimp. Br??dt ', `description` = 'Vandbr??dt p?? stern i forende' WHERE (`materials_id` = '9');
UPDATE `carport_test`.`materials` SET `description` = 'Tagplader monteres p?? sp??r' WHERE (`materials_id` = '10');



