package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Conexion.Conexion;
import java.util.List;
import interfaz.interfazDAO;

public class Usuario extends Persona 
{
    private String USU_NOMBRE_USUARIO;
    private String USU_FECHA_NACIMIENTO;
    private String USU_CLAVE;
    private double USU_SUELDO;   
    private int TIP_USU_ID;

    public Usuario() {
    }

    public Usuario(
            int PER_ID, 
            String PER_CEDULA, 
            String PER_NOMBRE, 
            String PER_DIRECCION, 
            String PER_TELEFONO, 
            String PER_CORREO, 
            String PER_SEXO, 
            String PER_FECHA_REGISTRO, 
            String PER_OBSERVACION, 
            boolean PER_ESTADO,
            
            String USU_NOMBRE_USUARIO, 
            String USU_FECHA_NACIMIENTO, 
            String USU_CLAVE, 
            double USU_SUELDO, 
            int TIP_USU_ID
    ) {
        super(PER_ID, PER_CEDULA, PER_NOMBRE, PER_DIRECCION, PER_TELEFONO, PER_CORREO, PER_SEXO, PER_FECHA_REGISTRO, PER_OBSERVACION, PER_ESTADO);
        this.USU_NOMBRE_USUARIO = USU_NOMBRE_USUARIO;
        this.USU_FECHA_NACIMIENTO = USU_FECHA_NACIMIENTO;
        this.USU_CLAVE = USU_CLAVE;
        this.USU_SUELDO = USU_SUELDO;
        this.TIP_USU_ID = TIP_USU_ID;
    }

    public String getUSU_NOMBRE_USUARIO() {
        return USU_NOMBRE_USUARIO;
    }

    public void setUSU_NOMBRE_USUARIO(String USU_NOMBRE_USUARIO) {
        this.USU_NOMBRE_USUARIO = USU_NOMBRE_USUARIO;
    }

    public String getUSU_FECHA_NACIMIENTO() {
        return USU_FECHA_NACIMIENTO;
    }

    public void setUSU_FECHA_NACIMIENTO(String USU_FECHA_NACIMIENTO) {
        this.USU_FECHA_NACIMIENTO = USU_FECHA_NACIMIENTO;
    }

    public String getUSU_CLAVE() {
        return USU_CLAVE;
    }

    public void setUSU_CLAVE(String USU_CLAVE) {
        this.USU_CLAVE = USU_CLAVE;
    }

    public double getUSU_SUELDO() {
        return USU_SUELDO;
    }

    public void setUSU_SUELDO(double USU_SUELDO) {
        this.USU_SUELDO = USU_SUELDO;
    }

    public int getTIP_USU_ID() {
        return TIP_USU_ID;
    }

    public void setTIP_USU_ID(int TIP_USU_ID) {
        this.TIP_USU_ID = TIP_USU_ID;
    }
        
}