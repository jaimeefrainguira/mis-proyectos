<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of NtificacionDAO
 *
 * @author jaimeguiracocha
 */
class NotificacionDAO {
    public function crear(\Notificacion $clase)
    {
        require '../basedatos/conexion.php';
        $fecha_notificacion=$clase->getFecha_notificacion();
        $num_notificacion=$clase->getNum_notificacion();
        $direccion=$clase->getDireccion();
        $extintor=$clase->getExtintor();
        $inst_electricas=$clase->getInst_electricas();
        $recipientes=$clase->getRecipientes();
        $mater_combust=$clase->getMater_combust();
        $otros=$clase->getOtros();
        $fecha_limite=$clase->getFecha_limite();
        $estado=$clase->getEstado();
        $latitud=$clase->getLatitud();
        $longitud=$clase->getLongitud();
        $observaciones=$clase->getObservaciones();
        $idcontribuyente=$clase->getIdcontribuyente();
        $usuarios_idusuarios=$clase->getUsuarios_idusuarios();
        
        
        


        
        $sql ="CALL `bomberos`.`notificacionProcedimiento`(
            '".$fecha_notificacion."', 
            '".$num_notificacion."', 
           '". $direccion."',  
           '". $extintor."', 
            '".$inst_electricas."',  
           '". $recipientes."',   
           '". $mater_combust."', 
            '".$otros."', 
            '".$fecha_limite."', 
            '". $estado."', 
            '".$latitud."',   
            '".$longitud."', 
            '".$observaciones."',   
            '".$idcontribuyente."',   
            '".$usuarios_idusuarios."', 
            '".'CREAR'."');";
        $result= mysqli_query($mysqli, $sql);  
        mysqli_close($mysqli);
    }
}
