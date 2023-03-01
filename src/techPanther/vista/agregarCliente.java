package techPanther.vista;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;
import techPanther.controlador.UsoClientes;

/**
 *
 * @author Kendrick
 */
public class agregarCliente extends javax.swing.JFrame {

    /**
     * Creates new form Administrador
     */
    public agregarCliente() {
        initComponents();

        //Extraemos el nomrbe del usuario proveniente del Login.
        user = Login.user;

        setResizable(false);
        setTitle("Agregar Cliente - Sesión de " + user);

        //Inicializamos el objeto usoUsuarios
        usoClientes = new UsoClientes();

        ImageIcon imagen = new ImageIcon("src/images/FondoV3.png");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(labelWallpaper.getWidth(), labelWallpaper.getHeight(),
                Image.SCALE_DEFAULT));

        labelWallpaper.setIcon(icono);

        this.repaint();

        ImageIcon imagenLogo = new ImageIcon("src/images/tp.png");
        Icon iconoLogo = new ImageIcon(imagenLogo.getImage().getScaledInstance(labelLogo.getWidth(), labelLogo.getHeight(), Image.SCALE_DEFAULT));
        labelLogo.setIcon(iconoLogo);
        this.repaint();

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
        botonEnviar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabelGerencia1 = new javax.swing.JLabel();
        jLabelAgregar1 = new javax.swing.JLabel();
        jLabelGerencia2 = new javax.swing.JLabel();
        jLabelGerencia3 = new javax.swing.JLabel();
        jLabelGerencia4 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        campoDireccion = new javax.swing.JTextField();
        campoTlf = new javax.swing.JTextField();
        campoEmail = new javax.swing.JTextField();
        labelWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        botonEnviar.setBackground(new java.awt.Color(255, 204, 0));
        botonEnviar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonEnviar.setForeground(new java.awt.Color(0, 0, 0));
        botonEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregar2.png"))); // NOI18N
        botonEnviar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(botonEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, 80, 70));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("By TechPanther  @  2022");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, -1, -1));

        jLabelGerencia1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelGerencia1.setForeground(new java.awt.Color(255, 204, 0));
        jLabelGerencia1.setText("  Enviar Datos");
        getContentPane().add(jLabelGerencia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, -1, -1));

        jLabelAgregar1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelAgregar1.setForeground(new java.awt.Color(255, 204, 0));
        jLabelAgregar1.setText("Nombre:");
        getContentPane().add(jLabelAgregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jLabelGerencia2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelGerencia2.setForeground(new java.awt.Color(255, 204, 0));
        jLabelGerencia2.setText("Email:");
        getContentPane().add(jLabelGerencia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jLabelGerencia3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelGerencia3.setForeground(new java.awt.Color(255, 204, 0));
        jLabelGerencia3.setText("Teléfono");
        getContentPane().add(jLabelGerencia3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, -1));

        jLabelGerencia4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelGerencia4.setForeground(new java.awt.Color(255, 204, 0));
        jLabelGerencia4.setText("Dirección:");
        getContentPane().add(jLabelGerencia4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, -1, -1));

        campoNombre.setBackground(new java.awt.Color(255, 204, 0));
        campoNombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        campoNombre.setForeground(new java.awt.Color(0, 0, 0));
        campoNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoNombre.setActionCommand("<Not Set>");
        campoNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        campoNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(campoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 210, 30));

        campoDireccion.setBackground(new java.awt.Color(255, 204, 0));
        campoDireccion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        campoDireccion.setForeground(new java.awt.Color(0, 0, 0));
        campoDireccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoDireccion.setActionCommand("<Not Set>");
        campoDireccion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        campoDireccion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(campoDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 210, 30));

        campoTlf.setBackground(new java.awt.Color(255, 204, 0));
        campoTlf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        campoTlf.setForeground(new java.awt.Color(0, 0, 0));
        campoTlf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoTlf.setActionCommand("<Not Set>");
        campoTlf.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        campoTlf.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(campoTlf, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 210, 30));

        campoEmail.setBackground(new java.awt.Color(255, 204, 0));
        campoEmail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        campoEmail.setForeground(new java.awt.Color(0, 0, 0));
        campoEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoEmail.setActionCommand("<Not Set>");
        campoEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        campoEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(campoEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 210, 30));
        getContentPane().add(labelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnviarActionPerformed

        String nombre = campoNombre.getText().trim();
        String telefono = campoTlf.getText().trim();
        String email = campoEmail.getText().trim();
        String direccion = campoDireccion.getText().trim();
        String ult_mod = user;

        if (usoClientes.agregarCliente(nombre, email, telefono, direccion, ult_mod)) {

            campoNombre.setText("");
            campoDireccion.setText("");
            campoTlf.setText("");
            campoEmail.setText("");

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
            java.util.logging.Logger.getLogger(agregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(agregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(agregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(agregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new agregarCliente().setVisible(true);
            }
        });
    }

    private UsoClientes usoClientes;
    private String user;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEnviar;
    private javax.swing.JTextField campoDireccion;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoTlf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelAgregar1;
    private javax.swing.JLabel jLabelGerencia1;
    private javax.swing.JLabel jLabelGerencia2;
    private javax.swing.JLabel jLabelGerencia3;
    private javax.swing.JLabel jLabelGerencia4;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelWallpaper;
    // End of variables declaration//GEN-END:variables
}
