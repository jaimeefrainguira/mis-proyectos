/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Conexion.Conexion;
import clases.Categoria;
import interfaz.interfazCategoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jaimeguiracocha
 */
public class modeloCategoria implements interfazCategoria
{
    private ArrayList<Categoria> listaClase;
    private Connection con;
    private ResultSet rs;
    private PreparedStatement ps;
    private Statement stm;
    @Override
    public boolean registrar(Categoria categoria) 
    {
        boolean registrar = false;
        String sql="CALL CreaModificaCategoria (?,?,?,?);";
        try 
        {			
                con=Conexion.conectar();
                ps = con.prepareStatement(sql);
                ps.setInt(1, 1);
                ps.setString(2, categoria.getCAT_DESCRIPCION());
                ps.setBytes(3,categoria.getCAT_IMAGEN());
                ps.setString(4, "CREAR");
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
    public boolean modificar(Categoria categoria) 
    {
        boolean estado = false;
        String sql="CALL CreaModificaCategoria (?,?,?,?);";
        try 
        {			
                con=Conexion.conectar();
                ps = con.prepareStatement(sql);
                ps.setInt(1, categoria.getCAT_ID());
                ps.setString(2, categoria.getCAT_DESCRIPCION());
                ps.setBytes(3,categoria.getCAT_IMAGEN());
                ps.setString(4, "MODIFICAR");
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
    public int getId() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Categoria> buscar(String texto) 
    {
        String sql="CALL buscaCategoria('%"+texto+"%');";        
        listaClase= new ArrayList<>();
        con=Conexion.conectar();

        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Categoria vo = new Categoria();
                vo.setCAT_ID(rs.getInt(1));
                vo.setCAT_DESCRIPCION(rs.getString(2));
                vo.setCAT_IMAGEN(rs.getBytes(3));
                listaClase.add(vo);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
                con.close();
            }catch(Exception ex){}
        }
        return listaClase;
    }
    
   public ArrayList<Categoria> Listar_Categoria()
   {
        ArrayList<Categoria> list = new ArrayList<Categoria>();
        Connection conec = Conexion.conectar();
        String sql = "SELECT * FROM CATEGORIA;";
        try{
            ps = conec.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Categoria vo = new Categoria();
                vo.setCAT_ID(rs.getInt(1));
                vo.setCAT_DESCRIPCION(rs.getString(2));
                vo.setCAT_IMAGEN(rs.getBytes(3));
                list.add(vo);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
                conec.close();
            }catch(Exception ex){}
        }
        return list;
    }
    
}
