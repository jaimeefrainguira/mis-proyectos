package Presentacion;

//import clases.Cliente;
import clases.OrdenReparacion;
import clases.Persona;
import clases.validaciones;
import controlador.controladorCliente;
import controlador.controladorOrdenReparacion;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class F_ServicioTecnico extends javax.swing.JInternalFrame {

    Persona cliente=new Persona();
    controladorCliente controladorCliente=new controladorCliente();
    OrdenReparacion orden;
    controladorOrdenReparacion ctrOrdenReparacion=new controladorOrdenReparacion();
    validaciones validar=new validaciones();
    double to;
    double ab;
    double sa;
    public static String vf;
    public F_ServicioTecnico() {
        initComponents();
        vf = ("vf");
//        cargaTabla();
        prod_precosto.setFormatterFactory(validar.moneda());
        prod_precosto1.setFormatterFactory(validar.moneda());
        prod_precosto2.setFormatterFactory(validar.moneda());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comp_nuevo = new javax.swing.JButton();
        comp_guardar = new javax.swing.JButton();
        comp_salir = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jLabel3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField7 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        comp_buscar1 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        prod_precosto = new javax.swing.JFormattedTextField();
        prod_precosto1 = new javax.swing.JFormattedTextField();
        prod_precosto2 = new javax.swing.JFormattedTextField();
        bt_modificar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBorder(null);

        comp_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo_categoria.png"))); // NOI18N
        comp_nuevo.setText("Nuevo");
        comp_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comp_nuevoActionPerformed(evt);
            }
        });

        comp_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guard_categoria.png"))); // NOI18N
        comp_guardar.setText("Guardar");
        comp_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comp_guardarActionPerformed(evt);
            }
        });

        comp_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar_categoria.png"))); // NOI18N
        comp_salir.setText("Salir");
        comp_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comp_salirActionPerformed(evt);
            }
        });

        jLabel15.setText("Buscar Orden de trabajo");

        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        tabla2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cod Empleado", "Nombres", "Apellidos", "Sexo", "Fecha Nacimiento", "Direccion", "Telefono", "Celular", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabla2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabla2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 311, Short.MAX_VALUE))
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Ordenes de reparación", jPanel3);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("ORDEN DE REPARACIÓN");

        jLabel7.setText("BUSCAR CLIENTE:");

        jLabel2.setText("FECHA DE ENTREGA:");

        jLabel3.setText("NOMBRE DEL CLIENTE:");

        jTextField4.setEditable(false);

        jLabel4.setText("TELF.:");

        jTextField5.setEditable(false);

        jLabel5.setText("SERIE/IMEI:");

        jLabel6.setText("MARCA:");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("INCLUYE"));

        jLabel8.setText("BATERIA:");

        jLabel11.setText("TAPA:");

        jLabel9.setText("CHIP:");

        jLabel10.setText("MEMORIA:");

        jLabel12.setText("CARGADOR:");

        jLabel13.setText("OTROS:");

        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox3)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox4)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox5)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3)
                    .addComponent(jLabel11)
                    .addComponent(jCheckBox4)
                    .addComponent(jLabel12)
                    .addComponent(jCheckBox5)
                    .addComponent(jLabel13)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel14.setText(" DIAGNOSTICO DEL TRABAJO");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextField7.setEnabled(false);

        jLabel16.setText("No.");

        jLabel17.setText("C.I./R.U.C.:");

        jTextField8.setEditable(false);

        comp_buscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N
        comp_buscar1.setToolTipText("");
        comp_buscar1.setBorder(null);
        comp_buscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comp_buscar1ActionPerformed(evt);
            }
        });

        jLabel19.setText("TOTAL:");

        jLabel20.setText("ABONO:");

        jLabel21.setText("SALDO:");

        prod_precosto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        prod_precosto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        prod_precosto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                prod_precostoFocusLost(evt);
            }
        });
        prod_precosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                prod_precostoKeyTyped(evt);
            }
        });

        prod_precosto1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        prod_precosto1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        prod_precosto1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                prod_precosto1FocusLost(evt);
            }
        });
        prod_precosto1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                prod_precosto1KeyTyped(evt);
            }
        });

        prod_precosto2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        prod_precosto2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        prod_precosto2.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prod_precosto, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prod_precosto1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prod_precosto2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(69, 69, 69)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comp_buscar1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField3))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(0, 499, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(comp_buscar1)
                    .addComponent(jLabel7)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel1))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(prod_precosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prod_precosto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prod_precosto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Nuevo/Modificar", jPanel2);

        bt_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/modifi_categoria.png"))); // NOI18N
        bt_modificar.setText("Modificar");
        bt_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_modificarActionPerformed(evt);
            }
        });

        jButton1.setText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comp_nuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comp_guardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_modificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comp_salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comp_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comp_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comp_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void comp_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comp_guardarActionPerformed
        // TODO add your handling code here:
        
//        Persona cliente;
//    OrdenReparacion orden;
//    controladorOrdenReparacion ctrOrdenReparacion = null;

        int REP_ID=0;
        try
        {
            REP_ID=Integer.valueOf(jTextField7.getText());
        }
        catch(NumberFormatException ex)
        {
            
        }
        int PER_ID=cliente.getPER_ID();
        String FECHA=validar.getFechaHora();
        String IMEI=jTextField2.getText();
        String MARCA=jTextField3.getText();
        String FECHA_DE_ENTREGA=validar.getFecha(jXDatePicker1.getDate());
        
        boolean BATERIA =jCheckBox1.isSelected();
        boolean CHIP=jCheckBox2.isSelected();
        boolean MEMORIA=jCheckBox3.isSelected();
        boolean TAPA=jCheckBox4.isSelected();
        boolean CARGADOR=jCheckBox5.isSelected();
        
        String OTROS=jTextField1.getText();
        String DIAGNOSTICO=jTextArea1.getText();
        
        double TOTAL=to;
        double ABONO=ab;
        double SALDO=sa;
        
        boolean ESTADO=true;     
                    
        orden=new OrdenReparacion(REP_ID,PER_ID,FECHA,IMEI,MARCA,FECHA_DE_ENTREGA,BATERIA,CHIP,MEMORIA,TAPA,CARGADOR,OTROS,DIAGNOSTICO,TOTAL,ABONO,SALDO,ESTADO);
        
        if(REP_ID==0)
        {
            ctrOrdenReparacion.registrar(orden);
        }
        else
        {
            ctrOrdenReparacion.actualiza(orden);
        }
        jTabbedPane1.setSelectedIndex(0);
        cargaTabla();
         try {    

           
            
                Connection  con =Conexion.Conexion.conectar();

                JasperReport reporte=null;
                String path="src/Reportes/OrdenReparacion.jasper";

                Map parametros=new HashMap();
                parametros.put("REP_ID",validar.convierteNumeroFactura(orden.getREP_ID()));

                reporte=(JasperReport) JRLoader.loadObjectFromFile(path);

                JasperPrint jprint=JasperFillManager.fillReport(reporte,parametros,con);

                JasperViewer view = new JasperViewer(jprint,false);
                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                view.setVisible(true);

//                limpiarTodo();

            } catch (JRException ex) {
                Logger.getLogger(F_Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_comp_guardarActionPerformed

    private void comp_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comp_salirActionPerformed
        vf=null;
        this.dispose();
    }//GEN-LAST:event_comp_salirActionPerformed

    private void comp_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comp_nuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comp_nuevoActionPerformed

    private void bt_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_modificarActionPerformed
        // TODO add your handling code here:
        int fila=tabla2.getSelectedRow();
        orden=ctrOrdenReparacion.datos.Orden.get(fila);        
        cliente=controladorCliente.getById(String.valueOf(orden.getPER_ID()));
        
        jTextField4.setText(cliente.getPER_NOMBRE());
        jTextField8.setText(cliente.getPER_CEDULA());
        jTextField5.setText(cliente.getPER_TELEFONO());
        
        jTextField7.setText(String.valueOf(orden.getREP_ID()));  
        jTextField2.setText(orden.getIMEI());
        jTextField3.setText(orden.getMARCA());
        
        if(orden.isBATERIA()){jCheckBox1.setSelected(true);}
        if(orden.isCHIP()){jCheckBox2.setSelected(true);}
        if(orden.isMEMORIA()){jCheckBox3.setSelected(true);}
        if(orden.isTAPA()){jCheckBox4.setSelected(true);}
        if(orden.isCARGADOR()){jCheckBox5.setSelected(true);}
        
        String FECHA_DE_ENTREGA=validar.getFecha(jXDatePicker1.getDate());

        
        jTextField1.setText(orden.getOTROS());
        jTextArea1.setText(orden.getDIAGNOSTICO());
        prod_precosto.setValue(orden.getTOTAL());
        prod_precosto1.setValue(orden.getABONO());
        prod_precosto2.setValue(orden.getSALDO());
        jTabbedPane1.setSelectedIndex(1);
        
    }//GEN-LAST:event_bt_modificarActionPerformed

    private void comp_buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comp_buscar1ActionPerformed

        consultaCliente ventD = new consultaCliente(null,true);
        ventD.setVisible(true);
        cliente=ventD.cliente;
        jTextField4.setText(cliente.getPER_NOMBRE());
        jTextField8.setText(cliente.getPER_CEDULA());
        jTextField5.setText(cliente.getPER_TELEFONO());
    }//GEN-LAST:event_comp_buscar1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabla2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla2MouseClicked
        // TODO add your handling code here:
//                popProducto.setVisible(false);
        
//                comp_total.setValue(producto.getPRO_PRECIO_COSTO());
//
//                if(!comp_cantidad.getText().equals(""))
//                {
//                        try
//                        {
//                                int cantidad=Integer.parseInt(comp_cantidad.getText());
//                                String sasd=comp_total.getText();
//                                double valor = validacion.formatoMoneda().parse(comp_total.getText()).doubleValue();
//                                comp_total1.setValue(cantidad*valor);
//                            }
//                        catch (ParseException ex)
//                        {
//                                Logger.getLogger(F_VerificarProducto.class.getName()).log(Level.SEVERE, null, ex);
//                            }
//                    }
//                else
//                {
//                        comp_total1.setValue(0.00);
//                    }
    }//GEN-LAST:event_tabla2MouseClicked

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        // TODO add your handling code here:
        ctrOrdenReparacion.buscar(tabla2, jTextField6.getText());
    }//GEN-LAST:event_jTextField6KeyReleased

    private void prod_precostoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_prod_precostoFocusLost
        // TODO add your handling code here:
        validarTotal();
    }//GEN-LAST:event_prod_precostoFocusLost

    private void prod_precostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prod_precostoKeyTyped
        // TODO add your handling code here:
        validar.decimales(evt,prod_precosto.getText());
        validar.tamanioTextFiel(evt,prod_precosto.getText().length(),7);
    }//GEN-LAST:event_prod_precostoKeyTyped

    private void prod_precosto1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_prod_precosto1FocusLost
        // TODO add your handling code here:
       validarAbono();
    }//GEN-LAST:event_prod_precosto1FocusLost

    private void prod_precosto1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prod_precosto1KeyTyped
        // TODO add your handling code here:
        validar.decimales(evt,prod_precosto1.getText());
        validar.tamanioTextFiel(evt,prod_precosto1.getText().length(),7);
    }//GEN-LAST:event_prod_precosto1KeyTyped

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_modificar;
    private javax.swing.JButton comp_buscar1;
    private javax.swing.JButton comp_guardar;
    private javax.swing.JButton comp_nuevo;
    private javax.swing.JButton comp_salir;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JFormattedTextField prod_precosto;
    private javax.swing.JFormattedTextField prod_precosto1;
    private javax.swing.JFormattedTextField prod_precosto2;
    private javax.swing.JTable tabla2;
    // End of variables declaration//GEN-END:variables

    private void cargaTabla() {
        ctrOrdenReparacion.getAll(tabla2);
    }

    private boolean validarTotal() {
       
       boolean bool=true;
       
        if(validar.formatDinero(prod_precosto.getText())<=0)
        {
             validar.colorRojo(prod_precosto);
             prod_precosto.setValue(null);
             bool=false;
        }
        else
        {
            validar.colorVerde(prod_precosto);
        }
        return bool;
    
    }

    private boolean validarAbono() 
    {
        boolean bool=true;
        to = validar.formatDinero(prod_precosto.getText());
        ab =validar.formatDinero(prod_precosto1.getText());
        sa=0;
        if(ab>to)
        {
            validar.colorRojo(prod_precosto1);
        }
        else
        {
            validar.colorVerde(prod_precosto1);
            sa=to-ab;
            prod_precosto2.setText(String.valueOf(sa));
        }
        return bool;
    }
}
