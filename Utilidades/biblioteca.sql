-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 08-12-2023 a las 03:00:13
-- Versión del servidor: 8.0.31
-- Versión de PHP: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `biblioteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artistas`
--

DROP TABLE IF EXISTS `artistas`;
CREATE TABLE IF NOT EXISTS `artistas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autores`
--

DROP TABLE IF EXISTS `autores`;
CREATE TABLE IF NOT EXISTS `autores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(191) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cds`
--

DROP TABLE IF EXISTS `cds`;
CREATE TABLE IF NOT EXISTS `cds` (
  `id_ejemplar` varchar(50) DEFAULT NULL,
  `duracion` int DEFAULT NULL,
  `ano_lanzamiento` int DEFAULT NULL,
  `canciones` int DEFAULT NULL,
  `id_artista` int DEFAULT NULL,
  `id_genero` int DEFAULT NULL,
  KEY `id_ejemplar` (`id_ejemplar`),
  KEY `id_genero` (`id_genero`),
  KEY `id_artista` (`id_artista`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `configuraciones`
--

DROP TABLE IF EXISTS `configuraciones`;
CREATE TABLE IF NOT EXISTS `configuraciones` (
  `clave` varchar(50) NOT NULL,
  `valor` varchar(255) NOT NULL,
  PRIMARY KEY (`clave`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `devoluciones`
--

DROP TABLE IF EXISTS `devoluciones`;
CREATE TABLE IF NOT EXISTS `devoluciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_prestamo` int DEFAULT NULL,
  `fecha_devolucion` date NOT NULL,
  `estado_devolucion` enum('En tiempo','Atrasado') NOT NULL,
  `comentarios` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_prestamo` (`id_prestamo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Disparadores `devoluciones`
--
DROP TRIGGER IF EXISTS `actualizar_prestados`;
DELIMITER $$
CREATE TRIGGER `actualizar_prestados` AFTER INSERT ON `devoluciones` FOR EACH ROW BEGIN
    UPDATE prestamos
    SET fecha_devolucion = NEW.fecha_devolucion
    WHERE id = NEW.id_prestamo;

    UPDATE ejemplares
    SET prestados = prestados - 1
    WHERE id = (SELECT id_ejemplar FROM prestamos WHERE id = NEW.id_prestamo);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `editoriales`
--

DROP TABLE IF EXISTS `editoriales`;
CREATE TABLE IF NOT EXISTS `editoriales` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejemplares`
--

DROP TABLE IF EXISTS `ejemplares`;
CREATE TABLE IF NOT EXISTS `ejemplares` (
  `id` varchar(50) NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `id_autor` int DEFAULT NULL,
  `tipo` varchar(50) NOT NULL,
  `ubicacion` varchar(255) NOT NULL,
  `cantidad` int NOT NULL,
  `prestados` int DEFAULT '0',
  `imagenURL` varchar(255) DEFAULT NULL,
  `estado` varchar(8) DEFAULT 'activo',
  PRIMARY KEY (`id`),
  KEY `id_autor` (`id_autor`)
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `generos`
--

DROP TABLE IF EXISTS `generos`;
CREATE TABLE IF NOT EXISTS `generos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `idiomas`
--

DROP TABLE IF EXISTS `idiomas`;
CREATE TABLE IF NOT EXISTS `idiomas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

DROP TABLE IF EXISTS `libros`;
CREATE TABLE IF NOT EXISTS `libros` (
  `id_ejemplar` varchar(50) DEFAULT NULL,
  `isbn` varchar(13) DEFAULT NULL,
  `id_editorial` int DEFAULT NULL,
  `edicion` int DEFAULT NULL,
  `fecha_publicacion` date DEFAULT NULL,
  `numero_paginas` int DEFAULT NULL,
  `id_idioma` int DEFAULT NULL,
  KEY `id_ejemplar` (`id_ejemplar`),
  KEY `id_editorial` (`id_editorial`),
  KEY `id_idioma` (`id_idioma`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pagos`
--

DROP TABLE IF EXISTS `pagos`;
CREATE TABLE IF NOT EXISTS `pagos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int DEFAULT NULL,
  `monto` decimal(10,2) NOT NULL,
  `fecha_pago` date NOT NULL,
  `id_prestamo` int DEFAULT NULL,
  `id_ejemplar` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_prestamo` (`id_prestamo`),
  KEY `id_ejemplar` (`id_ejemplar`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Disparadores `pagos`
--
DROP TRIGGER IF EXISTS `actualizar_id_ejemplar_pago`;
DELIMITER $$
CREATE TRIGGER `actualizar_id_ejemplar_pago` AFTER INSERT ON `pagos` FOR EACH ROW BEGIN
    DECLARE ultima_devolucion_id_ejemplar VARCHAR(50);

    -- Encontrar el id_ejemplar del último registro de devolución para el mismo usuario
    SELECT d.id_ejemplar INTO ultima_devolucion_id_ejemplar
    FROM devoluciones d
    WHERE d.id_usuario = NEW.id_usuario
    ORDER BY d.fecha_devolucion DESC, d.id DESC
    LIMIT 1;

    -- Actualizar el id_ejemplar en la tabla de pagos con el último id_ejemplar de la tabla de devoluciones
    IF ultima_devolucion_id_ejemplar IS NOT NULL THEN
        UPDATE pagos
        SET id_ejemplar = ultima_devolucion_id_ejemplar
        WHERE id = NEW.id;
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamos`
--

DROP TABLE IF EXISTS `prestamos`;
CREATE TABLE IF NOT EXISTS `prestamos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int DEFAULT NULL,
  `id_ejemplar` varchar(50) DEFAULT NULL,
  `fecha_prestamo` date NOT NULL,
  `fecha_devolucion` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_ejemplar` (`id_ejemplar`)
) ;

--
-- Disparadores `prestamos`
--
DROP TRIGGER IF EXISTS `incrementar_prestados`;
DELIMITER $$
CREATE TRIGGER `incrementar_prestados` AFTER INSERT ON `prestamos` FOR EACH ROW BEGIN
    UPDATE ejemplares
    SET prestados = prestados + 1
    WHERE id = NEW.id_ejemplar;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `revistas`
--

DROP TABLE IF EXISTS `revistas`;
CREATE TABLE IF NOT EXISTS `revistas` (
  `id_ejemplar` varchar(50) DEFAULT NULL,
  `issn` varchar(9) DEFAULT NULL,
  `numero` int DEFAULT NULL,
  `volumen` int DEFAULT NULL,
  `periodicidad` varchar(50) DEFAULT NULL,
  `editor` varchar(100) DEFAULT NULL,
  `fecha_publicacion` date DEFAULT NULL,
  KEY `id_ejemplar` (`id_ejemplar`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tesis`
--

DROP TABLE IF EXISTS `tesis`;
CREATE TABLE IF NOT EXISTS `tesis` (
  `id_ejemplar` varchar(50) DEFAULT NULL,
  `id_universidad` int DEFAULT NULL,
  `anio` int DEFAULT NULL,
  `grado` varchar(50) DEFAULT NULL,
  `programa_academico` varchar(100) DEFAULT NULL,
  KEY `id_ejemplar` (`id_ejemplar`),
  KEY `id_universidad` (`id_universidad`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `universidades`
--

DROP TABLE IF EXISTS `universidades`;
CREATE TABLE IF NOT EXISTS `universidades` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `contrasena` varchar(100) NOT NULL,
  `tipo_usuario` enum('Administrador','Profesor','Alumno') NOT NULL,
  `mora` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `correo` (`correo`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `correo`, `contrasena`, `tipo_usuario`, `mora`) VALUES
(1, 'Gerardo Marroquin', 'gerardo@test.com', '12345678', 'Administrador', '0.00');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
