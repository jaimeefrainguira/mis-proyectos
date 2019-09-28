package controlador;

import clases.ComprasDetalleDetallado;
import clases.ComprasCabesera;
import clases.ComprasDetalladas;
import clases.ComprasDetalle;
import modelo.modeloCompras;
import interfaz.interfazCompras;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import vista.vistaCompras;

public class controladorCompras
{
    private final interfazCompras dao= new  modeloCompras();
    private ArrayList <ComprasDetalle> arreglo;
    public vistaCompras datos= new vistaCompras();
//    public vistaComprasCabesera datos= new vistaComprasCabesera(); 
    
    
    public boolean registrar(ComprasCabesera compras) 
    {
        return dao.registrar(compras,arreglo);   
    }
//    public void getAll(JTable tabla)
//    {
//        datos.verTabla(tabla,dao.buscar(""));
//    }
    public void buscar(JTable tabla, String desde,String hasta,int tipo,String valores)
    {
        datos.verTablaCabesera(tabla,dao.buscar(desde, hasta, tipo,valores));
    }
    public void listaDetalle(JTable tabla,int COM_CAB_ID)
    {
        datos.verTablaDetalle(tabla,dao.buscarDetalle(COM_CAB_ID));
    }
    public void getComprasDetalladas(JTable tabla,String desde, String hasta)
    {
        datos.verComprasDetalladas(tabla,dao.getComprasDetalladas(tabla,desde, hasta));
    }
//    public boolean modificar(Producto producto ) 
//    {
//        return dao.modificar(producto);        
//    }
//    public Producto buscarById(String texto)
//   {
//        return dao.buscarById(texto);       
//   }    
    
    
    //para registrar en la base de datos
   
    
//    public boolean registrarDetalle() 
//    {
//        return dao.registrarDetalle(arreglo);
//    }
    
    
    //METODOS PAR METER PRODUCTOS EN UN ARREGLO
    public controladorCompras()
    {
        arreglo = new ArrayList();
    }
    
    //Metodo para agregar un nuevo registro
    public void Agregar(ComprasDetalle nuevo)
    {
        arreglo.add(nuevo);         
    }
    
    //Obtiene o envia un registro
    public ComprasDetalle getCompras(int i)
    {
        return arreglo.get(i);
    }
    
    //Reemplaza un informacion de un registro
    public void Reemplaza(int i, ComprasDetalle Actualizado)
    {
        arreglo.set(i, Actualizado);
    }
    
    //Obtiene el numero del total de registros almacenados
    public int Numero_Comprass()
    {
        return arreglo.size();
    }
    
    //Elimina un registro del cliente
    public void Eliminar(int i)
    {
        arreglo.remove(i);
    }
    
    //Elimina todo el registro de un cliente
    public void Eliminar()
    {
        for(int i = 0; i<Numero_Comprass(); i++)
        {
            arreglo.remove(i);                 
        }
    }
    
    //Elimina todo los registros
    public void EliminarTodo()
    {
        arreglo.removeAll(arreglo);
    }
    
    //Buscar un registro por codigo
    public boolean Buscar(int codigo)
    {
        for (int i = 0; i<Numero_Comprass(); i++)
        {
            if(codigo==(this.getCompras(i).getPRO_ID()))
                return false; //existe
        }
        return true; // Significa que no encontro el codigo        
    }
    
//    //Buscar por Nombre
//    public int Buscar_Apellido(String nombre)
//    {
//        for (int i = 0; i<Numero_Comprass(); i++)
//        {
//            if(nombre.equalsIgnoreCase(getCompras(i).))
//                return i; // Retorna el indice            
//        }
//        return -1; //Significa que no encontro el nombre
//    }
    
        //Buscar un registro por indice
    public int Buscar_Indice(int num)
    {
        for (int i = 0; i<Numero_Comprass(); i++)
        {
            if(num==i)
                return i; //retorna el indice
        }
        return -1; // Significa que no encontro el codigo        
    }  
    
    //Muestra todos los registros en la tabla
    public void getAll(JTable tabla)
    {
        datos.verTabla(tabla,this.arreglo);
    }

    public void anularCompra(ArrayList<ComprasDetalleDetallado> detalle, int fila) 
    {
        dao.anularCompra(detalle, fila);
    }
    
    public int getCantidadTotalComprasDetalladas()
    {
        int total=0;
        
        for (int i = 0; i < datos.arregloComprasDetalladas.size(); i++) {
            total=total+datos.arregloComprasDetalladas.get(i).getCOM_DET_CATIDAD();
        }
        return total;
    }
    public double getValorTotalComprasDetalladas()
    {
        double total=0;
        for (int i = 0; i < datos.arregloComprasDetalladas.size(); i++) {
            total=total+datos.arregloComprasDetalladas.get(i).getCOM_DET_TOTAL();
        }
        return total;
    }
}
