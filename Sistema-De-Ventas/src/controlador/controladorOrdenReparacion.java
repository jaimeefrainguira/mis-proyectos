package controlador;

import clases.OrdenReparacion;
import interfaz.interfazOrdenReparacion;
import javax.swing.JTable;
import modelo.modeloOrdenReparacion;
import vista.vistaOrdenReparacion;

public class controladorOrdenReparacion 
{
    private final interfazOrdenReparacion dao=new modeloOrdenReparacion();
    public final vistaOrdenReparacion datos= new vistaOrdenReparacion(); 
    public boolean registrar(OrdenReparacion reparacion)
    {        
        System.out.println(reparacion.toString());
        return dao.registrar(reparacion);
    }
    public void getAll(JTable tabla)
    {
        datos.verTabla(tabla,dao.buscar(""));
    }
    public void buscar(JTable tabla, String texto)
    {
        datos.verTabla(tabla,dao.buscar(texto));
    }
    public boolean actualiza(OrdenReparacion reparacion) 
    {
        return dao.actualiza(reparacion);
    }
    
}
