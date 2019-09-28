package com.hugo.empresa.buscandoando.modelo;

/**
 * Created by hugo on 29/9/18.
 */

public class ciudad {
    public String ciudad;
    public String provincia;

    public ciudad() {
    }

    public ciudad(String ciudad, String provincia) {
        this.ciudad = ciudad;
        this.provincia = provincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return ciudad;
    }
}
