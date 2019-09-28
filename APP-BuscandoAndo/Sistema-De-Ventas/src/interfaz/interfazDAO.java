package interfaz;

//import clases.Persona;
//import clases.TipoUsuario;
//import clases.Usuario;
import java.util.ArrayList;
import java.util.List;

public interface interfazDAO 
{
    public boolean              registrar       (Object clase) throws Exception;
    public boolean              actualizar      (Object clase);
    public boolean              eliminar        (int id);
    public ArrayList<Object>    buscar          (String texto);
    public Object               buscarById      (String texto);    
    public int                  getId();  
    
}
