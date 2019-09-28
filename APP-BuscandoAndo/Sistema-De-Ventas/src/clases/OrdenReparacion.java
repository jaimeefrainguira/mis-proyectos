package clases;

public class OrdenReparacion extends Persona
{
    private int REP_ID;
    private String FECHA;
    private String IMEI;
    private String MARCA;
    private String FECHA_DE_ENTREGA;
    private boolean BATERIA;
    private boolean CHIP;
    private boolean MEMORIA;
    private boolean TAPA;
    private boolean CARGADOR;
    private String OTROS;
    private String DIAGNOSTICO;
    private double TOTAL;
    private double ABONO;
    private double SALDO;
    private boolean ESTADO;
        
    
    public OrdenReparacion()
    {
    }
    public OrdenReparacion
        (
            int REP_ID,
            int PER_ID,
            String FECHA,
            String IMEI,
            String MARCA,
            String FECHA_DE_ENTREGA,
            boolean BATERIA,
            boolean CHIP,
            boolean MEMORIA,
            boolean TAPA,
            boolean CARGADOR,
            String OTROS,
            String DIAGNOSTICO,
            double TOTAL,
            double ABONO,
            double SALDO,
            boolean ESTADO
        )
    {
        this.REP_ID=REP_ID;
        super.PER_ID=PER_ID;
        this.FECHA=FECHA;
        this.IMEI=IMEI;
        this.MARCA=MARCA;
        this.FECHA_DE_ENTREGA=FECHA_DE_ENTREGA;
        this.BATERIA=BATERIA;
        this.CHIP=CHIP;
        this.MEMORIA=MEMORIA;
        this.TAPA=TAPA;
        this.CARGADOR=CARGADOR;
        this.OTROS=OTROS;
        this.DIAGNOSTICO=DIAGNOSTICO;
        this.TOTAL=TOTAL;
        this.ABONO=ABONO;
        this.SALDO=SALDO;
        this.ESTADO=ESTADO;
    }

    /**
     * @return the REP_ID
     */
    public int getREP_ID() {
        return REP_ID;
    }

    /**
     * @param REP_ID the REP_ID to set
     */
    public void setREP_ID(int REP_ID) {
        this.REP_ID = REP_ID;
    }

    /**
     * @return the FECHA
     */
    public String getFECHA() {
        return FECHA;
    }

    /**
     * @param FECHA the FECHA to set
     */
    public void setFECHA(String FECHA) {
        this.FECHA = FECHA;
    }

    /**
     * @return the IMEI
     */
    public String getIMEI() {
        return IMEI;
    }

    /**
     * @param IMEI the IMEI to set
     */
    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    /**
     * @return the MARCA
     */
    public String getMARCA() {
        return MARCA;
    }

    /**
     * @param MARCA the MARCA to set
     */
    public void setMARCA(String MARCA) {
        this.MARCA = MARCA;
    }

    /**
     * @return the FECHA_DE_ENTREGA
     */
    public String getFECHA_DE_ENTREGA() {
        return FECHA_DE_ENTREGA;
    }

    /**
     * @param FECHA_DE_ENTREGA the FECHA_DE_ENTREGA to set
     */
    public void setFECHA_DE_ENTREGA(String FECHA_DE_ENTREGA) {
        this.FECHA_DE_ENTREGA = FECHA_DE_ENTREGA;
    }

    /**
     * @return the BATERIA
     */
    public boolean isBATERIA() {
        return BATERIA;
    }

    /**
     * @param BATERIA the BATERIA to set
     */
    public void setBATERIA(boolean BATERIA) {
        this.BATERIA = BATERIA;
    }

    /**
     * @return the CHIP
     */
    public boolean isCHIP() {
        return CHIP;
    }

    /**
     * @param CHIP the CHIP to set
     */
    public void setCHIP(boolean CHIP) {
        this.CHIP = CHIP;
    }

    /**
     * @return the MEMORIA
     */
    public boolean isMEMORIA() {
        return MEMORIA;
    }

    /**
     * @param MEMORIA the MEMORIA to set
     */
    public void setMEMORIA(boolean MEMORIA) {
        this.MEMORIA = MEMORIA;
    }

    /**
     * @return the TAPA
     */
    public boolean isTAPA() {
        return TAPA;
    }

    /**
     * @param TAPA the TAPA to set
     */
    public void setTAPA(boolean TAPA) {
        this.TAPA = TAPA;
    }

    /**
     * @return the CARGADOR
     */
    public boolean isCARGADOR() {
        return CARGADOR;
    }

    /**
     * @param CARGADOR the CARGADOR to set
     */
    public void setCARGADOR(boolean CARGADOR) {
        this.CARGADOR = CARGADOR;
    }

    /**
     * @return the OTROS
     */
    public String getOTROS() {
        return OTROS;
    }

    /**
     * @param OTROS the OTROS to set
     */
    public void setOTROS(String OTROS) {
        this.OTROS = OTROS;
    }

    /**
     * @return the DIAGNOSTICO
     */
    public String getDIAGNOSTICO() {
        return DIAGNOSTICO;
    }

    /**
     * @param DIAGNOSTICO the DIAGNOSTICO to set
     */
    public void setDIAGNOSTICO(String DIAGNOSTICO) {
        this.DIAGNOSTICO = DIAGNOSTICO;
    }

    /**
     * @return the TOTAL
     */
    public double getTOTAL() {
        return TOTAL;
    }

    /**
     * @param TOTAL the TOTAL to set
     */
    public void setTOTAL(double TOTAL) {
        this.TOTAL = TOTAL;
    }

    /**
     * @return the ABONO
     */
    public double getABONO() {
        return ABONO;
    }

    /**
     * @param ABONO the ABONO to set
     */
    public void setABONO(double ABONO) {
        this.ABONO = ABONO;
    }

    /**
     * @return the SALDO
     */
    public double getSALDO() {
        return SALDO;
    }

    /**
     * @param SALDO the SALDO to set
     */
    public void setSALDO(double SALDO) {
        this.SALDO = SALDO;
    }

    /**
     * @return the ESTADO
     */
    public boolean isESTADO() {
        return ESTADO;
    }

    /**
     * @param ESTADO the ESTADO to set
     */
    public void setESTADO(boolean ESTADO) {
        this.ESTADO = ESTADO;
    }

}