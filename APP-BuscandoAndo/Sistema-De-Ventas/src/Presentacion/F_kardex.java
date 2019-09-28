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
import controlador.controladorKardex;
import controlador.controladorProducto;
import controlador.controladorProveedor;

public class F_kardex extends javax.swing.JInternalFrame {
    public static String vf;
    consultaProductos ventD;   
    controladorProducto ctrProductos=new controladorProducto();
    controladorKardex ctrKardex=new controladorKardex();
    Producto producto=new Producto();
    
    public F_kardex() {
        
        initComponents();
        cargaVentana();
        
        vf = ("vf");
        
        
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        comp_buscar2 = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
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
        jLabel3.setText("kardex");

        comp_buscar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N
        comp_buscar2.setToolTipText("");
        comp_buscar2.setBorder(null);
        comp_buscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comp_buscar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comp_buscar2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comp_buscar2)
                    .addComponent(jLabel3))
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
        jScrollPane4.setViewportView(tabla2);

        jLabel27.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel27.setText("Producto:");

        jLabel26.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel26.setText("Precio:");

        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setText("Stock:");

        jLayeredPane1.setLayer(jScrollPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel27, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel26, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel18, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel27)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel26)
                    .addComponent(jLabel18))
                .addGap(25, 25, 25)
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

    private void jLayeredPane1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLayeredPane1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLayeredPane1AncestorAdded

    private void jLayeredPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLayeredPane1MouseClicked
        // TODO add your handling code here:
//        popProveedor.setVisible(false);
//        popProducto.setVisible(false);
    }//GEN-LAST:event_jLayeredPane1MouseClicked

    private void comp_buscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comp_buscar2ActionPerformed
        // TODO add your handling code here:
        cargaVentana();

        
    }//GEN-LAST:event_comp_buscar2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton comp_buscar2;
    private javax.swing.JButton comp_salir;
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

    private void cargaVentana() {
        ventD = new consultaProductos(null,true);
        ventD.setVisible(true);

//        jLabel11.setText(String.valueOf(ventD.producto.getPRO_ID()));
        jLabel27.setText("Producto: "+ventD.producto.getPRO_NOMBRE());
//        jLabel8.setText(String.valueOf(ventD.producto.getPRO_PRECIO_VENTA()));
        jLabel18.setText("Stock: "+String.valueOf(ventD.producto.getPRO_STOCK()));
        jLabel26.setText("Precio Costo: "+String.valueOf(ventD.producto.getPRO_PRECIO_COSTO()));
//        jLabel10.setText(String.valueOf(Integer.parseInt(comp_cantidad.getText())*ventD.producto.getPRO_PRECIO_VENTA()));
        ctrKardex.getAll(tabla2,ventD.producto.getPRO_ID());
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
