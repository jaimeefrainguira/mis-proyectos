package Presentacion;

import clases.Categoria;
import clases.validaciones;
import controlador.controladorCategoria;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class F_Categoria extends javax.swing.JInternalFrame 
{

    public static String vf;
    Categoria categoria=new Categoria();
    controladorCategoria controladorCategoria = new controladorCategoria();
    validaciones validacion=new validaciones();

    public F_Categoria() 
    {
        
        initComponents();
        controladorCategoria.getAll(tabla);
        vf = ("vf");
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        busq_categ = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        PanelConPestania = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        tusuario_buscar = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        mensaje = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        bt_nuevo = new javax.swing.JButton();
        bt_modificar = new javax.swing.JButton();
        bt_guardar = new javax.swing.JButton();
        bt_salir = new javax.swing.JButton();

        setBorder(null);
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tusuario_buscarKeyTyped(evt);
            }
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
                .addComponent(tusuario_buscar)
                .addContainerGap())
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
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelConPestania.addTab("Buscar", jPanel1);

        mensaje.setText("Mensaje (Se cargaron los registros) ");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Tipo de Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 51, 255))); // NOI18N
        jPanel5.setName("CATEGORIA"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Código:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Descripcion:");

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(204, 204, 204));
        txtCodigo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtDescripcion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });

        jButton1.setText("Foto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(mensaje)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mensaje)
                .addContainerGap())
        );

        PanelConPestania.addTab("Nuevo / Editar", jPanel2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelConPestania)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelConPestania, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                .addContainerGap())
        );

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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_nuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_modificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_guardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_salir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        vf = null;
    }//GEN-LAST:event_formInternalFrameClosing

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
//        mensaje.setText("Se cargaron "+tabla.getRowCount()+" registros");
        controladorCategoria.buscar(tabla, tusuario_buscar.getText());
//        bloquearBotones();
//        controladorCategoria.anchoTablas(tabla);
    }//GEN-LAST:event_tusuario_buscarKeyReleased

    private void tablaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseReleased
        // TODO add your handling code here:
        bt_modificar.setEnabled(true);
    }//GEN-LAST:event_tablaMouseReleased

    private void PanelConPestaniaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_PanelConPestaniaStateChanged
        // TODO add your handling code here:
        bloquearBotones();
    }//GEN-LAST:event_PanelConPestaniaStateChanged

    private void bt_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_nuevoActionPerformed
        limpiarEntradas();
        PanelConPestania.setSelectedIndex(1);
    }//GEN-LAST:event_bt_nuevoActionPerformed

    private void bt_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_modificarActionPerformed
        // TODO add your handling code here:
        int fila=tabla.getSelectedRow();
        txtCodigo.setText(String.valueOf(tabla.getValueAt(fila, 0)));
        txtDescripcion.setText((String) tabla.getValueAt(fila, 1));
//        Icon a=(Icon) tabla.getValueAt(fila, 2);


        categoria=controladorCategoria.datos.categoria.get(fila);
//        JLabel lbl;
//            try
//            {
//                byte[] bi = categoria.getCAT_IMAGEN();
//                BufferedImage image = null;
//                InputStream in = new ByteArrayInputStream(bi);
//                image = ImageIO.read(in);
//                ImageIcon imgi = new ImageIcon(image.getScaledInstance(180, 180, 0));
//                lbl = new JLabel(imgi);
//            }
//            catch(Exception ex)
//            {
//                lbl = new JLabel("No imagen");                
//            }
            jLabel1.setIcon(categoria.getIcono(180, 180));
      
//        jLabel1.setLabelFor((JLabel) tabla.getValueAt(fila, 2));
//        jLabel1.add((JLabel) tabla.getValueAt(fila, 2));

        PanelConPestania.setSelectedIndex(1);
    }//GEN-LAST:event_bt_modificarActionPerformed

    private void bt_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_guardarActionPerformed
        // TODO add your handling code here:
                
        int id=0;
        if(!txtCodigo.getText().equals(""))
        {
            id=Integer.parseInt(txtCodigo.getText());
        }
        String descripcion=txtDescripcion.getText();
        
//        CAT_IMAGEN=null;        
//        File ruta = new File(txtruta.getText());
//        try
//        {
//            byte[] icono = new byte[(int) ruta.length()];
//            InputStream input = new FileInputStream(ruta);
//            input.read(icono);
//            CAT_IMAGEN=icono;
//        }
//        catch(Exception ex)
//        {
//            
//        }
        
        try
        {
            categoria=new Categoria(id, descripcion, categoria.getCAT_IMAGEN());
        }
        catch (java.lang.NullPointerException e)
        {
            categoria=new Categoria(id, descripcion, null);
        }

        if(txtCodigo.getText().equals(""))
        {
            if(txtDescripcion.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Se requiere una Descripción");
                txtDescripcion.requestFocus();
            }
            else
            {
                if(controladorCategoria.registrar(categoria))
                {
                    PanelConPestania.setSelectedIndex(0);
//                    tabla.setModel(controladorCategoria.getAll());
//                    limpiarEntradas();
//                    mensaje.setText("Se cargaron "+tabla.getRowCount()+" registros");
                }
            }
        }
        else
        {
//            int modifica=0;
            controladorCategoria.modificar(categoria);
            PanelConPestania.setSelectedIndex(0);
            controladorCategoria.getAll(tabla);
//            mensaje.setText("Se cargaron "+tabla.getRowCount()+" registros");
            limpiarEntradas();
        }
//        controladorCategoria.anchoTablas(tabla);
        controladorCategoria.getAll(tabla);
    }//GEN-LAST:event_bt_guardarActionPerformed

    private void bt_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salirActionPerformed
        vf = null;
        this.dispose();
    }//GEN-LAST:event_bt_salirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
        j.setFileFilter(fil);

        int s = j.showOpenDialog(this);
        if(s == JFileChooser.APPROVE_OPTION)
        {
            String ruta = j.getSelectedFile().getAbsolutePath();
//            txtruta.setText(ruta);            
                 
            File imagen = new File(ruta);
            try
            {
                byte[] icono = new byte[(int) imagen.length()];
                InputStream input = new FileInputStream(imagen);
                input.read(icono);
                categoria=new Categoria(0, null, icono);
            }
            catch(Exception ex)
            {
                categoria=new Categoria(0, null, null);
            }
            
        
            
//            JLabel lbl;
//            try
//            {
//                byte[] bi = new byte[(int) rut.length()];
////            byte[] icono = new byte[(int) ruta.length()];
//                InputStream input = new FileInputStream(ruta);
//                input.read(bi);
//                BufferedImage image = null;
//                InputStream in = new ByteArrayInputStream(bi);
//                image = ImageIO.read(in);
//                ImageIcon imgi = new ImageIcon(image.getScaledInstance(180, 180, 0));
//                lbl = new JLabel(imgi);
//                
//                
//                
//            }
//            catch(Exception ex)
//            {
//                lbl = new JLabel("No imagen");                
//            }
            
            jLabel1.setIcon(categoria.getIcono(180, 180));
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
        // TODO add your handling code here:
        validacion.mayusculas(evt);
    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void tusuario_buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tusuario_buscarKeyTyped
        // TODO add your handling code here:
        validacion.mayusculas(evt);
    }//GEN-LAST:event_tusuario_buscarKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane PanelConPestania;
    private javax.swing.JButton bt_guardar;
    private javax.swing.JButton bt_modificar;
    private javax.swing.JButton bt_nuevo;
    private javax.swing.JButton bt_salir;
    private javax.swing.ButtonGroup busq_categ;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
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
        categoria=null;
        jLabel1.setIcon(null);
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
}
