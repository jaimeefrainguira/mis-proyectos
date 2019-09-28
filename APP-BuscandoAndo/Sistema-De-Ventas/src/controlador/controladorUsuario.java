
package controlador;

import Conexion.Conexion;
import clases.TipoUsuario;
import clases.Usuario;
import clases.validaciones;
import modelo.modeloUsuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.ajustaAnchoDeJtable;
import vista.vistaUsuarios;
import interfaz.interfazDAO;



public class controladorUsuario 
{
    private final modeloUsuario dao= new  modeloUsuario();
	
    private vistaUsuarios datos= new vistaUsuarios();
    private ajustaAnchoDeJtable anchoTabla=new ajustaAnchoDeJtable();
    private validaciones validacion=new validaciones();
    public controladorUsuario() 
    {

    }
    //llama al DAO para guardar un usuario
    public boolean registrar(Usuario usuario ) 
    {
        boolean estado=true;
        try
        {
            dao.registrar(usuario);
        }
        catch (Exception e) 
        {
            validacion.mensajeError(e.getMessage(),"Usuario");
            estado=false;
        }
        return estado;
    }
    public boolean actualizar(Usuario usuario)
    {
        return dao.actualizar(usuario);
    }

    //	llama al DAO para obtener todos los usuarios y luego los muestra en la vista
    public DefaultTableModel getAll()
    {
        return datos.verUsuarios(dao.buscar(""));
    }
    public int getIdUsuario(String nombre)
    {

        return dao.buscarIdUsuarioByNombre(nombre);
    }
    public Object getById(String idUsuario)
    {
        return dao.buscarById(idUsuario);
    }
    public DefaultTableModel buscar(String buscar)
    {
        return datos.verUsuarios(dao.buscar(buscar));//
    }

    public Object iniciarSesion(String usuario,String clave)
    {

        return dao.iniciarSesion(usuario,clave);
    }

    public void anchoTablas(JTable tabla)
    {
        anchoTabla.ajustarAnchoTabla(tabla);
    }
    public void getAll(JTable tabla)
    {
        datos.verTabla(tabla,dao.buscar(""));
    }

    public void getAllUsuarios(JComboBox<String> jComboBox3) 
    {
        datos.comboboxUsuarios(jComboBox3,dao.buscar(""));
    }

    
        
        
        
}