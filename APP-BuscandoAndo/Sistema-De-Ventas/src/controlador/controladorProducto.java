/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clases.Producto;
import interfaz.interfazProducto;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JTable;
import modelo.modeloProducto;
import vista.vistaProducto;

/**
 *
 * @author jaimeguiracocha
 */
public class controladorProducto
{
    controladorKardex ctrKardex=new controladorKardex();
    private final interfazProducto dao= new  modeloProducto();
    public vistaProducto datos= new vistaProducto(); 
    
    
    public boolean registrar(Producto producto ) 
    {
        return dao.registrar(producto);        
    }
    public void getAll(JTable tabla)
    {
        datos.verTabla(tabla,dao.buscar(""));
    }
    public void buscar(JTable tabla, String texto)
    {
        datos.verTabla(tabla,dao.buscar(texto));
    }
    public boolean modificar(Producto producto, boolean modi) 
    {
        return dao.modificar(producto,modi);        
    }
    public Producto buscarById(String texto)
   {
        return dao.buscarById(texto);       
   }
    public boolean consultaModificar(int PRO_ID)
    {
        boolean pasa=false;
        int x=ctrKardex.cantidadRegistros(PRO_ID);
        if(ctrKardex.cantidadRegistros(PRO_ID)==1)
        {
            pasa=true;
        }
//        cantidadRegistros(int PRO_ID)
        return pasa;
    }
}
