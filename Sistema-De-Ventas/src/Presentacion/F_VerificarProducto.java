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

public class F_VerificarProducto extends javax.swing.JInternalFrame {
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
    public F_VerificarProducto(Usuario usu) {
        
        initComponents();
        
        validacion.moneda();
      
        comp_costo.setFormatterFactory(validacion.moneda());
//        comp_total.setFormatterFactory(validacion.moneda());
//        comp_total1.setFormatterFactory(validacion.moneda());
//        comp_sbtotal.setFormatterFactory(validacion.moneda());
//        comp_iva.setFormatterFactory(validacion.moneda());
//        comp_totalpagar.setFormatterFactory(validacion.moneda());
//       
//        popProveedor.setVisible(false);
//       popProducto.setVisible(false);
       
       
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
        jLabel3 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();
        comp_nombres = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        comp_stock = new javax.swing.JFormattedTextField();
        comp_costo = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
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

        jLabel3.setFont(new java.awt.Font("Bebas Neue", 1, 36)); // NOI18N
        jLabel3.setText("Verificar producto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
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

        jLabel27.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel27.setText("Producto:");

        jLabel26.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel26.setText("Precio:");

        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setText("Stock:");

        comp_stock.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        comp_stock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                comp_stockKeyReleased(evt);
            }
        });

        comp_costo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLayeredPane1.setLayer(jScrollPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(comp_nombres, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel27, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel26, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel18, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(comp_stock, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(comp_costo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addGap(333, 333, 333)
                                .addComponent(jLabel26))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                        .addGap(66, 66, 66)
                                        .addComponent(comp_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel27))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel27))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel18))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(comp_stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(comp_costo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(comp_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel26)))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(comp_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
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
                        .addComponent(jLayeredPane1)
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
                        .addComponent(jLayeredPane1))
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

    private void comp_stockKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comp_stockKeyReleased
        // TODO add your handling code here:
//        popProveedor.setLocation(cod_compras.getLocation().x, cod_compras.getLocation().y);
    }//GEN-LAST:event_comp_stockKeyReleased

    private void comp_nombresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comp_nombresKeyReleased
        // TODO add your handling code here:

//        if(comp_nombres.getText().equals(""))
//        {
//            popProducto.setVisible(false);
//        }
//        else
//        {
//            popProducto.setVisible(true);
//        }
        ctrProductos.buscar(tabla2, comp_nombres.getText());
    }//GEN-LAST:event_comp_nombresKeyReleased

    private void jLayeredPane1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLayeredPane1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLayeredPane1AncestorAdded

    private void comp_nombresFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comp_nombresFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_comp_nombresFocusLost

    private void tabla2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla2MouseClicked
        // TODO add your handling code here:
//        popProducto.setVisible(false);
        int fila=tabla2.getSelectedRow();
        producto = ctrProductos.buscarById(tabla2.getValueAt(fila, 0).toString());

        comp_nombres.setText(producto.getPRO_NOMBRE());
        comp_costo.setValue(producto.getPRO_PRECIO_VENTA());
        comp_stock.setValue(producto.getPRO_STOCK());
//        comp_total.setValue(producto.getPRO_PRECIO_COSTO());

//        if(!comp_cantidad.getText().equals(""))
//        {
//            try
//            {
//                int cantidad=Integer.parseInt(comp_cantidad.getText());
//                String sasd=comp_total.getText();
//                double valor = validacion.formatoMoneda().parse(comp_total.getText()).doubleValue();
//                comp_total1.setValue(cantidad*valor);
//            }
//            catch (ParseException ex)
//            {
//                Logger.getLogger(F_VerificarProducto.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        else
//        {
//            comp_total1.setValue(0.00);
//        }
    }//GEN-LAST:event_tabla2MouseClicked

    private void jLayeredPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLayeredPane1MouseClicked
        // TODO add your handling code here:
//        popProveedor.setVisible(false);
//        popProducto.setVisible(false);
    }//GEN-LAST:event_jLayeredPane1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField comp_costo;
    private javax.swing.JTextField comp_nombres;
    private javax.swing.JButton comp_salir;
    private javax.swing.JFormattedTextField comp_stock;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tabla2;
    // End of variables declaration//GEN-END:variables
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
