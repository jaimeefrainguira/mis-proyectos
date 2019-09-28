package controlador;

import clases.FacturaCabesera;
import clases.FacturaDetalle;
import clases.FacturaDetalleDetallado;
import interfaz.interfazFactura;
import java.util.ArrayList;
import javax.swing.JTable;
import modelo.modeloFactura;
import vista.vistaFactura;

public class controladorFactura {
    private final interfazFactura dao= new  modeloFactura();
    private ArrayList <FacturaDetalle> arreglo;
    public vistaFactura datos= new vistaFactura();
//    public vistaComprasCabesera datos= new vistaComprasCabesera(); 
    
    
    public boolean registrar(FacturaCabesera factura,int comprobante) 
    {        
        return dao.registrar(factura,arreglo,comprobante);   
    }
    public int prepararFacturaNumero()
    {
        return dao.getId();
    }
    public int prepararNotaVenta()
    {
        return dao.getIdNota();
    }
    
//    public void getAll(JTable tabla)
//    {
//        datos.verTabla(tabla,dao.buscar(""));
//    }
//    public void buscar(JTable tabla, String texto)
//    {
//        datos.verTabla(tabla,dao.buscar(texto));
//    }
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
    public controladorFactura()
    {
        arreglo = new ArrayList();
    }
    
    //Metodo para agregar un nuevo registro
    public void Agregar(FacturaDetalle nuevo)
    {
        arreglo.add(nuevo);         
    }
    
    //Obtiene o envia un registro
    public FacturaDetalle getCompras(int i)
    {
        return arreglo.get(i);
    }
    
    //Reemplaza un informacion de un registro
    public void Reemplaza(int i, FacturaDetalle Actualizado)
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
    
    //Elimina todo el arrego del cliente
    public void EliminarTodo()
    {
        arreglo.removeAll(arreglo);
    }
    
    //Elimina todo el registro de un cliente
    public void Eliminar()
    {
        for(int i = 0; i<Numero_Comprass(); i++)
        {
            arreglo.remove(i);                 
        }
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

    public void listaDetalle(JTable tabla, int codigoCabesera) 
    {
        datos.verTablaDetalle(tabla,dao.buscarDetalle(codigoCabesera));
    }

    public void buscar(JTable jTable1, String desde, String hasta, int i,String valores) 
    {
        
        if(i==0)
        {
             datos.verTablaCabesera(jTable1,dao.buscarVentas(desde,hasta,valores));
        }
    } 

    public void anularVenta(ArrayList<FacturaDetalleDetallado> detalle, int fila) 
    {
        dao.anular(detalle, fila);
    }

    public void buscarFacturaAlDetalle(JTable jTable1, String desde, String hasta) 
    {
        datos.VerTablaFacturasAlDetalle(jTable1,dao.buscarVentasAlDetalle( jTable1,  desde,  hasta));
    }
    public int getTotalCantidad()
    {
        int cantidad=0;
        for (int i = 0; i < datos.buscarVentasAlDetalle.size(); i++) {            
           cantidad=cantidad+datos.buscarVentasAlDetalle.get(i).getFAC_DET_CANTIDAD();
        }
        return cantidad;
    }
    public double getTotalVentas()
    {
        double cantidad=0;
        for (int i = 0; i < datos.buscarVentasAlDetalle.size(); i++) {            
           cantidad=cantidad+datos.buscarVentasAlDetalle.get(i).getFAC_DET_TOTAL();
        }
        return cantidad;
    }
    public double getTotalGanancias()
    {
        double cantidad=0;
        for (int i=0;i<this.Numero_Comprass();i++)
        {
            cantidad=cantidad+arreglo.get(i).getFAC_DET_PC();
        }
        return datos.subtotal-cantidad;
    }
    public double getTotalGananciassss()
    {
        double cantidad=0;
        for (int i=0;i<datos.buscarVentasAlDetalle.size();i++)
        {
            cantidad=cantidad+datos.buscarVentasAlDetalle.get(i).getFAC_DET_GANANCIA();
        }
        return cantidad;
    }
}
