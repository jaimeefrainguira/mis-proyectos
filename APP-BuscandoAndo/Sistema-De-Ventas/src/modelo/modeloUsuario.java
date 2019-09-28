package modelo;

import Conexion.Conexion;
import EncriptarDesencriptar.Utilidades;
import clases.TipoUsuario;
import clases.Usuario;
import interfaz.interfazPersona;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import interfaz.interfazDAO;

public class modeloUsuario implements interfazDAO
{
    private final modeloPersona dao= new  modeloPersona();
    private ArrayList<Object> arrayUsuario;
    
    Connection con;
        Statement stm;
        ResultSet rs;        
        String sql;
    @Override
    public boolean registrar(Object clase) throws Exception {
        
        boolean registrar = false;
		
        stm= null;
        con=null;
        Usuario usuario=(Usuario) clase;
        usuario.setPER_ID(getId());
        String sql1="call CrearModificaUsuario("
                +usuario.getPER_ID()+",'"
                +usuario.getPER_CEDULA()+"','"
                +usuario.getPER_NOMBRE()+"','"
                +usuario.getPER_DIRECCION()+"','"
                +usuario.getPER_TELEFONO()+"','"
                +usuario.getPER_CORREO()+"','"
                +usuario.getPER_SEXO()+"','"
                +usuario.getPER_FECHA_REGISTRO()+"',"
                +usuario.isPER_ESTADO()+",'"                    
                
                +usuario.getUSU_NOMBRE_USUARIO()+"','"
                +usuario.getUSU_FECHA_NACIMIENTO()+"','"
                +Utilidades.Encriptar(usuario.getUSU_CLAVE())+"',"                
                +usuario.getUSU_SUELDO()+","
                +usuario.getTIP_USU_ID()+",'CREAR')";        
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
        }
        return registrar;
    }
    
    @Override
    public boolean actualizar(Object clase)
    {
        Usuario usuario=(Usuario) clase;        
        boolean registrar = false;
        stm= null;
        con=null;
        
        String sql1="call CrearModificaUsuario("
                +usuario.getPER_ID()+",'"
                +usuario.getPER_CEDULA()+"','"
                +usuario.getPER_NOMBRE()+"','"
                +usuario.getPER_DIRECCION()+"','"
                +usuario.getPER_TELEFONO()+"','"
                +usuario.getPER_CORREO()+"','"
                +usuario.getPER_SEXO()+"','"
                +usuario.getPER_FECHA_REGISTRO()+"',"
                +usuario.isPER_ESTADO()+",'"                    
                
                +usuario.getUSU_NOMBRE_USUARIO()+"','"
                +usuario.getUSU_FECHA_NACIMIENTO()+"','"
                +Utilidades.Encriptar(usuario.getUSU_CLAVE())+"',"                
                +usuario.getUSU_SUELDO()+","
                +usuario.getTIP_USU_ID()+",'MODIFICAR')";
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
        con =null;
        stm= null;
        rs=null;
        
        
//        CALL TIPO_USUARIO_CRUDBD (1,'A%',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,TRUE,'LEER_BY_DESCRIPCION');
        

        String sql="CALL buscaUsuario('%"+texto+"%');";
        
        arrayUsuario= new ArrayList<Object>();

        try 
        {			
            con= Conexion.conectar();
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) 
            {
                Usuario c=new Usuario();
                c.setPER_ID(rs.getInt(1));
                c.setPER_CEDULA(rs.getString(2));
                c.setPER_NOMBRE(rs.getString(3));
                c.setPER_DIRECCION(rs.getString(4));
                c.setPER_TELEFONO(rs.getString(5));
                c.setPER_CORREO(rs.getString(6));
                c.setPER_SEXO(rs.getString(7));
                c.setPER_ESTADO(rs.getBoolean(8));   
                arrayUsuario.add(c);
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
        return arrayUsuario;
    }
    
    @Override
    public Object buscarById(String texto)
    {
        con =null;
        stm= null;
        rs=null;        
        sql="CALL buscaUsuarioById('"+texto+"%');";
        Usuario c=null;
        try 
        {	
            con= Conexion.conectar();
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            
            while (rs.next()) 
            {
                c=new Usuario();
                c.setPER_ID(rs.getInt(1));
                c.setPER_CEDULA(rs.getString(2));
                c.setPER_NOMBRE(rs.getString(3));
                c.setPER_DIRECCION(rs.getString(4));
                c.setPER_TELEFONO(rs.getString(5));
                c.setPER_CORREO(rs.getString(6));
                c.setPER_SEXO(rs.getString(7));
                c.setPER_ESTADO(rs.getBoolean(8));
                    
                c.setUSU_NOMBRE_USUARIO(rs.getString(9));
                c.setUSU_FECHA_NACIMIENTO(rs.getString(10));
                c.setUSU_CLAVE(Utilidades.Desencriptar(rs.getString(11)));
                c.setUSU_SUELDO(rs.getDouble(12));
                c.setTIP_USU_ID(rs.getInt(13));
                
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
    
   
    public Object iniciarSesion(String usuario,String clave)
    {
       
        
        con =null;
        stm= null;
        rs=null;        
        sql="call iniciarSesion('"+usuario+"','"+Utilidades.Encriptar(clave)+"')";
        Usuario c=null;
        try 
        {	
            
            con= Conexion.conectar();
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) 
            {
                c=new Usuario();
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
                
                c.setUSU_NOMBRE_USUARIO(rs.getString(11));
                c.setUSU_FECHA_NACIMIENTO(rs.getString(12));
                c.setUSU_CLAVE(Utilidades.Desencriptar(rs.getString(13)));
                c.setUSU_SUELDO(rs.getDouble(14));
                c.setTIP_USU_ID(rs.getInt(15));
                
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
    
    
    /**
     *
     * @return
     */
    @Override
    public int getId()
    {
        return dao.getId();
    }

    public int buscarIdUsuarioByNombre(String nombre)
    {
        int id = 0;
        con =null;
        stm= null;
        rs=null;        
        sql="call getIDPersonabyNombre('"+nombre+"')";        
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
        } catch (Exception ex) {
            Logger.getLogger(modeloUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
}
