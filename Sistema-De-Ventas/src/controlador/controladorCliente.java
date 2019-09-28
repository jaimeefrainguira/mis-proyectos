package controlador;

import clases.Persona;
import clases.validaciones;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.modeloCliente;
import vista.ajustaAnchoDeJtable;
import vista.vistaCliente;

public class controladorCliente 
{
    private final modeloCliente dao= new  modeloCliente();
    private vistaCliente vista= new vistaCliente();
    private ajustaAnchoDeJtable anchoTabla=new ajustaAnchoDeJtable();
    private validaciones validacion=new validaciones();
    
    public boolean registrar(Persona cliente) 
    {
        boolean estado=true;
        try
        {
            dao.registrar(cliente);
        }
        catch (Exception e) 
        {
            validacion.mensajeError(e.getMessage(),"Cliente");
            estado=false;
        }
        return estado;
    }
    public DefaultTableModel getAll()
    {
        return vista.verClientes(dao.buscar(""));
    }
    public void anchoTablas(JTable tabla)
    {
        anchoTabla.ajustarAnchoTabla(tabla);
    }
    public DefaultTableModel buscar(String buscar)
    {
        return vista.verClientes(dao.buscar(buscar));//
    }
    public Persona getById(String id)
    {
        return (Persona) dao.buscarById(id);
    }
    public void actualizar(Persona cliente)
    {
        dao.actualizar(cliente);
    }
}
