<?php


$caso=$_REQUEST['funcion'];

switch ($caso)
{
    case 'cargarRegistro':
        require '../dao/ContribuyenteDAO.php';
        $cedula=$_POST['idcontribuyente']; 
        require '../clases/Contribuyente.php';
        consultaByID($cedula);
        
    break;

    case 'extraerRegistro':
        require '../clases/Contribuyente.php';
        $cedula=$_POST['idgetcontri'];
        $datos=obtenerDatos($cedula);
	echo json_encode($datos);        
    break;

    case 'actualizar':
        $cedula=$_POST['idgetcontri'];
        $Razon_social=$_POST['Razon_social'];
        $direccion=$_POST['direccion'];
        $telefono=$_POST['telefono'];
        $email=$_POST['email'];
        
        require '../clases/Contribuyente.php';
        require '../dao/ContribuyenteDAO.php';
        $contribuyente=new Contribuyente();
                     $contribuyente->__Contribuyente(
                        $cedula, 
                        '', 
                        $Razon_social, 
                        $direccion, 
                        $telefono, 
                        $email, 
                        '', 
                        '', 
                        '',
                        '',
                        '',
                        '',
                        ''); 
        actualizar($contribuyente);
        consultaByID($cedula);
    break;

}


    
    //put your code here
    function registraContribuyente(\Contribuyente $contribuyente)
    {
        require './dao/ContribuyenteDAO.php';
        $return=true;
        $dao=new ContribuyenteDAO();
        $dao->registrar($contribuyente);

//        switch ($dao->dato) 
//        {
//            case 0:
//                $return=false;
//                break;    
//            default :
//                $tabla=new vistaUsuario();
//                $tabla->tabla($arreglo_Usuarios);
//                break;
//        }
        
        return $return;
    }
     function consultaByID($cedula)
    {
        require '../vista/vistas.php';
        $dao=new ContribuyenteDAO();
        $arrayClass=$dao->consultarById($cedula);
        switch ($dao->dato) 
        {
            case 0:
                $return=false;
                break;    
            default :
                $tabla=new vistas();
                $tabla->verContribuyente($arrayClass);
                break;
        }
    }
     function obtenerDatos($cedula)
    {
        require '../dao/ContribuyenteDAO.php';
        $dao=new ContribuyenteDAO();
        $arrayClass=$dao->consultarById($cedula);
        
        $datos=array();
        
        foreach ($arrayClass as $key => $value) {
            $datos['idgetcontri']=$value->getIdcontribuyente();
            $datos['Razon_social']=$value->getRazon_social();
            $datos['direccion']=$value->getDireccion();
            $datos['telefono']=$value->getTelefono();
            $datos['email']=$value->getEmail();            
            		
        }
        return $datos;
    }
    function actualizar(\Contribuyente $contribuyente)
    {       
        $dao=new ContribuyenteDAO();        
        $dao->actualizar($contribuyente);
    }

