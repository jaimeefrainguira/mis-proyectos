package controlador;

import interfaz.interfazKardex;
import javax.swing.JTable;
import modelo.modeloKardex;
import vista.vistaKardex;

public class controladorKardex 
{
    private final interfazKardex dao= new  modeloKardex();
    public vistaKardex datos= new vistaKardex(); 
    public void getAll(JTable tabla,int PRO_ID)
    {
        datos.verTabla(tabla,dao.buscar(PRO_ID));
    }
    public int cantidadRegistros(int PRO_ID)
    {
        
        return dao.buscar(PRO_ID).size();
    }
    
}
