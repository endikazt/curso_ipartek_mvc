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

-- Volcando estructura para tabla supermercado.producto
CREATE TABLE IF NOT EXISTS `producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) NOT NULL DEFAULT '0',
  `descripcion` varchar(150) NOT NULL DEFAULT '0',
  `imagen` varchar(250) NOT NULL DEFAULT '0',
  `precio` float NOT NULL DEFAULT '0',
  `descuento` int(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla supermercado.producto: ~10 rows (aproximadamente)
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` (`id`, `nombre`, `descripcion`, `imagen`, `precio`, `descuento`) VALUES
	(1, 'Turrón duro', 'Turrón duro, caja 250 g', 'https://supermercado.eroski.es/images/17930009.jpg', 10.95, 10),
	(2, 'Langostino crudo', 'Langostino crudo 35/42, caja 700 g', 'https://supermercado.eroski.es/images/16550501.jpg', 20, 70),
	(3, 'Vino Tinto', 'Vino Tinto Crianza, botella 75 cl\\r\\n', 'https://supermercado.eroski.es/images/2026631.jpg', 20, 70),
	(4, 'La gula del norte 430 g', 'Gulas del norte congeladas, bandeja 430 g', 'https://supermercado.eroski.es/images/19780345.jpg', 20, 70),
	(5, 'EL ALMENDRO, 280 g', 'Turrón crujiente de chocolate negro, tableta 280 g', 'https://supermercado.eroski.es/images/22615017.jpg', 20, 70),
	(6, 'BAQUÉ 2x250g', 'Café molido natural, pack', 'https://supermercado.eroski.es/images/2679173.jpg', 20, 70),
	(7, 'COOSUR', 'Aceite oliva virgen extra', 'https://supermercado.eroski.es/images/15923279.jpg', 20, 50),
	(8, 'SAN MIGUEL', 'Cerveza, pack 24x33 cl', 'https://supermercado.eroski.es/images/16514556.jpg', 20, 40),
	(9, 'ZÜ PREMIUM 2L', 'Zumo de naranja exprimido sin pulpa', 'https://supermercado.eroski.es/images/13899539.jpg', 20, 70),
	(10, 'CODORNIU', 'Cava Brut Reserva, botella 75 cl', 'https://supermercado.eroski.es/images/399691.jpg', 20, 50);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
