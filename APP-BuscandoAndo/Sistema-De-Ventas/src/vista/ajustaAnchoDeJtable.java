/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author jaimeguiracocha
 */
public class ajustaAnchoDeJtable 
{
    
    public void ajustarAnchoTabla(JTable tabla) 
    {
        for (int i = 0; i < tabla.getColumnCount()-1; i++) 
        {
            packColumn(tabla, i, 20);
        }
    }
    
    

// Ajusta a largura preferida da coluna visível especificada.
// A coluna será larga o bastante para mostrar o cabeçalho da coluna e a
// célula de maior conteúdo.
    public void packColumn(JTable table, int vColIndex, int margin) 
    {
        TableModel model = table.getModel();
        DefaultTableColumnModel colModel = (DefaultTableColumnModel)table.getColumnModel();
        TableColumn col = colModel.getColumn(vColIndex);
        int width = 0;            // Obtém a largura do cabeçalho da coluna
        TableCellRenderer renderer = col.getHeaderRenderer();
        if (renderer == null) 
        {
            renderer = table.getTableHeader().getDefaultRenderer();
        }
        Component comp = renderer.getTableCellRendererComponent(table, col.getHeaderValue(), false, false, 0, 0);
        width = comp.getPreferredSize().width;            // Obtém a largura maxima da coluna de dados
       
        for (int r=0; r<table.getRowCount(); r++) 
        {
            renderer = table.getCellRenderer(r, vColIndex);
            comp = renderer.getTableCellRendererComponent(table, table.getValueAt(r, vColIndex), false, false, r,vColIndex);
            width = Math.max(width, comp.getPreferredSize().width);
        }
        width += 2*margin;            // Configura a largura
        col.setPreferredWidth(width);
    }
    
}
