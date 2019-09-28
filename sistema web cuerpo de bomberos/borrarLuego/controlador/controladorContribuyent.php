<?php

require './borrarLuego/dao/ContribuyenteDAO.php';
class controladorContribuyent {
   //put your code here
    function registraContribuyente(\Contribuyente $contribuyente)
    {
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
        require './vista/vistas.php';
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
     
}
