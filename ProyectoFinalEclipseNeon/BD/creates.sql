-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema proyectoFinal
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `proyectoFinal` ;

-- -----------------------------------------------------
-- Schema proyectoFinal
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `proyectoFinal` DEFAULT CHARACTER SET utf8 ;
USE `proyectoFinal` ;

-- -----------------------------------------------------
-- Table `proyectoFinal`.`PIEZAS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyectoFinal`.`PIEZAS` ;

CREATE TABLE IF NOT EXISTS `proyectoFinal`.`PIEZAS` (
  `CODIGO` VARCHAR(6) NOT NULL,
  `NOMBRE` VARCHAR(20) NOT NULL,
  `PRECIO` FLOAT NOT NULL,
  `DESCRIPCION` TEXT NULL,
  PRIMARY KEY (`CODIGO`),
  UNIQUE INDEX `CODIGO_UNIQUE` (`CODIGO` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyectoFinal`.`PROVEEDORES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyectoFinal`.`PROVEEDORES` ;

CREATE TABLE IF NOT EXISTS `proyectoFinal`.`PROVEEDORES` (
  `CODIGO` VARCHAR(6) NOT NULL,
  `NOMBRE` VARCHAR(20) NOT NULL,
  `APELLIDOS` VARCHAR(30) NOT NULL,
  `DIRECCION` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`CODIGO`),
  UNIQUE INDEX `CODIGO_UNIQUE` (`CODIGO` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyectoFinal`.`PROYECTOS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyectoFinal`.`PROYECTOS` ;

CREATE TABLE IF NOT EXISTS `proyectoFinal`.`PROYECTOS` (
  `CODIGO` VARCHAR(6) NOT NULL,
  `NOMBRE` VARCHAR(40) NOT NULL,
  `CIUDAD` VARCHAR(40) NULL,
  PRIMARY KEY (`CODIGO`),
  UNIQUE INDEX `CODIGO_UNIQUE` (`CODIGO` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyectoFinal`.`GESTION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyectoFinal`.`GESTION` ;

CREATE TABLE IF NOT EXISTS `proyectoFinal`.`GESTION` (
  `CANTIDAD` FLOAT NULL,
  `CODPIEZAS` VARCHAR(6) NOT NULL,
  `CODPROYECTO` VARCHAR(6) NOT NULL,
  `CODPROVEEDOR` VARCHAR(6) NOT NULL,
  PRIMARY KEY (`CODPIEZAS`, `CODPROYECTO`, `CODPROVEEDOR`),
  INDEX `fk_GESTION_PIEZAS1_idx` (`CODPIEZAS` ASC),
  INDEX `fk_GESTION_PROYECTOS1_idx` (`CODPROYECTO` ASC),
  INDEX `fk_GESTION_PROVEEDORES1_idx` (`CODPROVEEDOR` ASC),
  CONSTRAINT `fk_GESTION_PIEZAS1`
    FOREIGN KEY (`CODPIEZAS`)
    REFERENCES `proyectoFinal`.`PIEZAS` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_GESTION_PROYECTOS1`
    FOREIGN KEY (`CODPROYECTO`)
    REFERENCES `proyectoFinal`.`PROYECTOS` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_GESTION_PROVEEDORES1`
    FOREIGN KEY (`CODPROVEEDOR`)
    REFERENCES `proyectoFinal`.`PROVEEDORES` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
