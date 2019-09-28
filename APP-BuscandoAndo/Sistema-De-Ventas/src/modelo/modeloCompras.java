package modelo;

import Conexion.Conexion;
import clases.ComprasCabeseraDetallada;
import clases.ComprasDetalleDetallado;
import clases.ComprasCabesera;
import clases.ComprasDetalladas;
import clases.ComprasDetalle;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import interfaz.interfazCompras;
import java.util.List;
import javax.swing.JTable;

public class modeloCompras implements interfazCompras
{
    private ComprasCabeseraDetallada clasCabesera=new ComprasCabeseraDetallada();
    private ArrayList<ComprasCabesera> arrayClases;
    private ArrayList<ComprasCabeseraDetallada> arregloCabesera;
    private ArrayList<ComprasDetalladas> arregloComprasDetalladas;
    private ArrayList<ComprasDetalleDetallado> arregloDetalle;
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    private int COM_CAB_ID;
    int _KAR_XCANT;
    double _KAR_XVU;
    double _KAR_XVT;

    @Override
    public boolean registrar(ComprasCabesera compras,ArrayList<ComprasDetalle> detalle) 
    {
//        Date xxx= compras.getCOM_CAB_FECHA();
//        java.sql.Date fec=(java.sql.Date) xxx;
        boolean registrar = false;
        
        
        try 
        {		
           
            COM_CAB_ID=compras.getCOM_CAB_ID();
            if(COM_CAB_ID==0)
            {
                COM_CAB_ID=getId();
            }
   
//    DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
//    java.sql.Date sqlDate = new java.sql.Date(df.parse("02-04-2015").getTime());
//java.sql.Date sqlDate = new java.sql.Date(df.parse("02-04-2015").getTime())
            
                con=Conexion.conectar();
                sql="CALL CreaModificaComprasCab (?,?,?,?,?,?,?,?,?,?,?);";
                ps = con.prepareStatement(sql);
                ps.setInt(1, COM_CAB_ID);
                ps.setInt(2, compras.getCOM_CAB_PROVEEDOR_ID());
                ps.setInt(3, compras.getCOM_CAB_USUARIO_ID());
                ps.setString(4, compras.getCOM_CAB_FECHA());
                ps.setInt(5, compras.getCOM_CAB_TIPO_COMPROVANTE());
                ps.setInt(6, compras.getCOM_CAB_NUM_COMPROVANTE());
                ps.setDouble(7, compras.getCOM_CAB_SUBTOTAL());
                ps.setDouble(8, compras.getCOM_CAB_IVA());
                ps.setDouble(9, compras.getCOM_CAB_TOTAL());
                ps.setBoolean(10, true);
                ps.setString(11, "CREAR");
                ps.executeUpdate();
                ps.close();
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
        } 
        
        //registro de detalle
        
        
//    in _COM_CAB_ID int(10),
//    in _PRO_ID int(10),
//    in _COM_DET_CATIDAD int(10),
//    in _COM_DET_VALOR double,
//    in _COM_DET_TOTAL double,
//    
//    in _KAR_FECHA date,
//    IN _KAR_DETALLE varchar(500),
//    in _KAR_XCANT int(10),
//    in _KAR_XVU double,
//    in _KAR_XVT double,
//
// IN `ACCION` VARCHAR(40)
        
        try 
        {
            
            
            detalle.forEach((itemsDetalle)->
            {
                try {
                    getUltimoRegistroKardex(itemsDetalle.getPRO_ID());
                    
                    con=Conexion.conectar();
                    sql="CALL CreaModificaComprasDetalle (?,?,?,?,?,?,?,?,?,?,?);";
                    ps = con.prepareStatement(sql);
                    ps.setInt(1, COM_CAB_ID);
                    ps.setInt(2, itemsDetalle.getPRO_ID());
                    ps.setInt(3, itemsDetalle.getCOM_DET_CATIDAD());
                    ps.setDouble(4, itemsDetalle.getCOM_DET_VALOR());
                    ps.setDouble(5, itemsDetalle.getCOM_DET_TOTAL());
                    
                    ps.setString(6, compras.getCOM_CAB_FECHA());
                    ps.setString(7, "Segun Compra #"+COM_CAB_ID);
                    ps.setInt(8, _KAR_XCANT);
                    ps.setDouble(9, _KAR_XVU);
                    ps.setDouble(10, _KAR_XVT);
                    
                    ps.setString(11, "CREAR");
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
        } 
        return registrar;
        
    }

    @Override
    public boolean modificar(ComprasCabesera compras) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getId() 
    {
        int id=0;
        con =null;
        stm= null;
        rs=null;

        sql="call getUltimoIdComprasCab();";

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
    
    public void getUltimoRegistroKardex(int PRO_ID)
    {
        
        con =null;
        stm= null;
        rs=null;

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
    public ArrayList<ComprasCabeseraDetallada> buscar(String desde,String hasta,int tipo,String valores) 
    {
        
        con =null;
        stm= null;
        rs=null;

        sql="call buscaCompraCab('"+desde+"','"+hasta+"',"+tipo+",'"+valores+"');";
        arregloCabesera= new ArrayList<ComprasCabeseraDetallada>();

        try 
        {			
            con= Conexion.conectar();
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) 
            {
                ComprasCabeseraDetallada c=new ComprasCabeseraDetallada();
                c.setCOM_CAB_ID(rs.getInt(1));
                c.setCOM_CAB_PROVEEDOR_ID(rs.getInt(2));
                c.setPROVEEDOR(rs.getString(3));
                c.setCOM_CAB_USUARIO_ID(rs.getInt(4));
                c.setUSUARIO(rs.getString(5));
                c.setCOM_CAB_FECHA(rs.getString(6));
                c.setCOM_CAB_TIPO_COMPROVANTE(rs.getInt(7));
                c.setCOM_CAB_NUM_COMPROVANTE(rs.getInt(8));
                c.setCOM_CAB_SUBTOTAL(rs.getDouble(9));   
                c.setCOM_CAB_IVA(rs.getDouble(10));   
                c.setCOM_CAB_TOTAL(rs.getDouble(11)); 
                c.setCOM_CAB_ESTADO(rs.getBoolean(12)); 
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
    public ComprasCabesera buscarById(String texto) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ComprasDetalleDetallado> buscarDetalle(int codigo) 
    {        
        con =null;
        stm= null;
        rs=null;

        sql="call buscaCompraDetalle("+codigo+");";
        arregloDetalle= new ArrayList<ComprasDetalleDetallado>();

        try 
        {			
            con= Conexion.conectar();
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) 
            {
                ComprasDetalleDetallado c=new ComprasDetalleDetallado();
                c.setPRODUCTO(rs.getString(3));
                c.setPRO_ID(rs.getInt(2));
                c.setCOM_DET_CATIDAD(rs.getInt(1));
                c.setCOM_DET_VALOR(rs.getDouble(4));
                c.setCOM_DET_TOTAL(rs.getDouble(5)); 
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
    public boolean anularCompra(ArrayList<ComprasDetalleDetallado> detalle, int fila) 
    {
        
       clasCabesera=arregloCabesera.get(fila);
        
//        arregloDetalle=detalle;
        int af=0;
        int a=0;
        con =null;

        sql="call anularCompraCabesera("+clasCabesera.getCOM_CAB_ID()+");";
        
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
                    getUltimoRegistroKardex(itemsDetalle.getPRO_ID());
                    con=Conexion.conectar();
                    sql="CALL CreaModificaComprasDetalle (?,?,?,?,?,?,?,?,?,?,?);";
                    ps = con.prepareStatement(sql);
                    ps.setInt(1, clasCabesera.getCOM_CAB_ID());
                    ps.setInt(2, itemsDetalle.getPRO_ID());
                    ps.setInt(3, -itemsDetalle.getCOM_DET_CATIDAD());
                    ps.setDouble(4, -itemsDetalle.getCOM_DET_VALOR());
                    ps.setDouble(5, -itemsDetalle.getCOM_DET_TOTAL());
                    
                    ps.setString(6, clasCabesera.getCOM_CAB_FECHA());
                    ps.setString(7, "Devolucion Segun Compra #"+clasCabesera.getCOM_CAB_ID());
                    ps.setInt(8, _KAR_XCANT);
                    ps.setDouble(9, _KAR_XVU);
                    ps.setDouble(10, _KAR_XVT);
                    
                    ps.setString(11, "ANULAR");
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
        return true;
    }

    @Override
    public ArrayList<ComprasDetalladas> getComprasDetalladas(JTable tabla, String desde, String hasta) 
    {
        con =null;
        stm= null;
        rs=null;

        sql="call consultasDetalladas('"+desde+"','"+hasta+"','COMPRAS');";
        arregloComprasDetalladas= new ArrayList<ComprasDetalladas>();

        try 
        {			
            con= Conexion.conectar();
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) 
            {
                ComprasDetalladas c=new ComprasDetalladas();
                c.setPRO_ID(rs.getInt(1));
                c.setPRO_NOMBRE(rs.getString(3));
                c.setCAT_DESCRIPCION(rs.getString(4));
                c.setCOM_DET_CATIDAD(rs.getInt(5));
                c.setCOM_DET_VALOR(rs.getDouble(6));
                c.setCOM_DET_TOTAL(rs.getDouble(7));
                arregloComprasDetalladas.add(c);
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
        return arregloComprasDetalladas;
    }
    
    
}
