package com.hugo.empresa.buscandoando.modelo;

/**
 * Created by hugo on 23/9/18.
 */

public class provincia {
    public String codigo;
    public String nombre;

    public provincia() {
    }

    public provincia(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre ;

    }
}
