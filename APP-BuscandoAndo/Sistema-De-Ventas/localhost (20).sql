-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 22-06-2019 a las 23:02:00
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
-- Base de datos: `bdventas`
--
CREATE DATABASE IF NOT EXISTS `bdventas` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bdventas`;

DELIMITER $$
--
-- Procedimientos
--
DROP PROCEDURE IF EXISTS `anularCompraCabesera`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `anularCompraCabesera` (IN `_COM_CAB_ID` INT(10))  BEGIN
UPDATE `COMPRAS_CAB` SET `COM_CAB_ESTADO` = '0' WHERE `COMPRAS_CAB`.`COM_CAB_ID` = _COM_CAB_ID;
END$$

DROP PROCEDURE IF EXISTS `anularFacturaCabesera`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `anularFacturaCabesera` (IN `_COM_CAB_ID` INT(10))  BEGIN
UPDATE `FACTURA_CAB` SET `FAC_CAB_ESTADO` = '0' WHERE `FACTURA_CAB`.`FAC_CAB_ID` = _COM_CAB_ID;
END$$

DROP PROCEDURE IF EXISTS `buscaCategoria`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `buscaCategoria` (IN `buscar` VARCHAR(50))  BEGIN
	SELECT * FROM CATEGORIA WHERE CAT_ID LIKE buscar OR CAT_DESCRIPCION LIKE buscar;
END$$

DROP PROCEDURE IF EXISTS `buscaCliente`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `buscaCliente` (IN `buscar` VARCHAR(50))  BEGIN
 SELECT
     PERSONA.`PER_ID` AS PERSONA_PER_ID,
     PERSONA.`PER_CEDULA` AS PERSONA_PER_CEDULA,
     PERSONA.`PER_NOMBRE` AS PERSONA_PER_NOMBRE,
     PERSONA.`PER_DIRECCION` AS PERSONA_PER_DIRECCION,
     PERSONA.`PER_TELEFONO` AS PERSONA_PER_TELEFONO,
     PERSONA.`PER_CELULAR` AS PERSONA_PER_CELULAR,
     PERSONA.`PER_CORREO` AS PERSONA_PER_CORREO,
     PERSONA.`PER_SEXO` AS PERSONA_PER_SEXO,
     CLI_ESTADO
FROM
     `PERSONA` PERSONA INNER JOIN `CLIENTE` CLIENTE
     ON  CLIENTE.`PER_ID`=PERSONA.`PER_ID` AND ( CLIENTE.`PER_ID` LIKE buscar  OR  PERSONA.`PER_CEDULA` LIKE buscar   OR PERSONA.`PER_NOMBRE` LIKE buscar );
     
END$$

DROP PROCEDURE IF EXISTS `buscaClienteById`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `buscaClienteById` (IN `buscar` VARCHAR(5))  BEGIN

	SELECT
     PERSONA.`PER_ID` AS PERSONA_PER_ID,
     PERSONA.`PER_CEDULA` AS PERSONA_PER_CEDULA,
     PERSONA.`PER_NOMBRE` AS PERSONA_PER_NOMBRE,
     PERSONA.`PER_DIRECCION` AS PERSONA_PER_DIRECCION,
     PERSONA.`PER_TELEFONO` AS PERSONA_PER_TELEFONO,
     PERSONA.`PER_CELULAR` AS PERSONA_PER_CELULAR,
     PERSONA.`PER_CORREO` AS PERSONA_PER_CORREO,
     PERSONA.`PER_SEXO` AS PERSONA_PER_SEXO,
     CLI_FECHA_REGISTRO,
     CLI_OBSERVACION,
     CLI_ESTADO
FROM
     `PERSONA` PERSONA INNER JOIN `CLIENTE` CLIENTE 
     ON  CLIENTE.`PER_ID`=PERSONA.`PER_ID` AND ( CLIENTE.`PER_ID` = buscar );
     

END$$

DROP PROCEDURE IF EXISTS `buscaCompraCab`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `buscaCompraCab` (IN `_DESDE` DATETIME, IN `_HASTA` DATETIME, IN `_TCOMPROVANTE` INT(1), IN `ACCION` VARCHAR(40))  BEGIN
CASE ACCION
	WHEN 'CONSULTA' THEN
SELECT 
        `C`.`COM_CAB_ID` AS `COM_CAB_ID`,
        `C`.`COM_CAB_PROVEEDOR_ID` AS `COM_CAB_PROVEEDOR_ID`,
        `P`.`PER_NOMBRE` AS `PROVEEDOR`,
        `C`.`COM_CAB_USUARIO_ID` AS `COM_CAB_USUARIO_ID`,
        `U`.`PER_NOMBRE` AS `USUARIO`,
        `C`.`COM_CAB_FECHA` AS `COM_CAB_FECHA`,
        `C`.`COM_CAB_TIPO_COMPROVANTE` AS `COM_CAB_TIPO_COMPROVANTE`,
        `C`.`COM_CAB_NUM_COMPROVANTE` AS `COM_CAB_NUM_COMPROVANTE`,
        `C`.`COM_CAB_SUBTOTAL` AS `COM_CAB_SUBTOTAL`,
        `C`.`COM_CAB_IVA` AS `COM_CAB_IVA`,
        `C`.`COM_CAB_TOTAL` AS `COM_CAB_TOTAL`,
        `C`.`COM_CAB_ESTADO` AS `COM_CAB_ESTADO`
    FROM
        ((`compras_cab` `C`
        JOIN `persona` `P` ON ((`P`.`PER_ID` = `C`.`COM_CAB_PROVEEDOR_ID`)))
        JOIN `persona` `U` ON ((`U`.`PER_ID` = `C`.`COM_CAB_USUARIO_ID`)))
    WHERE 
    ( 
		(`C`.`COM_CAB_FECHA` BETWEEN _DESDE AND _HASTA )
		AND
        (`P`.`PER_ID` = `C`.`COM_CAB_PROVEEDOR_ID`)
        AND 
        (`U`.`PER_ID` = `C`.`COM_CAB_USUARIO_ID`)
        AND
        (
        `C`.`COM_CAB_TIPO_COMPROVANTE`=_TCOMPROVANTE
        )
        and
        (
         `C`.`COM_CAB_ESTADO`=true
        )
	)
    ORDER BY `C`.`COM_CAB_ID`;
    
    WHEN 'TODO' THEN
SELECT 
        `C`.`COM_CAB_ID` AS `COM_CAB_ID`,
        `C`.`COM_CAB_PROVEEDOR_ID` AS `COM_CAB_PROVEEDOR_ID`,
        `P`.`PER_NOMBRE` AS `PROVEEDOR`,
        `C`.`COM_CAB_USUARIO_ID` AS `COM_CAB_USUARIO_ID`,
        `U`.`PER_NOMBRE` AS `USUARIO`,
        `C`.`COM_CAB_FECHA` AS `COM_CAB_FECHA`,
        `C`.`COM_CAB_TIPO_COMPROVANTE` AS `COM_CAB_TIPO_COMPROVANTE`,
        `C`.`COM_CAB_NUM_COMPROVANTE` AS `COM_CAB_NUM_COMPROVANTE`,
        `C`.`COM_CAB_SUBTOTAL` AS `COM_CAB_SUBTOTAL`,
        `C`.`COM_CAB_IVA` AS `COM_CAB_IVA`,
        `C`.`COM_CAB_TOTAL` AS `COM_CAB_TOTAL`,
        `C`.`COM_CAB_ESTADO` AS `COM_CAB_ESTADO`
    FROM
        ((`compras_cab` `C`
        JOIN `persona` `P` ON ((`P`.`PER_ID` = `C`.`COM_CAB_PROVEEDOR_ID`)))
        JOIN `persona` `U` ON ((`U`.`PER_ID` = `C`.`COM_CAB_USUARIO_ID`)))
    WHERE 
    ( 
		(`C`.`COM_CAB_FECHA` BETWEEN _DESDE AND _HASTA )
		AND
        (`P`.`PER_ID` = `C`.`COM_CAB_PROVEEDOR_ID`)
        AND 
        (`U`.`PER_ID` = `C`.`COM_CAB_USUARIO_ID`)
        AND
        (
        `C`.`COM_CAB_TIPO_COMPROVANTE`=_TCOMPROVANTE
        )
	)
    ORDER BY `C`.`COM_CAB_ID`;

		END case;
END$$

DROP PROCEDURE IF EXISTS `buscaCompraDetalle`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `buscaCompraDetalle` (IN `_COM_CAB_ID` INT(10))  BEGIN
	SELECT
		CD.COM_DET_CATIDAD,
		CD.PRO_ID,
		P.PRO_NOMBRE,
		CD.COM_DET_VALOR,
		CD.COM_DET_TOTAL
	FROM COMPRAS_DETALLE CD
	JOIN PRODUCTO P ON P.PRO_ID=CD.PRO_ID
	WHERE CD.COM_CAB_ID=_COM_CAB_ID;
END$$

DROP PROCEDURE IF EXISTS `buscaFacturaDetalle`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `buscaFacturaDetalle` (IN `_FAC_CAB_ID` INT(10))  BEGIN
	SELECT FD.FAC_CAB_ID, 
    FD.FAC_DET_CANTIDAD, 
    FD.PRO_ID, P.PRO_NOMBRE, 
    FD.FAC_DET_PVP,
	FD.FAC_DET_DESCUENTO,
    FD.FAC_DET_TOTAL 
    FROM FACTURA_DETALLE FD 
    JOIN PRODUCTO P ON P.PRO_ID=FD.PRO_ID 
    WHERE FD.FAC_CAB_ID=_FAC_CAB_ID;
END$$

DROP PROCEDURE IF EXISTS `buscaOrdenReparacion`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `buscaOrdenReparacion` (IN `buscar` VARCHAR(10))  BEGIN
SELECT *FROM REPARACION WHERE  (`REP_ID` LIKE buscar);    
END$$

DROP PROCEDURE IF EXISTS `buscaProducto`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `buscaProducto` (IN `buscar` VARCHAR(50))  BEGIN
	SELECT *FROM PRODUCTO WHERE  (PRO_ID LIKE buscar OR PRO_NOMBRE LIKE buscar OR PRO_DESCRIPCION LIKE buscar);    
END$$

DROP PROCEDURE IF EXISTS `buscaProductoById`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `buscaProductoById` (IN `buscar` VARCHAR(5))  BEGIN

	SELECT 
    PRO_ID, 
    PRO_NOMBRE,
    PRO_DESCRIPCION,
    PRO_PRECIO_COSTO,
    PRO_PRECIO_VENTA,
    PRO_STOCK,
    PRO_STOCK_MINIMO,
    PRO_ESTADO,
    CAT_ID
    FROM PRODUCTO WHERE PRO_ID=buscar;
     

END$$

DROP PROCEDURE IF EXISTS `buscaProveedor`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `buscaProveedor` (IN `buscar` VARCHAR(50))  BEGIN
 SELECT
     PERSONA.`PER_ID` AS PERSONA_PER_ID,
     PERSONA.`PER_CEDULA` AS PERSONA_PER_CEDULA,
     PERSONA.`PER_NOMBRE` AS PERSONA_PER_NOMBRE,
     PERSONA.`PER_DIRECCION` AS PERSONA_PER_DIRECCION,
     PERSONA.`PER_TELEFONO` AS PERSONA_PER_TELEFONO,
     PERSONA.`PER_CELULAR` AS PERSONA_PER_CELULAR,
     PERSONA.`PER_CORREO` AS PERSONA_PER_CORREO,
     PERSONA.`PER_SEXO` AS PERSONA_PER_SEXO,
     PROV_ESTADO
FROM
     `PERSONA` PERSONA INNER JOIN `PROVEEDOR` PROVEEDOR
     ON  PROVEEDOR.`PER_ID`=PERSONA.`PER_ID` AND ( PROVEEDOR.`PER_ID` LIKE buscar  OR  PERSONA.`PER_CEDULA` LIKE buscar   OR PERSONA.`PER_NOMBRE` LIKE buscar );
     
END$$

DROP PROCEDURE IF EXISTS `buscaProveedorById`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `buscaProveedorById` (IN `buscar` VARCHAR(5))  BEGIN

	SELECT
     PERSONA.`PER_ID` AS PERSONA_PER_ID,
     PERSONA.`PER_CEDULA` AS PERSONA_PER_CEDULA,
     PERSONA.`PER_NOMBRE` AS PERSONA_PER_NOMBRE,
     PERSONA.`PER_DIRECCION` AS PERSONA_PER_DIRECCION,
     PERSONA.`PER_TELEFONO` AS PERSONA_PER_TELEFONO,
     PERSONA.`PER_CELULAR` AS PERSONA_PER_CELULAR,
     PERSONA.`PER_CORREO` AS PERSONA_PER_CORREO,
     PERSONA.`PER_SEXO` AS PERSONA_PER_SEXO,
     PROV_FECHA_REGISTRO,
     PROV_OBSERVACION,
     PROV_ESTADO
FROM
     `PERSONA` PERSONA INNER JOIN `PROVEEDOR` PROVEEDOR 
     ON  PROVEEDOR.`PER_ID`=PERSONA.`PER_ID` AND ( PROVEEDOR.`PER_ID` = buscar );
     

END$$

DROP PROCEDURE IF EXISTS `buscarProveedorByNombre`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `buscarProveedorByNombre` (IN `buscar` VARCHAR(50))  BEGIN
SELECT
     PERSONA.`PER_ID` AS PERSONA_PER_ID,
     PERSONA.`PER_CEDULA` AS PERSONA_PER_CEDULA,
     PERSONA.`PER_NOMBRE` AS PERSONA_PER_NOMBRE,
     PERSONA.`PER_DIRECCION` AS PERSONA_PER_DIRECCION,
     PERSONA.`PER_TELEFONO` AS PERSONA_PER_TELEFONO,
     PERSONA.`PER_CELULAR` AS PERSONA_PER_CELULAR,
     PERSONA.`PER_CORREO` AS PERSONA_PER_CORREO,
     PERSONA.`PER_SEXO` AS PERSONA_PER_SEXO,
     PROV_ESTADO
FROM
     `PERSONA` PERSONA INNER JOIN `PROVEEDOR` PROVEEDOR
     ON  PROVEEDOR.`PER_ID`=PERSONA.`PER_ID` AND ( PERSONA.`PER_NOMBRE` LIKE buscar );
     
END$$

DROP PROCEDURE IF EXISTS `buscaTipoUsuario`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `buscaTipoUsuario` (IN `buscar` VARCHAR(50))  BEGIN
	select * from TIPO_USUARIO
    WHERE TIP_USU_ESTADO=TRUE AND (TIP_USU_ID LIKE buscar OR TIP_USU_DESCRIPCION LIKE buscar);
END$$

DROP PROCEDURE IF EXISTS `buscaUsuario`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `buscaUsuario` (IN `buscar` VARCHAR(50))  BEGIN
     SELECT
     PERSONA.`PER_ID` AS PERSONA_PER_ID,
     PERSONA.`PER_CEDULA` AS PERSONA_PER_CEDULA,
     PERSONA.`PER_NOMBRE` AS PERSONA_PER_NOMBRE,
     PERSONA.`PER_DIRECCION` AS PERSONA_PER_DIRECCION,
     PERSONA.`PER_TELEFONO` AS PERSONA_PER_TELEFONO,
     PERSONA.`PER_CELULAR` AS PERSONA_PER_CELULAR,
     PERSONA.`PER_CORREO` AS PERSONA_PER_CORREO,
     PERSONA.`PER_SEXO` AS PERSONA_PER_SEXO,
     USU_ESTADO
FROM
     `PERSONA` PERSONA INNER JOIN `USUARIO` USUARIO 
     ON  USUARIO.`PER_ID`=PERSONA.`PER_ID` AND ( USUARIO.`PER_ID` LIKE buscar  OR  PERSONA.`PER_CEDULA` LIKE buscar   OR PERSONA.`PER_NOMBRE` LIKE buscar );
     
END$$

DROP PROCEDURE IF EXISTS `buscaUsuarioById`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `buscaUsuarioById` (IN `buscar` VARCHAR(5))  BEGIN

	SELECT
     PERSONA.`PER_ID` AS PERSONA_PER_ID,
     PERSONA.`PER_CEDULA` AS PERSONA_PER_CEDULA,
     PERSONA.`PER_NOMBRE` AS PERSONA_PER_NOMBRE,
     PERSONA.`PER_DIRECCION` AS PERSONA_PER_DIRECCION,
     PERSONA.`PER_TELEFONO` AS PERSONA_PER_TELEFONO,
     PERSONA.`PER_CELULAR` AS PERSONA_PER_CELULAR,
     PERSONA.`PER_CORREO` AS PERSONA_PER_CORREO,
     PERSONA.`PER_SEXO` AS PERSONA_PER_SEXO,
     USU_NOMBRE_USUARIO,
     USU_CLAVE,
     USU_FECHA_NACIMIENTO,
     USU_FECHA_INGRESO,
     USU_SUELDO,
     TIP_USU_ID,
     USU_ESTADO
FROM
     `PERSONA` PERSONA INNER JOIN `USUARIO` USUARIO 
     ON  USUARIO.`PER_ID`=PERSONA.`PER_ID` AND ( USUARIO.`PER_ID` = buscar );
     

END$$

DROP PROCEDURE IF EXISTS `buscaVentaCabesera`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `buscaVentaCabesera` (IN `_DESDE` DATETIME, IN `_HASTA` DATETIME, IN `ACCION` VARCHAR(40))  BEGIN
CASE ACCION
	WHEN 'CONSULTA' THEN
	SELECT FC.FAC_CAB_ID,
		FC.FAC_CAB_FECHA,
        FC.FAC_CAB_SUBTOTAL,
        FC.FAC_DET_DESCUENTO,
        FC.FAC_CAB_IVA,
        FC.FAC_CAB_TOTAL,
        FC.FAC_CAB_FORMA_P,
        FC.PER_ID,
        C.PER_NOMBRE,
        FC.USUARIO_ID,
        U.PER_NOMBRE,
        FC.FAC_CAB_ESTADO       
FROM FACTURA_CAB FC
	JOIN PERSONA C ON C.PER_ID=FC.PER_ID
    JOIN PERSONA U ON U.PER_ID=FC.USUARIO_ID
    WHERE FC.FAC_CAB_FECHA BETWEEN _DESDE AND _HASTA
    AND FC.FAC_CAB_ESTADO = TRUE;
    
    WHEN 'TODO' THEN
    SELECT FC.FAC_CAB_ID,
		FC.FAC_CAB_FECHA,
        FC.FAC_CAB_SUBTOTAL,
        FC.FAC_CAB_DESCUENTO,
        FC.FAC_CAB_IVA,
        FC.FAC_CAB_TOTAL,
        FC.FAC_CAB_FORMA_P,
        FC.PER_ID,
        C.PER_NOMBRE,
        FC.USUARIO_ID,
        U.PER_NOMBRE,
        FC.FAC_CAB_ESTADO       
FROM FACTURA_CAB FC
	JOIN PERSONA C ON C.PER_ID=FC.PER_ID
    JOIN PERSONA U ON U.PER_ID=FC.USUARIO_ID
    WHERE FC.FAC_CAB_FECHA BETWEEN _DESDE AND _HASTA;
END case;
END$$

DROP PROCEDURE IF EXISTS `CLIENTECRUD`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `CLIENTECRUD` (IN `_PER_ID` INT, IN `_CLI_RUC` VARCHAR(60), IN `_CLI_OBSERVACION` VARCHAR(60), IN `accion` VARCHAR(40))  BEGIN
		case accion
        
        WHEN 'NUEVO' then
				INSERT into CLIENTE (PER_ID,CLI_RUC,CLI_OBSERVACION)
				values (_PER_ID, _CLI_RUC, _CLI_OBSERVACION);        
        WHEN 'EDITAR' then
				UPDATE CLIENTE SET                
                CLI_RUC=_CLI_RUC,
                CLI_OBSERVACION=_CLI_OBSERVACION
                where PER_ID=_PER_ID;
		WHEN 'ELIMINAR' THEN
				DELETE FROM CLIENTE where PER_ID=_PER_ID;
		when 'CONSULTAR' THEN
				SELECT * FROM CLIENTE WHERE PER_ID=_PER_ID;
		end case;
END$$

DROP PROCEDURE IF EXISTS `consultasDetalladas`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `consultasDetalladas` (IN `_DESDE` DATETIME, IN `_HASTA` DATETIME, IN `ACCION` VARCHAR(40))  BEGIN
CASE ACCION
		WHEN 'VENTAS' THEN
				SELECT * FROM `vistafacturasaldetalle` WHERE `FAC_CAB_FECHA` BETWEEN _DESDE AND _HASTA;
		when 'COMPRAS' THEN 
				SELECT * FROM `vistacomprasaldetalle` WHERE `COM_CAB_FECHA` BETWEEN _DESDE AND _HASTA;
                
    END case;

END$$

DROP PROCEDURE IF EXISTS `CreaModificaCategoria`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `CreaModificaCategoria` (IN `_CAT_ID` INT, IN `_CAT_DESCRIPCION` VARCHAR(50), IN `_CAT_IMAGEN` LONGBLOB, IN `ACCION` VARCHAR(40))  BEGIN	

CASE ACCION
	WHEN 'CREAR' THEN
		INSERT INTO `CATEGORIA`
		(
			CAT_DESCRIPCION,
            CAT_IMAGEN
		) 
		VALUES
		(
			_CAT_DESCRIPCION,
            _CAT_IMAGEN
		);
        
        WHEN 'MODIFICAR' THEN
				UPDATE CATEGORIA SET 
                CAT_DESCRIPCION =_CAT_DESCRIPCION,
                CAT_IMAGEN=_CAT_IMAGEN
                WHERE CAT_ID =_CAT_ID ;
        
		END case;
END$$

DROP PROCEDURE IF EXISTS `CreaModificaComprasCab`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `CreaModificaComprasCab` (IN `_COM_CAB_ID` INT(11), IN `_COM_CAB_PROVEEDOR_ID` INT(11), IN `_COM_CAB_USUARIO_ID` INT(11), IN `_COM_CAB_FECHA` VARCHAR(20), IN `_COM_CAB_TIPO_COMPROVANTE` INT(3), IN `_COM_CAB_NUM_COMPROVANTE` INT(11), IN `_COM_CAB_SUBTOTAL` DOUBLE, IN `_COM_CAB_IVA` DOUBLE, IN `_COM_CAB_TOTAL` DOUBLE, IN `_COM_CAB_ESTADO` TINYINT, IN `ACCION` VARCHAR(40))  BEGIN
	CASE ACCION
		WHEN 'CREAR' THEN        
        
			INSERT INTO COMPRAS_CAB
				(
					COM_CAB_ID,
                    COM_CAB_PROVEEDOR_ID,
                    COM_CAB_USUARIO_ID,
                    COM_CAB_FECHA,
                    COM_CAB_TIPO_COMPROVANTE,
                    COM_CAB_NUM_COMPROVANTE,
                    COM_CAB_SUBTOTAL,
                    COM_CAB_IVA,
                    COM_CAB_TOTAL,
                    COM_CAB_ESTADO
				) 
				VALUES 
				(
					_COM_CAB_ID,
                    _COM_CAB_PROVEEDOR_ID,
                    _COM_CAB_USUARIO_ID,
                    now(),
                    _COM_CAB_TIPO_COMPROVANTE,
                    _COM_CAB_NUM_COMPROVANTE,
                    _COM_CAB_SUBTOTAL,
                    _COM_CAB_IVA,
                    _COM_CAB_TOTAL,
                    _COM_CAB_ESTADO
				);
        
        
        
    
    END case;

END$$

DROP PROCEDURE IF EXISTS `CreaModificaComprasDetalle`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `CreaModificaComprasDetalle` (IN `_COM_CAB_ID` INT(10), IN `_PRO_ID` INT(10), IN `_COM_DET_CATIDAD` INT(10), IN `_COM_DET_VALOR` DOUBLE, IN `_COM_DET_TOTAL` DOUBLE, IN `_KAR_FECHA` VARCHAR(40), IN `_KAR_DETALLE` VARCHAR(500), IN `_KAR_XCANT` INT(10), IN `_KAR_XVU` DOUBLE, IN `_KAR_XVT` DOUBLE, IN `ACCION` VARCHAR(40))  BEGIN
	CASE ACCION
		WHEN 'CREAR' THEN        
        
			INSERT INTO COMPRAS_DETALLE
            (
				COM_CAB_ID,
				PRO_ID,
				COM_DET_CATIDAD,
				COM_DET_VALOR,
				COM_DET_TOTAL
			)
            VALUES 
            (
				_COM_CAB_ID,
				_PRO_ID,
				_COM_DET_CATIDAD,
				_COM_DET_VALOR,
				_COM_DET_TOTAL
			); 
            INSERT INTO KARDEX
					(
						PRO_ID,
						KAR_FECHA,
                        KAR_DETALLE,
                        KAR_ECANT,
                        KAR_EVU,
                        KAR_EVT,
                        KAR_XCANT,
                        KAR_XVU,
                        KAR_XVT
					) 
					VALUES 
					(
						_PRO_ID,
						 now(),
						_KAR_DETALLE,
						_COM_DET_CATIDAD,
                        round(_COM_DET_VALOR,2) ,
                        round(_COM_DET_TOTAL,2),
                        (_KAR_XCANT+_COM_DET_CATIDAD),
                        round((_COM_DET_TOTAL+_KAR_XVT)/(_COM_DET_CATIDAD+_KAR_XCANT),2),
                        round((_COM_DET_TOTAL+_KAR_XVT),2)
					);  
                    
                    UPDATE PRODUCTO SET 
					PRO_PRECIO_COSTO =round((_COM_DET_TOTAL+_KAR_XVT)/(_COM_DET_CATIDAD+_KAR_XCANT),2),
					PRO_STOCK =  (_COM_DET_CATIDAD+_KAR_XCANT)
                WHERE PRO_ID= _PRO_ID;
                
                WHEN 'ANULAR' THEN
                INSERT INTO KARDEX
					(
						PRO_ID,
						KAR_FECHA,
                        KAR_DETALLE,
                        KAR_ECANT,
                        KAR_EVU,
                        KAR_EVT,
                        KAR_XCANT,
                        KAR_XVU,
                        KAR_XVT
					) 
					VALUES 
					(
						_PRO_ID,
						 now(),
						_KAR_DETALLE,
						_COM_DET_CATIDAD,
                        _COM_DET_VALOR ,
                        _COM_DET_TOTAL,
                        (_KAR_XCANT+_COM_DET_CATIDAD),
                        round((_COM_DET_TOTAL+_KAR_XVT)/(_COM_DET_CATIDAD+_KAR_XCANT),2),
                        (_COM_DET_TOTAL+_KAR_XVT)
					);  
                    
                    UPDATE PRODUCTO SET 
					PRO_PRECIO_COSTO =round((_COM_DET_TOTAL+_KAR_XVT)/(_COM_DET_CATIDAD+_KAR_XCANT),2),
					PRO_STOCK =  (_COM_DET_CATIDAD+_KAR_XCANT)
                WHERE PRO_ID= _PRO_ID;
    
    END case;    
    

END$$

DROP PROCEDURE IF EXISTS `CreaModificaFacturaCab`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `CreaModificaFacturaCab` (IN `_FAC_CAB_ID` INT(11), IN `_FAC_CAB_FECHA` DATE, IN `_FAC_CAB_SUBTOTAL` DOUBLE, IN `_FAC_CAB_DESCUENTO` DOUBLE, IN `_FAC_CAB_IVA` DOUBLE, IN `_FAC_CAB_TOTAL` DOUBLE, IN `_FAC_CAB_FORMA_P` INT(3), IN `_PER_ID` INT(11), IN `_USUARIO_ID` INT(11), IN `_FAC_CAB_ESTADO` TINYINT, IN `ACCION` VARCHAR(40))  BEGIN
	CASE ACCION
		WHEN 'FACTURA' THEN        
        
			INSERT INTO FACTURA_CAB
				(
					FAC_CAB_ID,
                    FAC_CAB_FECHA,
                    FAC_CAB_SUBTOTAL,
                    FAC_CAB_DESCUENTO,
                    FAC_CAB_IVA,
                    FAC_CAB_TOTAL,
                    FAC_CAB_FORMA_P,
                    PER_ID,
                    USUARIO_ID,
                    FAC_CAB_ESTADO					
				) 
				VALUES 
				(
					_FAC_CAB_ID,
                    now(),
                    _FAC_CAB_SUBTOTAL,
                    _FAC_CAB_DESCUENTO,
                    _FAC_CAB_IVA,
                    _FAC_CAB_TOTAL,
                    _FAC_CAB_FORMA_P,
                    _PER_ID,
                    _USUARIO_ID,
                    _FAC_CAB_ESTADO
				);
                
                WHEN 'NOTA' THEN 
        
			INSERT INTO NOTA_CAB
				(
					NOT_CAB_ID,
                    NOT_CAB_FECHA,
                    NOT_CAB_DESCUENTO,
                    NOT_CAB_TOTAL,
                    NOT_CAB_FORMA_P,
                    PER_ID,
                    USUARIO_ID,
                    NOT__CAB_ESTADO				
				) 
				VALUES 
				(
					_FAC_CAB_ID,
                    now(),                    
                    _FAC_CAB_DESCUENTO,
                    _FAC_CAB_TOTAL,
                    _FAC_CAB_FORMA_P,
                    _PER_ID,
                    _USUARIO_ID,
                    _FAC_CAB_ESTADO
				);
                
    END case;

END$$

DROP PROCEDURE IF EXISTS `CreaModificaFacturaDetalle`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `CreaModificaFacturaDetalle` (IN `_FAC_CAB_ID` INT(10), IN `_PRO_ID` INT(10), IN `_FAC_DET_CANTIDAD` INT(10), IN `_FAC_DET_PVP` DOUBLE, IN `_FAC_DET_DESCUENTO` DOUBLE, IN `_FAC_DET_TOTAL` DOUBLE, IN `_FAC_DET_PC` DOUBLE, IN `_KAR_FECHA` DATE, IN `_KAR_DETALLE` VARCHAR(500), IN `_KAR_XCANT` INT(10), IN `_KAR_XVU` DOUBLE, IN `_KAR_XVT` DOUBLE, IN `ACCION` VARCHAR(40))  BEGIN
	CASE ACCION
		WHEN 'FACTURA' THEN        
        
			INSERT INTO FACTURA_DETALLE
            (
				FAC_CAB_ID,
				PRO_ID,
				FAC_DET_CANTIDAD,				
				FAC_DET_PVP,
                FAC_DET_DESCUENTO,
				FAC_DET_TOTAL,
                FAC_DET_PC
			)
            VALUES 
            (
				_FAC_CAB_ID,
				_PRO_ID,
				_FAC_DET_CANTIDAD,
				_FAC_DET_PVP,
                _FAC_DET_DESCUENTO,
				_FAC_DET_TOTAL,
                _FAC_DET_PC
			); 
            
            INSERT INTO KARDEX
					(
						PRO_ID,
						KAR_FECHA,
                        KAR_DETALLE,
                        KAR_SCANT,
                        KAR_SVU,
                        KAR_SVT,
                        KAR_XCANT,
                        KAR_XVU,
                        KAR_XVT
					) 
					VALUES 
					(
						_PRO_ID,
						now(),
						_KAR_DETALLE,
						_FAC_DET_CANTIDAD,
                        round(_KAR_XVU ,2),
                        round((_FAC_DET_CANTIDAD*_KAR_XVU),2),
                        (_KAR_XCANT-_FAC_DET_CANTIDAD),
                        round(((_KAR_XVT-(_FAC_DET_CANTIDAD*_KAR_XVU))/(_KAR_XCANT-_FAC_DET_CANTIDAD)),2),
                        round((_KAR_XVT-(_FAC_DET_CANTIDAD*_KAR_XVU)),2)
					);  
                    
                    UPDATE PRODUCTO SET 					
					PRO_STOCK =  (_KAR_XCANT-_FAC_DET_CANTIDAD)
                WHERE PRO_ID= _PRO_ID;
                
		WHEN 'ANULAR' THEN
			INSERT INTO KARDEX
					(
						PRO_ID,
						KAR_FECHA,
                        KAR_DETALLE,
                        KAR_SCANT,		/*catidad anterior*/
                        KAR_SVU,			/*valor anterior*/
                        KAR_SVT,			/*total anterior*/
                        KAR_XCANT,		/*catidad actual kaardex*/
                        KAR_XVU,			/*valor actual kaardex*/
                        KAR_XVT			/*total actual kaardex*/
					) 
					VALUES 
					(
						_PRO_ID,
						now(),
						_KAR_DETALLE,
						/*catidad anterior*/ -_FAC_DET_CANTIDAD,
                        /*valor anterior*/ -_FAC_DET_PVP ,
                        /*total anterior*/ -_FAC_DET_TOTAL,
                       /*catidad actual kaardex*/ (_KAR_XCANT+_FAC_DET_CANTIDAD),
                       /*valor actual kaardex*/ ((_KAR_XVT+_FAC_DET_TOTAL)/(_KAR_XCANT+_FAC_DET_CANTIDAD)),
                        /*total actual kaardex*/ (_KAR_XVT+_FAC_DET_TOTAL)
					);  
                    
                    UPDATE PRODUCTO SET 					
					PRO_STOCK =  (_KAR_XCANT+_FAC_DET_CANTIDAD)
                WHERE PRO_ID= _PRO_ID;
                
                
			
            
            
            WHEN 'NOTA' THEN        
           
        
			INSERT INTO NOTA_DETALLE
            (
				NOT_CAB_ID,
				PRO_ID,
				NOT_DET_CANTIDAD,				
				NOT_DET_PVP,
                NOT_DET_DESCUENTO,
                NOT_DET_TOTAL,
				NOT_DET_PC
			)
            VALUES 
            (
				_FAC_CAB_ID,
				_PRO_ID,
				_FAC_DET_CANTIDAD,
				_FAC_DET_PVP,
                _FAC_DET_DESCUENTO,
				_FAC_DET_TOTAL,
                _FAC_DET_PC
			); 
            
            INSERT INTO KARDEX
					(
						PRO_ID,
						KAR_FECHA,
                        KAR_DETALLE,
                        KAR_SCANT,
                        KAR_SVU,
                        KAR_SVT,
                        KAR_XCANT,
                        KAR_XVU,
                        KAR_XVT
					) 
					VALUES 
					(
						_PRO_ID,
						now(),
						_KAR_DETALLE,
						_FAC_DET_CANTIDAD,
                        round(_KAR_XVU ,2),
                        round((_FAC_DET_CANTIDAD*_KAR_XVU),2),
                        (_KAR_XCANT-_FAC_DET_CANTIDAD),
                        round(((_KAR_XVT-(_FAC_DET_CANTIDAD*_KAR_XVU))/(_KAR_XCANT-_FAC_DET_CANTIDAD)),2),
                        round((_KAR_XVT-(_FAC_DET_CANTIDAD*_KAR_XVU)),2)
					);  
                    
                    UPDATE PRODUCTO SET 					
					PRO_STOCK =  (_KAR_XCANT-_FAC_DET_CANTIDAD)
                WHERE PRO_ID= _PRO_ID;
                
		
        
    END case;

END$$

DROP PROCEDURE IF EXISTS `CreaModificaOrdenReparacion`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `CreaModificaOrdenReparacion` (IN `_REP_ID` INT(10), IN `_PER_ID` INT(10), IN `_FECHA` DATE, IN `_IMEI` VARCHAR(30), IN `_MARCA` VARCHAR(30), IN `_FECHA_DE_ENTREGA` DATE, IN `_BATERIA` TINYINT, IN `_CHIP` TINYINT, IN `_MEMORIA` TINYINT, IN `_TAPA` TINYINT, IN `_CARGADOR` TINYINT, IN `_OTROS` VARCHAR(100), IN `_DIAGNOSTICO` VARCHAR(500), IN `_TOTAL` DOUBLE, IN `_ABONO` DOUBLE, IN `_SALDO` DOUBLE, IN `_ESTADO` TINYINT, IN `ACCION` VARCHAR(40))  BEGIN
CASE ACCION
		WHEN 'REGISTRA' THEN 
        
        INSERT INTO `REPARACION`
        (
        `REP_ID`,
        `PER_ID`, 
        `FECHA`,
        `IMEI`, 
        `MARCA`,
        `FECHA_DE_ENTREGA`,
        `BATERIA`, 
        `CHIP`, 
        `MEMORIA`, 
        `TAPA`, 
        `CARGADOR`, 
        `OTROS`, 
        `DIAGNOSTICO`, 
        `TOTAL`, 
        `ABONO`, 
        `SALDO`, 
        `ESTADO`
        ) 
        VALUES 
        (
			 _REP_ID,
			 _PER_ID,
             now(),
			 _IMEI,
			 _MARCA,
			 _FECHA_DE_ENTREGA,
			 _BATERIA,
			 _CHIP ,
			 _MEMORIA,
			 _TAPA,
			 _CARGADOR,
			 _OTROS,
			 _DIAGNOSTICO ,
             _TOTAL,
             _ABONO,
             _SALDO,
			 _ESTADO
        );
        
        WHEN 'ACTUALIZA' THEN  
        UPDATE `REPARACION` SET 
        `PER_ID` = _PER_ID,
        `FECHA`=_FECHA,
        `IMEI` = _IMEI,
        `MARCA` =_MARCA,
        `FECHA_DE_ENTREGA` = _FECHA_DE_ENTREGA,
        `BATERIA` = _BATERIA,
        `CHIP` = _CHIP ,
        `MEMORIA` = _MEMORIA,
        `TAPA` =_TAPA,
        `CARGADOR` = _CARGADOR,
        `OTROS` = _OTROS,
        `DIAGNOSTICO` = _TOTAL ,
         `TOTAL` = _DIAGNOSTICO ,
          `ABONO` = _ABONO ,
           `SALDO` = _SALDO ,
        `ESTADO` = _ESTADO
        WHERE `REPARACION`.`REP_ID` = _REP_ID;
                
    END case;
END$$

DROP PROCEDURE IF EXISTS `CreaModificaProducto`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `CreaModificaProducto` (IN `_PRO_ID` INT(11), IN `_PRO_NOMBRE` VARCHAR(50), IN `_PRO_DESCRIPCION` VARCHAR(100), IN `_PRO_PRECIO_COSTO` DOUBLE, IN `_PRO_PRECIO_VENTA` DOUBLE, IN `_PRO_STOCK` INT(11), IN `_PRO_STOCK_MINIMO` INT(11), IN `_PRO_ESTADO` TINYINT, IN `_CAT_ID` INT(11), IN `ACCION` VARCHAR(40))  BEGIN
CASE ACCION
			WHEN 'CREAR' THEN
				INSERT INTO PRODUCTO
					(
						PRO_ID,
						PRO_NOMBRE,
						PRO_DESCRIPCION,
						PRO_PRECIO_COSTO ,
						PRO_PRECIO_VENTA,
						PRO_STOCK,
                        PRO_STOCK_MINIMO,		
                        PRO_ESTADO,
                        CAT_ID 
					) 
					VALUES 
					(
						_PRO_ID,
						_PRO_NOMBRE,
						_PRO_DESCRIPCION,
						_PRO_PRECIO_COSTO ,
						_PRO_PRECIO_VENTA,
						_PRO_STOCK,
                        _PRO_STOCK_MINIMO,		
                        _PRO_ESTADO,
                        _CAT_ID 
					);
                    
				INSERT INTO KARDEX
					(
						PRO_ID,
						KAR_FECHA,
                        KAR_DETALLE,
                        KAR_ECANT,
                        KAR_EVU,
                        KAR_EVT,
                        KAR_XCANT,
                        KAR_XVU,
                        KAR_XVT
					) 
					VALUES 
					(
						_PRO_ID,
						now(),
						'Inventario Inicial' ,
						_PRO_STOCK,
                        _PRO_PRECIO_COSTO ,
                        (_PRO_STOCK*_PRO_PRECIO_COSTO),
                        _PRO_STOCK,
                        (_PRO_STOCK*_PRO_PRECIO_COSTO)/ _PRO_STOCK,
                        (_PRO_STOCK*_PRO_PRECIO_COSTO)
					);  
                    
			WHEN 'MODIFICAR_PRODUCTO' THEN
				UPDATE PRODUCTO SET 
					PRO_NOMBRE = _PRO_NOMBRE,
					PRO_DESCRIPCION = _PRO_DESCRIPCION,
                    PRO_STOCK=_PRO_STOCK,
                    PRO_PRECIO_COSTO=_PRO_PRECIO_COSTO,
					PRO_PRECIO_VENTA = _PRO_PRECIO_VENTA,
					PRO_STOCK_MINIMO = _PRO_STOCK_MINIMO, 
					PRO_ESTADO = _PRO_ESTADO,
					CAT_ID = _CAT_ID 
                WHERE PRO_ID= _PRO_ID;               
                
                
                    
                    WHEN 'MODIFICAR_TODO' THEN
				UPDATE PRODUCTO SET 
					PRO_NOMBRE = _PRO_NOMBRE,
					PRO_DESCRIPCION = _PRO_DESCRIPCION,
                    PRO_STOCK=_PRO_STOCK,
                    PRO_PRECIO_COSTO=_PRO_PRECIO_COSTO,
					PRO_PRECIO_VENTA = _PRO_PRECIO_VENTA,
					PRO_STOCK_MINIMO = _PRO_STOCK_MINIMO, 
					PRO_ESTADO = _PRO_ESTADO,
					CAT_ID = _CAT_ID 
                WHERE PRO_ID= _PRO_ID;
                
                
                UPDATE KARDEX
					
						SET KAR_FECHA=now(),                       
                        KAR_ECANT=_PRO_STOCK,
                        KAR_EVU=_PRO_PRECIO_COSTO ,
                        KAR_EVT=(_PRO_STOCK*_PRO_PRECIO_COSTO),
                        KAR_XCANT=  _PRO_STOCK,
                        KAR_XVU= (_PRO_STOCK*_PRO_PRECIO_COSTO)/ _PRO_STOCK,
                        KAR_XVT=  (_PRO_STOCK*_PRO_PRECIO_COSTO)
					WHERE  KARDEX.PRO_ID=_PRO_ID;
                    
		END case;
END$$

DROP PROCEDURE IF EXISTS `CrearModificaCliente`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `CrearModificaCliente` (IN `_PER_ID` INT(11), IN `_PER_CEDULA` VARCHAR(13), IN `_PER_NOMBRE` VARCHAR(100), IN `_PER_DIRECCION` VARCHAR(200), IN `_PER_TELEFONO` VARCHAR(10), IN `_PER_CELULAR` VARCHAR(10), IN `_PER_CORREO` VARCHAR(100), IN `_PER_SEXO` VARCHAR(1), IN `_CLI_FECHA_REGISTRO` DATE, IN `_CLI_OBSERVACION` VARCHAR(300), IN `_CLI_ESTADO` TINYINT, IN `ACCION` VARCHAR(40))  BEGIN
CASE ACCION
			WHEN 'CREAR' THEN
				INSERT INTO PERSONA
					(
						PER_ID,
						PER_CEDULA,
						PER_NOMBRE,
						PER_DIRECCION,
						PER_TELEFONO,
						PER_CELULAR,
						PER_CORREO,
                        PER_SEXO				
					) 
					VALUES 
					(
						_PER_ID,
						_PER_CEDULA,
						_PER_NOMBRE,
						_PER_DIRECCION,
						_PER_TELEFONO,
						_PER_CELULAR,
						_PER_CORREO,
                        _PER_SEXO
					);
                    
				INSERT INTO CLIENTE
					(
						PER_ID,
						CLI_FECHA_REGISTRO,
						CLI_OBSERVACION,
						CLI_ESTADO
					) 
					VALUES 
					(
						_PER_ID,
						_CLI_FECHA_REGISTRO,
						_CLI_OBSERVACION,
						_CLI_ESTADO
					);    
            
            
            WHEN 'MODIFICAR' THEN
				UPDATE PERSONA SET 					
					PER_CEDULA=_PER_CEDULA,
					PER_NOMBRE=_PER_NOMBRE,
					PER_DIRECCION=_PER_DIRECCION,
					PER_TELEFONO=_PER_TELEFONO,
					PER_CELULAR=_PER_CELULAR,
					PER_CORREO=_PER_CORREO,
					PER_SEXO=_PER_SEXO                    
				WHERE PER_ID=_PER_ID;
                
                UPDATE CLIENTE SET 					
					
						CLI_FECHA_REGISTRO=_CLI_FECHA_REGISTRO,
						CLI_OBSERVACION=_CLI_OBSERVACION,
						CLI_ESTADO=_CLI_ESTADO
				WHERE PER_ID=_PER_ID;
            
            
		END case;
        
        

END$$

DROP PROCEDURE IF EXISTS `CrearModificaProveedor`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `CrearModificaProveedor` (IN `_PER_ID` INT(11), IN `_PER_CEDULA` VARCHAR(13), IN `_PER_NOMBRE` VARCHAR(100), IN `_PER_DIRECCION` VARCHAR(200), IN `_PER_TELEFONO` VARCHAR(10), IN `_PER_CELULAR` VARCHAR(10), IN `_PER_CORREO` VARCHAR(100), IN `_PER_SEXO` VARCHAR(1), IN `_PROV_FECHA_REGISTRO` DATE, IN `_PROV_OBSERVACION` VARCHAR(300), IN `_PROV_ESTADO` TINYINT, IN `ACCION` VARCHAR(40))  BEGIN
CASE ACCION
			WHEN 'CREAR' THEN
				INSERT INTO PERSONA
					(
						PER_ID,
						PER_CEDULA,
						PER_NOMBRE,
						PER_DIRECCION,
						PER_TELEFONO,
						PER_CELULAR,
						PER_CORREO,
                        PER_SEXO				
					) 
					VALUES 
					(
						_PER_ID,
						_PER_CEDULA,
						_PER_NOMBRE,
						_PER_DIRECCION,
						_PER_TELEFONO,
						_PER_CELULAR,
						_PER_CORREO,
                        _PER_SEXO
					);
                    
				INSERT INTO PROVEEDOR
					(
						PER_ID,
						PROV_FECHA_REGISTRO,
						PROV_OBSERVACION,
						PROV_ESTADO
					) 
					VALUES 
					(
						_PER_ID,
						_PROV_FECHA_REGISTRO,
						_PROV_OBSERVACION,
						_PROV_ESTADO
					);    
            
            
            WHEN 'MODIFICAR' THEN
				UPDATE PERSONA SET 					
					PER_CEDULA=_PER_CEDULA,
					PER_NOMBRE=_PER_NOMBRE,
					PER_DIRECCION=_PER_DIRECCION,
					PER_TELEFONO=_PER_TELEFONO,
					PER_CELULAR=_PER_CELULAR,
					PER_CORREO=_PER_CORREO,
					PER_SEXO=_PER_SEXO                    
				WHERE PER_ID=_PER_ID;
                
                UPDATE PROVEEDOR SET 					
					
						PROV_FECHA_REGISTRO=_PROV_FECHA_REGISTRO,
						PROV_OBSERVACION=_PROV_OBSERVACION,
						PROV_ESTADO=_PROV_ESTADO
				WHERE PER_ID=_PER_ID;
            
            
		END case;
        
        

END$$

DROP PROCEDURE IF EXISTS `crearModificaTipoUsuario`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `crearModificaTipoUsuario` (IN `_TIP_USU_ID` VARCHAR(10), IN `_TIP_USU_DESCRIPCION` VARCHAR(50), IN `_TIP_USU_PRODUCTO` TINYINT, IN `_TIP_USU_MERCADERIA` TINYINT, IN `_TIP_USU_COMPRAS` TINYINT, IN `_TIP_USU_PROVEEDORES` TINYINT, IN `_TIP_USU_CLIENTES` TINYINT, IN `_TIP_USU_VENTAS_REALIZADAS` TINYINT, IN `_TIP_USU_VENTAS_DETALLADAS` TINYINT, IN `_TIP_USU_ESTADISTICA_MENSUAL` TINYINT, IN `_TIP_USU_COMPRAS_REALIZADAS` TINYINT, IN `_TIP_USU_COMPRAS_DETALLADAS` TINYINT, IN `_TIP_USU_EMPLEADOS` TINYINT, IN `_TIP_USU_TIPO_DE_USUARIO` TINYINT, IN `_TIP_USU_SERVICIO_TECNICO` TINYINT, IN `_TIP_USU_ANULAR_VENTA` TINYINT, IN `_TIP_USU_ANULAR_COMPRA` TINYINT, IN `_TIP_USU_CAMBIAR_CONTRASEÑA` TINYINT, IN `_TIP_USU_USUARIOS` TINYINT, IN `_TIP_USU_RESPALDAR_BD` TINYINT, IN `_TIP_USU_RESTAURAR_BD` TINYINT, IN `_TIP_USU_ESTADO` TINYINT, IN `ACCION` VARCHAR(40))  BEGIN
	CASE ACCION
			WHEN 'CREAR' THEN
				INSERT INTO TIPO_USUARIO
					(
						TIP_USU_ID,
						TIP_USU_DESCRIPCION,
						TIP_USU_PRODUCTO,
						TIP_USU_MERCADERIA,
						TIP_USU_COMPRAS,
						TIP_USU_PROVEEDORES,
						TIP_USU_CLIENTES,
						TIP_USU_VENTAS_REALIZADAS,
						TIP_USU_VENTAS_DETALLADAS,
						TIP_USU_ESTADISTICA_MENSUAL,
						TIP_USU_COMPRAS_REALIZADAS,
						TIP_USU_COMPRAS_DETALLADAS, 
						TIP_USU_EMPLEADOS, 
						TIP_USU_TIPO_DE_USUARIO,
						TIP_USU_SERVICIO_TECNICO, 
						TIP_USU_ANULAR_VENTA,
						TIP_USU_ANULAR_COMPRA,
						TIP_USU_CAMBIAR_CONTRASEÑA,
						TIP_USU_USUARIOS, 
						TIP_USU_RESPALDAR_BD,
						TIP_USU_RESTAURAR_BD,
                        TIP_USU_ESTADO
					) 
					VALUES 
					(
						_TIP_USU_ID,
						_TIP_USU_DESCRIPCION,
						_TIP_USU_PRODUCTO,
						_TIP_USU_MERCADERIA,
						_TIP_USU_COMPRAS,
						_TIP_USU_PROVEEDORES,
						_TIP_USU_CLIENTES,
						_TIP_USU_VENTAS_REALIZADAS,
						_TIP_USU_VENTAS_DETALLADAS,
						_TIP_USU_ESTADISTICA_MENSUAL,
						_TIP_USU_COMPRAS_REALIZADAS,
						_TIP_USU_COMPRAS_DETALLADAS, 
						_TIP_USU_EMPLEADOS, 
						_TIP_USU_TIPO_DE_USUARIO,
						_TIP_USU_SERVICIO_TECNICO, 
						_TIP_USU_ANULAR_VENTA,
						_TIP_USU_ANULAR_COMPRA,
						_TIP_USU_CAMBIAR_CONTRASEÑA,
						_TIP_USU_USUARIOS, 
						_TIP_USU_RESPALDAR_BD,
						_TIP_USU_RESTAURAR_BD,
                        _TIP_USU_ESTADO
					);
            
            WHEN 'MODIFICAR' THEN
				UPDATE TIPO_USUARIO SET 
				TIP_USU_DESCRIPCION=_TIP_USU_DESCRIPCION,
				TIP_USU_PRODUCTO=_TIP_USU_PRODUCTO,
				TIP_USU_MERCADERIA=_TIP_USU_MERCADERIA,
				TIP_USU_COMPRAS=_TIP_USU_COMPRAS,
				TIP_USU_PROVEEDORES=_TIP_USU_PROVEEDORES,
				TIP_USU_CLIENTES=_TIP_USU_CLIENTES,
				TIP_USU_VENTAS_REALIZADAS=_TIP_USU_VENTAS_REALIZADAS,
				TIP_USU_VENTAS_DETALLADAS=_TIP_USU_VENTAS_DETALLADAS,
				TIP_USU_ESTADISTICA_MENSUAL=_TIP_USU_ESTADISTICA_MENSUAL,
				TIP_USU_COMPRAS_REALIZADAS=_TIP_USU_COMPRAS_REALIZADAS,
				TIP_USU_COMPRAS_DETALLADAS=_TIP_USU_COMPRAS_DETALLADAS, 
				TIP_USU_EMPLEADOS=_TIP_USU_EMPLEADOS, 
				TIP_USU_TIPO_DE_USUARIO=_TIP_USU_TIPO_DE_USUARIO,
				TIP_USU_SERVICIO_TECNICO=_TIP_USU_SERVICIO_TECNICO, 
				TIP_USU_ANULAR_VENTA=_TIP_USU_ANULAR_VENTA,
				TIP_USU_ANULAR_COMPRA=_TIP_USU_ANULAR_COMPRA,
				TIP_USU_CAMBIAR_CONTRASEÑA=_TIP_USU_CAMBIAR_CONTRASEÑA,
				TIP_USU_USUARIOS=_TIP_USU_USUARIOS, 
				TIP_USU_RESPALDAR_BD=_TIP_USU_RESPALDAR_BD,
				TIP_USU_RESTAURAR_BD=_TIP_USU_RESTAURAR_BD
				WHERE TIP_USU_ID=_TIP_USU_ID;
            
		END case;
END$$

DROP PROCEDURE IF EXISTS `CrearModificaUsuario`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `CrearModificaUsuario` (IN `_PER_ID` INT(11), IN `_PER_CEDULA` VARCHAR(10), IN `_PER_NOMBRE` VARCHAR(100), IN `_PER_DIRECCION` VARCHAR(200), IN `_PER_TELEFONO` VARCHAR(10), IN `_PER_CELULAR` VARCHAR(10), IN `_PER_CORREO` VARCHAR(100), IN `_PER_SEXO` VARCHAR(1), IN `_USU_NOMBRE_USUARIO` VARCHAR(50), IN `_USU_CLAVE` VARCHAR(200), IN `_USU_FECHA_NACIMIENTO` DATE, IN `_USU_FECHA_INGRESO` DATE, IN `_USU_SUELDO` DOUBLE, IN `_TIP_USU_ID` INT(11), IN `_USU_ESTADO` TINYINT, IN `ACCION` VARCHAR(40))  BEGIN
CASE ACCION
			WHEN 'CREAR' THEN
				INSERT INTO PERSONA
					(
						PER_ID,
						PER_CEDULA,
						PER_NOMBRE,
						PER_DIRECCION,
						PER_TELEFONO,
						PER_CELULAR,
						PER_CORREO,
                        PER_SEXO				
					) 
					VALUES 
					(
						_PER_ID,
						_PER_CEDULA,
						_PER_NOMBRE,
						_PER_DIRECCION,
						_PER_TELEFONO,
						_PER_CELULAR,
						_PER_CORREO,
                        _PER_SEXO
					);
                    
				INSERT INTO USUARIO
					(
						PER_ID,
						USU_NOMBRE_USUARIO,
						USU_CLAVE,
						USU_FECHA_NACIMIENTO,
						USU_FECHA_INGRESO,
						USU_SUELDO,
						TIP_USU_ID,
                        USU_ESTADO
					) 
					VALUES 
					(
						_PER_ID,
						_USU_NOMBRE_USUARIO,
						_USU_CLAVE,
					    _USU_FECHA_NACIMIENTO,
						_USU_FECHA_INGRESO,
						_USU_SUELDO,
						_TIP_USU_ID,
                        _USU_ESTADO
					);    
            
            
            WHEN 'MODIFICAR' THEN
				UPDATE PERSONA SET 					
					PER_CEDULA=_PER_CEDULA,
					PER_NOMBRE=_PER_NOMBRE,
					PER_DIRECCION=_PER_DIRECCION,
					PER_TELEFONO=_PER_TELEFONO,
					PER_CELULAR=_PER_CELULAR,
					PER_CORREO=_PER_CORREO,
					PER_SEXO=_PER_SEXO                    
				WHERE PER_ID=_PER_ID;
                
                UPDATE USUARIO SET 					
					
						USU_NOMBRE_USUARIO=_USU_NOMBRE_USUARIO,
						USU_CLAVE=_USU_CLAVE,
						USU_FECHA_NACIMIENTO=_USU_FECHA_NACIMIENTO,
						USU_FECHA_INGRESO=_USU_FECHA_INGRESO,
						USU_SUELDO=_USU_SUELDO,
						TIP_USU_ID=_TIP_USU_ID,
                        USU_ESTADO=_USU_ESTADO
				WHERE PER_ID=_PER_ID;
            
            
		END case;
        
        

END$$

DROP PROCEDURE IF EXISTS `getAllTipoUsuario`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllTipoUsuario` ()  BEGIN
	SELECT * FROM TIPO_USUARIO WHERE TIP_USU_ESTADO=TRUE ORDER BY TIP_USU_ID;
END$$

DROP PROCEDURE IF EXISTS `getByDescripcionTipoUsuario`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getByDescripcionTipoUsuario` (IN `_TIP_USU_DESCRIPCION` VARCHAR(50))  BEGIN
	SELECT * FROM TIPO_USUARIO WHERE TIP_USU_DESCRIPCION LIKE _TIP_USU_DESCRIPCION AND TIP_USU_ESTADO=TRUE;
END$$

DROP PROCEDURE IF EXISTS `getByIdTipoUsuario`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getByIdTipoUsuario` (IN `_TIP_USU_ID` VARCHAR(10))  BEGIN
	SELECT * FROM TIPO_USUARIO WHERE TIP_USU_ID LIKE _TIP_USU_ID AND TIP_USU_ESTADO=TRUE;
END$$

DROP PROCEDURE IF EXISTS `getComprasDetalladas`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `getComprasDetalladas` (IN `_DESDE` DATETIME, IN `_HASTA` DATETIME)  BEGIN

SELECT CD.PRO_ID, 
P.PRO_NOMBRE,
C.CAT_DESCRIPCION,
CD.COM_DET_CATIDAD, 
CD.COM_DET_VALOR, 
CD.COM_DET_TOTAL,
CC.COM_CAB_ESTADO
FROM COMPRAS_DETALLE CD 
JOIN PRODUCTO P ON P.PRO_ID=CD.PRO_ID 
JOIN CATEGORIA C ON C.CAT_ID=P.CAT_ID
JOIN COMPRAS_CAB CC ON CC.COM_CAB_ID=CD.COM_CAB_ID
WHERE CC.COM_CAB_FECHA BETWEEN  _DESDE AND _HASTA;

END$$

DROP PROCEDURE IF EXISTS `getIDPersonabyNombre`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `getIDPersonabyNombre` (IN `_nombre` VARCHAR(50))  BEGIN
SELECT `PER_ID` FROM `PERSONA` WHERE `PER_NOMBRE` =_nombre;

END$$

DROP PROCEDURE IF EXISTS `getUltimoIdComprasCab`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `getUltimoIdComprasCab` ()  BEGIN
	SELECT COM_CAB_ID FROM COMPRAS_CAB ORDER by COM_CAB_ID DESC LIMIT 1;
END$$

DROP PROCEDURE IF EXISTS `getUltimoIdFacturaCab`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `getUltimoIdFacturaCab` ()  BEGIN
	SELECT FAC_CAB_ID FROM FACTURA_CAB ORDER by FAC_CAB_ID DESC LIMIT 1;
END$$

DROP PROCEDURE IF EXISTS `getUltimoIdNotaCab`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `getUltimoIdNotaCab` ()  BEGIN
SELECT NOT_CAB_ID FROM NOTA_CAB ORDER by NOT_CAB_ID DESC LIMIT 1;
END$$

DROP PROCEDURE IF EXISTS `getUltimoIdPersona`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getUltimoIdPersona` ()  BEGIN
	SELECT PER_ID FROM PERSONA ORDER by PER_ID DESC LIMIT 1;
END$$

DROP PROCEDURE IF EXISTS `getUltimoIdProductos`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `getUltimoIdProductos` ()  BEGIN
	SELECT PRO_ID FROM PRODUCTO ORDER by PRO_ID DESC LIMIT 1;
END$$

DROP PROCEDURE IF EXISTS `getUltimoIdReparacion`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `getUltimoIdReparacion` ()  BEGIN
SELECT `REP_ID` FROM REPARACION ORDER by `REP_ID` DESC LIMIT 1;

END$$

DROP PROCEDURE IF EXISTS `getUltimoRegistroKardex`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `getUltimoRegistroKardex` (IN `_PRO_ID` INT(10))  BEGIN
SELECT `KAR_XCANT`,`KAR_XVU`,`KAR_XVT` FROM `KARDEX` WHERE `PRO_ID` = _PRO_ID ORDER by `KAR_ID` DESC LIMIT 1;
END$$

DROP PROCEDURE IF EXISTS `getUtlimoIdTipoUsuario`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getUtlimoIdTipoUsuario` ()  BEGIN
	SELECT TIP_USU_ID FROM TIPO_USUARIO ORDER by TIP_USU_ID DESC LIMIT 1;
END$$

DROP PROCEDURE IF EXISTS `getValorVentaKardexSegunCodigoDetalle`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `getValorVentaKardexSegunCodigoDetalle` (IN `_PRO_ID` INT(10), IN `_KAR_DETALLE` VARCHAR(50))  BEGIN
SELECT `KAR_SCANT`,`KAR_SVU`,`KAR_SVT` FROM `KARDEX` WHERE `PRO_ID`=_PRO_ID AND`KAR_DETALLE`=_KAR_DETALLE;
END$$

DROP PROCEDURE IF EXISTS `iniciarSesion`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `iniciarSesion` (IN `usuario` VARCHAR(200), IN `clave` VARCHAR(200))  BEGIN    
    SELECT
     PERSONA.`PER_ID` AS PERSONA_PER_ID,
     PERSONA.`PER_CEDULA` AS PERSONA_PER_CEDULA,
     PERSONA.`PER_NOMBRE` AS PERSONA_PER_NOMBRE,
     PERSONA.`PER_DIRECCION` AS PERSONA_PER_DIRECCION,
     PERSONA.`PER_TELEFONO` AS PERSONA_PER_TELEFONO,
     PERSONA.`PER_CELULAR` AS PERSONA_PER_CELULAR,
     PERSONA.`PER_CORREO` AS PERSONA_PER_CORREO,
     PERSONA.`PER_SEXO` AS PERSONA_PER_SEXO,
     USU_NOMBRE_USUARIO,
     USU_CLAVE,
     USU_FECHA_NACIMIENTO,
     USU_FECHA_INGRESO,
     USU_SUELDO,
     TIP_USU_ID,
     USU_ESTADO
FROM
     `PERSONA` PERSONA INNER JOIN `USUARIO` USUARIO 
     ON  USUARIO.`PER_ID`=PERSONA.`PER_ID` AND (USU_NOMBRE_USUARIO = usuario  AND USU_CLAVE = clave);

END$$

DROP PROCEDURE IF EXISTS `kardex`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `kardex` (IN `_PRO_ID` INT(5))  BEGIN
	SELECT * FROM `KARDEX` WHERE `PRO_ID` = _PRO_ID order BY `KAR_FECHA`;
END$$

DROP PROCEDURE IF EXISTS `prueva`$$
CREATE DEFINER=`jaime`@`localhost` PROCEDURE `prueva` (IN `_COM_CANTIDAD` INT)  BEGIN
SELECT @_KAR_XCANT:=KAR_XCANT FROM KARDEX WHERE PRO_ID=2 ORDER by KAR_ID DESC LIMIT 1;
	
    INSERT INTO KARDEX 
    ( 
		PRO_ID, KAR_FECHA, KAR_DETALLE, KAR_ECANT, KAR_XCANT 
    ) 
	VALUES 
    (
		2, CURDATE(), 'compra', _COM_CANTIDAD , (_COM_CANTIDAD + @_KAR_XCANT)
    );

END$$

DROP PROCEDURE IF EXISTS `TIPO_USUARIO_CRUDBD`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `TIPO_USUARIO_CRUDBD` (IN `_TIP_USU_ID` VARCHAR(10), IN `_TIP_USU_DESCRIPCION` VARCHAR(50), IN `_TIP_USU_PRODUCTO` TINYINT, IN `_TIP_USU_MERCADERIA` TINYINT, IN `_TIP_USU_COMPRAS` TINYINT, IN `_TIP_USU_PROVEEDORES` TINYINT, IN `_TIP_USU_VENTA` TINYINT, IN `_TIP_USU_CLIENTES` TINYINT, IN `_TIP_USU_VERIFICAR_PRODUCTO` TINYINT, IN `_TIP_USU_VENTAS_REALIZADAS` TINYINT, IN `_TIP_USU_VENTAS_DETALLADAS` TINYINT, IN `_TIP_USU_ESTADISTICA_MENSUAL` TINYINT, IN `_TIP_USU_COMPRAS_REALIZADAS` TINYINT, IN `_TIP_USU_COMPRAS_DETALLADAS` TINYINT, IN `_TIP_USU_EMPLEADOS` TINYINT, IN `_TIP_USU_TIPO_DE_USUARIO` TINYINT, IN `_TIP_USU_SERVICIO_TECNICO` TINYINT, IN `_TIP_USU_ANULAR_VENTA` TINYINT, IN `_TIP_USU_ANULAR_COMPRA` TINYINT, IN `_TIP_USU_CAMBIAR_CONTRASEÑA` TINYINT, IN `_TIP_USU_USUARIOS` TINYINT, IN `_TIP_USU_RESPALDAR_BD` TINYINT, IN `_TIP_USU_RESTAURAR_BD` TINYINT, IN `_TIP_USU_ESTADO` TINYINT, IN `ACCION` VARCHAR(40))  BEGIN
		CASE ACCION
			WHEN 'CREAR' THEN
				INSERT INTO TIPO_USUARIO
					(
						TIP_USU_ID,
						TIP_USU_DESCRIPCION,
						TIP_USU_PRODUCTO,
						TIP_USU_MERCADERIA,
						TIP_USU_COMPRAS,
						TIP_USU_PROVEEDORES,
                        TIP_USU_VENTA,
						TIP_USU_CLIENTES,
                        TIP_USU_VERIFICAR_PRODUCTO,
						TIP_USU_VENTAS_REALIZADAS,
						TIP_USU_VENTAS_DETALLADAS,
						TIP_USU_ESTADISTICA_MENSUAL,
						TIP_USU_COMPRAS_REALIZADAS,
						TIP_USU_COMPRAS_DETALLADAS, 
						TIP_USU_EMPLEADOS, 
						TIP_USU_TIPO_DE_USUARIO,
						TIP_USU_SERVICIO_TECNICO, 
						TIP_USU_ANULAR_VENTA,
						TIP_USU_ANULAR_COMPRA,
						TIP_USU_CAMBIAR_CONTRASEÑA,
						TIP_USU_USUARIOS, 
						TIP_USU_RESPALDAR_BD,
						TIP_USU_RESTAURAR_BD,
                        TIP_USU_ESTADO
					) 
					VALUES 
					(
						_TIP_USU_ID,
						_TIP_USU_DESCRIPCION,
						_TIP_USU_PRODUCTO,
						_TIP_USU_MERCADERIA,
						_TIP_USU_COMPRAS,
						_TIP_USU_PROVEEDORES,
                        _TIP_USU_VENTA,
						_TIP_USU_CLIENTES,
                        _TIP_USU_VERIFICAR_PRODUCTO,
						_TIP_USU_VENTAS_REALIZADAS,
						_TIP_USU_VENTAS_DETALLADAS,
						_TIP_USU_ESTADISTICA_MENSUAL,
						_TIP_USU_COMPRAS_REALIZADAS,
						_TIP_USU_COMPRAS_DETALLADAS, 
						_TIP_USU_EMPLEADOS, 
						_TIP_USU_TIPO_DE_USUARIO,
						_TIP_USU_SERVICIO_TECNICO, 
						_TIP_USU_ANULAR_VENTA,
						_TIP_USU_ANULAR_COMPRA,
						_TIP_USU_CAMBIAR_CONTRASEÑA,
						_TIP_USU_USUARIOS, 
						_TIP_USU_RESPALDAR_BD,
						_TIP_USU_RESTAURAR_BD,
                        _TIP_USU_ESTADO
					);
            
            WHEN 'LEER_TODO' THEN
				SELECT * FROM TIPO_USUARIO WHERE TIP_USU_ESTADO=TRUE ORDER BY TIP_USU_ID;
                
			WHEN 'LEER_BY_ID' THEN
				SELECT * FROM TIPO_USUARIO WHERE TIP_USU_ID LIKE _TIP_USU_ID AND TIP_USU_ESTADO=TRUE;
                
		    WHEN 'LEER_BY_DESCRIPCION' THEN
				SELECT * FROM TIPO_USUARIO WHERE TIP_USU_DESCRIPCION LIKE _TIP_USU_DESCRIPCION AND TIP_USU_ESTADO=TRUE;
            
            WHEN 'MODIFICAR' THEN
				UPDATE TIPO_USUARIO SET 
				TIP_USU_DESCRIPCION=_TIP_USU_DESCRIPCION,
				TIP_USU_PRODUCTO=_TIP_USU_PRODUCTO,
				TIP_USU_MERCADERIA=_TIP_USU_MERCADERIA,
				TIP_USU_COMPRAS=_TIP_USU_COMPRAS,
				TIP_USU_PROVEEDORES=_TIP_USU_PROVEEDORES,
                TIP_USU_VENTA=_TIP_USU_VENTA,
				TIP_USU_CLIENTES=_TIP_USU_CLIENTES,
                TIP_USU_VERIFICAR_PRODUCTO=_TIP_USU_VERIFICAR_PRODUCTO,
				TIP_USU_VENTAS_REALIZADAS=_TIP_USU_VENTAS_REALIZADAS,
				TIP_USU_VENTAS_DETALLADAS=_TIP_USU_VENTAS_DETALLADAS,
				TIP_USU_ESTADISTICA_MENSUAL=_TIP_USU_ESTADISTICA_MENSUAL,
				TIP_USU_COMPRAS_REALIZADAS=_TIP_USU_COMPRAS_REALIZADAS,
				TIP_USU_COMPRAS_DETALLADAS=_TIP_USU_COMPRAS_DETALLADAS, 
				TIP_USU_EMPLEADOS=_TIP_USU_EMPLEADOS, 
				TIP_USU_TIPO_DE_USUARIO=_TIP_USU_TIPO_DE_USUARIO,
				TIP_USU_SERVICIO_TECNICO=_TIP_USU_SERVICIO_TECNICO, 
				TIP_USU_ANULAR_VENTA=_TIP_USU_ANULAR_VENTA,
				TIP_USU_ANULAR_COMPRA=_TIP_USU_ANULAR_COMPRA,
				TIP_USU_CAMBIAR_CONTRASEÑA=_TIP_USU_CAMBIAR_CONTRASEÑA,
				TIP_USU_USUARIOS=_TIP_USU_USUARIOS, 
				TIP_USU_RESPALDAR_BD=_TIP_USU_RESPALDAR_BD,
				TIP_USU_RESTAURAR_BD=_TIP_USU_RESTAURAR_BD
				WHERE TIP_USU_ID=_TIP_USU_ID;
            
            WHEN 'BORRAR' THEN
				UPDATE TIPO_USUARIO SET 
					TIP_USU_ESTADO=FALSE
				WHERE TIP_USU_ID=_TIP_USU_ID;
		END case;

END$$

DROP PROCEDURE IF EXISTS `vajaTipoUsuario`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `vajaTipoUsuario` (IN `_TIP_USU_ID` VARCHAR(10))  BEGIN
	UPDATE TIPO_USUARIO SET 
					TIP_USU_ESTADO=FALSE
				WHERE TIP_USU_ID=_TIP_USU_ID;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `CATEGORIA`
--

DROP TABLE IF EXISTS `CATEGORIA`;
CREATE TABLE `CATEGORIA` (
  `CAT_ID` int(11) NOT NULL,
  `CAT_DESCRIPCION` varchar(50) DEFAULT NULL,
  `CAT_IMAGEN` longblob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `CATEGORIA`
--

INSERT INTO `CATEGORIA` (`CAT_ID`, `CAT_DESCRIPCION`, `CAT_IMAGEN`) VALUES
(41, 'COMPROBANTES', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `CLIENTE`
--

DROP TABLE IF EXISTS `CLIENTE`;
CREATE TABLE `CLIENTE` (
  `PER_ID` int(11) NOT NULL,
  `CLI_FECHA_REGISTRO` date DEFAULT NULL,
  `CLI_OBSERVACION` varchar(300) DEFAULT NULL,
  `CLI_ESTADO` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `CLIENTE`
--

INSERT INTO `CLIENTE` (`PER_ID`, `CLI_FECHA_REGISTRO`, `CLI_OBSERVACION`, `CLI_ESTADO`) VALUES
(7, '2019-06-04', '', 1),
(8, '2019-06-04', '', 1),
(9, '2019-06-04', '', 1),
(10, '2019-06-04', '', 1),
(11, '2019-06-04', '', 1),
(12, '2019-06-04', '', 1),
(13, '2019-06-04', '', 1),
(14, '2019-06-04', '', 1),
(15, '2019-06-04', '', 1),
(16, '2019-06-04', '', 1),
(17, '2019-06-04', '', 1),
(18, '2019-06-04', '', 1),
(19, '2019-06-04', '', 1),
(20, '2019-06-04', '', 1),
(21, '2019-06-04', '', 1),
(22, '2019-06-04', '', 1),
(23, '2019-06-04', '', 1),
(24, '2019-06-04', '', 1),
(25, '2019-06-04', '', 1),
(26, '2019-06-04', '', 1),
(27, '2019-06-04', '', 1),
(28, '2019-06-04', '', 1),
(29, '2019-06-04', '', 1),
(30, '2019-06-04', '', 1),
(31, '2019-06-04', '', 1),
(32, '2019-06-04', '', 1),
(33, '2019-06-04', '', 1),
(34, '2019-06-04', '', 1),
(35, '2019-06-04', '', 1),
(36, '2019-06-04', '', 1),
(37, '2019-06-04', '', 1),
(38, '2019-06-04', '', 1),
(39, '2019-06-04', '', 1),
(40, '2019-06-04', '', 1),
(41, '2019-06-04', '', 1),
(42, '2019-06-04', '', 1),
(43, '2019-06-04', '', 1),
(44, '2019-06-04', '', 1),
(45, '2019-06-04', '', 1),
(46, '2019-06-04', '', 1),
(47, '2019-06-04', '', 1),
(48, '2019-06-04', '', 1),
(49, '2019-06-04', '', 1),
(50, '2019-06-04', '', 1),
(51, '2019-06-04', '', 1),
(52, '2019-06-04', '', 1),
(53, '2019-06-04', '', 1),
(54, '2019-06-04', '', 1),
(55, '2019-06-04', '', 1),
(56, '2019-06-04', '', 1),
(57, '2019-06-04', '', 1),
(58, '2019-06-04', '', 1),
(59, '2019-06-04', '', 1),
(60, '2019-06-04', '', 1),
(61, '2019-06-04', '', 1),
(62, '2019-06-04', '', 1),
(63, '2019-06-04', '', 1),
(64, '2019-06-04', '', 1),
(65, '2019-06-04', '', 1),
(66, '2019-06-04', '', 1),
(67, '2019-06-04', '', 1),
(68, '2019-06-04', '', 1),
(69, '2019-06-04', '', 1),
(70, '2019-06-04', '', 1),
(71, '2019-06-04', '', 1),
(72, '2019-06-04', '', 1),
(73, '2019-06-04', '', 1),
(74, '2019-06-04', '', 1),
(75, '2019-06-04', '', 1),
(76, '2019-06-04', '', 1),
(77, '2019-06-04', '', 1),
(78, '2019-06-04', '', 1),
(79, '2019-06-04', '', 1),
(80, '2019-06-04', '', 1),
(81, '2019-06-04', '', 1),
(82, '2019-06-04', '', 1),
(83, '2019-06-04', '', 1),
(84, '2019-06-04', '', 1),
(85, '2019-06-04', '', 1),
(86, '2019-06-04', '', 1),
(87, '2019-06-04', '', 1),
(88, '2019-06-04', '', 1),
(89, '2019-06-04', '', 1),
(90, '2019-06-04', '', 1),
(91, '2019-06-04', '', 1),
(92, '2019-06-04', '', 1),
(93, '2019-06-04', '', 1),
(94, '2019-06-04', '', 1),
(95, '2019-06-04', '', 1),
(96, '2019-06-04', '', 1),
(97, '2019-06-04', '', 1),
(98, '2019-06-04', '', 1),
(99, '2019-06-04', '', 1),
(100, '2019-06-04', '', 1),
(101, '2019-06-04', '', 1),
(102, '2019-06-04', '', 1),
(103, '2019-06-04', '', 1),
(104, '2019-06-04', '', 1),
(105, '2019-06-04', '', 1),
(106, '2019-06-04', '', 1),
(107, '2019-06-04', '', 1),
(108, '2019-06-04', '', 1),
(109, '2019-06-04', '', 1),
(110, '2019-06-04', '', 1),
(111, '2019-06-04', '', 1),
(112, '2019-06-04', '', 1),
(113, '2019-06-04', '', 1),
(114, '2019-06-04', '', 1),
(115, '2019-06-04', '', 1),
(116, '2019-06-04', '', 1),
(117, '2019-06-04', '', 1),
(118, '2019-06-04', '', 1),
(119, '2019-06-04', '', 1),
(120, '2019-06-04', '', 1),
(121, '2019-06-04', '', 1),
(122, '2019-06-04', '', 1),
(123, '2019-06-04', '', 1),
(124, '2019-06-04', '', 1),
(125, '2019-06-04', '', 1),
(126, '2019-06-04', '', 1),
(127, '2019-06-04', '', 1),
(128, '2019-06-04', '', 1),
(129, '2019-06-04', '', 1),
(130, '2019-06-04', '', 1),
(131, '2019-06-04', '', 1),
(132, '2019-06-04', '', 1),
(133, '2019-06-04', '', 1),
(134, '2019-06-04', '', 1),
(135, '2019-06-04', '', 1),
(136, '2019-06-04', '', 1),
(137, '2019-06-04', '', 1),
(138, '2019-06-04', '', 1),
(139, '2019-06-04', '', 1),
(140, '2019-06-04', '', 1),
(141, '2019-06-04', '', 1),
(142, '2019-06-04', '', 1),
(143, '2019-06-04', '', 1),
(144, '2019-06-04', '', 1),
(145, '2019-06-04', '', 1),
(146, '2019-06-04', '', 1),
(147, '2019-06-04', '', 1),
(148, '2019-06-04', '', 1),
(149, '2019-06-04', '', 1),
(150, '2019-06-04', '', 1),
(151, '2019-06-04', '', 1),
(152, '2019-06-04', '', 1),
(153, '2019-06-04', '', 1),
(154, '2019-06-04', '', 1),
(155, '2019-06-04', '', 1),
(156, '2019-06-04', '', 1),
(157, '2019-06-04', '', 1),
(158, '2019-06-04', '', 1),
(159, '2019-06-04', '', 1),
(160, '2019-06-04', '', 1),
(161, '2019-06-04', '', 1),
(162, '2019-06-04', '', 1),
(163, '2019-06-04', '', 1),
(164, '2019-06-04', '', 1),
(165, '2019-06-04', '', 1),
(166, '2019-06-04', '', 1),
(167, '2019-06-04', '', 1),
(168, '2019-06-04', '', 1),
(169, '2019-06-04', '', 1),
(170, '2019-06-04', '', 1),
(171, '2019-06-04', '', 1),
(172, '2019-06-04', '', 1),
(173, '2019-06-04', '', 1),
(174, '2019-06-04', '', 1),
(175, '2019-06-04', '', 1),
(176, '2019-06-04', '', 1),
(177, '2019-06-04', '', 1),
(178, '2019-06-04', '', 1),
(179, '2019-06-04', '', 1),
(180, '2019-06-04', '', 1),
(181, '2019-06-04', '', 1),
(182, '2019-06-04', '', 1),
(183, '2019-06-04', '', 1),
(184, '2019-06-04', '', 1),
(185, '2019-06-04', '', 1),
(186, '2019-06-04', '', 1),
(187, '2019-06-04', '', 1),
(188, '2019-06-04', '', 1),
(189, '2019-06-04', '', 1),
(190, '2019-06-04', '', 1),
(191, '2019-06-04', '', 1),
(192, '2019-06-04', '', 1),
(193, '2019-06-04', '', 1),
(194, '2019-06-04', '', 1),
(195, '2019-06-04', '', 1),
(196, '2019-06-04', '', 1),
(197, '2019-06-04', '', 1),
(198, '2019-06-04', '', 1),
(199, '2019-06-04', '', 1),
(200, '2019-06-04', '', 1),
(201, '2019-06-04', '', 1),
(202, '2019-06-04', '', 1),
(203, '2019-06-04', '', 1),
(204, '2019-06-04', '', 1),
(205, '2019-06-04', '', 1),
(206, '2019-06-04', '', 1),
(207, '2019-06-04', '', 1),
(208, '2019-06-04', '', 1),
(209, '2019-06-04', '', 1),
(210, '2019-06-04', '', 1),
(211, '2019-06-04', '', 1),
(212, '2019-06-04', '', 1),
(213, '2019-06-04', '', 1),
(214, '2019-06-04', '', 1),
(215, '2019-06-04', '', 1),
(216, '2019-06-04', '', 1),
(217, '2019-06-04', '', 1),
(218, '2019-06-04', '', 1),
(219, '2019-06-04', '', 1),
(220, '2019-06-04', '', 1),
(221, '2019-06-04', '', 1),
(222, '2019-06-04', '', 1),
(223, '2019-06-04', '', 1),
(224, '2019-06-04', '', 1),
(225, '2019-06-04', '', 1),
(226, '2019-06-04', '', 1),
(227, '2019-06-04', '', 1),
(228, '2019-06-04', '', 1),
(229, '2019-06-04', '', 1),
(230, '2019-06-04', '', 1),
(231, '2019-06-04', '', 1),
(232, '2019-06-04', '', 1),
(233, '2019-06-04', '', 1),
(234, '2019-06-04', '', 1),
(235, '2019-06-04', '', 1),
(236, '2019-06-04', '', 1),
(237, '2019-06-04', '', 1),
(238, '2019-06-04', '', 1),
(239, '2019-06-04', '', 1),
(240, '2019-06-04', '', 1),
(241, '2019-06-04', '', 1),
(242, '2019-06-04', '', 1),
(243, '2019-06-04', '', 1),
(244, '2019-06-04', '', 1),
(245, '2019-06-04', '', 1),
(246, '2019-06-04', '', 1),
(247, '2019-06-04', '', 1),
(248, '2019-06-04', '', 1),
(249, '2019-06-04', '', 1),
(250, '2019-06-04', '', 1),
(251, '2019-06-04', '', 1),
(252, '2019-06-04', '', 1),
(253, '2019-06-04', '', 1),
(254, '2019-06-04', '', 1),
(255, '2019-06-04', '', 1),
(256, '2019-06-04', '', 1),
(257, '2019-06-04', '', 1),
(258, '2019-06-04', '', 1),
(259, '2019-06-04', '', 1),
(260, '2019-06-04', '', 1),
(261, '2019-06-04', '', 1),
(262, '2019-06-04', '', 1),
(263, '2019-06-04', '', 1),
(264, '2019-06-04', '', 1),
(265, '2019-06-04', '', 1),
(266, '2019-06-04', '', 1),
(267, '2019-06-04', '', 1),
(268, '2019-06-04', '', 1),
(269, '2019-06-04', '', 1),
(270, '2019-06-04', '', 1),
(271, '2019-06-04', '', 1),
(272, '2019-06-04', '', 1),
(273, '2019-06-04', '', 1),
(274, '2019-06-04', '', 1),
(275, '2019-06-04', '', 1),
(276, '2019-06-04', '', 1),
(277, '2019-06-04', '', 1),
(278, '2019-06-04', '', 1),
(279, '2019-06-04', '', 1),
(280, '2019-06-04', '', 1),
(281, '2019-06-04', '', 1),
(282, '2019-06-04', '', 1),
(283, '2019-06-04', '', 1),
(284, '2019-06-04', '', 1),
(285, '2019-06-04', '', 1),
(286, '2019-06-04', '', 1),
(287, '2019-06-04', '', 1),
(288, '2019-06-04', '', 1),
(289, '2019-06-04', '', 1),
(290, '2019-06-04', '', 1),
(291, '2019-06-04', '', 1),
(292, '2019-06-04', '', 1),
(293, '2019-06-04', '', 1),
(294, '2019-06-04', '', 1),
(295, '2019-06-04', '', 1),
(296, '2019-06-04', '', 1),
(297, '2019-06-04', '', 1),
(298, '2019-06-04', '', 1),
(299, '2019-06-04', '', 1),
(300, '2019-06-04', '', 1),
(301, '2019-06-04', '', 1),
(302, '2019-06-04', '', 1),
(303, '2019-06-04', '', 1),
(304, '2019-06-04', '', 1),
(305, '2019-06-04', '', 1),
(306, '2019-06-04', '', 1),
(307, '2019-06-04', '', 1),
(308, '2019-06-04', '', 1),
(309, '2019-06-04', '', 1),
(310, '2019-06-04', '', 1),
(311, '2019-06-04', '', 1),
(312, '2019-06-04', '', 1),
(313, '2019-06-04', '', 1),
(314, '2019-06-04', '', 1),
(315, '2019-06-04', '', 1),
(316, '2019-06-04', '', 1),
(317, '2019-06-04', '', 1),
(318, '2019-06-04', '', 1),
(319, '2019-06-04', '', 1),
(320, '2019-06-04', '', 1),
(321, '2019-06-04', '', 1),
(322, '2019-06-04', '', 1),
(323, '2019-06-04', '', 1),
(324, '2019-06-04', '', 1),
(325, '2019-06-04', '', 1),
(326, '2019-06-04', '', 1),
(327, '2019-06-04', '', 1),
(328, '2019-06-04', '', 1),
(329, '2019-06-04', '', 1),
(330, '2019-06-04', '', 1),
(331, '2019-06-04', '', 1),
(332, '2019-06-04', '', 1),
(333, '2019-06-04', '', 1),
(334, '2019-06-04', '', 1),
(335, '2019-06-04', '', 1),
(336, '2019-06-04', '', 1),
(337, '2019-06-04', '', 1),
(338, '2019-06-04', '', 1),
(339, '2019-06-04', '', 1),
(340, '2019-06-04', '', 1),
(341, '2019-06-04', '', 1),
(342, '2019-06-04', '', 1),
(343, '2019-06-04', '', 1),
(344, '2019-06-04', '', 1),
(345, '2019-06-04', '', 1),
(346, '2019-06-04', '', 1),
(347, '2019-06-04', '', 1),
(348, '2019-06-04', '', 1),
(349, '2019-06-04', '', 1),
(350, '2019-06-04', '', 1),
(351, '2019-06-04', '', 1),
(352, '2019-06-04', '', 1),
(353, '2019-06-04', '', 1),
(354, '2019-06-04', '', 1),
(355, '2019-06-04', '', 1),
(356, '2019-06-04', '', 1),
(357, '2019-06-04', '', 1),
(358, '2019-06-04', '', 1),
(359, '2019-06-04', '', 1),
(360, '2019-06-04', '', 1),
(361, '2019-06-04', '', 1),
(362, '2019-06-04', '', 1),
(363, '2019-06-04', '', 1),
(364, '2019-06-04', '', 1),
(365, '2019-06-04', '', 1),
(366, '2019-06-04', '', 1),
(367, '2019-06-04', '', 1),
(368, '2019-06-04', '', 1),
(369, '2019-06-04', '', 1),
(370, '2019-06-04', '', 1),
(371, '2019-06-04', '', 1),
(372, '2019-06-04', '', 1),
(373, '2019-06-04', '', 1),
(374, '2019-06-04', '', 1),
(375, '2019-06-04', '', 1),
(376, '2019-06-04', '', 1),
(377, '2019-06-04', '', 1),
(378, '2019-06-04', '', 1),
(379, '2019-06-04', '', 1),
(380, '2019-06-04', '', 1),
(381, '2019-06-04', '', 1),
(382, '2019-06-04', '', 1),
(383, '2019-06-04', '', 1),
(384, '2019-06-04', '', 1),
(385, '2019-06-04', '', 1),
(386, '2019-06-04', '', 1),
(387, '2019-06-04', '', 1),
(388, '2019-06-04', '', 1),
(389, '2019-06-04', '', 1),
(390, '2019-06-04', '', 1),
(391, '2019-06-04', '', 1),
(392, '2019-06-04', '', 1),
(393, '2019-06-04', '', 1),
(394, '2019-06-04', '', 1),
(395, '2019-06-04', '', 1),
(396, '2019-06-04', '', 1),
(397, '2019-06-04', '', 1),
(398, '2019-06-04', '', 1),
(399, '2019-06-04', '', 1),
(400, '2019-06-04', '', 1),
(401, '2019-06-04', '', 1),
(402, '2019-06-04', '', 1),
(403, '2019-06-04', '', 1),
(404, '2019-06-04', '', 1),
(405, '2019-06-04', '', 1),
(406, '2019-06-04', '', 1),
(407, '2019-06-04', '', 1),
(408, '2019-06-04', '', 1),
(409, '2019-06-04', '', 1),
(410, '2019-06-04', '', 1),
(411, '2019-06-04', '', 1),
(412, '2019-06-04', '', 1),
(413, '2019-06-04', '', 1),
(414, '2019-06-04', '', 1),
(415, '2019-06-04', '', 1),
(416, '2019-06-04', '', 1),
(417, '2019-06-04', '', 1),
(418, '2019-06-04', '', 1),
(419, '2019-06-04', '', 1),
(420, '2019-06-04', '', 1),
(421, '2019-06-04', '', 1),
(422, '2019-06-04', '', 1),
(423, '2019-06-04', '', 1),
(424, '2019-06-04', '', 1),
(425, '2019-06-04', '', 1),
(426, '2019-06-04', '', 1),
(427, '2019-06-04', '', 1),
(428, '2019-06-04', '', 1),
(429, '2019-06-04', '', 1),
(430, '2019-06-04', '', 1),
(431, '2019-06-04', '', 1),
(432, '2019-06-04', '', 1),
(433, '2019-06-04', '', 1),
(434, '2019-06-04', '', 1),
(435, '2019-06-04', '', 1),
(436, '2019-06-04', '', 1),
(437, '2019-06-04', '', 1),
(438, '2019-06-04', '', 1),
(439, '2019-06-04', '', 1),
(440, '2019-06-04', '', 1),
(441, '2019-06-04', '', 1),
(442, '2019-06-04', '', 1),
(443, '2019-06-04', '', 1),
(444, '2019-06-04', '', 1),
(445, '2019-06-04', '', 1),
(446, '2019-06-04', '', 1),
(447, '2019-06-04', '', 1),
(448, '2019-06-04', '', 1),
(449, '2019-06-04', '', 1),
(450, '2019-06-04', '', 1),
(451, '2019-06-04', '', 1),
(452, '2019-06-04', '', 1),
(453, '2019-06-04', '', 1),
(454, '2019-06-04', '', 1),
(455, '2019-06-04', '', 1),
(456, '2019-06-04', '', 1),
(457, '2019-06-04', '', 1),
(458, '2019-06-04', '', 1),
(459, '2019-06-04', '', 1),
(460, '2019-06-04', '', 1),
(461, '2019-06-04', '', 1),
(462, '2019-06-04', '', 1),
(463, '2019-06-04', '', 1),
(464, '2019-06-04', '', 1),
(465, '2019-06-04', '', 1),
(466, '2019-06-04', '', 1),
(467, '2019-06-04', '', 1),
(468, '2019-06-04', '', 1),
(469, '2019-06-04', '', 1),
(470, '2019-06-04', '', 1),
(471, '2019-06-04', '', 1),
(472, '2019-06-04', '', 1),
(473, '2019-06-04', '', 1),
(474, '2019-06-04', '', 1),
(475, '2019-06-04', '', 1),
(476, '2019-06-04', '', 1),
(477, '2019-06-04', '', 1),
(478, '2019-06-04', '', 1),
(479, '2019-06-04', '', 1),
(480, '2019-06-04', '', 1),
(481, '2019-06-04', '', 1),
(482, '2019-06-04', '', 1),
(483, '2019-06-04', '', 1),
(484, '2019-06-04', '', 1),
(485, '2019-06-04', '', 1),
(486, '2019-06-04', '', 1),
(487, '2019-06-04', '', 1),
(488, '2019-06-04', '', 1),
(489, '2019-06-04', '', 1),
(490, '2019-06-04', '', 1),
(491, '2019-06-04', '', 1),
(492, '2019-06-04', '', 1),
(493, '2019-06-04', '', 1),
(494, '2019-06-04', '', 1),
(495, '2019-06-04', '', 1),
(496, '2019-06-04', '', 1),
(497, '2019-06-04', '', 1),
(498, '2019-06-04', '', 1),
(499, '2019-06-04', '', 1),
(500, '2019-06-04', '', 1),
(501, '2019-06-04', '', 1),
(502, '2019-06-04', '', 1),
(503, '2019-06-04', '', 1),
(504, '2019-06-04', '', 1),
(505, '2019-06-04', '', 1),
(506, '2019-06-04', '', 1),
(507, '2019-06-04', '', 1),
(508, '2019-06-04', '', 1),
(509, '2019-06-04', '', 1),
(510, '2019-06-04', '', 1),
(511, '2019-06-04', '', 1),
(512, '2019-06-04', '', 1),
(513, '2019-06-04', '', 1),
(514, '2019-06-04', '', 1),
(515, '2019-06-04', '', 1),
(516, '2019-06-04', '', 1),
(517, '2019-06-04', '', 1),
(518, '2019-06-04', '', 1),
(519, '2019-06-04', '', 1),
(520, '2019-06-04', '', 1),
(521, '2019-06-04', '', 1),
(522, '2019-06-04', '', 1),
(523, '2019-06-04', '', 1),
(524, '2019-06-04', '', 1),
(525, '2019-06-04', '', 1),
(526, '2019-06-04', '', 1),
(527, '2019-06-04', '', 1),
(528, '2019-06-04', '', 1),
(529, '2019-06-04', '', 1),
(530, '2019-06-04', '', 1),
(531, '2019-06-04', '', 1),
(532, '2019-06-04', '', 1),
(533, '2019-06-04', '', 1),
(534, '2019-06-04', '', 1),
(535, '2019-06-04', '', 1),
(536, '2019-06-04', '', 1),
(537, '2019-06-04', '', 1),
(538, '2019-06-04', '', 1),
(539, '2019-06-04', '', 1),
(540, '2019-06-04', '', 1),
(541, '2019-06-04', '', 1),
(542, '2019-06-04', '', 1),
(543, '2019-06-04', '', 1),
(544, '2019-06-04', '', 1),
(545, '2019-06-04', '', 1),
(546, '2019-06-04', '', 1),
(547, '2019-06-04', '', 1),
(548, '2019-06-04', '', 1),
(549, '2019-06-04', '', 1),
(550, '2019-06-04', '', 1),
(551, '2019-06-04', '', 1),
(552, '2019-06-04', '', 1),
(553, '2019-06-04', '', 1),
(554, '2019-06-04', '', 1),
(555, '2019-06-04', '', 1),
(556, '2019-06-04', '', 1),
(557, '2019-06-04', '', 1),
(558, '2019-06-04', '', 1),
(559, '2019-06-04', '', 1),
(560, '2019-06-04', '', 1),
(561, '2019-06-04', '', 1),
(562, '2019-06-04', '', 1),
(563, '2019-06-04', '', 1),
(564, '2019-06-04', '', 1),
(565, '2019-06-04', '', 1),
(566, '2019-06-04', '', 1),
(567, '2019-06-04', '', 1),
(568, '2019-06-04', '', 1),
(569, '2019-06-04', '', 1),
(570, '2019-06-04', '', 1),
(571, '2019-06-04', '', 1),
(572, '2019-06-04', '', 1),
(573, '2019-06-04', '', 1),
(574, '2019-06-04', '', 1),
(575, '2019-06-04', '', 1),
(576, '2019-06-04', '', 1),
(577, '2019-06-04', '', 1),
(578, '2019-06-04', '', 1),
(579, '2019-06-04', '', 1),
(580, '2019-06-04', '', 1),
(581, '2019-06-04', '', 1),
(582, '2019-06-04', '', 1),
(583, '2019-06-04', '', 1),
(584, '2019-06-04', '', 1),
(585, '2019-06-04', '', 1),
(586, '2019-06-04', '', 1),
(587, '2019-06-04', '', 1),
(588, '2019-06-04', '', 1),
(589, '2019-06-04', '', 1),
(590, '2019-06-04', '', 1),
(591, '2019-06-04', '', 1),
(592, '2019-06-04', '', 1),
(593, '2019-06-04', '', 1),
(594, '2019-06-04', '', 1),
(595, '2019-06-04', '', 1),
(596, '2019-06-04', '', 1),
(597, '2019-06-04', '', 1),
(598, '2019-06-04', '', 1),
(599, '2019-06-04', '', 1),
(600, '2019-06-04', '', 1),
(601, '2019-06-04', '', 1),
(602, '2019-06-04', '', 1),
(603, '2019-06-04', '', 1),
(604, '2019-06-04', '', 1),
(605, '2019-06-04', '', 1),
(606, '2019-06-04', '', 1),
(607, '2019-06-04', '', 1),
(608, '2019-06-04', '', 1),
(609, '2019-06-04', '', 1),
(610, '2019-06-04', '', 1),
(611, '2019-06-04', '', 1),
(612, '2019-06-04', '', 1),
(613, '2019-06-04', '', 1),
(614, '2019-06-04', '', 1),
(615, '2019-06-04', '', 1),
(616, '2019-06-04', '', 1),
(617, '2019-06-04', '', 1),
(618, '2019-06-04', '', 1),
(619, '2019-06-04', '', 1),
(620, '2019-06-04', '', 1),
(621, '2019-06-04', '', 1),
(622, '2019-06-04', '', 1),
(623, '2019-06-04', '', 1),
(624, '2019-06-04', '', 1),
(625, '2019-06-04', '', 1),
(626, '2019-06-04', '', 1),
(627, '2019-06-04', '', 1),
(628, '2019-06-04', '', 1),
(629, '2019-06-04', '', 1),
(630, '2019-06-04', '', 1),
(631, '2019-06-04', '', 1),
(632, '2019-06-04', '', 1),
(633, '2019-06-04', '', 1),
(634, '2019-06-04', '', 1),
(635, '2019-06-04', '', 1),
(636, '2019-06-04', '', 1),
(637, '2019-06-04', '', 1),
(638, '2019-06-04', '', 1),
(639, '2019-06-04', '', 1),
(640, '2019-06-04', '', 1),
(641, '2019-06-04', '', 1),
(642, '2019-06-04', '', 1),
(643, '2019-06-04', '', 1),
(644, '2019-06-04', '', 1),
(645, '2019-06-04', '', 1),
(646, '2019-06-04', '', 1),
(647, '2019-06-04', '', 1),
(648, '2019-06-04', '', 1),
(649, '2019-06-04', '', 1),
(650, '2019-06-04', '', 1),
(651, '2019-06-04', '', 1),
(652, '2019-06-04', '', 1),
(653, '2019-06-04', '', 1),
(654, '2019-06-04', '', 1),
(655, '2019-06-04', '', 1),
(656, '2019-06-04', '', 1),
(657, '2019-06-04', '', 1),
(658, '2019-06-04', '', 1),
(659, '2019-06-04', '', 1),
(660, '2019-06-04', '', 1),
(661, '2019-06-04', '', 1),
(662, '2019-06-04', '', 1),
(663, '2019-06-04', '', 1),
(664, '2019-06-04', '', 1),
(665, '2019-06-04', '', 1),
(666, '2019-06-04', '', 1),
(667, '2019-06-04', '', 1),
(668, '2019-06-04', '', 1),
(669, '2019-06-04', '', 1),
(670, '2019-06-04', '', 1),
(671, '2019-06-04', '', 1),
(672, '2019-06-04', '', 1),
(673, '2019-06-04', '', 1),
(674, '2019-06-04', '', 1),
(675, '2019-06-04', '', 1),
(676, '2019-06-04', '', 1),
(677, '2019-06-04', '', 1),
(678, '2019-06-04', '', 1),
(679, '2019-06-04', '', 1),
(680, '2019-06-04', '', 1),
(681, '2019-06-04', '', 1),
(682, '2019-06-04', '', 1),
(683, '2019-06-04', '', 1),
(684, '2019-06-04', '', 1),
(685, '2019-06-04', '', 1),
(686, '2019-06-04', '', 1),
(687, '2019-06-04', '', 1),
(688, '2019-06-04', '', 1),
(689, '2019-06-04', '', 1),
(690, '2019-06-04', '', 1),
(691, '2019-06-04', '', 1),
(692, '2019-06-04', '', 1),
(693, '2019-06-04', '', 1),
(694, '2019-06-04', '', 1),
(695, '2019-06-04', '', 1),
(696, '2019-06-04', '', 1),
(697, '2019-06-04', '', 1),
(698, '2019-06-04', '', 1),
(699, '2019-06-04', '', 1),
(700, '2019-06-04', '', 1),
(701, '2019-06-04', '', 1),
(702, '2019-06-04', '', 1),
(703, '2019-06-04', '', 1),
(704, '2019-06-04', '', 1),
(705, '2019-06-04', '', 1),
(706, '2019-06-04', '', 1),
(707, '2019-06-04', '', 1),
(708, '2019-06-04', '', 1),
(709, '2019-06-04', '', 1),
(710, '2019-06-04', '', 1),
(711, '2019-06-04', '', 1),
(712, '2019-06-04', '', 1),
(713, '2019-06-04', '', 1),
(714, '2019-06-04', '', 1),
(715, '2019-06-04', '', 1),
(716, '2019-06-04', '', 1),
(717, '2019-06-04', '', 1),
(718, '2019-06-04', '', 1),
(719, '2019-06-04', '', 1),
(720, '2019-06-04', '', 1),
(721, '2019-06-04', '', 1),
(722, '2019-06-04', '', 1),
(723, '2019-06-04', '', 1),
(724, '2019-06-04', '', 1),
(725, '2019-06-04', '', 1),
(726, '2019-06-04', '', 1),
(727, '2019-06-04', '', 1),
(728, '2019-06-04', '', 1),
(729, '2019-06-04', '', 1),
(730, '2019-06-04', '', 1),
(731, '2019-06-04', '', 1),
(732, '2019-06-04', '', 1),
(733, '2019-06-04', '', 1),
(734, '2019-06-04', '', 1),
(735, '2019-06-04', '', 1),
(736, '2019-06-04', '', 1),
(737, '2019-06-04', '', 1),
(738, '2019-06-04', '', 1),
(739, '2019-06-04', '', 1),
(740, '2019-06-04', '', 1),
(741, '2019-06-04', '', 1),
(742, '2019-06-04', '', 1),
(743, '2019-06-04', '', 1),
(744, '2019-06-04', '', 1),
(745, '2019-06-04', '', 1),
(746, '2019-06-04', '', 1),
(747, '2019-06-04', '', 1),
(748, '2019-06-04', '', 1),
(749, '2019-06-04', '', 1),
(750, '2019-06-04', '', 1),
(751, '2019-06-04', '', 1),
(752, '2019-06-04', '', 1),
(753, '2019-06-04', '', 1),
(754, '2019-06-04', '', 1),
(755, '2019-06-04', '', 1),
(756, '2019-06-04', '', 1),
(757, '2019-06-04', '', 1),
(758, '2019-06-04', '', 1),
(759, '2019-06-04', '', 1),
(760, '2019-06-04', '', 1),
(761, '2019-06-04', '', 1),
(762, '2019-06-04', '', 1),
(763, '2019-06-04', '', 1),
(764, '2019-06-04', '', 1),
(765, '2019-06-04', '', 1),
(766, '2019-06-04', '', 1),
(767, '2019-06-04', '', 1),
(768, '2019-06-04', '', 1),
(769, '2019-06-04', '', 1),
(770, '2019-06-04', '', 1),
(771, '2019-06-04', '', 1),
(772, '2019-06-04', '', 1),
(773, '2019-06-04', '', 1),
(774, '2019-06-04', '', 1),
(775, '2019-06-04', '', 1),
(776, '2019-06-04', '', 1),
(777, '2019-06-04', '', 1),
(778, '2019-06-04', '', 1),
(779, '2019-06-04', '', 1),
(780, '2019-06-04', '', 1),
(781, '2019-06-04', '', 1),
(782, '2019-06-04', '', 1),
(783, '2019-06-04', '', 1),
(784, '2019-06-04', '', 1),
(785, '2019-06-04', '', 1),
(786, '2019-06-04', '', 1),
(787, '2019-06-04', '', 1),
(788, '2019-06-04', '', 1),
(789, '2019-06-04', '', 1),
(790, '2019-06-04', '', 1),
(791, '2019-06-04', '', 1),
(792, '2019-06-04', '', 1),
(793, '2019-06-04', '', 1),
(794, '2019-06-04', '', 1),
(795, '2019-06-04', '', 1),
(796, '2019-06-04', '', 1),
(797, '2019-06-04', '', 1),
(798, '2019-06-04', '', 1),
(799, '2019-06-04', '', 1),
(800, '2019-06-04', '', 1),
(801, '2019-06-04', '', 1),
(802, '2019-06-04', '', 1),
(803, '2019-06-04', '', 1),
(804, '2019-06-04', '', 1),
(805, '2019-06-04', '', 1),
(806, '2019-06-04', '', 1),
(807, '2019-06-04', '', 1),
(808, '2019-06-04', '', 1),
(809, '2019-06-04', '', 1),
(810, '2019-06-04', '', 1),
(811, '2019-06-04', '', 1),
(812, '2019-06-04', '', 1),
(813, '2019-06-04', '', 1),
(814, '2019-06-04', '', 1),
(815, '2019-06-04', '', 1),
(816, '2019-06-04', '', 1),
(817, '2019-06-04', '', 1),
(818, '2019-06-04', '', 1),
(819, '2019-06-04', '', 1),
(820, '2019-06-04', '', 1),
(821, '2019-06-04', '', 1),
(822, '2019-06-04', '', 1),
(823, '2019-06-04', '', 1),
(824, '2019-06-04', '', 1),
(825, '2019-06-04', '', 1),
(826, '2019-06-04', '', 1),
(827, '2019-06-04', '', 1),
(828, '2019-06-04', '', 1),
(829, '2019-06-04', '', 1),
(830, '2019-06-04', '', 1),
(831, '2019-06-04', '', 1),
(832, '2019-06-04', '', 1),
(833, '2019-06-04', '', 1),
(834, '2019-06-04', '', 1),
(835, '2019-06-04', '', 1),
(836, '2019-06-04', '', 1),
(837, '2019-06-04', '', 1),
(838, '2019-06-04', '', 1),
(839, '2019-06-04', '', 1),
(840, '2019-06-04', '', 1),
(841, '2019-06-04', '', 1),
(842, '2019-06-04', '', 1),
(843, '2019-06-04', '', 1),
(844, '2019-06-04', '', 1),
(845, '2019-06-04', '', 1),
(846, '2019-06-04', '', 1),
(847, '2019-06-04', '', 1),
(848, '2019-06-04', '', 1),
(849, '2019-06-04', '', 1),
(850, '2019-06-04', '', 1),
(851, '2019-06-04', '', 1),
(852, '2019-06-04', '', 1),
(853, '2019-06-04', '', 1),
(854, '2019-06-04', '', 1),
(855, '2019-06-04', '', 1),
(856, '2019-06-04', '', 1),
(857, '2019-06-04', '', 1),
(858, '2019-06-04', '', 1),
(859, '2019-06-04', '', 1),
(860, '2019-06-04', '', 1),
(861, '2019-06-04', '', 1),
(862, '2019-06-04', '', 1),
(863, '2019-06-04', '', 1),
(864, '2019-06-04', '', 1),
(865, '2019-06-04', '', 1),
(866, '2019-06-04', '', 1),
(867, '2019-06-04', '', 1),
(868, '2019-06-04', '', 1),
(869, '2019-06-04', '', 1),
(870, '2019-06-04', '', 1),
(871, '2019-06-04', '', 1),
(872, '2019-06-04', '', 1),
(873, '2019-06-04', '', 1),
(874, '2019-06-04', '', 1),
(875, '2019-06-04', '', 1),
(876, '2019-06-04', '', 1),
(877, '2019-06-04', '', 1),
(878, '2019-06-04', '', 1),
(879, '2019-06-04', '', 1),
(880, '2019-06-04', '', 1),
(881, '2019-06-04', '', 1),
(882, '2019-06-04', '', 1),
(883, '2019-06-04', '', 1),
(884, '2019-06-04', '', 1),
(885, '2019-06-04', '', 1),
(886, '2019-06-04', '', 1),
(887, '2019-06-04', '', 1),
(888, '2019-06-04', '', 1),
(889, '2019-06-04', '', 1),
(890, '2019-06-04', '', 1),
(891, '2019-06-04', '', 1),
(892, '2019-06-04', '', 1),
(893, '2019-06-04', '', 1),
(894, '2019-06-04', '', 1),
(895, '2019-06-04', '', 1),
(896, '2019-06-04', '', 1),
(897, '2019-06-04', '', 1),
(898, '2019-06-04', '', 1),
(899, '2019-06-04', '', 1),
(900, '2019-06-04', '', 1),
(901, '2019-06-04', '', 1),
(902, '2019-06-04', '', 1),
(903, '2019-06-04', '', 1),
(904, '2019-06-04', '', 1),
(905, '2019-06-04', '', 1),
(906, '2019-06-04', '', 1),
(907, '2019-06-04', '', 1),
(908, '2019-06-04', '', 1),
(909, '2019-06-04', '', 1),
(910, '2019-06-04', '', 1),
(911, '2019-06-04', '', 1),
(912, '2019-06-04', '', 1),
(913, '2019-06-04', '', 1),
(914, '2019-06-04', '', 1),
(915, '2019-06-04', '', 1),
(916, '2019-06-04', '', 1),
(917, '2019-06-04', '', 1),
(918, '2019-06-04', '', 1),
(919, '2019-06-04', '', 1),
(920, '2019-06-04', '', 1),
(921, '2019-06-04', '', 1),
(922, '2019-06-04', '', 1),
(923, '2019-06-04', '', 1),
(924, '2019-06-04', '', 1),
(925, '2019-06-04', '', 1),
(926, '2019-06-04', '', 1),
(927, '2019-06-04', '', 1),
(928, '2019-06-04', '', 1),
(929, '2019-06-04', '', 1),
(930, '2019-06-04', '', 1),
(931, '2019-06-04', '', 1),
(932, '2019-06-04', '', 1),
(933, '2019-06-04', '', 1),
(934, '2019-06-04', '', 1),
(935, '2019-06-04', '', 1),
(936, '2019-06-04', '', 1),
(937, '2019-06-04', '', 1),
(938, '2019-06-04', '', 1),
(939, '2019-06-04', '', 1),
(940, '2019-06-04', '', 1),
(941, '2019-06-04', '', 1),
(942, '2019-06-04', '', 1),
(943, '2019-06-04', '', 1),
(944, '2019-06-04', '', 1),
(945, '2019-06-04', '', 1),
(946, '2019-06-04', '', 1),
(947, '2019-06-04', '', 1),
(948, '2019-06-04', '', 1),
(949, '2019-06-04', '', 1),
(950, '2019-06-04', '', 1),
(951, '2019-06-04', '', 1),
(952, '2019-06-04', '', 1),
(953, '2019-06-04', '', 1),
(954, '2019-06-04', '', 1),
(955, '2019-06-04', '', 1),
(956, '2019-06-04', '', 1),
(957, '2019-06-04', '', 1),
(958, '2019-06-04', '', 1),
(959, '2019-06-04', '', 1),
(960, '2019-06-04', '', 1),
(961, '2019-06-04', '', 1),
(962, '2019-06-04', '', 1),
(963, '2019-06-04', '', 1),
(964, '2019-06-04', '', 1),
(965, '2019-06-04', '', 1),
(966, '2019-06-04', '', 1),
(967, '2019-06-04', '', 1),
(968, '2019-06-04', '', 1),
(969, '2019-06-04', '', 1),
(970, '2019-06-04', '', 1),
(971, '2019-06-04', '', 1),
(972, '2019-06-04', '', 1),
(973, '2019-06-04', '', 1),
(974, '2019-06-04', '', 1),
(975, '2019-06-04', '', 1),
(976, '2019-06-04', '', 1),
(977, '2019-06-04', '', 1),
(978, '2019-06-04', '', 1),
(979, '2019-06-04', '', 1),
(980, '2019-06-04', '', 1),
(981, '2019-06-04', '', 1),
(982, '2019-06-04', '', 1),
(983, '2019-06-04', '', 1),
(984, '2019-06-04', '', 1),
(985, '2019-06-04', '', 1),
(986, '2019-06-04', '', 1),
(987, '2019-06-04', '', 1),
(988, '2019-06-04', '', 1),
(989, '2019-06-04', '', 1),
(990, '2019-06-04', '', 1),
(991, '2019-06-04', '', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `COMPRAS_CAB`
--

DROP TABLE IF EXISTS `COMPRAS_CAB`;
CREATE TABLE `COMPRAS_CAB` (
  `COM_CAB_ID` int(11) NOT NULL,
  `COM_CAB_PROVEEDOR_ID` int(11) NOT NULL,
  `COM_CAB_USUARIO_ID` int(11) NOT NULL,
  `COM_CAB_FECHA` datetime NOT NULL,
  `COM_CAB_TIPO_COMPROVANTE` int(11) NOT NULL,
  `COM_CAB_NUM_COMPROVANTE` int(11) NOT NULL,
  `COM_CAB_SUBTOTAL` double NOT NULL,
  `COM_CAB_IVA` double NOT NULL,
  `COM_CAB_TOTAL` double NOT NULL,
  `COM_CAB_ESTADO` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `COMPRAS_CAB`
--

INSERT INTO `COMPRAS_CAB` (`COM_CAB_ID`, `COM_CAB_PROVEEDOR_ID`, `COM_CAB_USUARIO_ID`, `COM_CAB_FECHA`, `COM_CAB_TIPO_COMPROVANTE`, `COM_CAB_NUM_COMPROVANTE`, `COM_CAB_SUBTOTAL`, `COM_CAB_IVA`, `COM_CAB_TOTAL`, `COM_CAB_ESTADO`) VALUES
(1, 2, 1, '2019-06-06 20:58:26', 0, 5055, 800, 96, 896, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `COMPRAS_DETALLE`
--

DROP TABLE IF EXISTS `COMPRAS_DETALLE`;
CREATE TABLE `COMPRAS_DETALLE` (
  `COM_DET_ID` int(11) NOT NULL,
  `COM_CAB_ID` int(11) NOT NULL,
  `PRO_ID` int(11) NOT NULL,
  `COM_DET_CATIDAD` int(11) NOT NULL,
  `COM_DET_VALOR` double NOT NULL,
  `COM_DET_TOTAL` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `COMPRAS_DETALLE`
--

INSERT INTO `COMPRAS_DETALLE` (`COM_DET_ID`, `COM_CAB_ID`, `PRO_ID`, `COM_DET_CATIDAD`, `COM_DET_VALOR`, `COM_DET_TOTAL`) VALUES
(1, 1, 1, 100, 8.96, 896);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `FACTURA_CAB`
--

DROP TABLE IF EXISTS `FACTURA_CAB`;
CREATE TABLE `FACTURA_CAB` (
  `FAC_CAB_ID` int(10) NOT NULL,
  `FAC_CAB_FECHA` datetime NOT NULL,
  `FAC_CAB_SUBTOTAL` double NOT NULL,
  `FAC_CAB_DESCUENTO` double NOT NULL,
  `FAC_CAB_IVA` double NOT NULL,
  `FAC_CAB_TOTAL` double NOT NULL,
  `FAC_CAB_FORMA_P` int(1) NOT NULL,
  `PER_ID` int(10) NOT NULL,
  `USUARIO_ID` int(11) NOT NULL,
  `FAC_CAB_ESTADO` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `FACTURA_CAB`
--

INSERT INTO `FACTURA_CAB` (`FAC_CAB_ID`, `FAC_CAB_FECHA`, `FAC_CAB_SUBTOTAL`, `FAC_CAB_DESCUENTO`, `FAC_CAB_IVA`, `FAC_CAB_TOTAL`, `FAC_CAB_FORMA_P`, `PER_ID`, `USUARIO_ID`, `FAC_CAB_ESTADO`) VALUES
(1, '2019-06-06 21:06:53', 22.95, 0, 0, 22.95, 0, 11, 1, 1),
(2, '2019-06-06 21:49:34', 22.95, 0, 2.75, 25.7, 0, 9, 1, 1),
(3, '2019-06-22 15:59:43', 45, 0.9, 5.4, 50.4, 0, 7, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `FACTURA_DETALLE`
--

DROP TABLE IF EXISTS `FACTURA_DETALLE`;
CREATE TABLE `FACTURA_DETALLE` (
  `FAC_DET_ID` int(6) NOT NULL,
  `FAC_CAB_ID` int(6) NOT NULL,
  `PRO_ID` int(6) NOT NULL,
  `FAC_DET_CANTIDAD` int(6) NOT NULL,
  `FAC_DET_PVP` double NOT NULL,
  `FAC_DET_DESCUENTO` double NOT NULL,
  `FAC_DET_TOTAL` double NOT NULL,
  `FAC_DET_PC` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `FACTURA_DETALLE`
--

INSERT INTO `FACTURA_DETALLE` (`FAC_DET_ID`, `FAC_CAB_ID`, `PRO_ID`, `FAC_DET_CANTIDAD`, `FAC_DET_PVP`, `FAC_DET_DESCUENTO`, `FAC_DET_TOTAL`, `FAC_DET_PC`) VALUES
(1, 1, 1, 1, 13.6, 0, 13.6, 8.51),
(2, 1, 2, 1, 9.35, 0, 9.35, 5.57),
(3, 2, 1, 1, 13.6, 0, 13.6, 8.51),
(4, 2, 2, 1, 9.35, 0, 9.35, 5.57),
(5, 3, 1, 2, 13.6, 0.2, 27, 8.08),
(6, 3, 2, 2, 9.35, 0.7, 18, 5.57);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `KARDEX`
--

DROP TABLE IF EXISTS `KARDEX`;
CREATE TABLE `KARDEX` (
  `KAR_ID` int(11) NOT NULL,
  `PRO_ID` int(11) NOT NULL,
  `KAR_FECHA` datetime NOT NULL,
  `KAR_DETALLE` varchar(100) NOT NULL,
  `KAR_ECANT` int(11) DEFAULT NULL,
  `KAR_EVU` double DEFAULT NULL,
  `KAR_EVT` double DEFAULT NULL,
  `KAR_SCANT` int(11) DEFAULT NULL,
  `KAR_SVU` double DEFAULT NULL,
  `KAR_SVT` double DEFAULT NULL,
  `KAR_XCANT` int(11) DEFAULT NULL,
  `KAR_XVU` double DEFAULT NULL,
  `KAR_XVT` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `KARDEX`
--

INSERT INTO `KARDEX` (`KAR_ID`, `PRO_ID`, `KAR_FECHA`, `KAR_DETALLE`, `KAR_ECANT`, `KAR_EVU`, `KAR_EVT`, `KAR_SCANT`, `KAR_SVU`, `KAR_SVT`, `KAR_XCANT`, `KAR_XVU`, `KAR_XVT`) VALUES
(141, 1, '2019-05-26 23:13:51', 'Inventario Inicial', 100, 8, 800, NULL, NULL, NULL, 100, 8, 800),
(142, 1, '2019-05-26 23:14:44', 'Venta Segun factura #1', NULL, NULL, NULL, 1, 8, 8, 99, 8, 792),
(143, 2, '2019-05-26 23:21:24', 'Inventario Inicial', 100, 5.5, 550, NULL, NULL, NULL, 100, 5.5, 550),
(144, 2, '2019-05-26 23:38:48', 'Venta Segun factura #2', NULL, NULL, NULL, 2, 5.5, 11, 98, 5.5, 539),
(145, 2, '2019-05-27 00:04:27', 'Venta Segun factura #3', NULL, NULL, NULL, 2, 5.5, 11, 96, 5.5, 528),
(146, 2, '2019-05-27 00:08:29', 'Venta Segun factura #4', NULL, NULL, NULL, 2, 5.5, 11, 94, 5.5, 517),
(147, 1, '2019-05-27 00:10:55', 'Venta Segun factura #5', NULL, NULL, NULL, 1, 8, 8, 98, 8, 784),
(148, 1, '2019-05-27 00:11:40', 'Venta Segun factura #6', NULL, NULL, NULL, 1, 8, 8, 97, 8, 776),
(149, 2, '2019-05-27 00:13:54', 'Venta Segun factura #7', NULL, NULL, NULL, 2, 5.5, 11, 92, 5.5, 506),
(150, 1, '2019-05-27 20:10:42', 'Venta Segun Nota de Venta #1', NULL, NULL, NULL, 1, 8, 8, 96, 8, 768),
(151, 2, '2019-05-27 20:14:29', 'Venta Segun factura #8', NULL, NULL, NULL, 1, 5.5, 5.5, 91, 5.5, 500.5),
(152, 2, '2019-05-27 20:33:30', 'Segun Compra #1', 10, 6.16, 61.6, NULL, NULL, NULL, 101, 5.57, 562.1),
(153, 1, '2019-05-27 20:33:30', 'Segun Compra #1', 10, 8.96, 89.6, NULL, NULL, NULL, 106, 8.09, 857.6),
(154, 1, '2019-06-04 23:36:52', 'Venta Segun Nota de Venta #1', NULL, NULL, NULL, 1, 8.09, 8.09, 105, 8.09, 849.51),
(155, 1, '2019-06-06 20:58:26', 'Segun Compra #1', 100, 8.96, 896, NULL, NULL, NULL, 205, 8.51, 1745.51),
(156, 1, '2019-06-06 21:06:53', 'Venta Segun factura #1', NULL, NULL, NULL, 1, 8.51, 8.51, 204, 8.51, 1737),
(157, 2, '2019-06-06 21:06:53', 'Venta Segun factura #1', NULL, NULL, NULL, 1, 5.57, 5.57, 100, 5.57, 556.53),
(158, 1, '2019-06-06 21:49:34', 'Venta Segun factura #2', NULL, NULL, NULL, 1, 8.51, 8.51, 203, 8.51, 1728.49),
(159, 2, '2019-06-06 21:49:34', 'Venta Segun factura #2', NULL, NULL, NULL, 1, 5.57, 5.57, 99, 5.57, 550.96),
(160, 1, '2019-06-06 23:53:27', 'Devolucion Segun Compra #1', -100, -8.96, -896, NULL, NULL, NULL, 103, 8.08, 832.49),
(161, 1, '2019-06-22 15:59:43', 'Venta Segun factura #3', NULL, NULL, NULL, 2, 8.08, 16.16, 101, 8.08, 816.33),
(162, 2, '2019-06-22 15:59:43', 'Venta Segun factura #3', NULL, NULL, NULL, 2, 5.57, 11.14, 97, 5.57, 539.82);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `NOTA_CAB`
--

DROP TABLE IF EXISTS `NOTA_CAB`;
CREATE TABLE `NOTA_CAB` (
  `NOT_CAB_ID` int(10) NOT NULL,
  `NOT_CAB_FECHA` datetime NOT NULL,
  `NOT_CAB_DESCUENTO` double NOT NULL,
  `NOT_CAB_TOTAL` double NOT NULL,
  `NOT_CAB_FORMA_P` int(1) NOT NULL,
  `PER_ID` int(10) NOT NULL,
  `USUARIO_ID` int(10) NOT NULL,
  `NOT__CAB_ESTADO` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `NOTA_CAB`
--

INSERT INTO `NOTA_CAB` (`NOT_CAB_ID`, `NOT_CAB_FECHA`, `NOT_CAB_DESCUENTO`, `NOT_CAB_TOTAL`, `NOT_CAB_FORMA_P`, `PER_ID`, `USUARIO_ID`, `NOT__CAB_ESTADO`) VALUES
(1, '2019-06-04 23:36:52', 0, 13.6, 0, 357, 6, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `NOTA_DETALLE`
--

DROP TABLE IF EXISTS `NOTA_DETALLE`;
CREATE TABLE `NOTA_DETALLE` (
  `NOT_DET_ID` int(10) NOT NULL,
  `NOT_CAB_ID` int(10) NOT NULL,
  `PRO_ID` int(10) NOT NULL,
  `NOT_DET_CANTIDAD` int(10) NOT NULL,
  `NOT_DET_PVP` double NOT NULL,
  `NOT_DET_DESCUENTO` double NOT NULL,
  `NOT_DET_TOTAL` double NOT NULL,
  `NOT_DET_PC` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `NOTA_DETALLE`
--

INSERT INTO `NOTA_DETALLE` (`NOT_DET_ID`, `NOT_CAB_ID`, `PRO_ID`, `NOT_DET_CANTIDAD`, `NOT_DET_PVP`, `NOT_DET_DESCUENTO`, `NOT_DET_TOTAL`, `NOT_DET_PC`) VALUES
(2, 1, 1, 1, 13.6, 0, 13.6, 8.09);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `PERSONA`
--

DROP TABLE IF EXISTS `PERSONA`;
CREATE TABLE `PERSONA` (
  `PER_ID` int(11) NOT NULL,
  `PER_CEDULA` varchar(13) DEFAULT NULL,
  `PER_NOMBRE` varchar(100) DEFAULT NULL,
  `PER_DIRECCION` varchar(200) DEFAULT NULL,
  `PER_TELEFONO` varchar(10) DEFAULT NULL,
  `PER_CELULAR` varchar(10) DEFAULT NULL,
  `PER_CORREO` varchar(100) DEFAULT NULL,
  `PER_SEXO` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `PERSONA`
--

INSERT INTO `PERSONA` (`PER_ID`, `PER_CEDULA`, `PER_NOMBRE`, `PER_DIRECCION`, `PER_TELEFONO`, `PER_CELULAR`, `PER_CORREO`, `PER_SEXO`) VALUES
(1, '0104516257', 'Jaime Efrain Guiracocha Chocho', '', '', '', '', 'M'),
(2, '0104516240', 'MARIA ALEXANDRA', 'S/N', '2888999', '0988887777', 'mariaalexandraguira@gmail.com', 'F'),
(5, '0104516240001', 'MMM', 'XXX', '16516', '651651', '', 'F'),
(6, '0923646715', 'MAURICIO', '', '', '', '', 'M'),
(7, '0100196179001', 'ECHEVERRIA ECHEVERRIA LIGIA MAGDALENA', 'AV ESPAÑA S/N Y ELIA LIUT', '', '0991677204', '', 'F'),
(8, '0104671615001', 'ABAD BUENO LUIS ANTONIO', 'S/N Y VIA A HUINTUL', '', '0981630112', '', 'M'),
(9, '0102059722001', 'ABAD MOLINA OSCAR FERNANDO', 'JOSE PERALTA S/N Y CORNELIO MERCHAN', '4103874', '', '', ''),
(10, '0102660750001', 'ABRIL GUZAMN EDISON ABEL', 'JUAN DE SENIERGES S/N Y VIA A BAÑOS', '', '', '', ''),
(11, '0102145323001', 'ABRIL IDROVO JAIME RODRIGO', 'MIGUEL DIAZ 7-16 Y ALFONSO MORENO MORA', '2887116', '', '', ''),
(12, '0301479895001', 'ABRIL MOLINA CARLOS LEONARDO', 'DEL PEDREGAL  H8 Y DE LAS LADERAS', '095603078', '', '', ''),
(13, '0102759198001', 'AGUILAR GORDILLO LUIS FABIAN', 'SAN FERNANDO K S56-129', '080400851', '', '', ''),
(14, '0102997715001', 'AGUILAR LARRIVA BLANCA JANETH', 'CALLE VIEJA S/N Y CARRETAS', '091882821', '', '', ''),
(15, '0102385051001', 'AGUILAR LARRIVA MILTON GUILLERMO', 'CALLE VIEJA 10-73 Y CALLE DE LAS CARRETAS', '', '', '', ''),
(16, '0103888681001', 'AGUILAR MONTESDEOCA FABIAN GUSTAVO', 'TURUHUICO S-N Y HUACAS', '2341664', '', '', ''),
(17, '0101154482001', 'AGUILAR URGILES GUILLERMO ARTURO', 'VIA A GUARUMALES S/N', '', '', '', ''),
(18, '0100433507001', 'AGUILAR VILLALTA MARIA FLORENCIA', 'VIA A GUACHAPALA', '', '', '', ''),
(19, '1307683142001', 'ALAVA SANCHEZ WELINGTON CASELI', 'BENIGNO PALACIOS S/N Y AV. DE LAS AMERICAS', '093801644', '', '', ''),
(20, '0102534781001', 'ALBARRACIN AUQUILLA JOSE ROBERTO', 'VIA PRINCIPAL A BELLVISTA', '097052353', '', '', ''),
(21, '0190007510001', 'ALMACENES JUAN ELJURI', 'GIL RAMIRES DAVALOS', '2862111', '', '', ''),
(22, '0604154674001', 'ALULEMA SOLORZANO SEGUNDO SALVADOR', 'RIOBAMBA', '', '', '', ''),
(23, '0190009173001', 'ALUTEC CIA. LTDA.', 'CALLE VIEJA 11-79 Y ELIA LIUT', '2864766', '', '', ''),
(24, '0102708351001', 'ALVARADO ALVARADO CESAR PATRICIO', 'RUDESINDO INGA VELES S/N', '4088633', '', '', ''),
(25, '1104348675001', 'ALVARADO FLORES IRMA VERONICA', 'AV. ESPAÑA 11-20 Y ELIA LIUT', '094409062', '', '', ''),
(26, '0100235761001', 'ALVARADO MORA JOSE ROSENDO', 'AV. HURTADO DE MENDOZA S/N Y AV. ESPAÑA', '', '', '', ''),
(27, '0101142255001', 'ALVAREZ RIVERA ANDRIAN FERNANDO', 'VIA AL ORIENTE S/N', '', '', '', ''),
(28, '0102001997001', 'ALVEAR SUAREZ ANA', 'GARCIA MORENO S/N Y JULIO MARIA MATOVELLE', '', '', '', ''),
(29, '0102488368001', 'AMAY GALAN RUBEN PATRICIO', 'LA CASTELLANA', '2341646', '', '', ''),
(30, '0102263480001', 'AMAYA PINOS MARCO ESTEBAN', 'ISABEL LANDIVAR S-N Y LORENZO PIEDRA', '082809626', '', '', ''),
(31, '0102203254001', 'AMON ABAD JAIME ROLANDO', 'VIA AZOGUES S/N', '', '', '', ''),
(32, '0100977776001', 'ANDRADE BARZALLO AURELIO RUBEN', 'MARISCAL LAMAR 24-110 Y ALFONSO ANDRADE', '2832960', '', '', ''),
(33, '0105772396001', 'ANDRADE CARRION RENE ISMAEL', 'SIMON BOLIVAR S/N Y JOSE MIGUEL BARZALLO', '080053229', '', '', ''),
(34, '0300820727001', 'ANDRADE CRUZ ANGEL ALFONSO', 'S-N', '', '', '', ''),
(35, '0101448355001', 'ANDRADE GUTIERREZ MARINA ESTHELA', 'LOS CONQUISTADORES S/N Y AV. DON BOSCO', '098289804', '', '', ''),
(36, '0100873504001', 'ANDRADE RODRIGUEZ MANUEL LEONCIO', 'AV. ORDOÑEZ LAZO S/N Y GUAYACAN', '4075898', '', '', ''),
(37, '0300776960001', 'ANDRADE SIGUENCIA JULIO CESAR', 'FRANCO DAVILA S-N Y GRAHAM BELL', '099284294', '', '', ''),
(38, '0703407130001', 'APOLO ORDOÑEZ JHONSON FRANCISCO', 'PEDRO LOPEZ DE ARGUDO S/N Y ARISTOTELES', '2859882', '', '', ''),
(39, '0105505986001', 'VALDIVIEZO CASTRO JHOVANNY PATRICIO', 'FRANCISCO CISNEROS S/N Y CARLOS BERREZUETA', '2855342', '', '', ''),
(40, '0103146205001', 'ARAY PALOMEQUE MIRTHA VERONICA', 'NICOLAS VAZQUEZ S/N', '', '', '', ''),
(41, '0102553112001', 'ARCE LLIVICOTA TANIA SUSANA', 'S/N', '', '', '', ''),
(42, '0100593748001', 'ARCE RIVERA JUSTO LORENZO', 'SEVILLA DE ORO', '', '', '', ''),
(43, '0103515490001', 'ARCENTALES TOGRA OLGA JAQUELINE', 'SIMON BOLIVAR S/N', '', '', '', ''),
(44, '0103642336001', 'ARCINIEGAS SIGUENZA MARTHA LILIANA', 'HERNANDO LEOPULLA L-13 Y AV. PASEO DE LOS CAÑARIS', '2802823', '', '', ''),
(45, '0101339414001', 'AREVALO ASTUDILLO REBERCA BEATRIZ', 'CALLE VIEJA 12-300 Y ELIA LIUT', '2860495', '', '', ''),
(46, '0102668423001', 'AREVALO INIGUEZ JORGE LEONCIO', 'ALCABALAS 1-129 Y CALLE VIEJA', '080673592', '', '', ''),
(47, '0103953006001', 'AREVALO LUNA NANCY CATALINA', 'AV. 10 DE AGOSTO 2-293 Y AV. RICARDO MUÑOZ', '', '', '', ''),
(48, '0101063170001', 'AREVALO OTAVALO LUIS ANTONIO', 'AV. 10 DE AGOSTO 2-293 Y AV. RICARDO MUÑOZ', '', '', '', ''),
(49, '0300092350001', 'ARGUDO ARGUDO OLGA MARIA BEATRIZ', 'CICA FERNANDO MALO 67', '2459350', '', '', ''),
(50, '0912291531001', 'ARIAS ANGAMARCA IGNACIO RICARDO', 'AV. SIGLO XX 4-05 Y JULIO MARIA MATOVELLE', '', '', '', ''),
(51, '0102888724001', 'ARIZAGA VELEZ PAUL ESTEBAN', 'UCUBAMBA S/N', '2477658', '', '', ''),
(52, '0102927324001', 'ARMIJOS VERA MARCOS LEONARDO', 'OBISPO MIGUEL CRESPO 2-93 Y POLIT LAZO', '', '', '', ''),
(53, '0102597515001', 'ARPI PALACIOS JUAN SALVADOR', 'LAS GARZAS 2-60 Y LOS CISNES', '2885482', '', '', ''),
(54, '0101512663001', 'ARPI PEREZ CLARA EULALIA', 'LIRIBAMBA 2-58 Y QUITO', '4096404', '', '', ''),
(55, '0101030187001', 'ARPI PEREZ JORGE EDUARDO', 'CAMINO CASTILLA CRUZ S/N', '4096203', '', '', ''),
(56, '0916535735001', 'ARROYO MINA WASHINTON SEGUNDO ', 'EDWIN SOCOTO LARRIVA 1-15 Y AV. 12 DE ABRIL', '', '', '', ''),
(57, '0103624102001', 'ARTEAGA PEÑA JENIFFER OCTAVIA', 'ISABEL LA CATOLICA 3-21 Y JOSE ZORRILA CUENCA', '4091693', '', '', ''),
(58, '0103754826001', 'ARTEAGA VIMTIMILLA LUIS EDUARDO', 'CALLE VIEJA 1-133 Y DE LAS ALCABALAS', '2862789', '', '', ''),
(59, '0190350703001', 'ASELIMPRO CIA.LTDA', 'CARRETAS 1-59 Y CALLE VIEJA', '098835497', '', '', ''),
(60, '0103620688001', 'ASITIMBAY PATRICIO', 'AV. DE LAS AMERICAS SECTOR QUINTA CHICA', '085537541', '', '', ''),
(61, '0104756697001', 'ASITIMBAY SEGARRA MIRIAN LILIANA', 'VIA A RODEO S/N', '088848054', '', '', ''),
(62, '0190350843001', 'ASOCIACIÓN AGROPECUARIA SANTA TERESITA', 'VIA A GUACHAPALA', '073011581', '', '', ''),
(63, '0703934851001', 'ASTUDILLO AGUILAR PABLO VLADIMIR', 'VIRACOCHABAMBA 2-84 Y GUAPONDELIG', '094333167', '', '', ''),
(64, '0102192127001', 'ASTUDILLO IÑIGUEZ NANCY LUCIA', 'RAFAEL ROMERO S-N Y CESAR GONZALEZ PERALTA', '', '', '', ''),
(65, '1900319557001', 'ASTUDILLO VASQUEZ ANGEL RODRIGO', 'SANTA ISABEL', '2271220', '', '', ''),
(66, '0103227948001', 'ASTUDILLO ZHUZHINGO CECILIA DE LURDES', 'ROBERTO CRESPO S/N Y EDUARDO', '069450796', '', '', ''),
(67, '0102971140001', 'ATANCURI GORDILLO MANUEL ARMANDO', 'S-N', '092128015', '', '', ''),
(68, '0102583705001', 'AUCAPIÑA TENESACA JUAN JOSE', 'DE LOS CHASQUIS 4-97 Y COJIMIES', '2901132', '', '', ''),
(69, '0101294130001', 'AVENDAÑO DURAN JAUN OSWALDO', 'VIA A GUARUMALES S/N', '', '', '', ''),
(70, '0102957263001', 'AVILA AVILA JOSE DANIEL', 'VIA A LA MERCED S/N', '2475801', '', '', ''),
(71, '0104628219001', 'AVILA CABRERA SAIDA PIEDAD', 'GIGANTONES S/N Y AV. DE LAS AMERICAS', '069796881', '', '', ''),
(72, '0301381620001', 'AVILA CABRERA ZARA HERMIDA', 'AV. DE LAS AMERCAS S/N Y LAS LADERAS', '097383043', '', '', ''),
(73, '0101943645001', 'AVILA LASSO PAUL RENE', 'MIGUEL HEREDIA 9-21 Y BOLIVAR', '2843120', '', '', ''),
(74, '0100067933001', 'AVILA MATUTE VICTOR SALVADOR', 'PANAMERICANA NORTE S-N', '', '', '', ''),
(75, '0100341841001', 'AVILA MOSQUERA RUBEN BOLIVAR ', 'GIL RAMIREZ DAVALOS', '2805691', '', '', ''),
(76, '0104793567001', 'AVILA ORTIZ SILVIA MARLENE', 'S-N PAUTE', '', '', '', ''),
(77, '0104369756001', 'AVILA PINDUISACA CARLA GEANINA', 'EZEQUIEL PADILLA 3-73 Y SIN NOMBRE', '2891604', '', '', ''),
(78, '0300556222001', 'AVILA RIVERA HILDA HERNESTINA', 'AV. HURTADO DE MENDOZA 2-112 Y PAN DE AZUCAR', ' 2808407', '', '', ''),
(79, '0102528353001', 'AVILA TAPIA JUAN PABLO', 'DE LAS LADERAS  1-73  Y AV. GIL RAMIREZ DAVALOS', '4048598', '', '', ''),
(80, '0105621692001', 'AVILES AVILES EDWIN JAVIER', 'CARLOS ARIZAGA VEGA S/N', '', '', '', ''),
(81, '0102536422001', 'AYALA VELEZ ROSA ELENA', 'AMAZONAS 3-82 Y VENEZUELA', '2885111', '', '', ''),
(82, '1715571087001', 'AZOGUE TITUANA FABIAN VICENTE', 'EUGENIO ESPEJO  S/N', '', '', '', ''),
(83, '0105004220001', 'BALAREZO ANDRADE ANA LUCIA', 'EL PAN S/N', '', '', '', ''),
(84, '1802283380001', 'BALSECA ARMENDARIZ RAMIRO NEPTALI', 'VIA A COCHALATA S/N', '2340656', '', '', ''),
(85, '0301341848001', 'BARAHONA PINOS MARIA EULALIA', 'TOMAS ORDOÑEZ 11-87 Y SANGURIMA', '2831055', '', '', ''),
(86, '0103197216001', 'BARAHONA RUIZ BLANCA ELISA', 'S/N PAUTE', '', '', '', ''),
(87, '0103172029001', 'BARAHONA RUIZ ELVIA ROCIO', 'S/N PAUTE', '', '', '', ''),
(88, '0102002813001', 'BARBA  FAUSTO EFRAIN', 'GUACHAPALA', '', '', '', ''),
(89, '0102386935001', 'BARBA CEVALLOS LUIS SALVADOR', '27 DE ABRIL Y CIRCUNVALACION', '', '', '', ''),
(90, '0104284450001', 'BARBECHO  BRAVO DIANA PATRICIA ', 'VIA A SAN MIGUEL 2-56', '', '', '', ''),
(91, '0103779260001', 'BARBECHO BRAVO PEDRO ROGERIO', 'VIA A SAN MIGUEL 2-56', '094580589', '', '', ''),
(92, '0102338555001', 'BARBECHO OCHOA LUIS RAFAEL ', 'FRANCISCO ÑAUTA S/N Y SECTOR LA ASUNCION', '', '', '', ''),
(93, '0603647271001', 'BARRAGAN NARANJO MARIA TRINIDAD', 'SIMON BOLIVAR S/N Y JOSE MARIA MATOVELLE', '', '', '', ''),
(94, '0103582706001', 'BARRAZUETA SAMANIEGO JUAN FERNANDO', 'AYAPUNGO 1-85 Y PASEO DE LOS CAÑARIS', '091849588', '', '', ''),
(95, '0103077442001', 'BARRERA GARNICA BERTA JESUS', 'GARCIA MORENO S/N', '', '', '', ''),
(96, '0103453056001', 'BARRERA GARNICA JANETH PATRICIA', 'LUNTUR DANIEL PALACIOS S/N Y MARISCAL SUCRE', '', '', '', ''),
(97, '1400390702001', 'BARRERA RIERA ANGEL VICENTE', 'CENTRO VIA PRINCIPAL', '099088026', '', '', ''),
(98, '0103234530001', 'BARRERA ZUÑIGA CARLOS VICENTE', 'VIA A PALMAS S/N', '', '', '', ''),
(99, '0103241774001', 'BARRIGA WINHEMBACH ANDREA GUISUPPINE', '3 DE MAYO VIA A LA DOLOROSA S/N', '4187181', '', '', ''),
(100, '1801958834001', 'BARRIONUEVO FREIRE GUIDO WALBERTO', 'CAMINO A MIRAFLORES S/N', '086461001', '', '', ''),
(101, '0104893359001', 'BARROS CONTRERAS BORIS RENATO', 'BARRIAL BLANCO 14-103 Y AV. DE LAS AMERICAS', '2341735', '', '', ''),
(102, '0102899317001', 'BARROS ORELLANA EMMA CATALINA', 'RICARDO DURAN S-N', '', '', '', ''),
(103, '0102860442001', 'BARZALLO ORTIZ ELOY FRANKLIN', 'SIN NOMBRE', '4177670', '', '', ''),
(104, '0105709141001', 'BELTRAN AGUILAR JACKELINE ELIZABETH', 'TURUHUAICO 4-70 Y HUACAS', '4088934', '', '', ''),
(105, '0104784590001', 'BENALCAZAR LOPEZ JAVIER ALEJANDRO', 'AUTOPISTA CUENCA AZOGUES', '084175118', '', '', ''),
(106, '0101901445001', 'BENAVIDES CABRERA CARLOS ANTONIO', 'SIN NOMBRE', '093637204', '', '', ''),
(107, '0904069663001', 'BENAVIDES RODAS MARIANA DE JESUS', 'SIMON BOLIVAR 6-22 Y SUCRE', '', '', '', ''),
(108, '0103724357001', 'BENAVIDES SOLIZ DELFO WILFRIDO', 'AV. DE LAS AMERICAS S/N Y AMAZONAS', '4034585', '', '', ''),
(109, '0101981629001', 'BENAVIDES ZUÑA GLADYS MARISOL', 'BOLIVAR 6-14 Y SUCRE', '', '', '', ''),
(110, '0103146684001', 'BENAVIDES ZUÑA MIGUEL HUMBERTO', 'MARISCAL SUCRE S/N Y INTEROCEANICA', '081816868', '', '', ''),
(111, '0104178496001', 'BERMEO ASTUDILLO CHRISTIAN JONATHAN', 'SIN NOMBRE S-N', '095835710', '', '', ''),
(112, '1706760426001', 'BERMEO DAVILA RICARDO ESTEBAN', 'JUAN JARAMILLO 1-132 Y MANUEL VEGA', '2820196', '', '', ''),
(113, '0104806690001', 'BERMEO MOROCHO JULIO CESAR', 'ALCABALAS 1-50 Y GIL RAMIREZ DAVALOS', '098647973', '', '', ''),
(114, '0104433503001', 'BERMEO MOROCHO LUIS ALFONSO', 'AV GIL RAMIREZ DAVALOS S/N Y LAS LADERAS', '2870280', '', '', ''),
(115, '0101465011001', 'BERMEO SARMIENTO CARMEN HORTENSIA', 'LUNTUR S-N Y DANIEL PALACIOS', '', '', '', ''),
(116, '0103163614001', 'BERMEO ZUMBA JUAN CARLOS', 'PACHACAMA 2-21 Y PASEO DE LOS CAÑARIS', '092048300', '', '', ''),
(117, '0301833281001', 'BERNAL CABRERA LEONARDO ALEXANDER', 'FRAY VICENTE SOLANO 9-167 Y 27 DE FEBRERO', '', '', '', ''),
(118, '0102774304001', 'BERREZUETA PESANTEZ ORFA ELIZABETH', 'AV. LOS CONQUISTADORES S/N Y AV. LOJA', '', '', '', ''),
(119, '1768099570001', 'BOMBEROS DE PAUTE', 'FRANCISCO GONZALEZ S.N Y LUNTUR', '2251032', '', '', ''),
(120, '0103962940001', 'BRAVO ABAD EDITA MARCELA', 'DEL RETORNO 1-51 Y AURELIO AGUILAR', '', '', '', ''),
(121, '0103962957001', 'BRAVO ABAD MARIA FERNANDA', 'MARISCAL SUCRE 16-14 Y MIGUEL VELEZ', '2841982', '', '', ''),
(122, '0101404440001', 'BRAVO CALLE BLANCA LUZMILA', 'VIEJA S/N Y ELIA LIUT', '2816339', '', '', ''),
(123, '0101309896001', 'BRAVO CORONEL CORNELIO RENE ', 'SUCRE 16-14 Y MIGUEL VELEZ', '2841982', '', '', ''),
(124, '0101303725001', 'BRAVO JARA SARA RAQUEL', 'VIEJA 5-49 Y CALLE DEL CHORRO', '2860040', '', '', ''),
(125, '0100080407001', 'BRITO ALVAREZ MIGUEL ROSENDO', 'ARMENILLAS 6-35 Y CIRCUNVALACIÓN', '2826884', '', '', ''),
(126, '0103852455001', 'BUENO SUMBA BLANCA ROCIO', 'Unidad Nacional s/n y Remigio Crespo', '881-636', '', '', ''),
(127, '0101152833001', 'CABRERA AVILA BLANCO CELVIA', 'S/N PAUTE', '', '', '', ''),
(128, '0103146767001', 'CABRERA COBOS JUAN PABLO', 'AV. GONZALEZ SUAREZ 25-89 Y AV. DE LAS AMERICAS', '094679248', '', '', ''),
(129, '0102273166001', 'CABRERA ESPINOZA JHON FREDI', 'YANAHURCO LM-15 Y ANTISANA', '2864315', '', '', ''),
(130, '0915555890001', 'CABRERA MAGALLANES GRACE AMELIA', 'GENERAL ESCANDON S/N Y JOSE ASTUDILLO', '080087521', '', '', ''),
(131, '0103674404001', 'CABRERA MAZA BLANCA LUCRECIA', 'AV. DE LAS AMERICAS S/N', '', '', '', ''),
(132, '0105349799001', 'CABRERA ORELLANA JOSE MIGUEL', 'SIN NOMBRE S/N', '', '', '', ''),
(133, '0105305577001', 'CABRERA PATIÑO JUAN CARLITOS', 'AV. DE LAS AMERICAS 2-91 Y LOS NARANJOS', '340663', '', '', ''),
(134, '0101235562001', 'CABRERA REYES MARIA DEL CARMEN', 'CUMANDA S/N Y MARTIN FIERRO ', '2459224', '', '', ''),
(135, '0104083530001', 'CABRERA YUPANGUI VINICIO SALVADOR', 'CIRCUNVALACIÓN S/N', '', '', '', ''),
(136, '0100401777001', 'CACERES MACANCELA JOSE GUILLERMO', 'BOLIVAR S-N Y SUCRE', '', '', '', ''),
(137, '0101410264001', 'CACERES MACANCELA PIEDAD PASTORA', 'SIMON BOLIVAR 7-23 Y ABDON CALDERON', '', '', '', ''),
(138, '0301597027001', 'CACERES ORTUÑO JULIA VICTORIA', 'VIA A YUMACAY', '088031538', '', '', ''),
(139, '0103538161001', 'CACERES RIVERA GLADYS  RAQUEL', 'LUIS ARIOSTO MUÑOZ S/N Y HUMBERTO VICUÑA', '', '', '', ''),
(140, '0105006860001', 'CACERES YUPANGUI PEDRO FERNANDO', 'SIGLO XX S/N  Y RODRIGUEZ PARRA', '', '', '', ''),
(141, '0102840402001', 'CAGUANA CARRION JOSE FELIX', 'VIA A JEJAR S/N', '', '', '', ''),
(142, '0104619754001', 'CAJAMARCA JUCA JULIO HERIBERTO', '\"GUACHAPALA', '', '', '', ''),
(143, '0104467923001', 'CAJILIMA RIVERA LUZ FLORENCIA', 'JOSE MIGUEL BARZALLO S-N Y SIGLO XX', '', '', '', ''),
(144, '0907495741001', 'CALDAS LOOR LUIS ALFONSO', '110 S/N Y AV. FCO. DE ORELLAN', '4039476', '', '', ''),
(145, '0106376049001', 'CALDERON MARQUINA FRANKLIN EUGENIO', 'AV. INTEROCEANICA S/N Y LUNTUR', '091004964', '', '', ''),
(146, '0300810272001', 'CALLE CALLE ANITA DIOSCELINA', 'GRAN COLOMBIA 3-55 Y TOMAS ORDÓÑEZ', '098689151', '', '', ''),
(147, '0102814555001', 'CALLE CALLE MARCIA DEL ROCIO', 'GRAL. VILLAMIL 2-66 Y EDWIN SACOTO', '', '', '', ''),
(148, '0105425763001', 'CALLE LOJA VICTOR ALEJANDRO', 'VIA A ANDACOCHA S/N', '', '', '', ''),
(149, '1707834394001', 'CALLE MOLINA ANTONIO LIZARDO', 'VIA A BAGUANCHI S-N', '098073301', '', '', ''),
(150, '0105878862001', 'CALLE NOVILLO DIEGO EDMUNDO', 'AV. REMIGIO CRESPO S-N Y EDWIN SACOTO', '2880497', '', '', ''),
(151, '0103899506001', 'CALLE PACHECO SANTIAGO PATRICIO', 'RIO MPALORA 40-210 Y RIO UPANO', '095969012', '', '', ''),
(152, '0701383028001', 'CALLE PUCHA MARCO VINICIO', 'PRINCIPAL 404', '2898155', '', '', ''),
(153, '1714192745001', 'CALLE RAMIREZ FERNANDO VIRGILIO', 'S/N SECTOR ZHAPACAL', '4040782', '', '', ''),
(154, '0104056130001', 'CALLE URGILES ROMULO ENRIQUE', 'DANIEL HERMIDA 1-57 Y AV. DE LAS AMERICAS', '4088308', '', '', ''),
(155, '0104094792001', 'CALLE WILCHES MONICA DEL ROSARIO', 'JUAN JARAMILLO 1-132 Y MANUEL VEGA', '2820196', '', '', ''),
(156, '0102807468001', 'CAMPOS AGUILERA KATTY JACQUELINE', 'CAMINO DEL TEJAR S/N Y RIO AMARILLO', '087646287', '', '', ''),
(157, '0300821972001', 'CAMPOS ORELLANA ANA LUCIA', 'AV. DE LAS AMERICAS 3-129 Y GIGANTONES', '086147634', '', '', ''),
(158, '0102204450001', 'CAMPOS PERTALTA OLGA PIEDAD', 'CUBILAN 1-61 Y GIGANTONES', '', '', '', ''),
(159, '0300710613001', 'CAMPOVERDE ABAD JOSE ALBINO', 'S/N', '2246144', '', '', ''),
(160, '0101463230001', 'CAMPOVERDE AVILA VICTOR GENARO', 'GIL RAMIREZ DAVALOS 4-55 Y FRANCISCO PIZARRO', '', '', '', ''),
(161, '0301744744001', 'CAMPOVERDE CAJAMARCA SILVIA ELIZABETH', 'AV. MAX UHLE S/N Y PUMAPUNGO', '098699602', '', '', ''),
(162, '0300494739001', 'CAMPOVERDE FLORES JULIO CESAR', 'VIA A SAN VICENTE S/N', '', '', '', ''),
(163, '0300054616001', 'CAMPOVERDE FLORES MIGUEL ANGEL', 'GONZALEZ SUAREZ 2-25 Y JOSE JOAQUIN DE OLMENDO', '097127572', '', '', ''),
(164, '0104287099001', 'CAMPOVERDE GARATE LUIS HERNAN ', 'CABOGAN 1-47 Y SILBA', '4087832', '', '', ''),
(165, '0301400412001', 'CAMPOVERDE ORDOÑEZ DIANA PATRICIA', 'PALACOIS BRAVO DE LAS MARGARITAS S/N Y LOS CEDROS', '', '', '', ''),
(166, '0925358046001', 'CAMPOVERDE OROSCO FREDDY NESTOR', 'ESCALERAS 1-48 Y BARRIAL BLANCO', '089843112', '', '', ''),
(167, '0103203196001', 'CAMPOVERDE PESANTEZ LINA ELIZABETH', 'ALFONSO ORDERO 2-66 Y AV. MANUEL J. CALLE', '', '', '', ''),
(168, '0102458403001', 'CAMPOVERDE PESANTEZ MARIA FABIOLA', 'LATINOAMERICA 1-18 Y REMIGIO CRESPO', '2815156', '', '', ''),
(169, '0103399580001', 'CAMPOVERDE PESANTEZ WILLIAN PATRICIO', 'AV. ABRAHAN CALAZACON LOTE 8 Y AV. QUITO', '', '', '', ''),
(170, '0102814811001', 'CAPELO UREÑA PATRICIO JAVIER', 'ARGENTINA S/N Y AMAZONAS', '2881053', '', '', ''),
(171, '1101809372001', 'CARCHI DELGADO ELOY', 'CARAS S/N Y PASEO MILCHICHIG', '090468844', '', '', ''),
(172, '0102301827001', 'CARCHI QUEZADA JUAN OLMEDO', 'S/N Y OBISPO ALBERTO ORDOÑEZ', '086310851', '', '', ''),
(173, '0102482874001', 'CARCHIPULLA BARAHONA CARLOS ESTEBAN', 'JULIO MATOVELLE S/N', '', '', '', ''),
(174, '0102076510001', 'CARCHIPULLA RIVERA MARIA TERESA', 'SIMON BOLIVAR 2-12 Y TRES DE NOVIEMBRE', '', '', '', ''),
(175, '0101154417001', 'CARDENAS  PESANTEZ SANTIAGO', 'MOSCOSO S/N Y ESCUADRON CEDEÑO', '2890439', '', '', ''),
(176, '0101187268001', 'CARDENAS AMAY HUGO RODRIGO', 'AV. DE LAS AMERICAS 10-55 Y ARMENILLAS', '2839691', '', '', ''),
(177, '0102698867001', 'CARDENAS CARDENAS CARLOS GUSTAVO', '10 DE AGOSTO S-N', '099365573', '', '', ''),
(178, '0102355856001', 'CARDENAS RODRIGUEZ JOSE LUIS', 'GUILLERMO MEDINA 2-63 Y FRANCISCO PAREDES', '0999422884', '', '', ''),
(179, '0190336158001', 'CAVIFACOM CIA.LTDA.', 'AV. ESPAÑA 9-11 Y SEVILLA ', '2860359', '', '', ''),
(180, '0103779955001', 'CARPIO AREVALO PAOLO JOSE', 'DEL RETORNO S/N Y DEL PALTAN', '084997128', '', '', ''),
(181, '0103370979001', 'CARPIO ORELLANA MANUEL WILSON', 'AV. GIL RAMIREZ DAVALOS 2-10 Y TURUHUAICO', '4089008', '', '', ''),
(182, '0102122314001', 'CARPIO TENESACA MANUEL RESURRECCIÓN', 'ABELARDO J ANDRADE S-N', '', '', '', ''),
(183, '1707216741001', 'CARRANCO PIEDRA JAIME VICENTE', 'SEGUNDO PASAJE 3-76 Y CIMARRONES', '2900100', '', '', ''),
(184, '0104396635001', 'CARRANCO ZUMBA JAIME DAVID', 'LOS TRIGALES W-372', '091234799', '', '', ''),
(185, '1101952107001', 'CARRION CARRION SERVIO AMADOR', 'AV. DE LAS AMERICAS S/N Y EDUARDO ARIAS', '4095352', '', '', ''),
(186, '1303659047001', 'CARVAJAL MOREIRA SHANDRA MONSERRATE', 'AV. ESPAÑA 1-91 Y FRANCISCO PIZARRO', '2801303', '', '', ''),
(187, '0905453072001', 'CASTRO CHANG BALDOMERO SANTIAGO', 'CESAR BORJA LAVAYEN S/N Y MILAGRO', '091280959', '', '', ''),
(188, '0103619417001', 'CASTRO INTRIAGO CARLOS LENNIN ', 'ESMERALDAS 2-113', '093575155', '', '', ''),
(189, '1706494422001', 'CASTRO TAMARIZ CARLOS ALBERTO', 'AV. ORDOÑEZ LOZA S/N Y DE LA HIGUERILLA', '', '', '', ''),
(190, '0501486260001', 'TIGASI CAJIA SEGUNDO FULGENSIO', 'BARRIAL BLANCO 357 Y ARMENILLAS', '0995394486', '', '', ''),
(191, '0201765609001', 'CAYAMBE GOMEZ JUANA ALEXANDRA', 'JACINTO JIJON 2-44 Y LA REPUBLICA', '', '', '', ''),
(192, '0101037497001', 'CEDILLO NAULA MANUEL LEONIDAS', 'VIA GIRON PASAJE', '085879441', '', '', ''),
(193, '0101812675001', 'CEDILLO ZEA WILSON ARMANDO', 'ARMENILLAS 2-90 Y GIL RAMIREZ DAVALOS', '2862566', '', '', ''),
(194, '0704617513001', 'CELI  CASTRO LUIS HERNAN', 'ARENAL SIN NOMBRE S/N', '', '', '', ''),
(195, '0190411605001', 'BICI CAFE A&G ESCUELA DE CICLISMO GALO TAMAYO', 'MIGUEL CORDERO 4-27 Y DANIEL PALACIOS', '2816174 ', '', '', ''),
(196, '0104836853001', 'CHABLAY INGA PABLO ADRIAN', 'LA NUBE CALLE A S-N', '097840527', '', '', ''),
(197, '0105220453001', 'CHACON LEDESMA MONICA ENRIQUETA', 'VIA A GUARUMALES', '', '', '', ''),
(198, '0100118157001', 'CHALCO PESANTES PEDRO MENELAO', 'CALLE VIEJA 10-98 Y LA CARRETAS', '', '', '', ''),
(199, '0502683212001', 'CHANGOLUISA AMBATO MARCO ANTONIO', 'JULIO JARAMILLO S-N Y BARRIAL BLANCO', '', '', '', ''),
(200, '1001307493001', 'CHAVEZ POZO SANTIAGO MAURICIO', 'RAFAEL DEL VALLE S/N Y AV. 1 DE MAYO', '085569945', '', '', ''),
(201, '0102285400001', 'CHERREZ CARDENAS HOMERO PATRICIO', 'AV. GIL RAMIRES DAVALOS 3-30', '2863272', '', '', ''),
(202, '0101404986001', 'CHICAIZA VEGA VICTOR MANUEL', 'ALONSO DAMASO S/N Y GASSET ORTEGA', '', '', '', ''),
(203, '0105492680001', 'CHIMBO CAJAMARCA CELIO ROLANDO', 'AV. LAS AMERICAS S/N RICARDO DURAN', '085038537', '', '', ''),
(204, '0102883097001', 'CHIQUI LOPEZ MILTON JAVIER ', 'AV. 24 DE MAYO S-N Y PUYO', '', '', '', ''),
(205, '0190344231001', 'CIRKO ENGINEERING FLUIDO CONTROL CIRKOENG CIA.LTDA.', 'TIMOLEON CARRERA S/N Y EZEQUIEL MARQUEZ', '099002616', '', '', ''),
(206, '0102219508001', 'COLLAHUAZO LOJA MANUEL JESUS', 'SIN NOMBRE', '2896667', '', '', ''),
(207, '0190352129001', 'COMITÉ DE DESARROLLO DE LA NIÑEZ Y LA FAMILIA LAS ABEJITAS', 'CHASQUIS S/N Y COJIMIES', '069190457', '', '', ''),
(208, '0190322475001', 'COMPAÑÍA DE TRANSPORTE MIXTO TRANSHUAC CIA.LTDA', 'JOSE VICTOR IZQUIERDO S/N', '', '', '', ''),
(209, '0190324443001', 'COMPAÑÍA DE VOLQUETES TRANSMARGINAL CIA LTDA', 'MARGINAL RIO PAUTE S-N', '', '', '', ''),
(210, '0103310116001', 'CONDO BARRERA KLEVER', 'S/N PAUTE', '', '', '', ''),
(211, '0102904174001', 'CONDO YANZAGUANO MANUEL ALEJANDRO', 'SIN NOMBRE S-N', '', '', '', ''),
(212, '0190381471001', 'CONSORCIO CDOS CARPIO & CARPIO', 'ROMULO MARQUEZ 51 Y DEL INGENIERO', '0961138002', '', '', ''),
(213, '0190381722001', 'CONSORCIO JURICO IMPEGNO', 'ALFONSO CORDERO 3-77 Y MANUEL J. CALLE', '4103769', '', '', ''),
(214, '0190353664001', 'CONSTRUCTORA DIEMAR CIA LTDA', 'LA UNIÓN ALTA S/N Y AV. RICARDO DURAN', '4076358', '', '', ''),
(215, '0101632800001', 'CONTRERAS BRITO MARTHA ISABEL', 'GRAN COLOMBIA  16-95 Y MIGUEL HEREDIA', '2823307', '', '', ''),
(216, '0101650083001', 'CONTRERAS CONTRARAS CESAR OSWALDO', 'JUAN BAUTISTA AGUIRRE 1-79 Y EL OBSERVADOR', '084884882', '', '', ''),
(217, '0190308987001', 'COOPERATIVA DE AHORRO Y CREDITO GUACHAPALA', 'AV. 3 DE NOVIEMBRE S/N Y 9 DE OCTUBRE', '', '', '', ''),
(218, '0190311031001', 'COOPERATIVA DE AHORRO Y CREDITO SOL DE LOS ANDES', 'VELASCO IBARRA S/N Y VIA A HUINTUL', '', '', '', ''),
(219, '0190321061001', 'COOPERATIVA PATRIA CTDA.', 'AV. DE LAS AMERICAS S/N Y AV. REMIGIO CRESPO', '4097607', '', '', ''),
(220, '0101238558001', 'CORDERO ESPINOZA JACINTO EDMUNDO', 'AGUSTIN CUEVA TAMARIZ 1-23 Y AV. 12 DE ABRIL', '2844356', '', '', ''),
(221, '0101328649001', 'CORDERO FARFAN CARLOS EDMUNDO', 'REMIGIO CRESPO S/N Y AV. DE LAS AMERICAS', '084696692', '', '', ''),
(222, '0103100137001', 'CORDERO VIVAR JENNY PATRICIA', 'AV. DE LA AMERICAS S-N Y BOCINA', '', '', '', ''),
(223, '0300064888001', 'CORDOVA CORDOVA LUIS ERNESTO', 'AV. ESPAÑA 10-90 Y ELIA LIUT', '', '', '', ''),
(224, '0102471745001', 'CORDOVA MALDONADO BERTHA DEL CARMEN', 'BENIGNO PALACIOS 1-16 Y AV. 3 DE NOVIEMBRE', '2855162', '', '', ''),
(225, '1400545024001', 'CORDOVA PELAEZ NANNCY ISABEL', 'CAMINO A MISICATA S/N', '4195087', '', '', ''),
(226, '0100137272001', 'CORONEL LANDI RAQUEL MARIA', 'GASPAR SANGURIMA 5-73 Y HERMANO MIGUEL', '2838583', '', '', ''),
(227, '0104072608001', 'CORONEL OJEDA ESTEBAN ISRAEL', 'AV. UNIDAD NACIONAL 4-89 Y ESMERALDAS', '087065574', '', '', ''),
(228, '0101254241001', 'CORONEL PARAMO ABDON ABSALON', 'UNION SOVIETICA S-N Y INGLATERRA', '094356466', '', '', ''),
(229, '0301095642001', 'CORONEL SERVILLA NELSON ELADIO', 'ALTIPLANO S/N Y EPLICACHIMA', '', '', '', ''),
(230, '0105208060001', 'CORONEL YUNGA JUAN PABLO', 'ENSAYANA VIA A MINAS S/N', '2885334', '', '', ''),
(231, '0190167348001', 'CORPORACIÓN ASENDE CIA LTDA', 'PARQUE INDUSTRIAL AV. OCTAVIO CHACON', '2806333', '', '', ''),
(232, '0100679166001', 'CORRAL TAGLE MARIA CRISTINA ELIZABETH', 'DANIEL CORDOVA TORASL S-N Y AV. FRAY VICENTE SOLANO', '2814196', '', '', ''),
(233, '0102239423001', 'CORREA JUMBO MONICA VICTORIA', 'TURUHUICO 2-84 Y AV. GIL RAMIREZ DAVALOS', '4089010', '', '', ''),
(234, '0102221819001', 'CORTEZ CUANCA JORGE ONOFRE', 'GASPAR SANGURIMA 11-17 Y GENERAL TORRES', '2341512', '', '', ''),
(235, '0102238367001', 'COYAGO PIEDRA MANUEL JESUS', 'CALLE VEJA 8-30 Y ARMENILLAS', '', '', '', ''),
(236, '0103749164001', 'COYAGO PIEDRA SEGUNDO ALEJANDRO', 'BARRIAL BLANCO 5-56 Y DEL ARTESANO', '097774269', '', '', ''),
(237, '1702809318001', 'CRESPO MERCHAN MIGUEL BENJAMIN', 'DOLORES VEINTIMILLA 1-125', '2886775', '', '', ''),
(238, '0102564929001', 'CRESPO ROMERO JHON VINICIO', 'MANUEL VILLAVICENCIO S/N Y ARTURO CISNEROS', '099766738', '', '', ''),
(239, '0102186525001', 'CRIOLLO ABRIL TERESITA GABRIELA', 'MENENDEZ Y PELAYO S/N Y AV. 12 DE OCTUBRE', '', '', '', ''),
(240, '0102963766001', 'CRIOLLO ARAUJO RENE PATRICIO', 'AMAZONAS 3-82 Y BAHAMAS', '2885111', '', '', ''),
(241, '0703260166001', 'CRUZ PARRA JOSE MIGUEL', 'GRAN COLOMBIA 21-157 Y UNIDAD NACIONAL', '097037016', '', '', ''),
(242, '1104400906001', 'CUEVA ZAPATA JOSE LUIS', 'PEDRO CARBO S/N Y JUAN LEON MERA', '098859263', '', '', ''),
(243, '0101997104001', 'CUSCO MARIO ALVINO', 'VIA A TIXAN S/N', '41013543', '', '', ''),
(244, '0101031045001', 'CUSCO QUIZHPI RODRIGO VICENTE', 'TURUHUAICO S/N Y AV. DE LAS AMERICAS', '2340100', '', '', ''),
(245, '0301497814001', 'CUZCO LLGUIN MONICA PATRICIA', 'AV. ALEJANDRO LARRIVA S/N Y VIA A GUARUMALES', '', '', '', ''),
(246, '0102420387001', 'DAQUILEMA IZQUIERDO CARLOS BENARDO', 'VIA AL CARMEN DE SININCAY S/N', '2868856', '', '', ''),
(247, '1711713477001', 'DELGADO QUISPE XIMENA ALEXANDRA', 'JUNTO AL ESCUE SU ELIA LIUT S/N Y VIEJA', '2803132', '', '', ''),
(248, '0102518610001', 'DELGADO QUIZHPE ENMA ESTHELA', 'GUAPONDELIG S/N Y JUAN JOSE FLORES', '2867096', '', '', ''),
(249, '0102386539001', 'DELGADO QUIZHPE NARCISA DE JESUS', 'BARRIAL BLANCO S-N Y ESCALERAS', '4089111', '', '', ''),
(250, '1400687909001', 'DIAZ AVILA JAIME FERNANDO', 'EL PAN', '', '', '', ''),
(251, '1723516199001', 'DIAZ HERNANDEZ LAYLA GIONA', 'VIA A OCHOA LEON S/N', '097157413', '', '', ''),
(252, '0990789061001', 'DIPOR S.A', 'VIA LA DOLOROSA', '4077320', '', '', ''),
(253, '0190367517001', 'DIRECTIM CIA.LTDA', 'Av. 12 de Abril 5-84 y Av. Unidad Nacional', '2885334', '', '', ''),
(254, '0190331776001', 'DISTRIBUIDORA DUMAS BERMEO S.A.', 'AV  ESPAÑA 9-42 Y FRANCISCO PIZARRO', ' 2802377', '', '', ''),
(255, '0102098308001', 'DUCHITANGA MERCHA JOSE BENIGNO', 'VIA A OCHOA LEON S/N', '095839949', '', '', ''),
(256, '0101591659001', 'DUMAGUALA LOJA LUIS ALFONSO', 'VIA A SAN BARTOLOME S-N', '2851137', '', '', ''),
(257, '0101951846001', 'DURAN BONILLA WILSON GUSTAVO', 'MALVINAS 4-112 Y UNIDAD NACIONAL', '2815676', '', '', ''),
(258, '0102521994001', 'DURAN GOMEZ PEDRO FERNANDO', 'EDWIN SACOTO S/N Y CALLE DEL BATAN', '', '', '', ''),
(259, '0103323341001', 'DURAN SANCHEZ NILA BEATRIZ', 'DEL RETORNO S/N Y CABOGAN', '', '', '', ''),
(260, '0101324572001', 'DURAZNO MONTESDEOCA VICENTE DE JESUS', 'PIMAMPIRO 1-44 Y CALLE DEL RETORNO', '4089082', '', '', ''),
(261, '0102210572001', 'DURAZNO ORELLANA HERNAN RODRIGO', 'GALTES S-N Y POROTILLOS', '2450260', '', '', ''),
(262, '0104786769001', 'DURAZNO ORTIZ GEOVANNY XAVIER', 'REPUBLICANO S-N Y PRIMICIAS', '083289716', '', '', ''),
(263, '0701492977001', 'APOLO PEÑALOZA NOLBERTO FRANCISCO', 'PEDRO LOPES DE ARGUDO 3-13 Y ARISTOTELES', '089132854', '', '', ''),
(264, '0990018707001', 'ECUAQUIMICA ', 'AV. ESPAÑA 14-09', '2801661', '', '', ''),
(265, '0190378772001', 'ELECTRO MED CIA.LTDA.', 'CALLE VIEJA 10-73 Y ELIA LIUT', '2862993', '', '', ''),
(266, '0190311961001', 'EMPRESA COMERCIALIZADORA DEL AZUAY EN PRODUCTOS DE BELLEZA ECOAPROBE CIA LTDA', 'DEL CABILDO 1-9 Y AV. GONZALES SUAREZ', '24058744', '', '', ''),
(267, '0103317962001', 'ENCALADA BRAVO PABLO DAVID', 'VIA A MAYANCELA  S/N', '0995893708', '', '', ''),
(268, '0103602009001', 'ENCALADA ESPINOZA FREDI VICENTE', 'S/N', '4101364', '', '', ''),
(269, '0103642369001', 'ENCALADA QUEZADA GILDA XIMENA', 'AV. DE LAS AMERICAS S/N Y DON BOSCO', '2814413', '', '', ''),
(270, '0104855440001', 'ENCALADA SAGBAY NANCY DEL CARMEN', 'ROBERTO CRESPO ORDOÑEZ S/N Y EDUARDO ARIAS', '092629230', '', '', ''),
(271, '0703083311001', 'ENCALADA VALAREZO MARIA EUGENIA', 'GRAL. ESCANDON 1-19 Y AV. DE LAS AMERICAS', '', '', '', ''),
(272, '0301270682001', 'ENCALADA VEDUGO MARTHA SUSANA', 'HERMANO MIGUEL 10-82 Y MARISCAL LAMAR', '0983490307', '', '', ''),
(273, '0102484698001', 'ENDERICA CUESTA MANUEL AURELIO', 'FRANCISCO COETO S-N', '4068510', '', '', ''),
(274, '1900332584001', 'ESPARZA CUENCA EDY GERMAN', 'AV. PRINCIPAL S-N', '', '', '', ''),
(275, '0104086491001', 'ESPINOZA CANTOS MARIA FERNANDA', 'DUCHICELA 2-24 Y RIO PAUTE', '', '', '', ''),
(276, '0300180387001', 'ESPINOZA LOYOLA SEGUNDO VICENTE', 'AV. HUAYNA CAPAC 4-19 Y ALFONSO JERVES', '2828339', '', '', ''),
(277, '0190366537001', 'FACIL RENTA CAR FARENCAR CIA.LTDA', 'AV. ESPAÑA 10-90 Y ELIA LIUT', '2800414', '', '', ''),
(278, '0106337769001', 'FAJARDO LALVAY ROMEL FELIPE', 'VIA A GIRON PASAJE S/N', '2275721', '', '', ''),
(279, '0300528890001', 'FALCONI CORDERO VICTO GERARDO', 'BATALLON NUMANCIA 1-28 Y GENRAL MIRES', '2800087', '', '', ''),
(280, '0102895752001', 'FAREZ GARCIA MERCI MARITZA ', 'AV. 1 DE MAYO S/N', '069124693', '', '', ''),
(281, '0102071669001', 'FAREZ MATUTE MARIA ANA EULALIA', 'DEL SIGZAL S/N Y TOMILLOS', '2888547', '', '', ''),
(282, '1102556899001', 'FIERRO BATANCOURTH JOSE MANUEL', 'JOSE VICTOR IZQUIERDO S/N Y ABDON CALDERON', '', '', '', ''),
(283, '0102118130001', 'FIGUEROA SANTOS GALO FERNANDO', 'ESCULTOR VELASCO 1-40 Y DEL ARTESANO', '092619938', '', '', ''),
(284, '1802329894001', 'PEREZ TORRES ANGEL OSWALDO', 'CAMINO A PATAMARCA S/N Y CIMARRONES', '2901262', '', '', ''),
(285, '1102748967001', 'FLORES FLORES LADIA VIOLETA', 'AV. DE LA AMERICAS S/N Y MANUEL VILLAVICENCIO', '', '', '', ''),
(286, '0102812385001', 'FLORES PESANTEZ JUAN FERNANDO', 'SIN NOMBRE S-N', '091003819', '', '', ''),
(287, '0101144483001', 'FLORES TAPIA EDGAR PATRICIO', 'FERNANDO MALO CORDERO', '2459262', '', '', ''),
(288, '0104889779001', 'FLORES TORRES NANCY IVONNE', 'JOSE VICTOR IZQUIERDO S/N', '', '', '', ''),
(289, '0190148920001', 'FRAGANLICOR CIA. LTDA.', 'AV. ORDOÑEZ LAZO S-N Y LAS TEJAS', '', '', '', ''),
(290, '1721479358001', 'FRANCO AGUDELO ESTRELLA', 'ABELARDO J. ANDRADE S/N ', '083917918', '', '', ''),
(291, '0104006085001', 'FUENTES ORELLANA NATALY CELESTINA', 'VIEJA 10-73 Y ELIA LIUT', '093883523', '', '', ''),
(292, '0190157636001', 'FUNDACION ALTERNATIVAS PARA EL DESARROLLO SOCIAL ALDES', 'AV. DE LAS AMERICAS 31-71 Y PASEO 3 DE NOVIEMBRE', '072831244', '', '', ''),
(293, '0190345769001', 'FUNDACION JUVENIL KAREN TATIANA', 'PADRE AGUIRRE Y VEGA MUÑOZ ESQ', '', '', '', ''),
(294, '0190306887001', 'FUNDACION SER ', 'CENTRO MARISCAL SUCRE S/N Y RAMON BORRERO', '2250337', '', '', ''),
(295, '0101959575001', 'GALINDO DUMAS JOSE WILFRIDO', 'CALLE DEL OBRERO 1-37 Y CALLE VIEJA', '097737322', '', '', ''),
(296, '0102800299001', 'GALLEGOS MUÑOZ CRISTIAN ANDRES', 'BARRIAL BLANCO S/N Y ANTONIO NEUMANE', '088208508', '', '', ''),
(297, '0601415995001', 'GALLEGOS OROZCO FAUSTO RAMIRO', 'MANUEL ARTURO CISNEROS S/N Y TARQUINO CORDERO', '087202040', '', '', ''),
(298, '0705301463001', 'GALLO SANCHEZ ANDRES ROBERTO', 'SIMON BOLIVAR S-N Y SUCRE', '', '', '', ''),
(299, '0100721026001', 'GARATE RAMIREZ CARMELA BEATRIZ', 'AV. REMIGIO TAMARIZ 4-120 Y ALFONSO BORRERO', '', '', '', ''),
(300, '0104664529001', 'GARAY CORDOVA JAIME ANTONIO', 'VIA A GUARUMALES MENDEZ', '', '', '', ''),
(301, '0100424431001', 'GARAY MARQUINA MANUEL JESUS', 'VIA A GUARUMALES MENDEZ', '', '', '', ''),
(302, '0102573391001', 'GARCIA ALVEAR PABLO ESTUARDO', 'AV. ABELARDO J. ANDRADE S/N Y LOS CEREZOS', '096425787', '', '', ''),
(303, '0104721527001', 'GARCIA CRESPO JUAN PABLO', 'AV. ESPAÑA 2-110 Y SEBASTIAN DE BENALCAZAR', '', '', '', ''),
(304, '0102286259001', 'GARCIA LEON EDWIN FERNANDO', 'AUTOPISTA CUENCA AZOGUES', '2875353', '', '', ''),
(305, '0300059128001', 'GARCIA VALDEZ ELIAS RICARDO', 'PASEO RIO MACHANGARA S/N Y VIA A PATAMARCA', '', '', '', ''),
(306, '0104861224001', 'GARNICA BARRERA BLANCA MARIBEL', 'VIA A BULAN S/N', '', '', '', ''),
(307, '0104770359001', 'GARNICA JUELA MARCOS ANTONIO', 'S/N', '080360524', '', '', ''),
(308, '0104682885001', 'GARZON BERMEO CARLOS FERNANDO', 'SEVERO MATA S/N', '085337838', '', '', ''),
(309, '0102599321001', 'GAVILANEZ BERMEO SILVIA VICTORIA', 'LAS CARRETAS 1-93 Y CALLE VIEJA', '2800651', '', '', ''),
(310, '0102917846001', 'GLANZMANN SEGOVIA MARIA CRISTINA', 'Hermano  Miguel 8-09 y Sucre', '2 834684', '', '', ''),
(311, '0104087358001', 'GLANZMANN SEGOVIA REINER JACOB', 'EUGENIO ESPEJO  1-182 Y ANTONIO VALLEJO', '', '', '', ''),
(312, '0160000510001', 'GOBIERNO AUTONOMO DESCENTRALIZADO MUNICIPAL DEL CANTON PAUTE', 'ABDON CALDERON 5-01 E IGNACIO CALDERON', '2250310', '', '', ''),
(313, '0160033440001', 'GOBIERNO AUTONOMO DESCENTRALIZADO PARROQUIAL DE SUSUDEL', 'OÑA', '', '', '', ''),
(314, '0301603668001', 'GODOY SANTOS WILLIAM WILFRIDO', 'CHARLES DARWIN 2-85 Y AV. REMIGIO CRESPO', '092145481', '', '', ''),
(315, '0704656248001', 'GOMEZ CANDO JIMMY JAVIER', 'MANUEL CORRAL JAUREGUI S/N Y AV. DE LAS AMERICAS', '', '', '', ''),
(316, '0301442984001', 'GOMEZ CRUZ PATRICIO LEONIDAS', 'PADRE MATOVELLE S/N', '', '', '', ''),
(317, '0106016389001', 'GOMEZ QUICHIMBO LUIS ALBERTO', 'VIA A ANDACOCHA S/N', '', '', '', ''),
(318, '0102758042001', 'GONZALEZ CARDENAS HERIBERTO SALVADOR', 'LA INMACULADA SIN NOMBRE S/N', '476338', '', '', ''),
(319, '1101417754001', 'GONZALEZ JARAMILLO YOLANDA MARIA', 'CAMINO A PATAMARCA S/N', '', '', '', ''),
(320, '0103963575001', 'GONZALEZ SARMIENTO KLEVER SANTIAGO', 'AV. DE LAS AMERICAS S/N ', '', '', '', ''),
(321, '1104114986001', 'GORDILLO QUICHIMBO SORAYA VANESSA', 'MERCEDES QUINDE 2-10 Y CALLE VIEJA', '088965423', '', '', ''),
(322, '0101286235001', 'GORDILLO UZHCA LAURO VICENTE', 'VIA A SININCAY S/N', '', '', '', ''),
(323, '0104081856001', 'GOYES FAREZ IVAN PATRICIO', 'DEL SIGZAL S/N Y TOMILLOS', '', '', '', ''),
(324, '0104590609001', 'GUACHUN PEREZ CARMEN BEATRIZ', 'VIA A TACAPAMBA', '', '', '', ''),
(325, '0103392601001', 'GUACHUN SACA NORMA BEATRIZ', 'VIA A PAUTE S/N', '', '', '', ''),
(326, '0104991757001', 'GUAMAN AGUDO LILIANA ELIZABETH', 'S.N', '090436452', '', '', ''),
(327, '1102882311001', 'GUAMAN GUAMAN LUIS ANTONIO', 'VIA AL VALLE SAN JUAN LOMA S/N', '', '', '', ''),
(328, '0101044220001', 'GUAMAN PINEDA ANGEL RODRIGO', 'LA ASUNCION S/N', '084852859', '', '', ''),
(329, '0104048566001', 'GUAMAN QUIZHPI IVAN ANDRES', 'VIA A BAÑOS S/N', '2400433', '', '', ''),
(330, '0102484185001', 'GUAMAN ZHINGRE MARIA ROSA', 'VIA A SINICHAY S-N', '4082211', '', '', ''),
(331, '0102217718001', 'GUAMANCELA DELGADO BETTY LUCIA', 'LAS CARRETAS 1-59 Y CALLE VIEJA', '098835497', '', '', ''),
(332, '0101245322001', 'GUANANGA GALO', 'ANTONIO BORRERO 15-67', '2828803', '', '', ''),
(333, '0102018496001', 'GUANOQUIZA GUANOQUIZA MANUEL ASUNCION', 'S-N', '', '', '', ''),
(334, '0103365094001', 'GUAÑA CALLE JOSE DANIEL', 'TOMAS ORDOÑEZ 9-18 Y SIMON BOLIVAR', '2844546', '', '', ''),
(335, '0102449030001', 'GUAPISACA VARGAS JORGE LUCIANO', 'JAIME ROLDOS 4-80 Y HUAYNACAPAC', '099888215', '', '', ''),
(336, '0102248721001', 'GUAPIZACA VARGAS RAUL FABIAN', 'VIA A MOLINOPAMBA', '4175304', '', '', ''),
(337, '0301472635001', 'GUARQUILA MORQUECHO JULIA ALEJANDRINA', 'AV. ORDOÑEZ LAZO S/N Y LOS CEREZOS', '083247475', '', '', ''),
(338, '0704702745001', 'GUARTAZACA MONCADA MANUEL LEONARDO', '\"FERNANDO DE ARAGON Y ISABEL LA CATOLICA', '099220699', '', '', ''),
(339, '1400400592001', 'GUAYLLAZACA LOZANO GLORIA SUSANA', 'AV. 12 DE DICIEMBRE S/N', '2770557', '', '', ''),
(340, '0105146955001', 'GUAZHA AGUIRRE VILMA SUSANA', 'COMUNIDAD LA PAZ S/N', '085388387', '', '', ''),
(341, '0102346863001', 'GUERRERO ALVAREZ GEOVANNY SALVADOR', 'DEL ARTESANO 1-99 Y MANUEL PANGOL', '2870259', '', '', ''),
(342, '0103556767001', 'GUERRERO PAEZ ALBERTO ANIBAL', 'LA JARATA S/N Y EL TABLON', '4087975', '', '', ''),
(343, '0302109798001', 'GUILLAS PUIN EDDER HOMERO', 'VIA A BELLA VISTA S/N', '083241020', '', '', ''),
(344, '0300990561001', 'GUILLEN CORDERO JUAN MEDARDO', 'GENERAL ROBLES 1-56 Y VIRACOCHABAMBA', '099421345', '', '', ''),
(345, '0103968756001', 'GUTAMA CHUNIR NESTOR RAUL', 'VIA A NARANJAL S-N', '', '', '', ''),
(346, '0103948550001', 'GUZMAN GUZMAN WILMER JHOVANY', 'AV. ESPAÑA 9-89 Y SEVILLA', '087236203', '', '', ''),
(347, '0500145586001', 'HEREDIA SEGUNDO JUAN PABLO', 'LEOPOLDO DAVILA S/N Y GABRIEL VALDIVIEZO', '2854412', '', '', ''),
(348, '0104184825001', 'HERRERA GALINDO FREDDY RUBEN', 'MUTUALIS AZUAY PLUTARCO S/N', '2857863', '', '', ''),
(349, '0104067129001', 'HOYOS CARDENAS MONICA ELIZABETH', 'OCTAVIO DIAZ S/N', '', '', '', ''),
(350, '0100747732001', 'HUIRACOCHA VALLADARES JOSE LUIS', 'VIEJA S/N Y ALFONSO VASQUEZ', '2867351', '', '', ''),
(351, '0102238037001', 'HURTADO BRAVO KLEBER ELIAS', 'HUACAS S/N Y SILBAN', '093129791', '', '', ''),
(352, '0102494069001', 'ICAZA SAMANIEGO MAURICIO LIZANDRO', 'GENERAL JOSE DE SAN MARTIN S/N', '086506070', '', '', ''),
(353, '0904837531001', 'IDEAL GAS', 'AV. ESPAÑA 17-18', '2862138', '', '', ''),
(354, '0102208964001', 'IDROVO JARAMILLO FERNANDO JAVIER', 'VIEJA 9-21 Y ARMENILLSA', '095290905', '', '', ''),
(355, '0100033240001', 'IDROVO PESANTEZ RENE ARQUIMIDES', 'EL TABLON ', '4086695', '', '', ''),
(356, '0105223184001', 'ILLESCAS PAUTE MARCO EDGAR', 'DANIEL TOTAL S/N Y CAMINO A RACAR', '099089062', '', '', ''),
(357, '0190336107001', 'IMPORTACION Y DISTRIBUCION CENTRAL DE MATERIALES DE CONSTRUCCION IMDISCEMCO CIA LTDA', 'AV. YANAHURCO LM-15 Y ANTISANA', '2864315', '', '', ''),
(358, '0190376427001', 'IMPORTADORA CAJAMARCA MEDINA ICM CIA LTDA', 'MODESTO LARREA S/N', '092318911', '', '', ''),
(359, '0103902110001', 'INGA AGUAYZA VICTOR XAVIER', 'AV. DE LAS AMERICAS S/N Y LUIS ALBERTO VALENCIA', '092178143', '', '', ''),
(360, '0104533963001', 'INGA ROCANO JULIA VIRGINIA', 'VIA A PUCALOMA S/N', '097149059', '', '', ''),
(361, '0190167658001', 'INSTITUTO EDUCATIVO BILINGÜE HOGAR Y ESCUELA INEBHYESC CIA. LTDA', 'AV. 24 DE MAYO 19-80 Y ACHUPALLAS', '4098410', '', '', ''),
(362, '0190167992001', 'INTERBORO TRANSPORT S.A.', 'AV. GIL RAMIREZ DAVALOS 5-32 Y ARMENILLAS', '2862111', '', '', ''),
(363, '0190348695001', 'INTERIMPEX ', 'AV. ESPAÑA 9-11 Y CASTELLANA', '2860359', '', '', ''),
(364, '0105057269001', 'GONZALEZ DELGADO FABRICIO ALFONSO', ' Armenillas 3-34 y Calle Vieja', '2 864848', '', '', ''),
(365, '0790151879001', 'INTERSERVISE C. LTDA', 'FEDERICO GUERRERO 1-081 Y PIO BRAVO', '', '', '', ''),
(366, '0103472445001', 'IÑIGUEZ ALVAREZ JOSE RAUL', 'JUAN MONTALVO 10-65 Y MARISCAL Lamr', '099661549', '', '', ''),
(367, '0101233807001', 'JACHERO ABRIL PROSPERO AGUSTIN', 'MERCEDES QUINDE 1-15 Y PRIMERA', '2860310', '', '', ''),
(368, '0102513660001', 'JACHERO CISNEROS CARLOS ANDRIAN', 'MERCEDES QUINDE 1-15 Y CALLE VIEJA', '2860309', '', '', ''),
(369, '0102490067001', 'JACHERO CISNEROS MIGUEL AGUSTIN', 'ABELARDO J. ANDRADE S/N ', '2860309', '', '', ''),
(370, '0101139111001', 'JAIME SIAVICHAY', 'CALLE VIEJA 4-35 Y CABOGAN', '4087808', '', '', ''),
(371, '0101653533001', 'JARA FREIRE JANNET YOLANDA', 'TURUHUAICO 2-46 Y GIL RAMIREZ DAVALOS', '4089022', '', '', ''),
(372, '0104176235001', 'JARA MOLINA ANGELITA GUILLERMINA', 'SIMON BOLIVAR S/N Y SUCRE', '', '', '', ''),
(373, '1400729750001', 'JARA SALINAS JESSICA MARIUXI', 'VEINTIOCHO DE MAYO S/N', '', '', '', ''),
(374, '0101951895001', 'JARAMILLO ARIAS DIEGO FABRICIO', 'ISAURO RODRIGUEZ S/N', '2882912', '', '', ''),
(375, '0102975380001', 'JARRO INGA RUBEN AUGUSTO', 'AV. DE LAS AMERICA S/N Y BELICE', '2340949', '', '', ''),
(376, '1711707164001', 'JARRO ZUNIGA JOSE MANUEL', 'CIRCUNVALACIÓN S/N Y LUNTUR', '091004964', '', '', ''),
(377, '0190368785001', 'JASOFT SOLUCIONES EMPRESARIALES CIA.LTDA.', 'ALFONSO MORENO MORA 5-12 Y CESAR DAVILA', '092818953', '', '', ''),
(378, '0102321502001', 'JAYA MERIZALDE MARTHA MARIBEL', 'ANTONIO MACHADO RUIZ 2-86 Y MARIANO VEINTIMILLA', '2341648', '', '', ''),
(379, '0100974625001', 'JIMBO GUNCAY ROMAN RODRIGO', 'FRANCISCO COETO S-N Y CORONEL MONSALVE', '4068080', '', '', ''),
(380, '0101863934001', 'JUCA ASTUDILLO MARIA PIEDAD', 'AV. 3 DE NOVIEMBRE S/N  ', '092398514', '', '', ''),
(381, '0101271294001', 'JUCA GUARQUILA LUIS ANTONIO', 'ALFONSO MORENO MORA 6-36 Y RICARDO MUÑOZ', '', '', '', ''),
(382, '0104031075001', 'JUCA RODRIGUEZ JUAN PATRICIO', 'ALFONSO MORENO MORA 5-12 Y CESAR DAVILA', '', '', '', ''),
(383, '0104022389001', 'JUCA VILLALTA MARIA DOLORES', 'DEL RETORNO S/N ', '093015101', '', '', ''),
(384, '0102345089001', 'JUELA CUESTA EDGAR ALEJANDRO', 'MALVINAS MIRAFLORES S-N', '0985898083', '', '', ''),
(385, '0105607105001', 'JUELA FAJARDO RAFAEL SEVERO', 'MUÑOR VERNAZA 1-58 Y TOMAS ORDOÑEZ ', '097589961', '', '', ''),
(386, '0160041700001', 'JUNTA ADMINISTRADORA DE AGUA POTABLE Y ALCANTARILLADO DE  JIMA', 'IVAN PEÑAFIEL S-N Y BENIGNO TORRES', '418309', '', '', ''),
(387, '0704838242001', 'KAROL CHARLES BROSCH', 'RIO UPANO 4-71 Y HURTADO DE MENDOZA', '', '', '', ''),
(388, '0104652698001', 'LANDI BRITO MILTON DUVAL', 'VIA A PAUTE S/N', '', '', '', ''),
(389, '0101292274001', 'LANDY GUAMAN RUBEN ALFREDO', 'FRANCISCO ESTELLA CARRIO 3-30 Y AV. 10 DE AGOSTO', '099956534', '', '', ''),
(390, '0300398005001', 'LARA MUÑOZ ANGEL BOLIVAR', 'BENEDICTO XV  1-64 Y LEON XIII', '2830196', '', '', ''),
(391, '0300224839001', 'LARA MUÑOZ IVAN EDMUNDO', 'RIVERA Y SUCRE', '', '', '', ''),
(392, '0104550439001', 'LARGO ORDOÑEZ CARLOS BENITO', 'S/N', '', '', '', ''),
(393, '0101184968001', 'LAZO FAJARDO MARIA ROSARIO', 'COMBATE DE SABUM 2-60', '', '', '', ''),
(394, '1708253354001', 'LAZO GUILLERMO JUAN MARTIN', 'CIRCUNVALACION S/N Y JULIO MARIA MATOVELLE', '', '', '', ''),
(395, '0190378152001', 'LAZO LAZO & SANTACRUZ CIA.LTDA', 'AV. 12 DE ABRIL 6,139 Y FLOREANA', '093629990', '', '', ''),
(396, '0201302866001', 'LEDESMA POZO CLARA MARLENE', 'JUNIN 203 Y PANAMA', '091313255', '', '', ''),
(397, '0101540060001', 'LEON CONTRERAS VICTOR MANUEL', 'DESCARTES 2-26 Y HUMBOLT', '093241056', '', '', ''),
(398, '0105422349001', 'LEON ESCANDON WILMER ALFREDO', 'VIA A PADRE HURCO S/N', '', '', '', ''),
(399, '0102945425001', 'LEON GUACHUN CARLOS RODRIGO', 'GUILLERMO GARZON S/N Y TURUHUAICO', '2340160', '', '', ''),
(400, '0102058617001', 'LEON GUSTAVO EDUARDO', 'DUCHICELA S/N', '088838377', '', '', ''),
(401, '0100932581001', 'LEON LANDI MARIO RODRIGO', 'ARTESANO 3-33 Y BARRIAL BLANCO', '2805943', '', '', ''),
(402, '0102559754001', 'LEON LEON JAIME OSWALDO', 'DE LA BOCINA 1-05 Y AV. DE LAS AMERICAS', '092226200', '', '', ''),
(403, '0101068906001', 'LEON ORTIZ CARLOS RODOLFO', 'VIA A PAUTE MENDEZ S-N', '', '', '', ''),
(404, '0102276623001', 'LEON PESANTEZ ADRIANA DEL PILAR', 'DEL OBRERO 5-25 Y ARMENILLAS', '2868565', '', '', ''),
(405, '0102535127001', 'LEON PESANTEZ MARIA FERNANDA', 'DIEGO DONOSO 26 Y PASAJE UNO', '4088171', '', '', ''),
(406, '0103818241001', 'LEON PINOS NIXON SILBERIO', 'EL ORO 3-56 Y REMIGIO CRESPO TORAL', '4091720', '', '', ''),
(407, '0102752508001', 'LEON RIVERA REMIGIO LIBERTO', 'S/N ', '089300286', '', '', ''),
(408, '0102526068001', 'LEON VASQUEZ KATTY XIMENA', 'HERNAN CORDERO CRESPO 2-69 Y VICTOR AGUILAR', '2875308', '', '', ''),
(409, '0104821491001', 'LIMA CASTRO DIANA ELIZABETH', 'CENTRAL S/N', '2855180', '', '', ''),
(410, '0105629026001', 'LLERENA PIZARRO OMAR ROSENDO', 'RIO PARANA S/N Y RIO MISSISIPI', '4076636', '', '', ''),
(411, '0300527546001', 'LLIGUIN GUALPA MANUEL IGNACIO', 'SIN NOMBRE S/N', '3011886', '', '', ''),
(412, '0902238781001', 'LLIVISACA ORELLANA JORGE ALIPIO', 'AV. ESPAÑA 10-93 Y FRANCISCO PIZARRO', '2870573', '', '', ''),
(413, '0102888211001', 'LLIVISUPA MALDONADO JHOANA PATRICIA', 'BUERAN 2-36 Y MACHU PICHU', '2803652', '', '', ''),
(414, '0103556189001', 'LOARTE ANGUINSACA HOLGER  PATRICIO', 'S/N', '085230057', '', '', ''),
(415, '0103093761001', 'LOJA CAJAS JORGE OSWALDO', 'CABOGAN 2-146 Y SILBAN', '4087209', '', '', ''),
(416, '0102770401001', 'LOJA LOJA NOLVERTO FAVIAN', 'AV. GONZALEZ SUAREZ 8-63 Y JUAN DE VELASCO ', '', '', '', ''),
(417, '0301803128001', 'LOJANO MOCHA JAIME RODRIGO', 'VIA A HUIZHIL S/N', '', '', '', ''),
(418, '0103981528001', 'LOPEZ CORDOVA IRMA MARIBEL', 'EL PAN', '', '', '', ''),
(419, '0908108236001', 'LOPEZ INFANTE JUAN CARLOS', 'PAUTE', '', '', '', ''),
(420, '0103409280001', 'LOPEZ MALDONADO ANDREA SOLEDAD', 'LOS CIPRECES 1-61 Y AVENIDA ORDOÑEZ LAZO', '4075773', '', '', ''),
(421, '0301335592001', 'LOPEZ SIGUENCIA FAUSTO HOMERO', 'CHARCAY S/N ', '0987534097', '', '', ''),
(422, '0101731867001', 'LOPEZ ULLAURI ESTUARDO RICARDO', 'VIA A OHOA LEON S/N', '', '', '', ''),
(423, '0103188181001', 'LOPEZ VILLAVICENCIO FREDDY BOLIVAR', 'CALLE DEL RETORNO S/N Y CONQUISTADORES', '092057796', '', '', ''),
(424, '0100327949001', 'LOZANO BRAVO JUAN VICENTE', 'CAJAS S/N Y PAN DE AZUCAR', '2864968', '', '', ''),
(425, '0102374733001', 'LOZANO REINOSO NANCI MARLENE', 'AV. JAIME ROLDOS AGUILERA S/N', '2864766', '', '', ''),
(426, '0102347382001', 'LOZANO REINOSO OLGA GUILLEMINA', 'CALLE VIEJA 11-73 Y ELIA LIUT', '2864968', '', '', ''),
(427, '0102370210001', 'LOZANO REINOSO SAUL VINICIO', 'CALLE VIEJA 11-74 Y ELIA LIUT', '2864766', '', '', ''),
(428, '1400501738001', 'LOZANO SALAS ANGEL OSWALDO', 'AV. DOCE DE DICIEMBRE S/N', '', '', '', ''),
(429, '1400146419001', 'LUCERO ONCE MARIA ANGELITA', '28 DE MAYO S/N Y SIMON BOLIVAR', '', '', '', ''),
(430, '0100013853001', 'LUZURRIAGA JUELA ALICIA LEONOR', 'CALLE DEL OBRERO 2-90 Y ESCALERAS', '2340128', '', '', ''),
(431, '0104821681001', 'MACAO CARDENAS DARIO SEGUNDO', 'VIA A MACAS', '', '', '', ''),
(432, '0700620396001', 'MACHADO VASQUEZ SEGUNDO RODOLFO ', 'BATALLON VENCEDORES 2-1 Y BATALLON CARAQUE', '', '', '', ''),
(433, '0106987100001', 'MACKARNESS SUSAN ELIZABETH', 'S/N', '', '', '', ''),
(434, '0300817699001', 'MAILLAZHUNGO GUASCO SEGUNDO LUIS', 'S-N', '087667333', '', '', ''),
(435, '0100593474001', 'MALDONADO GALLEGOS VICTOR POMPILIO', 'AV. 24 DE MAYO S/N ', '4097660', '', '', ''),
(436, '0907411581001', 'MALDONADO MERCHAN LUIS ALBERTO', 'SOLAR 14', '086954897', '', '', ''),
(437, '0909240947001', 'MALDONADO MERCHAN ROSA AMERICA', 'CARLOS ARIZAGA VEGA S-N Y FRANXISCO CISNEROS', '2855061', '', '', ''),
(438, '0301927810001', 'MALDONADO VILLAVICENCIO GARDO PATRICIO', 'AV. LOJA 2-373', '', '', '', ''),
(439, '0701164196001', 'MALLA PATIÑO SAUL', 'SIN NOMBRE S-N', '0987785090', '', '', ''),
(440, '0103299525001', 'MALLA ZHUNIO FREDDY MATEO', 'AMAZONAS S/N Y TACADEL', '', '', '', ''),
(441, '0103388781001', 'MAÑO ZHAGUI MARCELINO BENITO', 'S/N', '2370580', '', '', ''),
(442, '0103539169001', 'MARCA CONDO CARLOS GIOVANNY', 'INTEROCEANICA S/N', '', '', '', ''),
(443, '0103398855001', 'MARCA LLIVICHUZHCA JOSE HUMBERTO', 'OBISTO MIGUEL LEON 4-66 MARIANO VEINTIMILLA', '094802196', '', '', ''),
(444, '0102051612001', 'MARIN FLORES WILLIAN PATRICIO', 'VIA A RACAR S-N', '099911571', '', '', ''),
(445, '1400594410001', 'MARIN VALLEJO LUZ MARISOL', 'CABOGAN 2-146 Y SILBAN', '4087209', '', '', ''),
(446, '1400402606001', 'MARIN VALLEJO MARIA ELISA', 'CABOGAN 1-47 Y SILBA', '4087217', '', '', ''),
(447, '0103411435001', 'MARIN VASQUEZ RONALD ERNESTO', 'PANAMERICANA NORTE S/N Y AV. GONZALEZ SUAREZ', '084885519', '', '', ''),
(448, '0190368920001', 'MARKETPRINT S.A.', 'GIL RAMIREZ DAVALOS 5-32 Y ARMENILLAS', '2862111', '', '', ''),
(449, '0105287122001', 'MARQUINA CASTILLO JOHNNY FERNANDO', '\"084973732', '', '', '', ''),
(450, '0100951524001', 'MARTINEZ AREVALO LUCIA FABIOLA', 'AV. PAUCARBAMBA 5-50 Y RAFAEL TORRES', '', '', '', ''),
(451, '0105164743001', 'MARTINEZ CORONEL MARIA SANDRA', 'GIL RAMIREZ DAVALOS S/N Y TURUHUICO', '2341005', '', '', ''),
(452, '0106673973001', 'MARTINEZ GARCIA CARIDAD', 'MANUEL ARTEAGA 1-248 Y TOMAS DE HERES', '095763555', '', '', ''),
(453, '0102747326001', 'MATUTE AREVALO ROSA MARIA', '5 DE FEBRERO 4-96 Y TRES DE NOVIEMBRE', '', '', '', ''),
(454, '0104462445001', 'MAURA GUACHICHULCA MARIA AUGUSTA', 'CALLE VIEJA 3-17 Y CABOGAN', '091291325', '', '', ''),
(455, '0102809944001', 'MAYANCELA GARCIA MARIA ANGELITA', 'AV. ESPAÑA 10-90 Y ELIA LIUT', '2800414', '', '', ''),
(456, '0301478178001', 'MAYLLAZHUNGO GUASCO JOSE MIGUEL', 'S/N SUSCAL', '080537214', '', '', ''),
(457, '0102014941001', 'MEJIA FAREZ LUIS ROGRIGO', 'HURTADO DE MENDOZA S/N Y SARA URCO', '4047665', '', '', ''),
(458, '0102643335001', 'MEJIA IÑIGUEZ SILVIA KATIUSCA', 'DEL BATAN 5-110 Y ESMERALDAS', '2811470', '', '', ''),
(459, '0101734929001', 'MEJIA SANCHEZ JOSE HUMBERTO', 'CARLOS ARIZAGA VEGA S/N', '', '', '', ''),
(460, '0102681269001', 'MEJIA VASQuEZ CLAUDIO RODRIGO', 'BALZAY BAJO S-N', '', '', '', ''),
(461, '0100412691001', 'MEJIA VILLAVICENCIO JOSE ROSENDO', 'TURUHUAICO 2-82 Y GIL RAMIREZ DAVALOS', '2800361', '', '', ''),
(462, '0101389336001', 'MENDEZ AVILA JUAN GUALBERTO', 'CANAL DE AGUA S/N', '084020927', '', '', ''),
(463, '0103878757001', 'MENDEZ BARBECHO NANCY ALEXANDRA', 'SIN NOMBRE S/N Y TURUHUAYCO', '2816376', '', '', ''),
(464, '0103431003001', 'MENDEZ BRAVO JOSE ELIAS ', 'ABELARDO J. ANDRADE 4-84', '', '', '', ''),
(465, '0104646930001', 'MENDEZ BRITO XAVIER GUSTAVO', 'GENERAL ARTIGAS 5-58 Y JORGE ISAAC', '084035311', '', '', '');
INSERT INTO `PERSONA` (`PER_ID`, `PER_CEDULA`, `PER_NOMBRE`, `PER_DIRECCION`, `PER_TELEFONO`, `PER_CELULAR`, `PER_CORREO`, `PER_SEXO`) VALUES
(466, '0101781250001', 'MENDEZ ERRAEZ DIGNA DE JESUS', 'VIA A LOJA', '', '', '', ''),
(467, '0100080670001', 'MENDEZ GUAMAN ZOILA ROSA', 'AV. ESPAÑA 9-42 Y FRANCISCO PIZARRO', '2800410', '', '', ''),
(468, '0102451564001', 'MENDEZ MENDEZ FREDDY RUBEN', 'GUARIVINA', '4024844', '', '', ''),
(469, '0102864329001', 'MENDEZ MENDEZ WILLIAM SANTIAGO', 'CAMINO GUSHO S/N', '', '', '', ''),
(470, '0105120349001', 'MENDOZA ALVEAR ANA LUCIA', 'GARCIA MORENO S/N Y JULIO MARIA MATOVELLE', '', '', '', ''),
(471, '0104777933001', 'MENDOZA ALVEAR GLENDA PATRICIA', 'GABRIEL GARCIA MORENO S/N Y JULIO MA.MATOVELLE', '', '', '', ''),
(472, '1306674510001', 'MENDOZA HOLGUIN LARENA ANNABELL', 'MANUEL MARIA PALACIOS 1-13 Y AV. REMIGIO CRESPO', '', '', '', ''),
(473, '0103348280001', 'MENDOZA PAUTA CARMEN JANETH', 'SITIO SON JAVIER', '090123999', '', '', ''),
(474, '1312309691001', 'MERA PINARGOTE FANNY MARGOT', 'VIA A GIRON PASAJE S/N', '', '', '', ''),
(475, '0103198198001', 'MERCHAN CARPIO SANDRA ELIZABETH', 'MARIANO CUEVA 4-10 Y VARGAS MACHUCA', '085534478', '', '', ''),
(476, '0914533906001', 'MERCHAN CEDILLO ROLENDIO ELADIO', 'JUAN DE SENIERGUES S/N Y RICARDO DURAN', '091449355', '', '', ''),
(477, '0104286034001', 'MERCHAN JADAN FREDY SANTIAGO', 'CALLE VIEJA 6-13 Y EL CHORRO', '2801383', '', '', ''),
(478, '0301188470001', 'MINCHALA CAMPOVERDE GALO ROMAN', 'AGUSTIN LANDIVAR S/N Y AV. 10 DE AGOSTO', '4097761', '', '', ''),
(479, '0106480221001', 'MIYER SNEYDER MENDEZ MONTIEL', 'HERMANO MIGUEL 7-16 Y PRESIDENTE CORDOVA', '2820673', '', '', ''),
(480, '0102191343001', 'MOGROVEJO CAMPOVERDE MONICA MARGARITA', 'BATALLON NUMANCIA 3-46 Y GENERAL MIRES', '084951131', '', '', ''),
(481, '0102269255001', 'MOGROVEJO CAMPOVERDE NANCY MARIANITA', 'BARRIAL BLANCO S/N Y PADRE MORENO', '2869236', '', '', ''),
(482, '0104125620001', 'MOGROVEJO PEÑALOZA JUAN CARLOS', 'BENIGNO MALO 6-37', '090886250', '', '', ''),
(483, '1400279137001', 'MOLINA CABRERA FREDY GONZALO', 'VEINTE Y OCHO DE MAYO S/N Y AV. DEL EJERCITO', '093061821', '', '', ''),
(484, '0103922047001', 'MOLINA MARTINEZ FLAVIO HARUP', 'VIA A NAZON S/N', '2802929', '', '', ''),
(485, '0101363687001', 'MOLINA MOSCOSO ELSA BEATRIZ', 'PANAMERICANA NORTE S/N Y LONDRES', '4035131', '', '', ''),
(486, '0104178009001', 'MOLINA MURILLO YADIRA DEL CARMEN', 'AMAZANOS 4-75 Y AV. DE LAS AMERICAS', '', '', '', ''),
(487, '0300907151001', 'MOLINA NIETO VICENTE HERNAN', 'CALLE DEL RETORNO S/N', '', '', '', ''),
(488, '0104784988001', 'MOLINA PINTADO HIPATIA SUE', 'JOSE MARIA ORMAZA 1-59 Y FRANCISCO CALDERON', '2820805', '', '', ''),
(489, '0102145935001', 'MOLINA ROBLES IVAN PATRICIO ', 'S/N', '2897765', '', '', ''),
(490, '0301233870001', 'MONTENEGRO CANTOS JACSON ALFREDO', 'FERROVIARIA LA PLAYA', '', '', '', ''),
(491, '0101727733001', 'MONTENEGRO VALVERDE ANGEL ALBERTO', 'GENERAL CORDOVA 1-27 Y CALLE 4', '2802384', '', '', ''),
(492, '0103932489001', 'MONTESDEOCA CABRERA JOSE LUIS', 'DANIEL PALACIOS S/N Y MIGUEL CORDERO', '074101049', '', '', ''),
(493, '0102165768001', 'MONTESDEOCA VERA MARGARITA BEATRIZ', 'CALLE VIEJA 11-41 Y ELIA LIUT', '2340054', '', '', ''),
(494, '1802518553001', 'MOPOSITA GUAMAN WILSON EDUARDO', 'PANAMERICANA S/N', '', '', '', ''),
(495, '0901545996001', 'MORA ESTRADA ALBERTO VICENTE', 'SILBAN 2-57 Y CABOGAN', '099604409', '', '', ''),
(496, '0105278261001', 'MORA ÑAUTA MARIA FERNANDA', 'VIA A PATAMARCA S/N Y PALMIRA ', '0986092367', '', '', ''),
(497, '0102923687001', 'MORA PINEDA JORGE GUSTAVO', 'ABDON CALDERON S-N', '0986442468', '', '', ''),
(498, '0102568565001', 'MORA RODRIGUEZ MARIA NIEVES', 'URUGUAY S/N Y COLOMBIA', '', '', '', ''),
(499, '0104407317001', 'MORALES BUSTAMANTE ANGEL EUGENIO', 'VIEJA 3-17 Y CABOGAN', '', '', '', ''),
(500, '1002731527001', 'MORALES GUEVARA JESICA KARINA', 'VIA A RICAURTE', '098946342', '', '', ''),
(501, '0103386124001', 'MORALES YUQUI LILIA LEONOR', 'DEL RETORNO S/N Y ENRIQUE ESPIN', '2340325', '', '', ''),
(502, '0400915559001', 'MORAN GUERRERO JHIMY RAUL', 'NICANOR COBOS S/N Y GENERAL ESCANDON', '091352314', '', '', ''),
(503, '0190369013001', 'MORE BENGOCHEA JESUS', 'AUTACHI DUCHICELA S/N Y AV. GONZALES SUAREZ', '', '', '', ''),
(504, '0105544589001', 'MOROCHO ARIAS MAYRA DANIELA', 'AMAZONAS S/N Y LLACUCHIR', '088941759 ', '', '', ''),
(505, '0102235033001', 'MOROCHO BUENO MANUEL JESUS', 'VEGA MUÑOZ S/N Y TORRES', '2266402', '', '', ''),
(506, '0301711313001', 'MOROCHO LLIGUICOTA MERI SUSANA', 'S/N', '', '', '', ''),
(507, '0104997663001', 'MOROCHO LLIGUICOTA MONICA CRISTINA', 'VIA A GUARUMALES MENDEZ', '', '', '', ''),
(508, '0103061990001', 'MOROCHO MOROCHO LAURA MANUELA', 'MARISCAL LAMAR 8-17 Y LUIS CORDERO', '091072038', '', '', ''),
(509, '0102998218001', 'MOROCHO WHAZIMA DIEGO AURELIO', 'LA UNIÓN ALTA S/N ', '4076358', '', '', ''),
(510, '0100910496001', 'MOSCOSO NARVAEZ VICTOR GERARDO', 'ENTRADA A BARABON CHICO', '4177084', '', '', ''),
(511, '0102495108001', 'MOSCOSO PINEDA MIGUEL ESTEBAN', 'UNION SOVIETICA S/N Y PANAMERICANA NORTE', '', '', '', ''),
(512, '0103437802001', 'MOSQUERA AMBROSI BENJAMIN AMADO', 'FRAY VICENTE SOLANO 24-202', '', '', '', ''),
(513, '0160002480001', 'GAD MUNICIPAL DE GUACHAPALA ', 'SIXTO DURAN BALLEN Y 3 DE NOVIEMBRE', '2284196', '', '', ''),
(514, '0103660809001', 'MUÑOZ BRITO MARY LUZ', 'AV ESPAÑA S/N Y GIL RAMIREZ DAVALOS', '22860284', '', '', ''),
(515, '0301397303001', 'NARANJO MONTERO CARLOS XAVIER', 'GASPAR SANGURIMA 15-23 Y CORONEL TALBOT', '087720974', '', '', ''),
(516, '0603009200001', 'NARANJO NARANJO MARIA OLIVA', 'BERLIN 26 Y PARIS', '4175057', '', '', ''),
(517, '0100747971001', 'NARVAEZ AVILES IPOLO MESIAS', 'SIN NOMBRE S-N', '085935164', '', '', ''),
(518, '0101016160001', 'NARVAEZ AVILES LUIS LINO', 'BALZAY BAJO S-N', '2853027', '', '', ''),
(519, '0105644074001', 'NARVAEZ DURAN PEDRO IVAN', 'NUEVE DE OCTUBRE S/N Y CINCO ESQUINAS', '085791366', '', '', ''),
(520, '0102063252001', 'NARVAEZ RIVERA EDGAR EDUARDO', 'UNIDAD NACIONAL 4-92 Y CUBA', '2812201', '', '', ''),
(521, '0100589647001', 'NARVAREZ OCHOA GALO EGBERTO', 'ATAHUALPA S/N', '2808353', '', '', ''),
(522, '0302012067001', 'NASPUD SACOTO MARIA ALEXANDRA', 'PADRE HURCO S/N', '', '', '', ''),
(523, '0190339610001', 'NEWTIRE S.A.', 'CARLOS TOSI S/N Y SEGUNDA TRANSVERSAL', '2805804', '', '', ''),
(524, '0703859637001', 'NIETO ORELLANA CHRISTIAN RICARDO', 'FRANCISCO DE QUEVEDO', '087417324', '', '', ''),
(525, '0300882883001', 'NIVELO TENESACA JULIO ANIBAL/FERRETERIA HURTADO DE MENDOZA', 'AV. HURTADO DE MENDOZA 2-114  Y PAN DE AZUCAR', '2868219', '', '', ''),
(526, '0102185626001', 'OCHOA VERA NILA JENNY', 'AV. DE LAS AMERICAS S/N Y EDUARDO ARIAS', '', '', '', ''),
(527, '0103093746001', 'OLEAS PESANTEZ ANDRES SANTIAGO', 'ESCULTOR VELASCO 1-10 Y MERCEDES QUINDE', '2801977', '', '', ''),
(528, '1400777833001', 'ONCE BERMEO NANCY ANABEL', 'SIN AV. SIGLO XX S/N Y RODRIGUEZ PARRA', '', '', '', ''),
(529, '0101573517001', 'ONCE PEREZ JULIA ERNESTINA', 'VIA A CUENCA S-N', '2171430', '', '', ''),
(530, '0101897254001', 'ONCE ZHAÑAY JAIME CESAR', 'AV. DE LAS AMERICAS S/N Y PASEO DE MILCHICHIG', '2340923', '', '', ''),
(531, '1104121510001', 'ONTANEDA JIMENEZ EDWIN VICENTE', 'ADOLFO VALAREZO 22-11 Y VALDIVIESO', '09717114', '', '', ''),
(532, '0106651417001', 'ORDOÑEZ CABRERA PEDRO ARMANDO', 'S/N', '088511548', '', '', ''),
(533, '0701929812001', 'ORDOÑEZ CALOZUMA MARIANA LUCINDA', 'PEDRO LOPEZ ARGUDO 3-13', '2859882', '', '', ''),
(534, '0104153911001', 'ORDOÑEZ OCHOA ANA MARIA', 'AV. ESPAÑA 11-14 Y ELIA LIUT', '2803183', '', '', ''),
(535, '0102512472001', 'ORDOÑEZ SEGOVIA CARLOS ENRIQUE', 'ANTONIO VALLEJO 2-100 Y EUGENIO ESPEJO', '096177452', '', '', ''),
(536, '0702339789001', 'ORELLANA AGUDO WALTER VINICIO', 'AV. DE LAS AMERICAS 5-128 Y BARRIAL BLANCO', '086711249', '', '', ''),
(537, '1900145200001', 'ORELLANA AREVALO GLADIS CARMELA', 'EPICLACHIMA S/N Y ALTIPLANO', '2804242', '', '', ''),
(538, '0103960738001', 'ORELLANA BRAVO MERCY RAQUEL', 'CALLE VIEJA 5-49 Y DEL CHORRO', '', '', '', ''),
(539, '0100857390001', 'ORELLANA CORDERO NESTOR ARGENCIO', 'PASEO RIO MACHANGARA S/N', '2804278', '', '', ''),
(540, '0105792014001', 'ORELLANA MENDOZA JOSE LUIS', 'SIMON BOLIVAR S/N Y 24 DE MAYO', '', '', '', ''),
(541, '0104083514001', 'ORELLANA PERALTA GLORIA ROCIO', 'S/N ', '', '', '', ''),
(542, '0101503639001', 'ORELLANA SAMANIEGO LUIS MARCELO', 'VIA A ANDACOCHA S/N', '', '', '', ''),
(543, '0103794624001', 'ORELLANA TENESACA WALTER MAURICIO', 'BARRIAL BLANCO 14-324 Y JULIO MATOVELLE', '097023495', '', '', ''),
(544, '0301729059001', 'ORELLANA URGILES SEGUNDO JAIME', 'GABRIEL GARCIA MORENO S/N ', '', '', '', ''),
(545, '0104988134001', 'ORTEGA ANDRADE JORGE EDUARDO', 'NICANOR COBOS 3-30 Y GENERAL ESCANDON', '', '', '', ''),
(546, '0102569498001', 'ORTEGA AREVALO PEDRO ANTONIO', 'CALERAS S/N L-2 Y MANUEL DE FALLA', '2387134', '', '', ''),
(547, '0102457835001', 'ORTEGA SANCHEZ ANA ISABEL', 'CAMILO PONCE S-N Y AV. PAUTE', '', '', '', ''),
(548, '0103151842001', 'ORTIZ BANEGAS PABLO JAVIER', 'LUIS CORDERO Y GENERAL ENRIQUEZ', '093043567', '', '', ''),
(549, '0102684925001', 'ORTIZ CEDILLO MARIA SUSANA', 'SANGURIMA S-N Y MARIANA CUEVA', '', '', '', ''),
(550, '0104435722001', 'ORTIZ CORONEL ANA PATRICIA', 'VIA MISICATA S-N', '082532537', '', '', ''),
(551, '0102793627001', 'ORTIZ ESPINOZA HUGO FERNANDO', 'TURUHUAICO 2-95 Y PASACALLE', '093806307', '', '', ''),
(552, '0101287886001', 'ORTIZ GALINDO LUIS ENRIQUE', 'LAS ALCABALAS 2-62 Y BARRIAL BLANCO', '2883267', '', '', ''),
(553, '0101558351001', 'ORTIZ GALINDO TEODORO ANTONIO', 'EL RETORNO 1-49 Y ARMENILLAS', '2832731', '', '', ''),
(554, '0104198684001', 'ORTIZ GONZALEZ JUAN PAUL', 'DE LOS COLORADOS 1-40 Y EL CONDOR', '092768863', '', '', ''),
(555, '0300797438001', 'ORTIZ NEIRA LUIS HUMBERTO ', 'CALLE VIEJA S/N Y AV. HEROES DE VERDELOMA', '098626090', '', '', ''),
(556, '0300289428001', 'ORTIZ ORTIZ MARIA VICTORIA', 'ARMENILLAS 2-62 Y GIL RAMIREZ DAVALOS', '2868353', '', '', ''),
(557, '0104065313001', 'ORTIZ ORTIZ PATRICIA EMPERATRIZ', 'VIA A GUARUMALES S/N', '', '', '', ''),
(558, '0104347497001', 'PACHECO CARDENAS JAVIER HONORIO ', 'VIA A CHICTI S/N', '', '', '', ''),
(559, '0102149390001', 'PACHECO REA ELVIA LUDUVINA', 'SIMON BOLICAR 1-48', '', '', '', ''),
(560, '0102138179001', 'PACURUCU LAFEBRE DIEGO ALFREDO', 'SARAURCO S/N Y AV. LOS ANDES', ' 2864694', '', '', ''),
(561, '0301507794001', 'PADRON SAETEROS DIEGO FERNANDO', 'GUAYAQUIL S/N Y PANAMERICANA SUR', '098060600', '', '', ''),
(562, '0300364932001', 'PAGUAY CHUSINA MARIA CARMEN', 'MARISCAL SUCRE 2-69 Y TOMAS ORDOÑEZ', '', '', '', ''),
(563, '0104967450001', 'PAGUAY TORRES JORGE BARZALLO', 'SIGLO XX  JOSE MIGUEL BARZALLO', '', '', '', ''),
(564, '0302198585001', 'PALAGUACHI JEREZ VERONICA SARBELIA', 'BIBLIAN', '087324287', '', '', ''),
(565, '0301681581001', 'PALTA PAUTE LAURO ALBERTO', 'PANAMERICANA SUR S/N', '', '', '', ''),
(566, '0105641740001', 'PANDO ALVARRACIN WALTER PAUL', 'CALLE DEL RETORNO S/N Y AV. GIL RAMIREZ DAVALOS', '081763513', '', '', ''),
(567, '0102985496001', 'PAREDES BENENAULA JULIA ALEJANDRINA', 'CAMINO A MISICATA S/N', '', '', '', ''),
(568, '1400364871001', 'PAREDES FERNANDEZ OLIVA NOEMI', 'AV. INTEROCEANICCA S-N ', '', '', '', ''),
(569, '1001999273001', 'PAREDES OBANDO MARIA LORENA', 'JOSE PERALTA S/N Y PAUCARBAMBA', '096801273', '', '', ''),
(570, '0102405255001', 'PARRA CORONEL GREIS DEL ROSARIO', 'AV. REMIGIO TAMARIZ 9-63 Y BATAN', '2815059', '', '', ''),
(571, '0102270931001', 'PARRA HIDALGO MARIA ELENA', 'COORDILLERA DE COLONCHE S/N Y CORDILLERA DE CHONGON', '', '', '', ''),
(572, '0104050323001', 'PARRA SOJOS JIMMY HENRY', 'MARISCAL LAMAR  11-67 Y TARQUI', '2840834', '', '', ''),
(573, '0102599909001', 'PARRA ZHAÑAY XAVIER SAUL', 'QUINGEO S/N Y ENTRADA A SAN MIGUEL', '094155249', '', '', ''),
(574, '0190167364001', 'PARTACCESORIOS PARTES Y ACCESORIOS CIA. LTDA. LLANTAMAX', 'JOAQUIN MALO L-82 Y AV. DE LAS AMERICAS', '4090560', '', '', ''),
(575, '0102595782001', 'PATIÑO QUIZHPI MARIA TERESA', 'LAMAR 11-95 Y TARQUI', '2867747', '', '', ''),
(576, '0104553847001', 'PAUTE GUIÑANSACA DIGNA SARBELIA', 'VIA A GIRON PASAJE S/N', '', '', '', ''),
(577, '0103864179001', 'PAZAN MALDONADO DIEGO PAOLO', 'AV. CARLOS ARIZAGA VEGA S/N', '', '', '', ''),
(578, '0905859583001', 'PAZAN RUBIO VICTOR BENJAMIN', 'CARLOS ARIZAGA VEGA S-N Y NICANOR TAPIA', '091260504', '', '', ''),
(579, '0102668225001', 'PEÑA MAURA WILSON VINICIO', 'SILBAN 1-32 Y LAS LADERAS', '4068402', '', '', ''),
(580, '0103439592001', 'PEÑA PATIÑO HUGO FABIAN', 'turuhuaico 7-35 y antonio neumane', '------', '', '', ''),
(581, '0103797999001', 'PEÑA RUILOVA ANDREA GABRIELA', 'CALLE VIEJA 5-16 Y TURUHUAICO', '4088878', '', '', ''),
(582, '0102346194001', 'PEÑAFIEL PALACIOS ANGEL MARCELO', 'AV. PASEO DE LOS CAÑARIS S/N Y YANAHURCO', '', '', '', ''),
(583, '0101115152001', 'PEÑAHERRERA PASANTEZ CARLOS MARCELO', 'GERARDO CORDERO Y LEON 83', '2883551', '', '', ''),
(584, '0104144597001', 'PEÑAHERRERA RAMON DIANA CAROLINA', 'AV. 27 DE FEBRERO 83 Y GERARDO CORDERO', '', '', '', ''),
(585, '1102970157001', 'PEÑALOZA ORDOÑEZ MARIA GLADYS', 'AV. GIL RAMIREZ DÁVALOS 1-96 Y EL CHORRO', '093293449', '', '', ''),
(586, '0103860821001', 'PERALTA BARBECHO VICTOR LEON', 'VIA A LA DOLOROSA', '', '', '', ''),
(587, '0102186368001', 'PERALTA CRESPO RUTH CECILIA', 'AV. ABELARDO J. ANDRADA S/N Y JOSE MIGUEL ORTEGA', '', '', '', ''),
(588, '0101577849001', 'PERALTA GONZALEZ MARCO LEONARDO', 'SOCAVON S/N Y DEL CEBOLLAR', '4082171', '', '', ''),
(589, '0102302403001', 'PERALTA VASQUEZ CARLOS ALBERTO', 'HUACAS S/N Y SILBAN', '4087853', '', '', ''),
(590, '0101679009001', 'PERALTA VILLAVICENCIO JOSE VICENTE', 'AV. ESPAÑA 9-16 Y SEVILLA', ' 2861279', '', '', ''),
(591, '0102393816001', 'PEREZ ANDRADE MARIA MAGDALENA', 'PACHACAMAC 1-73 Y AV. HUAYNA CAPAC', '091979910', '', '', ''),
(592, '0101787620001', 'PEREZ CORDERO CECILIA BERNARDITA', 'AV. SOLANO 1-02 Y TADEO TORRES', '2829329', '', '', ''),
(593, '1803266269001', 'PEREZ GUEVARA FRANKLIN DANILO', 'AV, GONZALEZ SUAREZ 16-125 Y RAYOLOMA', '084429008', '', '', ''),
(594, '0102570991001', 'PEREZ GUIRACOCHA PABLO ANTONIO', 'BARRIAL BLANCO 1-83 Y HEROES DE VERDELOMA', '2802416', '', '', ''),
(595, '0190358089001', 'PEREZ MACIAS VIOLETA DEL CARMEN', 'AV. GONZALEZ SUAREZ S/N Y LOS ANDES', '', '', '', ''),
(596, '0101782654001', 'PEREZ MENDEZ FELIX ROSENDO', 'S/N', '099592624', '', '', ''),
(597, '0103576914001', 'PEREZ ROSALES  EDGAR RICARDO', 'AV. DE LAS AMERICAS S/N Y MARISCAL LAMAR', '4101050', '', '', ''),
(598, '0103995510001', 'PESANTEZ MOROCHO JOSE MILTON', 'SIN NOMBRE S/N', '', '', '', ''),
(599, '0104961164001', 'PESANTEZ PESANTEZ FABIAN EDUARDO', 'PATOQUINOAS S/N Y LAGARTOCOCHA', '4085304', '', '', ''),
(600, '0101617629001', 'PESANTEZ PINOS PIEDAD CECILIA', 'AV. DE LAS AMERICAS 5-99 Y DANIEL HERMIDA', '4043352', '', '', ''),
(601, '0101287373001', 'PESANTEZ TOLEDO JORGE BENIGNO', 'RUMIÑAHUI 2-55 Y CACIQUE DUMA', '2866354', '', '', ''),
(602, '1706734496001', 'PICO BUENANO LUIS GUSTAVO', 'MIGUEL DE TRUJILLO 267 Y BOBONAZA', '022653947', '', '', ''),
(603, '0102975398001', 'PICON MOROCHO MANUEL CESAR', '5 ESQUINAS 9 DE OCTUBRE S-N Y CAÑARIBAMBA', '090917522', '', '', ''),
(604, '0190167976001', 'PIGGIS EMBUTIDOS', 'CASTELLANA Y SEGOVIA', '2862244', '', '', ''),
(605, '0502186216001', 'PILATASIG PILA LUIS ALFREDO', 'PRINCIPAL S/N', '082632005', '', '', ''),
(606, '0102724689001', 'PILLACELA GUAZHIMA ROMEL ISIDRO', 'DEL MEDIO EJIDO S/N', '', '', '', ''),
(607, '1725971590001', 'PILLAJO LUGUAÑA DIEGO MAURICIO', 'LOS GUABOS S/N Y INCHAPICHO', '', '', '', ''),
(608, '1718004599001', 'PILLAJO LUGUAÑA JUAN FELIPE', 'AV. LOJA 5-167 Y AV. PRIMERO DE MAYO', '', '', '', ''),
(609, '0102047156001', 'PILLCO BERREZUETA HILDA SENAIDA', 'LA PALMERAS CARLOS ARIZAGA VEGA S-N', '', '', '', ''),
(610, '0104639307001', 'PINEDA USCHA BLANCA MERCEDES', 'LA NUBE VIA A SAN MIGUEL S/N', '087087698', '', '', ''),
(611, '0300398906001', 'PINGUIL TENEZACA MANUEL JESUS', 'AV. GIL RAMIREZ DAVALOS 2-30 Y TURUHUYCO', '2808995', '', '', ''),
(612, '0102425634001', 'PINOS URGILES FABIOLA ELISABETH', 'DEMETRIO AGUILERA MALTA S/N Y EL REBENQUE', '2804775', '', '', ''),
(613, '0190332934001', 'PINOSTER CONSTRUCTORA CIA.LTDA', 'JOSE SOLIS 1-30', '', '', '', ''),
(614, '0102291317001', 'PINTADO BACUILIMA MILTON PEDRO', 'FRANCISCO DE ORELLANA S/N Y AV. DON BOSCO', '', '', '', ''),
(615, '0105399836001', 'PINTADO GUAMAN DIGNA NOEMI', 'PANAMERICANA SUR S/N', '2385432', '', '', ''),
(616, '0104712708001', 'PIÑA VALVERDE CARLOS MARCELO', 'JUAN BAUTISTA COBOS 4-43 Y MAUEL ANTONIO BORRERO', '2862372', '', '', ''),
(617, '0301983680001', 'PLACENCIA CONTRERAS TANIA FLORENTINA', 'DEL ARTESANO 1-70 Y CALLE VIEJA', '087449850', '', '', ''),
(618, '1711189918001', 'PONCE CHAUCA EDWARD WILLIAM', 'TOREADORA 2-73 Y SAN PABLO DEL LAGO', '', '', '', ''),
(619, '0100283985001', 'PONCE GONZALO HERIBERTO', 'VIA A PAUTE S/N', '', '', '', ''),
(620, '0101601060001', 'PONCE PRIETO OSWALDO PATRICIO', 'DEL RETORNO S/N Y JAIME ROSALES', '', '', '', ''),
(621, '0190369080001', 'PROMOTORA DINEC S.A', 'PASAJE PUMAPUNGO Y PASAJE 3 DE NOVIEMBRE', '2833073', '', '', ''),
(622, '0101297034001', 'PUENTE ROCANO MANUEL SACRAMENTO ', 'VIA A CUENCA S-N', '', '', '', ''),
(623, '0301825329001', 'PUMA PAREDES JORGE AURELIO ', 'OBISPO MIGUEL LEON S/N AV. DE LAS AMERICAS', '083071675', '', '', ''),
(624, '0102177300001', 'PURUNCAJAS PINTO FABIAN PATRICIO', 'MIGUEL DELGADO S/N Y FRANCISCO ESTRELLA', '', '', '', ''),
(625, '0103458766001', 'QUEZADA QUEZADA SEGUNDO EDGAR', 'VIA A PROGRESO - SUSUCEL S/N', '091234753', '', '', ''),
(626, '0912687811001', 'QUICHIMBO ZUMBA MARIANITO DE JESUS', 'SIGLO XX S/N ', '', '', '', ''),
(627, '0603380072001', 'QUINCHE CHUQUI AIDA DEL ROCIO', 'SAN VICENTE VIA A LA MINAS', '2882175', '', '', ''),
(628, '0101155307001', 'QUINDE HERAS JULIA MERCEDES', 'SEVILLA DE ORO', '', '', '', ''),
(629, '0103104212001', 'QUINDE ZHUNGUR ANGEL RODRIGO', 'AMAZONAS 1-29 Y AV. UNIDAD NACIONAL', '2817634', '', '', ''),
(630, '0102832177001', 'QUITO ARIAS MIGUEL ANGEL', 'FERNANDO ARAGON S/N Y AV. DON BOSCO', '084848806', '', '', ''),
(631, '0100283720001', 'QUITO ARIAS OSWALDO MARCELO', 'AV. GIL RAMIREZ DAVALOS 2-54 Y ELIA LIUT', '089977759', '', '', ''),
(632, '0103436549001', 'QUITO GOMEZ LUIS ALFREDO', 'VILLALOBOS S-N Y TARREAGA', '095850276', '', '', ''),
(633, '0102446002001', 'QUITO GUAYLLASACA SONIA BEATRIZ', 'VIA A MONAY BAGUANCHI S/N', '095869991', '', '', ''),
(634, '0100670439001', 'QUITO RODRIGUEZ JULIO CESAR', 'S/N', '087131883', '', '', ''),
(635, '0103905105001', 'QUITO SIGUENCIA BLANCA LUZMILA', 'NICOLAS VAZQUEZ S/N', '', '', '', ''),
(636, '0102121696001', 'QUITO VELECELA MANUEL PATRICIO', 'CLAVELES S/N Y LIRIOS, CUENCA', '2869525', '', '', ''),
(637, '0102380854001', 'QUITO VELECELA MARCO FERNANDO', 'RIO PALORA 5-14 Y RIO CUTUCU', '0864504', '', '', ''),
(638, '0102309408001', 'QUITO YUNGA LUIS ALBERTO', 'AUTOPISTA CUENCA AZOGUES', '0997452139', '', '', ''),
(639, '0100923317001', 'QUIZHPE PERALTA MARIA TERESA DE JESUS', 'UNION NACIONAL DE EDUCADORES 3-61 Y HERNAN CORDERO', '', '', '', ''),
(640, '0103870168001', 'QUIZHPI AUCAPIÑA WILSON ALONSO', 'AV. UNIDAD NACIONAL S/N Y A. DOCE DE ABRIL', '099438680', '', '', ''),
(641, '0104165667001', 'QUIZHPI GUAMAN JENIHT PRICILA', 'VIA A SININCAY S-N', '4082211', '', '', ''),
(642, '0101807667001', 'QUIZHPI PARRA JOSE GONZALO', 'VIA A SAN PEDRO DEL CEBOLLA S/N', '4060020', '', '', ''),
(643, '1723934079001', 'RAMIREZ OBANDO EDGAR YAMID', 'AV. TURUHUAICO 6-27 Y DE LA OCARINA', '2340152', '', '', ''),
(644, '0301353363001', 'RAMIREZ OBANDO EDGAR YAMID', 'CALLE VIEJA S/N Y ARMENILLAS', '', '', '', ''),
(645, '0700997588001', 'RAMON QUEZADA WILSON OSWALDO', 'AV. DE LAS AMERICAS S/N Y MEDIO EJIDO', '4024259', '', '', ''),
(646, '0301639035001', 'REA LEON WASHINGTON BRANDO', 'SUCRE 605 Y SIMON BOLIVAR', '', '', '', ''),
(647, '0190085422001', 'RECOR DENTAL', 'Bolivar y Hno. Miguel', '2823749', '', '', ''),
(648, '0190094014001', 'REENCAUCHADORA ANDINA  S.A.', 'CARLOS TOSI S/N ', '2805804', '', '', ''),
(649, '0102663762001', 'REINO ZHAÑAY EULALIA CATALINA', 'VIEJA 4-80 Y SILBAN', '086849727', '', '', ''),
(650, '0103381646001', 'REINOSO AVECILLAS SEGUNDO PEDRO', 'XAVIER LOYOLA 1-62 Y FRANCISCA CALDERON', '097009198', '', '', ''),
(651, '0100815372001', 'REINOSO MOLINA MARIA GUILLERMINA', 'PAN DE AZUCAR L-8 S/N Y CAJAS', '2864698', '', '', ''),
(652, '0190326802001', 'RENOTRANS C.A.', 'GUAGUALOMA 1-75 Y AV. DE LAS AMERICAS', '094503406', '', '', ''),
(653, '0104302930001', 'REYES LOYOLA PABLO EMANUEL', 'AV. MAX UHLE 2-61 Y CESAR VALLEJO', '.0', '', '', ''),
(654, '0102018306001', 'RIERA HUIRACOCHA GLORIA NATIVIDAD', 'FERNANDO FERNANDEZ DE CORDOVA', '088788707', '', '', ''),
(655, '0104455597001', 'RIERA SUCUZHANAY NIRIA EDELMIRA', 'VIA A GUARAINAG S/N', '', '', '', ''),
(656, '0703837955001', 'RIOFRIO CHAVEZ SHIRLEY ELIZABETH', 'GENERA VILLAMIL 1-20 Y  EDWIN SACOTO', '2815635', '', '', ''),
(657, '0100902642001', 'RIVERA ARCE SEGUNDO BENJAMIN', 'VIA A PAUTE  - MENDEZ S/N', '', '', '', ''),
(658, '0100910504001', 'RIVERA CONTRERAS FELIX ANTONIO', 'SEVILLO DE ORO', '', '', '', ''),
(659, '0101697431001', 'RIVERA PAGUAY MARIA LETICIA', 'PADRE JULIO MATOVELLE S/N Y GARCIA MORENO', '', '', '', ''),
(660, '1751874213001', 'ROBLEJO PEREZ JENNIE MILAGROS', 'AV. GONZALEZ SUAREZ S/N Y LOS ANDES', '', '', '', ''),
(661, '0104412697001', 'ROCANO BRITO MIGUEL ALBERTO', 'S/N PAUTE', '', '', '', ''),
(662, '0104415385001', 'ROCANO TIGRE WILLIAM GIOVANNY', 'PAUTE', '2203222', '', '', ''),
(663, '0102482031001', 'RODAS CUZCO CESAR AGUSTO', 'CALLE VIEJA 4-36 Y CABOGAN', '4088542', '', '', ''),
(664, '0104976048001', 'RODAS LOPEZ MARLON DAVID', 'SUCRE S/N', '2250542', '', '', ''),
(665, '0103919908001', 'RODRIGUEZ BARRERA SANDRA LORENA', 'SUCRE 6-05 Y BOLIVAR', '', '', '', ''),
(666, '0704159656001', 'RODRIGUEZ COELLO SHIRLEY ADRIANA', 'AUSTIN SANCHEZ S/N Y AV. ORDOÑEZ LAZO', '', '', '', ''),
(667, '0103954251001', 'ROJAS ALVARRACINA LUIS ALBERTO', 'GENERAL ESCANDON 3-84 Y JOSE ASTUDILLO', '', '', '', ''),
(668, '0100262625001', 'ROJAS MEJIA AURELIO', 'CAMINO A MISICATA 4-130', '2892739', '', '', ''),
(669, '0100230341001', 'ROJAS MEJIA PEDRO BOLIVAR', 'HUIZHIL S/N', '094898969', '', '', ''),
(670, '0103589818001', 'ROJAS PARAPI JUAN NICOLAS', 'VIA A SAN ANTONIO S/N', '', '', '', ''),
(671, '0104229604001', 'ROMERO BELTRAN MANUEL ISAIAS', 'PANAMERICANA NORTE 1-1B', '088460572', '', '', ''),
(672, '0100487024001', 'ROMERO IDROVO SALVADORA MARIA', 'PDTE. GABRIEL GARCIA MORENO S/N Y LUCIANO VALLEJO', '2275160', '', '', ''),
(673, '0102184231001', 'SACTA GUARTASACA MARCO ANTONIO', 'VIA A LUNTUR S/N', '082934282', '', '', ''),
(674, '0101234706001', 'SALAZAR CAPELO ARCENSIO ROMEO', 'VIA A OÑA S/N', '091252197', '', '', ''),
(675, '0101991958001', 'SALAZAR CHIRIBOGA MILTON ENRIQUE', 'VEGA MUÑOZ S/N Y KENNEDY', '', '', '', ''),
(676, '0104734702001', 'SALCEDO NUÑEZ FELIPE', 'GENERAL ESCANDON S/N Y ROBERTO CRESPO', ' 093900673', '', '', ''),
(677, '1200040705001', 'SALINAS SACOTO CESAR AUGUSTO', 'AV. 24 DE MAYO S/N Y LAS GARZAS', '', '', '', ''),
(678, '1400514210001', 'SALINAS SICHA ANA LUCIA', '6 DE DICIEMBRE S/N', '2770717', '', '', ''),
(679, '0605519354001', 'SALTO CULQUI KIMBERLY NOEMI', 'AV. DE LAS AMERICAS S-N Y HUACAS', '4087876', '', '', ''),
(680, '0106536022001', 'SALTO TENEMAZA WILLIAM ANDRES', 'INTEROCEANICA S/N', '', '', '', ''),
(681, '0104237409001', 'SAMANIEGO BERMEO MARIA HELEN ', 'ALEJANDRO DAVILA S/N Y SUCRE', '089374517', '', '', ''),
(682, '0100824960001', 'SAMANIEGO SAMANIEGO LUIS RODRIGO', 'ALEJANDRO DAVILA S/N Y SUCRE', '2266170', '', '', ''),
(683, '0102673506001', 'SANCHEZ AYABACA DIGNA MARICELA', 'FERNANDO VEGA S/N', '4177689', '', '', ''),
(684, '0102187242001', 'SANCHEZ ESPINOZA IVAN RENE', 'VIA A HUIZHIL S/N', '', '', '', ''),
(685, '0103389532001', 'SANCHEZ MONTERO GALO SILVIO', 'HUALCOPO S-N Y ANTIPLANO', '2804213', '', '', ''),
(686, '0103647970001', 'SANCHEZ SANCHEZ JHON PATRICIO', 'DAVILA 1-59 Y SUCRE', '089582800', '', '', ''),
(687, '0103616306001', 'SANCHEZ TENESACA OLGER ROBERTO', 'AV. ORDOÑEZ LAZO 6-06 Y LOS CEDROS', '4073141', '', '', ''),
(688, '0301160792001', 'SANCHEZ YEPEZ MARIA ELINA', 'AV. DE LAS AMERICAS S/N Y INDEPENDENCIA', '091907492', '', '', ''),
(689, '0105031793001', 'SANGURIMA PAUTE CATALINA ALEXANDRA', 'DE LAS CARRETAS 1-59 Y CALLE VIEJA', '099206738', '', '', ''),
(690, '0102331972001', 'SANISACA NAULA GERARDINA', 'DE LA INDEPENDENCIA 5-32 Y ANTONIO RICAURTE', '2866293', '', '', ''),
(691, '0302137658001', 'SANMARTIN PINOS JUAN PABLO', 'MARISCAL SUCRE S-N Y SIGLO XX', '', '', '', ''),
(692, '0103733655001', 'SANTACRUZ PEREZ MARIA JOSE', 'RUMIÑAHUI 2-47 Y CACIQUE DUMA', '2808700', '', '', ''),
(693, '1312800053001', 'SANTANDER VELEZ DIANA CAROLINA', 'MARISCAL LAMAR S/N Y FRANCISCO PAREDES H', '0918613332', '', '', ''),
(694, '0102207420001', 'SAQUICELA ZHUNIO SANTIAGO DANILO', 'CALLE VIEJA 11-73 Y ELIA LIUT', '2864968', '', '', ''),
(695, '0103212692001', 'SARI QUINDE RUTH MARLENE', 'BARRIAL BLANCO S/N Y DE LAS AMERICAS', '09717114', '', '', ''),
(696, '0301840054001', 'SARMIENTO AMON ANDRES VINICIO', 'ABDON CALDERON S-N', '', '', '', ''),
(697, '0301517132001', 'SARMIENTO MOLINA KLEVER MILTON', 'PUARTO DE PALOS S/N Y AV. LOJA', '091079267', '', '', ''),
(698, '0101590362001', 'SARMIENTO SEGOVIA CARLOS ALFONSO', 'GUACHAPALA', '', '', '', ''),
(699, '0102458817001', 'SARMIENTO SEGOVIA FROILAN IPOLITO', 'NICOLAS VAZQUEZ S/N', '086727801', '', '', ''),
(700, '0102377884001', 'SEGARRA ANDRADE PAUL DAVID', 'AV. DE LAS AMERICAS S/N Y TURUHUAYCO', '2340317', '', '', ''),
(701, '0302148606001', 'SEGARRA CASTRO SANDRA MARLENE', 'RODRIGUEZ PARRA S/N', '', '', '', ''),
(702, '0106056492001', 'SEGOVIA ZAMBRANO CHRISTIAN FERNANDO', 'OBRERO S/N Y CARRETAS', '4088121', '', '', ''),
(703, '0103508461001', 'SHINING VEGA LIDIA ELIZABETH', 'AV. YANAHURCO LM-15 Y VICTOR AGUILAR', '2864315', '', '', ''),
(704, '0100905876001', 'SIBRI SUCUZHAÑAY LUIS ENRIQUE', 'SEVILLA DE ORO', '', '', '', ''),
(705, '0102483641001', 'SILVA NARVAEZ LUIS ANIBAL', 'GENERAL TORRES 5-20 Y CALLE LARGA', '2826355', '', '', ''),
(706, '0190334279001', 'SINCHI CARRASCO ASOCIADOS  CIA.LTDA', 'VIA A SININCAY AV. ABELARDO J. ANDRADE', '4082212', '', '', ''),
(707, '0102549888001', 'SINCHI CARRASCO HUGO BOLIVAR', 'S/N (VIA A SININCAY - AV. ABELARDO J. ANDRADE S/N)', '4082212', '', '', ''),
(708, '0104752159001', 'SINCHI SINCHI PABLO ANIBAL', 'VIA A SAN PEDRO DEL CEBOLLA S/N', '099626657', '', '', ''),
(709, '0101489979001', 'SINCHI TACURI ANITA LUCILA', 'VIA A SININCAY S/N', '', '', '', ''),
(710, '0100119171001', 'SINCHI TACURI BLANCA SUSANA', 'VIA PRINCIPAL S/N', '', '', '', ''),
(711, '0103814711001', 'SIRANAULA FAJARDO ANA LUCIA', 'GABRIEL CARRASCO 1-03 Y ALFONSO MARIA MORA', '2856449', '', '', ''),
(712, '0102821469001', 'SIRANAULA FAJARDO ROGER EDUARDO', 'GABRIEL CARRASCO 1-03 Y ALFONSO MARIA MORA', '2856499', '', '', ''),
(713, '0104042460001', 'SISALIMA ZUÑA CARLOS ORLANDO', 'ABDON CALDERON S-N Y RAMON BORRERO', '081655968', '', '', ''),
(714, '0103418216001', 'SISALIMA ZUÑA NORMA ISABEL', 'ABDON CALDERON S/N Y RAMON BORRERO', '2250595', '', '', ''),
(715, '0190160017001', 'SISTEMA DE RIEGO MACHANGARA', 'CHIQUINTAD', '4179156', '', '', ''),
(716, '0700378433001', 'SOLORZANO IRMA COLOMBIA', 'AV. ALONZO MERCADIL S/N Y LA Y', '2972290', '', '', ''),
(717, '0103117982001', 'SOLORZANO ORTIZ RAMON SANTIAGO', 'DE LOS V JUEGOS NACINALES S/N Y DANEL A. CAÑIZARES', '092759535', '', '', ''),
(718, '0105554240001', 'SOLORZANO URGILES LUIS EUCLIDES', 'S/N PAUTE', '', '', '', ''),
(719, '0704492990001', 'SOTAMBA HURTADO RICHARD PATRICIO', 'BARRIAL BLANCO 5-71 Y DE LAS CARRETAS', '097355843', '', '', ''),
(720, '0190340937001', 'SPRING CORRAL & HIJOS C.LTDA', 'NUEVA LOJA 1-05 Y REMIGIO TAMARIZ', '', '', '', ''),
(721, '0105818264001', 'SUAREZ ARMIJOS JAVIER NAUFREDO', 'OCARINA S/N Y TURUHUAYCO', '098941783', '', '', ''),
(722, '0102647111001', 'SUIN SACAQUIRIN ROMUALDO MARTINANO', 'LA VERDAD ', '', '', '', ''),
(723, '0104450846001', 'SUMBA LEON KARLA GISELLE', 'DON BOSCO NICOLAS VASQUES S/N', '', '', '', ''),
(724, '1790016919001', 'SUPERMAXI', 'ELIA LIUT Y GIL RAMIREZ', '2864314', '', '', ''),
(725, '1713920864001', 'SUQUILLO CAIZA JOSE RODRIGO', 'AV. LOJA 5-167 Y AV. PRIMERO DE MAYO', '', '', '', ''),
(726, '0102150240001', 'TACURI ARPI MANUEL VICENTE', 'ALEJANDRO VOLTA S/N Y GAY LUSSAC', '090719675', '', '', ''),
(727, '0102465036001', 'TACURI COLLAGUAZO JOSE VICENTE', 'JAIME ROLDOS JESUS DEL GRAN PODER 6', '081690233', '', '', ''),
(728, '0915557581001', 'TACURI GUAMAN MARIA EMILIA', 'S/N Y SECTOR PONGO CHICO', '', '', '', ''),
(729, '0101221059001', 'TACURI ROLDAN VICENTE GILBERTO', 'AV. LAS AMERICAS 1-85 Y LUIS MOSCOSO', '095972760', '', '', ''),
(730, '0104399043001', 'TACURI VELEZ RUTH NELLY', 'VIA A POLOMA S/N', '4036921', '', '', ''),
(731, '0102594926001', 'TAPIA CALLE DIEGO FABIAN', 'VIA A SININCAY S-N', '2390543', '', '', ''),
(732, '0301863452001', 'TAPIA CALLE JOSE DAVID', 'VIA A TRIGALES ALTOS MR-355', '092707992', '', '', ''),
(733, '0104293485001', 'TAPIA NIEVES XAVIER MARCELO', 'SECTOR SAN MIGUEL S/N', '', '', '', ''),
(734, '1791436512001', 'TAPIA Y MERA Cia.Ltda', 'QUITO', '2900989', '', '', ''),
(735, '0100608546001', 'TELLO ELVIRA ELENA', 'AV. AMERICAS S/N Y EDUARDO ARIAS', '4095304', '', '', ''),
(736, '0105665228001', 'TENEMPAGUAY LARGO KLEBER ALBERTO', 'AV. INTEROCEANICCA S-N Y TUTUCAN', '', '', '', ''),
(737, '0101493591001', 'TENESACA CARDENAS MANUEL HUMBERTO', 'VIA A GUARUMAMES MENDEZ S-N', '', '', '', ''),
(738, '0103720553001', 'TENORIO TELLO FABIOLA MARICELA', 'VIA MONAY EL CRUCE S/N', '084763696', '', '', ''),
(739, '0907533566001', 'ABAD BARRERA LUIS HECTOR', 'JULIO JARAMILLO S/N Y DEL RETORNO', '2340585', '', '', ''),
(740, '0104272380001', 'TIGRE MORA RUTH CATALINA', 'S/N ', '2341763', '', '', ''),
(741, '0703237891001', 'TOALONGO VERA DALILA DEL PILAR', 'AV. DE LAS AMERICAS S/N Y JUAN LARREA', '', '', '', ''),
(742, '0102492196001', 'TOGRA JARA ANA LUCIA', 'S/N', '', '', '', ''),
(743, '0104133863001', 'TOLA TOLEDO VERONICA ANDREA', 'MANUEL QUIROGA S/N Y MANUELA ZAENZ', '099129161', '', '', ''),
(744, '0190379450001', 'TORO VINASCO LUZ ADRIANA', 'S/N', '', '', '', ''),
(745, '0104764105001', 'TORRES  CONTRERAS KARINA MARIANELA', 'QUITO S-N T CIRCUNVALACIÓN', '', '', '', ''),
(746, '0101676542001', 'TORRES ANGUISACA MARCO ROLANDO', 'AV. MANCILLA S/N', '2250238', '', '', ''),
(747, '0300486644001', 'TORRES CANTOS MANUEL ANTONIO', 'OCARINA S-N Y AV. DE LAS AMERICA', '098490623', '', '', ''),
(748, '0103055463001', 'TORRES CARDENAS CARLOS ENRIQUE', 'AV. SIGLO XX 2-14', '', '', '', ''),
(749, '0103146163001', 'TORRES CARDENAS LORENA BEATRIZ', 'AV. SIGLO XX 2-14', '', '', '', ''),
(750, '0103078010001', 'TORRES CHIQUE MARIA CARMITA', 'PUEBLO NUEVO S/N', '099384211', '', '', ''),
(751, '0106468952001', 'TORRES LOZADO ROSA MERCEDES', 'COLON S/N Y AV LOS CAÑARIS', '', '', '', ''),
(752, '0103342507001', 'TORRES PICON MIRIAN PATRICIA', 'AV. LOJA 6-26 Y AV. DON BOSCO', '', '', '', ''),
(753, '0102565348001', 'TOTAL GUERRERO JAVIER ANTONIO', 'DEL BATAN S/N Y SANTA CRUZ', '4101060', '', '', ''),
(754, '0190169057001', 'TRANS PIONEROS DEL AUTROS CIA.LTDA', 'AV. DE LAS AMERICAS S/N Y ARMENILLAS', '2848166', '', '', ''),
(755, '0190342484001', 'TRANSCOMER CIA.LTDA', 'AV. ESPAÑA 10-91 Y FRANCISCO PIZARRO', '2801303', '', '', ''),
(756, '0190153460001', 'TRANSMIRAFLORES S.A.', 'AV. ABELARDO J. ANDRADA S/N Y AV. DEL CHOFER', '', '', '', ''),
(757, '0190344339001', 'TRANSMORLAQUI C.A.', 'LUIS MOSCOSO 1-86 Y AV. DE LAS AMERICA', '095972760', '', '', ''),
(758, '0190314405001', 'TRANSPORTES ARPI PEREZ TAPERSA CIA LTDA', 'NUÑEZ DE BONILLA 101 Y SEBASTIAN DE BENALCAZAR', '4084293', '', '', ''),
(759, '0190346560001', 'TRANSPORTES PAGUAY TRANSPAGUAY S.A.', 'CAJAS S/N Y YAGUARCOCHA', '2869973', '', '', ''),
(760, '0103118345001', 'TRELLES CRESPO FELIX RAFAEL', 'PAUTE SIN NOMBRE', '', '', '', ''),
(761, '0103955274001', 'TUBA VELETANGA ANGEL POLIVIO', 'S/N Y BELISARIO ANDRADE', '2341722', '', '', ''),
(762, '0101743888001', 'TUPAN  SAQUIPAY JULIO RICARDO', 'SAN PEDRO DE ESCALERAS', '091955797', '', '', ''),
(763, '0100392034001', 'ULLAURI ROMERO LUZ MARIA', 'SIN NOMBRE S-N Y SECTOR SUSUDEL', '2580440', '', '', ''),
(764, '0101468577001', 'ULLOA CABRERA MARIO ALFONSO', '3 DE NOVIEMBRE 4-34 Y CUENCA', '095170920', '', '', ''),
(765, '0190151530001', 'UNIVERSIDAD POLITECNICA SALESIANA', 'CALLE VIEJA 12-30 ', '24135250', '', '', ''),
(766, '0104420674001', 'UYAGUARI YARI NANCY RAQUEL', 'AV. AMAZONAS S/N', '2418278', '', '', ''),
(767, '0300959434001', 'UZHCA PARAPI MARIA MARGARITA', 'ISABELA CATOLICA 10-20 Y AV. 12 DE OCTUBRE', '2815893', '', '', ''),
(768, '2100057344001', 'CARDENAS TAPIA  JOSE FELIX', 'CRISTOBAL COLON 20 Y HEROES DEL CENEPA', '0994479737', '', '', ''),
(769, '0102807823001', 'VALDIVIEZO ORTIZ JAVIER ALFREDO', 'CULEBRILLAS S/N Y PASAJE CULEBRILLAS', '2868739', '', '', ''),
(770, '0104988548001', 'VALERA BARRERO EDOARDO ANDRES', 'AV. GIL RAMIREZ DAVALOS S/N Y SEBASTIAN DE BENALCAZAR', '0981114965', '', '', ''),
(771, '0102572674001', 'VALLEJO CEDILLO MAURICIO ESTEBAN', 'FRANCISCO MOSCOSO S/N Y RAFAEL TORRES BELTRAN', '4024572', '', '', ''),
(772, '0104202957001', 'VARGAS GUERRERO JUAN PABLO', 'LA VICTORIA S/N', '082111198', '', '', ''),
(773, '0100801448001', 'VASQUEZ CALLE MARIA ALTAGRACIA', 'AV. DE LAS AMERICAS S/N', '2819266', '', '', ''),
(774, '0102323847001', 'VASQUEZ CAMPOVERDE CESAR RODOLFO', 'TURUHUAICO 4-70 Y HUACAS', '084051240', '', '', ''),
(775, '0101773810001', 'VASQUEZ HEREDIA ROSA INES', 'VIA A GUARUMALES S/N', '2250602', '', '', ''),
(776, '0100405521001', 'VASQUEZ PATIÑO RODOLFO HESS', 'SIN NOMBRE S/N', '2228080', '', '', ''),
(777, '0102315165001', 'VAZQUEZ BENAVIDEZ JUAN FERNANDO', 'SIMON BOLIVAR 6-08 Y JOSE MIGUEL BARZALLO', '', '', '', ''),
(778, '0104828694001', 'VAZQUEZ URGILES SANTIAGO ESTEBAN ', 'RIO ORINOCO S/N', '', '', '', ''),
(779, '1100039393001', 'VEGA LUIS ANTONIO', 'ALONSO DE MERCADILLO S/N', '2972290', '', '', ''),
(780, '0300289774001', 'VELEZ ARIZAGA PIEDAD TERESITA DEL NIÑO JESUS', 'HERMANO MIGUEL 19-25 Y EUGENIO ESPEJO', '087080878', '', '', ''),
(781, '0103724258001', 'VELEZ TOGRA MILTON XAVIER', 'VIA A CUENCA S-N', '', '', '', ''),
(782, '0102539475001', 'VELEZ VICTOR HUGO', 'CALLE DEL RETORNO V-22', '', '', '', ''),
(783, '0102405545001', 'VELEZACA CHAPA PASTOR MARCELO', 'CORDILLERA DE TOIZAN S/N', '', '', '', ''),
(784, '0104845771001', 'VELEZACA FERNANDEZ EGMA CESILIA', 'AV. HURTADO DE MENDOZA 4-87 Y ANTISANA', '', '', '', ''),
(785, '0103597159001', 'VENEGAS VENEGAS JENNY SUSANA', 'FRANCISCO CALDERÓN 2-99 Y JAVIER LOYOLA', '097955816', '', '', ''),
(786, '0104470885001', 'VERA YUQUI DIANA PRISCILA', 'CHAPETONES 1-48 Y GIL RAMIREZ', '', '', '', ''),
(787, '0102814787001', 'VERDUGO TENESACA JUAN PABLO', 'CESAR ANDRADE 3-70 Y ALFONSO MORENO MORA', '2880714', '', '', ''),
(788, '0104058391001', 'VERDUGO TENESACA PRISCILA ROSARIO', 'CESAR ANDRADE 5-12 Y ALFONSO MORENO MORA', '085801677', '', '', ''),
(789, '0103379871001', 'VERDUGO TENESACA WILSON PATRICIO', 'ALFONSO MORENO MORA 5-12 Y CESAR DAVILA', '092818953', '', '', ''),
(790, '0300176476001', 'VICUÑA NIETO MOISES ALCIDES', 'CRUZPAMBA', '', '', '', ''),
(791, '0602922544001', 'VILLA SAMANIEGO EDUARDO EFRAIN', '12 DE OCTUBRE S/N Y MANABI', '088226830', '', '', ''),
(792, '0101819332001', 'VILLA TACURI LUZ EDELINA', 'SIN NOMBRE S/N', '', '', '', ''),
(793, '0101497709001', 'VILLA ZHAGUI MARINA IMELDA', 'MERCEDES QUINDE S-N Y CALLE VIEJA', '2865732', '', '', ''),
(794, '0300871068001', 'VILLACRECES SARMIENTO ARTURO FERNANDO', 'AMSTERDAM S/N Y ROMA', '099874878', '', '', ''),
(795, '0105180897001', 'VILLALTA ARCENTALES NANCY CECILIA', 'SIMON BOLIVAR S/N Y SUCRE', '', '', '', ''),
(796, '0102279734001', 'VILLAMAR CABRERA CARLOS EDUARDO', 'POPAYAN K-15 Y RIO DE JANEIRO', '2804327', '', '', ''),
(797, '0102427317001', 'VILLAVICENCIO LOPEZ JORGE EDUARDO', 'SIN NOMBRE S-N Y SIN NOMBRE', '', '', '', ''),
(798, '0103991618001', 'VILLAVICENCIO PESANTEZ JUAN MAURICIO', 'LA HABANA N-21 Y POPAYAN', '093913780', '', '', ''),
(799, '0101459113001', 'VINTIMILLA BARZALLO MIREYA ALICIA', 'FRANCISCO MOSCOSO S/N Y AV. SAN SILVESTRE', '099243767', '', '', ''),
(800, '0101333201001', 'VINTIMILLA MOSCOSO LUIS EDUARDO', 'GRAN COLOMBIA S/N Y UNIDAD NACIONAL', '097838506', '', '', ''),
(801, '0101494979001', 'VINTIMILLA TORRES HIDALGO BACILIO', 'VIA A TADAY S/N', '', '', '', ''),
(802, '0103788444001', 'VINTIMILLA VINTIMILLA DANIEL FRANCISCO', 'CORNELIO MERCHAN 2-45 Y JOSE PERALTA', '4103703', '', '', ''),
(803, '0923032528001', 'VIRI PINOS JUAN FRANCISCO', 'VIA A ANDACOCHA S/N', '', '', '', ''),
(804, '0105426696001', 'VIRI PINOS MANUEL JESUS', 'VIA A ANDACOCHA S/N', '086727605', '', '', ''),
(805, '1711995454001', 'WITT PLATANOFF PATRICIO GUILLERMO', 'RAMONA CORDERO Y LEON S/N Y LUIS ACOSTA', '096801273', '', '', ''),
(806, '0101830412001', 'YAMUNAQUE LEON JANNETH SARAYA', 'TURUBAMBA S/N Y AV. QUITO', '087230689', '', '', ''),
(807, '0702594581001', 'YANEZ CABRERA JUAN JOSE', '9 DE OCTUBRE S/M Y CAÑARIBAMBA', '2270139', '', '', ''),
(808, '0102382066001', 'YANZA PEREZ MANUEL RICARDO', 'LUIS ACOSTA S-N Y JOSE ASTUDILLO', '2844463', '', '', ''),
(809, '0105563407001', 'YANZA ZAMBRANO SILVIO HOMERO', 'PANAMERICANA NORTE S/N', '088171035', '', '', ''),
(810, '0103919874001', 'YANZAGUANO PARRA JOSE DANIEL', 'MARISCAL SUCRE S/N', '', '', '', ''),
(811, '0105227789001', 'YARI MOROCHO PRISCILA NATALIA', 'AV. AMAZONAS S/N', '2418024', '', '', ''),
(812, '0704574144001', 'YUNGA PINTADO JULIO RODRIGO', 'BARRIAL BLANCO 15-176', '090744100', '', '', ''),
(813, '0104972450001', 'YUPANGUI PAGUAY VERONICA ALEXANDRA', 'SIMON BOLIVAR S/N Y SUCRE', '', '', '', ''),
(814, '0102187523001', 'YUQUI PONCE CORLOS RIGOBERTO', 'VIA A MENDEZ S/N', '', '', '', ''),
(815, '0102636990001', 'ZALAMEA LEON LAURA INES', 'DESCARTES 1-69', '2828347', '', '', ''),
(816, '0102245057001', 'ZAMORA TELLO PABLO FABIAN', 'ESCULTOR VELASCO 1-37 Y DEL ARTESANO', '0980854708', '', '', ''),
(817, '0102118072001', 'ZAMORA TELLO SERGIO PATRICIO', 'CALLE VIEJA S/N Y LA CARRETAS', '', '', '', ''),
(818, '0190380165001', 'ZARENT ZARUMA RENTA A CAR CIA, LTDA.', 'AV. ESPAÑA 11-20 Y ELIA LIUT', '4084156', '', '', ''),
(819, '1718282419001', 'ZENTENO FREIRE OSCAR ANDRES', 'FIDEL ROSALES S/N', '097428729', '', '', ''),
(820, '0107125981001', 'ZHAGÑAY ZHAGÑAY DIEGO ARMANDO', 'VIEJA S/N Y ARMENILLAS', '2803696', '', '', ''),
(821, '0102268703001', 'ZHANAY BRAVO EDGAR PATRICIO', 'BARRIAL BLANCO S/N Y TORIL', '2900359', '', '', ''),
(822, '1716056781001', 'ZHANG CHEN JINGUA', 'AV. ESPAÑA 2-110 Y NUÑEZ DE BONILLA', '', '', '', ''),
(823, '0101725307001', 'ZHICAY GUACHUN ANGELITA DEL ROSARIO', 'VIA AL ESTADIO S/N', '2203079', '', '', ''),
(824, '0103461596001', 'ZHIMINAICELA CUZCO WILSON RUBEN', 'AV. GIL RAMIREZ DAVALOS 1-90 Y CHORRO', '2340325', '', '', ''),
(825, '0106086671001', 'ZHIMINAICELA LEON SONIA YOLANDA', 'SAN MIGUEL', '', '', '', ''),
(826, '0105898175001', 'ZHIRZHAN PROCEL VICTOR PAUL', 'VIA A DUGDUG', '', '', '', ''),
(827, '0914771688001', 'ZHUCUZHAÑIAY SALAZAR KLEVER OSWALDO', 'SIN NOMBRE / CHORDELEG', '0995358009', '', '', ''),
(828, '1102096862001', 'ZHUNAULA CHALAN JUAN', 'GONZALEZ SUARES L-45 Y REINO DE QUITO', '099602959', '', '', ''),
(829, '0104510458001', 'ZHUNGO FERNANDEZ LUIS DEOFILIO', 'FRANCISCO XAVIER S-N', '', '', '', ''),
(830, '0100876374001', 'ZUMBA PALAGUACHI SERGIO ROLANDO', 'FRANCISCO CALDERÓN 2-85', '2827956', '', '', ''),
(831, '0103131058001', 'ZUÑA GORDILLO ELVA JOVINA', 'VIA A PAUTE GUARUMALES MENDEZ S-N', '2291222', '', '', ''),
(832, '0102320371001', 'ZUÑIGA HOYOS IRALDA BEATRIZ', 'SIXTO DURAN BALLEN S/N', '', '', '', ''),
(833, '0105155873001', 'CORDERO PINOS DIEGO ESTEBAN', 'CAMILO EGAS 2-21 Y LUIS MONSALVE POZO', '', '', '', ''),
(834, '0190383830001', 'CENTRO DE ESTUDIOS Y NIVELACIÓN ACADEMICA CENIACADEM S.A.', 'AV. PAUCARBAMBA S/N Y JOSE PERALTA', '4103225', '', '', ''),
(835, '0190156257001', 'TOYOCUENCA S.A.', 'GIL RAMIREZ DAVALOS 3-90', '2865678', '', '', ''),
(836, '0102279429001', 'SARMIENTO POLO PABLO VINICIO', 'AV. OCTAVA SUR 28/03', '0000', '', '', ''),
(837, '0101425551001', 'AVILES MUÑOZ MARGOT CECILIA', 'CAMINO A PATAMARCA S/N', '2900534', '', '', ''),
(838, '1750312959001', 'ZHANG CHEN YOUMIAO', 'AV. ESPAÑA 2-110 Y NUÑEZ DE BONILLA', '2864461', '', '', ''),
(839, '0102890761001', 'ARIZAGA VELEZ JOSE SANTIAGO', 'VIA A NULTI S/N', '0994994792', '', '', ''),
(840, '0102066800001', 'HORMAECHEA HIDALGO JUAN IGNACIO', 'SIN NONBRE S/N', '2876617', '', '', ''),
(841, '0102425550001', 'GUZHNAY PADILLA NORMA BEATRIZ', 'DEL RETORNO S/N Y ESCUADRON  CEDEÑO', '0995355549', '', '', ''),
(842, '0100884311001', 'ORTIZ COBOS LUIS ENRIQUE', 'LUIS CORDERO Y RAFAEL MARIA ARIZAGA', '2820414', '', '', ''),
(843, '1400671796001', 'MEJIA MATUTE RIKELMER MAMFREDY', 'DE LOS V JUEGOS NACINALES S/N Y DANEL A. CAÑIZARES', '0993431324', '', '', ''),
(844, '0302018718001', 'RIVIERA ARCE WALTER RAIMUNDO', 'VIA A OCHOA LEOAN S/N', '', '', '', ''),
(845, '0102054111001', 'VELEZ GARATE PATRICIA LORENA', 'VIA MISICATA KM 3 S/N', '2862545', '', '', ''),
(846, '0102245651001', 'LEON LAZO ALFONSO EUGENIO', 'AV.PASEO DE LOS CAÑARIS 5-14', '', '', '', ''),
(847, '0103735809001', 'VERA CARDENAS IRMA ISABEL', 'ULISES SOTOMAYOR S/N', '2280254', '', '', ''),
(848, '0102165958001', 'GUARTASACA TAPIA BERTHA LUCIA', 'DUITAMA S/N SIN SILVESTRE', '', '', '', ''),
(849, '0101807592001', 'SOLANO PELAEZ KLEVER VICENTE', 'DIEGO COLON S/N Y FRAY GASPAR DE CARABAJAL', '4056622', '', '', ''),
(850, '0102291002001', 'CORDOVA RODAS ANA ISABEL', 'AV.SOLANO 4-53 Y FLORENCIA ASTUDILLO', '0994568581', '', '', ''),
(851, '0702649294001', 'CARCHI FERNANDEZ JOSE VICENTE ', 'ANTONIO NAUMANE S/N Y CANTOR', '', '', '', ''),
(852, '0101871440001', 'NUGRA SANCHEZ FELIX ANTONIO', 'MARIA AUXILIADORA VIA AL VALLE S/N', '', '', '', ''),
(853, '0102953379001', 'GUERRERO ALVAREZ ANTONIO JOSE', 'DEL ARTESANO 2-70', '', '', '', ''),
(854, '0101139541001', 'VENEGAS CORDERO MARCO ROLANDO', 'CORONEL FRANCISCO CALDERON 2-99', '0994028341', '', '', ''),
(855, '0103807426001', 'FARFAN MUÑOZ DIEGO RENE', 'LA CASTELLANA Y SEVILLA', '2804598', '', '', ''),
(856, '0103085874001', 'VINTIMILLA CORDOVA MARIA GABRIELA', 'AV. PAUCARBAMBA 3-142 Y FRANCISCO SOJOS', '2886043', '', '', ''),
(857, '0104327325001', 'MERCHAN IZURIETA JOHANNA ELIZABETH', 'CALLE DE LA BOCINA 1-75', '4087278', '', '', ''),
(858, '0703929497001', 'ZAMBRANO MONSERRATE MANUEL ANDRES', 'AYACUCHO 2019 Y ARIZAGA', '2936483', '', '', ''),
(859, '0190352099001', 'COMITÉ DE DESARROLLO DE LA NIÑEZ Y LA FAMILIA CNH LAS SEMILLITAS', 'SILVAN S/N Y HUACAS', '099604409', '', '', ''),
(860, '1102935010001', 'MORENO SAMANIEGO BETTY ROCIO', 'MARIANO CUEVA 11-70  Y SANGURIMA', '828113', '', '', ''),
(861, '1104348204001', 'ALVARO POGO', 'PASEO DE MICHICHIG', '2340260', '', '', ''),
(862, '0105501852001', 'TAMAYO CAMPOVERDE TATIANA FABIOLA', 'LATINOAMERICA 1-18 Y REMIGIO CRESPO', '2815156', '', '', ''),
(863, '0103861951001', 'PINEDA MUÑOZ DANIEL ALEJANDRO', 'S/N', '2891778', '', '', ''),
(864, '0101586733001', 'ROMEL CORDOVA', 'PASEO RIO MACHANGARA S/N', '2808562', '', '', ''),
(865, '0102046042001', 'HURTADO CHERREZ VALERIA FERNANDA', 'CABOGAN 2-141 Y SILBAN', '4088898', '', '', ''),
(866, '1804137022001', 'GUAMAN LESCANO SEGUNDO GABRIEL', 'S/N', '0990884335', '', '', ''),
(867, '0104186259001', 'AREVALO BRITO FREDDY MARCO', 'S/N', '994822261', '', '', ''),
(868, '0104531611001', 'SHICAY ARIAS CRISTIAN FRANCISCO', 'S/N SECTOR BARABON', '2370437', '', '', ''),
(869, '0102634748001', 'CALLE ALVARRACIN LUIS FERNANDO', 'BOLIVAR S/N', '072279328', '', '', ''),
(870, '0104369202001', 'ORELLANA INGA GABRIELA CAROLINA', 'BOSQUE DE MONAY  MZ-K24 Y MANAGUA', '2809622', '', '', ''),
(871, '0100269182001', 'ZEA MATOVELLE BLANCA LUCIA', 'ARMENILLAS 2-86 Y GIL RAMIREZ DAVALOS', '2862566', '', '', ''),
(872, '0103563243001', 'CHALEN MENDIETA PABLO FERNANDO', 'PLOVDIV L-1', '0998969902', '', '', ''),
(873, '0160055330001', 'JUNTA ADMINISTRADORA DE AGUA POTABLE Y ALCANTARILLADO DE CHICAN', 'VIA A COPZHAL S/N', '3014374', '', '', ''),
(874, '0102305190001', 'JARAMILLO GUACHICHULLCA BERTHA MARIANA', 'CARRETAS 2-06 Y DEL OBRERO', '2861339', '', '', ''),
(875, '0160000940001', 'GAD MUNICIPAL DE SAN FERNANDO', 'CALLE SUCRE S/N Y 10 DE AGOSTO', '2279100', '', '', ''),
(876, '0190368815001', 'CONSTRUCCIONES CABRERA CONSTRUCABRERA CIA LTDA.', 'AV. YANAHURCO M15 Y ANTISANA', '2862315', '', '', ''),
(877, '0160050100001', 'CUERPO DE BOMBEROS DEL CANTON GUACHAPALA', 'CENTRO SIXTO DURAN BALLEN S/N', '959235168', '', '', ''),
(878, '0103789202001', 'CHIQUI SINCHI MARIA BALTAZARRA', 'VIA SIGCHO S/N', '4060606', '', '', ''),
(879, '1800385963001', 'ROMERO PALACIO LEONARDO AGUSTIN', 'CORNELIO VINTIMILLA 1-51 Y OCTAVIO CHACON', '2806321', '', '', ''),
(880, '0101662542001', 'PEÑALOZA NAULA BLANCA LUISA', 'DANIEL A. CAÑIZARES A11', '2898670', '', '', ''),
(881, '1790007499001', 'UMCO S.A.', 'QUITO', '2655718', '', '', ''),
(882, '0102380615001', 'OCHOA SAN LUCAS SILVIA DEL CARMEN', 'LAS ORQUIDEAS LUIS ALARCON L-3', '2870409', '', '', ''),
(883, '0104146782001', 'ESPINOZA ARIAS MARIA BELEN', 'CALLE VIEJA S/N Y CALLE DEL CHORRO', '2801 572', '', '', ''),
(884, '0190376583001', 'FIRE', 'JACINTO FLORES 1-05 Y AV. 10 DE AGOSTO', '2854700', '', '', ''),
(885, '0102007499001', 'ASTUDILLO PALADINES PERLA MARINA', 'AV GIL RAMIREZ DAVALOS 3-89 Y FRANCISCO PIZARRO', '2805908', '', '', ''),
(886, '0101165140001', 'MAURA LUIS CORNELIO', 'Sin Nombre s/n y Cimarrones', '0991542662', '', '', ''),
(887, '0105894265001', 'CHUQUIRA RIVERA RICARDO PATRICIO', 'ABDON CALDERON', '2250539', '', '', ''),
(888, '0190372006001', '  TRANS GRUAS QUINTUÑA CIA LTDA', 'AUTOPISTA CUENCA AZOGUES S/N', '4096990', '', '', ''),
(889, '0106415565001', 'ALBARRACIN BARROS ERIKA ALEXANDRA', 'LAZARETO BARRIO YANATURO', '0959236496', '', '', ''),
(890, '0101031698001', 'Coronel Reinoso Marcia Isabel', 'Benedicto XV s/n y León XIII', '2 830196', '', '', ''),
(891, '0101702959001', 'QUEZADA ALVAREZ RAUL NECTARIO ', 'LUSPA 2-81 Y LAGARTOCOCHA', '4207235', '', '', ''),
(892, '0104271010001', 'PESANTEZ LEON RAMON PATRICIO', 'CALLE VIEJA 7-14 Y LAS ALCABALAS', '4187-540', '', '', ''),
(893, '0105259246001', 'LOJA AVILA NUBE XIMENA', 'Tarqui 9-46 y Simón Bolívar', '0995958234', '', '', ''),
(894, '0302297262001', 'BARBECHO BRAVO SANDRA LORENA', 'VIA A OCHOA LEON S/N', '2890580', '', '', ''),
(895, '0100925098001', 'ESPINOZA ROMERO BLANCA DOLORES', 'YANA URCO M-15 Y UNION NACIONAL DE EDUCADORES', '2806 356', '', '', ''),
(896, '0103232641001', 'BRITO VAZQUEZ AIDA BEATRIZ', 'Av. España s-n y Av. Gil Ramírez Dávalos', '4083505', '', '', ''),
(897, '0990018685001', 'CONAUTO C.A.', 'AV. ESPAÑA 1437 Y TURUHUAYCO', '2862263', '', '', ''),
(898, '0102109808001', 'AGUIRRE MARQUEZ FABIAN LEONARDO', 'AV. ESPAÑA 9-12 Y SEVILLA', '2808131', '', '', ''),
(899, '0190391906001', 'AUSTROPARTS CIA. LTDA.', 'AV. ESPAÑA 18-85 Y SEGOVIA', '2802053', '', '', ''),
(900, '0103933438001', 'ASTUDILLO MORALES PRISCILA ELIZABETH', 'AV. ESPAÑA 9-11 Y SEVILLA', '', '', '', ''),
(901, '0102280484001', 'SEMPERTEGUI MOROCHO JORGE LEONIDAS', 'JULIO JARAMILLO L-1 BARRIAL BLANCO', '341259', '', '', ''),
(902, '0102104775001', 'PESANTEZ LLANOS ANGEL GILBERTO', 'PATOQUINOAS S/N Y LAGARTOCOCHA', '4207021', '', '', ''),
(903, '0102275617001', 'JARA PAREDES JUAN EDMUNDO', 'DE LA VERBENA 2-15 Y DEL CEDRON', '0999701373', '', '', ''),
(904, '0101019701001', 'PALACIOS PALACIOS CESAR  EDUARDO IVAN', 'LUIS MORENO MORA S/N Y EDUARDO MALO ANDRADE', '4092085', '', '', ''),
(905, '1204537151001', 'AMAGUA YELA OSCAR FABIAN', 'CALLE ITALIA S/N  Y PORTUGAL', '0991456176', '', '', ''),
(906, '0106401532001', 'JUELA MAURICIO', 'JADAN', '0994181869', '', '', ''),
(907, '0105279665001', 'BRIONES CHASTAIN FRANCOIS SEBASTIEN', 'AV. GIL RAMIREZ DAVALOS 14-84', '4048255', '', '', ''),
(908, '0104583117001', 'AGUILAR ALVAREZ ALEXANDRA ELIZABETH', 'TURI S/N', '819 051', '', '', ''),
(909, '0102283496001', 'CORDOVA OCHOA MARCELO PATRICIO', 'AV. ESPAÑA 10-90 Y ELIA LIUT', '2863198', '', '', ''),
(910, '0791773326001', 'CONSORCIO AUTRAL - O', 'AV. LUIS ANGEL LEON ROMAN S/N KM 1 1/2', '786040.0', '', '', ''),
(911, '0101409753001', 'ARIAS ALBA', 'ANTONIO RICAURTE S/N Y JUAN STROBEL', '2890669', '', '', ''),
(912, '1708281199001', 'ENDARA MARIA ELENA', 'AV. ALTIPLANO Y CALLE SIN RETORNO', '0984254915', '', '', ''),
(913, '0105073217001', 'FIALLO DANIEL', 'MANZANA L L 246', '', '', '', ''),
(914, '0102492535001', 'GUILLERMO ORELLANA', 'ANTONIO VALLEJO 2-98', '2838601', '', '', ''),
(915, '0105863153001', 'LEON AMBROSI JOSE LUIS', 'DANIEL FERNANDEZ DE CORDOVA', '0986601369', '', '', ''),
(916, '0190390217001', 'COMPAÑIA DE TAXIS PRIMERO DE MAYO PRIMATAX S.A', 'AV. DE LAS AMERICAS S/N Y TURUHUAICO', '2340200', '', '', ''),
(917, '0103088910001', 'DELGADO  SALAZAR  PABLO TEODORO', 'Armenillas 3-34 y Calle Vieja', '2 864848', '', '', ''),
(918, '1791170393001', 'CONSTRUCTORA HIDROBO ESTRADA', 'PORTETE E13-28 Y MANUEL CAMACHO', '283763', '', '', ''),
(919, '0103069464001', 'PULLA LAURA', 'CAMINO A RACAR S/N ', '0995746253', '', '', ''),
(920, '0105492904001', 'ZAMORA  GUAMAN FRANCISCO JAVIER', 'S/N CHIQUINTAD', '2470147', '', '', ''),
(921, '0103561346001', '  ORELLANA URGILES JOSE MACARIO', 'TURUHUAICO S/N', '0994727272', '', '', ''),
(922, '0104199153001', 'BARBA NIETO MIRIAM MARLENE', 'S/N MARGINAL', ' 4131230', '', '', ''),
(923, '0104875448001', 'MATUTE BRAVO HECTOR MARCELO', 'VIA A RICAURTE S/N', '2875894', '', '', ''),
(924, '0107518896001', 'PEREZ SINCHE PAULINA ISABEL', 'SININCAY S/N', '082249.0', '', '', ''),
(925, '0401495692001', 'ENRIQUEZ RAMIREZ JAIME ANDRES', 'CAMINO A RACER S/N C. LA MERCED CASA 3', '0986963108', '', '', ''),
(926, '0104150891001', 'DELGADO QUEZADA INES VIVIANA', 'CALLE DEL RETORNO S/N Y TEOTIHUACAN', '2802273', '', '', ''),
(927, '1104165509001', 'ROBLES GRANDA MARIA SILVANA ', 'Sin Nombre s-n e Isabel Antón', '', '', '', ''),
(928, '0190368157001', 'CORPORACION DE TECNOLOGIAS DE LA INFORMACION CUATRO RIOS', 'SANTIAGO CARRASCO 1-66 Y RAFAEL BELTRAN', '4092096', '', '', ''),
(929, '0190362396001', 'SERVITUA CIA. LTDA.', 'FEDERICO MALO 1-150', '4040158', '', '', ''),
(930, '0102941051001', 'CASTRO BARROS JOSE GUSTAVO ', 'RICAURTE 5 ESQ.', '0982124027', '', '', '');
INSERT INTO `PERSONA` (`PER_ID`, `PER_CEDULA`, `PER_NOMBRE`, `PER_DIRECCION`, `PER_TELEFONO`, `PER_CELULAR`, `PER_CORREO`, `PER_SEXO`) VALUES
(931, '0301471918001', 'SIGUENCIA CALLE FRANKLIN ROLANDO', 'CAJAS 2-42 Y AV. DE LOS ANDES', '0995545520', '', '', ''),
(932, '0190402363001', 'CENTRO TERAPEUTICO INTEGRAL DON BOSCO', 'LUNTUR S/N Y DANIEL PALACIOS', '2250625', '', '', ''),
(933, '0190398811001', 'SERVICIOS EXEQUIALES GETSEMANI GEREXQ CIA. LTDA.', 'DANIEL DURAN 2-02 Y MELCHOR CHERREZ', '4209659', '', '', ''),
(934, '0106902745001', 'ALVARADO TENESACA CESAR DAVID', 'LAZARETO S/N Y YANATURO ', '4081226 ', '', '', ''),
(935, '0190325970001', 'COOPERATIVA DE AHORRO Y CREDITO INTEGRAL', 'AV. RICARDO DURAN S/N Y ANTONIO ANTE', '4024890', '', '', ''),
(936, '0101730869001', 'GARCIA GONZALO', 'ARZOBISPO SERRANO ABAD S/N ', '4088627', '', '', ''),
(937, '0102180973001', 'GUARICELA MARIA', 'GIRON CALLE ANTONIO FLOR 6-14 Y CORDOVA', '2275354', '', '', ''),
(938, '0102788635001', 'MALDONADO LOURDES', 'AV. ALTIPLANO S/N Y AV. LOS ANDES', '2865256', '', '', ''),
(939, '0190380815001', 'JULIO  CESAR VIOLA', 'ORDONEZ LASSO ', '0959680133', '', '', ''),
(940, '0190399702001', 'INSTALAUSTRO CIA. LTDA. ', 'AV. DE LAS AMERICAS Y LUIS VALENCIA', '0983322657', '', '', ''),
(941, '0102768900001', 'CHIMBO SALAZAR LUIS GUILLERMO', 'AV. DE LAS AMERICAS Y QUEBRADA DE MILCHICHIG S/N ', '0969527888', '', '', ''),
(942, '0104438718001', 'AGUILERA SANTIAGO', 'RIO AMARILLO S/N', ' 4187594', '', '', ''),
(943, '0102057734001', 'ORELLANA BERREZUETA NELLY SOLEDAD', 'JOSE RODRIGUEZ S/N Y AV ORDOÑEZ LAZO', '2849192', '', '', ''),
(944, '0301303731001', 'GARCIA VALDEZ WILSON LIZARDO', 'PANAMERICANA S/N', ' 3013633', '', '', ''),
(945, '0103643490001', 'FARFAN MUÑOZ FABIOLA GERARDINA', 'LA CASTELLANA 4-90 Y SEVILLA', '4127039', '', '', ''),
(946, '0101003382001', 'MUÑOZ CHICA MARGARITA', 'LA CASTELLANA 4-80 Y SEVILLA', '801287', '', '', ''),
(947, '0105066781001', 'BERMEO MOROCHO DARWIN FERNANDO', 'GIL RAMIREZ DAVALOS 1-141 Y LADERAS', '2867621', '', '', ''),
(948, '0190375048001', 'RELACIONES PUBLICAS DIGITALES REPUBLIDIG CIA. LTDA', 'SANTIAGO CARRASCO 1-66 Y RAFAEL TORRES', ' 2882439', '', '', ''),
(949, '0101240471001', 'MALDONADO VELEZ FANNY MERCEDES', 'LOS CIPRESES 1-65 Y AV. ORDOÑEZ LAZO', '4096861', '', '', ''),
(950, '1600118499001', 'VALLEJO BALSECA CARLOS DANIEL', 'GIL RAMIREZ DAVALOS Y TURUHUAYCO', '4088965', '', '', ''),
(951, '0102760287001', 'BRAVO CHACA  NORMA ALEXANDRA', 'REINO DE QUITO SN Y ANTISANA', '', '', '', ''),
(952, '0190419401001', 'COOPERATIVA DE AHORRO Y CREDITO MAS AHORRO SOLIDARIO MASCOOP', 'RICARDO DURAN Y ANTONIO ANTE', '4024890', '', '', ''),
(953, '0703485409001', 'VIVANCO IÑIGUEZ EDUARDO MANUEL', 'ARMENILLAS 2-90 Y AV. GIL RAMIREZ DAVALOZ', '4034533', '', '', ''),
(954, '0190417255001', 'CONSTRUCTORA PRO UNIDOS CIA. LTDA.', 'PAN DE AZUCAR L8 Y HURTADO DE MENDOZA', '2808407', '', '', ''),
(955, '0190421473001', 'GALVASUR ECUADOR CIA LTDA.', 'VIA A BAGUANCHI  KM 7 1/2 ', '4045806', '', '', ''),
(956, '0102581717001', 'ZUMBA ERNESTO', 'FRANCISCO CALDERON 2-75', '4205344', '', '', ''),
(957, '1704194149001', 'ASTUDILLO ASTUDILLO ORLANDO LUCIANO', 'AV. GIL RAMIREZ DAVALOS 3-89 Y FRANCISCO PIZARRO', '2805908', '', '', ''),
(958, '1002424818001', 'LOPEZ PALACIOS MARCO ANTONIO', 'PATRICIO GRANDA 1-92 Y PRINCESA PACHA', '0995595284', '', '', ''),
(959, '0190154688001', 'FUNDACION MENSAJEROS DE LA PAZ', 'MARISCAL SUCRE 11-60 Y TARQUI', '2837341', '', '', ''),
(960, '0190096467001', 'CORPORACION ECUATORIANA DE LICORES Y ALIMENTOS S.A. CELYASA', '9 DE MAYO 411 Y ONCEAVA NORTE ESQUINA - MACHALA', '3705700', '', '', ''),
(961, '1768161550001', 'TAME EP CUENCA', 'AV ESPAÑA', '809147', '', '', ''),
(962, '2490013760001', 'DISTRIBUIDORA DE PRODUCTOS DE CONSUMO MASIVO DISTRIK AZUAY', 'AV. GIL RAMIREZ DAVALOS S/N Y LOS PEDREGALES', '2862109', '', '', ''),
(963, '0104613922001', 'TEPAN FERNANDEZ MAGALI FERNANDA', 'S/N VIA A CUMBE', ' 2330477', '', '', ''),
(964, '0100267053001', 'BENAVIDES RODAS VICTOR GERARDO', 'MARISCAL SUCRE  4-44 Y BOLIVAR', '2250172', '', '', ''),
(965, '0190396169001', 'COMTRANSCARMEN S.A.', 'PANAMERICANA NORTE K 7 1/2 Y CALLE JULIA BERNAL', '4037937', '', '', ''),
(966, '0913984324001', 'YANEZ MORENO ELIZABETH', 'AV. GIL RAMIREZ DAVALOS S/N Y LOS PEDREGALES', '2862109', '', '', ''),
(967, '0101565711001', 'CEVALLOS ORTEGA MARIA ESPERANZA', 'CALLE DE LA BOCINA S-N Y TURUHUAICO', '2340334', '', '', ''),
(968, '0102050002001', 'CORDOVA RODAS MARCELA ', 'AUTOPISTA CUENCA AZOGUEZ S/N', '2876113', '', '', ''),
(969, '0104032958001', 'CONDOR SISALIMA ALEXANDER MARTIN', 'PANAMERICANA NORTE 7-77 Y VICTORIA DEL PORTETE ', '0998705561', '', '', ''),
(970, '0190451267001', 'KORAUTOPARTS', 'AV ESPAÑA 2-110 ENTRE NUÑEZ DE BONILLA', '0969989800', '', '', ''),
(971, '0190430235001', 'PARROQUIA ECLESIASTICA LA COMUNIDAD DE SAN PABLO', 'DEL ORIENTE S/N', ' 2870596', '', '', ''),
(972, '0101244176001', 'ROBLEZ CAMPOVERDE ANGEL POLIVIO', 'CARLOS CRESPI AV.MIRAFLORES S/N', '4087077', '', '', ''),
(973, '0104042650001', 'MOLINA SOLIS LUZ MARINA', 'SANTA MARIA DEL VERGEL AV.JULIO VERNE S/N', '0999352126', '', '', ''),
(974, '0105202964001', 'QUIZHPILEMA DIEGO', 'AV DEL TORIL Y VIA A PATAMARCA ', '0959689546', '', '', ''),
(975, '0190474976001', 'CONSORCIO UCET ', 'MIGUEL MORENO 4-15 Y ROBERTO CRESPO TORAL ', '0995170920', '', '', ''),
(976, '0301902201001', 'LEMA CONDO EFREN LEANDRO', 'BIBLIAN', '0999227838', '', '', ''),
(977, '0105344121001', 'ARMIJOS FREIRE SANDRA DANIELA ', 'AV  ESPAÑA 9-42 Y FRANCISCO PIZARRO', ' 2802377', '', '', ''),
(978, '0103674370001', 'MOGROVEJO PANAMA GERMAN BENIGNO', 'VIA A SININCAY', '0993859382', '', '', ''),
(979, '0103100509001', 'MIRANDA CHUNI JOFFRE MANUEL ', 'VIA A PASAJE KM 4 1/2 AV 25 DE JUNIO S/N', ' 2802377', '', '', ''),
(980, '0100065176001', 'CAMPOVERDE IZQUIERDO JULIO ADRIAN ', 'LA CATOLICA ARZOBISPO SERRANO 2-44 Y OBISPO DE LEON ', ' 2341439', '', '', ''),
(981, '0105317358001', 'CABRERA VELECELA MARIA VERONICA ', 'CALLE4 VIEJA S/N Y SEGUNDA Y TRANSVERSAL ', ' 4035571', '', '', ''),
(982, '0105358188001', 'PACHECO MORA KARINA ESTEFANIA ', 'AV. DE LAS AMERICAS 19-20 Y ABRAHAM SARMIENTO ', '0989402961', '', '', ''),
(983, '1751726314001', 'ARRIETA CHUCHUCAN ROBERT RAUL ', 'CALLE VIEJA 3-28 Y CABOGAN ', '0987623652', '', '', ''),
(984, '0104657994001', 'PERALTA ZUÑIGA MARCO LEONARDO', 'MUTUALISTA AZUAY I Y EL CEBOLLAR', '4082171', '', '', ''),
(985, '0103697207001', 'ORELLANA BUESTAN JORGE MARCELO', 'JAIME ROLDOS Y 9 DE OCTUBRE', '0980909676', '', '', ''),
(986, '0101801330001', 'ILLESCAS CRIOLLO ROSA TARGELIA', 'VIA AL VALLE', '0968065886', '', '', ''),
(987, '0190473325001', 'CONSORCIO PC REDES', 'REINO DE QUITO 1-82 Y AV. GONZALEZ SUAREZ', '4058844', '', '', ''),
(988, '0190475166001', 'CONSORCIO MARIN-CADMECORP ASOCIADOS S.A.', 'CALLE A', '074077274', '', '', ''),
(989, '0103187407001', 'DOMINGUEZ PANZA JORGE BENIGNO', 'SANTIAGO Y MEDELLIN', '0958749682', '', '', ''),
(990, '0190359131001', 'ASIAN AMERICAN SCHOOL', 'AUTOPISTA CUENCA AZOGUES', '4041813', '', '', ''),
(991, '0102623295001', 'AREVALO PESANTEZ JOSE ALFREDO', 'CALLE VIEJA 4-125 Y CALLE DEL CHORRO', '0961373778', '', '', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `PRODUCTO`
--

DROP TABLE IF EXISTS `PRODUCTO`;
CREATE TABLE `PRODUCTO` (
  `PRO_ID` int(11) NOT NULL,
  `PRO_NOMBRE` varchar(50) DEFAULT NULL,
  `PRO_DESCRIPCION` varchar(50) DEFAULT NULL,
  `PRO_PRECIO_COSTO` double DEFAULT NULL,
  `PRO_PRECIO_VENTA` double DEFAULT NULL,
  `PRO_STOCK` int(11) DEFAULT NULL,
  `PRO_STOCK_MINIMO` int(11) DEFAULT NULL,
  `PRO_ESTADO` tinyint(4) DEFAULT NULL,
  `CAT_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `PRODUCTO`
--

INSERT INTO `PRODUCTO` (`PRO_ID`, `PRO_NOMBRE`, `PRO_DESCRIPCION`, `PRO_PRECIO_COSTO`, `PRO_PRECIO_VENTA`, `PRO_STOCK`, `PRO_STOCK_MINIMO`, `PRO_ESTADO`, `CAT_ID`) VALUES
(1, '1 BLOCK 1/4 OFICIO QUIMICO', 'BLOCK FACTURAS 1/4 OFICIO QUIMICO UNA COPIA', 8.08, 13.6, 101, 1, 1, 41),
(2, '2 BLOCK FACTURAS 1/4 OFICIO QUIMICO UNA COPIA', 'BLOCK FACTURAS 1/4 OFICIO QUIMICO UNA COPIA', 5.57, 9.35, 97, 1, 1, 41);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `PROVEEDOR`
--

DROP TABLE IF EXISTS `PROVEEDOR`;
CREATE TABLE `PROVEEDOR` (
  `PER_ID` int(11) NOT NULL,
  `PROV_FECHA_REGISTRO` datetime DEFAULT NULL,
  `PROV_OBSERVACION` varchar(300) DEFAULT NULL,
  `PROV_ESTADO` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `PROVEEDOR`
--

INSERT INTO `PROVEEDOR` (`PER_ID`, `PROV_FECHA_REGISTRO`, `PROV_OBSERVACION`, `PROV_ESTADO`) VALUES
(2, '2019-03-06 00:00:00', 'proveedor potencial', 1),
(5, '2019-05-07 00:00:00', '', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `REPARACION`
--

DROP TABLE IF EXISTS `REPARACION`;
CREATE TABLE `REPARACION` (
  `REP_ID` int(9) NOT NULL,
  `PER_ID` int(9) NOT NULL,
  `FECHA` datetime NOT NULL,
  `IMEI` varchar(20) NOT NULL,
  `MARCA` varchar(50) NOT NULL,
  `FECHA_DE_ENTREGA` datetime NOT NULL,
  `BATERIA` tinyint(1) NOT NULL,
  `CHIP` tinyint(1) NOT NULL,
  `MEMORIA` tinyint(1) NOT NULL,
  `TAPA` tinyint(1) NOT NULL,
  `CARGADOR` tinyint(1) NOT NULL,
  `OTROS` varchar(50) NOT NULL,
  `DIAGNOSTICO` text NOT NULL,
  `TOTAL` double NOT NULL,
  `ABONO` double NOT NULL,
  `SALDO` double NOT NULL,
  `ESTADO` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `REPARACION`
--

INSERT INTO `REPARACION` (`REP_ID`, `PER_ID`, `FECHA`, `IMEI`, `MARCA`, `FECHA_DE_ENTREGA`, `BATERIA`, `CHIP`, `MEMORIA`, `TAPA`, `CARGADOR`, `OTROS`, `DIAGNOSTICO`, `TOTAL`, `ABONO`, `SALDO`, `ESTADO`) VALUES
(1, 7, '2019-06-05 20:55:42', '', '', '2019-06-12 00:00:00', 0, 0, 0, 0, 0, 'asdf', 'asdf', 20, 10, 10, 1),
(2, 16, '2019-06-05 21:13:03', '01651610650', 'samsung', '2019-06-28 00:00:00', 1, 1, 1, 1, 1, 'asdf', 'asdfasdf', 50, 10, 40, 1),
(3, 14, '2019-06-05 22:34:42', '0101010101', 'SAMSUNG', '2019-06-30 00:00:00', 1, 0, 1, 0, 1, 'USB', 'PANTALLA ROTA, COMPRA NUEVA PANTALLA LUEGO CAMBIAR Y REVIASAR ESTADO DE LOS PARLANTES ADEMAS\nREVISAR SI ESTA BIEN LOS PUERTOS DE SALIDA DE AUDIO Y CAMBIAR BATERIA JUNTO CON EL TECLADO COMPRAR\nTECLADO Y REVISAR SI ESTA CORRECTO EL FUNCIONAMIENTO', 100, 50, 50, 1),
(4, 126, '2019-06-05 22:47:42', '020200211651', 'NOKIA', '2019-06-30 00:00:00', 1, 0, 0, 1, 0, 'USB', 'CAMBIAR PANTALLA', 80, 40, 40, 1),
(5, 66, '2019-06-05 22:50:14', '6161651', 'HUAWEI', '2019-06-29 00:00:00', 1, 0, 0, 1, 0, '', 'CAMBIAR GLAS', 30, 15, 15, 1),
(6, 11, '2019-06-06 23:49:34', '13241234', 'SAMSUNG', '2019-06-30 00:00:00', 1, 0, 0, 1, 0, 'USB', 'CAMBIAR PANTALLA', 80, 30, 50, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TIPO_USUARIO`
--

DROP TABLE IF EXISTS `TIPO_USUARIO`;
CREATE TABLE `TIPO_USUARIO` (
  `TIP_USU_ID` int(11) NOT NULL,
  `TIP_USU_DESCRIPCION` varchar(50) NOT NULL,
  `TIP_USU_PRODUCTO` tinyint(1) DEFAULT NULL,
  `TIP_USU_MERCADERIA` tinyint(1) NOT NULL,
  `TIP_USU_COMPRAS` tinyint(1) NOT NULL,
  `TIP_USU_PROVEEDORES` tinyint(1) NOT NULL,
  `TIP_USU_VENTA` tinyint(4) DEFAULT NULL,
  `TIP_USU_CLIENTES` tinyint(1) NOT NULL,
  `TIP_USU_VERIFICAR_PRODUCTO` tinyint(1) NOT NULL,
  `TIP_USU_VENTAS_REALIZADAS` tinyint(1) NOT NULL,
  `TIP_USU_VENTAS_DETALLADAS` tinyint(1) NOT NULL,
  `TIP_USU_ESTADISTICA_MENSUAL` tinyint(1) NOT NULL,
  `TIP_USU_COMPRAS_REALIZADAS` tinyint(1) NOT NULL,
  `TIP_USU_COMPRAS_DETALLADAS` tinyint(1) NOT NULL,
  `TIP_USU_EMPLEADOS` tinyint(1) NOT NULL,
  `TIP_USU_TIPO_DE_USUARIO` tinyint(1) NOT NULL,
  `TIP_USU_SERVICIO_TECNICO` tinyint(1) NOT NULL,
  `TIP_USU_ANULAR_VENTA` tinyint(1) NOT NULL,
  `TIP_USU_ANULAR_COMPRA` tinyint(1) NOT NULL,
  `TIP_USU_CAMBIAR_CONTRASEÑA` tinyint(1) NOT NULL,
  `TIP_USU_USUARIOS` tinyint(1) NOT NULL,
  `TIP_USU_RESPALDAR_BD` tinyint(1) NOT NULL,
  `TIP_USU_RESTAURAR_BD` tinyint(1) NOT NULL,
  `TIP_USU_ESTADO` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `TIPO_USUARIO`
--

INSERT INTO `TIPO_USUARIO` (`TIP_USU_ID`, `TIP_USU_DESCRIPCION`, `TIP_USU_PRODUCTO`, `TIP_USU_MERCADERIA`, `TIP_USU_COMPRAS`, `TIP_USU_PROVEEDORES`, `TIP_USU_VENTA`, `TIP_USU_CLIENTES`, `TIP_USU_VERIFICAR_PRODUCTO`, `TIP_USU_VENTAS_REALIZADAS`, `TIP_USU_VENTAS_DETALLADAS`, `TIP_USU_ESTADISTICA_MENSUAL`, `TIP_USU_COMPRAS_REALIZADAS`, `TIP_USU_COMPRAS_DETALLADAS`, `TIP_USU_EMPLEADOS`, `TIP_USU_TIPO_DE_USUARIO`, `TIP_USU_SERVICIO_TECNICO`, `TIP_USU_ANULAR_VENTA`, `TIP_USU_ANULAR_COMPRA`, `TIP_USU_CAMBIAR_CONTRASEÑA`, `TIP_USU_USUARIOS`, `TIP_USU_RESPALDAR_BD`, `TIP_USU_RESTAURAR_BD`, `TIP_USU_ESTADO`) VALUES
(1, 'ADMINISTRADOR', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
(2, 'vendedor 1', 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `USUARIO`
--

DROP TABLE IF EXISTS `USUARIO`;
CREATE TABLE `USUARIO` (
  `PER_ID` int(11) NOT NULL,
  `USU_NOMBRE_USUARIO` varchar(50) NOT NULL,
  `USU_CLAVE` varchar(200) NOT NULL,
  `USU_SUELDO` double NOT NULL,
  `USU_FECHA_NACIMIENTO` date NOT NULL,
  `USU_FECHA_INGRESO` datetime NOT NULL,
  `TIP_USU_ID` int(11) NOT NULL,
  `USU_ESTADO` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `USUARIO`
--

INSERT INTO `USUARIO` (`PER_ID`, `USU_NOMBRE_USUARIO`, `USU_CLAVE`, `USU_SUELDO`, `USU_FECHA_NACIMIENTO`, `USU_FECHA_INGRESO`, `TIP_USU_ID`, `USU_ESTADO`) VALUES
(1, 'admin', '8WbrFudV+9s=', 400, '2018-11-01', '2018-11-01 00:00:00', 1, 1),
(6, 'ma', 'ako43znBWG8=', 600, '1983-03-29', '2019-05-13 00:00:00', 2, 1);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vistacomprasaldetalle`
-- (Véase abajo para la vista actual)
--
DROP VIEW IF EXISTS `vistacomprasaldetalle`;
CREATE TABLE `vistacomprasaldetalle` (
`PRO_ID` int(11)
,`COM_CAB_FECHA` datetime
,`PRO_NOMBRE` varchar(50)
,`CAT_DESCRIPCION` varchar(50)
,`COM_DET_CATIDAD` int(11)
,`COM_DET_VALOR` double
,`COM_DET_TOTAL` double
,`COM_CAB_ESTADO` tinyint(4)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vistafacturasaldetalle`
-- (Véase abajo para la vista actual)
--
DROP VIEW IF EXISTS `vistafacturasaldetalle`;
CREATE TABLE `vistafacturasaldetalle` (
`PRO_ID` int(6)
,`FAC_CAB_FECHA` datetime
,`PRO_NOMBRE` varchar(50)
,`CAT_DESCRIPCION` varchar(50)
,`FAC_DET_CANTIDAD` int(6)
,`FAC_DET_PVP` double
,`FAC_DET_DESCUENTO` double
,`FAC_DET_TOTAL` double
,`FAC_DET_GANANCIA` double(19,2)
);

-- --------------------------------------------------------

--
-- Estructura para la vista `vistacomprasaldetalle`
--
DROP TABLE IF EXISTS `vistacomprasaldetalle`;

CREATE ALGORITHM=UNDEFINED DEFINER=`jaime`@`localhost` SQL SECURITY DEFINER VIEW `vistacomprasaldetalle`  AS  select `CD`.`PRO_ID` AS `PRO_ID`,`CC`.`COM_CAB_FECHA` AS `COM_CAB_FECHA`,`P`.`PRO_NOMBRE` AS `PRO_NOMBRE`,`C`.`CAT_DESCRIPCION` AS `CAT_DESCRIPCION`,`CD`.`COM_DET_CATIDAD` AS `COM_DET_CATIDAD`,`CD`.`COM_DET_VALOR` AS `COM_DET_VALOR`,`CD`.`COM_DET_TOTAL` AS `COM_DET_TOTAL`,`CC`.`COM_CAB_ESTADO` AS `COM_CAB_ESTADO` from (((`compras_detalle` `CD` join `producto` `P` on((`P`.`PRO_ID` = `CD`.`PRO_ID`))) join `categoria` `C` on((`C`.`CAT_ID` = `P`.`CAT_ID`))) join `compras_cab` `CC` on((`CC`.`COM_CAB_ID` = `CD`.`COM_CAB_ID`))) where (`CC`.`COM_CAB_ESTADO` = 1) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vistafacturasaldetalle`
--
DROP TABLE IF EXISTS `vistafacturasaldetalle`;

CREATE ALGORITHM=UNDEFINED DEFINER=`jaime`@`localhost` SQL SECURITY DEFINER VIEW `vistafacturasaldetalle`  AS  select `FD`.`PRO_ID` AS `PRO_ID`,`FC`.`FAC_CAB_FECHA` AS `FAC_CAB_FECHA`,`P`.`PRO_NOMBRE` AS `PRO_NOMBRE`,`C`.`CAT_DESCRIPCION` AS `CAT_DESCRIPCION`,`FD`.`FAC_DET_CANTIDAD` AS `FAC_DET_CANTIDAD`,`FD`.`FAC_DET_PVP` AS `FAC_DET_PVP`,`FD`.`FAC_DET_DESCUENTO` AS `FAC_DET_DESCUENTO`,`FD`.`FAC_DET_TOTAL` AS `FAC_DET_TOTAL`,round((`FD`.`FAC_DET_TOTAL` - `FD`.`FAC_DET_PC`),2) AS `FAC_DET_GANANCIA` from (((`factura_detalle` `FD` join `producto` `P` on((`P`.`PRO_ID` = `FD`.`PRO_ID`))) join `categoria` `C` on((`C`.`CAT_ID` = `P`.`CAT_ID`))) join `factura_cab` `FC` on((`FC`.`FAC_CAB_ID` = `FD`.`FAC_CAB_ID`))) where (`FC`.`FAC_CAB_ESTADO` = 1) ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `CATEGORIA`
--
ALTER TABLE `CATEGORIA`
  ADD PRIMARY KEY (`CAT_ID`);

--
-- Indices de la tabla `CLIENTE`
--
ALTER TABLE `CLIENTE`
  ADD PRIMARY KEY (`PER_ID`),
  ADD KEY `PER_ID` (`PER_ID`);

--
-- Indices de la tabla `COMPRAS_CAB`
--
ALTER TABLE `COMPRAS_CAB`
  ADD PRIMARY KEY (`COM_CAB_ID`),
  ADD KEY `PER_ID` (`COM_CAB_PROVEEDOR_ID`),
  ADD KEY `COM_CAB_USUARIO_ID` (`COM_CAB_USUARIO_ID`);

--
-- Indices de la tabla `COMPRAS_DETALLE`
--
ALTER TABLE `COMPRAS_DETALLE`
  ADD PRIMARY KEY (`COM_DET_ID`),
  ADD KEY `COM_CAB_ID` (`COM_CAB_ID`),
  ADD KEY `PRO_ID` (`PRO_ID`);

--
-- Indices de la tabla `FACTURA_CAB`
--
ALTER TABLE `FACTURA_CAB`
  ADD PRIMARY KEY (`FAC_CAB_ID`),
  ADD KEY `PER_ID` (`PER_ID`),
  ADD KEY `USUARIO_ID` (`USUARIO_ID`);

--
-- Indices de la tabla `FACTURA_DETALLE`
--
ALTER TABLE `FACTURA_DETALLE`
  ADD PRIMARY KEY (`FAC_DET_ID`),
  ADD KEY `FAC_CAB_ID` (`FAC_CAB_ID`),
  ADD KEY `PRO_ID` (`PRO_ID`);

--
-- Indices de la tabla `KARDEX`
--
ALTER TABLE `KARDEX`
  ADD PRIMARY KEY (`KAR_ID`),
  ADD KEY `PRO_ID` (`PRO_ID`);

--
-- Indices de la tabla `NOTA_CAB`
--
ALTER TABLE `NOTA_CAB`
  ADD PRIMARY KEY (`NOT_CAB_ID`),
  ADD KEY `PER_ID` (`PER_ID`),
  ADD KEY `USUARIO_ID` (`USUARIO_ID`);

--
-- Indices de la tabla `NOTA_DETALLE`
--
ALTER TABLE `NOTA_DETALLE`
  ADD PRIMARY KEY (`NOT_DET_ID`),
  ADD KEY `NOT_CAB_ID` (`NOT_CAB_ID`),
  ADD KEY `PRO_ID` (`PRO_ID`);

--
-- Indices de la tabla `PERSONA`
--
ALTER TABLE `PERSONA`
  ADD PRIMARY KEY (`PER_ID`),
  ADD UNIQUE KEY `PER_CEDULA` (`PER_CEDULA`);

--
-- Indices de la tabla `PRODUCTO`
--
ALTER TABLE `PRODUCTO`
  ADD PRIMARY KEY (`PRO_ID`),
  ADD KEY `CAT_ID` (`CAT_ID`);

--
-- Indices de la tabla `PROVEEDOR`
--
ALTER TABLE `PROVEEDOR`
  ADD PRIMARY KEY (`PER_ID`),
  ADD KEY `PER_ID` (`PER_ID`);

--
-- Indices de la tabla `REPARACION`
--
ALTER TABLE `REPARACION`
  ADD PRIMARY KEY (`REP_ID`),
  ADD KEY `PER_ID` (`PER_ID`);

--
-- Indices de la tabla `TIPO_USUARIO`
--
ALTER TABLE `TIPO_USUARIO`
  ADD PRIMARY KEY (`TIP_USU_ID`),
  ADD UNIQUE KEY `TIP_USU_DESCRIPCION` (`TIP_USU_DESCRIPCION`);

--
-- Indices de la tabla `USUARIO`
--
ALTER TABLE `USUARIO`
  ADD PRIMARY KEY (`PER_ID`),
  ADD UNIQUE KEY `USU_NOMBRE_USUARIO` (`USU_NOMBRE_USUARIO`),
  ADD KEY `TIP_USU_ID` (`TIP_USU_ID`),
  ADD KEY `PER_ID` (`PER_ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `CATEGORIA`
--
ALTER TABLE `CATEGORIA`
  MODIFY `CAT_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT de la tabla `COMPRAS_DETALLE`
--
ALTER TABLE `COMPRAS_DETALLE`
  MODIFY `COM_DET_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `FACTURA_DETALLE`
--
ALTER TABLE `FACTURA_DETALLE`
  MODIFY `FAC_DET_ID` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `KARDEX`
--
ALTER TABLE `KARDEX`
  MODIFY `KAR_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=163;

--
-- AUTO_INCREMENT de la tabla `NOTA_DETALLE`
--
ALTER TABLE `NOTA_DETALLE`
  MODIFY `NOT_DET_ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `PERSONA`
--
ALTER TABLE `PERSONA`
  MODIFY `PER_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=992;

--
-- AUTO_INCREMENT de la tabla `PRODUCTO`
--
ALTER TABLE `PRODUCTO`
  MODIFY `PRO_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `CLIENTE`
--
ALTER TABLE `CLIENTE`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`PER_ID`) REFERENCES `PERSONA` (`PER_ID`);

--
-- Filtros para la tabla `COMPRAS_CAB`
--
ALTER TABLE `COMPRAS_CAB`
  ADD CONSTRAINT `compras_cab_ibfk_1` FOREIGN KEY (`COM_CAB_PROVEEDOR_ID`) REFERENCES `PROVEEDOR` (`PER_ID`),
  ADD CONSTRAINT `compras_cab_ibfk_2` FOREIGN KEY (`COM_CAB_USUARIO_ID`) REFERENCES `USUARIO` (`PER_ID`);

--
-- Filtros para la tabla `COMPRAS_DETALLE`
--
ALTER TABLE `COMPRAS_DETALLE`
  ADD CONSTRAINT `compras_detalle_ibfk_1` FOREIGN KEY (`COM_CAB_ID`) REFERENCES `COMPRAS_CAB` (`COM_CAB_ID`),
  ADD CONSTRAINT `compras_detalle_ibfk_2` FOREIGN KEY (`PRO_ID`) REFERENCES `PRODUCTO` (`PRO_ID`);

--
-- Filtros para la tabla `FACTURA_CAB`
--
ALTER TABLE `FACTURA_CAB`
  ADD CONSTRAINT `factura_cab_ibfk_1` FOREIGN KEY (`PER_ID`) REFERENCES `CLIENTE` (`PER_ID`),
  ADD CONSTRAINT `factura_cab_ibfk_2` FOREIGN KEY (`USUARIO_ID`) REFERENCES `USUARIO` (`PER_ID`);

--
-- Filtros para la tabla `FACTURA_DETALLE`
--
ALTER TABLE `FACTURA_DETALLE`
  ADD CONSTRAINT `factura_detalle_ibfk_1` FOREIGN KEY (`FAC_CAB_ID`) REFERENCES `FACTURA_CAB` (`FAC_CAB_ID`),
  ADD CONSTRAINT `factura_detalle_ibfk_2` FOREIGN KEY (`PRO_ID`) REFERENCES `PRODUCTO` (`PRO_ID`);

--
-- Filtros para la tabla `KARDEX`
--
ALTER TABLE `KARDEX`
  ADD CONSTRAINT `kardex_ibfk_1` FOREIGN KEY (`PRO_ID`) REFERENCES `PRODUCTO` (`PRO_ID`);

--
-- Filtros para la tabla `NOTA_CAB`
--
ALTER TABLE `NOTA_CAB`
  ADD CONSTRAINT `nota_cab_ibfk_1` FOREIGN KEY (`PER_ID`) REFERENCES `PERSONA` (`PER_ID`),
  ADD CONSTRAINT `nota_cab_ibfk_2` FOREIGN KEY (`USUARIO_ID`) REFERENCES `USUARIO` (`PER_ID`);

--
-- Filtros para la tabla `NOTA_DETALLE`
--
ALTER TABLE `NOTA_DETALLE`
  ADD CONSTRAINT `nota_detalle_ibfk_1` FOREIGN KEY (`NOT_CAB_ID`) REFERENCES `NOTA_CAB` (`NOT_CAB_ID`),
  ADD CONSTRAINT `nota_detalle_ibfk_2` FOREIGN KEY (`PRO_ID`) REFERENCES `PRODUCTO` (`PRO_ID`);

--
-- Filtros para la tabla `PRODUCTO`
--
ALTER TABLE `PRODUCTO`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`CAT_ID`) REFERENCES `CATEGORIA` (`CAT_ID`);

--
-- Filtros para la tabla `PROVEEDOR`
--
ALTER TABLE `PROVEEDOR`
  ADD CONSTRAINT `proveedor_ibfk_1` FOREIGN KEY (`PER_ID`) REFERENCES `PERSONA` (`PER_ID`);

--
-- Filtros para la tabla `REPARACION`
--
ALTER TABLE `REPARACION`
  ADD CONSTRAINT `reparacion_ibfk_1` FOREIGN KEY (`PER_ID`) REFERENCES `PERSONA` (`PER_ID`);

--
-- Filtros para la tabla `USUARIO`
--
ALTER TABLE `USUARIO`
  ADD CONSTRAINT `usuario_ibfk_2` FOREIGN KEY (`PER_ID`) REFERENCES `PERSONA` (`PER_ID`),
  ADD CONSTRAINT `usuario_ibfk_3` FOREIGN KEY (`TIP_USU_ID`) REFERENCES `TIPO_USUARIO` (`TIP_USU_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
