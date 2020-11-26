-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-11-2020 a las 05:04:18
-- Versión del servidor: 10.4.13-MariaDB
-- Versión de PHP: 7.2.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tienda_fullgame`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jue_alquileres`
--

CREATE TABLE `jue_alquileres` (
  `ide_alquiler` varchar(20) NOT NULL,
  `ide_juego` int(11) NOT NULL,
  `ide_cliente` varchar(120) NOT NULL,
  `ide_tecnologia_juegos` int(11) NOT NULL,
  `fecha_inicio` date NOT NULL DEFAULT current_timestamp(),
  `fecha_fin` date NOT NULL,
  `precio_alquiler` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `jue_alquileres`
--

INSERT INTO `jue_alquileres` (`ide_alquiler`, `ide_juego`, `ide_cliente`, `ide_tecnologia_juegos`, `fecha_inicio`, `fecha_fin`, `precio_alquiler`) VALUES
('AL1606369183570', 4, 'deivid_199615@hotmail.com', 6, '2020-11-24', '2020-11-27', 10500),
('AL1606369209691', 1, 'jorgen@gmail.com', 1, '2020-11-26', '2020-11-28', 50000),
('AL1606369571395', 10, 'deivid_199615@hotmail.com', 4, '2020-11-24', '2020-11-30', 12000),
('AL1606369904801', 4, 'maria@hotmail.com', 6, '2020-11-26', '2020-11-28', 14000),
('AL1606381676024', 14, 'deivid_199615@hotmail.com', 17, '2020-11-26', '2020-11-27', 25000),
('AL1606384544157', 21, 'jorgen@gmail.com', 18, '2020-11-26', '2020-11-28', 12000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jue_clientes`
--

CREATE TABLE `jue_clientes` (
  `correo` varchar(120) NOT NULL,
  `nombre` varchar(120) NOT NULL,
  `celular` varchar(10) NOT NULL,
  `direccion` varchar(150) NOT NULL,
  `edad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `jue_clientes`
--

INSERT INTO `jue_clientes` (`correo`, `nombre`, `celular`, `direccion`, `edad`) VALUES
('deivid_199615@hotmail.com', 'Deivid Urrego', '3147987385', 'Calle 10 No 3-56', 25),
('jorgen@gmail.com', 'Jorgen Valdes', '355555555', 'Calle 10 No 10-06', 24),
('maria@hotmail.com', 'Maria Rodriguez', '3205654120', 'Calle 50A No 10-06', 30),
('steven@gmail.com', 'Steven Mosquera', '300542874', 'Calle Siempre Vista', 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jue_directores`
--

CREATE TABLE `jue_directores` (
  `ide_director` int(11) NOT NULL,
  `nombre` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `jue_directores`
--

INSERT INTO `jue_directores` (`ide_director`, `nombre`) VALUES
(1, 'HIDEKI KAMIYA​'),
(2, 'SHIGERY MIYAMOTO'),
(3, 'DEIVID URREGO'),
(4, 'LORENA LOPEZ'),
(5, 'RODOLFO MARTINEZ'),
(6, 'GABRIELA MORA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jue_juegos`
--

CREATE TABLE `jue_juegos` (
  `ide_juego` int(11) NOT NULL,
  `titulo` varchar(120) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `año` int(11) NOT NULL,
  `ide_protagonista` int(11) NOT NULL,
  `ide_director` int(11) NOT NULL,
  `ide_marca` int(11) NOT NULL,
  `precio_alquiler` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `jue_juegos`
--

INSERT INTO `jue_juegos` (`ide_juego`, `titulo`, `descripcion`, `año`, `ide_protagonista`, `ide_director`, `ide_marca`, `precio_alquiler`) VALUES
(1, 'Criminal Case', 'Juego de asesinatos', 2008, 2, 1, 2, 25000),
(3, 'DEVIL MAY CRY 2', 'Videojuego de hack and slash y beatem up', 2015, 1, 1, 1, 20000),
(4, 'DEVIL MAY CRY 3', 'Videojuego de hack and slash y beatem up', 2018, 1, 1, 1, 7000),
(10, 'Super Mario Bros', 'Juego de aventura', 1996, 2, 2, 2, 2000),
(13, 'Resident Evil', 'Juego de zombies', 2000, 5, 3, 1, 12000),
(14, 'Fifa 2020', 'Juego de Futbol', 2020, 4, 4, 4, 25000),
(15, 'Zelda', 'Juego de aventura', 1980, 7, 5, 2, 4000),
(16, 'Grand Theft Auto V', 'Juego de robo y misiones', 2018, 6, 6, 5, 12000),
(21, 'GTA IV', 'Juego arcade de robos', 2014, 6, 3, 1, 6000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jue_marcas`
--

CREATE TABLE `jue_marcas` (
  `ide_marca` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `jue_marcas`
--

INSERT INTO `jue_marcas` (`ide_marca`, `nombre`) VALUES
(1, 'CAPCOM'),
(2, 'NINTENDO'),
(4, 'SONY ENTERTAINMENT NETWORK'),
(5, 'RIOT GAMES');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jue_protagonistas`
--

CREATE TABLE `jue_protagonistas` (
  `ide_protagonista` int(11) NOT NULL,
  `nombre` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `jue_protagonistas`
--

INSERT INTO `jue_protagonistas` (`ide_protagonista`, `nombre`) VALUES
(1, 'DANTE'),
(2, 'MARIO BROS'),
(3, 'LEONEL MESSI'),
(4, 'CRISTIANO RONALDO'),
(5, 'MILLA JOVOVICH'),
(6, 'CJ'),
(7, 'LINK');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jue_tecnologias`
--

CREATE TABLE `jue_tecnologias` (
  `ide_tecnologia` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `jue_tecnologias`
--

INSERT INTO `jue_tecnologias` (`ide_tecnologia`, `nombre`) VALUES
(1, 'XBOX'),
(2, 'PLAYSTATION'),
(3, 'PC'),
(4, 'NINTENDO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jue_tecnologia_juegos`
--

CREATE TABLE `jue_tecnologia_juegos` (
  `ide_tecnologia_juego` int(11) NOT NULL,
  `ide_juego` int(11) NOT NULL,
  `ide_tecnologia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `jue_tecnologia_juegos`
--

INSERT INTO `jue_tecnologia_juegos` (`ide_tecnologia_juego`, `ide_juego`, `ide_tecnologia`) VALUES
(1, 1, 3),
(3, 1, 2),
(4, 10, 1),
(6, 4, 3),
(7, 1, 1),
(8, 16, 4),
(9, 3, 1),
(10, 3, 2),
(11, 3, 3),
(12, 13, 1),
(13, 15, 4),
(14, 16, 1),
(15, 16, 3),
(16, 14, 2),
(17, 14, 1),
(18, 21, 2),
(19, 21, 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `jue_alquileres`
--
ALTER TABLE `jue_alquileres`
  ADD PRIMARY KEY (`ide_alquiler`),
  ADD KEY `FK_CLIENTE` (`ide_cliente`),
  ADD KEY `FK_JUEGOS` (`ide_juego`),
  ADD KEY `FK_TECNOLOGIA_JUEGOS` (`ide_tecnologia_juegos`);

--
-- Indices de la tabla `jue_clientes`
--
ALTER TABLE `jue_clientes`
  ADD PRIMARY KEY (`correo`);

--
-- Indices de la tabla `jue_directores`
--
ALTER TABLE `jue_directores`
  ADD PRIMARY KEY (`ide_director`);

--
-- Indices de la tabla `jue_juegos`
--
ALTER TABLE `jue_juegos`
  ADD PRIMARY KEY (`ide_juego`),
  ADD KEY `FK_DIRECTOR` (`ide_director`),
  ADD KEY `FK_MARCA` (`ide_marca`),
  ADD KEY `FK_PROTAGONISTA` (`ide_protagonista`);

--
-- Indices de la tabla `jue_marcas`
--
ALTER TABLE `jue_marcas`
  ADD PRIMARY KEY (`ide_marca`);

--
-- Indices de la tabla `jue_protagonistas`
--
ALTER TABLE `jue_protagonistas`
  ADD PRIMARY KEY (`ide_protagonista`);

--
-- Indices de la tabla `jue_tecnologias`
--
ALTER TABLE `jue_tecnologias`
  ADD PRIMARY KEY (`ide_tecnologia`);

--
-- Indices de la tabla `jue_tecnologia_juegos`
--
ALTER TABLE `jue_tecnologia_juegos`
  ADD PRIMARY KEY (`ide_tecnologia_juego`),
  ADD KEY `FK_JUEGO` (`ide_juego`),
  ADD KEY `FK_TECNOLOGIA` (`ide_tecnologia`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `jue_directores`
--
ALTER TABLE `jue_directores`
  MODIFY `ide_director` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `jue_juegos`
--
ALTER TABLE `jue_juegos`
  MODIFY `ide_juego` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `jue_marcas`
--
ALTER TABLE `jue_marcas`
  MODIFY `ide_marca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `jue_protagonistas`
--
ALTER TABLE `jue_protagonistas`
  MODIFY `ide_protagonista` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `jue_tecnologias`
--
ALTER TABLE `jue_tecnologias`
  MODIFY `ide_tecnologia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `jue_tecnologia_juegos`
--
ALTER TABLE `jue_tecnologia_juegos`
  MODIFY `ide_tecnologia_juego` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `jue_alquileres`
--
ALTER TABLE `jue_alquileres`
  ADD CONSTRAINT `FK_CLIENTE` FOREIGN KEY (`ide_cliente`) REFERENCES `jue_clientes` (`correo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_JUEGOS` FOREIGN KEY (`ide_juego`) REFERENCES `jue_juegos` (`ide_juego`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_TECNOLOGIA_JUEGOS` FOREIGN KEY (`ide_tecnologia_juegos`) REFERENCES `jue_tecnologia_juegos` (`ide_tecnologia_juego`);

--
-- Filtros para la tabla `jue_juegos`
--
ALTER TABLE `jue_juegos`
  ADD CONSTRAINT `FK_DIRECTOR` FOREIGN KEY (`ide_director`) REFERENCES `jue_directores` (`ide_director`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_MARCA` FOREIGN KEY (`ide_marca`) REFERENCES `jue_marcas` (`ide_marca`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_PROTAGONISTA` FOREIGN KEY (`ide_protagonista`) REFERENCES `jue_protagonistas` (`ide_protagonista`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `jue_tecnologia_juegos`
--
ALTER TABLE `jue_tecnologia_juegos`
  ADD CONSTRAINT `FK_JUEGO` FOREIGN KEY (`ide_juego`) REFERENCES `jue_juegos` (`ide_juego`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_TECNOLOGIA` FOREIGN KEY (`ide_tecnologia`) REFERENCES `jue_tecnologias` (`ide_tecnologia`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
