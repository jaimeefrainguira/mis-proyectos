package clases;

public class Producto 
{
    private int PRO_ID;
    private String PRO_NOMBRE;
    private String PRO_DESCRIPCION;
    private double PRO_PRECIO_COSTO;
    private double PRO_PRECIO_VENTA;
    private int PRO_STOCK;
    private int PRO_STOCK_MINIMO;
    private boolean PRO_ESTADO;
    private int CAT_ID;
    
    public Producto()
    {
    }
    
    public Producto(
            int PRO_ID,
            String PRO_NOMBRE,
            String PRO_DESCRIPCION,
            double PRO_PRECIO_COSTO,
            double PRO_PRECIO_VENTA,
            int PRO_STOCK,
            int PRO_STOCK_MINIMO,
            boolean PRO_ESTADO,
            int CAT_ID)
    {
        this.PRO_ID=PRO_ID;
        this.PRO_NOMBRE=PRO_NOMBRE;
        this.PRO_DESCRIPCION=PRO_DESCRIPCION;
        this.PRO_PRECIO_COSTO=PRO_PRECIO_COSTO;
        this.PRO_PRECIO_VENTA=PRO_PRECIO_VENTA;
        this.PRO_STOCK=PRO_STOCK;
        this.PRO_STOCK_MINIMO=PRO_STOCK_MINIMO;
        this.PRO_ESTADO=PRO_ESTADO;
        this.CAT_ID=CAT_ID;
        
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
     * @return the PRO_DESCRIPCION
     */
    public String getPRO_DESCRIPCION() {
        return PRO_DESCRIPCION;
    }

    /**
     * @param PRO_DESCRIPCION the PRO_DESCRIPCION to set
     */
    public void setPRO_DESCRIPCION(String PRO_DESCRIPCION) {
        this.PRO_DESCRIPCION = PRO_DESCRIPCION;
    }

    /**
     * @return the PRO_PRECIO_COSTO
     */
    public double getPRO_PRECIO_COSTO() {
        return PRO_PRECIO_COSTO;
    }

    /**
     * @param PRO_PRECIO_COSTO the PRO_PRECIO_COSTO to set
     */
    public void setPRO_PRECIO_COSTO(double PRO_PRECIO_COSTO) {
        this.PRO_PRECIO_COSTO = PRO_PRECIO_COSTO;
    }

    /**
     * @return the PRO_PRECIO_VENTA
     */
    public double getPRO_PRECIO_VENTA() {
        return PRO_PRECIO_VENTA;
    }

    /**
     * @param PRO_PRECIO_VENTA the PRO_PRECIO_VENTA to set
     */
    public void setPRO_PRECIO_VENTA(double PRO_PRECIO_VENTA) {
        this.PRO_PRECIO_VENTA = PRO_PRECIO_VENTA;
    }

    /**
     * @return the PRO_STOCK
     */
    public int getPRO_STOCK() {
        return PRO_STOCK;
    }

    /**
     * @param PRO_STOCK the PRO_STOCK to set
     */
    public void setPRO_STOCK(int PRO_STOCK) {
        this.PRO_STOCK = PRO_STOCK;
    }

    /**
     * @return the PRO_STOCK_MINIMO
     */
    public int getPRO_STOCK_MINIMO() {
        return PRO_STOCK_MINIMO;
    }

    /**
     * @param PRO_STOCK_MINIMO the PRO_STOCK_MINIMO to set
     */
    public void setPRO_STOCK_MINIMO(int PRO_STOCK_MINIMO) {
        this.PRO_STOCK_MINIMO = PRO_STOCK_MINIMO;
    }

    /**
     * @return the PRO_ESTADO
     */
    public boolean isPRO_ESTADO() {
        return PRO_ESTADO;
    }

    /**
     * @param PRO_ESTADO the PRO_ESTADO to set
     */
    public void setPRO_ESTADO(boolean PRO_ESTADO) {
        this.PRO_ESTADO = PRO_ESTADO;
    }

    /**
     * @return the CAT_ID
     */
    public int getCAT_ID() {
        return CAT_ID;
    }

    /**
     * @param CAT_ID the CAT_ID to set
     */
    public void setCAT_ID(int CAT_ID) {
        this.CAT_ID = CAT_ID;
    }
}
