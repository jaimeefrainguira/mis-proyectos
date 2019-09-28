/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Conexion.Conexion;
import clases.Producto;
import interfaz.interfazProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jaimeguiracocha
 */
public class modeloProducto implements interfazProducto
{

    private ArrayList<Producto> listaClase;
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    private PreparedStatement ps;
    @Override
    public boolean registrar(Producto producto) {
        boolean registrar = false;
        String sql="CALL CreaModificaProducto (?,?,?,?,?,?,?,?,?,?);";
        try 
        {			
                con=Conexion.conectar();
                
                ps = con.prepareStatement(sql);
                ps.setInt(1, getId());
                ps.setString(2, producto.getPRO_NOMBRE());
                ps.setString(3, producto.getPRO_DESCRIPCION());
                ps.setDouble(4, producto.getPRO_PRECIO_COSTO());
                ps.setDouble(5, producto.getPRO_PRECIO_VENTA());
                ps.setInt(6, producto.getPRO_STOCK());
                ps.setInt(7, producto.getPRO_STOCK_MINIMO());
                ps.setBoolean(8, producto.isPRO_ESTADO());
                ps.setInt(9, producto.getCAT_ID());
                ps.setString(10, "CREAR");
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
        return registrar;
    }

    @Override
    public int getId() {
        int id=0;

        String sql="CALL getUltimoIdProductos();";

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
    public ArrayList<Producto> buscar(String texto) {
        
        

        String sql="CALL buscaProducto('%"+texto+"%');";
        
        listaClase= new ArrayList<>();
        
        

        try 
        {			
            con= Conexion.conectar();
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) 
            {
                Producto c=new Producto();
                c.setPRO_ID(rs.getInt(1));
                c.setPRO_NOMBRE(rs.getString(2));
                c.setPRO_DESCRIPCION(rs.getString(3));
                c.setPRO_PRECIO_COSTO(rs.getDouble(4));
                c.setPRO_PRECIO_VENTA(rs.getDouble(5));
                c.setPRO_STOCK(rs.getInt(6));
                c.setPRO_STOCK_MINIMO(rs.getInt(7));
                c.setPRO_ESTADO(rs.getBoolean(8));                
                c.setCAT_ID(rs.getInt(9));
                listaClase.add(c);
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
        return listaClase;
    }

    @Override
    public boolean modificar(Producto producto, boolean mod) {
        boolean estado = false;
        String sql="CALL CreaModificaProducto (?,?,?,?,?,?,?,?,?,?);";
        try 
        {     
            String modifica="MODIFICAR_PRODUCTO";
            if(mod)
            {
                modifica="MODIFICAR_TODO";
            }
            
                con=Conexion.conectar();
                ps = con.prepareStatement(sql);
                
                ps.setInt(1, producto.getPRO_ID());
                ps.setString(2, producto.getPRO_NOMBRE());
                ps.setString(3, producto.getPRO_DESCRIPCION());
                ps.setDouble(4, producto.getPRO_PRECIO_COSTO());
                ps.setDouble(5, producto.getPRO_PRECIO_VENTA());
                ps.setInt(6, producto.getPRO_STOCK());
                ps.setInt(7, producto.getPRO_STOCK_MINIMO());
                ps.setBoolean(8, producto.isPRO_ESTADO());
                ps.setInt(9, producto.getCAT_ID());
                ps.setString(10, modifica);
                ps.executeUpdate();
                ps.close();
                estado=true;
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
        return estado;
    }
    
    @Override
    public Producto buscarById(String texto)
    {
        con =null;
        stm= null;
        rs=null;        
        String sql="CALL buscaProductoById('"+texto+"%');";
        Producto c=null;
        try 
        {	
            
            con= Conexion.conectar();
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) 
            { 
                c=new Producto();
                c.setPRO_ID(rs.getInt(1));
                c.setPRO_NOMBRE(rs.getString(2));
                c.setPRO_DESCRIPCION(rs.getString(3));
                c.setPRO_PRECIO_COSTO(rs.getDouble(4));
                c.setPRO_PRECIO_VENTA(rs.getDouble(5));
                c.setPRO_STOCK(rs.getInt(6));
                c.setPRO_STOCK_MINIMO(rs.getInt(7));
                c.setPRO_ESTADO(rs.getBoolean(8));
                c.setCAT_ID(rs.getInt(9));
                
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
    
}
