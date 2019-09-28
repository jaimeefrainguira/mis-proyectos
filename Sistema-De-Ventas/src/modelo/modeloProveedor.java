package modelo;

import Conexion.Conexion;
import clases.Persona;
import clases.Proveedor;
import interfaz.interfazDAO;
import interfaz.interfazPersona;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class modeloProveedor implements interfazDAO, interfazPersona
{
    private final interfazPersona dao= new  modeloPersona();
    private ArrayList<Object> arrayClases;

    @Override
    public boolean registrar(Object clase) throws Exception {
        
        Persona proveedor=(Persona) clase;
        
        boolean registrar = false;	
        
        Statement stm= null;
        Connection con=null;
        
        proveedor.setPER_ID(getId());
        String sql1="call CrearModificaProveedor("
                +proveedor.getPER_ID()+",'"
                +proveedor.getPER_CEDULA()+"','"
                +proveedor.getPER_NOMBRE()+"','"
                +proveedor.getPER_DIRECCION()+"','"
                +proveedor.getPER_TELEFONO()+"','"
                +proveedor.getPER_CORREO()+"','"
                +proveedor.getPER_SEXO()+"','"               
                +proveedor.getPER_FECHA_REGISTRO()+"','"
                +proveedor.getPER_OBSERVACION()+"',"
                +proveedor.isPER_ESTADO()+",'CREAR')";
        try 
        {			
                con=Conexion.conectar();
                stm= con.createStatement();
                System.out.println(sql1);
                
                stm.execute(sql1);
                registrar=true;
                stm.close();
                con.close();
                if (con.isClosed()) {System.out.println("Desconectado");}
        } 
        catch (SQLException e) 
        {
               throw new Exception(String.valueOf(e.getErrorCode()));
        }
        return registrar;  
    }

    @Override
    public boolean actualizar(Object clase) {
        
        Persona proveedor=(Persona) clase;
        
        boolean registrar = false;
		
        Statement stm= null;
        Connection con=null;
        
        String sql1="call CrearModificaProveedor("
                +proveedor.getPER_ID()+",'"
                +proveedor.getPER_CEDULA()+"','"
                +proveedor.getPER_NOMBRE()+"','"
                +proveedor.getPER_DIRECCION()+"','"
                +proveedor.getPER_TELEFONO()+"','"
                +proveedor.getPER_CORREO()+"','"
                +proveedor.getPER_SEXO()+"','"                
                +proveedor.getPER_FECHA_REGISTRO()+"','"                
                +proveedor.getPER_OBSERVACION()+"',"
                +proveedor.isPER_ESTADO()+",'MODIFICAR')";
        try 
        {			
                con=Conexion.conectar();
                stm= con.createStatement();
                stm.execute(sql1);
                registrar=true;
                stm.close();
                con.close();
                if (con.isClosed()) {System.out.println("Desconectado");}
        } 
        catch (SQLException e) 
        {
                System.out.println("Error: Clase ProveedorDaoImple, método registrar");
                e.printStackTrace();
        }
        return registrar;
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Object> buscar(String texto) {
        
        Connection con =null;
        Statement stm= null;
        ResultSet rs=null;

        String sql="CALL buscaProveedor('%"+texto+"%','TODO');";
        
        arrayClases= new ArrayList<Object>();

        try 
        {			
            con= Conexion.conectar();
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) 
            {
                Proveedor c=new Proveedor();
                c.setPER_ID(rs.getInt(1));
                c.setPER_CEDULA(rs.getString(2));
                c.setPER_NOMBRE(rs.getString(3));
                c.setPER_DIRECCION(rs.getString(4));
                c.setPER_TELEFONO(rs.getString(5));
                c.setPER_CORREO(rs.getString(6));
                c.setPER_SEXO(rs.getString(7));
                c.setPER_FECHA_REGISTRO(rs.getString(8));
                c.setPER_OBSERVACION(rs.getString(9));
                c.setPROV_ESTADO(rs.getBoolean(10));   
                arrayClases.add(c);
            }
            stm.close();
            rs.close();
            con.close();	
            if (con.isClosed()) {System.out.println("Desconectado");}
        } 
        catch (SQLException e) 
        {
            System.out.println("Error: Clase ProveedorDaoImple, método obtener");
            e.printStackTrace();
        }
        return arrayClases;
    }

    @Override
    public Object buscarById(String texto) {
        Connection con =null;
        Statement stm= null;
        ResultSet rs=null;
        String sql="CALL buscaProveedor('"+texto+"%','ID');";
        Proveedor c=null;
        try 
        {	
            
            con= Conexion.conectar();
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) 
            {
                c=new Proveedor();
                c.setPER_ID(rs.getInt(1));
                c.setPER_CEDULA(rs.getString(2));
                c.setPER_NOMBRE(rs.getString(3));
                c.setPER_DIRECCION(rs.getString(4));
                c.setPER_TELEFONO(rs.getString(5));
                c.setPER_CORREO(rs.getString(6));
                c.setPER_SEXO(rs.getString(7));
                c.setPER_FECHA_REGISTRO(rs.getString(8));
                c.setPER_OBSERVACION(rs.getString(9));
                c.setPER_ESTADO(rs.getBoolean(10));                
            }
            stm.close();
            rs.close();
            con.close();
            if (con.isClosed()) {System.out.println("Desconectado");}
        } 
        catch (SQLException e) 
        {
            System.out.println("Error: Clase ProveedorDaoImple, método obtener");
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(modeloUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    @Override
    public int getId() 
    {
        return dao.getId();
    }

    public ArrayList<Object> buscarByNombre(String texto) 
    {
        Connection con =null;
        Statement stm= null;
        ResultSet rs=null;        
        
//        CALL TIPO_USUARIO_CRUDBD (1,'A%',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,TRUE,'LEER_BY_DESCRIPCION');
        
    
        String sql="CALL buscaProveedor('%"+texto+"%','NOMBRE');";
        
        arrayClases= new ArrayList<Object>();

        try 
        {			
            con= Conexion.conectar();
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) 
            {
                Proveedor c=new Proveedor();
                c.setPER_ID(rs.getInt(1));
                c.setPER_CEDULA(rs.getString(2));
                c.setPER_NOMBRE(rs.getString(3));
                c.setPER_DIRECCION(rs.getString(4));
                c.setPER_TELEFONO(rs.getString(5));
                c.setPER_CORREO(rs.getString(6));
                c.setPER_SEXO(rs.getString(7));
                c.setPER_FECHA_REGISTRO(rs.getString(8));
                c.setPER_OBSERVACION(rs.getString(9));
                c.setPROV_ESTADO(rs.getBoolean(10));   
                arrayClases.add(c);
            }
            stm.close();
            rs.close();
            con.close();	
            if (con.isClosed()) {System.out.println("Desconectado");}
        } 
        catch (SQLException e) 
        {
            System.out.println("Error: Clase ProveedorDaoImple, método obtener");
            e.printStackTrace();
        }
        return arrayClases;
    }
}
