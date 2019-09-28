<?php
session_start();
$user = $_SESSION['tipo_usuario'];
switch ($user)
{
    case $user==='Administrador':
        require 'home.php';
        break;
    case $user==='Supervisor':
        require 'roles/Supervisor.php';
        break;
    case $user==='Notificador':
        require 'roles/Notificador.php';
        break;
    case $user==='Tesorero':
        require 'roles/Tesorero.php';
        break;
    default :
        echo '<h1>No existe contenido para este tipo</h1>';
        break;
}