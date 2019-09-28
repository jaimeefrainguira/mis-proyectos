package clases;

public class Proveedor extends Persona
{
    private String PROV_FECHA_REGISTRO;
    private String PROV_OBSERVACION;
    private boolean PROV_ESTADO;
    
    public Proveedor()
    {
    }
    public Proveedor(int PER_ID,String  PER_CEDULA, String PER_NOMBRE,
            String PER_DIRECCION, String PER_TELEFONO ,
            String PER_CORREO, String PER_SEXO,
            String PROV_FECHA_REGISTRO,String PROV_OBSERVACION,boolean PROV_ESTADO)
    {
//        super(PER_ID, PER_CEDULA, PER_NOMBRE,
//            PER_DIRECCION, PER_TELEFONO ,
//            PER_CORREO, PER_SEXO);
//        this.PROV_FECHA_REGISTRO=PROV_FECHA_REGISTRO;
//        this.PROV_OBSERVACION=PROV_OBSERVACION;
//        this.PROV_ESTADO=PROV_ESTADO;
    }

    /**
     * @return the PROV_FECHA_REGISTRO
     */
    public String getPROV_FECHA_REGISTRO() {
        return PROV_FECHA_REGISTRO;
    }

    /**
     * @param PROV_FECHA_REGISTRO the PROV_FECHA_REGISTRO to set
     */
    public void setPROV_FECHA_REGISTRO(String PROV_FECHA_REGISTRO) {
        this.PROV_FECHA_REGISTRO = PROV_FECHA_REGISTRO;
    }

    /**
     * @return the PROV_OBSERVACION
     */
    public String getPROV_OBSERVACION() {
        return PROV_OBSERVACION;
    }

    /**
     * @param PROV_OBSERVACION the PROV_OBSERVACION to set
     */
    public void setPROV_OBSERVACION(String PROV_OBSERVACION) {
        this.PROV_OBSERVACION = PROV_OBSERVACION;
    }

    /**
     * @return the PROV_ESTADO
     */
    public boolean isPROV_ESTADO() {
        return PROV_ESTADO;
    }

    /**
     * @param PROV_ESTADO the PROV_ESTADO to set
     */
    public void setPROV_ESTADO(boolean PROV_ESTADO) {
        this.PROV_ESTADO = PROV_ESTADO;
    }
    
}
