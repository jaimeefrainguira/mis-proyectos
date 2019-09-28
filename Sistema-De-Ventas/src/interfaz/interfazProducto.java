/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;


import clases.Producto;
import java.util.ArrayList;

/**
 *
 * @author jaimeguiracocha
 */
public interface interfazProducto {
    public boolean registrar(Producto producto);
    public boolean modificar(Producto producto,boolean mod);
    public int getId();
    public ArrayList<Producto> buscar(String texto);
    public Producto buscarById(String texto);
}
