<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of Notificacion
 *
 * @author jaimeguiracocha
 */
class Notificacion {
    private $fecha_notificacion;
    private $num_notificacion;
    private $direccion;
    private $extintor;
    private $inst_electricas;
    private $recipientes;
    private $mater_combust;
    private $otros;
    private $fecha_limite;
    private $estado;
    private $latitud;
    private $longitud;
    private $observaciones;
    private $idcontribuyente;
    private $usuarios_idusuarios;
    
    function __construct($fecha_notificacion, $num_notificacion, $direccion, $extintor, $inst_electricas, $recipientes, $mater_combust, $otros, $fecha_limite, $estado, $latitud, $longitud, $observaciones, $idcontribuyente, $usuarios_idusuarios) {
        $this->fecha_notificacion = $fecha_notificacion;
        $this->num_notificacion = $num_notificacion;
        $this->direccion = $direccion;
        $this->extintor = $extintor;
        $this->inst_electricas = $inst_electricas;
        $this->recipientes = $recipientes;
        $this->mater_combust = $mater_combust;
        $this->otros = $otros;
        $this->fecha_limite = $fecha_limite;
        $this->estado = $estado;
        $this->latitud = $latitud;
        $this->longitud = $longitud;
        $this->observaciones = $observaciones;
        $this->idcontribuyente = $idcontribuyente;
        $this->usuarios_idusuarios = $usuarios_idusuarios;
    }
    
    function getFecha_notificacion() {
        return $this->fecha_notificacion;
    }

    function getNum_notificacion() {
        return $this->num_notificacion;
    }

    function getDireccion() {
        return $this->direccion;
    }

    function getExtintor() {
        return $this->extintor;
    }

    function getInst_electricas() {
        return $this->inst_electricas;
    }

    function getRecipientes() {
        return $this->recipientes;
    }

    function getMater_combust() {
        return $this->mater_combust;
    }

    function getOtros() {
        return $this->otros;
    }

    function getFecha_limite() {
        return $this->fecha_limite;
    }

    function getEstado() {
        return $this->estado;
    }

    function getLatitud() {
        return $this->latitud;
    }

    function getLongitud() {
        return $this->longitud;
    }

    function getObservaciones() {
        return $this->observaciones;
    }

    function getIdcontribuyente() {
        return $this->idcontribuyente;
    }

    function getUsuarios_idusuarios() {
        return $this->usuarios_idusuarios;
    }

    function setFecha_notificacion($fecha_notificacion) {
        $this->fecha_notificacion = $fecha_notificacion;
    }

    function setNum_notificacion($num_notificacion) {
        $this->num_notificacion = $num_notificacion;
    }

    function setDireccion($direccion) {
        $this->direccion = $direccion;
    }

    function setExtintor($extintor) {
        $this->extintor = $extintor;
    }

    function setInst_electricas($inst_electricas) {
        $this->inst_electricas = $inst_electricas;
    }

    function setRecipientes($recipientes) {
        $this->recipientes = $recipientes;
    }

    function setMater_combust($mater_combust) {
        $this->mater_combust = $mater_combust;
    }

    function setOtros($otros) {
        $this->otros = $otros;
    }

    function setFecha_limite($fecha_limite) {
        $this->fecha_limite = $fecha_limite;
    }

    function setEstado($estado) {
        $this->estado = $estado;
    }

    function setLatitud($latitud) {
        $this->latitud = $latitud;
    }

    function setLongitud($longitud) {
        $this->longitud = $longitud;
    }

    function setObservaciones($observaciones) {
        $this->observaciones = $observaciones;
    }

    function setIdcontribuyente($idcontribuyente) {
        $this->idcontribuyente = $idcontribuyente;
    }

    function setUsuarios_idusuarios($usuarios_idusuarios) {
        $this->usuarios_idusuarios = $usuarios_idusuarios;
    }

}
