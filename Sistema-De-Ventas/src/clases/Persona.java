package clases;

public class Persona 
{
    int PER_ID;
    private String PER_CEDULA;
    private String PER_NOMBRE;
    private String PER_DIRECCION;
    private String PER_TELEFONO;
    private String PER_CORREO;
    private String PER_SEXO;
    private String PER_FECHA_REGISTRO;
    private String PER_OBSERVACION;
    private boolean PER_ESTADO;    
    
    public Persona()
    {
    }

    public Persona(int PER_ID, String PER_CEDULA, String PER_NOMBRE, String PER_DIRECCION, String PER_TELEFONO, String PER_CORREO, String PER_SEXO, String PER_FECHA_REGISTRO, String PER_OBSERVACION, boolean PER_ESTADO) {
        this.PER_ID = PER_ID;
        this.PER_CEDULA = PER_CEDULA;
        this.PER_NOMBRE = PER_NOMBRE;
        this.PER_DIRECCION = PER_DIRECCION;
        this.PER_TELEFONO = PER_TELEFONO;
        this.PER_CORREO = PER_CORREO;
        this.PER_SEXO = PER_SEXO;
        this.PER_FECHA_REGISTRO = PER_FECHA_REGISTRO;
        this.PER_OBSERVACION = PER_OBSERVACION;
        this.PER_ESTADO = PER_ESTADO;
    }

    public int getPER_ID() {
        return PER_ID;
    }

    public void setPER_ID(int PER_ID) {
        this.PER_ID = PER_ID;
    }

    public String getPER_CEDULA() {
        return PER_CEDULA;
    }

    public void setPER_CEDULA(String PER_CEDULA) {
        this.PER_CEDULA = PER_CEDULA;
    }

    public String getPER_NOMBRE() {
        return PER_NOMBRE;
    }

    public void setPER_NOMBRE(String PER_NOMBRE) {
        this.PER_NOMBRE = PER_NOMBRE;
    }

    public String getPER_DIRECCION() {
        return PER_DIRECCION;
    }

    public void setPER_DIRECCION(String PER_DIRECCION) {
        this.PER_DIRECCION = PER_DIRECCION;
    }

    public String getPER_TELEFONO() {
        return PER_TELEFONO;
    }

    public void setPER_TELEFONO(String PER_TELEFONO) {
        this.PER_TELEFONO = PER_TELEFONO;
    }

    public String getPER_CORREO() {
        return PER_CORREO;
    }

    public void setPER_CORREO(String PER_CORREO) {
        this.PER_CORREO = PER_CORREO;
    }

    public String getPER_SEXO() {
        return PER_SEXO;
    }

    public void setPER_SEXO(String PER_SEXO) {
        this.PER_SEXO = PER_SEXO;
    }

    public String getPER_FECHA_REGISTRO() {
        return PER_FECHA_REGISTRO;
    }

    public void setPER_FECHA_REGISTRO(String PER_FECHA_REGISTRO) {
        this.PER_FECHA_REGISTRO = PER_FECHA_REGISTRO;
    }

    public String getPER_OBSERVACION() {
        return PER_OBSERVACION;
    }

    public void setPER_OBSERVACION(String PER_OBSERVACION) {
        this.PER_OBSERVACION = PER_OBSERVACION;
    }

    public boolean isPER_ESTADO() {
        return PER_ESTADO;
    }

    public void setPER_ESTADO(boolean PER_ESTADO) {
        this.PER_ESTADO = PER_ESTADO;
    }
    
}
