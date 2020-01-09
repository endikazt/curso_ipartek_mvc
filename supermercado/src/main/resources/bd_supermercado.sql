-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.1.72-community - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para supermercado
CREATE DATABASE IF NOT EXISTS `supermercado` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `supermercado`;

-- Volcando estructura para tabla supermercado.categoria
CREATE TABLE IF NOT EXISTS `categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla supermercado.categoria: ~12 rows (aproximadamente)
DELETE FROM `categoria`;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` (`id`, `nombre`) VALUES
	(1, 'CARNEa'),
	(2, 'PESCADO'),
	(3, 'FRUTAS'),
	(4, 'PANADERIA, BOLLERIA, Y PASTELERIA'),
	(5, 'CHARCUTERIA'),
	(6, 'VERDURAS Y HORTALIZAS'),
	(7, 'QUESOS'),
	(8, 'DULCES Y DESAYUNO'),
	(9, 'VINOS'),
	(10, 'CERVEZAS'),
	(11, 'ALIMENTACION'),
	(13, 'nueva2');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;

-- Volcando estructura para tabla supermercado.historico_producto_precio
CREATE TABLE IF NOT EXISTS `historico_producto_precio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_producto` int(11) DEFAULT NULL,
  `precio_antiguo` int(11) DEFAULT NULL,
  `precio_nuevo` int(11) DEFAULT NULL,
  `fecha` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK__producto` (`id_producto`),
  CONSTRAINT `FK__producto` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla supermercado.historico_producto_precio: ~0 rows (aproximadamente)
DELETE FROM `historico_producto_precio`;
/*!40000 ALTER TABLE `historico_producto_precio` DISABLE KEYS */;
INSERT INTO `historico_producto_precio` (`id`, `id_producto`, `precio_antiguo`, `precio_nuevo`, `fecha`) VALUES
	(1, 2, 20, 21, '2020-01-09 13:58:14');
/*!40000 ALTER TABLE `historico_producto_precio` ENABLE KEYS */;

-- Volcando estructura para tabla supermercado.producto
CREATE TABLE IF NOT EXISTS `producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) NOT NULL DEFAULT '0',
  `descripcion` varchar(150) NOT NULL DEFAULT '0',
  `imagen` varchar(250) NOT NULL DEFAULT '0',
  `precio` float NOT NULL DEFAULT '0',
  `descuento` int(3) NOT NULL DEFAULT '0',
  `id_usuario` int(11) DEFAULT NULL,
  `id_categoria` int(11) DEFAULT NULL,
  `fecha_baja` int(11) DEFAULT NULL,
  `fecha_alta` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_modificacion` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`),
  KEY `FK_producto_usuario` (`id_usuario`),
  KEY `FK_producto_categoria` (`id_categoria`),
  CONSTRAINT `FK_producto_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`),
  CONSTRAINT `FK_producto_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla supermercado.producto: ~18 rows (aproximadamente)
DELETE FROM `producto`;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` (`id`, `nombre`, `descripcion`, `imagen`, `precio`, `descuento`, `id_usuario`, `id_categoria`, `fecha_baja`, `fecha_alta`, `fecha_modificacion`) VALUES
	(1, 'TurrÃ³n duro', 'TurrÃ³n duro, caja 250 g', 'https://supermercado.eroski.es/images/17930009.jpg', 10.95, 90, 2, 8, NULL, '2020-01-09 13:42:33', '2020-01-09 13:42:34'),
	(2, 'Langostino crudo', 'Langostino crudo 35/42, caja 700 g', 'https://supermercado.eroski.es/images/16550501.jpg', 21, 70, 1, 2, NULL, '2020-01-09 13:42:34', '2020-01-09 13:58:14'),
	(3, 'Vino Tinto', 'Vino Tinto Crianza, botella 75 cl\\r\\n', 'https://supermercado.eroski.es/images/2026631.jpg', 20, 70, 2, 9, NULL, '2020-01-09 13:42:35', '2020-01-09 13:42:36'),
	(4, 'La gula del norte 430 g', 'Gulas del norte congeladas, bandeja 430 g', 'https://supermercado.eroski.es/images/19780345.jpg', 20, 70, 2, 2, NULL, '2020-01-09 13:42:36', '2020-01-09 13:42:37'),
	(5, 'EL ALMENDRO, 280 g', 'Turrón crujiente de chocolate negro, tableta 280 g', 'https://supermercado.eroski.es/images/22615017.jpg', 20, 70, 2, 8, NULL, '2020-01-09 13:42:37', '2020-01-09 13:42:38'),
	(6, 'BAQUÉ 2x250g', 'Café molido natural, pack', 'https://supermercado.eroski.es/images/2679173.jpg', 20, 70, 2, 8, NULL, '2020-01-09 13:42:38', '2020-01-09 13:42:38'),
	(7, 'COOSUR', 'Aceite oliva virgen extra', 'https://supermercado.eroski.es/images/15923279.jpg', 20, 50, 2, 11, NULL, '2020-01-09 13:42:39', '2020-01-09 13:42:39'),
	(8, 'SAN MIGUEL', 'Cerveza, pack 24x33 cl', 'https://supermercado.eroski.es/images/16514556.jpg', 20, 40, 2, 10, NULL, '2020-01-09 13:42:39', '2020-01-09 13:42:40'),
	(9, 'ZÜ PREMIUM 2L', 'Zumo de naranja exprimido sin pulpa', 'https://supermercado.eroski.es/images/13899539.jpg', 20, 70, 2, 11, NULL, '2020-01-09 13:42:40', '2020-01-09 13:42:41'),
	(10, 'CODORNIU2222', 'Cava Brut Reserva, botella 75 cl', 'https://supermercado.eroski.es/images/399691.jpg', 20, 50, 1, 9, NULL, '2020-01-09 13:42:41', '2020-01-09 13:42:41'),
	(14, 'aaaa', 'aaaa', 'https://image.flaticon.com/icons/png/512/372/372627.png', 5.5, 0, 1, 5, NULL, '2020-01-09 13:42:42', '2020-01-09 13:42:42'),
	(15, 'AAAAAe', 'AAAAAAAAAAAAAA', 'https://image.flaticon.com/icons/png/512/372/372627.png', 5, 10, 1, 3, NULL, '2020-01-09 13:42:42', '2020-01-09 13:42:43'),
	(16, 'AAAAAAAAAA', 'EEEEEEEEE', 'https://image.flaticon.com/icons/png/512/372/372627.png', 25, 15, 2, 4, NULL, '2020-01-09 13:42:43', '2020-01-09 13:42:44'),
	(17, 'prueba', 'prueba', 'https://image.flaticon.com/icons/png/512/372/372627.png', 42, 10, 1, 1, NULL, '2020-01-09 13:42:44', '2020-01-09 13:42:44'),
	(18, 'aaaaaa', 'aaaaa', 'https://image.flaticon.com/icons/png/512/372/372627.png', 20, 12, 2, 7, NULL, '2020-01-09 13:42:45', '2020-01-09 13:42:45'),
	(20, 'morcilla1', ':)', 'https://image.flaticon.com/icons/png/512/372/372627.png', 50, 0, 1, 1, NULL, '2020-01-09 13:42:45', '2020-01-09 13:42:46'),
	(21, 'morcilla2', ':)', 'https://image.flaticon.com/icons/png/512/372/372627.png', 50, 100, 1, 1, NULL, '2020-01-09 13:42:46', '2020-01-09 13:42:47'),
	(22, 'morcilla4', ':)', 'https://image.flaticon.com/icons/png/512/372/372627.png', 50, 100, 1, 1, NULL, '2020-01-09 13:42:47', '2020-01-09 13:43:07');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;

-- Volcando estructura para tabla supermercado.rol
CREATE TABLE IF NOT EXISTS `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla supermercado.rol: ~2 rows (aproximadamente)
DELETE FROM `rol`;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` (`id`, `nombre`) VALUES
	(1, 'ADMIN'),
	(2, 'USUARIO');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;

-- Volcando estructura para tabla supermercado.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `id_rol` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`),
  KEY `FK_usuario_rol` (`id_rol`),
  CONSTRAINT `FK_usuario_rol` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla supermercado.usuario: ~3 rows (aproximadamente)
DELETE FROM `usuario`;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id`, `nombre`, `password`, `id_rol`) VALUES
	(1, 'endika', '123456', 2),
	(2, 'admin', 'admin', 1),
	(4, 'prueba', 'prueba', 2);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

-- Volcando estructura para procedimiento supermercado.pa_categoria_delete
DELIMITER //
CREATE PROCEDURE `pa_categoria_delete`(
	IN `p_id` INT
)
BEGIN

DELETE FROM categoria WHERE id = p_id;

END//
DELIMITER ;

-- Volcando estructura para procedimiento supermercado.pa_categoria_getall
DELIMITER //
CREATE PROCEDURE `pa_categoria_getall`()
BEGIN

-- Muestra todas las categorias

SELECT id, nombre FROM categoria ORDER BY nombre ASC LIMIT 500;

END//
DELIMITER ;

-- Volcando estructura para procedimiento supermercado.pa_categoria_getbyid
DELIMITER //
CREATE PROCEDURE `pa_categoria_getbyid`(
	IN `p_id` INT
)
BEGIN

SELECT id, nombre FROM categoria WHERE id=p_id;

END//
DELIMITER ;

-- Volcando estructura para procedimiento supermercado.pa_categoria_insert
DELIMITER //
CREATE PROCEDURE `pa_categoria_insert`(
	IN `p_nombre` VARCHAR(100),
	OUT `p_id` INT
)
BEGIN

	-- Crear nuevo registro
	
	INSERT INTO categoria (nombre) VALUES (p_nombre);
	
	-- Obtener el ID generado
	
	SET p_id = LAST_INSERT_ID();
 	

END//
DELIMITER ;

-- Volcando estructura para procedimiento supermercado.pa_categoria_update
DELIMITER //
CREATE PROCEDURE `pa_categoria_update`(
	IN `p_id` INT,
	IN `p_nombre` VARCHAR(100)
)
BEGIN

	UPDATE categoria SET nombre= p_nombre WHERE id = p_id;

END//
DELIMITER ;

-- Volcando estructura para procedimiento supermercado.pa_producto_getallbycategoria
DELIMITER //
CREATE PROCEDURE `pa_producto_getallbycategoria`(
	IN `p_id` INT
)
BEGIN

SELECT id, nombre, descripcion, imagen, precio, descuento, id_usuario, id_categoria  FROM producto WHERE id_categoria=p_id;

END//
DELIMITER ;

-- Volcando estructura para procedimiento supermercado.pa_producto_getbycategoriaandsearchparam
DELIMITER //
CREATE PROCEDURE `pa_producto_getbycategoriaandsearchparam`(
	IN `p_id` INT,
	IN `p_searchParam` VARCHAR(150)
)
BEGIN

SELECT id, nombre, descripcion, imagen, precio, descuento, id_usuario, id_categoria  FROM producto WHERE id_categoria=p_id AND nombre LIKE p_searchParam;

END//
DELIMITER ;

-- Volcando estructura para función supermercado.HELLO_WORLD
DELIMITER //
CREATE FUNCTION `HELLO_WORLD`() RETURNS varchar(100) CHARSET utf8
BEGIN

RETURN "holaaaaaaaaaaaaaa";

END//
DELIMITER ;

-- Volcando estructura para función supermercado.HELLO_WORLD2
DELIMITER //
CREATE FUNCTION `HELLO_WORLD2`(
	`p_nombre` VARCHAR(100)
) RETURNS varchar(100) CHARSET utf8
BEGIN

	DECLARE nombre VARCHAR(100) DEFAULT('anonimo');
	
	IF(TRIM(p_nombre) != '') THEN
	
		SET nombre = TRIM(p_nombre);
	
	END IF;

	RETURN CONCAT("Hello"," ",nombre);

END//
DELIMITER ;

-- Volcando estructura para función supermercado.MES_FECHA
DELIMITER //
CREATE FUNCTION `MES_FECHA`(
	`p_fecha` DATE
) RETURNS varchar(50) CHARSET utf8
BEGIN
	
	DECLARE mesNombre VARCHAR(50);
	
	CASE MONTH(p_fecha)
		WHEN 1 THEN SET mesNombre = 'Enero';
		WHEN 2 THEN SET mesNombre = 'Febrero';
		WHEN 3 THEN SET mesNombre = 'Marzo';
		WHEN 4 THEN SET mesNombre = 'Abril';
		WHEN 5 THEN SET mesNombre = 'Mayo';
		WHEN 6 THEN SET mesNombre = 'Junio';
		WHEN 7 THEN SET mesNombre = 'Julio';
		WHEN 8 THEN SET mesNombre = 'Agosto';
		WHEN 9 THEN SET mesNombre = 'Septiembre';
		WHEN 10 THEN SET mesNombre = 'Octubre';
		WHEN 11 THEN SET mesNombre = 'Noviembre';
		WHEN 12 THEN SET mesNombre = 'Diciembre';
	END CASE;

	RETURN mesNombre;

END//
DELIMITER ;

-- Volcando estructura para disparador supermercado.tbi_producto
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `tbi_producto` BEFORE INSERT ON `producto` FOR EACH ROW BEGIN

	/**
	
		Comprueba si el descuento es menor que 0 o mayor que 100.
		En caso de que sea menor que 0, se pondra 0.
		En caso de que sea mayo que 100, se pondra 100.
	
	**/

	IF NEW.descuento < 0 THEN SET NEW.descuento = 0; END IF;
	IF NEW.descuento > 100 THEN SET NEW.descuento = 100; END IF;
	
	-- Inserta la fecha actual a la fecha de modificacion
	
	SET NEW.fecha_modificacion = CURRENT_TIMESTAMP();

END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Volcando estructura para disparador supermercado.tbu_producto
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `tbu_producto` BEFORE UPDATE ON `producto` FOR EACH ROW BEGIN

	/**
	
		Comprueba si el descuento es menor que 0 o mayor que 100.
		En caso de que sea menor que 0, se pondra 0.
		En caso de que sea mayo que 100, se pondra 100.
	
	**/
	
	IF NEW.descuento < 0 THEN SET NEW.descuento = 0; END IF;
	IF NEW.descuento > 100 THEN SET NEW.descuento = 100; END IF;
	
	-- Inserta en el campo de fecha_modificacion un timestamp de la fecha actual
	
	SET NEW.fecha_modificacion = CURRENT_TIMESTAMP();
	
	IF NEW.precio != OLD.precio THEN 
	INSERT INTO historico_producto_precio (id_producto, precio_antiguo, precio_nuevo) VALUES (NEW.id, OLD.precio, NEW.precio); END IF;

END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
