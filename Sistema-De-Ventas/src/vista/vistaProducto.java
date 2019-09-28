/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import clases.Categoria;
import clases.Producto;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelo.modeloCategoria;

/**
 *
 * @author jaimeguiracocha
 */
public class vistaProducto {
    private DefaultTableModel modeloTabla1;
    private DefaultComboBoxModel lista;
    private ajustaAnchoDeJtable anchoTabla;
    public List<Producto> producto;
    private static DefaultTableCellRenderer tcr;
    //Creamos el encavezado para la tabla
   
    String[]encavezado={
        "ID",
        "NOMBRE",
        "DESCRIPCION",
        "PRECIO_COSTO",
        "PRECIO_VENTA",
        "STOCK",
        "STOCK_MINIMO",
        "ESTADO",
        "CATEGORIA",
    };
    //Creamos donde se van a almacenar los datos para la tabla
    public void verTabla(JTable tabla, List<Producto> producto) 
    {
        modeloTabla1=new DefaultTableModel();
        anchoTabla=new ajustaAnchoDeJtable();        
        this.producto=producto;
        
        for (int i = 0; i < encavezado.length; i++) 
        {
            modeloTabla1.addColumn(encavezado[i]);
        }
        
//        tabla.setDefaultRenderer(Object.class, new Render()); 
        
        producto.forEach((productos)->
        {
            modeloCategoria categoria=new modeloCategoria();
            Categoria cat=categoria.buscar(String.valueOf(productos.getCAT_ID())).get(0);
            String estado="Inactivo";
            if(productos.isPRO_ESTADO())
            {
                estado="Activo";
            }
            
            Object fila []=
            {
                productos.getPRO_ID(),                
                productos.getPRO_NOMBRE(),
                productos.getPRO_DESCRIPCION(),
                new Float(productos.getPRO_PRECIO_COSTO()),
                new Float(productos.getPRO_PRECIO_VENTA()),
                productos.getPRO_STOCK(),
                productos.getPRO_STOCK_MINIMO(),
                estado,
                cat.getCAT_DESCRIPCION()
                
            };
            modeloTabla1.addRow(fila);            
        });
        tabla.setModel(modeloTabla1);
//        tabla.setRowHeight(30);
        anchoTabla.ajustarAnchoTabla(tabla);
        
        //Indicamos la alineacion de las columnas
        tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.RIGHT); //CENTER o LEFT
        tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
        tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
        tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
        tabla.getColumnModel().getColumn(6).setCellRenderer(tcr);
        
    }
}
