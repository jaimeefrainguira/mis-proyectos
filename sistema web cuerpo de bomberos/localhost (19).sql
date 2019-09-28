-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 21-06-2019 a las 02:22:36
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 5.6.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bomberos`
--
CREATE DATABASE IF NOT EXISTS `bomberos` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bomberos`;

DELIMITER $$
--
-- Procedimientos
--
DROP PROCEDURE IF EXISTS `buscarContribuyente`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `buscarContribuyente` (`_idcontribuyente` VARCHAR(13), `_anio` VARCHAR(4))  BEGIN
SELECT 
`idcontribuyente`,
 `tipo_documento`, 
 `razon_social`,
 `direccion`,
 `telefono`, 
 `email`, 
 `fecha_ingreso`,
 `especial`,
 `patente`,
 `fecha_importacion`, 
 `valor`,
 `estado`,
 `ape_nombre`,
 `perfil` 
 FROM `vista_contribuyente`WHERE `idcontribuyente`=_idcontribuyente  AND YEAR(`fecha_importacion`)=_anio ORDER BY `fecha_importacion` DESC LIMIT 1;

END$$

DROP PROCEDURE IF EXISTS `contribuyenteProcedimiento`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `contribuyenteProcedimiento` (`_idcontribuyente` VARCHAR(13), `_tipo_documento` VARCHAR(6), `_razon_social` VARCHAR(50), `_direccion` VARCHAR(55), `_telefono` VARCHAR(10), `_email` VARCHAR(50), `_fecha_ingreso` DATETIME, `_especial` VARCHAR(1), `_patente` DOUBLE, `_fecha_importacion` DATETIME, `_valor` DOUBLE, `_estado` CHAR(1), `_idusuarios` INT(11), `ACCION` VARCHAR(40))  BEGIN
	CASE ACCION
    
			WHEN 'CREAR' THEN
            INSERT INTO `contribuyente`
            (
            `idcontribuyente`,
            `tipo_documento`,
            `razon_social`,
            `direccion`,
            `telefono`,
            `email`,
            `fecha_ingreso`,
            `especial`
            ) VALUES (
            _idcontribuyente ,
			_tipo_documento ,
			_razon_social ,
			_direccion ,
			_telefono,
			_email ,
			_fecha_ingreso ,
			_especial 
            );
            INSERT INTO `contribuyente_detalle`(
            `idcontribuyente`,
            `patente`,
            `fecha_importacion`,
            `valor`, 
            `estado`,
            `idusuarios`
            ) VALUES (
            _idcontribuyente,
			_patente,
			_fecha_importacion,
			_valor ,
			_estado ,
			_idusuarios 
            );
            
            WHEN 'DETALLE' THEN           
            INSERT INTO `contribuyente_detalle`
            (
            `idcontribuyente`,
            `patente`,
            `fecha_importacion`,
            `valor`, 
            `estado`,
            `idusuarios`
            ) VALUES (
            _idcontribuyente,
			_patente,
			_fecha_importacion,
			_valor ,
			_estado ,
			_idusuarios 
            );
            WHEN 'ACTUALIZA' THEN
            UPDATE `contribuyente` SET 
            `razon_social` = _razon_social,
            `direccion` =_direccion,
            `telefono` = _telefono, 
            `email` = _email 
            WHERE `contribuyente`.`idcontribuyente` = _idcontribuyente;
	end case;
end$$

DROP PROCEDURE IF EXISTS `iniciarSesion`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `iniciarSesion` (IN `_usuario` VARCHAR(12), IN `_clave` VARCHAR(16))  BEGIN

SELECT `idusuarios`, `usuario`, `cedula`, `clave`, `fecha_creacion`, `ape_nombre`, `direccion`, `perfil` FROM `usuarios` WHERE usuario = _usuario AND clave = _clave;

END$$

DROP PROCEDURE IF EXISTS `notificacionProcedimiento`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `notificacionProcedimiento` (`_fecha_notificacion` DATETIME, `_num_notificacion` INT(10), `_direccion` VARCHAR(55), `_extintor` TINYINT, `_inst_electricas` TINYINT, `_recipientes` TINYINT, `_mater_combust` TINYINT, `_otros` VARCHAR(45), `_fecha_limite` DATETIME, `_estado` CHAR(1), `_latitud` VARCHAR(15), `_longitud` VARCHAR(15), `_observaciones` TEXT, `_idcontribuyente` VARCHAR(13), `_usuarios_idusuarios` INT(11), `ACCION` VARCHAR(40))  BEGIN

	CASE ACCION
    
			WHEN 'CREAR' THEN

				INSERT INTO `notificaciones`(
                idnotificaciones,
                `fecha_notificacion`,
                `num_notificacion`,
                `direccion`,
                `extintor`,
                `inst_electricas`,
                `recipientes`, 
                `mater_combust`,
                `otros`,
                `fecha_limite`, 
                `estado`,
                `latitud`,
                `longitud`,
                `observaciones`, 
                `idcontribuyente`, 
                `usuarios_idusuarios`
                ) VALUES (
                null,
                _fecha_notificacion,
				_num_notificacion 	,
				_direccion ,
				_extintor 	,
				_inst_electricas ,
				_recipientes ,
				_mater_combust ,
				_otros ,
				_fecha_limite,
				_estado 		,
				_latitud 	,
				_longitud 		,
				_observaciones ,
				_idcontribuyente 	,
				_usuarios_idusuarios
                );
	end case;
END$$

DROP PROCEDURE IF EXISTS `numeroNotificacion`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `numeroNotificacion` (`_idcontribuyente` VARCHAR(13), `_anio` VARCHAR(4))  BEGIN
	SELECT `num_notificacion`,`fecha_notificacion`,`fecha_limite`,`estado` from notificaciones WHERE `idcontribuyente` = _idcontribuyente  AND YEAR(`fecha_limite`)=_anio   ORDER BY `fecha_notificacion` DESC LIMIT 1;
END$$

DROP PROCEDURE IF EXISTS `sesion`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `sesion` (`_estado` VARCHAR(1), `_fecha_sesion` DATETIME, `_ip_conexion` VARCHAR(45), `_usuarios_idusuarios` INT(11))  BEGIN
INSERT INTO `sesion`(`estado`, `fecha_sesion`, `ip_conexion`, `usuarios_idusuarios`) VALUES (
_estado,
_fecha_sesion,
_ip_conexion,
_usuarios_idusuarios);

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contribuyente`
--

DROP TABLE IF EXISTS `contribuyente`;
CREATE TABLE `contribuyente` (
  `idcontribuyente` varchar(13) NOT NULL,
  `tipo_documento` varchar(6) NOT NULL,
  `razon_social` varchar(50) NOT NULL,
  `direccion` varchar(55) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `fecha_ingreso` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `especial` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `contribuyente`
--

INSERT INTO `contribuyente` (`idcontribuyente`, `tipo_documento`, `razon_social`, `direccion`, `telefono`, `email`, `fecha_ingreso`, `especial`) VALUES
('0104516257', 'CEDULA', 'Jaime Efrain Guiracocha', 'Pio Bravo y Huaynacapac', '0994778739', 'jaimeefrainguira@gmail.com', '2019-06-20 18:39:47', 'N'),
('0300146826', 'CEDULA', 'ALVAREZ SILVIO OSWALDO', '', '2242412', 'casar@caref.com.ec', '2019-06-19 03:58:18', 'N'),
('0300673803', 'CEDULA', 'ABAD SALINAS', 'AZOGUES', '998269022', 'casar@caref.com.ec', '2019-06-20 16:16:57', 'N'),
('0301489522001', 'RUC', 'SEGARRA ', 'AZOGUES', '2242', 'casar@caref.com.ec', '2019-06-20 06:54:57', 'N'),
('0301500856', 'CEDULA', 'APUANGO GONZALEZ RAUL FERNANDO', 'AZOGUES', '2242412', 'casar@caref.com.ec', '2019-06-18 08:07:42', 'N'),
('0301508495', 'CEDULA', 'ANDRADE CARANGUI CESAR AUGUSTO', 'AZOGUES', '2242412', 'casar@caref.com.ec', '2019-06-18 08:07:42', 'N'),
('0301567160', 'CEDULA', 'ALVAREZ LOZANO NUBE ESTEFANIA', 'AZOGUES', '998269022', 'casar@caref.com.ec', '2019-06-18 08:07:42', 'N'),
('1710525633', 'CEDULA', 'AÃ‘ASCO TRAVEZ  NELSON FABIAN', 'AZOGUES', '2242412', 'casar@caref.com.ec', '2019-06-18 08:07:42', 'N'),
('1801766526', 'CEDULA', 'ACURIO GORDON HOLGUER GERARDO', 'AZOGUES', '2242412', 'casar@caref.com.ec', '2019-06-18 08:07:42', 'N'),
('2019-06-20 03', '1', 'asdf', 'on', '', '', '0000-00-00 00:00:00', 'a');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contribuyente_detalle`
--

DROP TABLE IF EXISTS `contribuyente_detalle`;
CREATE TABLE `contribuyente_detalle` (
  `id_contri_detalle` int(11) NOT NULL,
  `idcontribuyente` varchar(13) CHARACTER SET utf8 NOT NULL,
  `patente` double NOT NULL,
  `fecha_importacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `valor` double NOT NULL,
  `estado` char(1) NOT NULL,
  `idusuarios` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `contribuyente_detalle`
--

INSERT INTO `contribuyente_detalle` (`id_contri_detalle`, `idcontribuyente`, `patente`, `fecha_importacion`, `valor`, `estado`, `idusuarios`) VALUES
(41, '1710525633', 10.01, '2019-06-18 08:07:42', 0.6006, 'P', 1),
(42, '0300673803', 10.01, '2019-06-18 08:07:42', 0.6006, 'P', 1),
(43, '1801766526', 10.01, '2019-06-18 08:07:42', 0.6006, 'P', 1),
(44, '0301567160', 10.01, '2019-06-18 08:07:42', 0.6006, 'P', 1),
(45, '0300146826', 10.01, '2019-06-18 08:07:42', 0.6006, 'P', 1),
(46, '0301508495', 36.01, '2019-06-18 08:07:42', 2.1606, 'P', 1),
(47, '0301500856', 10.01, '2019-06-18 08:07:42', 0.6006, 'P', 1),
(48, '0301489522001', 10.01, '2019-06-18 08:07:42', 0.6006, 'P', 1),
(49, '1710525633', 10.01, '2019-06-18 08:09:56', 0.6006, 'P', 1),
(50, '0300673803', 10.01, '2019-06-18 08:09:56', 0.6006, 'P', 1),
(51, '1801766526', 10.01, '2019-06-18 08:09:56', 0.6006, 'P', 1),
(52, '0301567160', 10.01, '2019-06-18 08:09:56', 0.6006, 'P', 1),
(53, '0300146826', 10.01, '2019-06-18 08:09:56', 0.6006, 'P', 1),
(54, '0301508495', 36.01, '2019-06-18 08:09:56', 2.1606, 'P', 1),
(55, '0301500856', 10.01, '2019-06-18 08:09:56', 0.6006, 'P', 1),
(56, '0301489522001', 10.01, '2019-06-18 08:09:56', 0.6006, 'P', 1),
(57, '1710525633', 10.01, '2019-06-20 06:57:05', 0.6006, 'P', 1),
(58, '0300673803', 10.01, '2019-06-20 06:57:05', 0.6006, 'P', 1),
(59, '1801766526', 10.01, '2019-06-20 06:57:05', 0.6006, 'P', 1),
(60, '0301567160', 10.01, '2019-06-20 06:57:05', 0.6006, 'P', 1),
(61, '0300146826', 10.01, '2019-06-20 06:57:05', 0.6006, 'P', 1),
(62, '0301508495', 36.01, '2019-06-20 06:57:05', 2.1606, 'P', 1),
(63, '0301500856', 10.01, '2019-06-20 06:57:05', 0.6006, 'P', 1),
(64, '0301489522001', 10.01, '2019-06-20 06:57:05', 0.6006, 'P', 1),
(65, '0104516257', 10.2, '2019-06-20 06:57:05', 0.612, 'P', 1),
(66, '2019-06-20 03', 1111, '0000-00-00 00:00:00', 0, '0', 1),
(67, '1710525633', 10.01, '2019-06-21 00:19:12', 0.6006, 'P', 1),
(68, '0300673803', 10.01, '2019-06-21 00:19:12', 0.6006, 'P', 1),
(69, '1801766526', 10.01, '2019-06-21 00:19:12', 0.6006, 'P', 1),
(70, '0301567160', 10.01, '2019-06-21 00:19:12', 0.6006, 'P', 1),
(71, '0300146826', 10.01, '2019-06-21 00:19:12', 0.6006, 'P', 1),
(72, '0301508495', 36.01, '2019-06-21 00:19:12', 2.1606, 'P', 1),
(73, '0301500856', 10.01, '2019-06-21 00:19:12', 0.6006, 'P', 1),
(74, '0301489522001', 10.01, '2019-06-21 00:19:12', 0.6006, 'P', 1),
(75, '0104516257', 10.2, '2019-06-21 00:19:12', 0.612, 'P', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `emision`
--

DROP TABLE IF EXISTS `emision`;
CREATE TABLE `emision` (
  `idemision` int(11) NOT NULL,
  `forma_pago` char(2) NOT NULL,
  `fecha_emision` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `valor_pagado` decimal(2,0) NOT NULL,
  `estado` varchar(1) NOT NULL,
  `idcontribuyente` varchar(13) NOT NULL,
  `usuarios_idusuarios` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notificaciones`
--

DROP TABLE IF EXISTS `notificaciones`;
CREATE TABLE `notificaciones` (
  `idnotificaciones` int(11) NOT NULL,
  `fecha_notificacion` datetime NOT NULL,
  `num_notificacion` int(10) NOT NULL,
  `direccion` varchar(55) NOT NULL,
  `extintor` tinyint(1) NOT NULL,
  `inst_electricas` tinyint(1) NOT NULL,
  `recipientes` tinyint(1) NOT NULL,
  `mater_combust` tinyint(1) NOT NULL,
  `otros` varchar(45) NOT NULL,
  `fecha_limite` datetime NOT NULL,
  `estado` char(1) NOT NULL,
  `latitud` varchar(15) NOT NULL,
  `longitud` varchar(15) NOT NULL,
  `observaciones` text NOT NULL,
  `idcontribuyente` varchar(13) NOT NULL,
  `usuarios_idusuarios` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sesion`
--

DROP TABLE IF EXISTS `sesion`;
CREATE TABLE `sesion` (
  `idsesion` int(11) NOT NULL,
  `estado` varchar(1) NOT NULL,
  `fecha_sesion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ip_conexion` varchar(45) NOT NULL,
  `usuarios_idusuarios` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `sesion`
--

INSERT INTO `sesion` (`idsesion`, `estado`, `fecha_sesion`, `ip_conexion`, `usuarios_idusuarios`) VALUES
(132, 'V', '2019-06-19 05:06:12', '::1', 1),
(133, 'V', '2019-06-19 05:06:23', '::1', 1),
(134, 'V', '2019-06-19 05:08:10', '::1', 1),
(135, 'V', '2019-06-19 05:17:32', '::1', 1),
(136, 'V', '2019-06-19 05:18:47', '::1', 3),
(137, 'V', '2019-06-19 05:19:11', '::1', 1),
(138, 'V', '2019-06-19 05:41:54', '::1', 1),
(139, 'V', '2019-06-19 05:44:59', '::1', 1),
(140, 'V', '2019-06-19 06:03:53', '::1', 3),
(141, 'V', '2019-06-19 07:01:18', '::1', 3),
(142, 'V', '2019-06-19 07:05:03', '::1', 3),
(143, 'V', '2019-06-19 07:05:49', '::1', 3),
(144, 'V', '2019-06-19 07:10:07', '::1', 3),
(145, 'V', '2019-06-19 07:21:42', '::1', 1),
(146, 'V', '2019-06-19 07:21:57', '::1', 1),
(147, 'V', '2019-06-19 07:24:34', '::1', 1),
(148, 'V', '2019-06-19 07:25:18', '::1', 1),
(149, 'V', '2019-06-19 07:25:39', '::1', 3),
(150, 'V', '2019-06-19 07:25:50', '::1', 3),
(151, 'V', '2019-06-19 07:26:34', '::1', 3),
(152, 'V', '2019-06-19 07:29:17', '::1', 3),
(153, 'V', '2019-06-19 07:29:30', '::1', 1),
(154, 'V', '2019-06-19 07:29:42', '::1', 3),
(155, 'V', '2019-06-19 07:35:12', '::1', 3),
(156, 'V', '2019-06-19 07:35:30', '::1', 3),
(157, 'V', '2019-06-19 07:36:17', '::1', 3),
(158, 'V', '2019-06-20 05:10:56', '::1', 1),
(159, 'V', '2019-06-20 05:11:05', '::1', 3),
(160, 'V', '2019-06-20 05:15:08', '::1', 3),
(161, 'V', '2019-06-20 05:16:45', '::1', 3),
(162, 'V', '2019-06-20 05:18:38', '::1', 3),
(163, 'V', '2019-06-20 06:03:28', '::1', 1),
(164, 'V', '2019-06-20 06:03:38', '::1', 3),
(165, 'V', '2019-06-20 06:05:15', '::1', 3),
(166, 'V', '2019-06-20 06:05:28', '::1', 3),
(167, 'V', '2019-06-20 06:06:16', '::1', 3),
(168, 'V', '2019-06-20 06:56:55', '::1', 1),
(169, 'V', '2019-06-20 07:07:03', '::1', 1),
(170, 'V', '2019-06-20 07:07:11', '::1', 3),
(171, 'V', '2019-06-20 07:15:33', '::1', 3),
(172, 'V', '2019-06-20 07:59:16', '::1', 3),
(173, 'V', '2019-06-20 13:52:53', '::1', 3),
(174, 'V', '2019-06-20 13:54:46', '::1', 3),
(175, 'V', '2019-06-20 18:02:09', '::1', 3),
(176, 'V', '2019-06-20 18:41:11', '::1', 1),
(177, 'V', '2019-06-20 18:42:04', '::1', 3),
(178, 'V', '2019-06-20 23:54:04', '::1', 1),
(179, 'V', '2019-06-20 23:57:46', '::1', 1),
(180, 'V', '2019-06-20 23:58:33', '::1', 1),
(181, 'V', '2019-06-21 00:00:31', '::1', 1),
(182, 'V', '2019-06-21 00:01:18', '::1', 1),
(183, 'V', '2019-06-21 00:05:07', '::1', 3),
(184, 'V', '2019-06-21 00:05:22', '::1', 1),
(185, 'V', '2019-06-21 00:10:02', '::1', 1),
(186, 'V', '2019-06-21 00:19:25', '::1', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `idusuarios` int(11) NOT NULL,
  `usuario` varchar(12) NOT NULL,
  `cedula` varchar(10) NOT NULL,
  `clave` varchar(16) NOT NULL,
  `fecha_creacion` date NOT NULL,
  `ape_nombre` varchar(50) NOT NULL,
  `direccion` varchar(55) NOT NULL,
  `perfil` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idusuarios`, `usuario`, `cedula`, `clave`, `fecha_creacion`, `ape_nombre`, `direccion`, `perfil`) VALUES
(1, 'admin', '0106625412', 'admin', '2019-05-22', 'Segarra Johny', 'El Cebollar', 'Administrador'),
(2, 'super', '0106625413', 'super', '2019-05-22', 'Alvarado Carlos', 'Loja', 'Supervisor'),
(3, 'noti', '0106625414', 'noti', '2019-05-22', 'Chacon Jessica', 'Sucre', 'Notificador'),
(5, 'teso', '0106625415', 'teso', '2019-05-22', 'Guzman Valeria', 'El batan', 'Tesorero');

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_contribuyente`
-- (Véase abajo para la vista actual)
--
DROP VIEW IF EXISTS `vista_contribuyente`;
CREATE TABLE `vista_contribuyente` (
`idcontribuyente` varchar(13)
,`tipo_documento` varchar(6)
,`razon_social` varchar(50)
,`direccion` varchar(55)
,`telefono` varchar(10)
,`email` varchar(50)
,`fecha_ingreso` timestamp
,`especial` varchar(1)
,`patente` double
,`fecha_importacion` timestamp
,`valor` double
,`estado` char(1)
,`ape_nombre` varchar(50)
,`perfil` varchar(20)
);

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_contribuyente`
--
DROP TABLE IF EXISTS `vista_contribuyente`;

CREATE ALGORITHM=UNDEFINED DEFINER=`jaime`@`localhost` SQL SECURITY DEFINER VIEW `vista_contribuyente`  AS  select `c`.`idcontribuyente` AS `idcontribuyente`,`c`.`tipo_documento` AS `tipo_documento`,`c`.`razon_social` AS `razon_social`,`c`.`direccion` AS `direccion`,`c`.`telefono` AS `telefono`,`c`.`email` AS `email`,`c`.`fecha_ingreso` AS `fecha_ingreso`,`c`.`especial` AS `especial`,`cd`.`patente` AS `patente`,`cd`.`fecha_importacion` AS `fecha_importacion`,`cd`.`valor` AS `valor`,`cd`.`estado` AS `estado`,`u`.`ape_nombre` AS `ape_nombre`,`u`.`perfil` AS `perfil` from ((`contribuyente` `c` join `contribuyente_detalle` `cd` on((`cd`.`idcontribuyente` = `c`.`idcontribuyente`))) join `usuarios` `u` on((`u`.`idusuarios` = `cd`.`idusuarios`))) ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `contribuyente`
--
ALTER TABLE `contribuyente`
  ADD PRIMARY KEY (`idcontribuyente`);

--
-- Indices de la tabla `contribuyente_detalle`
--
ALTER TABLE `contribuyente_detalle`
  ADD PRIMARY KEY (`id_contri_detalle`),
  ADD KEY `idcontribuyente` (`idcontribuyente`),
  ADD KEY `idusuarios` (`idusuarios`);

--
-- Indices de la tabla `emision`
--
ALTER TABLE `emision`
  ADD PRIMARY KEY (`idemision`),
  ADD UNIQUE KEY `idemision_UNIQUE` (`idemision`),
  ADD KEY `fk_emision_usuarios1_idx` (`usuarios_idusuarios`),
  ADD KEY `idcontribuyente` (`idcontribuyente`);

--
-- Indices de la tabla `notificaciones`
--
ALTER TABLE `notificaciones`
  ADD PRIMARY KEY (`idnotificaciones`),
  ADD KEY `idcontribuyente` (`idcontribuyente`),
  ADD KEY `usuarios_idusuarios` (`usuarios_idusuarios`);

--
-- Indices de la tabla `sesion`
--
ALTER TABLE `sesion`
  ADD PRIMARY KEY (`idsesion`),
  ADD UNIQUE KEY `idsesion_UNIQUE` (`idsesion`),
  ADD KEY `fk_sesion_usuarios1_idx` (`usuarios_idusuarios`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idusuarios`),
  ADD UNIQUE KEY `idusuarios_UNIQUE` (`idusuarios`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `contribuyente_detalle`
--
ALTER TABLE `contribuyente_detalle`
  MODIFY `id_contri_detalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=76;

--
-- AUTO_INCREMENT de la tabla `notificaciones`
--
ALTER TABLE `notificaciones`
  MODIFY `idnotificaciones` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `sesion`
--
ALTER TABLE `sesion`
  MODIFY `idsesion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=187;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idusuarios` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `contribuyente_detalle`
--
ALTER TABLE `contribuyente_detalle`
  ADD CONSTRAINT `contribuyente_detalle_ibfk_1` FOREIGN KEY (`idcontribuyente`) REFERENCES `contribuyente` (`idcontribuyente`),
  ADD CONSTRAINT `contribuyente_detalle_ibfk_2` FOREIGN KEY (`idusuarios`) REFERENCES `usuarios` (`idusuarios`);

--
-- Filtros para la tabla `emision`
--
ALTER TABLE `emision`
  ADD CONSTRAINT `emision_ibfk_1` FOREIGN KEY (`idcontribuyente`) REFERENCES `contribuyente` (`idcontribuyente`),
  ADD CONSTRAINT `fk_emision_usuarios1` FOREIGN KEY (`usuarios_idusuarios`) REFERENCES `usuarios` (`idusuarios`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `notificaciones`
--
ALTER TABLE `notificaciones`
  ADD CONSTRAINT `notificaciones_ibfk_1` FOREIGN KEY (`usuarios_idusuarios`) REFERENCES `usuarios` (`idusuarios`),
  ADD CONSTRAINT `notificaciones_ibfk_2` FOREIGN KEY (`idcontribuyente`) REFERENCES `contribuyente` (`idcontribuyente`);

--
-- Filtros para la tabla `sesion`
--
ALTER TABLE `sesion`
  ADD CONSTRAINT `fk_sesion_usuarios1` FOREIGN KEY (`usuarios_idusuarios`) REFERENCES `usuarios` (`idusuarios`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
