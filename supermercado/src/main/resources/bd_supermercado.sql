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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla supermercado.categoria: ~11 rows (aproximadamente)
DELETE FROM `categoria`;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` (`id`, `nombre`) VALUES
	(1, 'CARNE'),
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
	(12, 'Prueba');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;

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
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`),
  KEY `FK_producto_usuario` (`id_usuario`),
  KEY `FK_producto_categoria` (`id_categoria`),
  CONSTRAINT `FK_producto_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`),
  CONSTRAINT `FK_producto_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla supermercado.producto: ~15 rows (aproximadamente)
DELETE FROM `producto`;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` (`id`, `nombre`, `descripcion`, `imagen`, `precio`, `descuento`, `id_usuario`, `id_categoria`) VALUES
	(1, 'TurrÃ³n duro', 'TurrÃ³n duro, caja 250 g', 'https://supermercado.eroski.es/images/17930009.jpg', 10.95, 90, 2, 8),
	(2, 'Langostino crudo', 'Langostino crudo 35/42, caja 700 g', 'https://supermercado.eroski.es/images/16550501.jpg', 20, 70, 1, 2),
	(3, 'Vino Tinto', 'Vino Tinto Crianza, botella 75 cl\\r\\n', 'https://supermercado.eroski.es/images/2026631.jpg', 20, 70, 2, 9),
	(4, 'La gula del norte 430 g', 'Gulas del norte congeladas, bandeja 430 g', 'https://supermercado.eroski.es/images/19780345.jpg', 20, 70, 2, 2),
	(5, 'EL ALMENDRO, 280 g', 'Turrón crujiente de chocolate negro, tableta 280 g', 'https://supermercado.eroski.es/images/22615017.jpg', 20, 70, 2, 8),
	(6, 'BAQUÉ 2x250g', 'Café molido natural, pack', 'https://supermercado.eroski.es/images/2679173.jpg', 20, 70, 2, 8),
	(7, 'COOSUR', 'Aceite oliva virgen extra', 'https://supermercado.eroski.es/images/15923279.jpg', 20, 50, 2, 11),
	(8, 'SAN MIGUEL', 'Cerveza, pack 24x33 cl', 'https://supermercado.eroski.es/images/16514556.jpg', 20, 40, 2, 10),
	(9, 'ZÜ PREMIUM 2L', 'Zumo de naranja exprimido sin pulpa', 'https://supermercado.eroski.es/images/13899539.jpg', 20, 70, 2, 11),
	(10, 'CODORNIU2222', 'Cava Brut Reserva, botella 75 cl', 'https://supermercado.eroski.es/images/399691.jpg', 20, 50, 1, 9),
	(14, 'aaaa', 'aaaa', 'https://image.flaticon.com/icons/png/512/372/372627.png', 5.5, 0, 1, 5),
	(15, 'AAAAAe', 'AAAAAAAAAAAAAA', 'https://image.flaticon.com/icons/png/512/372/372627.png', 5, 10, 1, 3),
	(16, 'AAAAAAAAAA', 'EEEEEEEEE', 'https://image.flaticon.com/icons/png/512/372/372627.png', 25, 15, 2, 4),
	(17, 'prueba', 'prueba', 'https://image.flaticon.com/icons/png/512/372/372627.png', 42, 10, 1, 1),
	(18, 'aaaaaa', 'aaaaa', 'https://image.flaticon.com/icons/png/512/372/372627.png', 20, 12, 2, 7);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla supermercado.usuario: ~2 rows (aproximadamente)
DELETE FROM `usuario`;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id`, `nombre`, `password`, `id_rol`) VALUES
	(1, 'endika', '123456', 2),
	(2, 'admin', 'admin', 1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
