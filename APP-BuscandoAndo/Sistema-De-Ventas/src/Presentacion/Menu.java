package Presentacion;
import clases.TipoUsuario;
import clases.Usuario;
import clases.validaciones;
import controlador.controladorTipoUsuario;
import controlador.controladorUsuario;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class Menu extends javax.swing.JFrame 
{
    public Usuario usuario=new Usuario();
    controladorUsuario controladorUsuario=new controladorUsuario();
    TipoUsuario tipoUsuario=new TipoUsuario();
    controladorTipoUsuario controladorTipoUsuario=new controladorTipoUsuario();
    String vf;
    
    Calendar c2 = new GregorianCalendar(); 
        validaciones validacion=new validaciones();
    
    public Menu(Usuario usu)
    {
        
        
        this.usuario=usu;
        initComponents();

       
        this.setLocationRelativeTo(null);
//        this.setExtendedState(this.MAXIMIZED_BOTH);
        
//        jLabel2.setText(usuario.getPER_NOMBRE());
        
        
        bolquearBotones();       
       
              
        
        jLabel5.setText(validacion.getFechaLarga());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateTime1 = new org.joda.time.DateTime();
        pgsLabelUI1 = new com.pagosoft.plaf.PgsLabelUI();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        body = new javax.swing.JPanel();
        ventanas = new javax.swing.JPanel();
        escritorio = new javax.swing.JDesktopPane();
        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        menu = new javax.swing.JPanel();
        buttonTask1 = new org.edisoncor.gui.button.ButtonTask();
        buttonTask2 = new org.edisoncor.gui.button.ButtonTask();
        buttonTask3 = new org.edisoncor.gui.button.ButtonTask();
        buttonTask4 = new org.edisoncor.gui.button.ButtonTask();
        buttonTask5 = new org.edisoncor.gui.button.ButtonTask();
        buttonTask6 = new org.edisoncor.gui.button.ButtonTask();
        buttonTask7 = new org.edisoncor.gui.button.ButtonTask();
        footer = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        hora1 = new Reloj.Hora();
        jLabel5 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        MenuBar1 = new javax.swing.JMenuBar();
        Menu_archivo = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        Menu_cerrar = new javax.swing.JMenuItem();
        Menu_almacen = new javax.swing.JMenu();
        Menu_prod = new javax.swing.JMenuItem();
        Menu_merc = new javax.swing.JMenuItem();
        Menu_compras = new javax.swing.JMenu();
        bt_compras = new javax.swing.JMenuItem();
        bt_Proveedores = new javax.swing.JMenuItem();
        Menu_ventas = new javax.swing.JMenu();
        bt_ventas = new javax.swing.JMenuItem();
        bt_Clientes = new javax.swing.JMenuItem();
        bt_verificar_producto = new javax.swing.JMenuItem();
        Menu_consulta = new javax.swing.JMenu();
        bt_venta_Realizada = new javax.swing.JMenuItem();
        bt_Venta_detallada = new javax.swing.JMenuItem();
        bt_estadistica_mensual = new javax.swing.JMenuItem();
        bt_compra_Realizada = new javax.swing.JMenuItem();
        bt_compra_detallada = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        Menu_mant = new javax.swing.JMenu();
        Menu_admin = new javax.swing.JMenu();
        bt_usuarios = new javax.swing.JMenuItem();
        bt_tipo_usuario = new javax.swing.JMenuItem();
        Menu_st = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        Menu_anular = new javax.swing.JMenu();
        bt_anular_venta = new javax.swing.JMenuItem();
        bt_anular_compra = new javax.swing.JMenuItem();
        Menu_herram = new javax.swing.JMenu();
        bt_cambira_contrase = new javax.swing.JMenuItem();
        bt_usuarios_nose = new javax.swing.JMenuItem();
        bt_respaldar_bd = new javax.swing.JMenuItem();
        bt_Restaura_bd = new javax.swing.JMenuItem();
        Menu_ayuda = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1024, 650));
        setName("PRINCIPAL MENU"); // NOI18N

        escritorio.setBackground(new java.awt.Color(238, 238, 238));
        escritorio.setToolTipText("");

        jcMousePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LogoSotf.png"))); // NOI18N
        jcMousePanel1.setPreferredSize(new java.awt.Dimension(300, 300));
        jcMousePanel1.setVisibleLogo(false);

        javax.swing.GroupLayout jcMousePanel1Layout = new javax.swing.GroupLayout(jcMousePanel1);
        jcMousePanel1.setLayout(jcMousePanel1Layout);
        jcMousePanel1Layout.setHorizontalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jcMousePanel1Layout.setVerticalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        escritorio.setLayer(jcMousePanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addContainerGap(224, Short.MAX_VALUE)
                .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(224, Short.MAX_VALUE))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ventanasLayout = new javax.swing.GroupLayout(ventanas);
        ventanas.setLayout(ventanasLayout);
        ventanasLayout.setHorizontalGroup(
            ventanasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(escritorio)
                .addContainerGap())
        );
        ventanasLayout.setVerticalGroup(
            ventanasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(escritorio)
                .addContainerGap())
        );

        menu.setBackground(new java.awt.Color(26, 42, 65));

        buttonTask1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buttonTask1.setForeground(new java.awt.Color(255, 255, 255));
        buttonTask1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/002Clientes.png"))); // NOI18N
        buttonTask1.setText("Clientes");
        buttonTask1.setDescription("Crear, Actualizar");
        buttonTask1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTask1ActionPerformed(evt);
            }
        });

        buttonTask2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buttonTask2.setForeground(new java.awt.Color(255, 255, 255));
        buttonTask2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/001ventas.png"))); // NOI18N
        buttonTask2.setText("Ventas");
        buttonTask2.setDescription("Facturación");
        buttonTask2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTask2ActionPerformed(evt);
            }
        });

        buttonTask3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buttonTask3.setForeground(new java.awt.Color(255, 255, 255));
        buttonTask3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/003Productos.png"))); // NOI18N
        buttonTask3.setText("Productos");
        buttonTask3.setDescription("Consultas");
        buttonTask3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTask3ActionPerformed(evt);
            }
        });

        buttonTask4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buttonTask4.setForeground(new java.awt.Color(255, 255, 255));
        buttonTask4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/004Caja.png"))); // NOI18N
        buttonTask4.setText("Caja");
        buttonTask4.setDescription("Ingresos, Egresos");
        buttonTask4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTask4ActionPerformed(evt);
            }
        });

        buttonTask5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buttonTask5.setForeground(new java.awt.Color(255, 255, 255));
        buttonTask5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/005Usuario.png"))); // NOI18N
        buttonTask5.setText("Usuarios");
        buttonTask5.setDescription("Crear, Actualizar");
        buttonTask5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTask5ActionPerformed(evt);
            }
        });

        buttonTask6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buttonTask6.setForeground(new java.awt.Color(255, 255, 255));
        buttonTask6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/006Consulta.png"))); // NOI18N
        buttonTask6.setText("Verificar Producto");
        buttonTask6.setDescription("Disponibilidad, Stock");
        buttonTask6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTask6ActionPerformed(evt);
            }
        });

        buttonTask7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buttonTask7.setForeground(new java.awt.Color(255, 255, 255));
        buttonTask7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/006Consulta.png"))); // NOI18N
        buttonTask7.setText("Consultas");
        buttonTask7.setDescription("Visual, Detalladas");
        buttonTask7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTask7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonTask2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonTask1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonTask3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonTask4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonTask5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonTask6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonTask7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(buttonTask2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonTask1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonTask3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonTask4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonTask5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonTask7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonTask6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ventanas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ventanas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        footer.setBackground(new java.awt.Color(21, 37, 56));
        footer.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(172, 172, 172));
        jLabel1.setText("Usuario:");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(172, 172, 172));
        jLabel2.setText("jLabel2");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(172, 172, 172));
        jLabel3.setText("Cargo:");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(172, 172, 172));
        jLabel4.setText("jLabel4");

        hora1.setForeground(new java.awt.Color(172, 172, 172));
        hora1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(172, 172, 172));
        jLabel5.setText("DD/MM/AAAA");

        jLabel17.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(172, 172, 172));
        jLabel17.setText("Fecha:");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(172, 172, 172));
        jLabel6.setText("Hora:");

        javax.swing.GroupLayout footerLayout = new javax.swing.GroupLayout(footer);
        footer.setLayout(footerLayout);
        footerLayout.setHorizontalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hora1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        footerLayout.setVerticalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(jLabel5))
                    .addGroup(footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(hora1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addContainerGap())
        );

        MenuBar1.setBackground(new java.awt.Color(21, 37, 56));
        MenuBar1.setBorder(null);
        MenuBar1.setBorderPainted(false);
        MenuBar1.setPreferredSize(new java.awt.Dimension(971, 30));

        Menu_archivo.setForeground(new java.awt.Color(172, 172, 172));
        Menu_archivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logoBarra.png"))); // NOI18N
        Menu_archivo.setText("Technologiescell");
        Menu_archivo.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N

        jMenuItem2.setText("Cerrar sesión");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        Menu_archivo.add(jMenuItem2);

        Menu_cerrar.setText("Salir");
        Menu_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_cerrarActionPerformed(evt);
            }
        });
        Menu_archivo.add(Menu_cerrar);

        MenuBar1.add(Menu_archivo);

        Menu_almacen.setForeground(new java.awt.Color(172, 172, 172));
        Menu_almacen.setText("Almacén");
        Menu_almacen.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N

        Menu_prod.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        Menu_prod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/producto.png"))); // NOI18N
        Menu_prod.setText("Producto");
        Menu_prod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu_prodMouseClicked(evt);
            }
        });
        Menu_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_prodActionPerformed(evt);
            }
        });
        Menu_almacen.add(Menu_prod);

        Menu_merc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        Menu_merc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mercaderia.png"))); // NOI18N
        Menu_merc.setText("Categoría");
        Menu_merc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu_mercMouseClicked(evt);
            }
        });
        Menu_merc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_mercActionPerformed(evt);
            }
        });
        Menu_almacen.add(Menu_merc);

        MenuBar1.add(Menu_almacen);

        Menu_compras.setForeground(new java.awt.Color(172, 172, 172));
        Menu_compras.setText("Compras");
        Menu_compras.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N

        bt_compras.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        bt_compras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/comp_compra.png"))); // NOI18N
        bt_compras.setText("Compras");
        bt_compras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_comprasActionPerformed(evt);
            }
        });
        Menu_compras.add(bt_compras);

        bt_Proveedores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        bt_Proveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/proveedores.png"))); // NOI18N
        bt_Proveedores.setText("Proveedores");
        bt_Proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ProveedoresActionPerformed(evt);
            }
        });
        Menu_compras.add(bt_Proveedores);

        MenuBar1.add(Menu_compras);

        Menu_ventas.setForeground(new java.awt.Color(172, 172, 172));
        Menu_ventas.setText("Ventas");
        Menu_ventas.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N

        bt_ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ventas.png"))); // NOI18N
        bt_ventas.setText("Venta");
        bt_ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ventasActionPerformed(evt);
            }
        });
        Menu_ventas.add(bt_ventas);

        bt_Clientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        bt_Clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clientes.png"))); // NOI18N
        bt_Clientes.setText("Clientes");
        bt_Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ClientesActionPerformed(evt);
            }
        });
        Menu_ventas.add(bt_Clientes);

        bt_verificar_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/verificar.png"))); // NOI18N
        bt_verificar_producto.setText("Verificar Producto");
        bt_verificar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_verificar_productoActionPerformed(evt);
            }
        });
        Menu_ventas.add(bt_verificar_producto);

        MenuBar1.add(Menu_ventas);

        Menu_consulta.setForeground(new java.awt.Color(172, 172, 172));
        Menu_consulta.setText("Consulta");
        Menu_consulta.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N

        bt_venta_Realizada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/vent_realizada.png"))); // NOI18N
        bt_venta_Realizada.setText("Ventas Realizadas");
        bt_venta_Realizada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_venta_RealizadaActionPerformed(evt);
            }
        });
        Menu_consulta.add(bt_venta_Realizada);

        bt_Venta_detallada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/vent_detallada.png"))); // NOI18N
        bt_Venta_detallada.setText("Ventas Detalladas");
        bt_Venta_detallada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Venta_detalladaActionPerformed(evt);
            }
        });
        Menu_consulta.add(bt_Venta_detallada);

        bt_estadistica_mensual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/estadistica.png"))); // NOI18N
        bt_estadistica_mensual.setText("Estadística Mensual");
        bt_estadistica_mensual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_estadistica_mensualActionPerformed(evt);
            }
        });
        Menu_consulta.add(bt_estadistica_mensual);

        bt_compra_Realizada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/comp_realizada.png"))); // NOI18N
        bt_compra_Realizada.setText("Compras Realizadas");
        bt_compra_Realizada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_compra_RealizadaActionPerformed(evt);
            }
        });
        Menu_consulta.add(bt_compra_Realizada);

        bt_compra_detallada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/comp_detallada.png"))); // NOI18N
        bt_compra_detallada.setText("Compras Detalladas");
        bt_compra_detallada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_compra_detalladaActionPerformed(evt);
            }
        });
        Menu_consulta.add(bt_compra_detallada);

        jMenuItem3.setText("kardex");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        Menu_consulta.add(jMenuItem3);

        MenuBar1.add(Menu_consulta);

        Menu_mant.setForeground(new java.awt.Color(172, 172, 172));
        Menu_mant.setText("Mantenimiento");
        Menu_mant.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N

        Menu_admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/admin.png"))); // NOI18N
        Menu_admin.setText("Administracion");

        bt_usuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/empleados.png"))); // NOI18N
        bt_usuarios.setText("Usuarios");
        bt_usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_usuariosActionPerformed(evt);
            }
        });
        Menu_admin.add(bt_usuarios);

        bt_tipo_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tipo_usuario.png"))); // NOI18N
        bt_tipo_usuario.setText("Tipo de usuario");
        bt_tipo_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tipo_usuarioActionPerformed(evt);
            }
        });
        Menu_admin.add(bt_tipo_usuario);

        Menu_mant.add(Menu_admin);

        MenuBar1.add(Menu_mant);

        Menu_st.setForeground(new java.awt.Color(172, 172, 172));
        Menu_st.setText("Servicio Tecnico");
        Menu_st.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        Menu_st.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_stActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Orden de Reparación");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Menu_st.add(jMenuItem1);

        MenuBar1.add(Menu_st);

        Menu_anular.setForeground(new java.awt.Color(172, 172, 172));
        Menu_anular.setText("Anulaciones");
        Menu_anular.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        Menu_anular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_anularActionPerformed(evt);
            }
        });

        bt_anular_venta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/anul_ventas.png"))); // NOI18N
        bt_anular_venta.setText("Anular venta");
        bt_anular_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_anular_ventaActionPerformed(evt);
            }
        });
        Menu_anular.add(bt_anular_venta);

        bt_anular_compra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/anul_compras.png"))); // NOI18N
        bt_anular_compra.setText("Anular compra");
        bt_anular_compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_anular_compraActionPerformed(evt);
            }
        });
        Menu_anular.add(bt_anular_compra);

        MenuBar1.add(Menu_anular);

        Menu_herram.setForeground(new java.awt.Color(172, 172, 172));
        Menu_herram.setText("Herramienta");
        Menu_herram.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N

        bt_cambira_contrase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user_clave.png"))); // NOI18N
        bt_cambira_contrase.setText("Cambiar contraseña");
        bt_cambira_contrase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cambira_contraseActionPerformed(evt);
            }
        });
        Menu_herram.add(bt_cambira_contrase);

        bt_usuarios_nose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/empleados.png"))); // NOI18N
        bt_usuarios_nose.setText("Usuarios");
        Menu_herram.add(bt_usuarios_nose);

        bt_respaldar_bd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardar db.png"))); // NOI18N
        bt_respaldar_bd.setText("Respaldar BD");
        Menu_herram.add(bt_respaldar_bd);

        bt_Restaura_bd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/restaurar db.png"))); // NOI18N
        bt_Restaura_bd.setText("Restaurar BD");
        Menu_herram.add(bt_Restaura_bd);

        MenuBar1.add(Menu_herram);

        Menu_ayuda.setForeground(new java.awt.Color(172, 172, 172));
        Menu_ayuda.setText("Ayuda");
        Menu_ayuda.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N

        jMenuItem4.setText("jMenuItem4");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        Menu_ayuda.add(jMenuItem4);

        MenuBar1.add(Menu_ayuda);

        setJMenuBar(MenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(footer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTask1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTask1ActionPerformed
        // TODO add your handling code here:
        
       ventanasInternas("Clientes");
    }//GEN-LAST:event_buttonTask1ActionPerformed

    private void buttonTask2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTask2ActionPerformed
        // TODO add your handling code here:
        ventanasInternas("Ventas");
    }//GEN-LAST:event_buttonTask2ActionPerformed

    private void buttonTask3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTask3ActionPerformed
        // TODO add your handling code here:
        
        vf = F_Producto.vf;
       if(vf==null){
            F_Producto prod = new F_Producto();
            setRootPaneCheckingEnabled(false);
  javax.swing.plaf.InternalFrameUI ifu= prod.getUI();
  ((javax.swing.plaf.basic.BasicInternalFrameUI)ifu).setNorthPane(null); 
            escritorio.add(prod);
            prod.setVisible(true);
            try {
               prod.setMaximum(true);
           } catch (PropertyVetoException ex) {
               Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       else{
           JOptionPane.showMessageDialog(null,"Ventana Producto esta abierta!!!");
       }
    }//GEN-LAST:event_buttonTask3ActionPerformed

    private void buttonTask4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTask4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonTask4ActionPerformed

    private void buttonTask5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTask5ActionPerformed
        // TODO add your handling code here:
        vf = F_Usuario.vf;
        if(vf==null){
            F_Usuario empld = new F_Usuario();
            escritorio.add(empld);
            empld.setVisible(true);
           try {
               empld.setMaximum(true);
           } catch (PropertyVetoException ex) {
               Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        else{
            JOptionPane.showMessageDialog(null,"Ventana Empleado esta abierta!!!");
        }
    }//GEN-LAST:event_buttonTask5ActionPerformed

    private void buttonTask6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTask6ActionPerformed
        // TODO add your handling code here:
        vf = F_VerificarProducto.vf;
       if(vf==null){
            F_VerificarProducto prod = new F_VerificarProducto(usuario);
            setRootPaneCheckingEnabled(false);
  javax.swing.plaf.InternalFrameUI ifu= prod.getUI();
  ((javax.swing.plaf.basic.BasicInternalFrameUI)ifu).setNorthPane(null); 
            escritorio.add(prod);
            prod.setVisible(true);
            try {
               prod.setMaximum(true);
           } catch (PropertyVetoException ex) {
               Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       else{
           JOptionPane.showMessageDialog(null,"Ventana Producto esta abierta!!!");
       }
    }//GEN-LAST:event_buttonTask6ActionPerformed

    private void bt_cambira_contraseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cambira_contraseActionPerformed
        // TODO add your handling code here:
        cambioContrasenia ventD = new cambioContrasenia(null,true,usuario);
        ventD.setVisible(true);
    }//GEN-LAST:event_bt_cambira_contraseActionPerformed

    private void Menu_anularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_anularActionPerformed

    }//GEN-LAST:event_Menu_anularActionPerformed

    private void bt_anular_compraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_anular_compraActionPerformed
        vf = F_AnularCompra.vf;

        if(vf==null){
            F_AnularCompra anular = new F_AnularCompra();
            setRootPaneCheckingEnabled(false);
            javax.swing.plaf.InternalFrameUI ifu= anular.getUI();
            ((javax.swing.plaf.basic.BasicInternalFrameUI)ifu).setNorthPane(null);
            escritorio.add(anular);
            anular.setVisible(true);
            try {
                anular.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Ventana Anular Compras esta abierta!!!");
        }
    }//GEN-LAST:event_bt_anular_compraActionPerformed

    private void bt_anular_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_anular_ventaActionPerformed
        vf = F_AnularVenta.vf;

        if(vf==null){
            F_AnularVenta venta = new F_AnularVenta();
            escritorio.add(venta);
            venta.setVisible(true);
            try {
                venta.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Ventana Anular Venta esta abierta!!!");
        }
    }//GEN-LAST:event_bt_anular_ventaActionPerformed

    private void bt_tipo_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_tipo_usuarioActionPerformed
        vf = F_TipoUsuario.vf;

        if(vf==null){
            F_TipoUsuario tpusuar = new F_TipoUsuario();
            escritorio.add(tpusuar);
            tpusuar.setVisible(true);
            try {
                tpusuar.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Ventana Usuario esta abierta!!!");
        }
    }//GEN-LAST:event_bt_tipo_usuarioActionPerformed

    private void bt_usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_usuariosActionPerformed
        vf = F_Usuario.vf;
        if(vf==null){
            F_Usuario empld = new F_Usuario();
            escritorio.add(empld);
            empld.setVisible(true);
            try {
                empld.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Ventana Empleado esta abierta!!!");
        }
    }//GEN-LAST:event_bt_usuariosActionPerformed

    private void bt_compra_detalladaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_compra_detalladaActionPerformed
        // TODO add your handling code here:
        vf = F_ComprasDetalladas.vf;
        if(vf==null){
            F_ComprasDetalladas empld = new F_ComprasDetalladas();
            escritorio.add(empld);
            empld.setVisible(true);
            try {
                empld.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Ventana Empleado esta abierta!!!");
        }
    }//GEN-LAST:event_bt_compra_detalladaActionPerformed

    private void bt_compra_RealizadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_compra_RealizadaActionPerformed
        // TODO add your handling code here:
        vf = F_ComprasRealizadas.vf;

        if(vf==null){
            F_ComprasRealizadas ventana = new F_ComprasRealizadas();
            setRootPaneCheckingEnabled(false);
            javax.swing.plaf.InternalFrameUI ifu= ventana.getUI();
            ((javax.swing.plaf.basic.BasicInternalFrameUI)ifu).setNorthPane(null);
            escritorio.add(ventana);
            ventana.setVisible(true);
            try
            {
                ventana.setMaximum(true);
            }
            catch (PropertyVetoException ex)
            {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Ventana Anular Venta esta abierta!!!");
        }
    }//GEN-LAST:event_bt_compra_RealizadaActionPerformed

    private void bt_estadistica_mensualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_estadistica_mensualActionPerformed
        // TODO add your handling code here:
        vf = F_EstadisticaMensual.vf;
        if(vf==null){
            F_EstadisticaMensual empld = new F_EstadisticaMensual();
            escritorio.add(empld);
            empld.setVisible(true);
            try {
                empld.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Ventana FEstadistica Mensual esta abierta!!!");
        }

    }//GEN-LAST:event_bt_estadistica_mensualActionPerformed

    private void bt_Venta_detalladaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Venta_detalladaActionPerformed
        // TODO add your handling code here:
        vf = F_VentasDetalladas.vf;
        if(vf==null){
            F_VentasDetalladas empld = new F_VentasDetalladas();
            escritorio.add(empld);
            empld.setVisible(true);
            try {
                empld.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Ventana Empleado esta abierta!!!");
        }
    }//GEN-LAST:event_bt_Venta_detalladaActionPerformed

    private void bt_venta_RealizadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_venta_RealizadaActionPerformed
        // TODO add your handling code here:
        vf = F_VentasRealizadas.vf;

        if(vf==null){
            F_VentasRealizadas ventana = new F_VentasRealizadas();
            setRootPaneCheckingEnabled(false);
            javax.swing.plaf.InternalFrameUI ifu= ventana.getUI();
            ((javax.swing.plaf.basic.BasicInternalFrameUI)ifu).setNorthPane(null);
            escritorio.add(ventana);
            ventana.setVisible(true);
            try
            {
                ventana.setMaximum(true);
            }
            catch (PropertyVetoException ex)
            {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Ventana Anular Venta esta abierta!!!");
        }
    }//GEN-LAST:event_bt_venta_RealizadaActionPerformed

    private void bt_verificar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_verificar_productoActionPerformed
        vf = F_VerificarProducto.vf;
       if(vf==null){
            F_VerificarProducto prod = new F_VerificarProducto(usuario);
            setRootPaneCheckingEnabled(false);
  javax.swing.plaf.InternalFrameUI ifu= prod.getUI();
  ((javax.swing.plaf.basic.BasicInternalFrameUI)ifu).setNorthPane(null); 
            escritorio.add(prod);
            prod.setVisible(true);
            try {
               prod.setMaximum(true);
           } catch (PropertyVetoException ex) {
               Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       else{
           JOptionPane.showMessageDialog(null,"Ventana Producto esta abierta!!!");
       }
    }//GEN-LAST:event_bt_verificar_productoActionPerformed

    private void bt_ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ClientesActionPerformed

        ventanasInternas("Clientes");
    }//GEN-LAST:event_bt_ClientesActionPerformed

    private void bt_ventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ventasActionPerformed
        // TODO add your handling code here:
        ventanasInternas("Ventas") ;

    }//GEN-LAST:event_bt_ventasActionPerformed

    private void bt_ProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ProveedoresActionPerformed

        vf = F_Proveedores.vf;
        if(vf==null){
            F_Proveedores provd = new F_Proveedores();
            setRootPaneCheckingEnabled(false);
            javax.swing.plaf.InternalFrameUI ifu= provd.getUI();
            ((javax.swing.plaf.basic.BasicInternalFrameUI)ifu).setNorthPane(null);
            escritorio.add(provd);
            provd.setVisible(true);
            try {
                provd.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Ventana Proveedores esta abierta!!!");
        }
    }//GEN-LAST:event_bt_ProveedoresActionPerformed

    private void bt_comprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_comprasActionPerformed
        vf = F_Compras.vf;

        if(vf==null){
            F_Compras comp = new F_Compras(usuario);
            setRootPaneCheckingEnabled(false);
            javax.swing.plaf.InternalFrameUI ifu= comp.getUI();
            ((javax.swing.plaf.basic.BasicInternalFrameUI)ifu).setNorthPane(null);
            escritorio.add(comp);
            comp.setVisible(true);
            try {
                comp.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        else{
            JOptionPane.showMessageDialog(null,"Ventana Compras esta abierta!!!");
        }
    }//GEN-LAST:event_bt_comprasActionPerformed

    private void Menu_mercActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_mercActionPerformed
        vf = F_Categoria.vf;

        if(vf==null){
            F_Categoria catg = new F_Categoria();
            setRootPaneCheckingEnabled(false);
            javax.swing.plaf.InternalFrameUI ifu= catg.getUI();
            ((javax.swing.plaf.basic.BasicInternalFrameUI)ifu).setNorthPane(null);
            escritorio.add(catg);
            catg.setVisible(true);
            try {
                catg.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Ventana Mercadería esta abierta!!!");
        }

    }//GEN-LAST:event_Menu_mercActionPerformed

    private void Menu_mercMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu_mercMouseClicked

    }//GEN-LAST:event_Menu_mercMouseClicked

    private void Menu_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_prodActionPerformed
        ventanasInternas("Productos") ;

    }//GEN-LAST:event_Menu_prodActionPerformed

    private void Menu_prodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu_prodMouseClicked

    }//GEN-LAST:event_Menu_prodMouseClicked

    private void Menu_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_cerrarActionPerformed
        JOptionPane.showMessageDialog(null,"Desea salir del Sistema" );
        System.exit(0);
    }//GEN-LAST:event_Menu_cerrarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            // TODO add your handling code here:
            Login formIntro=new Login();
            formIntro.setVisible(true);

            F_Cliente.vf=null;
            F_Ventas.vf=null;
            F_Ventas.vf=null;F_VerificarProducto.vf=null;
            F_Cliente.vf=null;
            F_AnularVenta.vf=null;
            F_AnularCompra.vf=null;
            F_Compras.vf=null;
            F_TipoUsuario.vf=null;
            F_Proveedores.vf=null;
            F_Usuario.vf=null;
            F_Producto.vf=null;
            F_Categoria.vf=null;

            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void buttonTask7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTask7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonTask7ActionPerformed

    private void Menu_stActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_stActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Menu_stActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        vf = F_ServicioTecnico.vf;
        if(vf==null){
            F_ServicioTecnico empld = new F_ServicioTecnico();
            escritorio.add(empld);
            empld.setVisible(true);
            try {
                empld.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Ventana Empleado esta abierta!!!");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:vf = F_ComprasDetalladas.vf;
        if(vf==null){            
            F_kardex empld = new F_kardex();
            escritorio.add(empld);
            empld.setVisible(true);
            try {
                empld.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Ventana Empleado esta abierta!!!");
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        bolquearBotones();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {        
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            private Usuario usuario;
            public void run() 
            {
                new Menu(usuario).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar1;
    private javax.swing.JMenu Menu_admin;
    private javax.swing.JMenu Menu_almacen;
    private javax.swing.JMenu Menu_anular;
    private javax.swing.JMenu Menu_archivo;
    private javax.swing.JMenu Menu_ayuda;
    private javax.swing.JMenuItem Menu_cerrar;
    private javax.swing.JMenu Menu_compras;
    private javax.swing.JMenu Menu_consulta;
    private javax.swing.JMenu Menu_herram;
    private javax.swing.JMenu Menu_mant;
    private javax.swing.JMenuItem Menu_merc;
    private javax.swing.JMenuItem Menu_prod;
    private javax.swing.JMenu Menu_st;
    private javax.swing.JMenu Menu_ventas;
    private javax.swing.JPanel body;
    private javax.swing.JMenuItem bt_Clientes;
    private javax.swing.JMenuItem bt_Proveedores;
    private javax.swing.JMenuItem bt_Restaura_bd;
    private javax.swing.JMenuItem bt_Venta_detallada;
    private javax.swing.JMenuItem bt_anular_compra;
    private javax.swing.JMenuItem bt_anular_venta;
    private javax.swing.JMenuItem bt_cambira_contrase;
    private javax.swing.JMenuItem bt_compra_Realizada;
    private javax.swing.JMenuItem bt_compra_detallada;
    private javax.swing.JMenuItem bt_compras;
    private javax.swing.JMenuItem bt_estadistica_mensual;
    private javax.swing.JMenuItem bt_respaldar_bd;
    private javax.swing.JMenuItem bt_tipo_usuario;
    private javax.swing.JMenuItem bt_usuarios;
    private javax.swing.JMenuItem bt_usuarios_nose;
    private javax.swing.JMenuItem bt_venta_Realizada;
    private javax.swing.JMenuItem bt_ventas;
    private javax.swing.JMenuItem bt_verificar_producto;
    private org.edisoncor.gui.button.ButtonTask buttonTask1;
    private org.edisoncor.gui.button.ButtonTask buttonTask2;
    private org.edisoncor.gui.button.ButtonTask buttonTask3;
    private org.edisoncor.gui.button.ButtonTask buttonTask4;
    private org.edisoncor.gui.button.ButtonTask buttonTask5;
    private org.edisoncor.gui.button.ButtonTask buttonTask6;
    private org.edisoncor.gui.button.ButtonTask buttonTask7;
    private org.joda.time.DateTime dateTime1;
    public javax.swing.JDesktopPane escritorio;
    private javax.swing.JPanel footer;
    private Reloj.Hora hora1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    private javax.swing.JPanel menu;
    private com.pagosoft.plaf.PgsLabelUI pgsLabelUI1;
    private javax.swing.JPanel ventanas;
    // End of variables declaration//GEN-END:variables

    public void bolquearBotones() 
    {
        tipoUsuario=controladorTipoUsuario.buscarTipoUsu(String.valueOf(usuario.getTIP_USU_ID())).get(0);
        jLabel2.setText(usuario.getPER_NOMBRE());
        jLabel4.setText(tipoUsuario.getTIP_USU_DESCRIPCION());
        
        if (!tipoUsuario.isTIP_USU_PRODUCTO()&!tipoUsuario.isTIP_USU_MERCADERIA()) 
        {
            Menu_almacen.setVisible(false);
        }
        else
        {
            Menu_prod.setEnabled(tipoUsuario.isTIP_USU_PRODUCTO());
            Menu_merc.setEnabled(tipoUsuario.isTIP_USU_MERCADERIA()); 
        }
        
        if (!tipoUsuario.isTIP_USU_COMPRAS()&!tipoUsuario.isTIP_USU_PROVEEDORES()) 
        {
            Menu_compras.setVisible(false);
        }
        else
        {
            bt_compras.setEnabled(tipoUsuario.isTIP_USU_COMPRAS());
            bt_Proveedores.setEnabled(tipoUsuario.isTIP_USU_PROVEEDORES()); 
        }
        
      //bloqueo de botones de menu
        if(tipoUsuario.isTIP_USU_VENTA()) {buttonTask2.setVisible(true);}else{buttonTask2.setVisible(false);}
        if(tipoUsuario.isTIP_USU_CLIENTES()) {buttonTask1.setVisible(true);}else{buttonTask1.setVisible(false);}
        if(tipoUsuario.isTIP_USU_PRODUCTO()) {buttonTask3.setVisible(true);}else{buttonTask3.setVisible(false);}
//        if(tipoUsuario.isTIP_USU_VENTA()) {buttonTask2.setVisible(true);}else{buttonTask2.setVisible(false);}
        if(tipoUsuario.isTIP_USU_EMPLEADOS()) {buttonTask5.setVisible(true);}else{buttonTask5.setVisible(false);}
//        if(tipoUsuario.isTIP_USU_VENTAS_REALIZADAS()
//                &tipoUsuario.isTIP_USU_VENTAS_DETALLADAS()
//                &tipoUsuario.isTIP_USU_ESTADISTICA_MENSUAL()
//                &tipoUsuario.isTIP_USU_COMPRAS_REALIZADAS()
//                &tipoUsuario.isTIP_USU_COMPRAS_DETALLADAS()) {buttonTask7.setVisible(true);}else{buttonTask7.setVisible(false);}
        if(tipoUsuario.isTIP_USU_VERIFICAR_PRODUCTO()) {buttonTask6.setVisible(true);}else{buttonTask6.setVisible(false);}
        
        
        if (!tipoUsuario.isTIP_USU_VENTA()&!tipoUsuario.isTIP_USU_CLIENTES()&!tipoUsuario.isTIP_USU_VERIFICAR_PRODUCTO()) 
        {
            Menu_ventas.setVisible(false);            
        }
        else
        {
            bt_ventas.setEnabled(tipoUsuario.isTIP_USU_VENTA());
            bt_Clientes.setEnabled(tipoUsuario.isTIP_USU_CLIENTES());
            bt_verificar_producto.setEnabled(tipoUsuario.isTIP_USU_VERIFICAR_PRODUCTO());            
        }
        
        if (!tipoUsuario.isTIP_USU_VENTAS_REALIZADAS()
                &!tipoUsuario.isTIP_USU_VENTAS_DETALLADAS()
                &!tipoUsuario.isTIP_USU_ESTADISTICA_MENSUAL()
                &!tipoUsuario.isTIP_USU_COMPRAS_REALIZADAS()
                &!tipoUsuario.isTIP_USU_COMPRAS_DETALLADAS()) 
        {
            Menu_consulta.setVisible(false);
            buttonTask7.setVisible(false);
        }
        else
        {
            bt_venta_Realizada.setEnabled(tipoUsuario.isTIP_USU_VENTAS_REALIZADAS());
            bt_Venta_detallada.setEnabled(tipoUsuario.isTIP_USU_VENTAS_DETALLADAS());
            bt_estadistica_mensual.setEnabled(tipoUsuario.isTIP_USU_ESTADISTICA_MENSUAL());
            bt_compra_Realizada.setEnabled(tipoUsuario.isTIP_USU_COMPRAS_REALIZADAS());
            bt_compra_detallada.setEnabled(tipoUsuario.isTIP_USU_COMPRAS_DETALLADAS());
            buttonTask7.setVisible(true);
        }
        
        if (!tipoUsuario.isTIP_USU_EMPLEADOS()
                &!tipoUsuario.isTIP_USU_TIPO_DE_USUARIO()) 
        {
            Menu_mant.setVisible(false);
        }
        else
        {
            bt_usuarios.setEnabled(tipoUsuario.isTIP_USU_EMPLEADOS());
            bt_tipo_usuario.setEnabled(tipoUsuario.isTIP_USU_TIPO_DE_USUARIO());
        }
        
        
        Menu_st.setVisible(tipoUsuario.isTIP_USU_SERVICIO_TECNICO());
        
        
        
        
        if (!tipoUsuario.isTIP_USU_ANULAR_VENTA()
                &!tipoUsuario.isTIP_USU_ANULAR_COMPRA()) 
        {
            Menu_anular.setVisible(false);
        }
        else
        {
            bt_anular_venta.setEnabled(tipoUsuario.isTIP_USU_ANULAR_VENTA());
            bt_anular_compra.setEnabled(tipoUsuario.isTIP_USU_ANULAR_COMPRA());
        }
        
//        Menu_herram;
//        bt_cambira_contrase;
//        bt_usuarios_nose;
//        bt_respaldar_bd;
//        bt_Restaura_bd;
        
        if (!tipoUsuario.isTIP_USU_CAMBIAR_CONTRASEÑA()
                &!tipoUsuario.isTIP_USU_USUARIOS()
                &!tipoUsuario.isTIP_USU_RESPALDAR_BD()                
                &!tipoUsuario.isTIP_USU_RESTAURAR_BD()) 
        {
            Menu_herram.setVisible(false);
        }
        else
        {
            bt_cambira_contrase.setEnabled(tipoUsuario.isTIP_USU_CAMBIAR_CONTRASEÑA());
            bt_usuarios_nose.setEnabled(tipoUsuario.isTIP_USU_USUARIOS());
            bt_respaldar_bd.setEnabled(tipoUsuario.isTIP_USU_RESPALDAR_BD());
            bt_Restaura_bd.setEnabled(tipoUsuario.isTIP_USU_RESTAURAR_BD());
        }
        
//        client.setVisible(tipoUsuario.isTIP_USU_CLIENTES());
//        ventas.setVisible(tipoUsuario.isTIP_USU_VENTA());
    }

     private void ventanasInternas(String caso) 
    {
        switch(caso)
        {
            case "Clientes": 
                vf = F_Cliente.vf;
                if(vf==null)
                {
                    F_Cliente ventana = new F_Cliente(); 
                    setRootPaneCheckingEnabled(false);
                    javax.swing.plaf.InternalFrameUI ifu= ventana.getUI();
                    ((javax.swing.plaf.basic.BasicInternalFrameUI)ifu).setNorthPane(null); 
                    escritorio.add(ventana);
                    ventana.setVisible(true);
                    try 
                    {
                       ventana.setMaximum(true);
                    } 
                    catch (PropertyVetoException ex) 
                    {
                       Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Ventana Cliente esta abierta!!!");
                }
                break;
            case "Productos":
                vf = F_Producto.vf;
                if(vf==null){
                F_Producto prod = new F_Producto();
                setRootPaneCheckingEnabled(false);
                javax.swing.plaf.InternalFrameUI ifu= prod.getUI();
                ((javax.swing.plaf.basic.BasicInternalFrameUI)ifu).setNorthPane(null); 
                escritorio.add(prod);
                prod.setVisible(true);
                try {
                prod.setMaximum(true);
                } catch (PropertyVetoException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                else{
                JOptionPane.showMessageDialog(null,"Ventana Producto esta abierta!!!");
                }
                break;
            case "Categoria":
                vf = F_Categoria.vf;

                if(vf==null){
                F_Categoria catg = new F_Categoria();
                setRootPaneCheckingEnabled(false);
                javax.swing.plaf.InternalFrameUI ifu= catg.getUI();
                ((javax.swing.plaf.basic.BasicInternalFrameUI)ifu).setNorthPane(null); 
                escritorio.add(catg);
                catg.setVisible(true);
                try {
                catg.setMaximum(true);
                } catch (PropertyVetoException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                else{
                JOptionPane.showMessageDialog(null,"Ventana Mercadería esta abierta!!!");
                }
                break;
            case "Ventas":
                vf = F_Ventas.vf;
                F_Ventas vent= new F_Ventas(usuario);
                if(vf==null){
               
                setRootPaneCheckingEnabled(false);
                javax.swing.plaf.InternalFrameUI ifu= vent.getUI();
                ((javax.swing.plaf.basic.BasicInternalFrameUI)ifu).setNorthPane(null); 
                escritorio.add(vent);
                vent.setVisible(true);
                try {
                vent.setMaximum(true);
                } catch (PropertyVetoException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                else{
                   
                JOptionPane.showMessageDialog(null,"Ventana Ventas esta abierta!!!");
                } 
                break;
                 
        }
    }

    
}
