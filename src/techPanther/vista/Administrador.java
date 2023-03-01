package techPanther.vista;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import techPanther.controlador.*;

/**
 *
 * @author Kendrick
 */
public class Administrador extends javax.swing.JFrame {

    /**
     * Creates new form Administrador
     */
    public Administrador() {
        initComponents();

        //Extraemos el valor del usuario de la sesión actual desde el Login y lo guardamos para usarlo en esta ventana.
        user = Login.user;

        setTitle("Panel de Administrador - Sesión de " + user);
        setResizable(false);

        //Inicializamos el objeto usoUsuario de la capa Controlador.
        usoUsuarios = new UsoUsuarios();
        usoEquipos = new usoEquipos();
        usoClientes = new UsoClientes();

        //Inicializamos el fondo de pantalla
        ImageIcon imagen = new ImageIcon("src/images/FondoV3.png");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(labelWallpaper.getWidth(), labelWallpaper.getHeight(),
                Image.SCALE_DEFAULT));

        labelWallpaper.setIcon(icono);

        this.repaint();

        //Boton de cerrar sesión.
        ImageIcon imagenSalir = new ImageIcon("src/images/salir.png");
        Icon iconoSalir = new ImageIcon(imagenSalir.getImage().getScaledInstance(label_salir.getWidth(), label_salir.getHeight(),
                Image.SCALE_DEFAULT));

        label_salir.setIcon(iconoSalir);

        this.repaint();

        label_salir.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                int resul = JOptionPane.showConfirmDialog(null, "¿Desea cerrar sesión?");

                if (resul == JOptionPane.YES_OPTION) {

                    new Login().setVisible(true);
                    dispose();
                }
            }

        });

        //Inicializamos el logo de la aplicación
        ImageIcon imagenLogo = new ImageIcon("src/images/tp.png");
        Icon iconoLogo = new ImageIcon(imagenLogo.getImage().getScaledInstance(labelLogo.getWidth(), labelLogo.getHeight(), Image.SCALE_DEFAULT));
        labelLogo.setIcon(iconoLogo);
        this.repaint();

        //Inicializmos el texto de bienvenida con el nombre del usuario.
        String nombre = usoUsuarios.mensajeBienvenida(user);

        mensajeBienvenida.setText("¡Bienvenido(a), " + nombre + "!");

    }

    //Inicializamos el icono.
    @Override
    public Image getIconImage() {

        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icono.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        list1 = new java.awt.List();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        botonTecnico = new javax.swing.JButton();
        botonGestion = new javax.swing.JButton();
        jLabelAgregar = new javax.swing.JLabel();
        mensajeBienvenida = new javax.swing.JLabel();
        botonGerencia = new javax.swing.JButton();
        botonAgregar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabelGerencia1 = new javax.swing.JLabel();
        jLabelAgregar1 = new javax.swing.JLabel();
        jLabelGerencia2 = new javax.swing.JLabel();
        jLabelGerencia3 = new javax.swing.JLabel();
        label_salir = new javax.swing.JLabel();
        jLabelGerencia4 = new javax.swing.JLabel();
        botonGestionEquipos = new javax.swing.JButton();
        botonGestionar = new javax.swing.JButton();
        labelWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 51));
        jLabel5.setText("Sistema de Control y Gestión");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 450, 60));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 51));
        jLabel1.setText("TECHPANTHER WIZARD");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 360, 70));
        getContentPane().add(labelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 190, 150));

        botonTecnico.setBackground(new java.awt.Color(255, 204, 0));
        botonTecnico.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonTecnico.setForeground(new java.awt.Color(0, 0, 0));
        botonTecnico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tecnico.png"))); // NOI18N
        botonTecnico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botonTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTecnicoActionPerformed(evt);
            }
        });
        getContentPane().add(botonTecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 80, 70));

        botonGestion.setBackground(new java.awt.Color(255, 204, 0));
        botonGestion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonGestion.setForeground(new java.awt.Color(0, 0, 0));
        botonGestion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestion.png"))); // NOI18N
        botonGestion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botonGestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGestionActionPerformed(evt);
            }
        });
        getContentPane().add(botonGestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 80, 70));

        jLabelAgregar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelAgregar.setForeground(new java.awt.Color(255, 204, 0));
        jLabelAgregar.setText("Gestionar Usuarios");
        getContentPane().add(jLabelAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        mensajeBienvenida.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        mensajeBienvenida.setForeground(new java.awt.Color(255, 255, 255));
        mensajeBienvenida.setText("¡Bienvenido(a), Usuario!");
        getContentPane().add(mensajeBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, -1, -1));

        botonGerencia.setBackground(new java.awt.Color(255, 204, 0));
        botonGerencia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonGerencia.setForeground(new java.awt.Color(0, 0, 0));
        botonGerencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gerente.png"))); // NOI18N
        botonGerencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botonGerencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGerenciaActionPerformed(evt);
            }
        });
        getContentPane().add(botonGerencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 80, 70));

        botonAgregar.setBackground(new java.awt.Color(255, 204, 0));
        botonAgregar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonAgregar.setForeground(new java.awt.Color(0, 0, 0));
        botonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregarUser.png"))); // NOI18N
        botonAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(botonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 80, 70));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("By TechPanther  @  2022");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, -1, -1));

        jLabelGerencia1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelGerencia1.setForeground(new java.awt.Color(255, 204, 0));
        jLabelGerencia1.setText("Gestionar Clientes");
        getContentPane().add(jLabelGerencia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, -1, -1));

        jLabelAgregar1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelAgregar1.setForeground(new java.awt.Color(255, 204, 0));
        jLabelAgregar1.setText("  Agregar Usuario");
        getContentPane().add(jLabelAgregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabelGerencia2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelGerencia2.setForeground(new java.awt.Color(255, 204, 0));
        jLabelGerencia2.setText("Ventana de Gerencia");
        getContentPane().add(jLabelGerencia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, -1));

        jLabelGerencia3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelGerencia3.setForeground(new java.awt.Color(255, 204, 0));
        jLabelGerencia3.setText("Ventana de Técnico");
        getContentPane().add(jLabelGerencia3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, -1, -1));

        label_salir.setText("jLabel2");
        getContentPane().add(label_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 50, 40));

        jLabelGerencia4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelGerencia4.setForeground(new java.awt.Color(255, 204, 0));
        jLabelGerencia4.setText("Gestionar Equipos");
        getContentPane().add(jLabelGerencia4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, -1, -1));

        botonGestionEquipos.setBackground(new java.awt.Color(255, 204, 0));
        botonGestionEquipos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonGestionEquipos.setForeground(new java.awt.Color(0, 0, 0));
        botonGestionEquipos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestionEquipo.png"))); // NOI18N
        botonGestionEquipos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botonGestionEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGestionEquiposActionPerformed(evt);
            }
        });
        getContentPane().add(botonGestionEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 80, 70));

        botonGestionar.setBackground(new java.awt.Color(255, 204, 0));
        botonGestionar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonGestionar.setForeground(new java.awt.Color(0, 0, 0));
        botonGestionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregar2.png"))); // NOI18N
        botonGestionar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botonGestionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGestionarActionPerformed(evt);
            }
        });
        getContentPane().add(botonGestionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 80, 70));
        getContentPane().add(labelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Boton para ingresar a la ventana de Técnico
    private void botonTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTecnicoActionPerformed

        Tecnico t = new Tecnico();
        t.setVisible(true);
        t.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_botonTecnicoActionPerformed

    //Boton para ingresar a la ventana de DetalleUsuario
    private void botonGestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGestionActionPerformed

        new listadoUsuarios().setVisible(true);
    }//GEN-LAST:event_botonGestionActionPerformed

    //Boton para ingresar a la ventana de AgregarUsuario
    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed

        new agregarUsuario().setVisible(true);
    }//GEN-LAST:event_botonAgregarActionPerformed

    //Boton para ingresar a la ventana de Gerencia
    private void botonGerenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGerenciaActionPerformed

        Gerencia g = new Gerencia();
        g.setVisible(true);
        g.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_botonGerenciaActionPerformed

    private void botonGestionEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGestionEquiposActionPerformed
        new listadoEquipos().setVisible(true);
    }//GEN-LAST:event_botonGestionEquiposActionPerformed

    private void botonGestionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGestionarActionPerformed
        new listadoClientes().setVisible(true);
    }//GEN-LAST:event_botonGestionarActionPerformed

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
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true);
            }
        });
    }

    private String user;
    private UsoClientes usoClientes;
    private usoEquipos usoEquipos;
    private UsoUsuarios usoUsuarios;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonGerencia;
    private javax.swing.JButton botonGestion;
    private javax.swing.JButton botonGestionEquipos;
    private javax.swing.JButton botonGestionar;
    private javax.swing.JButton botonTecnico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelAgregar;
    private javax.swing.JLabel jLabelAgregar1;
    private javax.swing.JLabel jLabelGerencia1;
    private javax.swing.JLabel jLabelGerencia2;
    private javax.swing.JLabel jLabelGerencia3;
    private javax.swing.JLabel jLabelGerencia4;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelWallpaper;
    private javax.swing.JLabel label_salir;
    private java.awt.List list1;
    private javax.swing.JLabel mensajeBienvenida;
    // End of variables declaration//GEN-END:variables
}
