<?php
function menu()
{
    require 'menu.php';
}
function cotenido()
{
    $user = $_SESSION['tipo_usuario'];
    switch ($user)
    {
        case $user==='Administrador':
            require 'Administrador.php';
            break;
        case $user==='Supervisor':
            require 'Supervisor.php';
            break;
        case $user==='Notificador':
            require 'Notificador.php';
            break;
        case $user==='Tesorero':
            require 'Tesorero.php';
            break;
        default :
            echo '<h1>No existe contenido para este tipo</h1>';
            break;
    }            
}