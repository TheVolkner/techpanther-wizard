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
public class detalleCliente extends javax.swing.JFrame {

    /**
     * Creates new form Administrador
     */
    public detalleCliente() {
        initComponents();

        //Obtenemos el ID del cliente a modificar.
        id_cliente = listadoClientes.id_cliente;

        //Inicializamos el objeto usoClientes y usoEquipos
        usoCliente = new UsoClientes();
        usoEquipos = new usoEquipos();

        setResizable(false);
        setTitle("Detalle de Cliente - Sesión de " + Login.user);

        //Inicializamos el fondo
        ImageIcon imagen = new ImageIcon("src/images/FondoV3.png");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(labelWallpaper.getWidth(), labelWallpaper.getHeight(),
                Image.SCALE_DEFAULT));

        labelWallpaper.setIcon(icono);

        this.repaint();

        //Inicializamos el logo
        ImageIcon imagenLogo = new ImageIcon("src/images/tp.png");
        Icon iconoLogo = new ImageIcon(imagenLogo.getImage().getScaledInstance(labelLogo.getWidth(), labelLogo.getHeight(), Image.SCALE_DEFAULT));
        labelLogo.setIcon(iconoLogo);
        this.repaint();

        //Rellenamos los campos según el ID proveniente del listado.
        Object[] cliente = usoCliente.obtenerCliente(id_cliente);

        campoNombre.setText(cliente[1].toString());
        campoDomicilio.setText(cliente[2].toString());
        campoTelefono.setText(cliente[3].toString());
        campoEmail.setText(cliente[4].toString());
        campoUltModificacion.setText(cliente[5].toString());

        //Inicializamos la tabla con los equipos del cliente.
        tabla_equipos = usoEquipos.listarEquiposPorId(id_cliente);

        jScrollPane1.setViewportView(tabla_equipos);

        tabla_equipos.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                int row_point = tabla_equipos.rowAtPoint(e.getPoint());

                int column_point = 0;

                if (row_point > -1) {

                    id_equipo = (int) tabla_equipos.getValueAt(row_point, column_point);

                    new detalleEquipo().setVisible(true);

                    dispose();
                }

            }
        });

    }

    //Inicializamos el icono
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
        botonImprimir = new javax.swing.JButton();
        jLabelAgregar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelGerencia1 = new javax.swing.JLabel();
        jLabelAgregar1 = new javax.swing.JLabel();
        jLabelGerencia2 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        campoEmail = new javax.swing.JTextField();
        jLabelGerencia5 = new javax.swing.JLabel();
        botonActualizar = new javax.swing.JButton();
        campoDomicilio = new javax.swing.JTextField();
        jLabelAgregar2 = new javax.swing.JLabel();
        botonAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_equipos = new javax.swing.JTable();
        campoTelefono = new javax.swing.JTextField();
        campoUltModificacion = new javax.swing.JTextField();
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
        getContentPane().add(labelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 170, 130));

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
        getContentPane().add(botonImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 350, 60, 50));

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
        jLabelGerencia1.setText("  Imprimir Cliente");
        getContentPane().add(jLabelGerencia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 410, -1, -1));

        jLabelAgregar1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelAgregar1.setForeground(new java.awt.Color(255, 204, 0));
        jLabelAgregar1.setText("Nombre:");
        getContentPane().add(jLabelAgregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jLabelGerencia2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelGerencia2.setForeground(new java.awt.Color(255, 204, 0));
        jLabelGerencia2.setText("Email:");
        getContentPane().add(jLabelGerencia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        campoNombre.setBackground(new java.awt.Color(255, 204, 0));
        campoNombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        campoNombre.setForeground(new java.awt.Color(0, 0, 0));
        campoNombre.setActionCommand("<Not Set>");
        campoNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        campoNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(campoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 210, 30));

        campoEmail.setBackground(new java.awt.Color(255, 204, 0));
        campoEmail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        campoEmail.setForeground(new java.awt.Color(0, 0, 0));
        campoEmail.setActionCommand("<Not Set>");
        campoEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        campoEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(campoEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 210, 30));

        jLabelGerencia5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelGerencia5.setForeground(new java.awt.Color(255, 204, 0));
        jLabelGerencia5.setText("Ultima Modificacion:");
        getContentPane().add(jLabelGerencia5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, -1, -1));

        botonActualizar.setBackground(new java.awt.Color(255, 204, 0));
        botonActualizar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonActualizar.setForeground(new java.awt.Color(0, 0, 0));
        botonActualizar.setText("Actualizar Cliente");
        botonActualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(botonActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, 130, 30));

        campoDomicilio.setEditable(false);
        campoDomicilio.setBackground(new java.awt.Color(255, 204, 0));
        campoDomicilio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        campoDomicilio.setForeground(new java.awt.Color(0, 0, 0));
        campoDomicilio.setActionCommand("<Not Set>");
        campoDomicilio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        campoDomicilio.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(campoDomicilio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 210, 30));

        jLabelAgregar2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelAgregar2.setForeground(new java.awt.Color(255, 204, 0));
        jLabelAgregar2.setText("Domicilio:");
        getContentPane().add(jLabelAgregar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        botonAgregar.setBackground(new java.awt.Color(255, 204, 0));
        botonAgregar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonAgregar.setForeground(new java.awt.Color(0, 0, 0));
        botonAgregar.setText("Agregar Equipo");
        botonAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(botonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 130, 30));

        tabla_equipos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla_equipos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 390, 150));

        campoTelefono.setBackground(new java.awt.Color(255, 204, 0));
        campoTelefono.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        campoTelefono.setForeground(new java.awt.Color(0, 0, 0));
        campoTelefono.setActionCommand("<Not Set>");
        campoTelefono.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        campoTelefono.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(campoTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 210, 30));

        campoUltModificacion.setBackground(new java.awt.Color(255, 204, 0));
        campoUltModificacion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        campoUltModificacion.setForeground(new java.awt.Color(0, 0, 0));
        campoUltModificacion.setActionCommand("<Not Set>");
        campoUltModificacion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        campoUltModificacion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(campoUltModificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 210, 30));
        getContentPane().add(labelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed

        String texto = campoNombre.getText();
        String domicilio = campoDomicilio.getText();
        String telefono = campoTelefono.getText();
        String email = campoEmail.getText();
        String ultModi = Login.user;

        usoCliente.actualizarCliente(id_cliente, texto, domicilio, telefono, email, ultModi);

        dispose();
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        new agregarEquipo().setVisible(true);

        dispose();
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonImprimirActionPerformed
       usoCliente.imprimirCliente(id_cliente);
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
            java.util.logging.Logger.getLogger(detalleCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(detalleCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(detalleCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(detalleCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new detalleCliente().setVisible(true);
            }
        });
    }

    public static int id_equipo;
    private usoEquipos usoEquipos;
    private UsoClientes usoCliente;
    private int id_cliente;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonImprimir;
    private javax.swing.JTextField campoDomicilio;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoTelefono;
    private javax.swing.JTextField campoUltModificacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelAgregar;
    private javax.swing.JLabel jLabelAgregar1;
    private javax.swing.JLabel jLabelAgregar2;
    private javax.swing.JLabel jLabelGerencia1;
    private javax.swing.JLabel jLabelGerencia2;
    private javax.swing.JLabel jLabelGerencia5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelWallpaper;
    private javax.swing.JTable tabla_equipos;
    // End of variables declaration//GEN-END:variables
}
