package modelo;

import Conexion.Conexion;
import clases.TipoUsuario;
import interfaz.interfazTipoUsuario;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import interfaz.interfazDAO;

public class modeloTipoUsuario implements interfazTipoUsuario
{
    ArrayList<TipoUsuario> arrayTipoUsuario;
    
//    CALL TIPO_USUARIO_CRUDBD (1,'AS',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,TRUE,'CREAR');
//    CALL TIPO_USUARIO_CRUDBD (1,'AS',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,TRUE,'LEER_TODO');
//    CALL TIPO_USUARIO_CRUDBD (1,'AS',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,TRUE,'LEER_BY_ID');
//    CALL TIPO_USUARIO_CRUDBD (1,'A%',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,TRUE,'LEER_BY_DESCRIPCION');
//    CALL TIPO_USUARIO_CRUDBD (1,'A%',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,TRUE,'MODIFICAR');
//    CALL TIPO_USUARIO_CRUDBD (1,'A%',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,TRUE,'BORRAR');

    @Override
    public boolean registrar(TipoUsuario tipoUsuario) {
        
        boolean registrar = false;
		
        Statement stm= null;
        Connection con=null;
        

//        INSERT INTO TIPO_USUARIO VALUES ('1', 'asdf', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0');
//        String sql="CALL TIPO_USUARIO_CRUDBD (2,'ASDF',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,TRUE,'CREAR');";
        String sql="CALL TIPO_USUARIO_CRUDBD ("
                +getId()+",'"
                +tipoUsuario.getTIP_USU_DESCRIPCION()+"',"
                +tipoUsuario.isTIP_USU_PRODUCTO()+","
                +tipoUsuario.isTIP_USU_MERCADERIA()+","
                +tipoUsuario.isTIP_USU_COMPRAS()+","
                +tipoUsuario.isTIP_USU_PROVEEDORES()+","
                +tipoUsuario.isTIP_USU_VENTA()+","
                +tipoUsuario.isTIP_USU_CLIENTES()+","
                +tipoUsuario.isTIP_USU_VERIFICAR_PRODUCTO()+","
                +tipoUsuario.isTIP_USU_VENTAS_REALIZADAS()+","
                +tipoUsuario.isTIP_USU_VENTAS_DETALLADAS()+","
                +tipoUsuario.isTIP_USU_ESTADISTICA_MENSUAL()+","
                +tipoUsuario.isTIP_USU_COMPRAS_REALIZADAS()+","
                +tipoUsuario.isTIP_USU_COMPRAS_DETALLADAS()+","
                +tipoUsuario.isTIP_USU_EMPLEADOS()+","
                +tipoUsuario.isTIP_USU_TIPO_DE_USUARIO()+","
                +tipoUsuario.isTIP_USU_SERVICIO_TECNICO()+","
                +tipoUsuario.isTIP_USU_ANULAR_VENTA()+","
                +tipoUsuario.isTIP_USU_ANULAR_COMPRA()+","
                +tipoUsuario.isTIP_USU_CAMBIAR_CONTRASEÑA()+","
                +tipoUsuario.isTIP_USU_USUARIOS()+","
                +tipoUsuario.isTIP_USU_RESPALDAR_BD()+","
                +tipoUsuario.isTIP_USU_RESTAURAR_BD()+",TRUE,'CREAR');";
               

        try 
        {			
                con=Conexion.conectar();
                stm= con.createStatement();
                stm.execute(sql);
                registrar=true;
                stm.close();
                con.close();
                if (con.isClosed()) {System.out.println("Desconectado");}
        } 
        catch (SQLException e) 
        {
            if(e.getErrorCode()==1062)
            {
                JOptionPane.showMessageDialog(null, "Ya existe este tipo de Usuario: "+'"'+tipoUsuario.getTIP_USU_DESCRIPCION()+'"');
            }
            
//                System.out.println("Error: Clase ClienteDaoImple, método registrar");
//                e.printStackTrace();
                //extrae el codigo de error
                System.out.println("Codigo de error: "+e.getErrorCode());
        }
        return registrar;
    }

    /**
     *
     * @return
     */
    @Override
    public int getId()
    {
//        SELECT `TIP_USU_ID` FROM TIPO_USUARIO ORDER by `TIP_USU_ID` DESC LIMIT 1
        int id=0;
        Connection con =null;
        Statement stm= null;
        ResultSet rs=null;

        String sql="CALL `getUtlimoIdTipoUsuario`();";

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

    //Busca registro por id o descripcion
    @Override
    public ArrayList<TipoUsuario> buscarTipoUsuario(String texto)
    {
        Connection con =null;
        Statement stm= null;
        ResultSet rs=null;
        String sql="CALL buscaTipoUsuario('"+texto+"%');";
        arrayTipoUsuario= new ArrayList<TipoUsuario>();

        try 
        {			
            con= Conexion.conectar();
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) 
            {
                TipoUsuario c=new TipoUsuario();
                c.setTIP_USU_ID(rs.getInt(1));
                c.setTIP_USU_DESCRIPCION(rs.getString(2));
                c.setTIP_USU_PRODUCTO(rs.getBoolean(3));
                c.setTIP_USU_MERCADERIA(rs.getBoolean(4));
                c.setTIP_USU_COMPRAS(rs.getBoolean(5));
                c.setTIP_USU_PROVEEDORES(rs.getBoolean(6));
                c.setTIP_USU_VENTA(rs.getBoolean(7));
                c.setTIP_USU_CLIENTES(rs.getBoolean(8));
                c.setTIP_USU_VERIFICAR_PRODUCTO(rs.getBoolean(9));
                c.setTIP_USU_VENTAS_REALIZADAS(rs.getBoolean(10));
                c.setTIP_USU_VENTAS_DETALLADAS(rs.getBoolean(11));
                c.setTIP_USU_ESTADISTICA_MENSUAL(rs.getBoolean(12));
                c.setTIP_USU_COMPRAS_REALIZADAS(rs.getBoolean(13));
                c.setTIP_USU_COMPRAS_DETALLADAS(rs.getBoolean(14));
                c.setTIP_USU_EMPLEADOS(rs.getBoolean(15));
                c.setTIP_USU_TIPO_DE_USUARIO(rs.getBoolean(16));
                c.setTIP_USU_SERVICIO_TECNICO(rs.getBoolean(17));
                c.setTIP_USU_ANULAR_VENTA(rs.getBoolean(18));
                c.setTIP_USU_ANULAR_COMPRA(rs.getBoolean(19));
                c.setTIP_USU_CAMBIAR_CONTRASEÑA(rs.getBoolean(20));
                c.setTIP_USU_USUARIOS(rs.getBoolean(21));
                c.setTIP_USU_RESPALDAR_BD(rs.getBoolean(22));
                c.setTIP_USU_RESTAURAR_BD(rs.getBoolean(23));
                
                arrayTipoUsuario.add(c);
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
        return arrayTipoUsuario;
    }
        
    @Override
    public boolean modificar(TipoUsuario tipoUsuario)
    {
        boolean registrar = false;
		
        Statement stm= null;
        Connection con=null;
        String sql="CALL TIPO_USUARIO_CRUDBD ("
                +tipoUsuario.getTIP_USU_ID()+","+
                "'"+tipoUsuario.getTIP_USU_DESCRIPCION()+"',"
                +tipoUsuario.isTIP_USU_PRODUCTO()+","
                +tipoUsuario.isTIP_USU_MERCADERIA()+","
                +tipoUsuario.isTIP_USU_COMPRAS()+","
                +tipoUsuario.isTIP_USU_PROVEEDORES()+","
                +tipoUsuario.isTIP_USU_VENTA()+","
                +tipoUsuario.isTIP_USU_CLIENTES()+","
                +tipoUsuario.isTIP_USU_VERIFICAR_PRODUCTO()+","
                +tipoUsuario.isTIP_USU_VENTAS_REALIZADAS()+","
                +tipoUsuario.isTIP_USU_VENTAS_DETALLADAS()+","
                +tipoUsuario.isTIP_USU_ESTADISTICA_MENSUAL()+","
                +tipoUsuario.isTIP_USU_COMPRAS_REALIZADAS()+","
                +tipoUsuario.isTIP_USU_COMPRAS_DETALLADAS()+","
                +tipoUsuario.isTIP_USU_EMPLEADOS()+","
                +tipoUsuario.isTIP_USU_TIPO_DE_USUARIO()+","
                +tipoUsuario.isTIP_USU_SERVICIO_TECNICO()+","
                +tipoUsuario.isTIP_USU_ANULAR_VENTA()+","
                +tipoUsuario.isTIP_USU_ANULAR_COMPRA()+","
                +tipoUsuario.isTIP_USU_CAMBIAR_CONTRASEÑA()+","
                +tipoUsuario.isTIP_USU_USUARIOS()+","
                +tipoUsuario.isTIP_USU_RESPALDAR_BD()+","
                +tipoUsuario.isTIP_USU_RESTAURAR_BD()+",TRUE,'MODIFICAR');";
               

        try 
        {			
                con=Conexion.conectar();
                stm= con.createStatement();
                stm.execute(sql);
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
    
    
    
}
