package controlador;

import clases.Categoria;
import interfaz.interfazCategoria;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.modeloCategoria;
import vista.ajustaAnchoDeJtable;
import vista.vistaCategoria;

public class controladorCategoria 
{
    private final interfazCategoria dao= new  modeloCategoria();
    public vistaCategoria datos= new vistaCategoria();
    
    
    //llama al DAO para guardar un usuario
    public boolean registrar(Categoria categoria ) 
    {
        return dao.registrar(categoria);        
    }
    public void getAll(JTable tabla)
    {
        datos.verTabla(tabla,dao.buscar(""));
    }
    public void buscar(JTable tabla, String texto)
    {
        datos.verTabla(tabla,dao.buscar(texto));
    }
    public void getCombobox(JComboBox<String> prod_opciones)
    {
        
        datos.verComboBox(prod_opciones,dao.Listar_Categoria());
    }
    public boolean modificar(Categoria categoria ) 
    {
        return dao.modificar(categoria);        
    }
}
