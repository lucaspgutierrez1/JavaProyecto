-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-04-2023 a las 05:10:21
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_participantes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pronosticos`
--

CREATE TABLE `pronosticos` (
  `id` int(50) NOT NULL,
  `participante` varchar(255) NOT NULL,
  `equipo1` varchar(255) NOT NULL,
  `gana1` tinyint(1) NOT NULL,
  `empata` tinyint(1) NOT NULL,
  `gana2` tinyint(1) NOT NULL,
  `equipo2` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `pronosticos`
--

INSERT INTO `pronosticos` (`id`, `participante`, `equipo1`, `gana1`, `empata`, `gana2`, `equipo2`) VALUES
(1, 'Mariana', 'Argentina', 1, 0, 0, 'Arabia'),
(2, 'Mariana', 'Polonia', 0, 1, 0, 'Mexico'),
(3, 'Mariana', 'Argentina', 1, 0, 0, 'Mexico'),
(4, 'Mariana', 'Arabia', 0, 0, 1, 'Polonia'),
(5, 'Mariana', 'Dinamarca', 0, 1, 0, 'Tunez'),
(6, 'Mariana', 'Francia', 1, 0, 0, 'Australia'),
(7, 'Mariana', 'Tunez', 0, 0, 1, 'Australia'),
(8, 'Mariana', 'Francia', 1, 0, 0, 'Dinamarca'),
(9, 'Pedro', 'Argentina', 1, 0, 0, 'Arabia'),
(10, 'Pedro', 'Polonia', 0, 0, 1, 'Mexico'),
(11, 'Pedro', 'Argentina', 1, 0, 0, 'Mexico'),
(12, 'Pedro', 'Arabia', 0, 1, 0, 'Polonia'),
(13, 'Pedro', 'Dinamarca', 1, 0, 0, 'Tunez'),
(14, 'Pedro', 'Francia', 0, 0, 1, 'Australia'),
(15, 'Pedro', 'Tunez', 1, 0, 0, 'Australia'),
(16, 'Pedro', 'Francia', 0, 1, 0, 'Dinamarca');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `pronosticos`
--
ALTER TABLE `pronosticos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `pronosticos`
--
ALTER TABLE `pronosticos`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
