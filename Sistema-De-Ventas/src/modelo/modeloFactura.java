/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Conexion.Conexion;
import clases.FacturaAlDetalle;
import clases.FacturaCabeseraDetallada;
import clases.FacturaCabesera;
import clases.FacturaDetalle;
import clases.FacturaDetalleDetallado;
import interfaz.interfazFactura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author jaimeguiracocha
 */
public class modeloFactura implements interfazFactura
{
    private FacturaCabeseraDetallada clasCabesera=new FacturaCabeseraDetallada();
    private ArrayList<FacturaCabesera> listaClase;
    private ArrayList<FacturaCabeseraDetallada> arregloCabesera;
    private ArrayList<FacturaDetalleDetallado> arregloDetalle;
    private ArrayList<FacturaAlDetalle> arregloFacturasAlDetalle;
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    int _KAR_SCANT;
    double _KAR_SVU;
    double _KAR_SVT;
    int _KAR_XCANT;
    double _KAR_XVU;
    double _KAR_XVT;

    @Override
    public boolean registrar(FacturaCabesera cabesera, ArrayList<FacturaDetalle> detalle,int comprobante) {
        
        
        boolean registrar = true;
        
        //condicion para verificar que tipo de comprobante es
        switch(comprobante)
        {
            case 0:
                try 
        {		
           
            
            if(cabesera.getFAC_CAB_ID()==0)
            {
                cabesera.setFAC_CAB_ID(getId());
            }
            sql="CALL CreaModificaFacturaCab(?,?,?,?,?,?,?,?,?,?,?);";
                con=Conexion.conectar();
                
                ps = con.prepareStatement(sql);
                ps.setInt(1,cabesera.getFAC_CAB_ID());
                ps.setString(2, cabesera.getFAC_CAB_FECHA());
                ps.setDouble(3, cabesera.getFAC_CAB_SUBTOTAL());
                ps.setDouble(4, cabesera.getFAC_DET_DESCUENTO());
                ps.setDouble(5, cabesera.getFAC_CAB_IVA());
                ps.setDouble(6, cabesera.getFAC_CAB_TOTAL());
                ps.setInt(7, cabesera.getFAC_CAB_FORMA_P());
                ps.setInt(8, cabesera.getPER_ID());                
                ps.setInt(9, cabesera.getUSUARIO_ID());
                ps.setBoolean(10, true);
                ps.setString(11, "FACTURA");
                ps.executeUpdate();
                ps.close();
                registrar=true;
                con.close();
                if (con.isClosed()) {System.out.println("Desconectado");}
                
                detalle.forEach((itemsDetalle)->
            {                
                try {
                    getUltimoRegistroKardex(itemsDetalle.getPRO_ID());
                    con=Conexion.conectar();
                    sql="CALL CreaModificaFacturaDetalle (?,?,?,?,?,?,?,?,?,?,?,?,?);";
                    ps = con.prepareStatement(sql);
                    ps.setInt(1, cabesera.getFAC_CAB_ID());
                    ps.setInt(2, itemsDetalle.getPRO_ID());
                    ps.setInt(3, itemsDetalle.getFAC_DET_CANTIDAD());
                    ps.setDouble(4, itemsDetalle.getFAC_DET_PVP());
                    ps.setDouble(5, itemsDetalle.getFAC_DET_DESCUENTO());
                    ps.setDouble(6, itemsDetalle.getFAC_DET_TOTAL());
                    ps.setDouble(7, itemsDetalle.getFAC_DET_PC());
                    
                    ps.setString(8, cabesera.getFAC_CAB_FECHA());
                    ps.setString(9, "Venta Segun factura #"+cabesera.getFAC_CAB_ID());
                    ps.setInt(10, _KAR_XCANT);
                    ps.setDouble(11, _KAR_XVU);
                    ps.setDouble(12, _KAR_XVT);
                    
                    ps.setString(13, "FACTURA");
                    ps.executeUpdate();
                    ps.close();                
                    
                } catch (SQLException ex) {
                    System.out.println("Codigo de error: "+ex.getErrorCode()+" "+ex);
                }
                
            });
            registrar=true;
            
            con.close();
            if (con.isClosed()) {System.out.println("Desconectado");}
                
        } 
        catch (SQLException e) 
        {
            if(e.getErrorCode()==1062)
            {
//                JOptionPane.showMessageDialog(null, "Ya existe este tipo de Usuario: "+'"'+categoria.getTIP_USU_DESCRIPCION()+'"');
            }
            
//                System.out.println("Error: Clase ClienteDaoImple, método registrar");
//                e.printStackTrace();
                //extrae el codigo de error
                System.out.println("Codigo de error: "+e.getErrorCode()+" "+e);
                registrar=false;
        } 
        
        
                break;
            case 1:
                try 
        {		
           
            
            if(cabesera.getFAC_CAB_ID()==0)
            {
                cabesera.setFAC_CAB_ID(getIdNota());
            }
            
                cabesera.setFAC_CAB_TOTAL(cabesera.getFAC_CAB_SUBTOTAL());
                sql="CALL CreaModificaFacturaCab(?,?,?,?,?,?,?,?,?,?,?);";
                con=Conexion.conectar();
                
                ps = con.prepareStatement(sql);
                ps.setInt(1,cabesera.getFAC_CAB_ID());
                ps.setString(2, cabesera.getFAC_CAB_FECHA());
                ps.setDouble(3, cabesera.getFAC_CAB_SUBTOTAL());
                ps.setDouble(4, cabesera.getFAC_DET_DESCUENTO());
                ps.setDouble(5, cabesera.getFAC_CAB_IVA());
                ps.setDouble(6, cabesera.getFAC_CAB_TOTAL());
                ps.setInt(7, cabesera.getFAC_CAB_FORMA_P());
                ps.setInt(8, cabesera.getPER_ID());                
                ps.setInt(9, cabesera.getUSUARIO_ID());
                ps.setBoolean(10, true);
                ps.setString(11, "NOTA");
                ps.executeUpdate();
                ps.close();
                registrar=true;
                con.close();
                if (con.isClosed()) {System.out.println("Desconectado");}
                
                
                detalle.forEach((itemsDetalle)->
            {                
                try {
                    getUltimoRegistroKardex(itemsDetalle.getPRO_ID());
                    con=Conexion.conectar();
                    sql="CALL CreaModificaFacturaDetalle (?,?,?,?,?,?,?,?,?,?,?,?,?);";
                    ps = con.prepareStatement(sql);
                    ps.setInt(1, cabesera.getFAC_CAB_ID());
                    ps.setInt(2, itemsDetalle.getPRO_ID());
                    ps.setInt(3, itemsDetalle.getFAC_DET_CANTIDAD());
                    ps.setDouble(4, itemsDetalle.getFAC_DET_PVP());
                    ps.setDouble(5, itemsDetalle.getFAC_DET_DESCUENTO());
                    ps.setDouble(6, itemsDetalle.getFAC_DET_TOTAL());
                    ps.setDouble(7, itemsDetalle.getFAC_DET_PC());
                    
                    ps.setString(8, cabesera.getFAC_CAB_FECHA());
                    ps.setString(9, "Venta Segun Nota de Venta #"+cabesera.getFAC_CAB_ID());
                    ps.setInt(10, _KAR_XCANT);
                    ps.setDouble(11, _KAR_XVU);
                    ps.setDouble(12, _KAR_XVT);
                    
                    ps.setString(13, "NOTA");
                    ps.executeUpdate();
                    ps.close();                
                    
                } catch (SQLException ex) {
                    System.out.println("Codigo de error: "+ex.getErrorCode()+" "+ex);
                }
                
            });
            registrar=true;
            
            con.close();
            if (con.isClosed()) {System.out.println("Desconectado");}
        } 
        catch (SQLException e) 
        {
            if(e.getErrorCode()==1062)
            {
//                JOptionPane.showMessageDialog(null, "Ya existe este tipo de Usuario: "+'"'+categoria.getTIP_USU_DESCRIPCION()+'"');
            }
            
//                System.out.println("Error: Clase ClienteDaoImple, método registrar");
//                e.printStackTrace();
                //extrae el codigo de error
                System.out.println("Codigo de error: "+e.getErrorCode()+" "+e);
                registrar=false;
        } 
        
        
                break;
        }
        
         
        return registrar;
    }

    @Override
    public boolean modificar(FacturaCabesera cabesera) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getId() {
        int id=0;
        

        sql="call getUltimoIdFacturaCab();";

        try 
        {			
            con= Conexion.conectar();
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) 
            {
                id=rs.getInt(1);
            }
            stm.close();
            rs.close();
            con.close();
            if (con.isClosed()) {System.out.println("Desconectado");}
        } 
        catch (SQLException e) 
        {
            System.out.println("Error: Clase ClienteDaoImple, método obtener");
            e.printStackTrace();
        }
        return id+1;
    }
    @Override
    public int getIdNota() {
        int id=0;
        

        sql="call getUltimoIdNotaCab();";

        try 
        {			
            con= Conexion.conectar();
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) 
            {
                id=rs.getInt(1);
            }
            stm.close();
            rs.close();
            con.close();
            if (con.isClosed()) {System.out.println("Desconectado");}
        } 
        catch (SQLException e) 
        {
            System.out.println("Error: Clase ClienteDaoImple, método obtener");
            e.printStackTrace();
        }
        return id+1;
    }

    @Override
    public ArrayList<FacturaCabesera> buscar(String texto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FacturaCabesera buscarById(String texto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void getValorVentaKardexSegunCodigoDetalle(int _PRO_ID,String _KAR_DETALLE)
    {
        sql="call getValorVentaKardexSegunCodigoDetalle("+_PRO_ID+",'"+_KAR_DETALLE+"');";

        try 
        {			
            con= Conexion.conectar();
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) 
            {
                _KAR_SCANT=rs.getInt(1);
                _KAR_SVU=rs.getDouble(2);
                _KAR_SVT=rs.getDouble(3);
            }
            stm.close();
            rs.close();
            con.close();
            if (con.isClosed()) {System.out.println("Desconectado");}
        } 
        catch (SQLException e) 
        {
            System.out.println("Error: Clase ClienteDaoImple, método obtener");
            e.printStackTrace();
        }
    }
    @Override
    public void getUltimoRegistroKardex(int PRO_ID) 
    {

        sql="call getUltimoRegistroKardex("+PRO_ID+");";

        try 
        {			
            con= Conexion.conectar();
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) 
            {
                _KAR_XCANT=rs.getInt(1);
                _KAR_XVU=rs.getDouble(2);
                _KAR_XVT=rs.getDouble(3);
            }
            stm.close();
            rs.close();
            con.close();
            if (con.isClosed()) {System.out.println("Desconectado");}
        } 
        catch (SQLException e) 
        {
            System.out.println("Error: Clase ClienteDaoImple, método obtener");
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<FacturaCabeseraDetallada> buscarVentas(String desde, String hasta,String valores) 
    {
        con =null;
        stm= null;
        rs=null;

        sql="call buscaVentaCabesera('"+desde+"','"+hasta+"','"+valores+"');";
        arregloCabesera= new ArrayList<FacturaCabeseraDetallada>();

        try 
        {			
            con= Conexion.conectar();
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) 
            {   

                FacturaCabeseraDetallada c=new FacturaCabeseraDetallada();
                c.setFAC_CAB_ID(rs.getInt(1));
                c.setFAC_CAB_FECHA(rs.getString(2));
                c.setFAC_CAB_SUBTOTAL(rs.getDouble(3));
                c.setFAC_DET_DESCUENTO(rs.getDouble(4));
                c.setFAC_CAB_IVA(rs.getDouble(5));
                c.setFAC_CAB_TOTAL(rs.getDouble(6));
                c.setFAC_CAB_FORMA_P(rs.getInt(7));
                c.setPER_ID(rs.getInt(8));
                c.setCLIENTE(rs.getString(9));
                c.setUSUARIO_ID(rs.getInt(10));   
                c.setUSUARIO(rs.getString(11));
                c.setFAC_CAB_ESTADO(rs.getBoolean(12)); 
                arregloCabesera.add(c);
            }
            stm.close();
            rs.close();
            con.close();	
            if (con.isClosed()) {System.out.println("Desconectado");}
        }
        catch (SQLException e) 
        {
            System.out.println("Error: Clase ClienteDaoImple, método obtener");
            e.printStackTrace();
        }
        return arregloCabesera;
    }

    @Override
    public ArrayList<FacturaDetalleDetallado> buscarDetalle(int codigoCabesera) 
    {
        con =null;
        stm= null;
        rs=null;

        sql="call buscaFacturaDetalle("+codigoCabesera+");";
        arregloDetalle= new ArrayList<FacturaDetalleDetallado>();

        try 
        {			
            con= Conexion.conectar();
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) 
            {
                
//                FD.FAC_CAB_ID, 
//    FD.FAC_DET_CANTIDAD, 
//    FD.PRO_ID, 
//                P.PRO_NOMBRE, 
//    FD.FAC_DET_PVP,
//	FD.FAC_DET_DESCUENTO,
//    FD.FAC_DET_TOTAL 
            
                FacturaDetalleDetallado c=new FacturaDetalleDetallado();
                c.setFAC_CAB_ID(rs.getInt(1));
                c.setPRO_ID(rs.getInt(3));
                c.setFAC_DET_CANTIDAD(rs.getInt(2));
                c.setFAC_DET_PVP(rs.getDouble(5));
                c.setFAC_DET_DESCUENTO(rs.getDouble(6));
                c.setFAC_DET_TOTAL(rs.getDouble(7)); 
                c.setPRODUCTO(rs.getString(4));
                arregloDetalle.add(c);
            }
            stm.close();
            rs.close();
            con.close();	
            if (con.isClosed()) {System.out.println("Desconectado");}
        }
        catch (SQLException e) 
        {
            System.out.println("Error: Clase ClienteDaoImple, método obtener");
            e.printStackTrace();
        }
        return arregloDetalle;
    }

    @Override
    public void anular(ArrayList<FacturaDetalleDetallado> detalle, int fila) 
    {
        clasCabesera=arregloCabesera.get(fila);
        
//        arregloDetalle=detalle;
        int af=0;
        int a=0;
        con =null;

        sql="call anularFacturaCabesera("+clasCabesera.getFAC_CAB_ID()+");";
        
//        arregloDetalle= new ArrayList<AnularComprasDetalle>();

        try 
        {			
            con=Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();  
//            con.close();	
            if (con.isClosed()) {System.out.println("Desconectado");}
        }
        catch (SQLException e) 
        {
            System.out.println("Error: Clase ClienteDaoImple, método obtener");
            e.printStackTrace();
        }
        
        
        try 
        {
//            con=Conexion.conectar();
            
            detalle.forEach((itemsDetalle)->
            {
                try {
                    getValorVentaKardexSegunCodigoDetalle(itemsDetalle.getPRO_ID(),"Venta Segun factura #"+itemsDetalle.getFAC_CAB_ID());
                    getUltimoRegistroKardex(itemsDetalle.getPRO_ID());
                    con=Conexion.conectar();
                    sql="CALL CreaModificaFacturaDetalle (?,?,?,?,?,?,?,?,?,?,?,?);";
                    ps = con.prepareStatement(sql);
                    ps.setInt(1, itemsDetalle.getFAC_CAB_ID());
                    ps.setInt(2, itemsDetalle.getPRO_ID());
                    ps.setInt(3, _KAR_SCANT);
                    ps.setDouble(4, _KAR_SVU);
                    ps.setDouble(5, _KAR_SVT);
                    ps.setDouble(6, itemsDetalle.getFAC_DET_PC());
                    ps.setString(7, clasCabesera.getFAC_CAB_FECHA());
                    ps.setString(8, "Devolucion Segun Venta #"+itemsDetalle.getFAC_CAB_ID());
                    ps.setInt(9, _KAR_XCANT);
                    ps.setDouble(10, _KAR_XVU);
                    ps.setDouble(11, _KAR_XVT);
                    
                    ps.setString(12, "ANULAR");
                    ps.executeUpdate();
                    ps.close();                
                    
                } catch (SQLException ex) {
                    System.out.println("Codigo de error: "+ex.getErrorCode()+" "+ex);
                }
                
            });
//            registrar=true;
            
            con.close();
            if (con.isClosed()) {System.out.println("Desconectado");}
        } 
        catch (SQLException e) 
        {
            if(e.getErrorCode()==1062)
            {
//                JOptionPane.showMessageDialog(null, "Ya existe este tipo de Usuario: "+'"'+categoria.getTIP_USU_DESCRIPCION()+'"');
            }
            
//                System.out.println("Error: Clase ClienteDaoImple, método registrar");
//                e.printStackTrace();
                //extrae el codigo de error
                System.out.println("Codigo de error: "+e.getErrorCode()+" "+e);
        } 
//        return true;
    }

    @Override
    public ArrayList<FacturaAlDetalle> buscarVentasAlDetalle(JTable jTable1, String desde, String hasta) 
    {
       con =null;
        stm= null;
        rs=null;

        sql="call consultasDetalladas('"+desde+"','"+hasta+"','VENTAS');";
        arregloFacturasAlDetalle= new ArrayList<FacturaAlDetalle>();

        try 
        {			
            con= Conexion.conectar();
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) 
            {
                FacturaAlDetalle c=new FacturaAlDetalle();
                c.setPRO_ID(rs.getInt(1));
                c.setPRO_NOMBRE(rs.getString(3));
                c.setCAT_DESCRIPCION(rs.getString(4));
                c.setFAC_DET_CANTIDAD(rs.getInt(5));
                c.setFAC_DET_PVP(rs.getDouble(6));
                c.setFAC_DET_DESCUENTO(rs.getDouble(7));
                c.setFAC_DET_TOTAL(rs.getDouble(8));
                c.setFAC_DET_GANANCIA(rs.getDouble(9));
                arregloFacturasAlDetalle.add(c);
            }
            stm.close();
            rs.close();
            con.close();	
            if (con.isClosed()) {System.out.println("Desconectado");}
        }
        catch (SQLException e) 
        {
            System.out.println("Error: Clase ClienteDaoImple, método obtener");
            e.printStackTrace();
        }
        return arregloFacturasAlDetalle;
    }

    
    
}
