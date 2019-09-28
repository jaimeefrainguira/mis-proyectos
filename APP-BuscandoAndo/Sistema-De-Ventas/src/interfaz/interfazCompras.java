package interfaz;

import clases.ComprasCabeseraDetallada;
import clases.ComprasDetalleDetallado;
import clases.ComprasCabesera;
import clases.ComprasDetalladas;
import clases.ComprasDetalle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

public interface interfazCompras 
{
    public boolean registrar(ComprasCabesera compras,ArrayList<ComprasDetalle> detalle);
    public boolean modificar(ComprasCabesera compras);
    public int getId();
    public ArrayList<ComprasCabeseraDetallada> buscar(String desde,String hasta,int tipo,String valores);
    public ArrayList<ComprasDetalleDetallado> buscarDetalle(int codigo);
    public ComprasCabesera buscarById(String texto);
    public void getUltimoRegistroKardex(int PRO_ID);
    
//    public boolean registrarDetalle(ArrayList<ComprasDetalle> compras);

    public boolean anularCompra(ArrayList<ComprasDetalleDetallado> detalle, int codigoCabesera);

    public ArrayList<ComprasDetalladas> getComprasDetalladas(JTable tabla, String desde, String hasta);
}
