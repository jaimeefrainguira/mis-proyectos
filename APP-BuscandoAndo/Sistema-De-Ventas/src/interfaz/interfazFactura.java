package interfaz;

import clases.FacturaAlDetalle;
import clases.FacturaCabeseraDetallada;
import clases.FacturaCabesera;
import clases.FacturaDetalle;
import clases.FacturaDetalleDetallado;
import java.util.ArrayList;
import javax.swing.JTable;

public interface interfazFactura 
{
    public boolean registrar(FacturaCabesera cabesera,ArrayList<FacturaDetalle> detalle,int comprobante);
    public boolean modificar(FacturaCabesera cabesera);
    public int getId();
    public int getIdNota();
    public ArrayList<FacturaCabesera> buscar(String texto);
    public FacturaCabesera buscarById(String texto);
    public void getValorVentaKardexSegunCodigoDetalle(int _PRO_ID,String _KAR_DETALLE);
    public void getUltimoRegistroKardex(int PRO_ID);

    public ArrayList<FacturaCabeseraDetallada> buscarVentas(String desde, String hasta,String valores);

    public ArrayList<FacturaDetalleDetallado> buscarDetalle(int codigoCabesera);

    public void anular(ArrayList<FacturaDetalleDetallado> detalle, int fila);

    public ArrayList<FacturaAlDetalle> buscarVentasAlDetalle(JTable jTable1, String desde, String hasta);
    
}
