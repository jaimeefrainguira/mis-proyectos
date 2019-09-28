package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion 
{
    
    public static Connection conectar() 
    {                
        Connection con = null;
        
//        String password = "18332021";
//        String usuario = "cliente";
//        String db="bdventas";
//        String url = "jdbc:mysql://192.168.100.2:3306/"+db+"?user=" + usuario + "&password=" + password;

            String password = "";
        String usuario = "root";
        String db="bdventas";
        String url = "jdbc:mysql://localhost:3306/"+db+"?user=" + usuario + "&password=" + password;
        try 
        {
            con = DriverManager.getConnection(url);
            if (con != null) 
            {                
                System.out.println("Conectado");
            }
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
            System.out.println("No se pudo conectar a la base de datos"+db);
            e.printStackTrace();
        }
        return con;
    } 
}
