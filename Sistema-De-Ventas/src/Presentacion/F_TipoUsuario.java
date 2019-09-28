package Presentacion;
import clases.TipoUsuario;
import controlador.controladorTipoUsuario;
import java.awt.Color;
import java.awt.Component;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class F_TipoUsuario extends javax.swing.JInternalFrame implements Runnable{
    public static String vf;
    Thread hilo1;
    
    
    
    TipoUsuario tipoUsuario=new TipoUsuario();;
    controladorTipoUsuario controladorTipoUsuario = new controladorTipoUsuario();
    public F_TipoUsuario() {
        
        
        initComponents(); 
        
        
        
		
         
        controladorTipoUsuario.getAll(tabla);
        
        
//        tabla.setModel(controladorTipoUsuario.getAllTiposUsuarios());
        mensaje.setText("Se cargaron "+tabla.getRowCount()+" registros");
            hilo1 = new Thread(this);
             hilo1.start();
        vf = ("vf");
//       controladorTipoUsuario.anchoTablas(tabla);
       }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        busq_usuario = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        PanelConPestania = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        tusuario_buscar = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        Boton_Compras = new javax.swing.JCheckBox();
        Boton_Mercadería = new javax.swing.JCheckBox();
        Boton_Ventas_Realizadas = new javax.swing.JCheckBox();
        Boton_Producto = new javax.swing.JCheckBox();
        Boton_Proveedores = new javax.swing.JCheckBox();
        Boton_Clientes = new javax.swing.JCheckBox();
        Boton_Tipo_Usuario = new javax.swing.JCheckBox();
        Boton_Empleados = new javax.swing.JCheckBox();
        Boton_Servicio_Tecnico = new javax.swing.JCheckBox();
        Boton_Compra_Detallada = new javax.swing.JCheckBox();
        Boton_Usuarios = new javax.swing.JCheckBox();
        Boton_Anular_Venta = new javax.swing.JCheckBox();
        Boton_Restaurar_BD = new javax.swing.JCheckBox();
        Boton_Estadistica_Mensual = new javax.swing.JCheckBox();
        Boton_Anular_Compra = new javax.swing.JCheckBox();
        Boton_Compra_Realizada = new javax.swing.JCheckBox();
        Boton_Cambiar_Contrasena = new javax.swing.JCheckBox();
        Boton_Verificar_Producto = new javax.swing.JCheckBox();
        Boton_Venta_Detallada = new javax.swing.JCheckBox();
        Boton_Respalda_BD = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Boton_Venta = new javax.swing.JCheckBox();
        bt_nuevo = new javax.swing.JButton();
        bt_modificar = new javax.swing.JButton();
        bt_guardar = new javax.swing.JButton();
        bt_salir = new javax.swing.JButton();
        mensaje = new javax.swing.JLabel();

        setBackground(new java.awt.Color(233, 228, 234));
        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("REGISTRO PARA DAR OPCIONES DEL MENU");
        setVisible(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
        });

        PanelConPestania.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 255)));
        PanelConPestania.setForeground(new java.awt.Color(51, 51, 255));
        PanelConPestania.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        PanelConPestania.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        PanelConPestania.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                PanelConPestaniaStateChanged(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Busqueda Avanzada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 51, 255))); // NOI18N

        tusuario_buscar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tusuario_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tusuario_buscarKeyReleased(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar1.png"))); // NOI18N
        jLabel13.setText(" Buscar por Codigo o Descripción:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tusuario_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tusuario_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/empleado1.png"))); // NOI18N
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel6.setAlignmentX(10.0F);
        jLabel6.setAlignmentY(10.0F);
        jLabel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_BOTTOM, new java.awt.Font("Tahoma", 1, 10), new java.awt.Color(102, 102, 255))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelConPestania.addTab("Buscar", jPanel1);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Tipo de Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 51, 255))); // NOI18N
        jPanel5.setName("CATEGORIA"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Código de Usuario:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Descripcion:");

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(204, 204, 204));
        txtCodigo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtDescripcion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Operacione que puede realizar el empleado en el sistema", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 51, 255))); // NOI18N
        jPanel6.setName("CATEGORIA"); // NOI18N
        jPanel6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel6MouseMoved(evt);
            }
        });
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });

        Boton_Compras.setBackground(new java.awt.Color(204, 255, 204));
        Boton_Compras.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Boton_Compras.setText("Botón_Compras");
        Boton_Compras.setOpaque(true);

        Boton_Mercadería.setBackground(new java.awt.Color(204, 255, 204));
        Boton_Mercadería.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Boton_Mercadería.setText("Botón_Mercadería");
        Boton_Mercadería.setOpaque(true);

        Boton_Ventas_Realizadas.setBackground(new java.awt.Color(204, 255, 204));
        Boton_Ventas_Realizadas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Boton_Ventas_Realizadas.setText("Botón_Ventas_Realizadas");
        Boton_Ventas_Realizadas.setOpaque(true);

        Boton_Producto.setBackground(new java.awt.Color(204, 255, 204));
        Boton_Producto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Boton_Producto.setText("Botón_Producto");
        Boton_Producto.setOpaque(true);

        Boton_Proveedores.setBackground(new java.awt.Color(204, 255, 204));
        Boton_Proveedores.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Boton_Proveedores.setText("Botón_Proveedores");
        Boton_Proveedores.setOpaque(true);

        Boton_Clientes.setBackground(new java.awt.Color(204, 255, 204));
        Boton_Clientes.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Boton_Clientes.setText("Botón_Clientes");
        Boton_Clientes.setOpaque(true);

        Boton_Tipo_Usuario.setBackground(new java.awt.Color(204, 255, 204));
        Boton_Tipo_Usuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Boton_Tipo_Usuario.setText("Botón_Tipo_Usuario");
        Boton_Tipo_Usuario.setOpaque(true);

        Boton_Empleados.setBackground(new java.awt.Color(204, 255, 204));
        Boton_Empleados.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Boton_Empleados.setText("Botón_Empleados");
        Boton_Empleados.setOpaque(true);

        Boton_Servicio_Tecnico.setBackground(new java.awt.Color(204, 255, 204));
        Boton_Servicio_Tecnico.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Boton_Servicio_Tecnico.setText("Botón_Servicio_Tecnico");
        Boton_Servicio_Tecnico.setOpaque(true);

        Boton_Compra_Detallada.setBackground(new java.awt.Color(204, 255, 204));
        Boton_Compra_Detallada.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Boton_Compra_Detallada.setText("Botón_Compra_Detallada");
        Boton_Compra_Detallada.setOpaque(true);

        Boton_Usuarios.setBackground(new java.awt.Color(204, 255, 204));
        Boton_Usuarios.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Boton_Usuarios.setText("Botón_Usuarios");
        Boton_Usuarios.setOpaque(true);

        Boton_Anular_Venta.setBackground(new java.awt.Color(204, 255, 204));
        Boton_Anular_Venta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Boton_Anular_Venta.setText("Botón_Anular_Venta");
        Boton_Anular_Venta.setOpaque(true);

        Boton_Restaurar_BD.setBackground(new java.awt.Color(204, 255, 204));
        Boton_Restaurar_BD.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Boton_Restaurar_BD.setText("Botón_Restaurar_BD");
        Boton_Restaurar_BD.setOpaque(true);

        Boton_Estadistica_Mensual.setBackground(new java.awt.Color(204, 255, 204));
        Boton_Estadistica_Mensual.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Boton_Estadistica_Mensual.setText("Botón_Estadistica_Mensual");
        Boton_Estadistica_Mensual.setOpaque(true);

        Boton_Anular_Compra.setBackground(new java.awt.Color(204, 255, 204));
        Boton_Anular_Compra.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Boton_Anular_Compra.setText("Botón_Anular_Compra");
        Boton_Anular_Compra.setOpaque(true);

        Boton_Compra_Realizada.setBackground(new java.awt.Color(204, 255, 204));
        Boton_Compra_Realizada.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Boton_Compra_Realizada.setText("Botón_Compra_Realizada");
        Boton_Compra_Realizada.setOpaque(true);

        Boton_Cambiar_Contrasena.setBackground(new java.awt.Color(204, 255, 204));
        Boton_Cambiar_Contrasena.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Boton_Cambiar_Contrasena.setText("Botón_Cambiar_Contraseña");
        Boton_Cambiar_Contrasena.setOpaque(true);

        Boton_Verificar_Producto.setBackground(new java.awt.Color(204, 255, 204));
        Boton_Verificar_Producto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Boton_Verificar_Producto.setText("Botón_Verificar_Producto");
        Boton_Verificar_Producto.setOpaque(true);

        Boton_Venta_Detallada.setBackground(new java.awt.Color(204, 255, 204));
        Boton_Venta_Detallada.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Boton_Venta_Detallada.setText("Botón_Venta_Detallada");
        Boton_Venta_Detallada.setOpaque(true);

        Boton_Respalda_BD.setBackground(new java.awt.Color(204, 255, 204));
        Boton_Respalda_BD.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Boton_Respalda_BD.setText("Botón_Respalda_BD");
        Boton_Respalda_BD.setOpaque(true);

        jLabel1.setText("HERRAMIENTAS:");

        jLabel2.setText("ALMACEN:");

        jLabel7.setText("COMPRAS:");

        jLabel8.setText("VENTAS:");

        jLabel9.setText("CONSUTA:");

        jLabel10.setText("MANTENIMIENTO:");

        jLabel11.setText("SERVICIO TÉCNICO:");

        jLabel12.setText("ANULACIONES:");

        Boton_Venta.setBackground(new java.awt.Color(204, 255, 204));
        Boton_Venta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Boton_Venta.setText("Botón_Venta");
        Boton_Venta.setOpaque(true);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(Boton_Producto)
                            .addComponent(jLabel7)
                            .addComponent(Boton_Mercadería)
                            .addComponent(Boton_Compras)
                            .addComponent(Boton_Proveedores)
                            .addComponent(jLabel8)
                            .addComponent(Boton_Venta)
                            .addComponent(Boton_Clientes))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Boton_Tipo_Usuario)
                            .addComponent(Boton_Empleados)
                            .addComponent(jLabel10)
                            .addComponent(Boton_Compra_Detallada, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton_Estadistica_Mensual)
                            .addComponent(Boton_Venta_Detallada)
                            .addComponent(Boton_Ventas_Realizadas)
                            .addComponent(jLabel9)
                            .addComponent(Boton_Compra_Realizada)))
                    .addComponent(Boton_Verificar_Producto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(Boton_Servicio_Tecnico)
                    .addComponent(Boton_Anular_Venta)
                    .addComponent(jLabel12)
                    .addComponent(Boton_Anular_Compra)
                    .addComponent(jLabel1)
                    .addComponent(Boton_Cambiar_Contrasena)
                    .addComponent(Boton_Usuarios)
                    .addComponent(Boton_Respalda_BD)
                    .addComponent(Boton_Restaurar_BD))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Boton_Ventas_Realizadas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Boton_Venta_Detallada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Boton_Estadistica_Mensual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Boton_Compra_Realizada)
                        .addGap(7, 7, 7)
                        .addComponent(Boton_Compra_Detallada)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Boton_Empleados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Boton_Tipo_Usuario))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Boton_Servicio_Tecnico)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Boton_Anular_Venta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Boton_Anular_Compra)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Boton_Cambiar_Contrasena)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Boton_Usuarios))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Boton_Producto)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Boton_Compras))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Boton_Mercadería)))
                                .addGap(6, 6, 6)
                                .addComponent(Boton_Proveedores)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Boton_Venta)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(Boton_Respalda_BD)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Boton_Restaurar_BD))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Boton_Clientes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Boton_Verificar_Producto)))))
                .addGap(77, 77, 77))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelConPestania.addTab("Nuevo / Editar", jPanel2);

        bt_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo_categoria.png"))); // NOI18N
        bt_nuevo.setText("Nuevo");
        bt_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_nuevoActionPerformed(evt);
            }
        });

        bt_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/modifi_categoria.png"))); // NOI18N
        bt_modificar.setText("Modificar");
        bt_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_modificarActionPerformed(evt);
            }
        });

        bt_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guard_categoria.png"))); // NOI18N
        bt_guardar.setText("Guardar");
        bt_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_guardarActionPerformed(evt);
            }
        });

        bt_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar_categoria.png"))); // NOI18N
        bt_salir.setText("Salir");
        bt_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salirActionPerformed(evt);
            }
        });

        mensaje.setText("Mensaje (Se cargaron los registros) ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(mensaje)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(PanelConPestania, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_nuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_modificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_guardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_salir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelConPestania)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(bt_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(mensaje)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salirActionPerformed
        vf = null;
        this.dispose();
    }//GEN-LAST:event_bt_salirActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        vf = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void bt_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_guardarActionPerformed
        // TODO add your handling code here:
        int id=0;
        if(!txtCodigo.getText().equals(""))
        {
            id=Integer.parseInt(txtCodigo.getText());
        }
            String descripcion=txtDescripcion.getText();        
            boolean TIP_USU_PRODUCTO=Boton_Producto.isSelected();
            boolean TIP_USU_MERCADERIA=Boton_Mercadería.isSelected();
            boolean TIP_USU_COMPRAS=Boton_Compras.isSelected();
            boolean TIP_USU_PROVEEDORES=Boton_Proveedores.isSelected();
            boolean TIP_USU_VENTA=Boton_Venta.isSelected();            
            boolean TIP_USU_CLIENTES=Boton_Clientes.isSelected();
            boolean TIP_USU_VENTAS_REALIZADAS=Boton_Ventas_Realizadas.isSelected();
            boolean TIP_USU_VENTAS_DETALLADAS=Boton_Venta_Detallada.isSelected();
            boolean TIP_USU_ESTADISTICA_MENSUAL=Boton_Estadistica_Mensual.isSelected();
            boolean TIP_USU_COMPRAS_REALIZADAS=Boton_Compra_Realizada.isSelected();
            boolean TIP_USU_COMPRAS_DETALLADAS=Boton_Compra_Detallada.isSelected();
            boolean TIP_USU_EMPLEADOS=Boton_Empleados.isSelected();
            boolean TIP_USU_TIPO_DE_USUARIO=Boton_Tipo_Usuario.isSelected();
            boolean TIP_USU_SERVICIO_TECNICO=Boton_Servicio_Tecnico.isSelected();
            boolean TIP_USU_ANULAR_VENTA=Boton_Anular_Venta.isSelected();
            boolean TIP_USU_ANULAR_COMPRA=Boton_Anular_Compra.isSelected();
            boolean TIP_USU_CAMBIAR_CONTRASEÑA=Boton_Cambiar_Contrasena.isSelected();
            boolean TIP_USU_USUARIOS=Boton_Usuarios.isSelected();
            boolean TIP_USU_RESPALDAR_BD=Boton_Respalda_BD.isSelected();
            boolean TIP_USU_RESTAURAR_BD=Boton_Restaurar_BD.isSelected();
            
            boolean TIP_USU_VERIFICAR_PRODUCTO=Boton_Verificar_Producto.isSelected();
            
            tipoUsuario=new TipoUsuario(id, descripcion, TIP_USU_PRODUCTO, TIP_USU_MERCADERIA, TIP_USU_COMPRAS, TIP_USU_PROVEEDORES, 
                    TIP_USU_VENTA,TIP_USU_CLIENTES, TIP_USU_VERIFICAR_PRODUCTO, TIP_USU_VENTAS_REALIZADAS, TIP_USU_VENTAS_DETALLADAS, TIP_USU_ESTADISTICA_MENSUAL, TIP_USU_COMPRAS_REALIZADAS, 
                    TIP_USU_COMPRAS_DETALLADAS, TIP_USU_EMPLEADOS, TIP_USU_TIPO_DE_USUARIO, TIP_USU_SERVICIO_TECNICO, TIP_USU_ANULAR_VENTA, TIP_USU_ANULAR_COMPRA, 
                    TIP_USU_CAMBIAR_CONTRASEÑA, TIP_USU_USUARIOS, TIP_USU_RESPALDAR_BD, TIP_USU_RESTAURAR_BD);
            controladorTipoUsuario controladorTipUsuario=new controladorTipoUsuario();
            
        if(txtCodigo.getText().equals(""))
        {
            if(txtDescripcion.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Se requiere una Descripción");
                txtDescripcion.requestFocus();
            }
            else
            {
                if(controladorTipUsuario.registrar(tipoUsuario))
                {
                    PanelConPestania.setSelectedIndex(0);
//                    tabla.setModel(controladorTipoUsuario.getAllTiposUsuarios());
                    controladorTipoUsuario.getAll(tabla);
                    limpiarEntradas();
                    mensaje.setText("Se cargaron "+tabla.getRowCount()+" registros");
                }
            }
        }
        if(!txtCodigo.getText().equals(""))
        {
            controladorTipUsuario.modificar(tipoUsuario);
            PanelConPestania.setSelectedIndex(0);
//            tabla.setModel(controladorTipoUsuario.getAllTiposUsuarios());
            controladorTipoUsuario.getAll(tabla);
            mensaje.setText("Se cargaron "+tabla.getRowCount()+" registros");
            limpiarEntradas();
        }
       
//        controladorTipoUsuario.anchoTablas(tabla);
    }//GEN-LAST:event_bt_guardarActionPerformed

    private void bt_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_nuevoActionPerformed
        limpiarEntradas();
        PanelConPestania.setSelectedIndex(1);
    }//GEN-LAST:event_bt_nuevoActionPerformed

    private void PanelConPestaniaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_PanelConPestaniaStateChanged
        // TODO add your handling code here:
        bloquearBotones();
    }//GEN-LAST:event_PanelConPestaniaStateChanged

    private void bt_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_modificarActionPerformed
        // TODO add your handling code here:
        int fila=tabla.getSelectedRow();
        txtCodigo.setText(String.valueOf(tabla.getValueAt(fila, 0)));
        txtDescripcion.setText((String) tabla.getValueAt(fila, 1));
        Boton_Producto.setSelected(((int) tabla.getValueAt(fila, 2) != 0));
        Boton_Mercadería.setSelected(((int) tabla.getValueAt(fila, 3) != 0));
        Boton_Compras.setSelected(((int) tabla.getValueAt(fila, 4) != 0));
        Boton_Proveedores.setSelected(((int) tabla.getValueAt(fila, 5) != 0));
        Boton_Venta.setSelected(((int) tabla.getValueAt(fila, 6) != 0));
        Boton_Clientes.setSelected(((int) tabla.getValueAt(fila, 7) != 0));
        Boton_Verificar_Producto.setSelected(((int) tabla.getValueAt(fila, 8) != 0));
        Boton_Ventas_Realizadas.setSelected(((int) tabla.getValueAt(fila, 9) != 0));
        Boton_Venta_Detallada.setSelected(((int) tabla.getValueAt(fila, 10) != 0));
        Boton_Estadistica_Mensual.setSelected(((int) tabla.getValueAt(fila, 11) != 0));
        Boton_Compra_Realizada.setSelected(((int) tabla.getValueAt(fila, 12) != 0));
        Boton_Compra_Detallada.setSelected(((int) tabla.getValueAt(fila, 13) != 0));
        Boton_Empleados.setSelected(((int) tabla.getValueAt(fila, 14) != 0));
        Boton_Tipo_Usuario.setSelected(((int) tabla.getValueAt(fila, 15) != 0));
        Boton_Servicio_Tecnico.setSelected(((int) tabla.getValueAt(fila, 16) != 0));
        Boton_Anular_Venta.setSelected(((int) tabla.getValueAt(fila, 17) != 0));
        Boton_Anular_Compra.setSelected(((int) tabla.getValueAt(fila, 18) != 0));
        Boton_Cambiar_Contrasena.setSelected(((int) tabla.getValueAt(fila, 19) != 0));
        Boton_Usuarios.setSelected(((int) tabla.getValueAt(fila, 20) != 0));
        Boton_Respalda_BD.setSelected(((int) tabla.getValueAt(fila, 21) != 0));
        Boton_Restaurar_BD.setSelected(((int) tabla.getValueAt(fila, 22) != 0));
        
        
        
        PanelConPestania.setSelectedIndex(1);
    }//GEN-LAST:event_bt_modificarActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
      
    }//GEN-LAST:event_formMouseMoved

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked

    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel6MouseMoved

    private void tusuario_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tusuario_buscarKeyReleased
        // TODO add your handling code here:
        //        tipoUsuario=new TipoUsuario();;
        //        controladorTipoUsuario = new controladorTipoUsuario();
//        if(cod_tusuario.isSelected())
//        {
//            tusuario_table1.setModel(controladorTipoUsuario.buscarTipousuarioById(tusuario_buscar.getText()));
//
//        }
//        if(tusuario_descripcion.isSelected())
//        {
//            tusuario_table1.setModel(controladorTipoUsuario.buscarTipousuarioByDescripcion(tusuario_buscar.getText()));
//
//        }

        controladorTipoUsuario.buscarTipoUsuario(tabla, tusuario_buscar.getText());// llama al metodo que muestra la tabla
//        tabla.setModel(controladorTipoUsuario.buscarTipoUsuario(tusuario_buscar.getText()));
        mensaje.setText("Se cargaron "+tabla.getRowCount()+" registros");
        bloquearBotones();
//        controladorTipoUsuario.anchoTablas(tabla);

    }//GEN-LAST:event_tusuario_buscarKeyReleased

    private void tablaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseReleased
        // TODO add your handling code here:
        bt_modificar.setEnabled(true);
    }//GEN-LAST:event_tablaMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Boton_Anular_Compra;
    private javax.swing.JCheckBox Boton_Anular_Venta;
    private javax.swing.JCheckBox Boton_Cambiar_Contrasena;
    private javax.swing.JCheckBox Boton_Clientes;
    private javax.swing.JCheckBox Boton_Compra_Detallada;
    private javax.swing.JCheckBox Boton_Compra_Realizada;
    private javax.swing.JCheckBox Boton_Compras;
    private javax.swing.JCheckBox Boton_Empleados;
    private javax.swing.JCheckBox Boton_Estadistica_Mensual;
    private javax.swing.JCheckBox Boton_Mercadería;
    private javax.swing.JCheckBox Boton_Producto;
    private javax.swing.JCheckBox Boton_Proveedores;
    private javax.swing.JCheckBox Boton_Respalda_BD;
    private javax.swing.JCheckBox Boton_Restaurar_BD;
    private javax.swing.JCheckBox Boton_Servicio_Tecnico;
    private javax.swing.JCheckBox Boton_Tipo_Usuario;
    private javax.swing.JCheckBox Boton_Usuarios;
    private javax.swing.JCheckBox Boton_Venta;
    private javax.swing.JCheckBox Boton_Venta_Detallada;
    private javax.swing.JCheckBox Boton_Ventas_Realizadas;
    private javax.swing.JCheckBox Boton_Verificar_Producto;
    private javax.swing.JTabbedPane PanelConPestania;
    private javax.swing.JButton bt_guardar;
    private javax.swing.JButton bt_modificar;
    private javax.swing.JButton bt_nuevo;
    private javax.swing.JButton bt_salir;
    private javax.swing.ButtonGroup busq_usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mensaje;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField tusuario_buscar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    // End of variables declaration//GEN-END:variables

    private void limpiarEntradas() {
        txtCodigo.setText("");
        txtDescripcion.setText("");        
        Boton_Producto.setSelected(false);
        Boton_Mercadería.setSelected(false);
        Boton_Compras.setSelected(false);
        Boton_Proveedores.setSelected(false);
        Boton_Clientes.setSelected(false);
        Boton_Ventas_Realizadas.setSelected(false);
        Boton_Venta_Detallada.setSelected(false);
        Boton_Estadistica_Mensual.setSelected(false);
        Boton_Compra_Detallada.setSelected(false);
        Boton_Compra_Detallada.setSelected(false);
        Boton_Empleados.setSelected(false);
        Boton_Tipo_Usuario.setSelected(false);
        Boton_Servicio_Tecnico.setSelected(false);
        Boton_Anular_Venta.setSelected(false);
        Boton_Anular_Compra.setSelected(false);
        Boton_Cambiar_Contrasena.setSelected(false);
        Boton_Usuarios.setSelected(false);
        Boton_Respalda_BD.setSelected(false);
        Boton_Restaurar_BD.setSelected(false);
        Boton_Compra_Realizada.setSelected(false);
        Boton_Verificar_Producto.setSelected(false);  
        Boton_Venta.setSelected(false);  
    }

    private void bloquearBotones() {
        
        if(PanelConPestania.getSelectedIndex()==0)
        {
            bt_guardar.setEnabled(false);
            bt_nuevo.setEnabled(true);
            bt_modificar.setEnabled(false);
        }
        if(PanelConPestania.getSelectedIndex()==1)
        {
            bt_guardar.setEnabled(true);
            bt_nuevo.setEnabled(false);
            bt_modificar.setEnabled(false);
        }
        
    }

    @Override
    public void run() {
        Thread ch = Thread.currentThread();
        while (ch == hilo1) 
        {            
            try {
                Thread.sleep(20);
                if (!this.Boton_Ventas_Realizadas.isSelected()) {
                    this.Boton_Ventas_Realizadas.setBackground(Color.decode("#ffe1e1"));
                }
                else{
                    this.Boton_Ventas_Realizadas.setBackground(Color.decode("#d6fcca"));
                }
                if (!this.Boton_Compras.isSelected()) {
                    this.Boton_Compras.setBackground(Color.decode("#ffe1e1"));
                }
                else{
                    this.Boton_Compras.setBackground(Color.decode("#d6fcca"));
                }
                if (!this.Boton_Mercadería.isSelected()) {
                    this.Boton_Mercadería.setBackground(Color.decode("#ffe1e1"));
                }
                else{
                    this.Boton_Mercadería.setBackground(Color.decode("#d6fcca"));
                }
                if (!this.Boton_Proveedores.isSelected()) {
                    this.Boton_Proveedores.setBackground(Color.decode("#ffe1e1"));
                }
                else{
                    this.Boton_Proveedores.setBackground(Color.decode("#d6fcca"));
                }
                if (!this.Boton_Producto.isSelected()) {
                    this.Boton_Producto.setBackground(Color.decode("#ffe1e1"));
                }
                else{
                    this.Boton_Producto.setBackground(Color.decode("#d6fcca"));
                }
                if (!this.Boton_Clientes.isSelected()) {
                    this.Boton_Clientes.setBackground(Color.decode("#ffe1e1"));
                }
                else{
                    this.Boton_Clientes.setBackground(Color.decode("#d6fcca"));
                }
                if (!this.Boton_Empleados.isSelected()) {
                    this.Boton_Empleados.setBackground(Color.decode("#ffe1e1"));
                }
                else{
                    this.Boton_Empleados.setBackground(Color.decode("#d6fcca"));
                }
                if (!this.Boton_Tipo_Usuario.isSelected()) {
                    this.Boton_Tipo_Usuario.setBackground(Color.decode("#ffe1e1"));
                }
                else{
                    this.Boton_Tipo_Usuario.setBackground(Color.decode("#d6fcca"));
                }
                if (!this.Boton_Anular_Compra.isSelected()) {
                    this.Boton_Anular_Compra.setBackground(Color.decode("#ffe1e1"));
                }
                else{
                    this.Boton_Anular_Compra.setBackground(Color.decode("#d6fcca"));
                }
                if (!this.Boton_Anular_Venta.isSelected()) {
                    this.Boton_Anular_Venta.setBackground(Color.decode("#ffe1e1"));
                }
                else{
                    this.Boton_Anular_Venta.setBackground(Color.decode("#d6fcca"));
                }
                if (!this.Boton_Cambiar_Contrasena.isSelected()) {
                    this.Boton_Cambiar_Contrasena.setBackground(Color.decode("#ffe1e1"));
                }
                else{
                    this.Boton_Cambiar_Contrasena.setBackground(Color.decode("#d6fcca"));
                }
                if (!this.Boton_Verificar_Producto.isSelected()) {
                    this.Boton_Verificar_Producto.setBackground(Color.decode("#ffe1e1"));
                }
                else{
                    this.Boton_Verificar_Producto.setBackground(Color.decode("#d6fcca"));
                }
                if (!this.Boton_Venta_Detallada.isSelected()) {
                    this.Boton_Venta_Detallada.setBackground(Color.decode("#ffe1e1"));
                }
                else{
                    this.Boton_Venta_Detallada.setBackground(Color.decode("#d6fcca"));
                }
                if (!this.Boton_Estadistica_Mensual.isSelected()) {
                    this.Boton_Estadistica_Mensual.setBackground(Color.decode("#ffe1e1"));
                }
                else{
                    this.Boton_Estadistica_Mensual.setBackground(Color.decode("#d6fcca"));
                }
                if (!this.Boton_Compra_Realizada.isSelected()) {
                    this.Boton_Compra_Realizada.setBackground(Color.decode("#ffe1e1"));
                }
                else{
                    this.Boton_Compra_Realizada.setBackground(Color.decode("#d6fcca"));
                }
                if (!this.Boton_Compra_Detallada.isSelected()) {
                    this.Boton_Compra_Detallada.setBackground(Color.decode("#ffe1e1"));
                }
                else{
                    this.Boton_Compra_Detallada.setBackground(Color.decode("#d6fcca"));
                }
                if (!this.Boton_Servicio_Tecnico.isSelected()) {
                    this.Boton_Servicio_Tecnico.setBackground(Color.decode("#ffe1e1"));
                }
                else{
                    this.Boton_Servicio_Tecnico.setBackground(Color.decode("#d6fcca"));
                }
                if (!this.Boton_Usuarios.isSelected()) {
                    this.Boton_Usuarios.setBackground(Color.decode("#ffe1e1"));
                }
                else{
                    this.Boton_Usuarios.setBackground(Color.decode("#d6fcca"));
                }
                if (!this.Boton_Respalda_BD.isSelected()) {
                    this.Boton_Respalda_BD.setBackground(Color.decode("#ffe1e1"));
                }
                else{
                    this.Boton_Respalda_BD.setBackground(Color.decode("#d6fcca"));
                }
                if (!this.Boton_Restaurar_BD.isSelected()) {
                    this.Boton_Restaurar_BD.setBackground(Color.decode("#ffe1e1"));
                }
                else{
                    this.Boton_Restaurar_BD.setBackground(Color.decode("#d6fcca"));
                }
                if (!this.Boton_Venta.isSelected()) {
                    this.Boton_Venta.setBackground(Color.decode("#ffe1e1"));
                }
                else{
                    this.Boton_Venta.setBackground(Color.decode("#d6fcca"));
                }
            } catch (Exception e) 
            {
            }
        }
    }
    

}
