package modelo;

import Conexion.Conexion;
import clases.OrdenReparacion;
import interfaz.interfazOrdenReparacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class modeloOrdenReparacion implements interfazOrdenReparacion
{
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    
    private ArrayList<OrdenReparacion> listaClase;
    
    @Override
    public boolean registrar(OrdenReparacion reparacion) 
    {
        return registra_actualiza("REGISTRA", reparacion);
    }

    @Override
    public int getId() 
    {
        int id=0;
        sql="call getUltimoIdReparacion();";

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
            if (con.isClosed()) 
            {
                System.out.println("Desconectado");
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("Codigo de error: "+e.getErrorCode()+" "+e);
        }
        return id+1;
    }

    @Override
    public ArrayList<OrdenReparacion> buscar(String texto) 
    {
        sql="CALL buscaOrdenReparacion('%"+texto+"%');";        
        listaClase= new ArrayList<>();
        try 
        {			
            con= Conexion.conectar();
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) 
            {                    
                OrdenReparacion c=new OrdenReparacion();
                c.setREP_ID(rs.getInt(1));
                c.setPER_ID(rs.getInt(2));
                c.setFECHA(rs.getString(3));
                c.setIMEI(rs.getString(4));
                c.setMARCA(rs.getString(5));
                c.setFECHA_DE_ENTREGA(rs.getString(6));
                c.setBATERIA(rs.getBoolean(7));
                c.setCHIP(rs.getBoolean(8));                
                c.setMEMORIA(rs.getBoolean(9));
                c.setTAPA(rs.getBoolean(10));
                c.setCARGADOR(rs.getBoolean(11));
                c.setOTROS(rs.getString(12));
                c.setDIAGNOSTICO(rs.getString(13));
                c.setTOTAL(rs.getDouble(14));
                c.setABONO(rs.getDouble(15));
                c.setSALDO(rs.getDouble(16));
                c.setESTADO(rs.getBoolean(17));
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
    public boolean actualiza(OrdenReparacion reparacion) 
    {
        return registra_actualiza("ACTUALIZA", reparacion);
    }
    public boolean registra_actualiza(String tipo,OrdenReparacion reparacion)
    {
        boolean retorna=false;
        try 
        {
            if(reparacion.getREP_ID()==0)
            {
                reparacion.setREP_ID(getId());
            }
            con=Conexion.conectar();
            sql="CALL CreaModificaOrdenReparacion (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            ps = con.prepareStatement(sql);
            ps.setInt(1, reparacion.getREP_ID());
            ps.setInt(2, reparacion.getPER_ID());
            ps.setString(3, reparacion.getFECHA());
            ps.setString(4, reparacion.getIMEI());
            ps.setString(5, reparacion.getMARCA());
            ps.setString(6, reparacion.getFECHA_DE_ENTREGA());
            ps.setBoolean(7, reparacion.isBATERIA());
            ps.setBoolean(8, reparacion.isCHIP());
            ps.setBoolean(9, reparacion.isMEMORIA());
            ps.setBoolean(10, reparacion.isTAPA());
            ps.setBoolean(11, reparacion.isCARGADOR());
            ps.setString(12, reparacion.getOTROS());            
            ps.setString(13, reparacion.getDIAGNOSTICO());
            ps.setDouble(14, reparacion.getTOTAL());
            ps.setDouble(15, reparacion.getABONO());
            ps.setDouble(16, reparacion.getSALDO());
            ps.setBoolean(17, true);
            System.out.println(sql);
            ps.setString(18, tipo);
            ps.executeUpdate();
            ps.close();            
            con.close();
            
            if (con.isClosed()) 
            {
                System.out.println("Desconectado");
            }
            retorna=true;
        } 
        catch (SQLException e) 
        {
            System.out.println("Codigo de error: "+e.getErrorCode()+" "+e);
            if(e.getErrorCode()==1062)
            {
//                JOptionPane.showMessageDialog(null, "Ya existe este tipo de Usuario: "+'"'+categoria.getTIP_USU_DESCRIPCION()+'"');
            }                
        } 
        return retorna;
    }
    
}
