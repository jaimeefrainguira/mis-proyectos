package com.hugo.empresa.buscandoando.modelo;

import com.hugo.empresa.buscandoando.comunicacion.empresapadre;

public class negocio extends empresapadre {
    public negocio() {
    }
public negocio(String neg_codigo,String neg_nombre,String neg_descripcion,String foto,String categoria){
       super(neg_codigo,neg_nombre,neg_descripcion,foto,categoria);
}

}
