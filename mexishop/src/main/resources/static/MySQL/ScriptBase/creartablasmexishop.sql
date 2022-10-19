-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mexishop2db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mexishop2db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mexishop2db` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
USE `mexishop2db` ;

-- -----------------------------------------------------
-- Table `mexishop2db`.`categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mexishop2db`.`categorias` (
  `cate_id` INT NOT NULL AUTO_INCREMENT,
  `nombre_cat` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cate_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mexishop2db`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mexishop2db`.`usuarios` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `tel` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `contrasena` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mexishop2db`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mexishop2db`.`producto` (
  `product_id` INT NOT NULL,
  `prod_nombr` VARCHAR(100) NOT NULL,
  `prod_link` VARCHAR(100) NOT NULL,
  `prod_desc` VARCHAR(500) NOT NULL,
  `inventario_cant` INT NOT NULL,
  `categorias_cate_id` INT NOT NULL,
  `precio_prod` INT NOT NULL,
  PRIMARY KEY (`product_id`, `categorias_cate_id`),
  INDEX `fk_producto_categorias1_idx` (`categorias_cate_id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mexishop2db`.`compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mexishop2db`.`compra` (
  `idcompra` INT NOT NULL AUTO_INCREMENT,
  `total_compra` INT NULL,
  `usuarios_user_id` INT NOT NULL,
  PRIMARY KEY (`idcompra`, `usuarios_user_id`),
  INDEX `fk_compra_usuarios1_idx` (`usuarios_user_id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mexishop2db`.`prod_compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mexishop2db`.`prod_compra` (
  `idprod_compra` INT NOT NULL AUTO_INCREMENT,
  `compra_idcompra` INT NOT NULL,
  `compra_usuarios_user_id` INT NOT NULL,
  `producto_product_id` INT NOT NULL,
  `producto_categorias_cate_id` INT NOT NULL,
  PRIMARY KEY (`idprod_compra`, `compra_idcompra`, `compra_usuarios_user_id`, `producto_product_id`, `producto_categorias_cate_id`),
  INDEX `fk_prod_compra_compra1_idx` (`compra_idcompra` ASC, `compra_usuarios_user_id` ASC) VISIBLE,
  INDEX `fk_prod_compra_producto1_idx` (`producto_product_id` ASC, `producto_categorias_cate_id` ASC) VISIBLE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
