/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Conexion.Conexion;
import interfaz.interfazPersona;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class modeloPersona implements interfazPersona
{
    @Override
    public int getId()
    {
        int id=0;
        Connection con =null;
        Statement stm= null;
        ResultSet rs=null;

        String sql="call getUltimoIdPersona();";

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
}
