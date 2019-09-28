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
public class FacturaDetalleDetallado extends FacturaDetalle{
   private String PRODUCTO;
    
    public FacturaDetalleDetallado()
    {
    }
    
    public FacturaDetalleDetallado(
            int FAC_CAB_ID,
            int PRO_ID,
            int FAC_DET_CANTIDAD,
            double FAC_DET_PVP,
            double FAC_DET_DESCUENTO,
            double FAC_DET_TOTAL,
            double FAC_DET_PC,
            String PRODUCTO)
    {
        super(FAC_CAB_ID,PRO_ID,FAC_DET_CANTIDAD,FAC_DET_PVP,FAC_DET_DESCUENTO,FAC_DET_TOTAL,FAC_DET_PC);
        this.PRODUCTO=PRODUCTO;
    }

    /**
     * @return the PRODUCTO
     */
    public String getPRODUCTO() {
        return PRODUCTO;
    }

    /**
     * @param PRODUCTO the PRODUCTO to set
     */
    public void setPRODUCTO(String PRODUCTO) {
        this.PRODUCTO = PRODUCTO;
    }
    
}
