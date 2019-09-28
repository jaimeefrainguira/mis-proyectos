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
public class FacturaCabeseraDetallada extends FacturaCabesera {
   
    private String CLIENTE;   
    private String USUARIO;
    
    
    public FacturaCabeseraDetallada()
    {
    }
    
    public FacturaCabeseraDetallada(
            int FAC_CAB_ID,
            String FAC_CAB_FECHA,
            double FAC_CAB_SUBTOTAL,
            double FAC_DET_DESCUENTO,
            double FAC_CAB_IVA,
            double FAC_CAB_TOTAL,
            int FAC_CAB_FORMA_P,
            int PER_ID,
            String CLIENTE,
            int USUARIO_ID,
            String USUARIO,
            boolean FAC_CAB_ESTADO)
    {
        super(FAC_CAB_ID,FAC_CAB_FECHA,FAC_CAB_SUBTOTAL,FAC_DET_DESCUENTO,FAC_CAB_IVA,FAC_CAB_TOTAL,FAC_CAB_FORMA_P,PER_ID,USUARIO_ID,FAC_CAB_ESTADO);
        this.CLIENTE=CLIENTE;
        this.USUARIO=USUARIO;
    }

    /**
     * @return the CLIENTE
     */
    public String getCLIENTE() {
        return CLIENTE;
    }

    /**
     * @param CLIENTE the CLIENTE to set
     */
    public void setCLIENTE(String CLIENTE) {
        this.CLIENTE = CLIENTE;
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
