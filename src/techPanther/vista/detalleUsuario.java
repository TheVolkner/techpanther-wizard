package techPanther.vista;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;
import techPanther.controlador.*;

/**
 *
 * @author Kendrick
 */
public class detalleUsuario extends javax.swing.JFrame {

    /**
     * Creates new form Administrador
     */
    public detalleUsuario() {
        initComponents();

        usoUsuarios = new UsoUsuarios();

        //Obtenemos el ID del Usuario seleccionado proveniente de la ventana de listado.
        id_usuario = listadoUsuarios.id_usuario;

        setTitle("Detalles de Usuario - Sesión de " + Login.user);
        setResizable(false);

        //Inicializamos el fondo de la aplicación
        ImageIcon imagen = new ImageIcon("src/images/FondoV3.png");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(labelWallpaper.getWidth(), labelWallpaper.getHeight(),
                Image.SCALE_DEFAULT));

        labelWallpaper.setIcon(icono);

        this.repaint();

        //Inicializamos el logo de la aplicación
        ImageIcon imagenLogo = new ImageIcon("src/images/tp.png");
        Icon iconoLogo = new ImageIcon(imagenLogo.getImage().getScaledInstance(labelLogo.getWidth(), labelLogo.getHeight(), Image.SCALE_DEFAULT));
        labelLogo.setIcon(iconoLogo);
        this.repaint();

        //Obtenemos los valores del usuario para rellenar los campos de la ventana.
        Object[] users = usoUsuarios.obtenerUsuario(id_usuario);

        //Leemos el arreglo de objetos para leer los valores
        campoNombre.setText(users[0].toString());
        campoUser.setText(users[1].toString());
        campoEmail.setText(users[2].toString());
        campoTelefono.setText(users[3].toString());
        campoRegistroPor.setText(users[4].toString());
        campoDomicilio.setText(users[5].toString());
        comboRol.setSelectedItem(users[6]);

    }

    //Inicializamos el ícono de la aplicación
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
        jLabelAgregar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelGerencia1 = new javax.swing.JLabel();
        jLabelAgregar1 = new javax.swing.JLabel();
        jLabelGerencia2 = new javax.swing.JLabel();
        jLabelGerencia3 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        campoEmail = new javax.swing.JTextField();
        campoTelefono = new javax.swing.JTextField();
        campoUser = new javax.swing.JTextField();
        comboRol = new javax.swing.JComboBox<>();
        jLabelGerencia5 = new javax.swing.JLabel();
        botonPass = new javax.swing.JButton();
        campoRegistroPor = new javax.swing.JTextField();
        jLabelAgregar2 = new javax.swing.JLabel();
        campoDomicilio = new javax.swing.JTextField();
        jLabelAgregar3 = new javax.swing.JLabel();
        labelWallpaper = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

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
        botonEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregarUser.png"))); // NOI18N
        botonEnviar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(botonEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, 80, 70));

        jLabelAgregar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelAgregar.setForeground(new java.awt.Color(255, 204, 0));
        jLabelAgregar.setText("Teléfono:");
        getContentPane().add(jLabelAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("By TechPanther  @  2022");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, -1, -1));

        jLabelGerencia1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelGerencia1.setForeground(new java.awt.Color(255, 204, 0));
        jLabelGerencia1.setText("  Enviar Datos");
        getContentPane().add(jLabelGerencia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, -1, -1));

        jLabelAgregar1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelAgregar1.setForeground(new java.awt.Color(255, 204, 0));
        jLabelAgregar1.setText("Nombre: *");
        getContentPane().add(jLabelAgregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jLabelGerencia2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelGerencia2.setForeground(new java.awt.Color(255, 204, 0));
        jLabelGerencia2.setText("Email:");
        getContentPane().add(jLabelGerencia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabelGerencia3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelGerencia3.setForeground(new java.awt.Color(255, 204, 0));
        jLabelGerencia3.setText("Usuario: *");
        getContentPane().add(jLabelGerencia3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, -1, -1));

        campoNombre.setBackground(new java.awt.Color(255, 204, 0));
        campoNombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        campoNombre.setForeground(new java.awt.Color(0, 0, 0));
        campoNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoNombre.setActionCommand("<Not Set>");
        campoNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        campoNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(campoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 210, 30));

        campoEmail.setBackground(new java.awt.Color(255, 204, 0));
        campoEmail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        campoEmail.setForeground(new java.awt.Color(0, 0, 0));
        campoEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoEmail.setActionCommand("<Not Set>");
        campoEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        campoEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(campoEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 210, 30));

        campoTelefono.setBackground(new java.awt.Color(255, 204, 0));
        campoTelefono.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        campoTelefono.setForeground(new java.awt.Color(0, 0, 0));
        campoTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoTelefono.setActionCommand("<Not Set>");
        campoTelefono.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        campoTelefono.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(campoTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 210, 30));

        campoUser.setBackground(new java.awt.Color(255, 204, 0));
        campoUser.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        campoUser.setForeground(new java.awt.Color(0, 0, 0));
        campoUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoUser.setActionCommand("<Not Set>");
        campoUser.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        campoUser.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(campoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 210, 30));

        comboRol.setBackground(new java.awt.Color(255, 204, 0));
        comboRol.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        comboRol.setForeground(new java.awt.Color(0, 0, 0));
        comboRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Gerente", "Tecnico" }));
        comboRol.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(comboRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 170, -1));

        jLabelGerencia5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelGerencia5.setForeground(new java.awt.Color(255, 204, 0));
        jLabelGerencia5.setText("Permisos de: *");
        getContentPane().add(jLabelGerencia5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, -1, -1));

        botonPass.setBackground(new java.awt.Color(255, 204, 0));
        botonPass.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonPass.setForeground(new java.awt.Color(0, 0, 0));
        botonPass.setText("Recuperar Contraseña");
        botonPass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botonPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPassActionPerformed(evt);
            }
        });
        getContentPane().add(botonPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 170, 30));

        campoRegistroPor.setEditable(false);
        campoRegistroPor.setBackground(new java.awt.Color(255, 204, 0));
        campoRegistroPor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        campoRegistroPor.setForeground(new java.awt.Color(0, 0, 0));
        campoRegistroPor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoRegistroPor.setActionCommand("<Not Set>");
        campoRegistroPor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        campoRegistroPor.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(campoRegistroPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 210, 30));

        jLabelAgregar2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelAgregar2.setForeground(new java.awt.Color(255, 204, 0));
        jLabelAgregar2.setText("Registrado por:");
        getContentPane().add(jLabelAgregar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, -1, -1));

        campoDomicilio.setBackground(new java.awt.Color(255, 204, 0));
        campoDomicilio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        campoDomicilio.setForeground(new java.awt.Color(0, 0, 0));
        campoDomicilio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoDomicilio.setActionCommand("<Not Set>");
        campoDomicilio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        campoDomicilio.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(campoDomicilio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 210, 30));

        jLabelAgregar3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelAgregar3.setForeground(new java.awt.Color(255, 204, 0));
        jLabelAgregar3.setText("Domicilio");
        getContentPane().add(jLabelAgregar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));
        getContentPane().add(labelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 450));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("¡Los campos con el '*' son obligatorios!");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPassActionPerformed
        new cambioPass().setVisible(true);
    }//GEN-LAST:event_botonPassActionPerformed

    private void botonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnviarActionPerformed

        String nombre = campoNombre.getText().trim();
        String username = campoUser.getText().trim();
        String email = campoEmail.getText().trim();
        String telefono = campoTelefono.getText().trim();
        String registrado_por = campoRegistroPor.getText().trim();
        String domicilio = campoDomicilio.getText().trim();
        String permisos = (String) comboRol.getSelectedItem();

        usoUsuarios.actualizarUsuario(id_usuario,nombre, email, telefono, domicilio, username, permisos, registrado_por);
               
        dispose();    


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
            java.util.logging.Logger.getLogger(detalleUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(detalleUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(detalleUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(detalleUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new detalleUsuario().setVisible(true);
            }
        });
    }

    private UsoUsuarios usoUsuarios;
    private int id_usuario;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEnviar;
    private javax.swing.JButton botonPass;
    private javax.swing.JTextField campoDomicilio;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoRegistroPor;
    private javax.swing.JTextField campoTelefono;
    private javax.swing.JTextField campoUser;
    private javax.swing.JComboBox<String> comboRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelAgregar;
    private javax.swing.JLabel jLabelAgregar1;
    private javax.swing.JLabel jLabelAgregar2;
    private javax.swing.JLabel jLabelAgregar3;
    private javax.swing.JLabel jLabelGerencia1;
    private javax.swing.JLabel jLabelGerencia2;
    private javax.swing.JLabel jLabelGerencia3;
    private javax.swing.JLabel jLabelGerencia5;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelWallpaper;
    // End of variables declaration//GEN-END:variables
}
