-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema carport_test
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `carport_test` ;

-- -----------------------------------------------------
-- Schema carport_test
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `carport_test` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `carport_test` ;

-- -----------------------------------------------------
-- Table `carport_test`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carport_test`.`users` ;

CREATE TABLE IF NOT EXISTS `carport_test`.`users` (
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
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
