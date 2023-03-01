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

public class Tecnico extends javax.swing.JFrame {

    public Tecnico() {
        initComponents();

        setResizable(false);
        setTitle("Panel de Técnico - Sesión de " + Login.user);

        //Inicializamos los objetos del controlador
        usoUsuarios = new UsoUsuarios();

        //Inicializamos el fondo
        ImageIcon imagen = new ImageIcon("src/images/FondoV3.png");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(labelWallpaper.getWidth(), labelWallpaper.getHeight(),
                Image.SCALE_DEFAULT));

        labelWallpaper.setIcon(icono);

        this.repaint();

        //Inicializamos el logo.
        ImageIcon imagenLogo = new ImageIcon("src/images/tp.png");
        Icon iconoLogo = new ImageIcon(imagenLogo.getImage().getScaledInstance(labelLogo.getWidth(), labelLogo.getHeight(), Image.SCALE_DEFAULT));
        labelLogo.setIcon(iconoLogo);
        this.repaint();

        //Inicializmos el texto de bienvenida con el nombre del usuario.
        String nombre = usoUsuarios.mensajeBienvenida(Login.user);

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
        botonGestionCliente = new javax.swing.JButton();
        botonGestionEquipos = new javax.swing.JButton();
        botonGrafica = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabelAgregar2 = new javax.swing.JLabel();
        jLabelAgregar3 = new javax.swing.JLabel();
        jLabelAgregar4 = new javax.swing.JLabel();
        mensajeBienvenida = new javax.swing.JLabel();
        label_salir = new javax.swing.JLabel();
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
        getContentPane().add(labelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 150, 120));

        botonGestionCliente.setBackground(new java.awt.Color(255, 204, 0));
        botonGestionCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonGestionCliente.setForeground(new java.awt.Color(0, 0, 0));
        botonGestionCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestion.png"))); // NOI18N
        botonGestionCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botonGestionCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGestionClienteActionPerformed(evt);
            }
        });
        getContentPane().add(botonGestionCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 80, 70));

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
        getContentPane().add(botonGestionEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 80, 70));

        botonGrafica.setBackground(new java.awt.Color(255, 204, 0));
        botonGrafica.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonGrafica.setForeground(new java.awt.Color(0, 0, 0));
        botonGrafica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/barras.png"))); // NOI18N
        botonGrafica.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botonGrafica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGraficaActionPerformed(evt);
            }
        });
        getContentPane().add(botonGrafica, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 80, 70));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("By TechPanther  @  2022");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, -1, -1));

        jLabelAgregar2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelAgregar2.setForeground(new java.awt.Color(255, 204, 0));
        jLabelAgregar2.setText("Gestionar Equipos");
        getContentPane().add(jLabelAgregar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, -1, -1));

        jLabelAgregar3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelAgregar3.setForeground(new java.awt.Color(255, 204, 0));
        jLabelAgregar3.setText("Gráfica de Estatus");
        getContentPane().add(jLabelAgregar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, -1, -1));

        jLabelAgregar4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelAgregar4.setForeground(new java.awt.Color(255, 204, 0));
        jLabelAgregar4.setText("Gestionar Clientes");
        getContentPane().add(jLabelAgregar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        mensajeBienvenida.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        mensajeBienvenida.setForeground(new java.awt.Color(255, 255, 255));
        mensajeBienvenida.setText("¡Bienvenido(a), Usuario!");
        getContentPane().add(mensajeBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, -1, -1));

        label_salir.setText("jLabel2");
        getContentPane().add(label_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, 30, 30));
        getContentPane().add(labelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 300));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonGestionClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGestionClienteActionPerformed
        new listadoClientes().setVisible(true);
    }//GEN-LAST:event_botonGestionClienteActionPerformed

    private void botonGestionEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGestionEquiposActionPerformed
        new listadoEquipos().setVisible(true);
    }//GEN-LAST:event_botonGestionEquiposActionPerformed

    private void botonGraficaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGraficaActionPerformed
       new graficaEstatus().setVisible(true);
    }//GEN-LAST:event_botonGraficaActionPerformed

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
            java.util.logging.Logger.getLogger(Tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tecnico().setVisible(true);
            }
        });
    }

    private UsoUsuarios usoUsuarios;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGestionCliente;
    private javax.swing.JButton botonGestionEquipos;
    private javax.swing.JButton botonGrafica;
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
