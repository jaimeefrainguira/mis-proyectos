package interfaz;

import clases.OrdenReparacion;
import java.util.ArrayList;

public interface interfazOrdenReparacion 
{
    public boolean registrar(OrdenReparacion reparacion);
    public boolean actualiza(OrdenReparacion reparacion);
    public int getId();
    public ArrayList<OrdenReparacion> buscar(String texto);
}
