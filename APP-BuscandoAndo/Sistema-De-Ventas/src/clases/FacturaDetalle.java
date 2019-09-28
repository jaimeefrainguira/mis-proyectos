package clases;

public class FacturaDetalle 
{
    private int FAC_CAB_ID;
    private int PRO_ID;
    private int FAC_DET_CANTIDAD;
    private double FAC_DET_PVP;
    private double FAC_DET_DESCUENTO;
    private double FAC_DET_TOTAL;
    private double FAC_DET_PC;
    
    public FacturaDetalle()
    {
    }
    
    public FacturaDetalle(
            int FAC_CAB_ID,
            int PRO_ID,
            int FAC_DET_CANTIDAD,
            double FAC_DET_PVP,
            double FAC_DET_DESCUENTO,
            double FAC_DET_TOTAL,
            double FAC_DET_PC)
    {
        this.FAC_CAB_ID=FAC_CAB_ID;
        this.PRO_ID=PRO_ID;
        this.FAC_DET_CANTIDAD=FAC_DET_CANTIDAD;
        this.FAC_DET_PVP=FAC_DET_PVP;
        this.FAC_DET_DESCUENTO=FAC_DET_DESCUENTO;
        this.FAC_DET_TOTAL=FAC_DET_TOTAL;
        this.FAC_DET_PC= FAC_DET_PC;
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
     * @return the FAC_DET_CANTIDAD
     */
    public int getFAC_DET_CANTIDAD() {
        return FAC_DET_CANTIDAD;
    }

    /**
     * @param FAC_DET_CANTIDAD the FAC_DET_CANTIDAD to set
     */
    public void setFAC_DET_CANTIDAD(int FAC_DET_CANTIDAD) {
        this.FAC_DET_CANTIDAD = FAC_DET_CANTIDAD;
    }

    /**
     * @return the FAC_DET_PVP
     */
    public double getFAC_DET_PVP() {
        return FAC_DET_PVP;
    }

    /**
     * @param FAC_DET_PVP the FAC_DET_PVP to set
     */
    public void setFAC_DET_PVP(double FAC_DET_PVP) {
        this.FAC_DET_PVP = FAC_DET_PVP;
    }

    /**
     * @return the FAC_DET_TOTAL
     */
    public double getFAC_DET_TOTAL() {
        return FAC_DET_TOTAL;
    }

    /**
     * @param FAC_DET_TOTAL the FAC_DET_TOTAL to set
     */
    public void setFAC_DET_TOTAL(double FAC_DET_TOTAL) {
        this.FAC_DET_TOTAL = FAC_DET_TOTAL;
    }

    /**
     * @return the FAC_DET_PC
     */
    public double getFAC_DET_PC() {
        return FAC_DET_PC;
    }

    /**
     * @param FAC_DET_PC the FAC_DET_PC to set
     */
    public void setFAC_DET_PC(double FAC_DET_PC) {
        this.FAC_DET_PC = FAC_DET_PC;
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
