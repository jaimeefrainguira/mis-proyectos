package controlador;

import clases.Persona;
import clases.Proveedor;
import clases.validaciones;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.modeloProveedor;
import vista.ajustaAnchoDeJtable;
import vista.vistaProveedor;

public class controladorProveedor 
{
    private final modeloProveedor dao= new  modeloProveedor();
    private vistaProveedor datos= new vistaProveedor();
    private ajustaAnchoDeJtable anchoTabla=new ajustaAnchoDeJtable();
    private validaciones validacion=new validaciones();
    
    public boolean registrar(Persona proveedor) 
    {
        boolean estado=true;
        try
        {
            dao.registrar(proveedor);
        }
        catch (Exception e) 
        {
            validacion.mensajeError(e.getMessage(),"Proveedor");
            estado=false;
        }
        return estado;
    }
    public DefaultTableModel getAll()
    {
        return datos.verProveedor(dao.buscar(""));
    }
    public void anchoTablas(JTable tabla)
    {
        anchoTabla.ajustarAnchoTabla(tabla);
    }
    public DefaultTableModel buscar(String buscar)
    {
        return datos.verProveedor(dao.buscar(buscar));//
    }
    public DefaultTableModel buscarByNombre(String buscar)
    {
        return datos.verProveedor(dao.buscarByNombre(buscar));//
    }
    public Proveedor getById(String id)
    {
        return (Proveedor) dao.buscarById(id);
    }
    public void actualizar(Persona proveedor)
    {
        dao.actualizar(proveedor);
    }
}
