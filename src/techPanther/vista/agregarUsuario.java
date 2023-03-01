package techPanther.vista;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;
import techPanther.controlador.UsoUsuarios;

/**
 *
 * @author Kendrick
 */
public class agregarUsuario extends javax.swing.JFrame {

    /**
     * Creates new form Administrador
     */
    public agregarUsuario() {
        initComponents();

        //Obtenemos el valor del usuario en sesión actualmente proveniente de la ventana Login.
        user = Login.user;

        setResizable(false);
        setTitle("Agregar nuevo usuario - Sesión de " + user);

        //Inicializamos el fondo de pantalla
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
        jLabel1 = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        botonEnviar = new javax.swing.JButton();
        jLabelAgregar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelGerencia1 = new javax.swing.JLabel();
        jLabelAgregar1 = new javax.swing.JLabel();
        jLabelGerencia2 = new javax.swing.JLabel();
        jLabelGerencia3 = new javax.swing.JLabel();
        jLabelGerencia4 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        campoEmail = new javax.swing.JTextField();
        campoTelefono = new javax.swing.JTextField();
        campoUser = new javax.swing.JTextField();
        comboRol = new javax.swing.JComboBox<>();
        jLabelGerencia5 = new javax.swing.JLabel();
        campoPass = new javax.swing.JPasswordField();
        campoDomicilio = new javax.swing.JTextField();
        jLabelAgregar2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
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
        botonEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregarUser.png"))); // NOI18N
        botonEnviar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(botonEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, 80, 70));

        jLabelAgregar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelAgregar.setForeground(new java.awt.Color(255, 204, 0));
        jLabelAgregar.setText("Teléfono:");
        getContentPane().add(jLabelAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("¡Los campos con el '*' son obligatorios!");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabelGerencia1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelGerencia1.setForeground(new java.awt.Color(255, 204, 0));
        jLabelGerencia1.setText("  Enviar Datos");
        getContentPane().add(jLabelGerencia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, -1, -1));

        jLabelAgregar1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelAgregar1.setForeground(new java.awt.Color(255, 204, 0));
        jLabelAgregar1.setText("Nombre: *");
        getContentPane().add(jLabelAgregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabelGerencia2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelGerencia2.setForeground(new java.awt.Color(255, 204, 0));
        jLabelGerencia2.setText("Email:");
        getContentPane().add(jLabelGerencia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        jLabelGerencia3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelGerencia3.setForeground(new java.awt.Color(255, 204, 0));
        jLabelGerencia3.setText("Usuario: *");
        getContentPane().add(jLabelGerencia3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, -1, -1));

        jLabelGerencia4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelGerencia4.setForeground(new java.awt.Color(255, 204, 0));
        jLabelGerencia4.setText("Contraseña: *");
        getContentPane().add(jLabelGerencia4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, -1, -1));

        campoNombre.setBackground(new java.awt.Color(255, 204, 0));
        campoNombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        campoNombre.setForeground(new java.awt.Color(0, 0, 0));
        campoNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoNombre.setActionCommand("<Not Set>");
        campoNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        campoNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(campoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 210, 30));

        campoEmail.setBackground(new java.awt.Color(255, 204, 0));
        campoEmail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        campoEmail.setForeground(new java.awt.Color(0, 0, 0));
        campoEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoEmail.setActionCommand("<Not Set>");
        campoEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        campoEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(campoEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 210, 30));

        campoTelefono.setBackground(new java.awt.Color(255, 204, 0));
        campoTelefono.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        campoTelefono.setForeground(new java.awt.Color(0, 0, 0));
        campoTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoTelefono.setActionCommand("<Not Set>");
        campoTelefono.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        campoTelefono.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(campoTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 210, 30));

        campoUser.setBackground(new java.awt.Color(255, 204, 0));
        campoUser.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        campoUser.setForeground(new java.awt.Color(0, 0, 0));
        campoUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoUser.setActionCommand("<Not Set>");
        campoUser.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        campoUser.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(campoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 210, 30));

        comboRol.setBackground(new java.awt.Color(255, 204, 0));
        comboRol.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        comboRol.setForeground(new java.awt.Color(0, 0, 0));
        comboRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Gerente", "Tecnico" }));
        comboRol.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(comboRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 170, -1));

        jLabelGerencia5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelGerencia5.setForeground(new java.awt.Color(255, 204, 0));
        jLabelGerencia5.setText("Permisos de: *");
        getContentPane().add(jLabelGerencia5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        campoPass.setBackground(new java.awt.Color(255, 204, 51));
        campoPass.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        campoPass.setForeground(new java.awt.Color(0, 0, 0));
        campoPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoPass.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        getContentPane().add(campoPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 210, 30));

        campoDomicilio.setBackground(new java.awt.Color(255, 204, 0));
        campoDomicilio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        campoDomicilio.setForeground(new java.awt.Color(0, 0, 0));
        campoDomicilio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoDomicilio.setActionCommand("<Not Set>");
        campoDomicilio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        campoDomicilio.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(campoDomicilio, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 210, 30));

        jLabelAgregar2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelAgregar2.setForeground(new java.awt.Color(255, 204, 0));
        jLabelAgregar2.setText("Domicilio:");
        getContentPane().add(jLabelAgregar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("By TechPanther  @  2022");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, -1, -1));
        getContentPane().add(labelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnviarActionPerformed

        //Extraemos los datos de los JTextField y el JComboBox.
        String nombre = campoNombre.getText().trim();
        String email = campoEmail.getText().trim();
        String telefono = campoTelefono.getText().trim();
        String u = campoUser.getText().trim();
        String password = campoPass.getText().trim();
        String domicilio = campoDomicilio.getText().trim();
        String permisos = (String) comboRol.getSelectedItem();

        usuario = new UsoUsuarios();

        //Enviamos los datos a agregarUsuario en la Capa Controlador.
        if (usuario.agregarUsuario(nombre, email, telefono, domicilio, u, password, permisos, user)) {
        
            JOptionPane.showMessageDialog(this, "El usuario ha sido agregado correctamente!");
            
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
            java.util.logging.Logger.getLogger(agregarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(agregarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(agregarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(agregarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new agregarUsuario().setVisible(true);
            }
        });
    }

    private UsoUsuarios usuario;
    private String user = "";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEnviar;
    private javax.swing.JTextField campoDomicilio;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JPasswordField campoPass;
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
    private javax.swing.JLabel jLabelGerencia1;
    private javax.swing.JLabel jLabelGerencia2;
    private javax.swing.JLabel jLabelGerencia3;
    private javax.swing.JLabel jLabelGerencia4;
    private javax.swing.JLabel jLabelGerencia5;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelWallpaper;
    // End of variables declaration//GEN-END:variables
}
