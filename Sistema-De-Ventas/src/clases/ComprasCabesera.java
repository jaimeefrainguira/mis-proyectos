package clases;

import java.text.DateFormat;
import java.util.Date;

public class ComprasCabesera 
{  
    private int COM_CAB_ID;
    private int COM_CAB_PROVEEDOR_ID;
    private int COM_CAB_USUARIO_ID;
    private String COM_CAB_FECHA;
    private int COM_CAB_TIPO_COMPROVANTE;
    private int COM_CAB_NUM_COMPROVANTE;
    private double COM_CAB_SUBTOTAL;
    private double COM_CAB_IVA;
    private double COM_CAB_TOTAL;
    private boolean COM_CAB_ESTADO;
    
    public ComprasCabesera()
    {
    }
    
    public ComprasCabesera(
            int COM_CAB_ID,
            int COM_CAB_PROVEEDOR_ID,
            int COM_CAB_USUARIO_ID,
            String COM_CAB_FECHA,
            int COM_CAB_TIPO_COMPROVANTE,
            int COM_CAB_NUM_COMPROVANTE,
            double COM_CAB_SUBTOTAL,
            double COM_CAB_IVA,
            double COM_CAB_TOTAL,
            boolean COM_CAB_ESTADO)
    {
        this.COM_CAB_ID=COM_CAB_ID;
        this.COM_CAB_PROVEEDOR_ID=COM_CAB_PROVEEDOR_ID;
        this.COM_CAB_USUARIO_ID=COM_CAB_USUARIO_ID;
        this.COM_CAB_FECHA=COM_CAB_FECHA;
        this.COM_CAB_TIPO_COMPROVANTE=COM_CAB_TIPO_COMPROVANTE;
        this.COM_CAB_NUM_COMPROVANTE=COM_CAB_NUM_COMPROVANTE;
        this.COM_CAB_SUBTOTAL=COM_CAB_SUBTOTAL;
        this.COM_CAB_IVA=COM_CAB_IVA;
        this.COM_CAB_TOTAL=COM_CAB_TOTAL;
        this.COM_CAB_ESTADO=COM_CAB_ESTADO;
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
     * @return the COM_CAB_PROVEEDOR_ID
     */
    public int getCOM_CAB_PROVEEDOR_ID() {
        return COM_CAB_PROVEEDOR_ID;
    }

    /**
     * @param COM_CAB_PROVEEDOR_ID the COM_CAB_PROVEEDOR_ID to set
     */
    public void setCOM_CAB_PROVEEDOR_ID(int COM_CAB_PROVEEDOR_ID) {
        this.COM_CAB_PROVEEDOR_ID = COM_CAB_PROVEEDOR_ID;
    }

    /**
     * @return the COM_CAB_USUARIO_ID
     */
    public int getCOM_CAB_USUARIO_ID() {
        return COM_CAB_USUARIO_ID;
    }

    /**
     * @param COM_CAB_USUARIO_ID the COM_CAB_USUARIO_ID to set
     */
    public void setCOM_CAB_USUARIO_ID(int COM_CAB_USUARIO_ID) {
        this.COM_CAB_USUARIO_ID = COM_CAB_USUARIO_ID;
    }

    /**
     * @return the COM_CAB_FECHA
     */
    public String getCOM_CAB_FECHA() {
        return COM_CAB_FECHA;
    }

    /**
     * @param COM_CAB_FECHA the COM_CAB_FECHA to set
     */
    public void setCOM_CAB_FECHA(String COM_CAB_FECHA) {
        this.COM_CAB_FECHA = COM_CAB_FECHA;
    }

    /**
     * @return the COM_CAB_TIPO_COMPROVANTE
     */
    public int getCOM_CAB_TIPO_COMPROVANTE() {
        return COM_CAB_TIPO_COMPROVANTE;
    }

    /**
     * @param COM_CAB_TIPO_COMPROVANTE the COM_CAB_TIPO_COMPROVANTE to set
     */
    public void setCOM_CAB_TIPO_COMPROVANTE(int COM_CAB_TIPO_COMPROVANTE) {
        this.COM_CAB_TIPO_COMPROVANTE = COM_CAB_TIPO_COMPROVANTE;
    }

    /**
     * @return the COM_CAB_NUM_COMPROVANTE
     */
    public int getCOM_CAB_NUM_COMPROVANTE() {
        return COM_CAB_NUM_COMPROVANTE;
    }

    /**
     * @param COM_CAB_NUM_COMPROVANTE the COM_CAB_NUM_COMPROVANTE to set
     */
    public void setCOM_CAB_NUM_COMPROVANTE(int COM_CAB_NUM_COMPROVANTE) {
        this.COM_CAB_NUM_COMPROVANTE = COM_CAB_NUM_COMPROVANTE;
    }

    /**
     * @return the COM_CAB_SUBTOTAL
     */
    public double getCOM_CAB_SUBTOTAL() {
        return COM_CAB_SUBTOTAL;
    }

    /**
     * @param COM_CAB_SUBTOTAL the COM_CAB_SUBTOTAL to set
     */
    public void setCOM_CAB_SUBTOTAL(double COM_CAB_SUBTOTAL) {
        this.COM_CAB_SUBTOTAL = COM_CAB_SUBTOTAL;
    }

    /**
     * @return the COM_CAB_IVA
     */
    public double getCOM_CAB_IVA() {
        return COM_CAB_IVA;
    }

    /**
     * @param COM_CAB_IVA the COM_CAB_IVA to set
     */
    public void setCOM_CAB_IVA(double COM_CAB_IVA) {
        this.COM_CAB_IVA = COM_CAB_IVA;
    }

    /**
     * @return the COM_CAB_TOTAL
     */
    public double getCOM_CAB_TOTAL() {
        return COM_CAB_TOTAL;
    }

    /**
     * @param COM_CAB_TOTAL the COM_CAB_TOTAL to set
     */
    public void setCOM_CAB_TOTAL(double COM_CAB_TOTAL) {
        this.COM_CAB_TOTAL = COM_CAB_TOTAL;
    }

    /**
     * @return the COM_CAB_ESTADO
     */
    public boolean isCOM_CAB_ESTADO() {
        return COM_CAB_ESTADO;
    }

    /**
     * @param COM_CAB_ESTADO the COM_CAB_ESTADO to set
     */
    public void setCOM_CAB_ESTADO(boolean COM_CAB_ESTADO) {
        this.COM_CAB_ESTADO = COM_CAB_ESTADO;
    }
}
