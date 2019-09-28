package clases;

public class Kardex 
{
    private int KAR_ID;
    private int PRO_ID;
    private String KAR_FECHA;
    private String KAR_DETALLE;
    private int KAR_ECANT;
    private double KAR_EVU;
    private double KAR_EVT;
    private int KAR_SCANT;
    private double KAR_SVU;
    private double KAR_SVT;
    private int KAR_XCANT;
    private double KAR_XVU;
    private double KAR_XVT;
    
    public Kardex()
    {
    }
    public Kardex
        (
            int KAR_ID,
            int PRO_ID,
            String KAR_FECHA,
            String KAR_DETALLE,
            int KAR_ECANT,
            double KAR_EVU,
            double KAR_EVT,
            int KAR_SCANT,
            double KAR_SVU,
            double KAR_SVT,
            int KAR_XCANT,
            double KAR_XVU,
            double KAR_XVT
        )
    {
        this.KAR_ID=KAR_ID;
        this.PRO_ID=PRO_ID;
        this.KAR_FECHA=KAR_FECHA;
        this.KAR_DETALLE=KAR_DETALLE;
        this.KAR_ECANT=KAR_ECANT;
        this.KAR_EVU=KAR_EVU;
        this.KAR_EVT=KAR_EVT;
        this.KAR_SCANT=KAR_SCANT;
        this.KAR_SVU=KAR_SVU;
        this.KAR_SVT=KAR_SVT;
        this.KAR_XCANT=KAR_XCANT;
        this.KAR_XVU=KAR_XVU;
        this.KAR_XVT=KAR_XVT;
    }

    /**
     * @return the KAR_ID
     */
    public int getKAR_ID() {
        return KAR_ID;
    }

    /**
     * @param KAR_ID the KAR_ID to set
     */
    public void setKAR_ID(int KAR_ID) {
        this.KAR_ID = KAR_ID;
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
     * @return the KAR_FECHA
     */
    public String getKAR_FECHA() {
        return KAR_FECHA;
    }

    /**
     * @param KAR_FECHA the KAR_FECHA to set
     */
    public void setKAR_FECHA(String KAR_FECHA) {
        this.KAR_FECHA = KAR_FECHA;
    }

    /**
     * @return the KAR_DETALLE
     */
    public String getKAR_DETALLE() {
        return KAR_DETALLE;
    }

    /**
     * @param KAR_DETALLE the KAR_DETALLE to set
     */
    public void setKAR_DETALLE(String KAR_DETALLE) {
        this.KAR_DETALLE = KAR_DETALLE;
    }

    /**
     * @return the KAR_ECANT
     */
    public int getKAR_ECANT() {
        return KAR_ECANT;
    }

    /**
     * @param KAR_ECANT the KAR_ECANT to set
     */
    public void setKAR_ECANT(int KAR_ECANT) {
        this.KAR_ECANT = KAR_ECANT;
    }

    /**
     * @return the KAR_EVU
     */
    public double getKAR_EVU() {
        return KAR_EVU;
    }

    /**
     * @param KAR_EVU the KAR_EVU to set
     */
    public void setKAR_EVU(double KAR_EVU) {
        this.KAR_EVU = KAR_EVU;
    }

    /**
     * @return the KAR_EVT
     */
    public double getKAR_EVT() {
        return KAR_EVT;
    }

    /**
     * @param KAR_EVT the KAR_EVT to set
     */
    public void setKAR_EVT(double KAR_EVT) {
        this.KAR_EVT = KAR_EVT;
    }

    /**
     * @return the KAR_SCANT
     */
    public int getKAR_SCANT() {        
        return KAR_SCANT;
    }

    /**
     * @param KAR_SCANT the KAR_SCANT to set
     */
    public void setKAR_SCANT(int KAR_SCANT) {
        this.KAR_SCANT = KAR_SCANT;
    }

    /**
     * @return the KAR_SVU
     */
    public double getKAR_SVU() {
        return KAR_SVU;
    }

    /**
     * @param KAR_SVU the KAR_SVU to set
     */
    public void setKAR_SVU(double KAR_SVU) {
        this.KAR_SVU = KAR_SVU;
    }

    /**
     * @return the KAR_SVT
     */
    public double getKAR_SVT() {
        return KAR_SVT;
    }

    /**
     * @param KAR_SVT the KAR_SVT to set
     */
    public void setKAR_SVT(double KAR_SVT) {
        this.KAR_SVT = KAR_SVT;
    }

    /**
     * @return the KAR_XCANT
     */
    public int getKAR_XCANT() {
        return KAR_XCANT;
    }

    /**
     * @param KAR_XCANT the KAR_XCANT to set
     */
    public void setKAR_XCANT(int KAR_XCANT) {
        this.KAR_XCANT = KAR_XCANT;
    }

    /**
     * @return the KAR_XVU
     */
    public double getKAR_XVU() {
        return KAR_XVU;
    }

    /**
     * @param KAR_XVU the KAR_XVU to set
     */
    public void setKAR_XVU(double KAR_XVU) {
        this.KAR_XVU = KAR_XVU;
    }

    /**
     * @return the KAR_XVT
     */
    public double getKAR_XVT() {
        return KAR_XVT;
    }

    /**
     * @param KAR_XVT the KAR_XVT to set
     */
    public void setKAR_XVT(double KAR_XVT) {
        this.KAR_XVT = KAR_XVT;
    }
}
