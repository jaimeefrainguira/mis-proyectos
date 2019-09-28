package com.hugo.empresa.buscandoando.comunicacion;

public class empresapadre {
    private String neg_codigo;
    private String neg_nombre;
    private String neg_descripcion;
    private String neg_direccion;
    private String neg_provincia;
    private String neg_ciudad;
    private String neg_telefono;
    private String neg_celular;
    private  String neg_imagen;
    private String neg_hora_fecha;
    private String neg_categoria;

    public String getNeg_categoria() {
        return neg_categoria;
    }

    public void setNeg_categoria(String neg_categoria) {
        this.neg_categoria = neg_categoria;
    }

    public String getNeg_hora_fecha() {
        return neg_hora_fecha;
    }

    public void setNeg_hora_fecha(String neg_hora_fecha) {
        this.neg_hora_fecha = neg_hora_fecha;
    }

    public empresapadre(){

    }

    public empresapadre(String neg_codigo, String neg_nombre, String neg_descripcion, String neg_imagen,String categoria) {
        this.neg_codigo = neg_codigo;
        this.neg_nombre = neg_nombre;
        this.neg_descripcion = neg_descripcion;
        this.neg_imagen = neg_imagen;
        this.neg_categoria = categoria;

    }

    public String getNeg_codigo() {
        return neg_codigo;
    }

    public void setNeg_codigo(String neg_codigo) {
        this.neg_codigo = neg_codigo;
    }

    public String getNeg_nombre() {
        return neg_nombre;
    }

    public void setNeg_nombre(String neg_nombre) {
        this.neg_nombre = neg_nombre;
    }

    public String getNeg_descripcion() {
        return neg_descripcion;
    }

    public void setNeg_descripcion(String neg_descripcion) {
        this.neg_descripcion = neg_descripcion;
    }

    public String getNeg_direccion() {
        return neg_direccion;
    }

    public void setNeg_direccion(String neg_direccion) {
        this.neg_direccion = neg_direccion;
    }

    public String getNeg_provincia() {
        return neg_provincia;
    }

    public void setNeg_provincia(String neg_provincia) {
        this.neg_provincia = neg_provincia;
    }

    public String getNeg_ciudad() {
        return neg_ciudad;
    }

    public void setNeg_ciudad(String neg_ciudad) {
        this.neg_ciudad = neg_ciudad;
    }

    public String getNeg_telefono() {
        return neg_telefono;
    }

    public void setNeg_telefono(String neg_telefono) {
        this.neg_telefono = neg_telefono;
    }

    public String getNeg_celular() {
        return neg_celular;
    }

    public void setNeg_celular(String neg_celular) {
        this.neg_celular = neg_celular;
    }

    public String getNeg_imagen() {
        return neg_imagen;
    }

    public void setNeg_imagen(String neg_imagen) {
        this.neg_imagen = neg_imagen;
    }
}
