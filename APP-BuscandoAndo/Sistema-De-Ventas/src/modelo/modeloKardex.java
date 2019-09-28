package modelo;

import Conexion.Conexion;
import clases.Kardex;
import interfaz.interfazKardex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class modeloKardex implements interfazKardex
{
    private ArrayList<Kardex> listaClase;
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    private PreparedStatement ps;
    
    @Override
    public ArrayList<Kardex> buscar(int texto) {
        
        

        String sql="CALL kardex("+texto+");";
        
        listaClase= new ArrayList<>();
        
        

        try 
        {			
            con= Conexion.conectar();
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) 
            {
                Kardex c=new Kardex();
                c.setKAR_ID(rs.getInt(1));
                c.setPRO_ID(rs.getInt(2));
                c.setKAR_FECHA(rs.getString(3));
                c.setKAR_DETALLE(rs.getString(4));
                c.setKAR_ECANT(rs.getInt(5));
                c.setKAR_EVU(rs.getDouble(6));
                c.setKAR_EVT(rs.getDouble(7));
                c.setKAR_SCANT(rs.getInt(8));     
                c.setKAR_SVU(rs.getDouble(9));     
                c.setKAR_SVT(rs.getDouble(10));     
                c.setKAR_XCANT(rs.getInt(11));     
                c.setKAR_XVU(rs.getDouble(12));     
                c.setKAR_XVT(rs.getDouble(13));       
                
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
}
