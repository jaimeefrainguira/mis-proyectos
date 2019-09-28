package modelo;

import Conexion.Conexion;
import EncriptarDesencriptar.Utilidades;
import clases.Persona;
import clases.Usuario;
//import interfaz.interfazCliente;
import interfaz.interfazDAO;
import interfaz.interfazPersona;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class modeloCliente implements interfazDAO, interfazPersona
{
    private final interfazPersona dao= new  modeloPersona();
    private ArrayList<Object> arrayClases;

    @Override
    public boolean registrar(Object clase) throws Exception
    {    
        Persona cliente=(Persona) clase;  
        boolean registrar = false;
        Statement stm= null;
        Connection con=null;
        
        cliente.setPER_ID(getId());
        String sql1="call CrearModificaCliente("
                +cliente.getPER_ID()+",'"
                +cliente.getPER_CEDULA()+"','"
                +cliente.getPER_NOMBRE()+"','"
                +cliente.getPER_DIRECCION()+"','"
                +cliente.getPER_TELEFONO()+"','"
                +cliente.getPER_CORREO()+"','"
                +cliente.getPER_SEXO()+"','"                
                
                +cliente.getPER_FECHA_REGISTRO()+"','"
                +cliente.getPER_OBSERVACION()+"',"
                +cliente.isPER_ESTADO()+",'CREAR')";
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
                throw new Exception(String.valueOf(e.getErrorCode()));               
//                System.out.println("Error: Clase ClienteDaoImple, método registrar");
//                e.printStackTrace();
            
        }
        return registrar;  
    }

    @Override
    public boolean actualizar(Object clase) 
    {
        Persona cliente=(Persona) clase;  
        boolean registrar = false;		
        Statement stm= null;
        Connection con=null;
        
        String sql1="call CrearModificaCliente("
                +cliente.getPER_ID()+",'"
                +cliente.getPER_CEDULA()+"','"
                +cliente.getPER_NOMBRE()+"','"
                +cliente.getPER_DIRECCION()+"','"
                +cliente.getPER_TELEFONO()+"','"
                +cliente.getPER_CORREO()+"','"
                +cliente.getPER_SEXO()+"','"
                
                +cliente.getPER_FECHA_REGISTRO()+"','"                
                +cliente.getPER_OBSERVACION()+"',"
                +cliente.isPER_ESTADO()+",'MODIFICAR')";
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
                System.out.println("Error: Clase ClienteDaoImple, método registrar");
                e.printStackTrace();
        }
        return registrar;
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ArrayList<Object> buscar(String texto) 
    {
        Connection con =null;
        Statement stm= null;
        ResultSet rs=null;        
        
//        CALL TIPO_USUARIO_CRUDBD (1,'A%',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,TRUE,'LEER_BY_DESCRIPCION');        

        String sql="CALL buscaCliente('%"+texto+"%');";
        
        arrayClases= new ArrayList<Object>();

        try 
        {			
            con= Conexion.conectar();
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) 
            {
                Persona c=new Persona();
                c.setPER_ID(rs.getInt(1));
                c.setPER_CEDULA(rs.getString(2));
                c.setPER_NOMBRE(rs.getString(3));
                c.setPER_DIRECCION(rs.getString(4));
                c.setPER_TELEFONO(rs.getString(5));
                c.setPER_CORREO(rs.getString(6));
                c.setPER_SEXO(rs.getString(7));
                c.setPER_ESTADO(rs.getBoolean(8));   
                arrayClases.add(c);
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
        return arrayClases;
    }

    @Override
    public Object buscarById(String texto) 
    {
        Connection con =null;
        Statement stm= null;
        ResultSet rs=null;        
        String sql="CALL buscaClienteById('"+texto+"%');";
        Persona c=null;
        try 
        {	
            
            con= Conexion.conectar();
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) 
            {
                c=new Persona();
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
            System.out.println("Error: Clase ClienteDaoImple, método obtener");
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

   
}
