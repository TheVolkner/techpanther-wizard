package techPanther.vista;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.Date;
import javax.swing.*;
import techPanther.controlador.*;

/**
 *
 * @author Kendrick
 */
public class detalleEquipo extends javax.swing.JFrame {

    /**
     * Creates new form Administrador
     */
    public detalleEquipo() {
        initComponents();
        
        //Inicializamos el objeto del tipo del Controlador
        usoEquipos = new usoEquipos();
        
        //Obtenemos el valor del ID del cliente.
        id_equipo = detalleCliente.id_equipo;
        
        setResizable(false);
        setTitle("Detalle de Equipo - Sesión de " + Login.user);
        
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
        
        System.out.println("id del equipo: " + id_equipo);
        
        //Inicializamos los campos de Equipo
        Object[] equipo = usoEquipos.obtenerEquipo(id_equipo);
        
        campoTipoEquipo.setText(equipo[0].toString());
        campoMarca.setText(equipo[1].toString());
        campoModelo.setText(equipo[2].toString());
        Date fecha = (Date) equipo[3];
        eligeFecha.setDate(fecha);
        areaObserv.setText(equipo[4].toString());
        comboEstatus.setSelectedItem(equipo[5].toString());
        areaComent.setText(equipo[6].toString());
        campoRevisado.setText(equipo[7].toString());
        
                      
        

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

        jLabel5 = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        botonEnviar = new javax.swing.JButton();
        jLabelAgregar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelGerencia1 = new javax.swing.JLabel();
        jLabelAgregar1 = new javax.swing.JLabel();
        jLabelGerencia2 = new javax.swing.JLabel();
        jLabelGerencia3 = new javax.swing.JLabel();
        jLabelGerencia4 = new javax.swing.JLabel();
        campoTipoEquipo = new javax.swing.JTextField();
        campoModelo = new javax.swing.JTextField();
        jLabelGerencia5 = new javax.swing.JLabel();
        campoMarca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaComent = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaObserv = new javax.swing.JTextArea();
        jLabelGerencia6 = new javax.swing.JLabel();
        campoRevisado = new javax.swing.JTextField();
        jLabelGerencia7 = new javax.swing.JLabel();
        comboEstatus = new javax.swing.JComboBox<>();
        eligeFecha = new com.toedter.calendar.JDateChooser();
        labelWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 51));
        jLabel5.setText("Sistema de Control y Gestión");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 450, 60));
        getContentPane().add(labelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 190, 150));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 51));
        jLabel1.setText("TECHPANTHER WIZARD");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 360, 70));

        botonEnviar.setBackground(new java.awt.Color(255, 204, 0));
        botonEnviar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonEnviar.setForeground(new java.awt.Color(0, 0, 0));
        botonEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestionEquipo.png"))); // NOI18N
        botonEnviar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(botonEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, 70, 60));

        jLabelAgregar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelAgregar.setForeground(new java.awt.Color(255, 204, 0));
        jLabelAgregar.setText("Modelo:");
        getContentPane().add(jLabelAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("By TechPanther  @  2022");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 480, -1, -1));

        jLabelGerencia1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelGerencia1.setForeground(new java.awt.Color(255, 204, 0));
        jLabelGerencia1.setText("   Enviar Datos");
        getContentPane().add(jLabelGerencia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 410, -1, -1));

        jLabelAgregar1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelAgregar1.setForeground(new java.awt.Color(255, 204, 0));
        jLabelAgregar1.setText("Tipo de Equipo: *");
        getContentPane().add(jLabelAgregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jLabelGerencia2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelGerencia2.setForeground(new java.awt.Color(255, 204, 0));
        jLabelGerencia2.setText("Marca: *");
        getContentPane().add(jLabelGerencia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        jLabelGerencia3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelGerencia3.setForeground(new java.awt.Color(255, 204, 0));
        jLabelGerencia3.setText("Observaciones: *");
        getContentPane().add(jLabelGerencia3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, -1, -1));

        jLabelGerencia4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelGerencia4.setForeground(new java.awt.Color(255, 204, 0));
        jLabelGerencia4.setText("Comentarios Post - Revisión:");
        getContentPane().add(jLabelGerencia4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, -1, -1));

        campoTipoEquipo.setBackground(new java.awt.Color(255, 204, 0));
        campoTipoEquipo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        campoTipoEquipo.setForeground(new java.awt.Color(0, 0, 0));
        campoTipoEquipo.setActionCommand("<Not Set>");
        campoTipoEquipo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        campoTipoEquipo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(campoTipoEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 210, 30));

        campoModelo.setBackground(new java.awt.Color(255, 204, 0));
        campoModelo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        campoModelo.setForeground(new java.awt.Color(0, 0, 0));
        campoModelo.setActionCommand("<Not Set>");
        campoModelo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        campoModelo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(campoModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 210, 30));

        jLabelGerencia5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelGerencia5.setForeground(new java.awt.Color(255, 204, 0));
        jLabelGerencia5.setText("Fecha de Ingreso:  *");
        getContentPane().add(jLabelGerencia5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, -1));

        campoMarca.setBackground(new java.awt.Color(255, 204, 0));
        campoMarca.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        campoMarca.setForeground(new java.awt.Color(0, 0, 0));
        campoMarca.setActionCommand("<Not Set>");
        campoMarca.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        campoMarca.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(campoMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 210, 30));

        areaComent.setBackground(new java.awt.Color(255, 204, 0));
        areaComent.setColumns(20);
        areaComent.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        areaComent.setForeground(new java.awt.Color(0, 0, 0));
        areaComent.setRows(5);
        jScrollPane1.setViewportView(areaComent);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 290, 110));

        areaObserv.setBackground(new java.awt.Color(255, 204, 0));
        areaObserv.setColumns(20);
        areaObserv.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        areaObserv.setForeground(new java.awt.Color(0, 0, 0));
        areaObserv.setRows(5);
        jScrollPane2.setViewportView(areaObserv);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 290, 120));

        jLabelGerencia6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelGerencia6.setForeground(new java.awt.Color(255, 204, 0));
        jLabelGerencia6.setText("Estatus: *");
        getContentPane().add(jLabelGerencia6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, -1, -1));

        campoRevisado.setBackground(new java.awt.Color(255, 204, 0));
        campoRevisado.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        campoRevisado.setForeground(new java.awt.Color(0, 0, 0));
        campoRevisado.setActionCommand("<Not Set>");
        campoRevisado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        campoRevisado.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(campoRevisado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 210, 30));

        jLabelGerencia7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelGerencia7.setForeground(new java.awt.Color(255, 204, 0));
        jLabelGerencia7.setText("Revisado Por: *");
        getContentPane().add(jLabelGerencia7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        comboEstatus.setBackground(new java.awt.Color(255, 204, 0));
        comboEstatus.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        comboEstatus.setForeground(new java.awt.Color(0, 0, 0));
        comboEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo Ingreso", "En Revision", "Reparado", "No Reparado", "Entregado" }));
        comboEstatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(comboEstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, 170, -1));

        eligeFecha.setBackground(new java.awt.Color(255, 204, 0));
        eligeFecha.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(eligeFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 210, -1));
        getContentPane().add(labelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnviarActionPerformed
        
        String tipoEquipo = campoTipoEquipo.getText();
        String marca = campoMarca.getText();
        String modelo = campoModelo.getText();
        String revisadoPor = Login.user;
        String estatus = (String) comboEstatus.getSelectedItem();
        String observaciones = areaObserv.getText();
        String comentarios = areaComent.getText();
        Date fecha = eligeFecha.getDate();
        
        if(usoEquipos.actualizarEquipo(id_equipo, tipoEquipo, marca, modelo, observaciones, fecha, estatus, comentarios, revisadoPor)){
            
            dispose();
        }
        
        
    }//GEN-LAST:event_botonEnviarActionPerformed

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
            java.util.logging.Logger.getLogger(detalleEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(detalleEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(detalleEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(detalleEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new detalleEquipo().setVisible(true);
            }
        });
    }

    private int id_equipo;
    private usoEquipos usoEquipos;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaComent;
    private javax.swing.JTextArea areaObserv;
    private javax.swing.JButton botonEnviar;
    private javax.swing.JTextField campoMarca;
    private javax.swing.JTextField campoModelo;
    private javax.swing.JTextField campoRevisado;
    private javax.swing.JTextField campoTipoEquipo;
    private javax.swing.JComboBox<String> comboEstatus;
    private com.toedter.calendar.JDateChooser eligeFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelAgregar;
    private javax.swing.JLabel jLabelAgregar1;
    private javax.swing.JLabel jLabelGerencia1;
    private javax.swing.JLabel jLabelGerencia2;
    private javax.swing.JLabel jLabelGerencia3;
    private javax.swing.JLabel jLabelGerencia4;
    private javax.swing.JLabel jLabelGerencia5;
    private javax.swing.JLabel jLabelGerencia6;
    private javax.swing.JLabel jLabelGerencia7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelWallpaper;
    // End of variables declaration//GEN-END:variables
}
