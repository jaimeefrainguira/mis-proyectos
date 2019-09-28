package vista;

import clases.ComprasCabeseraDetallada;
import clases.ComprasDetalleDetallado;
import clases.ComprasCabesera;
import clases.ComprasDetalladas;
import clases.ComprasDetalle;
import clases.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.modeloProducto;

public class vistaCompras 
{
    private DefaultTableModel modeloTabla1;
    private DefaultComboBoxModel lista;
    private ajustaAnchoDeJtable anchoTabla=new ajustaAnchoDeJtable();
    public List<ComprasDetalle> compras;
    public ArrayList<ComprasDetalladas> arregloComprasDetalladas;
    public List<ComprasCabeseraDetallada> cabesera;
    public List<ComprasDetalleDetallado> detalle;
    int numero=0;
    public double subtotal;
    public double iva;
    public double total;
    //Creamos el encavezado para la tabla
   
    
    String[]encavezado={
        "CODIGO",
        "CANTIDAD",
        "DETALLE",
        "V. UNITARIO",
        "V. TOTAL"
    };
//    compra.getCOM_CAB_ID(),
//                compra.getPROVEEDOR(),   
//                compra.getUSUARIO(),
//                compra.getCOM_CAB_FECHA(),
//                compra.getCOM_CAB_TIPO_COMPROVANTE(),
//                compra.getCOM_CAB_NUM_COMPROVANTE(),
//                compra.getCOM_CAB_SUBTOTAL(),
//                compra.getCOM_CAB_IVA(),
//                compra.getCOM_CAB_TOTAL(),
//                compra.isCOM_CAB_ESTADO()
    String[]encavezado2={
        "CODIGO",
        "PROVEEDOR",
        "USUARIO",
        "FECHA",
        "COMPROVANTE",
        "NUM. COMPROVANTE",
        "SUBTOTAL",
        "IVA",
        "TOTAL",
        "ESTADO"
    };
    String[]encavezado3={
        "#",
        "CANTIDAD",
        "DESCRIPCION",
        "V. UNITARIO",
        "V. TOTAL"
    };
                    //        private int PRO_ID;
//private String PRO_NOMBRE;
//private String CAT_DESCRIPCION;
//private int COM_DET_CATIDAD;
//private double COM_DET_VALOR;
//private double COM_DET_TOTAL;
//private boolean COM_CAB_ESTADO;
    String[]encavezado4={
        "#",
        "CODIGO",
        "DESCRIPCION",
        "CATEGORIA",
        "CANTIDAD",
        "VALOR",
        "TOTAL"
    };
    
     //Creamos donde se van a almacenar los datos para la tabla
    public void verTabla(JTable tabla, List<ComprasDetalle> compras) 
    {
        subtotal=0;
        iva=0;
        total=0;
        modeloTabla1=new DefaultTableModel();      
        this.compras= compras;
        
        for (int i = 0; i < encavezado.length; i++) 
        {
            modeloTabla1.addColumn(encavezado[i]);
        }
        
//        tabla.setDefaultRenderer(Object.class, new Render()); 
        
        compras.forEach((compra)->
        {
            modeloProducto producto=new modeloProducto();
            Producto pro =producto.buscarById(String.valueOf(compra.getPRO_ID()));            
            
            Object fila []=
            {
                compra.getPRO_ID(),
                compra.getCOM_DET_CATIDAD(),                
                pro.getPRO_DESCRIPCION(),
                compra.getCOM_DET_VALOR(),
                compra.getCOM_DET_TOTAL() 
            };            
            modeloTabla1.addRow(fila);
            subtotal=subtotal+compra.getCOM_DET_TOTAL()/1.12;
        });
        iva=subtotal*12/100;
        total=subtotal+iva;
        tabla.setModel(modeloTabla1);
//        tabla.setRowHeight(30);
        anchoTabla.ajustarAnchoTabla(tabla);
    }

    public void verTablaCabesera(JTable tabla, ArrayList<ComprasCabeseraDetallada> compras) {
        modeloTabla1=new DefaultTableModel();       
        this.cabesera= compras;
        
        for (int i = 0; i < encavezado2.length; i++) 
        {
            modeloTabla1.addColumn(encavezado2[i]);
        }
        
//        tabla.setDefaultRenderer(Object.class, new Render()); 
        
        compras.forEach((compra)->
        {      
            String tipoComprobate="Factura";
            if(compra.getCOM_CAB_TIPO_COMPROVANTE()==1)
            {
                tipoComprobate="Nota de Venta";
            }
            String estado="ANULADO";
            if(compra.isCOM_CAB_ESTADO())
            {
                estado="ACTIVO";
            }
            Object fila []=
            {
                compra.getCOM_CAB_ID(),
                compra.getPROVEEDOR(),   
                compra.getUSUARIO(),
                compra.getCOM_CAB_FECHA(),
                tipoComprobate,
                compra.getCOM_CAB_NUM_COMPROVANTE(),
                compra.getCOM_CAB_SUBTOTAL(),
                compra.getCOM_CAB_IVA(),
                compra.getCOM_CAB_TOTAL(),
                estado
            };            
            modeloTabla1.addRow(fila);
        });
        
        tabla.setModel(modeloTabla1);
        anchoTabla.ajustarAnchoTabla(tabla);
    }

    public void verTablaDetalle(JTable tabla, ArrayList<ComprasDetalleDetallado> buscarDetalle) 
    {
        modeloTabla1=new DefaultTableModel();        
        this.detalle= buscarDetalle;
        
        for (int i = 0; i < encavezado3.length; i++) 
        {
            modeloTabla1.addColumn(encavezado3[i]);
        }
        
//        tabla.setDefaultRenderer(Object.class, new Render()); 
        
        numero=0;
        detalle.forEach((compra)->
        {      
            numero++;
            Object fila []=
            {
                numero,
                compra.getCOM_DET_CATIDAD(),
                compra.getPRODUCTO(),
                compra.getCOM_DET_VALOR(),   
                compra.getCOM_DET_VALOR()
            };            
            modeloTabla1.addRow(fila);
        });
        
        tabla.setModel(modeloTabla1);
        anchoTabla.ajustarAnchoTabla(tabla);
        
    }

    public void verComprasDetalladas(JTable tabla, ArrayList<ComprasDetalladas> comprasDetalladas) {

modeloTabla1=new DefaultTableModel();        
        this.arregloComprasDetalladas= comprasDetalladas;
        
        for (int i = 0; i < encavezado4.length; i++) 
        {
            modeloTabla1.addColumn(encavezado4[i]);
        }
        
//        tabla.setDefaultRenderer(Object.class, new Render()); 
        
        numero=0;
        arregloComprasDetalladas.forEach((compra)->
        {      
            numero++;
            Object fila []=
            {

                numero,
                compra.getPRO_ID(),
                compra.getPRO_NOMBRE(),
                compra.getCAT_DESCRIPCION(),   
                compra.getCOM_DET_CATIDAD(),
                compra.getCOM_DET_VALOR(),
                compra.getCOM_DET_TOTAL()
//                compra.isCOM_CAB_ESTADO()
            };            
            modeloTabla1.addRow(fila);
        });
        
        tabla.setModel(modeloTabla1);
        anchoTabla.ajustarAnchoTabla(tabla);
        
    }
}
