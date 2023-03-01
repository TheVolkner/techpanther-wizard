/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package techPanther.vista;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import techPanther.controlador.*;

/**
 *
 * @author Kendrick
 */
public class Gerencia extends javax.swing.JFrame {

    /**
     * Creates new form Gerencia
     */
    public Gerencia() {
        initComponents();

        //Extraemos el nombre del usuario desde el login.
        user = Login.user;
        
        //Inicializamos el objeto usoUsuarios del Controlador.
        usoUsuarios = new UsoUsuarios();
        usoClientes = new UsoClientes();

        setResizable(false);
        setTitle("Panel de Gerencia - Sesión de " + user);

        ImageIcon imagen = new ImageIcon("src/images/FondoV3.png");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(labelWallpaper.getWidth(), labelWallpaper.getHeight(),
                Image.SCALE_DEFAULT));

        labelWallpaper.setIcon(icono);

        this.repaint();

        ImageIcon imagenLogo = new ImageIcon("src/images/tp.png");
        Icon iconoLogo = new ImageIcon(imagenLogo.getImage().getScaledInstance(labelLogo.getWidth(), labelLogo.getHeight(), Image.SCALE_DEFAULT));
        labelLogo.setIcon(iconoLogo);
        this.repaint();

        //Inicializmos el texto de bienvenida con el nombre del usuario.
        String nombre = usoUsuarios.mensajeBienvenida(user);

        mensajeBienvenida.setText("¡Bienvenido(a), " + nombre + "!");

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

    }

    @Override
    public Image getIconImage() {

        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icono.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        botonAgregar = new javax.swing.JButton();
        botonGestionar = new javax.swing.JButton();
        botonImprimir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabelAgregar2 = new javax.swing.JLabel();
        jLabelAgregar3 = new javax.swing.JLabel();
        jLabelAgregar4 = new javax.swing.JLabel();
        label_salir = new javax.swing.JLabel();
        mensajeBienvenida = new javax.swing.JLabel();
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
        getContentPane().add(labelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 150, 130));

        botonAgregar.setBackground(new java.awt.Color(255, 204, 0));
        botonAgregar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonAgregar.setForeground(new java.awt.Color(0, 0, 0));
        botonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregar2.png"))); // NOI18N
        botonAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(botonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 80, 70));

        botonGestionar.setBackground(new java.awt.Color(255, 204, 0));
        botonGestionar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonGestionar.setForeground(new java.awt.Color(0, 0, 0));
        botonGestionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestion.png"))); // NOI18N
        botonGestionar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botonGestionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGestionarActionPerformed(evt);
            }
        });
        getContentPane().add(botonGestionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 80, 70));

        botonImprimir.setBackground(new java.awt.Color(255, 204, 0));
        botonImprimir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonImprimir.setForeground(new java.awt.Color(0, 0, 0));
        botonImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imprimir.png"))); // NOI18N
        botonImprimir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonImprimirActionPerformed(evt);
            }
        });
        getContentPane().add(botonImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 80, 70));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("By TechPanther  @  2022");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, -1, -1));

        jLabelAgregar2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelAgregar2.setForeground(new java.awt.Color(255, 204, 0));
        jLabelAgregar2.setText("Gestionar Cliente");
        getContentPane().add(jLabelAgregar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, -1, -1));

        jLabelAgregar3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelAgregar3.setForeground(new java.awt.Color(255, 204, 0));
        jLabelAgregar3.setText("Imprimir Clientes");
        getContentPane().add(jLabelAgregar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, -1, -1));

        jLabelAgregar4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelAgregar4.setForeground(new java.awt.Color(255, 204, 0));
        jLabelAgregar4.setText("Agregar Cliente");
        getContentPane().add(jLabelAgregar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        label_salir.setText("jLabel2");
        getContentPane().add(label_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 40, 40));

        mensajeBienvenida.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        mensajeBienvenida.setForeground(new java.awt.Color(255, 255, 255));
        mensajeBienvenida.setText("¡Bienvenido(a), Usuario!");
        getContentPane().add(mensajeBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, -1, -1));
        getContentPane().add(labelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 300));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        new agregarCliente().setVisible(true);
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonGestionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGestionarActionPerformed
        new listadoClientes().setVisible(true);
    }//GEN-LAST:event_botonGestionarActionPerformed

    private void botonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonImprimirActionPerformed
        
        usoClientes.imprimir();
    }//GEN-LAST:event_botonImprimirActionPerformed

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
            java.util.logging.Logger.getLogger(Gerencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gerencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gerencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gerencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gerencia().setVisible(true);
            }
        });
    }

    private UsoClientes usoClientes;
    private UsoUsuarios usoUsuarios;
    private String user;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonGestionar;
    private javax.swing.JButton botonImprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelAgregar2;
    private javax.swing.JLabel jLabelAgregar3;
    private javax.swing.JLabel jLabelAgregar4;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelWallpaper;
    private javax.swing.JLabel label_salir;
    private javax.swing.JLabel mensajeBienvenida;
    // End of variables declaration//GEN-END:variables
}
