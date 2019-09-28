/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import clases.Persona;
import clases.TipoUsuario;
import clases.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jaimeguiracocha
 */
public class vistaUsuarios 
{
    public DefaultTableModel modeloTabla1;
    public DefaultComboBoxModel lista = new DefaultComboBoxModel();
    private ajustaAnchoDeJtable anchoTabla=new ajustaAnchoDeJtable();
    //Creamos el encavezado para la tabla
    String[]encavezado={
        "ID",
        "CÉDULA",
        "NOMBRE",
        "DIRECCIÓN",
        "TELÉFONO",
        "CORREO",
        "SEXO",
        "ESTADO"
    };
    //Creamos donde se van a almacenar los datos para la tabla
    String[][]datos={};
    public DefaultTableModel verUsuarios(List<Object> arraClase) 
    {
        
        
        modeloTabla1=new DefaultTableModel(datos,encavezado);
        
        for (Object clase : arraClase) 
        {
            Usuario usuarios=(Usuario) clase;
            Object fila []={
                usuarios.getPER_ID(),
                usuarios.getPER_CEDULA(),
                usuarios.getPER_NOMBRE(),
                usuarios.getPER_DIRECCION(),
                usuarios.getPER_TELEFONO(),
                usuarios.getPER_CORREO(),
                usuarios.getPER_SEXO(),
                usuarios.isPER_ESTADO()? 1 : 0,
            };
            modeloTabla1.addRow(fila);
        }        
        return modeloTabla1;        
    }
    
        public void verTabla(JTable tabla, List<Object> u) 
    {
        modeloTabla1=new DefaultTableModel();
        for (int i = 0; i < encavezado.length; i++) 
        {
            modeloTabla1.addColumn(encavezado[i]);
        }
        
        tabla.setDefaultRenderer(Object.class, new Render()); 
        
        modeloTabla1=new DefaultTableModel(datos,encavezado);
        
        for (Object usu : u) 
        {
            Usuario usuarios=(Usuario) usu;
            Object fila []={
                usuarios.getPER_ID(),
                usuarios.getPER_CEDULA(),
                usuarios.getPER_NOMBRE(),
                usuarios.getPER_DIRECCION(),
                usuarios.getPER_TELEFONO(),
                usuarios.getPER_CORREO(),
                usuarios.getPER_SEXO(),
                usuarios.isPER_ESTADO()? 1 : 0,
            };
            modeloTabla1.addRow(fila);
        }
            tabla.setModel(modeloTabla1);
    //        tabla.setRowHeight(60);
            anchoTabla.ajustarAnchoTabla(tabla);
    }

    public void comboboxUsuarios(JComboBox<String> jComboBox3, ArrayList<Object> Usuarios) {
        jComboBox3.removeAllItems();
        Usuarios.forEach((usuario) -> {
            Usuario usuarios=(Usuario) usuario;
            jComboBox3.addItem(usuarios.getPER_NOMBRE());
        });      
        
    }
        
        
    
}
