package vista;

import clases.Persona;
import clases.OrdenReparacion;
import controlador.controladorCliente;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class vistaOrdenReparacion 
{
    private Persona cliente=new Persona();
    private final controladorCliente controladorCliente=new controladorCliente();
    private DefaultTableModel modeloTabla1;
    private DefaultComboBoxModel lista;
    private ajustaAnchoDeJtable anchoTabla;
    public List<OrdenReparacion> Orden;
    private static DefaultTableCellRenderer tcr;
//    Creamos el encavezado para la tabla
   
    String[]encavezado={
        "#",
        "CLIENTE",
        "FECHA",
        "IMEI",
        "MARCA",
        "FECHA_DE_ENTREGA",
        "BATERIA",
        "CHIP",
        "MEMORIA",
        "TAPA",
        "CARGADOR",
        "OTROS",
        "DIAGNOSTICO",
        "TOTAL",
        "ABONO",
        "SALDO",
        "ESTADO"
    };

    public void verTabla(JTable tabla, ArrayList<OrdenReparacion> buscar) 
    {
        modeloTabla1=new DefaultTableModel();
        anchoTabla=new ajustaAnchoDeJtable();        
        this.Orden=buscar;
        
        for (int i = 0; i < encavezado.length; i++) 
        {
            modeloTabla1.addColumn(encavezado[i]);
        }
        
        tabla.setDefaultRenderer(Object.class, new Render()); 
        
        buscar.forEach((OrdenReparacion item)->
        {
            
            String estado="Inactivo";
            if(item.isESTADO())
            {
                estado="Activo";
            }
        
            
            cliente=controladorCliente.getById(String.valueOf(item.getPER_ID()));
            
            String bateria="NO";
            String chip="NO";
            String memoria="NO";
            String tapa="NO";
            String cargador="NO";
            
            if(item.isBATERIA())
            {
                bateria="SI";
            }
            if(item.isCHIP())
            {
                chip="SI";
            }
            if(item.isMEMORIA())
            {
                memoria="SI";
            }
            if(item.isTAPA())
            {
                tapa="SI";
            }
            if(item.isCARGADOR())
            {
                cargador="SI";
            }
                
                
            Object fila []=
            {
                item.getREP_ID(),
                cliente.getPER_NOMBRE(),
                item.getFECHA(),
                item.getIMEI(),
                item.getMARCA(),
                item.getFECHA_DE_ENTREGA(),
                bateria,
                chip,
                memoria,
                tapa,
                cargador,
                item.getOTROS(),
                item.getDIAGNOSTICO(),
                item.getTOTAL(),
                item.getABONO(),
                item.getSALDO(),
                estado                
            };
            modeloTabla1.addRow(fila);            
        });
        tabla.setModel(modeloTabla1);
        anchoTabla.ajustarAnchoTabla(tabla);
    }
    
}
