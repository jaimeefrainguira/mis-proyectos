package vista;

import clases.Kardex;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class vistaKardex 
{
    private DefaultTableModel modeloTabla1;
    public List<Kardex> kardex;
    private ajustaAnchoDeJtable anchoTabla=new ajustaAnchoDeJtable();
    String[]encavezado={
//        int KAR_ID,
//            int PRO_ID,
//            String KAR_FECHA,
//            String KAR_DETALLE,
//            int KAR_ECANT,
//            double KAR_EVU,
//            double KAR_EVT,
//            int KAR_SCANT,
//            double KAR_SVU,
//            double KAR_SVT,
//            int KAR_XCANT,
//            double KAR_XVU,
//            double KAR_XVT
        "FECHA",
        "DETALLE",
        "ENTR. CANT.",
        "ENTR. V. UNIT.",
        "ENTR. V. TOTAL",
        "SALIDA CANT.",
        "SALIDA V. UNIT.",
        "SALIDA V. TOTAL",
        "EXISTENCIAS CANT.",
        "EXISTENCIAS V. UNIT.",
        "EXISTENCIAS V. TOTAL"
    };
    public void verTabla(JTable tabla, ArrayList<Kardex> kardex) 
    {
        
        modeloTabla1=new DefaultTableModel();
        anchoTabla=new ajustaAnchoDeJtable();
        this.kardex= kardex;
        
        for (String encavezado1 : encavezado) {
            modeloTabla1.addColumn(encavezado1);
        }
        
//        tabla.setDefaultRenderer(Object.class, new Render()); 
        
                
        kardex.forEach((karde)->
        { 
            String getKAR_ECANT = null;
if(karde.getKAR_ECANT()!=0){getKAR_ECANT=String.valueOf(karde.getKAR_ECANT());}
            String getKAR_EVU = null;
if(karde.getKAR_EVU()!=0){getKAR_EVU=String.valueOf(karde.getKAR_EVU());}
            String getKAR_EVT = null;
if(karde.getKAR_EVT()!=0){getKAR_EVT=String.valueOf(karde.getKAR_EVT());}
            String getKAR_SCANT = null;
if( karde.getKAR_SCANT()!=0){getKAR_SCANT= String.valueOf(karde.getKAR_SCANT());}
            String getKAR_SVU = null;
if(karde.getKAR_SVU()!=0){getKAR_SVU=String.valueOf(karde.getKAR_SVU());}
            String getKAR_SVT = null;
if(karde.getKAR_SVT()!=0){getKAR_SVT=String.valueOf(karde.getKAR_SVT());}
            
    
                
                
               
                
                
            Object fila []=
            {
                karde.getKAR_FECHA(),
                karde.getKAR_DETALLE(),                
                getKAR_ECANT,
                getKAR_EVU,
                getKAR_EVT,
                getKAR_SCANT,
                getKAR_SVU,
                getKAR_SVT,
                karde.getKAR_XCANT(),
                karde.getKAR_XVU(),
                karde.getKAR_XVT() 
            };            
            modeloTabla1.addRow(fila);
        });
        tabla.setModel(modeloTabla1);
        anchoTabla.ajustarAnchoTabla(tabla);
    }
    
}
