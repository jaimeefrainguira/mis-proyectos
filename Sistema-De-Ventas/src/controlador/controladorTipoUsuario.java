
package controlador;

import clases.TipoUsuario;
import modelo.modeloTipoUsuario;
import interfaz.interfazTipoUsuario;
import java.util.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.modeloTipoUsuario;
import vista.ajustaAnchoDeJtable;
import vista.vistaTipoUsuario;
import interfaz.interfazDAO;



public class controladorTipoUsuario 
{
        private final interfazTipoUsuario dao= new  modeloTipoUsuario();
	private vistaTipoUsuario datos= new vistaTipoUsuario();
	
	public controladorTipoUsuario() 
        {
	
        }
	
	//llama al DAO para guardar un usuario
	public boolean registrar(TipoUsuario tipoUsuario ) 
        {
            return dao.registrar(tipoUsuario);        
	}
        
        public void modificar(TipoUsuario tipoUsuario)
        {
            dao.modificar(tipoUsuario);
        }
	
        //	llama al DAO para obtener todos los usuarios y luego los muestra en la vista
//	public DefaultTableModel getAllTiposUsuarios()
//        {
//            return datos.verTipoUsuarios(dao.buscarTipoUsuario(""));
//	}
        //obtiene todos los usuarios en un comboBoxModel
        public DefaultComboBoxModel getAllListTipoUsuarios()
        {
            return datos.listaTipoUsuarios(dao.buscarTipoUsuario(""));
        }
        
        public void buscarTipoUsuario(JTable tabla,String buscar)
        {
            datos.verTabla(tabla,dao.buscarTipoUsuario(buscar));
//            return datos.verTipoUsuarios(dao.buscarTipoUsuario(buscar));//
        }
        
        public ArrayList<TipoUsuario> buscarTipoUsu(String buscar)
        {
            return dao.buscarTipoUsuario(buscar);//
            
        }
        
        
        
        public void getAll(JTable tabla)
        {
            datos.verTabla(tabla,dao.buscarTipoUsuario(""));
        }
        
        
        //llama al DAO para obtener todo el usuario por id y luego le muestra en la vista
//	public Usuario getUsuarioById(int usuarioId)
//        {
//            return dao.getUsuarioById(usuarioId);
//	}        
    
        
}