<?php

class Usuario  
{    
    private $idusuarios;
    private $usuario;
    private $cedula;
    private $clave;
    private $fecha_creacion;
    private $ape_nombre;
    private $direccion;
    private $perfil;
    
               
    function __construct() 
    {
        
    }
    
    public function usuario($idusuarios, $usuario, $cedula, $clave, $fecha_creacion, $ape_nombre, $direccion, $perfil)
    {
        $this->idusuarios = $idusuarios;
        $this->usuario = $usuario;
        $this->cedula = $cedula;
        $this->clave = $clave;
        $this->fecha_creacion = $fecha_creacion;
        $this->ape_nombre = $ape_nombre;
        $this->direccion = $direccion;
        $this->perfil = $perfil;
    }
    
    function getIdusuarios() {
        return $this->idusuarios;
    }

    function getUsuario() {
        return $this->usuario;
    }

    function getCedula() {
        return $this->cedula;
    }

    function getClave() {
        return $this->clave;
    }

    function getFecha_creacion() {
        return $this->fecha_creacion;
    }

    function getApe_nombre() {
        return $this->ape_nombre;
    }

    function getDireccion() {
        return $this->direccion;
    }

    function getPerfil() {
        return $this->perfil;
    }

    function setIdusuarios($idusuarios) {
        $this->idusuarios = $idusuarios;
    }

    function setUsuario($usuario) {
        $this->usuario = $usuario;
    }

    function setCedula($cedula) {
        $this->cedula = $cedula;
    }

    function setClave($clave) {
        $this->clave = $clave;
    }

    function setFecha_creacion($fecha_creacion) {
        $this->fecha_creacion = $fecha_creacion;
    }

    function setApe_nombre($ape_nombre) {
        $this->ape_nombre = $ape_nombre;
    }

    function setDireccion($direccion) {
        $this->direccion = $direccion;
    }

    function setPerfil($perfil) {
        $this->perfil = $perfil;
    }


}
