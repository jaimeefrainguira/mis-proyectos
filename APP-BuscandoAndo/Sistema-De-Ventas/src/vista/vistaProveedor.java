package vista;

//import clases.Cliente;
import clases.Persona;
import clases.Proveedor;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class vistaProveedor 
{
    public DefaultTableModel modeloTabla1;
    public DefaultComboBoxModel lista = new DefaultComboBoxModel();
    //Creamos el encavezado para la tabla
    String[]encavezado={
        "ID",
        "CÉDULA",
        "NOMBRE",
        "DIRECCIÓN",
        "TELÉFONO",
        "CORREO",
        "SEXO",
        "ESTADO"
    };
    //Creamos donde se van a almacenar los datos para la tabla
    String[][]datos={};
    public DefaultTableModel verProveedor(List<Object> arraClase) 
    {
        
        
        modeloTabla1=new DefaultTableModel(datos,encavezado);
        
        for (Object clase : arraClase) 
        {
            Proveedor proveedores=(Proveedor) clase;

            Object fila []={
                proveedores.getPER_ID(),
                proveedores.getPER_CEDULA(),
                proveedores.getPER_NOMBRE(),
                proveedores.getPER_DIRECCION(),
                proveedores.getPER_TELEFONO(),
                proveedores.getPER_CORREO(),
                proveedores.getPER_SEXO(),
                proveedores.isPROV_ESTADO()? 1 : 0,
            };
            modeloTabla1.addRow(fila);
        }        
        return modeloTabla1;        
    }
}
