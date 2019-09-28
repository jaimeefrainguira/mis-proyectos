package clases;

public class TipoUsuario 
{
    private int TIP_USU_ID;
    private String TIP_USU_DESCRIPCION;
    private boolean TIP_USU_PRODUCTO,
            TIP_USU_MERCADERIA,
            TIP_USU_COMPRAS,
            TIP_USU_PROVEEDORES,
            TIP_USU_VENTA,
            TIP_USU_CLIENTES,
            TIP_USU_VERIFICAR_PRODUCTO,
            TIP_USU_VENTAS_REALIZADAS,            
            TIP_USU_VENTAS_DETALLADAS,
            TIP_USU_ESTADISTICA_MENSUAL,
            TIP_USU_COMPRAS_REALIZADAS,
            TIP_USU_COMPRAS_DETALLADAS,
            TIP_USU_EMPLEADOS,
            TIP_USU_TIPO_DE_USUARIO,
            TIP_USU_SERVICIO_TECNICO,
            TIP_USU_ANULAR_VENTA,
            TIP_USU_ANULAR_COMPRA,
            TIP_USU_CAMBIAR_CONTRASEÑA,
            TIP_USU_USUARIOS,
            TIP_USU_RESPALDAR_BD,
            TIP_USU_RESTAURAR_BD;
    
    
    public TipoUsuario()
    {
    }
    public TipoUsuario(
            int TIP_USU_ID,
            String TIP_USU_DESCRIPCION,
            boolean TIP_USU_PRODUCTO,
            boolean TIP_USU_MERCADERIA,
            boolean TIP_USU_COMPRAS,
            boolean TIP_USU_PROVEEDORES,
            boolean TIP_USU_VENTA,
            boolean TIP_USU_CLIENTES,
            boolean TIP_USU_VERIFICAR_PRODUCTO,
            boolean TIP_USU_VENTAS_REALIZADAS,
            boolean TIP_USU_VENTAS_DETALLADAS,
            boolean TIP_USU_ESTADISTICA_MENSUAL,
            boolean TIP_USU_COMPRAS_REALIZADAS,
            boolean TIP_USU_COMPRAS_DETALLADAS,
            boolean TIP_USU_EMPLEADOS,
            boolean TIP_USU_TIPO_DE_USUARIO,
            boolean TIP_USU_SERVICIO_TECNICO,
            boolean TIP_USU_ANULAR_VENTA,
            boolean TIP_USU_ANULAR_COMPRA,
            boolean TIP_USU_CAMBIAR_CONTRASEÑA,
            boolean TIP_USU_USUARIOS,
            boolean TIP_USU_RESPALDAR_BD,
            boolean TIP_USU_RESTAURAR_BD)
    {
        this.TIP_USU_ID=TIP_USU_ID;
        this.TIP_USU_DESCRIPCION=TIP_USU_DESCRIPCION;
        this.TIP_USU_PRODUCTO=TIP_USU_PRODUCTO;
        this.TIP_USU_MERCADERIA=TIP_USU_MERCADERIA;
        this.TIP_USU_COMPRAS=TIP_USU_COMPRAS;
        this.TIP_USU_PROVEEDORES=TIP_USU_PROVEEDORES;
        this.TIP_USU_VENTA=TIP_USU_VENTA;
        this.TIP_USU_CLIENTES=TIP_USU_CLIENTES;
        this.TIP_USU_VERIFICAR_PRODUCTO=TIP_USU_VERIFICAR_PRODUCTO;
        this.TIP_USU_VENTAS_REALIZADAS=TIP_USU_VENTAS_REALIZADAS;
        this.TIP_USU_VENTAS_DETALLADAS=TIP_USU_VENTAS_DETALLADAS;
        this.TIP_USU_ESTADISTICA_MENSUAL=TIP_USU_ESTADISTICA_MENSUAL;
        this.TIP_USU_COMPRAS_REALIZADAS=TIP_USU_COMPRAS_REALIZADAS;
        this.TIP_USU_COMPRAS_DETALLADAS=TIP_USU_COMPRAS_DETALLADAS;
        this.TIP_USU_EMPLEADOS=TIP_USU_EMPLEADOS;
        this.TIP_USU_TIPO_DE_USUARIO=TIP_USU_TIPO_DE_USUARIO;
        this.TIP_USU_SERVICIO_TECNICO=TIP_USU_SERVICIO_TECNICO;
        this.TIP_USU_ANULAR_VENTA=TIP_USU_ANULAR_VENTA;
        this.TIP_USU_ANULAR_COMPRA=TIP_USU_ANULAR_COMPRA;
        this.TIP_USU_CAMBIAR_CONTRASEÑA=TIP_USU_CAMBIAR_CONTRASEÑA;
        this.TIP_USU_USUARIOS=TIP_USU_USUARIOS;
        this.TIP_USU_RESPALDAR_BD=TIP_USU_RESPALDAR_BD;
        this.TIP_USU_RESTAURAR_BD=TIP_USU_RESTAURAR_BD;
    }

    /**
     * @return the TIP_USU_ID
     */
    public int getTIP_USU_ID() {
        return TIP_USU_ID;
    }

    /**
     * @param TIP_USU_ID the TIP_USU_ID to set
     */
    public void setTIP_USU_ID(int TIP_USU_ID) {
        this.TIP_USU_ID = TIP_USU_ID;
    }

    /**
     * @return the TIP_USU_DESCRIPCION
     */
    public String getTIP_USU_DESCRIPCION() {
        return TIP_USU_DESCRIPCION;
    }

    /**
     * @param TIP_USU_DESCRIPCION the TIP_USU_DESCRIPCION to set
     */
    public void setTIP_USU_DESCRIPCION(String TIP_USU_DESCRIPCION) {
        this.TIP_USU_DESCRIPCION = TIP_USU_DESCRIPCION;
    }

    /**
     * @return the TIP_USU_PRODUCTO
     */
    public boolean isTIP_USU_PRODUCTO() {
        return TIP_USU_PRODUCTO;
    }

    /**
     * @param TIP_USU_PRODUCTO the TIP_USU_PRODUCTO to set
     */
    public void setTIP_USU_PRODUCTO(boolean TIP_USU_PRODUCTO) {
        this.TIP_USU_PRODUCTO = TIP_USU_PRODUCTO;
    }

    /**
     * @return the TIP_USU_MERCADERIA
     */
    public boolean isTIP_USU_MERCADERIA() {
        return TIP_USU_MERCADERIA;
    }

    /**
     * @param TIP_USU_MERCADERIA the TIP_USU_MERCADERIA to set
     */
    public void setTIP_USU_MERCADERIA(boolean TIP_USU_MERCADERIA) {
        this.TIP_USU_MERCADERIA = TIP_USU_MERCADERIA;
    }

    /**
     * @return the TIP_USU_COMPRAS
     */
    public boolean isTIP_USU_COMPRAS() {
        return TIP_USU_COMPRAS;
    }

    /**
     * @param TIP_USU_COMPRAS the TIP_USU_COMPRAS to set
     */
    public void setTIP_USU_COMPRAS(boolean TIP_USU_COMPRAS) {
        this.TIP_USU_COMPRAS = TIP_USU_COMPRAS;
    }

    /**
     * @return the TIP_USU_PROVEEDORES
     */
    public boolean isTIP_USU_PROVEEDORES() {
        return TIP_USU_PROVEEDORES;
    }

    /**
     * @param TIP_USU_PROVEEDORES the TIP_USU_PROVEEDORES to set
     */
    public void setTIP_USU_PROVEEDORES(boolean TIP_USU_PROVEEDORES) {
        this.TIP_USU_PROVEEDORES = TIP_USU_PROVEEDORES;
    }

    /**
     * @return the TIP_USU_CLIENTES
     */
    public boolean isTIP_USU_CLIENTES() {
        return TIP_USU_CLIENTES;
    }

    /**
     * @param TIP_USU_CLIENTES the TIP_USU_CLIENTES to set
     */
    public void setTIP_USU_CLIENTES(boolean TIP_USU_CLIENTES) {
        this.TIP_USU_CLIENTES = TIP_USU_CLIENTES;
    }

    /**
     * @return the TIP_USU_VENTAS_REALIZADAS
     */
    public boolean isTIP_USU_VENTAS_REALIZADAS() {
        return TIP_USU_VENTAS_REALIZADAS;
    }

    /**
     * @param TIP_USU_VENTAS_REALIZADAS the TIP_USU_VENTAS_REALIZADAS to set
     */
    public void setTIP_USU_VENTAS_REALIZADAS(boolean TIP_USU_VENTAS_REALIZADAS) {
        this.TIP_USU_VENTAS_REALIZADAS = TIP_USU_VENTAS_REALIZADAS;
    }

    /**
     * @return the TIP_USU_VENTAS_DETALLADAS
     */
    public boolean isTIP_USU_VENTAS_DETALLADAS() {
        return TIP_USU_VENTAS_DETALLADAS;
    }

    /**
     * @param TIP_USU_VENTAS_DETALLADAS the TIP_USU_VENTAS_DETALLADAS to set
     */
    public void setTIP_USU_VENTAS_DETALLADAS(boolean TIP_USU_VENTAS_DETALLADAS) {
        this.TIP_USU_VENTAS_DETALLADAS = TIP_USU_VENTAS_DETALLADAS;
    }

    /**
     * @return the TIP_USU_ESTADISTICA_MENSUAL
     */
    public boolean isTIP_USU_ESTADISTICA_MENSUAL() {
        return TIP_USU_ESTADISTICA_MENSUAL;
    }

    /**
     * @param TIP_USU_ESTADISTICA_MENSUAL the TIP_USU_ESTADISTICA_MENSUAL to set
     */
    public void setTIP_USU_ESTADISTICA_MENSUAL(boolean TIP_USU_ESTADISTICA_MENSUAL) {
        this.TIP_USU_ESTADISTICA_MENSUAL = TIP_USU_ESTADISTICA_MENSUAL;
    }

    /**
     * @return the TIP_USU_COMPRAS_REALIZADAS
     */
    public boolean isTIP_USU_COMPRAS_REALIZADAS() {
        return TIP_USU_COMPRAS_REALIZADAS;
    }

    /**
     * @param TIP_USU_COMPRAS_REALIZADAS the TIP_USU_COMPRAS_REALIZADAS to set
     */
    public void setTIP_USU_COMPRAS_REALIZADAS(boolean TIP_USU_COMPRAS_REALIZADAS) {
        this.TIP_USU_COMPRAS_REALIZADAS = TIP_USU_COMPRAS_REALIZADAS;
    }

    /**
     * @return the TIP_USU_COMPRAS_DETALLADAS
     */
    public boolean isTIP_USU_COMPRAS_DETALLADAS() {
        return TIP_USU_COMPRAS_DETALLADAS;
    }

    /**
     * @param TIP_USU_COMPRAS_DETALLADAS the TIP_USU_COMPRAS_DETALLADAS to set
     */
    public void setTIP_USU_COMPRAS_DETALLADAS(boolean TIP_USU_COMPRAS_DETALLADAS) {
        this.TIP_USU_COMPRAS_DETALLADAS = TIP_USU_COMPRAS_DETALLADAS;
    }

    /**
     * @return the TIP_USU_EMPLEADOS
     */
    public boolean isTIP_USU_EMPLEADOS() {
        return TIP_USU_EMPLEADOS;
    }

    /**
     * @param TIP_USU_EMPLEADOS the TIP_USU_EMPLEADOS to set
     */
    public void setTIP_USU_EMPLEADOS(boolean TIP_USU_EMPLEADOS) {
        this.TIP_USU_EMPLEADOS = TIP_USU_EMPLEADOS;
    }

    /**
     * @return the TIP_USU_TIPO_DE_USUARIO
     */
    public boolean isTIP_USU_TIPO_DE_USUARIO() {
        return TIP_USU_TIPO_DE_USUARIO;
    }

    /**
     * @param TIP_USU_TIPO_DE_USUARIO the TIP_USU_TIPO_DE_USUARIO to set
     */
    public void setTIP_USU_TIPO_DE_USUARIO(boolean TIP_USU_TIPO_DE_USUARIO) {
        this.TIP_USU_TIPO_DE_USUARIO = TIP_USU_TIPO_DE_USUARIO;
    }

    /**
     * @return the TIP_USU_SERVICIO_TECNICO
     */
    public boolean isTIP_USU_SERVICIO_TECNICO() {
        return TIP_USU_SERVICIO_TECNICO;
    }

    /**
     * @param TIP_USU_SERVICIO_TECNICO the TIP_USU_SERVICIO_TECNICO to set
     */
    public void setTIP_USU_SERVICIO_TECNICO(boolean TIP_USU_SERVICIO_TECNICO) {
        this.TIP_USU_SERVICIO_TECNICO = TIP_USU_SERVICIO_TECNICO;
    }

    /**
     * @return the TIP_USU_ANULAR_VENTA
     */
    public boolean isTIP_USU_ANULAR_VENTA() {
        return TIP_USU_ANULAR_VENTA;
    }

    /**
     * @param TIP_USU_ANULAR_VENTA the TIP_USU_ANULAR_VENTA to set
     */
    public void setTIP_USU_ANULAR_VENTA(boolean TIP_USU_ANULAR_VENTA) {
        this.TIP_USU_ANULAR_VENTA = TIP_USU_ANULAR_VENTA;
    }

    /**
     * @return the TIP_USU_ANULAR_COMPRA
     */
    public boolean isTIP_USU_ANULAR_COMPRA() {
        return TIP_USU_ANULAR_COMPRA;
    }

    /**
     * @param TIP_USU_ANULAR_COMPRA the TIP_USU_ANULAR_COMPRA to set
     */
    public void setTIP_USU_ANULAR_COMPRA(boolean TIP_USU_ANULAR_COMPRA) {
        this.TIP_USU_ANULAR_COMPRA = TIP_USU_ANULAR_COMPRA;
    }

    /**
     * @return the TIP_USU_CAMBIAR_CONTRASEÑA
     */
    public boolean isTIP_USU_CAMBIAR_CONTRASEÑA() {
        return TIP_USU_CAMBIAR_CONTRASEÑA;
    }

    /**
     * @param TIP_USU_CAMBIAR_CONTRASEÑA the TIP_USU_CAMBIAR_CONTRASEÑA to set
     */
    public void setTIP_USU_CAMBIAR_CONTRASEÑA(boolean TIP_USU_CAMBIAR_CONTRASEÑA) {
        this.TIP_USU_CAMBIAR_CONTRASEÑA = TIP_USU_CAMBIAR_CONTRASEÑA;
    }

    /**
     * @return the TIP_USU_USUARIOS
     */
    public boolean isTIP_USU_USUARIOS() {
        return TIP_USU_USUARIOS;
    }

    /**
     * @param TIP_USU_USUARIOS the TIP_USU_USUARIOS to set
     */
    public void setTIP_USU_USUARIOS(boolean TIP_USU_USUARIOS) {
        this.TIP_USU_USUARIOS = TIP_USU_USUARIOS;
    }

    /**
     * @return the TIP_USU_RESPALDAR_BD
     */
    public boolean isTIP_USU_RESPALDAR_BD() {
        return TIP_USU_RESPALDAR_BD;
    }

    /**
     * @param TIP_USU_RESPALDAR_BD the TIP_USU_RESPALDAR_BD to set
     */
    public void setTIP_USU_RESPALDAR_BD(boolean TIP_USU_RESPALDAR_BD) {
        this.TIP_USU_RESPALDAR_BD = TIP_USU_RESPALDAR_BD;
    }

    /**
     * @return the TIP_USU_RESTAURAR_BD
     */
    public boolean isTIP_USU_RESTAURAR_BD() {
        return TIP_USU_RESTAURAR_BD;
    }

    /**
     * @param TIP_USU_RESTAURAR_BD the TIP_USU_RESTAURAR_BD to set
     */
    public void setTIP_USU_RESTAURAR_BD(boolean TIP_USU_RESTAURAR_BD) {
        this.TIP_USU_RESTAURAR_BD = TIP_USU_RESTAURAR_BD;
    }

    /**
     * @return the TIP_USU_VERIFICAR_PRODUCTO
     */
    public boolean isTIP_USU_VERIFICAR_PRODUCTO() {
        return TIP_USU_VERIFICAR_PRODUCTO;
    }

    /**
     * @param TIP_USU_VERIFICAR_PRODUCTO the TIP_USU_VERIFICAR_PRODUCTO to set
     */
    public void setTIP_USU_VERIFICAR_PRODUCTO(boolean TIP_USU_VERIFICAR_PRODUCTO) {
        this.TIP_USU_VERIFICAR_PRODUCTO = TIP_USU_VERIFICAR_PRODUCTO;
    }

    /**
     * @return the TIP_USU_VENTA
     */
    public boolean isTIP_USU_VENTA() {
        return TIP_USU_VENTA;
    }

    /**
     * @param TIP_USU_VENTA the TIP_USU_VENTA to set
     */
    public void setTIP_USU_VENTA(boolean TIP_USU_VENTA) {
        this.TIP_USU_VENTA = TIP_USU_VENTA;
    }

    
    
}
