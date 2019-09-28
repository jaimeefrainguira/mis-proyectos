package Presentacion;
import javax.swing.JOptionPane;
import Presentacion.Menu.*;
import clases.ComprasCabesera;
import clases.ComprasDetalle;
import clases.Producto;
import clases.Proveedor;
import clases.TextPrompt;
import clases.Usuario;
import clases.validaciones;
import controlador.controladorCompras;
import controlador.controladorProducto;
import controlador.controladorProveedor;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import static jdk.nashorn.internal.objects.NativeRegExp.source;

public class F_Compras extends javax.swing.JInternalFrame {
    public static String vf;
    
   
//    TextPrompt placeholder;
    String place="Apellido Paterno";
    Proveedor proveedor=new Proveedor();
    
    controladorProveedor controladorProveedor=new controladorProveedor();
    
    ComprasDetalle compras=new ComprasDetalle();
    ComprasCabesera ComprasCabesera =new ComprasCabesera();
    controladorCompras ctrComCab=new controladorCompras();
    Calendar c2;
    controladorProducto ctrProductos=new controladorProducto();
    Producto producto=new Producto();
    validaciones validacion=new validaciones();
    int i=0;
    public Usuario usuario=new Usuario();
    public F_Compras(Usuario usu) {
        
        initComponents();
        
        validacion.moneda();
      
        comp_costo.setFormatterFactory(validacion.moneda());
        comp_total.setFormatterFactory(validacion.moneda());
        comp_total1.setFormatterFactory(validacion.moneda());
        comp_sbtotal.setFormatterFactory(validacion.moneda());
        comp_iva.setFormatterFactory(validacion.moneda());
        comp_totalpagar.setFormatterFactory(validacion.moneda());
       
        popProveedor.setVisible(false);
       popProducto.setVisible(false);
       
       
        this.usuario=usu;
//        placeholder = new TextPrompt(place, cod_compras);
        
//        TextPrompt placeholder = new TextPrompt("Apellido Paterno", cod_compras);
//        placeholder.changeAlpha(0.75f);
//        placeholder.changeStyle(Font.ITALIC);
        vf = ("vf");
        
        
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        comp_numcompra = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comp_cambiar = new javax.swing.JCheckBox();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        popProveedor = new javax.swing.JLayeredPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        popProducto = new javax.swing.JLayeredPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        cod_compras = new javax.swing.JTextField();
        comp_nombres = new javax.swing.JTextField();
        comp_buscar = new javax.swing.JButton();
        comp_buscar2 = new javax.swing.JButton();
        comp_opciones = new javax.swing.JComboBox<>();
        facturaNumero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        comp_agregar = new javax.swing.JButton();
        comp_borrarfila = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        comp_cambiar1 = new javax.swing.JCheckBox();
        comp_cantidad = new javax.swing.JFormattedTextField();
        comp_total = new javax.swing.JFormattedTextField();
        comp_stock = new javax.swing.JFormattedTextField();
        comp_costo = new javax.swing.JFormattedTextField();
        comp_total1 = new javax.swing.JFormattedTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        comp_sbtotal = new javax.swing.JFormattedTextField();
        comp_iva = new javax.swing.JFormattedTextField();
        comp_totalpagar = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        comp_nuevo = new javax.swing.JButton();
        comp_guardar = new javax.swing.JButton();
        comp_salir = new javax.swing.JButton();

        setBorder(null);
        setTitle("REGISTRO DE COMPRA");
        setRequestFocusEnabled(false);
        setVisible(true);
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

        jLabel15.setFont(new java.awt.Font("Bebas Neue", 1, 24)); // NOI18N
        jLabel15.setText("N° -");

        comp_numcompra.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        comp_numcompra.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        comp_numcompra.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Bebas Neue", 1, 36)); // NOI18N
        jLabel3.setText("COMPRA DE PRODUCTOS");

        comp_cambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comp_cambiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comp_numcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comp_cambiar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(comp_cambiar))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel15)
                        .addComponent(comp_numcompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLayeredPane1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jLayeredPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLayeredPane1MouseClicked(evt);
            }
        });

        tabla1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabla1);

        popProveedor.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout popProveedorLayout = new javax.swing.GroupLayout(popProveedor);
        popProveedor.setLayout(popProveedorLayout);
        popProveedorLayout.setHorizontalGroup(
            popProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        popProveedorLayout.setVerticalGroup(
            popProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );

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

        popProducto.setLayer(jScrollPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout popProductoLayout = new javax.swing.GroupLayout(popProducto);
        popProducto.setLayout(popProductoLayout);
        popProductoLayout.setHorizontalGroup(
            popProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        popProductoLayout.setVerticalGroup(
            popProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );

        tabla.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        tabla.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        jLabel12.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel12.setText("Proveedor:");

        cod_compras.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cod_compras.setToolTipText("");
        cod_compras.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cod_comprasFocusLost(evt);
            }
        });
        cod_compras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cod_comprasKeyReleased(evt);
            }
        });

        comp_nombres.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        comp_nombres.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                comp_nombresFocusLost(evt);
            }
        });
        comp_nombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                comp_nombresKeyReleased(evt);
            }
        });

        comp_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N
        comp_buscar.setToolTipText("");
        comp_buscar.setBorder(null);
        comp_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comp_buscarActionPerformed(evt);
            }
        });

        comp_buscar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N
        comp_buscar2.setToolTipText("");
        comp_buscar2.setBorder(null);
        comp_buscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comp_buscar2ActionPerformed(evt);
            }
        });

        comp_opciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Factura", "Nota de Venta" }));

        facturaNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                facturaNumeroKeyPressed(evt);
            }
        });

        jLabel2.setText("No.");

        jLabel30.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel30.setText("Cant.:");

        jLabel31.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel31.setText("Valor:");

        comp_agregar.setText("Agregar");
        comp_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comp_agregarActionPerformed(evt);
            }
        });

        comp_borrarfila.setText("Borrar");
        comp_borrarfila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comp_borrarfilaActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel27.setText("Producto:");

        jLabel26.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel26.setText("Costo:");

        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setText("Stock:");

        jLabel32.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel32.setText("Total:");

        comp_cambiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comp_cambiar1ActionPerformed(evt);
            }
        });

        comp_cantidad.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        comp_cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                comp_cantidadKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                comp_cantidadKeyReleased(evt);
            }
        });

        comp_total.setEditable(false);
        comp_total.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        comp_total.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                comp_totalKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                comp_totalKeyReleased(evt);
            }
        });

        comp_stock.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        comp_stock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                comp_stockKeyReleased(evt);
            }
        });

        comp_costo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        comp_total1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLayeredPane1.setLayer(popProveedor, javax.swing.JLayeredPane.MODAL_LAYER);
        jLayeredPane1.setLayer(popProducto, javax.swing.JLayeredPane.MODAL_LAYER);
        jLayeredPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(cod_compras, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(comp_nombres, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(comp_buscar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(comp_buscar2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(comp_opciones, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(facturaNumero, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel30, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel31, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(comp_agregar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(comp_borrarfila, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel27, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel26, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel18, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel32, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(comp_cambiar1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(comp_cantidad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(comp_total, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(comp_stock, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(comp_costo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(comp_total1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jSeparator1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jSeparator2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jLabel31))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(220, 220, 220)
                                .addComponent(comp_cambiar1))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(509, 509, 509)
                                .addComponent(facturaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(251, 251, 251)
                                .addComponent(jLabel32))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(281, 281, 281)
                                .addComponent(comp_buscar))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(374, 374, 374)
                                .addComponent(comp_agregar))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel12))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(481, 481, 481)
                                .addComponent(jLabel2))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(480, 480, 480)
                                .addComponent(jLabel18))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(519, 519, 519)
                                .addComponent(comp_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(374, 374, 374)
                                .addComponent(comp_costo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(283, 283, 283)
                                .addComponent(comp_buscar2))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(287, 287, 287)
                                .addComponent(comp_total1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(473, 473, 473)
                                .addComponent(comp_borrarfila, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(333, 333, 333)
                                .addComponent(jLabel26))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(331, 331, 331)
                                .addComponent(comp_opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(comp_total, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(comp_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addGap(34, 34, 34)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(popProducto)
                                    .addComponent(comp_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(13, 13, 13)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(popProveedor)
                                    .addComponent(cod_compras, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel12))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(cod_compras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel27)
                        .addGap(3, 3, 3)
                        .addComponent(popProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel18))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(comp_stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(comp_costo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(comp_buscar2))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(comp_total1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(comp_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(comp_borrarfila))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel26))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel30))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(comp_opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(comp_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(comp_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(jLabel31))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(comp_cambiar1))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(facturaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(jLabel32))
                            .addComponent(comp_buscar)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(comp_agregar))))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(popProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanel7.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel19.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel19.setText("Sub Total:");

        jLabel20.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel20.setText("IVA:");

        jLabel22.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel22.setText("Total a Pagar:");

        comp_sbtotal.setEditable(false);

        comp_iva.setEditable(false);

        comp_totalpagar.setEditable(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comp_sbtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comp_iva, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comp_totalpagar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel22)
                    .addComponent(comp_sbtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comp_iva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comp_totalpagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comp_nuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comp_guardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(comp_salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comp_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comp_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comp_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLayeredPane1))
                        .addGap(18, 18, 18)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLayeredPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        vf = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void comp_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comp_salirActionPerformed
        vf=null;
        this.dispose();
    }//GEN-LAST:event_comp_salirActionPerformed

    private void comp_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comp_guardarActionPerformed
        // TODO add your handling code here:
        //        private int COM_CAB_ID;
        //    private int COM_CAB_PROVEEDOR_ID;
        //    private int COM_CAB_USUARIO_ID;
        //    private String COM_CAB_FECHA;
        //    private int COM_CAB_TIPO_COMPROVANTE;
        //    private int COM_CAB_NUM_COMPROVANTE;
        //    private double COM_CAB_SUBTOTAL;
        //    private double COM_CAB_IVA;
        //    private double COM_CAB_TOTAL;
        //    private boolean COM_CAB_ESTADO;

        //    int año1 =fechingreso.getCalendar().get(Calendar.YEAR);
        //        int mes1=fechingreso.getCalendar().get(Calendar.MARCH);
        //        int dia1=fechingreso.getCalendar().get(Calendar.DAY_OF_MONTH);
        //        String fechaIngreso=String.valueOf(año1+"-"+mes1+"-"+dia1);

        c2 = new GregorianCalendar();

        comp_cambiar.getSelectedIcon();
        int NumeroDeCompra=0;
        if(comp_cambiar.isSelected())
        {
            NumeroDeCompra=Integer.parseInt(comp_numcompra.getText());
        }
        int NumeroDeComprovante=0;
        try {
            NumeroDeComprovante =Integer.parseInt(facturaNumero.getText());
        } catch (NumberFormatException e)
        {

        }

        try {
            ComprasCabesera=new clases.ComprasCabesera(
                NumeroDeCompra,
                proveedor.getPER_ID(),
                usuario.getPER_ID(),
                "now()",
                comp_opciones.getSelectedIndex(),
                NumeroDeComprovante,
                validacion.formatoMoneda().parse(comp_sbtotal.getText()).doubleValue(),
                validacion.formatoMoneda().parse(comp_iva.getText()).doubleValue(),
                validacion.formatoMoneda().parse(comp_totalpagar.getText()).doubleValue(),
                true);
        } catch (ParseException ex) {
            Logger.getLogger(F_Compras.class.getName()).log(Level.SEVERE, null, ex);
        }
        ctrComCab.registrar(ComprasCabesera);
        limpiarTodo();
    }//GEN-LAST:event_comp_guardarActionPerformed

    private void comp_cambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comp_cambiarActionPerformed
        // TODO add your handling code here:
        if(comp_cambiar.isSelected())
        {
            comp_numcompra.enable(true);
            comp_numcompra.requestFocus();
        }
        else
        {
            comp_numcompra.enable(false);
            comp_numcompra.setText("");
        }
    }//GEN-LAST:event_comp_cambiarActionPerformed

    private void comp_stockKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comp_stockKeyReleased
        // TODO add your handling code here:
        popProveedor.setLocation(cod_compras.getLocation().x, cod_compras.getLocation().y);
    }//GEN-LAST:event_comp_stockKeyReleased

    private void comp_totalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comp_totalKeyReleased
        // TODO add your handling code here:

        if(!comp_total.getText().equals(""))
        { 
            try
            {
                int cantidad=Integer.parseInt(comp_cantidad.getText());
                double valor = Double.parseDouble(comp_total.getText());
                comp_total1.setValue(cantidad*valor);
            }
            catch (NumberFormatException ex)
            {
                Logger.getLogger(F_Compras.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            comp_total1.setValue(0.00);
        }
    }//GEN-LAST:event_comp_totalKeyReleased

    private void comp_totalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comp_totalKeyTyped
        // TODO add your handling code here:
        validacion.decimales(evt, comp_total.getText());
    }//GEN-LAST:event_comp_totalKeyTyped

    private void comp_cantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comp_cantidadKeyReleased
        // TODO add your handling code here:
        if(!comp_cantidad.getText().equals(""))
        {
            try
            {
                int cantidad=Integer.parseInt(comp_cantidad.getText());
                String sasd=comp_total.getText();                
                double valor = validacion.formatoMoneda().parse(comp_total.getText()).doubleValue();
                comp_total1.setValue(cantidad*valor);
            }
            catch (ParseException ex)
            {
                Logger.getLogger(F_Compras.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            comp_total1.setValue(0.00);
        }
    }//GEN-LAST:event_comp_cantidadKeyReleased

    private void comp_cantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comp_cantidadKeyTyped
        // TODO add your handling code here:
        validacion.enteros(evt);
    }//GEN-LAST:event_comp_cantidadKeyTyped

    private void comp_cambiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comp_cambiar1ActionPerformed
        // TODO add your handling code here:

        if(comp_cambiar1.isSelected())
        {
            comp_total.setEditable(true);
            comp_total.requestFocus();
        }
        else
        {
            comp_total.setEditable(false);
            comp_total.setValue(producto.getPRO_PRECIO_COSTO());
            if(!comp_total.getText().equals(""))
            {
                try
                {
                    int cantidad=Integer.parseInt(comp_cantidad.getText());
                    double valor = validacion.formatoMoneda().parse(comp_total.getText()).doubleValue();
                    comp_total1.setValue(cantidad*valor);
                }
                catch (ParseException ex)
                {
                    Logger.getLogger(F_Compras.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch(NumberFormatException e)
                {
                    
                }
            }
        }
    }//GEN-LAST:event_comp_cambiar1ActionPerformed

    private void comp_buscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comp_buscar2ActionPerformed
        // TODO add your handling code here:
        consultaProductos ventD = new consultaProductos(null,true);
        ventD.setVisible(true);
        producto=ventD.producto;
        
        
        comp_nombres.setText(producto.getPRO_NOMBRE());
        comp_costo.setValue(producto.getPRO_PRECIO_COSTO());
        comp_stock.setValue(producto.getPRO_STOCK());
        comp_total.setValue(producto.getPRO_PRECIO_COSTO());
        
        if(!comp_cantidad.getText().equals(""))
        {
            int cantidad=Integer.parseInt(comp_cantidad.getText());
            double valor = producto.getPRO_PRECIO_COSTO();
            comp_total1.setValue(cantidad*valor);
        }
        else
        {
            comp_total1.setValue(0.00);
        }
//        ctrProductos.buscar(tabla1, "");
//        popProveedor.setVisible(true);
    }//GEN-LAST:event_comp_buscar2ActionPerformed

    private void comp_nombresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comp_nombresKeyReleased
        // TODO add your handling code here:

        if(comp_nombres.getText().equals(""))
        {
            popProducto.setVisible(false);
        }
        else
        {
            popProducto.setVisible(true);
        }
        ctrProductos.buscar(tabla2, comp_nombres.getText());
    }//GEN-LAST:event_comp_nombresKeyReleased

    private void comp_borrarfilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comp_borrarfilaActionPerformed
        // TODO add your handling code here:
        int fila=tabla.getSelectedRow();
        ctrComCab.Eliminar(fila);
        ctrComCab.getAll(tabla);
        comp_sbtotal.setValue(ctrComCab.datos.subtotal);
        comp_iva.setValue(ctrComCab.datos.iva);
        comp_totalpagar.setValue(ctrComCab.datos.total);
        int x=0;
    }//GEN-LAST:event_comp_borrarfilaActionPerformed

    private void comp_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comp_agregarActionPerformed
        // TODO add your handling code here:
        int PRO_ID = producto.getPRO_ID();
        int cantidad=0;
        double valorUnitario=0;
        double valorTotal=0;

        String pc = comp_total.getText();
        String pt=comp_total1.getText();
        try
        {
            Number numero = validacion.formatoMoneda().parse(pc);
            Number numero2 = validacion.formatoMoneda().parse(pt);
            cantidad=Integer.parseInt(comp_cantidad.getText());
            valorUnitario = numero.doubleValue()+(numero.doubleValue()*12/100);
            valorTotal = numero2.doubleValue()+(numero2.doubleValue()*12/100);
        }
        catch (ParseException ex)
        {
            Logger.getLogger(F_Compras.class.getName()).log(Level.SEVERE, null, ex);
        }

        compras=new ComprasDetalle(1, PRO_ID, cantidad, valorUnitario, valorTotal);

        if(ctrComCab.Buscar(PRO_ID))
        {
            ctrComCab.Agregar(compras);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Ya existe este producto en detalle");
        }
        ctrComCab.getAll(tabla);
        comp_sbtotal.setValue(ctrComCab.datos.subtotal);
        comp_iva.setValue(ctrComCab.datos.iva);
        comp_totalpagar.setValue(ctrComCab.datos.total);
    }//GEN-LAST:event_comp_agregarActionPerformed

    private void facturaNumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_facturaNumeroKeyPressed
        // TODO add your handling code here:
        validacion.enteros(evt);
    }//GEN-LAST:event_facturaNumeroKeyPressed

    private void comp_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comp_buscarActionPerformed
//        tabla1.setModel(controladorProveedor.buscar(""));
//        controladorProveedor.anchoTablas(tabla1);
//        popProveedor.setVisible(true);

        consultaProveedor ventD = new consultaProveedor(null,true);
        ventD.setVisible(true);        
        proveedor=ventD.cliente;        
        cod_compras.setText(proveedor.getPER_NOMBRE());

        //            placeholder();

        //            Menu.usuario.getPER_ID();
        //            int a = Menu.usuario.getPER_ID();
        //
        //
        //
        //        NewJFrame ventana=new NewJFrame();
        //        ventana.setVisible(true);
    }//GEN-LAST:event_comp_buscarActionPerformed

    private void cod_comprasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cod_comprasKeyReleased
        // TODO add your handling code here:
     
        tabla1.setModel(controladorProveedor.buscar(cod_compras.getText()));
        controladorProveedor.anchoTablas(tabla1);
        if(cod_compras.getText().equals(""))
        {
            popProveedor.setVisible(false);

        }
        else
        {
            popProveedor.setVisible(true);

        }
    }//GEN-LAST:event_cod_comprasKeyReleased

    private void jLayeredPane1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLayeredPane1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLayeredPane1AncestorAdded

    private void cod_comprasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cod_comprasFocusLost
        // TODO add your handling code here:
//        popProveedor.setVisible(false);
    }//GEN-LAST:event_cod_comprasFocusLost

    private void comp_nombresFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comp_nombresFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_comp_nombresFocusLost

    private void jLayeredPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLayeredPane1MouseClicked
        // TODO add your handling code here:
        popProveedor.setVisible(false);
        popProducto.setVisible(false);
    }//GEN-LAST:event_jLayeredPane1MouseClicked

    private void tabla2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla2MouseClicked
        // TODO add your handling code here:
        popProducto.setVisible(false);
        int fila=tabla2.getSelectedRow();
        producto = ctrProductos.buscarById(tabla2.getValueAt(fila, 0).toString());

        comp_nombres.setText(producto.getPRO_NOMBRE());
        comp_costo.setValue(producto.getPRO_PRECIO_COSTO());
        comp_stock.setValue(producto.getPRO_STOCK());
        comp_total.setValue(producto.getPRO_PRECIO_COSTO());

        if(!comp_cantidad.getText().equals(""))
        {
            try
            {
                int cantidad=Integer.parseInt(comp_cantidad.getText());
                String sasd=comp_total.getText();
                double valor = validacion.formatoMoneda().parse(comp_total.getText()).doubleValue();
                comp_total1.setValue(cantidad*valor);
            }
            catch (ParseException ex)
            {
                Logger.getLogger(F_Compras.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            comp_total1.setValue(0.00);
        }
    }//GEN-LAST:event_tabla2MouseClicked

    private void tabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla1MouseClicked
        // TODO add your handling code here:

        int fila=tabla1.getSelectedRow();
        proveedor = controladorProveedor.getById(tabla1.getValueAt(fila, 0).toString());
        cod_compras.setText(proveedor.getPER_NOMBRE());
        popProveedor.setVisible(false);
        //        popProveedor.setVisible(false);
    }//GEN-LAST:event_tabla1MouseClicked

    private void comp_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comp_nuevoActionPerformed
        // TODO add your handling code here:
        limpiarTodo();
    }//GEN-LAST:event_comp_nuevoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cod_compras;
    private javax.swing.JButton comp_agregar;
    private javax.swing.JButton comp_borrarfila;
    private javax.swing.JButton comp_buscar;
    private javax.swing.JButton comp_buscar2;
    private javax.swing.JCheckBox comp_cambiar;
    private javax.swing.JCheckBox comp_cambiar1;
    private javax.swing.JFormattedTextField comp_cantidad;
    private javax.swing.JFormattedTextField comp_costo;
    private javax.swing.JButton comp_guardar;
    private javax.swing.JFormattedTextField comp_iva;
    private javax.swing.JTextField comp_nombres;
    private javax.swing.JButton comp_nuevo;
    private javax.swing.JTextField comp_numcompra;
    private javax.swing.JComboBox<String> comp_opciones;
    private javax.swing.JButton comp_salir;
    private javax.swing.JFormattedTextField comp_sbtotal;
    private javax.swing.JFormattedTextField comp_stock;
    private javax.swing.JFormattedTextField comp_total;
    private javax.swing.JFormattedTextField comp_total1;
    private javax.swing.JFormattedTextField comp_totalpagar;
    private javax.swing.JTextField facturaNumero;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLayeredPane popProducto;
    private javax.swing.JLayeredPane popProveedor;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tabla1;
    private javax.swing.JTable tabla2;
    // End of variables declaration//GEN-END:variables

    private void limpiarTodo() {
        ctrComCab.EliminarTodo();        
        proveedor=new Proveedor();
        producto=new Producto();   
        cod_compras.setText(proveedor.getPER_NOMBRE());
        comp_nombres.setText(producto.getPRO_NOMBRE());
        comp_costo.setValue(producto.getPRO_PRECIO_COSTO());
        comp_stock.setValue(producto.getPRO_STOCK());
        comp_total.setValue(producto.getPRO_PRECIO_COSTO());
        
        if(!comp_cantidad.getText().equals(""))
        {
            int cantidad=Integer.parseInt(comp_cantidad.getText());
            double valor = producto.getPRO_PRECIO_COSTO();
            comp_total1.setValue(cantidad*valor);
        }
        else
        {
            comp_total1.setValue(0.00);
        }
        ctrComCab.getAll(tabla);
    }
//    private void convertirMayuscula(KeyEvent evt) 
//    {
//        char c=evt.getKeyChar();
//        if (Character.isLowerCase(c)) {
//            String cad=(""+c).toUpperCase();
//            c=cad.charAt(0);
//            evt.setKeyChar(c);
//        }
//    }

//    private void placeholder() {
//        String valor="";
//    try {
//        String tx=cod_compras.getText();
//           if(!tx.equals(""))
//           {
//               valor=controladorProveedor.buscarByNombre(cod_compras.getText()).getValueAt(0, 2).toString();  
//           }
//           
//          
//          
//        } catch (java.lang.ArrayIndexOutOfBoundsException e) 
//        {
//            valor="";
//        }
//        
//    int contValor=valor.length();
//    int contText=cod_compras.getText().length();
//    
//    
//    System.out.println("letras de busqueda "+contValor+" letras de input: "+contText);
//    if(contValor>=1)
//    {
//        cod_compras.setBackground(Color.decode("#CCFFCC"));
//        
//    }
//    else
//    {
//        cod_compras.setBackground(Color.decode("#FFCCCC"));
//    }
//      
////       placeholder.setText(valor);
////       placeholder.checkForPrompt();
//       this.repaint();
//    }

    
}
