package Presentacion;

//import clases.Cliente;
import clases.FacturaCabesera;
import clases.FacturaDetalle;
import clases.Persona;
import clases.Usuario;
import clases.validaciones;
import controlador.controladorFactura;
import controlador.controladorUsuario;
import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class F_Ventas extends javax.swing.JInternalFrame {
    String fecha;
    public static String vf;
    FacturaCabesera cabesera;
    FacturaDetalle detalle=new FacturaDetalle();
    consultaProductos ventD;
    controladorFactura ctrFactura=new controladorFactura();
    Persona cliente=new Persona();
    Calendar c2;
    double pc;
    public Usuario usuario=new Usuario();
    validaciones validar=new validaciones();
    double descuento=0;
    controladorUsuario controladorUsuario=new controladorUsuario();

    public F_Ventas(Usuario usu) {
        this.usuario=usu;
        initComponents();
        vf = ("vf");
        
        
        
        
        
        
        //otra forma de estraer fecha
//        Date fecha = new Date();
//        dia = Integer.toString(fecha.getDay());
//        mes = String.valueOf(fecha.getMonth());
//        annio = String.valueOf(fecha.getYear());

        c2 = new GregorianCalendar();        
        fecha=Integer.toString(c2.get(Calendar.DATE))+"/"+Integer.toString(c2.get(Calendar.MONTH)+1)+"/"+Integer.toString(c2.get(Calendar.YEAR));
        
        limpiarCliente();
        limpiarDetalle();
        controladorUsuario.getAllUsuarios(jComboBox3); 
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        comp_numcompra = new javax.swing.JTextField();
        comp_cambiar = new javax.swing.JCheckBox();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        comp_buscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        comp_nuevo1 = new javax.swing.JButton();
        comp_nuevo = new javax.swing.JButton();
        comp_salir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        comp_buscar2 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        comp_cantidad = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        comp_borrarfila = new javax.swing.JButton();
        comp_agregar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        jDesktopPane1.setLayout(null);

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setTitle("REGISTRO DE VENTAS");
        setToolTipText("");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
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
        });

        jPanel1.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Bebas Neue", 1, 36)); // NOI18N
        jLabel3.setText("Comprobante");

        comp_numcompra.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        comp_numcompra.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        comp_numcompra.setEnabled(false);

        comp_cambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comp_cambiarActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FACTURA", "NOTA DE VENTA" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setText("Vendedor:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(comp_numcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comp_cambiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comp_numcompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comp_cambiar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Cliente"));

        comp_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N
        comp_buscar.setToolTipText("");
        comp_buscar.setBorder(null);
        comp_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comp_buscarActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel1");

        jLabel4.setText("jLabel1");

        jLabel5.setText("jLabel1");

        jLabel9.setText("jLabel1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comp_buscar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comp_buscar)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        comp_nuevo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo_categoria.png"))); // NOI18N
        comp_nuevo1.setText("Nuevo");
        comp_nuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comp_nuevo1ActionPerformed(evt);
            }
        });

        comp_nuevo.setText("Generar venta");
        comp_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comp_nuevoActionPerformed(evt);
            }
        });

        comp_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar_categoria.png"))); // NOI18N
        comp_salir.setText("Salir");
        comp_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comp_salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comp_nuevo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comp_nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comp_salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comp_nuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comp_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comp_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del producto"));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setText(" Stock:");

        jLabel25.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel25.setText("Codigo:");

        jLabel26.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel26.setText("Precio:");

        jLabel27.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel27.setText("Nombre:");

        comp_buscar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N
        comp_buscar2.setToolTipText("");
        comp_buscar2.setBorder(null);
        comp_buscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comp_buscar2ActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel30.setText("Cantidad:");

        comp_cantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        comp_cantidad.setText("1");
        comp_cantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                comp_cantidadFocusLost(evt);
            }
        });
        comp_cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                comp_cantidadKeyTyped(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel31.setText("Total:");

        comp_borrarfila.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/anul_compras.png"))); // NOI18N
        comp_borrarfila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comp_borrarfilaActionPerformed(evt);
            }
        });

        comp_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/comp_compra.png"))); // NOI18N
        comp_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comp_agregarActionPerformed(evt);
            }
        });

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel6");

        jLabel8.setText("jLabel6");

        jLabel10.setText("jLabel6");

        jLabel11.setText("jLabel6");

        jLabel17.setText("Descuento");

        jTextField1.setText("0");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comp_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comp_buscar2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(comp_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comp_borrarfila, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel18)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addComponent(comp_buscar2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comp_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comp_borrarfila, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30)
                        .addComponent(comp_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel26)
                        .addComponent(jLabel8)
                        .addComponent(jLabel17)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel31)
                        .addComponent(jLabel10))))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos"));

        tabla.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        tabla.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Producto", "Descripcion", "Cantidad", "Precio", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel28.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel28.setText("Forma de Pago:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Dinero Electrónico", "Tarjeta de Crédito/Débito", "Otros" }));

        jLabel23.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel23.setText("Efectivo:");

        jTextField15.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField15FocusLost(evt);
            }
        });
        jTextField15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField15KeyTyped(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel24.setText("Cambio");

        jTextField13.setEditable(false);

        jLabel19.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel19.setText("<html> <style type = \"text/css\"> .subTotal { font-family : Bebas Neue;   font-size : 19px;   color : #009045;   color : rgb(0, 144, 69); } </style> <body>  <span class=subTotal>Descuento</span>  </body> </html>");

        jLabel20.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel20.setText("<html>\n<style type = \"text/css\">\n.subTotal\n{\nfont-family : Bebas Neue;\n  font-size : 19px;\n  color : #009045;\n  color : rgb(0, 144, 69);\n}\n</style>\n<body>\n\n<span class=subTotal>IVA</span>\n\n</body>\n</html>");

        jLabel22.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel22.setText("<html>\n<style type = \"text/css\">\n.subTotal\n{\nfont-family : Bebas Neue;\n  font-size : 19px;\n  color : #009045;\n  color : rgb(0, 144, 69);\n}\n</style>\n<body>\n\n<span class=subTotal>Total</span>\n\n</body>\n</html>");

        jLabel21.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel21.setText("<html> <style type = \"text/css\"> .subTotal { font-family : Bebas Neue;   font-size : 19px;   color : #009045;   color : rgb(0, 144, 69); } </style> <body>  <span class=subTotal>Sub Total</span>  </body> </html>");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel23)
                    .addComponent(jLabel28))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comp_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comp_salirActionPerformed
        vf=null;
        this.dispose();
    }//GEN-LAST:event_comp_salirActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        vf = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void comp_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comp_buscarActionPerformed

        consultaCliente ventD = new consultaCliente(null,true);
        ventD.setVisible(true);
        cliente=ventD.cliente;
        
        jLabel1.setText("Nombre: "+cliente.getPER_NOMBRE());
        jLabel9.setText("R.U.C./C.I.: "+cliente.getPER_CEDULA());
        jLabel2.setText("Telf.: "+cliente.getPER_TELEFONO());
        jLabel4.setText("Dirección: "+cliente.getPER_DIRECCION());
        jLabel5.setText("Correo: "+cliente.getPER_CORREO());
        
        if(cliente.getPER_NOMBRE()==null)
        {
            limpiarCliente();
        }        
        
    }//GEN-LAST:event_comp_buscarActionPerformed

    private void comp_cambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comp_cambiarActionPerformed
        // TODO add your handling code here:
        if(comp_cambiar.isSelected())
        {
            comp_numcompra.enable(true);
        }
        else
        {
            comp_numcompra.enable(false);
            comp_numcompra.setText("");
        }
    }//GEN-LAST:event_comp_cambiarActionPerformed

    private void jTextField15FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField15FocusLost
        // TODO add your handling code here:
        double vuelto=0;
        BigDecimal redondeado;
        switch(jComboBox2.getSelectedIndex())
        {
            case 0:
                vuelto =Double.parseDouble(jTextField15.getText())-(ctrFactura.datos.total);
                redondeado = new BigDecimal(vuelto)
                                .setScale(2, RoundingMode.HALF_EVEN);
                jTextField13.setText(Double.toString(redondeado.doubleValue()));
                break;
            case 1:
                vuelto =Double.parseDouble(jTextField15.getText())-(ctrFactura.datos.subtotal);
                redondeado = new BigDecimal(vuelto)
                                .setScale(2, RoundingMode.HALF_EVEN);
                jTextField13.setText(Double.toString(redondeado.doubleValue()));
                break;
        }
        
        
         
    }//GEN-LAST:event_jTextField15FocusLost

    private void comp_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comp_nuevoActionPerformed
        // TODO add your handling code here:
        //verifica que tipo de compronante es
        if(comp_cambiar.isSelected())
            {
                if(Integer.parseInt(comp_numcompra.getText())<=0)
                {
                    JOptionPane.showMessageDialog(this, "Numero de factura no valido");
                }
                else
                {
                    if(!jLabel9.getText().equals(""))
                    {
                        generarFactura(Integer.parseInt(comp_numcompra.getText()));
                    }
                    else
                    {JOptionPane.showMessageDialog(this, "Debe Cargar un Cliente");}
                                        
                }
                
            }
            else
            {
                String mensaje="";
                switch (jComboBox2.getSelectedIndex())
                {
                    case 0:
                        mensaje ="Preparar factura # "+validar.convierteNumeroFactura(ctrFactura.prepararFacturaNumero());
                        break;
                    case 1: 
                        mensaje ="Nota de venta # "+validar.convierteNumeroFactura(ctrFactura.prepararNotaVenta());
                        break;
                }
                
        
                String[] options = {"Continuar", "Cancelar"};
                if(JOptionPane.showOptionDialog(null, mensaje, "Titulo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0])==0)
                {
                    if(!jLabel9.getText().equals(""))
                    {
                        generarFactura(0);   
                    }
                    else
                    {JOptionPane.showMessageDialog(this, "Debe Cargar un Cliente");}
                                     
                }
                
            }
        
        
            
        
        
        
        
    }//GEN-LAST:event_comp_nuevoActionPerformed

    private void comp_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comp_agregarActionPerformed
        // TODO add your handling code here:
        
        try{
            
        jLabel10.setText(String.valueOf((Integer.parseInt(comp_cantidad.getText())*ventD.producto.getPRO_PRECIO_VENTA())-validaDescuento()));
        }
        catch (NullPointerException ex)
        {
        }
        int PRO_ID = 0;
        int cantidad = 0;
        double valorUnitario = 0;
        descuento=0;
        double valorTotal = 0;
        try
        {
            
            PRO_ID = ventD.producto.getPRO_ID();
            cantidad=Integer.parseInt(comp_cantidad.getText());
            valorUnitario=Double.parseDouble(jLabel8.getText());
            descuento=validaDescuento();
            valorTotal=Double.parseDouble(jLabel10.getText());
            detalle=new FacturaDetalle(1, PRO_ID, cantidad, valorUnitario,descuento, valorTotal,pc);
            try 
            {

                if(validarAgregarItem(PRO_ID))
                {
                    ctrFactura.Agregar(detalle);
                }
            } 
            catch (Exception ex) 
            {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Se debe cargar un producto");
        }
        
        
        
        limpiarTabla();
        
    }//GEN-LAST:event_comp_agregarActionPerformed

    private void comp_borrarfilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comp_borrarfilaActionPerformed
        // TODO add your handling code here:
        try{
        int fila=tabla.getSelectedRow();
        ctrFactura.Eliminar(fila);
        ctrFactura.getAll(tabla);
        //        comp_sbtotal.setText(String.valueOf(ctrFactura.datos.subtotal));
        //        comp_iva.setText(String.valueOf(ctrFactura.datos.iva));
        //        comp_totalpagar.setText(String.valueOf(ctrFactura.datos.total));

        String html[]={"<html> <style type = \"text/css\"> .subTotal { font-family : Bebas Neue;   font-size : 19px;   color : #0000FF;  color : rgb(0, 0, 255); } </style> <body>  <span class=subTotal>","</span>  </body> </html>"};
        jLabel19.setText(html[0]+"SUBTOTAL $ "+ String.valueOf(ctrFactura.datos.subtotal)+html[1]);
        jLabel20.setText(html[0]+"IVA $ "+ String.valueOf(ctrFactura.datos.iva)+html[1]);
        jLabel22.setText(html[0]+"TOTAL $ "+ String.valueOf(ctrFactura.datos.total));
        int x=0;
        }
        catch(ArrayIndexOutOfBoundsException ex)
        {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un item");
        }
    }//GEN-LAST:event_comp_borrarfilaActionPerformed

    private void comp_cantidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comp_cantidadFocusLost
        // TODO add your handling code here:

//        double to=Integer.parseInt(comp_cantidad.getText())*Double.parseDouble(jLabel8.getText());
//        jLabel10.setText(String.valueOf(to));
try{
        if(Integer.parseInt(comp_cantidad.getText())>Integer.parseInt(jLabel7.getText()))
        {
            JOptionPane.showMessageDialog(this, "No hay suficiente Stock");
        }
        else
        {
            jLabel10.setText(String.valueOf(Integer.parseInt(comp_cantidad.getText())*(ventD.producto.getPRO_PRECIO_VENTA()-validaDescuento())));
        }
        }
catch (NumberFormatException ex)
{
}
        
    }//GEN-LAST:event_comp_cantidadFocusLost

    private void comp_buscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comp_buscar2ActionPerformed
        // TODO add your handling code here:
        ventD = new consultaProductos(null,true);
        ventD.setVisible(true);

        jLabel11.setText(String.valueOf(ventD.producto.getPRO_ID()));
        jLabel6.setText(ventD.producto.getPRO_NOMBRE());
        jLabel8.setText(String.valueOf(ventD.producto.getPRO_PRECIO_VENTA()));
        jLabel7.setText(String.valueOf(ventD.producto.getPRO_STOCK()));
        pc=ventD.producto.getPRO_PRECIO_COSTO();        
        jLabel10.setText(String.valueOf(Integer.parseInt(comp_cantidad.getText())*ventD.producto.getPRO_PRECIO_VENTA()));

    }//GEN-LAST:event_comp_buscar2ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        limpiarTodo();
        switch(jComboBox2.getSelectedIndex())
        {
            case 0:
                ventanaFactura();
                break;
            case 1:
                ventanaNotaVenta();
                break;
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        
        
        try
        {
        double ganancia=(ventD.producto.getPRO_PRECIO_VENTA()-ventD.producto.getPRO_PRECIO_COSTO())*Integer.parseInt(comp_cantidad.getText());
        System.out.println("ganancia "+ganancia);
        double subtotal=ventD.producto.getPRO_PRECIO_VENTA();
        if(validaDescuento()>=ganancia)
        {
            JOptionPane.showMessageDialog(this, "Monto de descuento supera el precio de costo");
        }
        }
        catch (NullPointerException ex)
        {
        }
        
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        // TODO add your handling code here:
        try{
        jLabel10.setText(String.valueOf((Integer.parseInt(comp_cantidad.getText())*ventD.producto.getPRO_PRECIO_VENTA())-validaDescuento()));
        }
        catch (NullPointerException ex)
        {
        }

           
    }//GEN-LAST:event_jTextField1FocusLost

    private void comp_cantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comp_cantidadKeyTyped
        // TODO add your handling code here:
        validar.enteros(evt);
    }//GEN-LAST:event_comp_cantidadKeyTyped

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        validar.decimales(evt,jTextField1.getText());
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField15KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField15KeyTyped
        // TODO add your handling code here:
        validar.decimales(evt,jTextField15.getText());
    }//GEN-LAST:event_jTextField15KeyTyped

    private void comp_nuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comp_nuevo1ActionPerformed
        // TODO add your handling code here:
        limpiarTodo();
        switch(jComboBox2.getSelectedIndex())
        {
            case 0:
                ventanaFactura();
                break;
            case 1:
                ventanaNotaVenta();
                break;
        }
    }//GEN-LAST:event_comp_nuevo1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton comp_agregar;
    private javax.swing.JButton comp_borrarfila;
    private javax.swing.JButton comp_buscar;
    private javax.swing.JButton comp_buscar2;
    private javax.swing.JCheckBox comp_cambiar;
    private javax.swing.JTextField comp_cantidad;
    private javax.swing.JButton comp_nuevo;
    private javax.swing.JButton comp_nuevo1;
    private javax.swing.JTextField comp_numcompra;
    private javax.swing.JButton comp_salir;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables

    

    private void generarFactura(int NumeroDeCompra) 
    {
        String fechaIngreso=Integer.toString(c2.get(Calendar.YEAR))+"-"+Integer.toString(c2.get(Calendar.MONTH)+1)+"-"+Integer.toString(c2.get(Calendar.DATE));

            comp_cambiar.getSelectedIcon();

            

            cabesera=new FacturaCabesera(
                    NumeroDeCompra,
                    fechaIngreso,
                    ctrFactura.datos.subtotal,
                    ctrFactura.datos.descuento,
                    ctrFactura.datos.iva,
                    ctrFactura.datos.total,
                    jComboBox1.getSelectedIndex(),                
                    cliente.getPER_ID(), 
                    controladorUsuario.getIdUsuario((String) jComboBox3.getSelectedItem()),
                    true);
            boolean registro=ctrFactura.registrar(cabesera,jComboBox2.getSelectedIndex());
            switch(jComboBox2.getSelectedIndex())
        {
            case 0:
                if(!registro)
            {
                JOptionPane.showMessageDialog(this,"Numero de Factura ya existe");
            }
                else
                {
                generaFactura();
                }
                break;
            case 1:
                if(!registro)
            {
                JOptionPane.showMessageDialog(this,"Numero de Nota de Venta ya existe");
            }
                else
                {
                generaNotaVenta();
                }
                
                break;
        }

            
    }

    private void ventanaFactura() {
        
        jLabel20.setVisible(true);
        jLabel21.setVisible(true);
    }

    private void ventanaNotaVenta() {
        
        
        jLabel20.setVisible(false);
        jLabel21.setVisible(false);
    }
    
    

    private boolean validarAgregarItem(int PRO_ID) throws Exception
    {     
        String a=jLabel6.getText();
        if(a==null)
        {
            throw new Exception("Se debe cargar un producto");
        } 
        if(!ctrFactura.Buscar(PRO_ID))
        {
            throw new Exception("Producto subido en factura detalle");
        }
        if(Integer.parseInt(comp_cantidad.getText())>Integer.parseInt(jLabel7.getText()))
        {
            throw new Exception("Cantidad mayor que existencias en stock");
        }
        if(Integer.parseInt(comp_cantidad.getText())==0)
        {
            throw new Exception("Debe agregar una cantidad mayor que 0");
        }
        return true;
    }

    private void limpiarCliente() {
        jLabel1.setText("");
        jLabel9.setText("");
        jLabel2.setText("");
        jLabel4.setText("");
        jLabel5.setText("");
    }

    private void limpiarDetalle() {
        
        jLabel11.setText("");
        jLabel6.setText("");
        jLabel7.setText("");
        jLabel8.setText("");
        jLabel10.setText("");
        jTextField1.setText("0");
    }

    private void limpiarTabla() {
        ctrFactura.getAll(tabla);
        //        comp_sbtotal.setText(String.valueOf(ctrFactura.datos.subtotal));
        //        comp_iva.setText(String.valueOf(ctrFactura.datos.iva));
        //        comp_totalpagar.setText(String.valueOf(ctrFactura.datos.total));

        String html[]={"<html> <style type = \"text/css\"> .subTotal { font-family : Bebas Neue;   font-size : 19px;   color : #0000FF;  color : rgb(0, 0, 255); } </style> <body>  <span class=subTotal>","</span>  </body> </html>"};
        switch (jComboBox2.getSelectedIndex())
        {
            case 0:
                
               
                    jLabel21.setText(html[0]+"SUBTOTAL $ "+ String.valueOf(ctrFactura.datos.subtotal)+html[1]);
                    jLabel19.setText(html[0]+"DESCUENTO $ "+String.valueOf(ctrFactura.datos.descuento)+html[1]);
                    jLabel20.setText(html[0]+"IVA $ "+ String.valueOf(ctrFactura.datos.iva)+html[1]);
                    jLabel22.setText(html[0]+"TOTAL $ "+ String.valueOf(ctrFactura.datos.total));
               
                
                break;
            case 1:
                jLabel19.setText(html[0]+"DESCUENTO $ "+ String.valueOf(ctrFactura.datos.descuento)+html[1]);                
                jLabel22.setText(html[0]+"TOTAL $ "+ String.valueOf(ctrFactura.datos.total));
                break;
        }
    }

    private void limpiarTodo() {
        cabesera =new FacturaCabesera ();
     detalle=new FacturaDetalle();
    ventD =new consultaProductos(null,true);
    ctrFactura=new controladorFactura();
//    cliente=new Cliente();
    
        limpiarCliente();
        limpiarDetalle();
        ctrFactura.EliminarTodo();
        limpiarTabla();
    }
    
    private double validaDescuento()
    {
        try
        {
            descuento=Double.parseDouble(jTextField1.getText());
        }
        catch (NumberFormatException ex)
        {
            descuento=0;
        }
        return descuento;
    }

    private void generaFactura() {
        
        try {    

                Connection  con =Conexion.Conexion.conectar();

                JasperReport reporte=null;
                String path="src/Reportes/facturaA5.jasper";

                Map parametros=new HashMap();
                parametros.put("numeroFactura",cabesera.getFAC_CAB_ID());
                parametros.put("numeroDeFactrua",validar.convierteNumeroFactura(cabesera.getFAC_CAB_ID()));

                reporte=(JasperReport) JRLoader.loadObjectFromFile(path);

                JasperPrint jprint=JasperFillManager.fillReport(reporte,parametros,con);

                JasperViewer view = new JasperViewer(jprint,false);
                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                view.setVisible(true);

                limpiarTodo();

            } catch (JRException ex) {
                Logger.getLogger(F_Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    private void generaNotaVenta() {
        try {    

           
            
                Connection  con =Conexion.Conexion.conectar();

                JasperReport reporte=null;
                String path="src/Reportes/NotaA5.jasper";

                Map parametros=new HashMap();
                parametros.put("numeroFactura",cabesera.getFAC_CAB_ID());
                parametros.put("numeroDeFactrua",validar.convierteNumeroFactura(cabesera.getFAC_CAB_ID()));

                reporte=(JasperReport) JRLoader.loadObjectFromFile(path);

                JasperPrint jprint=JasperFillManager.fillReport(reporte,parametros,con);

                JasperViewer view = new JasperViewer(jprint,false);
                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                view.setVisible(true);

                limpiarTodo();

            } catch (JRException ex) {
                Logger.getLogger(F_Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    
    
}
