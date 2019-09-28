<?php

class ContribuyenteDAO 
{
    public $dato;
    public function registrar(\Contribuyente $contribuyente) {
        
        require './conexion.php';
//CALL contribuyenteProcedimiento
//('0101863405', 'CEDULA', 'JAIME', 'MAYANCELA', '888888', 'JAIME@', '2019-06-16 00:00:00', 'N','20', '2019-06-17 00:00:00', '5', 'P', '1','DETALLE');
        $idcontribuyente=$contribuyente->getIdcontribuyente();
        $tipo_documento=$contribuyente->getTipo_documento();
        $razon_social=$contribuyente->getRazon_social();
        $direccion=$contribuyente->getDireccion();
        $telefono=$contribuyente->getTelefono();
        $email=$contribuyente->getEmail();
        $fecha_ingreso=$contribuyente->getFecha_ingreso();
        $especial=$contribuyente->getEspecial();
        $patente=$contribuyente->getPatente();
        $fecha_importacion=$contribuyente->getFecha_importacion();
        $valor=$contribuyente->getValor();
        $estado=$contribuyente->getEstado();
        $idusuarios=$contribuyente->getIdusuarios();      
        
        $sql="CALL contribuyenteProcedimiento("
                . "'$idcontribuyente', "
                . "'$tipo_documento', "
                . "'$razon_social', "
                . "'$direccion', "
                . "'$telefono', "
                . "'$email', "
                . "'$fecha_ingreso', "
                . "'$especial',"
                . "'$patente', "
                . "'$fecha_importacion', "
                . "'$valor', "
                . "'$estado', "
                . "'$idusuarios',"
                . "'CREAR');";
        
        $result= mysqli_query($mysqli, $sql);        
        if (mysqli_errno($mysqli) == 1062) {
            $sql="CALL contribuyenteProcedimiento("
                . "'$idcontribuyente', "
                . "'$tipo_documento', "
                . "'$razon_social', "
                . "'$direccion', "
                . "'$telefono', "
                . "'$email', "
                . "'$fecha_ingreso', "
                . "'$especial',"
                . "'$patente', "
                . "'$fecha_importacion', "
                . "'$valor', "
                . "'$estado', "
                . "'$idusuarios',"
                . "'DETALLE');";
            $result= mysqli_query($mysqli, $sql);
        }
        mysqli_close($mysqli);        
    }

    public function consultarById($cedula) {
        session_start();
        require_once '../metodos.php';
        
        $metodos=new metodos();
        $anio=$metodos->getAnio();
        require '../basedatos/conexion.php';
        $sql="CALL buscarContribuyente('$cedula','$anio');";
        $result= mysqli_query($mysqli, $sql);        
        $this->dato=$result->num_rows;
        $datos=array();        
        while ($ver= mysqli_fetch_row($result))
        {
            $clase=new Contribuyente();
            
            $clase->__Contribuyente($ver[0], $ver[1], $ver[2], $ver[3], $ver[4], $ver[5], $ver[6], $ver[7],$ver[8],$ver[9],$ver[10],$ver[11],$_SESSION['idusuarios']);            
            $datos[]=$clase;           
        }
        mysqli_close($mysqli);
        return $datos; 
    }

    public function actualizar(\Contribuyente $contribuyente) {
        
        require '../basedatos/conexion.php';
//CALL contribuyenteProcedimiento
//('0101863405', 'CEDULA', 'JAIME', 'MAYANCELA', '888888', 'JAIME@', '2019-06-16 00:00:00', 'N','20', '2019-06-17 00:00:00', '5', 'P', '1','DETALLE');
        $idcontribuyente=$contribuyente->getIdcontribuyente();
        $tipo_documento=$contribuyente->getTipo_documento();
        $razon_social=$contribuyente->getRazon_social();
        $direccion=$contribuyente->getDireccion();
        $telefono=$contribuyente->getTelefono();
        $email=$contribuyente->getEmail();
        $fecha_ingreso=$contribuyente->getFecha_ingreso();
        $especial=$contribuyente->getEspecial();
        $patente=$contribuyente->getPatente();
        $fecha_importacion=$contribuyente->getFecha_importacion();
        $valor=$contribuyente->getValor();
        $estado=$contribuyente->getEstado();
        $idusuarios=$contribuyente->getIdusuarios();      
        
        $sql="CALL contribuyenteProcedimiento("
                . "'$idcontribuyente', "
                . "'$tipo_documento', "
                . "'$razon_social', "
                . "'$direccion', "
                . "'$telefono', "
                . "'$email', "
                . "'$fecha_ingreso', "
                . "'$especial',"
                . "'$patente', "
                . "'$fecha_importacion', "
                . "'$valor', "
                . "'$estado', "
                . "'$idusuarios',"
                . "'ACTUALIZA');";
        
        $result= mysqli_query($mysqli, $sql); 
        
        
        mysqli_close($mysqli); 
    }

}
