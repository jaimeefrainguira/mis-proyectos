package interfaz;

import clases.TipoUsuario;
import clases.Usuario;
import java.util.ArrayList;
import java.util.List;

public interface interfazTipoUsuario 
{
    public boolean registrar(TipoUsuario tipoUsuario);
    public boolean modificar(TipoUsuario tipoUsuario);
    public int getId();
    public ArrayList<TipoUsuario> buscarTipoUsuario(String texto);

    
}
