package clases;

public class ComprasDetalle 
{
    private int COM_CAB_ID;
    private int PRO_ID;
    private int COM_DET_CATIDAD;
    private double COM_DET_VALOR;
    private double COM_DET_TOTAL;
    
    public ComprasDetalle()
    {
    }
    
    public ComprasDetalle(int COM_CAB_ID,int PRO_ID,int COM_DET_CATIDAD,double COM_DET_VALOR,double COM_DET_TOTAL)
    {
        this.COM_CAB_ID=COM_CAB_ID;
        this.PRO_ID=PRO_ID;
        this.COM_DET_CATIDAD=COM_DET_CATIDAD;
        this.COM_DET_VALOR=COM_DET_VALOR;
        this.COM_DET_TOTAL=COM_DET_TOTAL;
    }

    /**
     * @return the COM_CAB_ID
     */
    public int getCOM_CAB_ID() {
        return COM_CAB_ID;
    }

    /**
     * @param COM_CAB_ID the COM_CAB_ID to set
     */
    public void setCOM_CAB_ID(int COM_CAB_ID) {
        this.COM_CAB_ID = COM_CAB_ID;
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
