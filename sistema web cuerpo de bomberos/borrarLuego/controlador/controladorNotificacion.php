<?php

switch ($_REQUEST['funcion']) {
    case 'registrar':        
        
        require '../dao/NotificacionDAO.php'; 
        require '../clases/Notificacion.php';
        require '../metodos.php';
        $metodos=new metodos();
        
        
        session_start();
        
       
        $fecha_notificacion=$metodos->getFechaHora();
        $num_notificacion=$_POST['numnoti'];
        $direccion=$_POST['direccion'];
        $extintor=filter_input(INPUT_POST, 'extintor', FILTER_VALIDATE_BOOLEAN);
        $inst_electricas=filter_input(INPUT_POST, 'instaele', FILTER_VALIDATE_BOOLEAN);
        $recipientes=filter_input(INPUT_POST, 'recipi', FILTER_VALIDATE_BOOLEAN);
        $mater_combust=filter_input(INPUT_POST, 'mate', FILTER_VALIDATE_BOOLEAN);
        $otros=$_POST['otros'];
        $fecha_limite=$metodos->getfechaMas3meses();
        $estado='P'; //VALIDAR SI ESTA PENDIENTE O ESTA COMPLETADO
        $latitud=$_POST['latitud'];
        $longitud=$_POST['longitud'];
        $observaciones=$_POST['obserba'];
        $idcontribuyente=$_POST['idcontr'];
        $usuarios_idusuarios=$_SESSION['idusuarios'];
        
        $clase=new Notificacion(
                $fecha_notificacion, 
                $num_notificacion, 
                $direccion, 
                $extintor, 
                $inst_electricas, 
                $recipientes, 
                $mater_combust, 
                $otros, 
                $fecha_limite, 
                $estado, 
                $latitud, 
                $longitud, 
                $observaciones,
                $idcontribuyente, 
                $usuarios_idusuarios
                );
        
                $fecha_notificacion.' '.
                $num_notificacion.' '.
                $direccion.' '. 
                $extintor.' '. 
                $inst_electricas.' '. 
                $recipientes.' '. 
                $mater_combust.' '. 
                $otros.' '. 
                $fecha_limite.' '. 
                $estado.' '. 
                $latitud.' '. 
                $longitud.' '. 
                $observaciones.' '.
                $idcontribuyente.' '. 
                $usuarios_idusuarios;
        
            $dao= new NotificacionDAO();
            $dao->crear($clase);
        break;

    default:
        break;
}