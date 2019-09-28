/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import clases.FacturaAlDetalle;
import clases.FacturaCabeseraDetallada;
import clases.FacturaDetalle;
import clases.FacturaDetalleDetallado;
import clases.Producto;
import clases.validaciones;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.modeloProducto;

/**
 *
 * @author jaimeguiracocha
 */
public class vistaFactura 
{
    private DefaultTableModel modeloTabla1;
    private DefaultComboBoxModel lista;
    private ajustaAnchoDeJtable anchoTabla;
    public List<FacturaDetalle> compras;
    public List<FacturaCabeseraDetallada> cabesera;
    public List<FacturaDetalleDetallado> detalle;
    public List<FacturaAlDetalle> buscarVentasAlDetalle;
    public double subtotal;
    public double descuento;
    public double iva;
    public double total;
    public double ganancia;
    int numero=0;
    validaciones validar=new validaciones();
    //Creamos el encavezado para la tabla
   
    
    String[]encavezado={
        "CODIGO",
        "CANTIDAD",
        "DETALLE",
        "V. UNITARIO",
        "DESCUENTO",
        "V. TOTAL"
    };
    
    String[]encavezado2={
        "# FAC.",
        "FECHA",
        "SUTOTAL",
        "IVA",
        "TOTAL",
        "FORMA DE PAGO",
        "CLIENTE",
        "VENDEDOR",
        "ESTADO"
    };
    String[]encavezado3={
        "#",
        "CODIGO",
        "CANTIDAD",
        "DESCRIPCION",
        "V. UNITARIO",
        "V. TOTAL"
    };
    String[]encavezado4={
        "CODIGO",
        "DESCRIPCION",
        "CATEGORIA",
        "CANTIDAD",
        "V. UNITARIO",
        "V. TOTAL",
        "GANANCIA"
    };
    
     //Creamos donde se van a almacenar los datos para la tabla
    public void verTabla(JTable tabla, List<FacturaDetalle> detalles) 
    {
        subtotal=0;
        descuento=0;
        iva=0;
        total=0;
        modeloTabla1=new DefaultTableModel();
        anchoTabla=new ajustaAnchoDeJtable();        
        this.compras= detalles;
        
        for (int i = 0; i < encavezado.length; i++) 
        {
            modeloTabla1.addColumn(encavezado[i]);
        }
        
//        tabla.setDefaultRenderer(Object.class, new Render()); 
        
        detalles.forEach((detalle)->
        {
            modeloProducto producto=new modeloProducto();
            Producto pro =producto.buscarById(String.valueOf(detalle.getPRO_ID()));            
            
            Object fila []=
            {
                detalle.getPRO_ID(),
                detalle.getFAC_DET_CANTIDAD(),                
                pro.getPRO_DESCRIPCION(),
                detalle.getFAC_DET_PVP(),
                detalle.getFAC_DET_DESCUENTO(),
                detalle.getFAC_DET_TOTAL() 
            };            
            modeloTabla1.addRow(fila);
            descuento=descuento+detalle.getFAC_DET_DESCUENTO();            
            subtotal=subtotal+detalle.getFAC_DET_TOTAL();            
        });
        subtotal=subtotal/1.12;
        iva=subtotal*12/100;
        total=subtotal+iva;
        tabla.setModel(modeloTabla1);
//        tabla.setRowHeight(30);
        anchoTabla.ajustarAnchoTabla(tabla);
        
        subtotal=validar.redondearDecimales(subtotal);
        descuento=validar.redondearDecimales(descuento);
        iva=validar.redondearDecimales(iva);
        total=validar.redondearDecimales(total);
        System.out.println("Subtotal: "+subtotal+"Descuento: "+descuento+"Iva: "+iva+"Total: "+total);
        
        
        
    }

    public void verTablaCabesera(JTable tabla, ArrayList<FacturaCabeseraDetallada> buscarVentas) 
    {
        modeloTabla1=new DefaultTableModel();
        anchoTabla=new ajustaAnchoDeJtable();        
        this.cabesera= buscarVentas;
        
        for (int i = 0; i < encavezado2.length; i++) 
        {
            modeloTabla1.addColumn(encavezado2[i]);
        }
        
//        tabla.setDefaultRenderer(Object.class, new Render()); 
        
        buscarVentas.forEach((compra)->
        {     
//            Efectivo
//Dinero Electrónico
//Tarjeta de Crédito/Débito
//Otros
            String tipoComprobate = null;
            switch(compra.getFAC_CAB_FORMA_P())
            {
                case 0:
                    tipoComprobate="Efectivo"; break;
                case 1:
                    tipoComprobate="Dinero Electrónico"; break;
                case 2:
                    tipoComprobate="Tarjeta de Crédito/Débito"; break;
                case 3:
                    tipoComprobate="Otros"; break;
            }
            String estado="ANULADO";
            if(compra.isFAC_CAB_ESTADO())
            {
                estado="EMITIDO";
            }
            Object fila []=
            {
                compra.getFAC_CAB_ID(),
                compra.getFAC_CAB_FECHA(),   
                compra.getFAC_CAB_SUBTOTAL(),
                compra.getFAC_CAB_IVA(),
                compra.getFAC_CAB_TOTAL(),
                tipoComprobate,
                compra.getCLIENTE(),
                compra.getUSUARIO(),
                estado
            };            
            modeloTabla1.addRow(fila);
        });
        
        tabla.setModel(modeloTabla1);
        anchoTabla.ajustarAnchoTabla(tabla);
    }

    public void verTablaDetalle(JTable tabla, ArrayList<FacturaDetalleDetallado> buscarDetalle) {
        
        modeloTabla1=new DefaultTableModel();
        anchoTabla=new ajustaAnchoDeJtable();        
        this.detalle= buscarDetalle;
        
        for (int i = 0; i < encavezado3.length; i++) 
        {
            modeloTabla1.addColumn(encavezado3[i]);
        }
        
        numero=0;
        detalle.forEach((compra)->
        {      
            numero++;
            Object fila []=
            {
                numero,
                compra.getPRO_ID(),
                compra.getFAC_DET_CANTIDAD(),
                compra.getPRODUCTO(),   
                compra.getFAC_DET_PVP(),
                compra.getFAC_DET_TOTAL()
            };            
            modeloTabla1.addRow(fila);
        });
        
        tabla.setModel(modeloTabla1);
        anchoTabla.ajustarAnchoTabla(tabla);
    }

    public void VerTablaFacturasAlDetalle(JTable tabla, ArrayList<FacturaAlDetalle> clases) 
    {
        modeloTabla1=new DefaultTableModel();
        anchoTabla=new ajustaAnchoDeJtable();        
        this.buscarVentasAlDetalle= clases;
        
        for (int i = 0; i < encavezado4.length; i++) 
        {
            modeloTabla1.addColumn(encavezado4[i]);
        }
        
        buscarVentasAlDetalle.forEach((compra)->
        {      
            Object fila []=
            {
//                int PRO_ID,
//        String PRO_NOMBRE,
//        String CAT_DESCRIPCION,
//        int FAC_DET_CANTIDAD,
//        double FAC_DET_PVP,
//        double FAC_DET_TOTAL,
//        double FAC_DET_GANANCIA,
//        boolean FAC_CAB_ESTADO
                compra.getPRO_ID(),
                compra.getPRO_NOMBRE(),
                compra.getCAT_DESCRIPCION(),   
                compra.getFAC_DET_CANTIDAD(),
                compra.getFAC_DET_PVP(),
                compra.getFAC_DET_TOTAL(),
                compra.getFAC_DET_GANANCIA()
            };            
            modeloTabla1.addRow(fila);
        });
        
        tabla.setModel(modeloTabla1);
        anchoTabla.ajustarAnchoTabla(tabla);
    }
}
