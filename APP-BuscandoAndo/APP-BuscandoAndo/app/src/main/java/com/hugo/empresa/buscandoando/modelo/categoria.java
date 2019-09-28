package com.hugo.empresa.buscandoando.modelo;

public class categoria {
    public String cat_codigo;
    public String cat_nombre;

    public categoria() {
    }

    public categoria(String codigo, String nombre) {
        this.cat_codigo = codigo;
        this.cat_nombre = nombre;
    }

    public String getCat_codigo() {
        return cat_codigo;
    }

    public void setCat_codigo(String cat_codigo) {
        this.cat_codigo = cat_codigo;
    }

    public String getCat_nombre() {
        return cat_nombre;
    }

    public void setCat_nombre(String cat_nombre) {
        this.cat_nombre = cat_nombre;
    }
    @Override
    public String toString() {
        return cat_nombre;
    }
}