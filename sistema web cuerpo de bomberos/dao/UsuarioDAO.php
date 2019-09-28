<?php


class UsuarioDAO {  
    public function registrar(\usuario  $usuario) {
        
        echo $usuario->getApe_nombre();
    }

    public function iniciarSesion($usuario, $clave) 
    {
        require '../basedatos/conexion.php';
        $sql="call iniciarSesion('$usuario','$clave');";
        $result= mysqli_query($mysqli, $sql);       
        $datos=$result->num_rows;
        require_once '../metodos.php';
        $metodos=new metodos();
        while ($ver= mysqli_fetch_row($result))
        {
            require '../clases/Usuario.php';
            $usu=new Usuario ();
            $usu->Usuario($ver[0], $ver[1], $ver[2], $ver[3], $ver[4], $ver[5], $ver[6], $ver[7]);
            require '../basedatos/conexion.php';
            $ip=$this->getRealIP();
            $date=$metodos->getFechaHora();
            $id=$usu->getIdusuarios();
            $sql2="call sesion('V','$date','$ip','$id');";
            mysqli_query($mysqli, $sql2);
            session_start();
            $_SESSION['idusuarios']=$usu->getIdusuarios();
            $_SESSION['id_usuario'] = $usu->getUsuario();
            $_SESSION['usuario'] = $usu->getApe_nombre();
            $_SESSION['tipo_usuario'] = $usu->getPerfil();
        }
        mysqli_close($mysqli);
        return $datos;  
    }
    
    
    function getRealIP()
    {

        $ip = "";
        if (isset($_SERVER)) {
            if (!empty($_SERVER['HTTP_CLIENT_IP'])) {
                $ip = $_SERVER['HTTP_CLIENT_IP'];
            } elseif (!empty($_SERVER['HTTP_X_FORWARDED_FOR'])) {
                $ip = $_SERVER['HTTP_X_FORWARDED_FOR'];
            } else {
                $ip = $_SERVER['REMOTE_ADDR'];
            }
        } else {
            if (getenv('HTTP_CLIENT_IP')) {
                $ip = getenv('HTTP_CLIENT_IP');
            } elseif (getenv('HTTP_X_FORWARDED_FOR')) {
                $ip = getenv('HTTP_X_FORWARDED_FOR');
            } else {
                $ip = getenv('REMOTE_ADDR');
            }
        }
        // En algunos casos muy raros la ip es devuelta repetida dos veces separada por coma 
        if (strstr($ip, ',')) {
            $ip = array_shift(explode(',', $ip));
        }
        return $ip;

    }

}
