package clases;

/**
 *
 * @author jaimeguiracocha
 */
public class ComprasDetalladas {
    
private int PRO_ID;
private String PRO_NOMBRE;
private String CAT_DESCRIPCION;
private int COM_DET_CATIDAD;
private double COM_DET_VALOR;
private double COM_DET_TOTAL;
    public ComprasDetalladas()
    {
    }
    public ComprasDetalladas(
        int PRO_ID,
        String PRO_NOMBRE,
        String CAT_DESCRIPCION,
        int COM_DET_CATIDAD,
        double COM_DET_VALOR,
        double COM_DET_TOTAL
    )
    {
        this.PRO_ID=PRO_ID;
        this.PRO_NOMBRE=PRO_NOMBRE;
        this.CAT_DESCRIPCION=CAT_DESCRIPCION;
        this.COM_DET_CATIDAD=COM_DET_CATIDAD;
        this.COM_DET_VALOR=COM_DET_VALOR;
        this.COM_DET_TOTAL=COM_DET_TOTAL;
    }    

    /**
     * @return the PRO_ID
     */
    public int getPRO_ID() {
        return PRO_ID;
    }

    /**
     * @param PRO_ID the PRO_ID to set
     */
    public void setPRO_ID(int PRO_ID) {
        this.PRO_ID = PRO_ID;
    }

    /**
     * @return the PRO_NOMBRE
     */
    public String getPRO_NOMBRE() {
        return PRO_NOMBRE;
    }

    /**
     * @param PRO_NOMBRE the PRO_NOMBRE to set
     */
    public void setPRO_NOMBRE(String PRO_NOMBRE) {
        this.PRO_NOMBRE = PRO_NOMBRE;
    }

    /**
     * @return the CAT_DESCRIPCION
     */
    public String getCAT_DESCRIPCION() {
        return CAT_DESCRIPCION;
    }

    /**
     * @param CAT_DESCRIPCION the CAT_DESCRIPCION to set
     */
    public void setCAT_DESCRIPCION(String CAT_DESCRIPCION) {
        this.CAT_DESCRIPCION = CAT_DESCRIPCION;
    }

    /**
     * @return the COM_DET_CATIDAD
     */
    public int getCOM_DET_CATIDAD() {
        return COM_DET_CATIDAD;
    }

    /**
     * @param COM_DET_CATIDAD the COM_DET_CATIDAD to set
     */
    public void setCOM_DET_CATIDAD(int COM_DET_CATIDAD) {
        this.COM_DET_CATIDAD = COM_DET_CATIDAD;
    }

    /**
     * @return the COM_DET_VALOR
     */
    public double getCOM_DET_VALOR() {
        return COM_DET_VALOR;
    }

    /**
     * @param COM_DET_VALOR the COM_DET_VALOR to set
     */
    public void setCOM_DET_VALOR(double COM_DET_VALOR) {
        this.COM_DET_VALOR = COM_DET_VALOR;
    }

    /**
     * @return the COM_DET_TOTAL
     */
    public double getCOM_DET_TOTAL() {
        return COM_DET_TOTAL;
    }

    /**
     * @param COM_DET_TOTAL the COM_DET_TOTAL to set
     */
    public void setCOM_DET_TOTAL(double COM_DET_TOTAL) {
        this.COM_DET_TOTAL = COM_DET_TOTAL;
    }
}
