<?php
//require './dao/UsuarioDAO.php';
//require './vista/vistas.php';
$caso=$_REQUEST['funcion'];



switch ($caso)
{
    case 'ingresar':
        $usuario=$_POST['usuario'];
        $password=$_POST['password'];
        iniciarSesion($usuario, $password);
//        echo '<script type="text/javascript">
//window.location="./notificador.php";
//</script>';
        
    break;

    case 'extraerRegistro':
       
    break;

    case 'actualizar':
       
    break;

}

function regi(\Usuario $usuario) 
{            
//        $mo=new UsuarioDAO();
//        $mo->registrar($usuario);
}
function iniciarSesion($usuario, $clave)
{
    require '../dao/UsuarioDAO.php';
    $mo=new UsuarioDAO();
    $valor=$mo->iniciarSesion($usuario, $clave);
    switch ($valor)
    {
        case 0:
            echo '<br><div class="alert alert-warning shake animated" role="alert"><span><strong>Error!</strong> Usuario o contraseña incorrecto.</span></div>';            
            break;
        default :
            echo '<div class="alert alert-success" role="alert"><span><strong>Iniciando...</div>'; 
            echo '<script type="text/javascript">window.location="./cargarRol.php";</script>';
            break;
    }
//switch ($mo->dato) 
//{
//    case 0:
//        
//        break; 
//    case 1:
//        echo 'si';
//        break;    
//}
}

