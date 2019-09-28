package vista;

import clases.Persona;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class vistaCliente 
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
    public DefaultTableModel verClientes(List<Object> arraClase) 
    {
        
        
        modeloTabla1=new DefaultTableModel(datos,encavezado);
        
        for (Object clase : arraClase) 
        {
            Persona clientes=(Persona) clase;
            Object fila []={
                clientes.getPER_ID(),
                clientes.getPER_CEDULA(),
                clientes.getPER_NOMBRE(),
                clientes.getPER_DIRECCION(),
                clientes.getPER_TELEFONO(),
                clientes.getPER_CORREO(),
                clientes.getPER_SEXO(),
                clientes.isPER_ESTADO()? 1 : 0,
            };
            modeloTabla1.addRow(fila);
        }        
        return modeloTabla1;        
    }
}