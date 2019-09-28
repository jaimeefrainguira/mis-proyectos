<?php

class Contribuyente {
    //put your code here
    private $idcontribuyente;
    private $tipo_documento;
    private $razon_social;
    private $direccion;
    private $telefono;
    private $email;
    private $fecha_ingreso;
    private $especial;
    private $patente;
    private $fecha_importacion;
    private $valor;
    private $estado;
    private $idusuarios;
    public function Contribuyente()
    {
        
    }
    public function __Contribuyente($idcontribuyente, $tipo_documento, $razon_social, $direccion, $telefono, $email, $fecha_ingreso, $especial, $patente, $fecha_importacion, $valor, $estado, $idusuarios) {
        $this->idcontribuyente = $idcontribuyente;
        $this->tipo_documento = $tipo_documento;
        $this->razon_social = $razon_social;
        $this->direccion = $direccion;
        $this->telefono = $telefono;
        $this->email = $email;
        $this->fecha_ingreso = $fecha_ingreso;
        $this->especial = $especial;
        $this->patente = $patente;
        $this->fecha_importacion = $fecha_importacion;
        $this->valor = $valor;
        $this->estado = $estado;
        $this->idusuarios = $idusuarios;
    }
    function getIdcontribuyente() {
        return $this->idcontribuyente;
    }

    function getTipo_documento() {
        return $this->tipo_documento;
    }

    function getRazon_social() {
        return $this->razon_social;
    }

    function getDireccion() {
        return $this->direccion;
    }

    function getTelefono() {
        return $this->telefono;
    }

    function getEmail() {
        return $this->email;
    }

    function getFecha_ingreso() {
        return $this->fecha_ingreso;
    }

    function getEspecial() {
        return $this->especial;
    }

    function getPatente() {
        return $this->patente;
    }

    function getFecha_importacion() {
        return $this->fecha_importacion;
    }

    function getValor() {
        return $this->valor;
    }

    function getEstado() {
        return $this->estado;
    }

    function getIdusuarios() {
        return $this->idusuarios;
    }

    function setIdcontribuyente($idcontribuyente) {
        $this->idcontribuyente = $idcontribuyente;
    }

    function setTipo_documento($tipo_documento) {
        $this->tipo_documento = $tipo_documento;
    }

    function setRazon_social($razon_social) {
        $this->razon_social = $razon_social;
    }

    function setDireccion($direccion) {
        $this->direccion = $direccion;
    }

    function setTelefono($telefono) {
        $this->telefono = $telefono;
    }

    function setEmail($email) {
        $this->email = $email;
    }

    function setFecha_ingreso($fecha_ingreso) {
        $this->fecha_ingreso = $fecha_ingreso;
    }

    function setEspecial($especial) {
        $this->especial = $especial;
    }

    function setPatente($patente) {
        $this->patente = $patente;
    }

    function setFecha_importacion($fecha_importacion) {
        $this->fecha_importacion = $fecha_importacion;
    }

    function setValor($valor) {
        $this->valor = $valor;
    }

    function setEstado($estado) {
        $this->estado = $estado;
    }

    function setIdusuarios($idusuarios) {
        $this->idusuarios = $idusuarios;
    }


}
