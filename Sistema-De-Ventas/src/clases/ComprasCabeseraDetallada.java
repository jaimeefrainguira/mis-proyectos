/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author jaimeguiracocha
 */
public class ComprasCabeseraDetallada extends ComprasCabesera{
    private String PROVEEDOR;
    private String USUARIO;
    
    public ComprasCabeseraDetallada()
    {
    }
    
    public ComprasCabeseraDetallada(
            int COM_CAB_ID,
            int COM_CAB_PROVEEDOR_ID,
            String PROVEEDOR,
            int COM_CAB_USUARIO_ID,
            String USUARIO,
            String COM_CAB_FECHA,
            int COM_CAB_TIPO_COMPROVANTE,
            int COM_CAB_NUM_COMPROVANTE,
            double COM_CAB_SUBTOTAL,
            double COM_CAB_IVA,
            double COM_CAB_TOTAL,
            boolean COM_CAB_ESTADO)
    {
        super(
            COM_CAB_ID,
            COM_CAB_PROVEEDOR_ID,
            COM_CAB_USUARIO_ID,
            COM_CAB_FECHA,
            COM_CAB_TIPO_COMPROVANTE,
            COM_CAB_NUM_COMPROVANTE,
            COM_CAB_SUBTOTAL,
            COM_CAB_IVA,
            COM_CAB_TOTAL,
            COM_CAB_ESTADO
        );
        this.PROVEEDOR=PROVEEDOR;
        this.USUARIO=USUARIO;
    }

    /**
     * @return the PROVEEDOR
     */
    public String getPROVEEDOR() {
        return PROVEEDOR;
    }

    /**
     * @param PROVEEDOR the PROVEEDOR to set
     */
    public void setPROVEEDOR(String PROVEEDOR) {
        this.PROVEEDOR = PROVEEDOR;
    }

    /**
     * @return the USUARIO
     */
    public String getUSUARIO() {
        return USUARIO;
    }

    /**
     * @param USUARIO the USUARIO to set
     */
    public void setUSUARIO(String USUARIO) {
        this.USUARIO = USUARIO;
    }
    
}
