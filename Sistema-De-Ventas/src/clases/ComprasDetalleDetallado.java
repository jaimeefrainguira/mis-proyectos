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
public class ComprasDetalleDetallado extends ComprasDetalle{
    private String PRODUCTO;
    
    public ComprasDetalleDetallado()
    {
    }
    
    public ComprasDetalleDetallado(String PRODUCTO,int COM_CAB_ID,int PRO_ID,int COM_DET_CATIDAD,double COM_DET_VALOR,double COM_DET_TOTAL)
    {
        super(COM_CAB_ID,PRO_ID,COM_DET_CATIDAD,COM_DET_VALOR,COM_DET_TOTAL);
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
