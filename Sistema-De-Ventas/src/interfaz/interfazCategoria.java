package interfaz;

import clases.Categoria;
import java.util.ArrayList;

public interface interfazCategoria 
{
    public boolean registrar(Categoria categoria);
    public boolean modificar(Categoria categoria);
    public int getId();
    public ArrayList<Categoria> buscar(String texto);
    public ArrayList<Categoria> Listar_Categoria();
}
