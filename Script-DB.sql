-- JHD 
SET NAMES utf8mb4;
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

-- Validar y Crear Base  De Datos.
DROP DATABASE IF EXISTS `dbPortalBancario`;
CREATE DATABASE `dbPortalBancario`;

-- Seleccionar db para creacion he insercion de datos. 
USE dbPortalBancario;

-- Creacion de Tabla Usuario
CREATE TABLE IF NOT EXISTS `usuario`( 
	usuarios_id int PRIMARY KEY NOT NULL,
	user_name varchar(100) NOT NULL,
	password varchar(100) NOT NULL,
	nombre_apellido varchar(100) NOT NULL,
	cedula bigint(30) NOT NULL,
	telefono bigint(30) NOT NULL,
	bancos varchar(100) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Creacion de Tabla Bancos
CREATE TABLE `bancos`( 
	banco_id int PRIMARY KEY NOT NULL,
	nombre_banco varchar(100)NOT NULL,
	nit bigint(100)NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- Creacion de Tabla DeudasUsuario
CREATE TABLE  IF NOT EXISTS `deudas_usuario`( 
	deuda_id int PRIMARY KEY NOT NULL, 
	usuario_id int(10) NOT NULL, 
	banco_id int(10) NOT NULL,	
	valor_deuda bigint(100) NOT NULL,
	valor_pagado_deuda bigint(100) NOT NULL, 
	valor_restante_deuda bigint(100) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Creacion de Tabla DetalleDeuda
CREATE TABLE  IF NOT EXISTS `detalle_deuda`( 
	factura_id int PRIMARY KEY NOT NULL, 
	valor_pagado bigint(100),
	banco_id int(10) NOT NULL,
	fecha_pago DATE	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- Insertar Valores tabla Usuario
INSERT INTO `usuario`(
	usuarios_id,user_name,password,nombre_apellido,cedula,telefono,bancos) VALUES 
	(1,'titaMedia','123456','Tita Media',123456789,3102616455,'[1,2]'),
	(2,'jhd','654321','Johnson Torres',987654321,3102616444,'[3,4]'),
	(3,'otros','123','username',9999999,3102616433,'[2,4,5]')
;


-- Insertar Valores tabla Bacnos
INSERT INTO `bancos`(banco_id, nombre_banco, nit) 
VALUES (1,"BanColombia",1234567890),
	(2,	"Banco De Bogota",1234567891),
	(3,	"Banco Occidente",1234567892),
	(4,	"Davivienda",1234567893),
	(5,	"Mi Banco",	1234567894)	
;

-- Insertar Valores tabla DeudasUsuario
INSERT INTO `deudas_usuario`(
	deuda_id,usuario_id,banco_id,valor_deuda,valor_pagado_deuda,valor_restante_deuda
) VALUES (1,1,1,500000,50000,450000),
	(2,1,2,	600000,	300000,	600000),
	(3,2,4,	700000,	0, 700000),
	(4,2,3,	300000,	50000,	250000),
	(5,3,2,	700000,	0,	700000),
	(6,3,4,	300000,	50000,	250000),
	(7,3,5,	3000000,500000,	2500000)
;


-- Insertar Valores tabla DetalleDeuda 
INSERT INTO `detalle_deuda` (factura_id, banco_id, valor_pagado, fecha_pago ) 
VALUES (1,1,50000,'2022/05/10'),
	(2,2,150000,'2022/05/11'),
	(3,2,150000,'2022/05/12'),
	(4,3,50000,'2022/05/13'),
	(5,4,500000,'2022/05/14'),
	(6,5,500000,'2022/05/15')	
;
