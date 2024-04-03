-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.30 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para correlativas
CREATE DATABASE IF NOT EXISTS `correlativas` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `correlativas`;

-- Volcando estructura para tabla correlativas.alumno
CREATE TABLE IF NOT EXISTS `alumno` (
  `legajo` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`legajo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla correlativas.alumno: ~1 rows (aproximadamente)
INSERT INTO `alumno` (`legajo`, `nombre`) VALUES
	(1, 'Elias Puddini');

-- Volcando estructura para tabla correlativas.alumno_materias_hechas
CREATE TABLE IF NOT EXISTS `alumno_materias_hechas` (
  `alumno_legajo` bigint NOT NULL,
  `materias_hechas_id` bigint NOT NULL,
  UNIQUE KEY `UK_i9v1liosym35x98p3ev9sbpaa` (`materias_hechas_id`),
  KEY `FKltd9g1a93oh9xmx5rl6ylpetl` (`alumno_legajo`),
  CONSTRAINT `FKjbbptjoc8yykibu64p5wa0tfk` FOREIGN KEY (`materias_hechas_id`) REFERENCES `materia` (`id`),
  CONSTRAINT `FKltd9g1a93oh9xmx5rl6ylpetl` FOREIGN KEY (`alumno_legajo`) REFERENCES `alumno` (`legajo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla correlativas.alumno_materias_hechas: ~8 rows (aproximadamente)
INSERT INTO `alumno_materias_hechas` (`alumno_legajo`, `materias_hechas_id`) VALUES
	(1, 1),
	(1, 2),
	(1, 3),
	(1, 4),
	(1, 5),
	(1, 6),
	(1, 7),
	(1, 8);

-- Volcando estructura para tabla correlativas.inscripcion
CREATE TABLE IF NOT EXISTS `inscripcion` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `alumno_legajo` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb56g1craqxhlquwpm5ah5t6si` (`alumno_legajo`),
  CONSTRAINT `FKb56g1craqxhlquwpm5ah5t6si` FOREIGN KEY (`alumno_legajo`) REFERENCES `alumno` (`legajo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla correlativas.inscripcion: ~1 rows (aproximadamente)
INSERT INTO `inscripcion` (`id`, `alumno_legajo`) VALUES
	(1, 1);

-- Volcando estructura para tabla correlativas.inscripcion_materias
CREATE TABLE IF NOT EXISTS `inscripcion_materias` (
  `inscripcion_id` bigint NOT NULL,
  `materias_id` bigint NOT NULL,
  UNIQUE KEY `UK_75q2tukrq0bdga6wycvvn7jke` (`materias_id`),
  KEY `FK6o592c9u9qerh6305dn6fjj9c` (`inscripcion_id`),
  CONSTRAINT `FK6o592c9u9qerh6305dn6fjj9c` FOREIGN KEY (`inscripcion_id`) REFERENCES `inscripcion` (`id`),
  CONSTRAINT `FKd2lxqhdx4e5myalhy7d3tvpfn` FOREIGN KEY (`materias_id`) REFERENCES `materia` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla correlativas.inscripcion_materias: ~1 rows (aproximadamente)
INSERT INTO `inscripcion_materias` (`inscripcion_id`, `materias_id`) VALUES
	(1, 9);

-- Volcando estructura para tabla correlativas.materia
CREATE TABLE IF NOT EXISTS `materia` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla correlativas.materia: ~16 rows (aproximadamente)
INSERT INTO `materia` (`id`, `nombre`) VALUES
	(1, 'Algoritmos_y_Estructura_de_Datos'),
	(2, 'Ingeniería_y_Sociedad'),
	(3, 'Arquitectura_de_Computadores'),
	(4, 'Matematica_discreta'),
	(5, 'Sistemas_y_Organizaciones'),
	(6, 'Quimica'),
	(7, 'Análisis_Matemático_1'),
	(8, 'Álgebra_y_Geometría_Analítica'),
	(9, 'Análisis_Matemático_2'),
	(10, 'Probabilidad_y_Estadística'),
	(11, 'Sintaxis_y_Semántica_de_los_Lenguajes'),
	(12, 'Paradigmas_de_Programación'),
	(13, 'Sistemas_de_Representación'),
	(14, 'Física_1'),
	(15, 'Inglés_Técnico_1'),
	(16, 'Análisis_de_Sistemas');

-- Volcando estructura para tabla correlativas.materia_correlativas
CREATE TABLE IF NOT EXISTS `materia_correlativas` (
  `materia_id` bigint NOT NULL,
  `correlativas_id` bigint DEFAULT NULL,
  UNIQUE KEY `UK_gyxmvh71ioapamympnu0wmrxm` (`correlativas_id`),
  KEY `FKlt7k739g1akhmikyts83rpag8` (`materia_id`),
  CONSTRAINT `FK9lr5onasklw4qymhfq6v2sw8j` FOREIGN KEY (`correlativas_id`) REFERENCES `materia` (`id`),
  CONSTRAINT `FKlt7k739g1akhmikyts83rpag8` FOREIGN KEY (`materia_id`) REFERENCES `materia` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla correlativas.materia_correlativas: ~2 rows (aproximadamente)
INSERT INTO `materia_correlativas` (`materia_id`, `correlativas_id`) VALUES
	(9, 7),
	(9, 8);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
