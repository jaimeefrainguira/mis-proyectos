package vista;

import clases.TipoUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class vistaTipoUsuario 
{
    public DefaultTableModel modeloTabla1;
    public DefaultComboBoxModel lista = new DefaultComboBoxModel();
    private ajustaAnchoDeJtable anchoTabla=new ajustaAnchoDeJtable();
    //Creamos el encavezado para la tabla
    String[]encavezado={
        "ID",
        "DESCRIPCIÓN",
        "PRODUCTO",
        "MERCADERIA",
        "COMPRAS",
        "PROVEEDORES",
        "VENTA",
        "CLIENTES",
        "VERIFICAR PRODUCTO",
        "VENTAS REALIZADAS",
        "VENTAS DETALLADAS",
        "ESTADISTICA MENSUAL",
        "COMPRAS REALIZADAS",
        "COMPRAS DETALLADAS",
        "EMPLEADOS",
        "TIPO DE USUARIO",
        "SERVICIO TECNICO",
        "ANULAR VENTA",
        "ANULAR COMPRA",
        "CAMBIAR CONTRASEÑA",
        "USUARIOS",
        "RESPALDAR BD",
        "RESTAURAR BD"
    };
    //Creamos donde se van a almacenar los datos para la tabla
    String[][]datos={};
    
//    public void verCliente(Cliente cliente) 
//    {
//        System.out.println("Datos del Cliente: "+cliente);
//    }
    
//    public DefaultTableModel verTipoUsuarios(List<TipoUsuario> tipoUsuario) 
//    {
//        
//        
//        modeloTabla1=new DefaultTableModel(datos,encavezado);
//        
//        for (TipoUsuario tipoUsuarios : tipoUsuario) 
//        {
//
//            Object fila []={
//                tipoUsuarios.getTIP_USU_ID(),                
//                tipoUsuarios.getTIP_USU_DESCRIPCION(),
//                tipoUsuarios.isTIP_USU_PRODUCTO()? 1 : 0,
//                tipoUsuarios.isTIP_USU_MERCADERIA()? 1 : 0,
//                tipoUsuarios.isTIP_USU_COMPRAS()? 1 : 0,
//                tipoUsuarios.isTIP_USU_PROVEEDORES()? 1 : 0,
//                tipoUsuarios.isTIP_USU_VENTA()? 1 : 0,
//                tipoUsuarios.isTIP_USU_CLIENTES()? 1 : 0,
//                tipoUsuarios.isTIP_USU_VERIFICAR_PRODUCTO()? 1 : 0,
//                tipoUsuarios.isTIP_USU_VENTAS_REALIZADAS()? 1 : 0,
//                tipoUsuarios.isTIP_USU_VENTAS_DETALLADAS()? 1 : 0,
//                tipoUsuarios.isTIP_USU_ESTADISTICA_MENSUAL()? 1 : 0,
//                tipoUsuarios.isTIP_USU_COMPRAS_REALIZADAS()? 1 : 0,
//                tipoUsuarios.isTIP_USU_COMPRAS_DETALLADAS()? 1 : 0,
//                tipoUsuarios.isTIP_USU_EMPLEADOS()? 1 : 0,
//                tipoUsuarios.isTIP_USU_TIPO_DE_USUARIO()? 1 : 0,
//                tipoUsuarios.isTIP_USU_SERVICIO_TECNICO()? 1 : 0,
//                tipoUsuarios.isTIP_USU_ANULAR_VENTA()? 1 : 0,
//                tipoUsuarios.isTIP_USU_ANULAR_COMPRA()? 1 : 0,
//                tipoUsuarios.isTIP_USU_CAMBIAR_CONTRASEÑA()? 1 : 0,
//                tipoUsuarios.isTIP_USU_USUARIOS()? 1 : 0,
//                tipoUsuarios.isTIP_USU_RESPALDAR_BD()? 1 : 0,
//                tipoUsuarios.isTIP_USU_RESTAURAR_BD()? 1 : 0
//            };
//            modeloTabla1.addRow(fila);
//        }        
//        return modeloTabla1;        
//    }
    
    
    
    public DefaultComboBoxModel listaTipoUsuarios(List<TipoUsuario> tipoUsuario)
    {
        //Recorrer el contenido del ArrayList
        int a=0;
        String[] vector=new String[tipoUsuario.size()];
        
        for (TipoUsuario tipoUsuarios : tipoUsuario) 
        {
            vector[a]=tipoUsuarios.getTIP_USU_DESCRIPCION();
            a++;
        }
        
        for(int i = 0;i < vector.length;i++) 
        {
            lista.addElement(vector[i]);
        }
        return lista;
    }
    
    
    public void verTabla(JTable tabla, List<TipoUsuario> tipoUsuario) 
    {
        modeloTabla1=new DefaultTableModel();
        for (int i = 0; i < encavezado.length; i++) 
        {
            modeloTabla1.addColumn(encavezado[i]);
        }
        
        tabla.setDefaultRenderer(Object.class, new Render()); 
        
        for (TipoUsuario tipoUsuarios : tipoUsuario) 
        {

            Object fila []={
                tipoUsuarios.getTIP_USU_ID(),                
                tipoUsuarios.getTIP_USU_DESCRIPCION(),
                tipoUsuarios.isTIP_USU_PRODUCTO()? 1 : 0,
                tipoUsuarios.isTIP_USU_MERCADERIA()? 1 : 0,
                tipoUsuarios.isTIP_USU_COMPRAS()? 1 : 0,
                tipoUsuarios.isTIP_USU_PROVEEDORES()? 1 : 0,
                tipoUsuarios.isTIP_USU_VENTA()? 1 : 0,
                tipoUsuarios.isTIP_USU_CLIENTES()? 1 : 0,
                tipoUsuarios.isTIP_USU_VERIFICAR_PRODUCTO()? 1 : 0,
                tipoUsuarios.isTIP_USU_VENTAS_REALIZADAS()? 1 : 0,
                tipoUsuarios.isTIP_USU_VENTAS_DETALLADAS()? 1 : 0,
                tipoUsuarios.isTIP_USU_ESTADISTICA_MENSUAL()? 1 : 0,
                tipoUsuarios.isTIP_USU_COMPRAS_REALIZADAS()? 1 : 0,
                tipoUsuarios.isTIP_USU_COMPRAS_DETALLADAS()? 1 : 0,
                tipoUsuarios.isTIP_USU_EMPLEADOS()? 1 : 0,
                tipoUsuarios.isTIP_USU_TIPO_DE_USUARIO()? 1 : 0,
                tipoUsuarios.isTIP_USU_SERVICIO_TECNICO()? 1 : 0,
                tipoUsuarios.isTIP_USU_ANULAR_VENTA()? 1 : 0,
                tipoUsuarios.isTIP_USU_ANULAR_COMPRA()? 1 : 0,
                tipoUsuarios.isTIP_USU_CAMBIAR_CONTRASEÑA()? 1 : 0,
                tipoUsuarios.isTIP_USU_USUARIOS()? 1 : 0,
                tipoUsuarios.isTIP_USU_RESPALDAR_BD()? 1 : 0,
                tipoUsuarios.isTIP_USU_RESTAURAR_BD()? 1 : 0
            };
            modeloTabla1.addRow(fila);
            tabla.setModel(modeloTabla1);
    //        tabla.setRowHeight(60);
            anchoTabla.ajustarAnchoTabla(tabla);
        }
    }

    
        
        
}