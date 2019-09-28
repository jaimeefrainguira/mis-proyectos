package Presentacion;
import clases.Categoria;
import clases.Producto;
import clases.validaciones;
import controlador.controladorCategoria;
import controlador.controladorProducto;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class F_Producto extends javax.swing.JInternalFrame
{
    
    
    controladorCategoria ctrCategoria =new controladorCategoria();
    Categoria categoria=new Categoria();
    
    controladorProducto ctrProductos=new controladorProducto();
    Producto producto=new Producto();
    
    validaciones validacion=new validaciones();
    
    public static String vf;
    
    double prec;
    double prev;
    boolean modificar;
    

    
    public F_Producto() {        
        initComponents();
        prod_precosto.setFormatterFactory(validacion.moneda());
        prod_preventa.setFormatterFactory(validacion.moneda());
        prod_ganancia.setFormatterFactory(validacion.moneda());
        
        ctrCategoria.getCombobox(prod_opciones);
        ctrProductos.getAll(tabla);
        mensaje.setText("Se cargaron "+ tabla.getRowCount() +" registros");        
        vf=("vf");
        bloquearBotones(0);
        cargaImg();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        estado = new javax.swing.ButtonGroup();
        PanelConPestania = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        mensaje = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        tusuario_buscar = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        obligados = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        prod_opciones = new javax.swing.JComboBox<>();
        radioBt_Activo = new javax.swing.JRadioButton();
        radioBt_Inactivo = new javax.swing.JRadioButton();
        prod_nombre = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        prod_img = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        prod_stkmini = new javax.swing.JFormattedTextField();
        prod_precosto = new javax.swing.JFormattedTextField();
        prod_preventa = new javax.swing.JFormattedTextField();
        prod_ganancia = new javax.swing.JFormattedTextField();
        bt_salir = new javax.swing.JButton();
        bt_guardar = new javax.swing.JButton();
        bt_modificar = new javax.swing.JButton();
        bt_nuevo = new javax.swing.JButton();
        bt_salir1 = new javax.swing.JButton();

        setBorder(null);
        setVisible(true);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
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

        PanelConPestania.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        PanelConPestania.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                PanelConPestaniaStateChanged(evt);
            }
        });

        mensaje.setText("Mensaje (Se cargaron los registros) ");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Busqueda Avanzada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        tusuario_buscar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tusuario_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tusuario_buscarKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tusuario_buscarKeyReleased(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar1.png"))); // NOI18N
        jLabel14.setText(" Buscar por Codigo o Descripción:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tusuario_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tusuario_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabla.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(mensaje))
        );

        PanelConPestania.addTab("Buscar", jPanel7);

        obligados.setText("Los campos marcado con asterísco (*) son obligatorios");

        jLabel18.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 51, 51));
        jLabel18.setText("*");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Cod. Producto:");

        txtCodigo.setBackground(new java.awt.Color(153, 204, 255));
        txtCodigo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCodigo.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Nombre:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Descripción:");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtDescripcion);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Categoría:");

        prod_opciones.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                prod_opcionesItemStateChanged(evt);
            }
        });
        prod_opciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                prod_opcionesMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prod_opcionesMouseClicked(evt);
            }
        });

        estado.add(radioBt_Activo);
        radioBt_Activo.setText("Activo");

        estado.add(radioBt_Inactivo);
        radioBt_Inactivo.setText("Inactivo");

        prod_nombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                prod_nombreFocusLost(evt);
            }
        });
        prod_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                prod_nombreKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(prod_nombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(radioBt_Activo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(radioBt_Inactivo))
                                .addComponent(prod_opciones, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 347, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioBt_Activo)
                    .addComponent(radioBt_Inactivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prod_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(prod_opciones, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Stock total:");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Stock minímo:");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Precio venta:");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Precio costo:");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("Utilidad:");

        prod_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/smartphone.png"))); // NOI18N
        prod_img.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 204, 204)));

        jFormattedTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormattedTextField1FocusLost(evt);
            }
        });
        jFormattedTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFormattedTextField1KeyTyped(evt);
            }
        });

        prod_stkmini.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        prod_stkmini.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                prod_stkminiFocusLost(evt);
            }
        });
        prod_stkmini.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                prod_stkminiKeyTyped(evt);
            }
        });

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

        prod_preventa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        prod_preventa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                prod_preventaFocusLost(evt);
            }
        });
        prod_preventa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                prod_preventaKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prod_preventaKeyReleased(evt);
            }
        });

        prod_ganancia.setEditable(false);
        prod_ganancia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        prod_ganancia.setFocusable(false);
        prod_ganancia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                prod_gananciaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(prod_stkmini, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(prod_precosto)
                            .addComponent(prod_preventa)
                            .addComponent(prod_ganancia)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(prod_img, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prod_stkmini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prod_precosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prod_preventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prod_ganancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(prod_img, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(obligados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 105, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(obligados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        PanelConPestania.addTab("Nuevo / Editar", jPanel2);

        bt_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar_categoria.png"))); // NOI18N
        bt_salir.setText("Salir");
        bt_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salirActionPerformed(evt);
            }
        });

        bt_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guard_categoria.png"))); // NOI18N
        bt_guardar.setText("Guardar");
        bt_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_guardarActionPerformed(evt);
            }
        });

        bt_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/modifi_categoria.png"))); // NOI18N
        bt_modificar.setText("Modificar");
        bt_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_modificarActionPerformed(evt);
            }
        });

        bt_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo_categoria.png"))); // NOI18N
        bt_nuevo.setText("Nuevo");
        bt_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_nuevoActionPerformed(evt);
            }
        });

        bt_salir1.setText("Imprimir");
        bt_salir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salir1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelConPestania)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bt_nuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_modificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_guardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_salir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bt_salir1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(bt_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_salir1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelConPestania)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        vf=null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void prod_opcionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prod_opcionesMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_prod_opcionesMouseClicked

    private void prod_opcionesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prod_opcionesMouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_prod_opcionesMouseReleased

    private void prod_opcionesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_prod_opcionesItemStateChanged
        // TODO add your handling code here:
        cargaImg();
    }//GEN-LAST:event_prod_opcionesItemStateChanged

    private void bt_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salirActionPerformed
        vf = null;
        this.dispose();
    }//GEN-LAST:event_bt_salirActionPerformed

    private void bt_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_guardarActionPerformed
        // TODO add your handling code here:

        if(validaEnvioBD())
        {
            int PRO_ID=0;
            if(!txtCodigo.getText().equals(""))
            {
                PRO_ID=Integer.parseInt(txtCodigo.getText());
            }
            String PRO_NOMBRE=prod_nombre.getText();
            String PRO_DESCRIPCION=txtDescripcion.getText();
//            double PRO_PRECIO_COSTO =Double.parseDouble(prod_precosto.getText());
//            double PRO_PRECIO_VENTA=Double.parseDouble(prod_preventa.getText());
            int PRO_STOCK = Integer.parseInt(jFormattedTextField1.getText());
            int PRO_STOCK_MINIMO=Integer.parseInt(prod_stkmini.getText());        
            boolean PRO_ESTADO = false;if(radioBt_Activo.isSelected()){PRO_ESTADO=true;}if(radioBt_Inactivo.isSelected()){PRO_ESTADO=false;}

            int fila=prod_opciones.getSelectedIndex();
            categoria=ctrCategoria.datos.categoria.get(fila);
            int CAT_ID=categoria.getCAT_ID();

            producto=new Producto(PRO_ID,PRO_NOMBRE,PRO_DESCRIPCION,prec,prev,PRO_STOCK,PRO_STOCK_MINIMO,PRO_ESTADO,CAT_ID);


            if(txtCodigo.getText().equals(""))
            {

                if(ctrProductos.registrar(producto))
                    {
                        PanelConPestania.setSelectedIndex(0);
                        ctrProductos.getAll(tabla);
                        limpiarEntradas();
                        mensaje.setText("Se cargaron "+tabla.getRowCount()+" registros");
                    }

            }
            else
            {
                ctrProductos.modificar(producto,modificar);
                PanelConPestania.setSelectedIndex(0);
                ctrProductos.getAll(tabla);
                mensaje.setText("Se cargaron "+tabla.getRowCount()+" registros");
                limpiarEntradas();
            }
        }
        
    }//GEN-LAST:event_bt_guardarActionPerformed

    private void bt_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_modificarActionPerformed
        // TODO add your handling code here:        
        int fila=tabla.getSelectedRow();
        
        txtCodigo.setText(String.valueOf(tabla.getValueAt(fila, 0)));
        prod_nombre.setText(String.valueOf(tabla.getValueAt(fila, 1)));
        txtDescripcion.setText((String) tabla.getValueAt(fila, 2));
        prod_precosto.setValue(tabla.getValueAt(fila, 3));
        prod_preventa.setValue(tabla.getValueAt(fila, 4));
        prod_ganancia.setValue(new Float((float) tabla.getValueAt(fila,4)-(float) tabla.getValueAt(fila,3)));
        jFormattedTextField1.setText(String.valueOf(tabla.getValueAt(fila, 5)));
        prod_stkmini.setText(String.valueOf(tabla.getValueAt(fila, 6)));   
        
        prec=Double.parseDouble(String.valueOf(tabla.getValueAt(fila, 3)));
        prev=Double.parseDouble(String.valueOf(tabla.getValueAt(fila, 4)));
        
        if(tabla.getValueAt(fila, 7).equals("Activo"))
        {
            radioBt_Activo.setSelected(true);
        }
        else
        {
            radioBt_Inactivo.setSelected(true);
        }
        prod_opciones.setSelectedItem(String.valueOf(tabla.getValueAt(fila, 8)));

        PanelConPestania.setSelectedIndex(1);
        
        modificar=ctrProductos.consultaModificar(Integer.parseInt(txtCodigo.getText()));
        if(modificar)
        {
            jFormattedTextField1.setEditable(true);
            prod_stkmini.setEditable(true);
            prod_precosto.setEditable(true);
        } 
        else
        {
            jFormattedTextField1.setEditable(false);
            prod_stkmini.setEditable(false);
            prod_precosto.setEditable(false);
        }
        
        
        
        
        
    }//GEN-LAST:event_bt_modificarActionPerformed

    private void bt_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_nuevoActionPerformed
        limpiarEntradas();
        PanelConPestania.setSelectedIndex(1);
        bloquearBotones(PanelConPestania.getSelectedIndex());
        
        
        
        
    }//GEN-LAST:event_bt_nuevoActionPerformed

    private void tusuario_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tusuario_buscarKeyReleased
        // TODO add your handling code here:
        //        categoria=new Categoria();;
        //        controladorCategoria = new controladorCategoria();
        //        if(cod_tusuario.isSelected())
        //        {
            //            tusuario_table1.setModel(controladorCategoria.buscarTipousuarioById(tusuario_buscar.getText()));
            //
            //        }
        //        if(tusuario_descripcion.isSelected())
        //        {
            //            tusuario_table1.setModel(controladorCategoria.buscarTipousuarioByDescripcion(tusuario_buscar.getText()));
            //
            //        }

        //        tabla.setModel(controladorCategoria.buscarCategoria(tusuario_buscar.getText()));
        ctrProductos.buscar(tabla, tusuario_buscar.getText());
        //        mensaje.setText("Se cargaron "+tabla.getRowCount()+" registros");
//        bloquearBotones();
        //        controladorCategoria.anchoTablas(tabla);
        bloquearBotones(0);
    }//GEN-LAST:event_tusuario_buscarKeyReleased

    private void tablaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseReleased
        // TODO add your handling code here:
        bt_modificar.setEnabled(true);
    }//GEN-LAST:event_tablaMouseReleased

    private void prod_preventaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_prod_preventaFocusLost
        // TODO add your handling code here:        
        validaPrecioVenta();
    }//GEN-LAST:event_prod_preventaFocusLost

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
        // TODO add your handling code here:
        validacion.mayusculas(evt);
    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void tusuario_buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tusuario_buscarKeyTyped
        // TODO add your handling code here:
        validacion.mayusculas(evt);
    }//GEN-LAST:event_tusuario_buscarKeyTyped

    private void PanelConPestaniaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_PanelConPestaniaStateChanged
        // TODO add your handling code here:
        
        bloquearBotones(PanelConPestania.getSelectedIndex());
    }//GEN-LAST:event_PanelConPestaniaStateChanged

    private void prod_preventaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prod_preventaKeyReleased
        // TODO add your handling code here:
//        validaPrecioVenta();        
    }//GEN-LAST:event_prod_preventaKeyReleased

    private void prod_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prod_nombreKeyTyped
        // TODO add your handling code here:
        validacion.mayusculas(evt);
    }//GEN-LAST:event_prod_nombreKeyTyped

    private void prod_precostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prod_precostoKeyTyped
        // TODO add your handling code here:
        validacion.decimales(evt,prod_precosto.getText());
        validacion.tamanioTextFiel(evt,prod_precosto.getText().length(),7);
         
    }//GEN-LAST:event_prod_precostoKeyTyped

    private void prod_preventaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prod_preventaKeyTyped
        // TODO add your handling code here:
        validacion.decimales(evt,prod_preventa.getText());
        validacion.tamanioTextFiel(evt,prod_preventa.getText().length(),7);
    }//GEN-LAST:event_prod_preventaKeyTyped

    private void prod_gananciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prod_gananciaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_prod_gananciaKeyPressed

    private void prod_stkminiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prod_stkminiKeyTyped
        // TODO add your handling code here:
        validacion.enteros(evt);        
        validacion.tamanioTextFiel(evt,prod_stkmini.getText().length(),7);
    }//GEN-LAST:event_prod_stkminiKeyTyped

    private void jFormattedTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField1KeyTyped
        // TODO add your handling code here:
        validacion.enteros(evt);        
        validacion.tamanioTextFiel(evt,jFormattedTextField1.getText().length(),7);
    }//GEN-LAST:event_jFormattedTextField1KeyTyped

    private void prod_precostoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_prod_precostoFocusLost
        // TODO add your handling code here:
       validaPrecioCosto();
    }//GEN-LAST:event_prod_precostoFocusLost

    private void jFormattedTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextField1FocusLost
        // TODO add your handling code here:
        validarStock();
    }//GEN-LAST:event_jFormattedTextField1FocusLost

    private void prod_stkminiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_prod_stkminiFocusLost
        // TODO add your handling code here:
        validaStockMinimo();
    }//GEN-LAST:event_prod_stkminiFocusLost

    private void prod_nombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_prod_nombreFocusLost
        // TODO add your handling code here:
        validaNombre();
    }//GEN-LAST:event_prod_nombreFocusLost

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusGained

    private void bt_salir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salir1ActionPerformed
        // TODO add your handling code here:
        try {    

                Connection  con =Conexion.Conexion.conectar();

                JasperReport reporte=null;
                String path="src/Reportes/inventario.jasper";

                Map parametros=new HashMap();

                reporte=(JasperReport) JRLoader.loadObjectFromFile(path);

                JasperPrint jprint=JasperFillManager.fillReport(reporte,parametros,con);

                JasperViewer view = new JasperViewer(jprint,false);
                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                view.setVisible(true);



            } catch (JRException ex) {
                Logger.getLogger(F_Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_bt_salir1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane PanelConPestania;
    private javax.swing.JButton bt_guardar;
    private javax.swing.JButton bt_modificar;
    private javax.swing.JButton bt_nuevo;
    private javax.swing.JButton bt_salir;
    private javax.swing.JButton bt_salir1;
    private javax.swing.ButtonGroup estado;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel mensaje;
    private javax.swing.JLabel obligados;
    private javax.swing.JFormattedTextField prod_ganancia;
    private javax.swing.JLabel prod_img;
    private javax.swing.JFormattedTextField prod_nombre;
    private javax.swing.JComboBox<String> prod_opciones;
    private javax.swing.JFormattedTextField prod_precosto;
    private javax.swing.JFormattedTextField prod_preventa;
    private javax.swing.JFormattedTextField prod_stkmini;
    private javax.swing.JRadioButton radioBt_Activo;
    private javax.swing.JRadioButton radioBt_Inactivo;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField tusuario_buscar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDescripcion;
    // End of variables declaration//GEN-END:variables

    private void cargaImg() {
        
            int fila=prod_opciones.getSelectedIndex();
            categoria=ctrCategoria.datos.categoria.get(fila);
            prod_img.setIcon(categoria.getIcono(180, 180));
            
       
        
    }

    private void limpiarEntradas() {
        txtCodigo.setText(null);
        estado.clearSelection();
        radioBt_Activo.setSelected(true);
        prod_nombre.setText(null);
        txtDescripcion.setText(null);
        prod_opciones.setSelectedIndex(0);
        jFormattedTextField1.setText(null);
        prod_stkmini.setText(null);
        prod_precosto.setValue(null);
        prod_preventa.setValue(null);
        prod_ganancia.setValue(null);
        jFormattedTextField1.setEditable(true);
        prod_stkmini.setEditable(true);
        prod_precosto.setEditable(true);
    }

    private void bloquearBotones(int caso) 
    {
        
        switch(caso)
        { 
            case 0:
            {
                bt_nuevo.setEnabled(true);
                bt_modificar.setEnabled(false);
                bt_guardar.setEnabled(false);
                break;
            }
            case 1:
            {
                bt_nuevo.setEnabled(false);
                bt_modificar.setEnabled(false);
                bt_guardar.setEnabled(true);
                jFormattedTextField1.setEditable(true);
                prod_stkmini.setEditable(true);
                prod_precosto.setEditable(true);
                break;
            }
            case 2:
            {
                bt_nuevo.setEnabled(true);
                bt_modificar.setEnabled(true);
                bt_guardar.setEnabled(false);
                break;
            }              
        }
        prod_nombre.setBackground(Color.decode("#FFFFFF"));
        jFormattedTextField1.setBackground(Color.decode("#FFFFFF"));
        prod_stkmini.setBackground(Color.decode("#FFFFFF"));
        prod_precosto.setBackground(Color.decode("#FFFFFF"));
        prod_preventa.setBackground(Color.decode("#FFFFFF"));
    }
    private boolean validaEnvioBD() 
    {
        boolean bool=false;
        validaNombre();
        validarStock();
        validaStockMinimo();
        validaPrecioCosto();
        validaPrecioVenta();
        if(validaNombre()&&validaEstado()&&validarStock()&&validaStockMinimo()&&validaPrecioCosto()&&validaPrecioVenta())
        {
            bool=true;
            System.out.println("todos los campos validados");
        }
        return bool;
    }

    private boolean validaPrecioVenta() 
    {
        boolean bool=true;
        prec = validacion.formatDinero(prod_precosto.getText());
        prev =validacion.formatDinero(prod_preventa.getText());
        if(prev>prec)
        {
            System.out.println(prec+"   "+prev);
            prod_ganancia.setValue(new Float(prev-prec)); 
            validacion.colorVerde(prod_preventa);
        }
        else
        {
            validacion.colorRojo(prod_preventa);
            prod_preventa.setValue(null);
            prod_ganancia.setValue(null);
            bool=false;
        }
        return bool;
    }

    private boolean validaPrecioCosto() 
    {
        boolean bool=true;
       
        if(validacion.formatDinero(prod_precosto.getText())<=0)
        {
             validacion.colorRojo(prod_precosto);
             prod_precosto.setValue(null);
             bool=false;
        }
        else
        {
            validacion.colorVerde(prod_precosto);
        }
        return bool;
    }

    private boolean validarStock() 
    {
        boolean bool=true;
        if(validacion.getInteger(jFormattedTextField1.getText())<=0)
        {
            validacion.colorRojo(jFormattedTextField1);
            jFormattedTextField1.setText("");
            bool=false;
        }
        else
        {
            validacion.colorVerde(jFormattedTextField1);
        }
        return bool;
    }

    private boolean validaStockMinimo() 
    {
        boolean bool=true;
        if(validacion.getInteger(prod_stkmini.getText())<0)
        {
            validacion.colorRojo(prod_stkmini);
            prod_stkmini.setText("");
            bool=false;
        }
        else
        {
            validacion.colorVerde(prod_stkmini);
        }
        return bool;
    }

    private boolean validaNombre() 
    {        
        return validacion.noNulloText(prod_nombre);
    }
    private boolean validaEstado()
    {
        boolean bool=false;
        if(radioBt_Activo.isSelected()||radioBt_Inactivo.isSelected())
        {
            bool=true;
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el Estado (Activo o Inactivo)");
        }
        return bool;
    }

    
}
