<?php
session_start();
$mensaje='';
if (!empty($_POST))
{
    $usuario=$_POST['email'];
    $pas=$_POST['pass'];
    

    require './clases/usuario.php';
    include './controlador/controladorUsuario.php';
    $controlador=new controladorUsuario();
    if ($controlador->iniciarSesion($usuario, $pas)) 
    {     
        header("location: home.php");
    }
    else 
    {
        $mensaje= "El nombre o contraseña son incorrectos";
    }
}
?>