package clases;

public class FacturaCabesera 
{
    private int FAC_CAB_ID;
    private String FAC_CAB_FECHA;
    private double FAC_CAB_SUBTOTAL;
    private double FAC_DET_DESCUENTO;
    private double FAC_CAB_IVA;
    private double FAC_CAB_TOTAL;
    private int FAC_CAB_FORMA_P;
    private int PER_ID;
    private int USUARIO_ID;
    private boolean FAC_CAB_ESTADO;
    
    public FacturaCabesera()
    {
    }
    
    public FacturaCabesera(
            int FAC_CAB_ID,
            String FAC_CAB_FECHA,
            double FAC_CAB_SUBTOTAL,
            double FAC_DET_DESCUENTO,
            double FAC_CAB_IVA,
            double FAC_CAB_TOTAL,
            int FAC_CAB_FORMA_P,
            int PER_ID,
            int USUARIO_ID,
            boolean FAC_CAB_ESTADO)
    {
        this.FAC_CAB_ID=FAC_CAB_ID;
        this.FAC_CAB_FECHA=FAC_CAB_FECHA;
        this.FAC_CAB_SUBTOTAL=FAC_CAB_SUBTOTAL;
        this.FAC_DET_DESCUENTO=FAC_DET_DESCUENTO;
        this.FAC_CAB_IVA=FAC_CAB_IVA;
        this.FAC_CAB_TOTAL=FAC_CAB_TOTAL;
        this.FAC_CAB_FORMA_P=FAC_CAB_FORMA_P;
        this.PER_ID=PER_ID;
        this.USUARIO_ID=USUARIO_ID;
        this.FAC_CAB_ESTADO=FAC_CAB_ESTADO;
    }

    /**
     * @return the FAC_CAB_ID
     */
    public int getFAC_CAB_ID() {
        return FAC_CAB_ID;
    }

    /**
     * @param FAC_CAB_ID the FAC_CAB_ID to set
     */
    public void setFAC_CAB_ID(int FAC_CAB_ID) {
        this.FAC_CAB_ID = FAC_CAB_ID;
    }

    /**
     * @return the FAC_CAB_FECHA
     */
    public String getFAC_CAB_FECHA() {
        return FAC_CAB_FECHA;
    }

    /**
     * @param FAC_CAB_FECHA the FAC_CAB_FECHA to set
     */
    public void setFAC_CAB_FECHA(String FAC_CAB_FECHA) {
        this.FAC_CAB_FECHA = FAC_CAB_FECHA;
    }

    /**
     * @return the FAC_CAB_SUBTOTAL
     */
    public double getFAC_CAB_SUBTOTAL() {
        return FAC_CAB_SUBTOTAL;
    }

    /**
     * @param FAC_CAB_SUBTOTAL the FAC_CAB_SUBTOTAL to set
     */
    public void setFAC_CAB_SUBTOTAL(double FAC_CAB_SUBTOTAL) {
        this.FAC_CAB_SUBTOTAL = FAC_CAB_SUBTOTAL;
    }

    /**
     * @return the FAC_CAB_IVA
     */
    public double getFAC_CAB_IVA() {
        return FAC_CAB_IVA;
    }

    /**
     * @param FAC_CAB_IVA the FAC_CAB_IVA to set
     */
    public void setFAC_CAB_IVA(double FAC_CAB_IVA) {
        this.FAC_CAB_IVA = FAC_CAB_IVA;
    }

    /**
     * @return the FAC_CAB_TOTAL
     */
    public double getFAC_CAB_TOTAL() {
        return FAC_CAB_TOTAL;
    }

    /**
     * @param FAC_CAB_TOTAL the FAC_CAB_TOTAL to set
     */
    public void setFAC_CAB_TOTAL(double FAC_CAB_TOTAL) {
        this.FAC_CAB_TOTAL = FAC_CAB_TOTAL;
    }

    /**
     * @return the FAC_CAB_FORMA_P
     */
    public int getFAC_CAB_FORMA_P() {
        return FAC_CAB_FORMA_P;
    }

    /**
     * @param FAC_CAB_FORMA_P the FAC_CAB_FORMA_P to set
     */
    public void setFAC_CAB_FORMA_P(int FAC_CAB_FORMA_P) {
        this.FAC_CAB_FORMA_P = FAC_CAB_FORMA_P;
    }

    /**
     * @return the PER_ID
     */
    public int getPER_ID() {
        return PER_ID;
    }

    /**
     * @param PER_ID the PER_ID to set
     */
    public void setPER_ID(int PER_ID) {
        this.PER_ID = PER_ID;
    }

    /**
     * @return the FAC_CAB_ESTADO
     */
    public boolean isFAC_CAB_ESTADO() {
        return FAC_CAB_ESTADO;
    }

    /**
     * @param FAC_CAB_ESTADO the FAC_CAB_ESTADO to set
     */
    public void setFAC_CAB_ESTADO(boolean FAC_CAB_ESTADO) {
        this.FAC_CAB_ESTADO = FAC_CAB_ESTADO;
    }

    /**
     * @return the USUARIO_ID
     */
    public int getUSUARIO_ID() {
        return USUARIO_ID;
    }

    /**
     * @param USUARIO_ID the USUARIO_ID to set
     */
    public void setUSUARIO_ID(int USUARIO_ID) {
        this.USUARIO_ID = USUARIO_ID;
    }

    /**
     * @return the FAC_DET_DESCUENTO
     */
    public double getFAC_DET_DESCUENTO() {
        return FAC_DET_DESCUENTO;
    }

    /**
     * @param FAC_DET_DESCUENTO the FAC_DET_DESCUENTO to set
     */
    public void setFAC_DET_DESCUENTO(double FAC_DET_DESCUENTO) {
        this.FAC_DET_DESCUENTO = FAC_DET_DESCUENTO;
    }

    
}
