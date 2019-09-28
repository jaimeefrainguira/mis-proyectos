/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import clases.Categoria;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jaimeguiracocha
 */
public class vistaCategoria 
{
    private DefaultTableModel modeloTabla1;
    private DefaultComboBoxModel lista;
    private ajustaAnchoDeJtable anchoTabla;
    public List<Categoria> categoria;
    //Creamos el encavezado para la tabla
   
    String[]encavezado={
        "ID",
        "DESCRIPCIÓN",
        "IMÁGEN"
    };
    //Creamos donde se van a almacenar los datos para la tabla
    public void verTabla(JTable tabla, List<Categoria> categoria) 
    {
        modeloTabla1=new DefaultTableModel();
        anchoTabla=new ajustaAnchoDeJtable();        
        this.categoria=categoria;
        
        for (int i = 0; i < encavezado.length; i++) 
        {
            modeloTabla1.addColumn(encavezado[i]);
        }
        
        tabla.setDefaultRenderer(Object.class, new Render()); 
        
        for (Categoria categorias : categoria) 
        {
            JLabel lbl;
            try
            {
                byte[] bi = categorias.getCAT_IMAGEN();
                BufferedImage image = null;
                InputStream in = new ByteArrayInputStream(bi);
                image = ImageIO.read(in);
                ImageIcon imgi = new ImageIcon(image.getScaledInstance(30, 30, 0));
                lbl = new JLabel(imgi);
            }
            catch(Exception ex)
            {
                lbl = new JLabel("No imagen");                
            }
            Object fila []=
            {
                categorias.getCAT_ID(),                
                categorias.getCAT_DESCRIPCION(),
                lbl
            };
            modeloTabla1.addRow(fila);            
        }
        tabla.setModel(modeloTabla1);
        tabla.setRowHeight(30);
        anchoTabla.ajustarAnchoTabla(tabla);
    }
    public void verComboBox(JComboBox<String> prod_opciones,List<Categoria> categoria)
    {
        this.categoria=categoria;
        
        categoria.forEach((categorias) -> {
            prod_opciones.addItem(categorias.getCAT_DESCRIPCION());
        });
    }
}   

