package Presentacion;
import clases.Usuario;
import controlador.controladorUsuario;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    Usuario usuario=new Usuario();
    controladorUsuario controladorUsuario=new controladorUsuario();

    public Login()throws IOException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(this.MAXIMIZED_BOTH);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        Login = new javax.swing.JLabel();
        User = new javax.swing.JLabel();
        Passw = new javax.swing.JLabel();
        Acept = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        user1 = new javax.swing.JTextField();
        passw1 = new javax.swing.JPasswordField();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(31, 65, 140));
        setName(""); // NOI18N
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(26, 42, 65));

        jcMousePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoLogin.png"))); // NOI18N
        jcMousePanel1.setVisibleLogo(false);

        Login.setBackground(new java.awt.Color(204, 204, 204));
        Login.setForeground(new java.awt.Color(204, 204, 204));
        Login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo_login.png"))); // NOI18N

        User.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        User.setForeground(new java.awt.Color(255, 255, 255));
        User.setText("USUARIO");

        Passw.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        Passw.setForeground(new java.awt.Color(255, 255, 255));
        Passw.setText("CONTRASEÑA");

        Acept.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        Acept.setForeground(new java.awt.Color(51, 51, 255));
        Acept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login_aceptar.png"))); // NOI18N
        Acept.setText("ACEPTAR");
        Acept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptActionPerformed(evt);
            }
        });

        Salir.setBackground(new java.awt.Color(204, 204, 204));
        Salir.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        Salir.setForeground(new java.awt.Color(255, 51, 51));
        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login_salir.png"))); // NOI18N
        Salir.setText("SALIR");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(255, 51, 51));

        user1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        user1.setToolTipText("");

        passw1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passw1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jcMousePanel1Layout = new javax.swing.GroupLayout(jcMousePanel1);
        jcMousePanel1.setLayout(jcMousePanel1Layout);
        jcMousePanel1Layout.setHorizontalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(User)
                    .addComponent(Passw)
                    .addComponent(Login)
                    .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(passw1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Salir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Acept, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                        .addComponent(user1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(50, 50, 50))
        );
        jcMousePanel1Layout.setVerticalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(Login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(User)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Passw)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passw1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(Acept)
                .addGap(17, 17, 17)
                .addComponent(Salir)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptActionPerformed
        usuario=(Usuario)controladorUsuario.iniciarSesion(user1.getText(), passw1.getText());
        try 
        {
            if (!usuario.getPER_NOMBRE().equals(null)) 
            {
                Menu lgn=new Menu (usuario);
                lgn.setVisible(true);
                dispose();
            }            
            
        }
        catch (java.lang.NullPointerException e) 
        {
            JOptionPane.showMessageDialog(null, "¡Usuario o clave incorrecto!","Alerta",JOptionPane.WARNING_MESSAGE);
            user1.setText(null);
            passw1.setText(null);
            user1.requestFocus();
        }
        
            
        
    }//GEN-LAST:event_AceptActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);

    }//GEN-LAST:event_SalirActionPerformed

    private void passw1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passw1KeyReleased
        // TODO add your handling code here:
        if (KeyEvent.VK_ENTER==evt.getKeyCode())
        {
          usuario=(Usuario) controladorUsuario.iniciarSesion(user1.getText(), passw1.getText());
        try 
        {
            if (!usuario.getPER_NOMBRE().equals(null)) 
            {
                Menu lgn=new Menu (usuario);
                lgn.setVisible(true);
                dispose();
            }            
            
        }
        catch (java.lang.NullPointerException e) 
        {
            JOptionPane.showMessageDialog(null, "¡Usuario o clave incorrecto!","Alerta",JOptionPane.WARNING_MESSAGE);
            user1.setText(null);
            passw1.setText(null);
            user1.requestFocus();
        }
        }
    }//GEN-LAST:event_passw1KeyReleased
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Login().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Acept;
    private javax.swing.JLabel Login;
    private javax.swing.JLabel Passw;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel User;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    private javax.swing.JPasswordField passw1;
    private javax.swing.JTextField user1;
    // End of variables declaration//GEN-END:variables
}
