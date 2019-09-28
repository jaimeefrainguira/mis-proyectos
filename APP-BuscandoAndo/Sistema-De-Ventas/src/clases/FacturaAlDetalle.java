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
public class FacturaAlDetalle {
    
    
private int PRO_ID;
private String PRO_NOMBRE;
private String CAT_DESCRIPCION;
private int FAC_DET_CANTIDAD;
private double FAC_DET_PVP;
private double FAC_DET_DESCUENTO;
private double FAC_DET_TOTAL;
private double FAC_DET_GANANCIA;
public FacturaAlDetalle()
{
}
public FacturaAlDetalle(
        int PRO_ID,
        String PRO_NOMBRE,
        String CAT_DESCRIPCION,
        int FAC_DET_CANTIDAD,
        double FAC_DET_PVP,
        double FAC_DET_DESCUENTO,
        double FAC_DET_TOTAL,
        double FAC_DET_GANANCIA
)
{
    this.PRO_ID=PRO_ID;
    this.PRO_NOMBRE=PRO_NOMBRE;
    this.CAT_DESCRIPCION=CAT_DESCRIPCION;
    this.FAC_DET_CANTIDAD=FAC_DET_CANTIDAD;
    this.FAC_DET_PVP=FAC_DET_PVP;
    this.FAC_DET_DESCUENTO=FAC_DET_DESCUENTO;
    this.FAC_DET_TOTAL=FAC_DET_TOTAL;
    this.FAC_DET_GANANCIA=FAC_DET_GANANCIA;
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
     * @return the PRO_NOMBRE
     */
    public String getPRO_NOMBRE() {
        return PRO_NOMBRE;
    }

    /**
     * @param PRO_NOMBRE the PRO_NOMBRE to set
     */
    public void setPRO_NOMBRE(String PRO_NOMBRE) {
        this.PRO_NOMBRE = PRO_NOMBRE;
    }

    /**
     * @return the CAT_DESCRIPCION
     */
    public String getCAT_DESCRIPCION() {
        return CAT_DESCRIPCION;
    }

    /**
     * @param CAT_DESCRIPCION the CAT_DESCRIPCION to set
     */
    public void setCAT_DESCRIPCION(String CAT_DESCRIPCION) {
        this.CAT_DESCRIPCION = CAT_DESCRIPCION;
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
     * @return the FAC_DET_GANANCIA
     */
    public double getFAC_DET_GANANCIA() {
        return FAC_DET_GANANCIA;
    }

    /**
     * @param FAC_DET_GANANCIA the FAC_DET_GANANCIA to set
     */
    public void setFAC_DET_GANANCIA(double FAC_DET_GANANCIA) {
        this.FAC_DET_GANANCIA = FAC_DET_GANANCIA;
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
