-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 05-11-2023 a las 22:23:41
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_sist_dist`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `enfrentamientos`
--

DROP TABLE IF EXISTS `enfrentamientos`;
CREATE TABLE IF NOT EXISTS `enfrentamientos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `equipo_local` int NOT NULL,
  `equipo_visitante` int NOT NULL,
  `fecha` date NOT NULL,
  `resultado` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `equipo_local` (`equipo_local`),
  KEY `equipo_visitante` (`equipo_visitante`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `enfrentamientos`
--

INSERT INTO `enfrentamientos` (`id`, `equipo_local`, `equipo_visitante`, `fecha`, `resultado`) VALUES
(1, 1, 3, '2023-10-15', '2-0'),
(2, 2, 4, '2023-10-30', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipos`
--

DROP TABLE IF EXISTS `equipos`;
CREATE TABLE IF NOT EXISTS `equipos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `fundacion` date NOT NULL,
  `pais` varchar(255) NOT NULL,
  `entrenador` varchar(255) NOT NULL,
  `estadio` varchar(255) NOT NULL,
  `presupuesto` decimal(10,2) DEFAULT NULL,
  `puntos` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `equipos`
--

INSERT INTO `equipos` (`id`, `nombre`, `fundacion`, `pais`, `entrenador`, `estadio`, `presupuesto`, `puntos`) VALUES
(1, 'Shaktar', '1995-05-22', 'Rusia', 'Daniela', 'AlianzArena', '50.00', 15),
(2, 'Nassa', '1988-03-09', 'Colombia', 'Juan', 'Maracana', '150.00', 18),
(3, 'Banfiel', '1999-12-01', 'Brasil', 'Julian', 'Campin', '500.00', 21),
(4, 'IceCube', '1977-10-26', 'EEUU', 'Wilson', 'Bernabeu', '90.00', 9);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
