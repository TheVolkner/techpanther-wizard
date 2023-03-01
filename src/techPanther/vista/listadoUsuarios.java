package techPanther.vista;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import techPanther.controlador.*;

/**
 *
 * @author Kendrick
 */
public class listadoUsuarios extends javax.swing.JFrame {

    /**
     * Creates new form Administrador
     */
    public listadoUsuarios() {
        initComponents();

        setTitle("Listado de Usuarios - Sesión de " + Login.user);
        setResizable(false);

        //Inicializamos el objeto del tipo de la clase controlador.
        usoUsuarios = new UsoUsuarios();

        //DEFINIMOS SI EN ESTA VENTANA SE MOSTRARÁN LOS BOTONES PARA IMPORTAR O EXPORTAR UNA TABLA DE EXCEL.
        if (Login.permisos.equals("Administrador")) {

            labelExcel.setVisible(true);
            botonImportar.setVisible(true);
            botonExportar.setVisible(true);
        } else {

            labelExcel.setVisible(false);
            botonImportar.setVisible(false);
            botonExportar.setVisible(false);
        }

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

        //Rellenar los valores del JTable.
        //el método devuelve un JTable, por lo tanto inicializamos la tabla de esta clase con el que proviene del controlador.
        tabla_usuarios = usoUsuarios.listarUsuarios();
        //agregamos la tabla al scrollpane
        jScrollPane1.setViewportView(tabla_usuarios);

        //añadimos un mouseEvent con el que vamos a poder capturar el evento que se dispare al dar click en alguna fila de la tabla.
        tabla_usuarios.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                //identificamos cual fila es, la columna siempre será la del ID (la primera, la #0)
                int fila_point = tabla_usuarios.rowAtPoint(e.getPoint());

                int columna_point = 0;

                if (fila_point > -1) {

                    id_usuario = (int) tabla_usuarios.getValueAt(fila_point, columna_point);

                    new detalleUsuario().setVisible(true);

                    dispose();
                }

            }

        });

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
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_usuarios = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        botonExportar = new javax.swing.JButton();
        labelExcel = new javax.swing.JLabel();
        botonImportar = new javax.swing.JButton();
        labelWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 51));
        jLabel5.setText("Sistema de Control y Gestión");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 450, 60));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 51));
        jLabel1.setText("Usuarios Registrados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 230, 60));
        getContentPane().add(labelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 190, 150));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("By TechPanther  @  2022");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, -1, -1));

        tabla_usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tabla_usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_usuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_usuarios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 650, 220));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 51));
        jLabel2.setText("TECHPANTHER WIZARD");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 360, 70));

        botonExportar.setBackground(new java.awt.Color(255, 204, 0));
        botonExportar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonExportar.setForeground(new java.awt.Color(0, 0, 0));
        botonExportar.setText("Exportar");
        botonExportar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botonExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonExportarActionPerformed(evt);
            }
        });
        getContentPane().add(botonExportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 70, 30));

        labelExcel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        labelExcel.setForeground(new java.awt.Color(255, 204, 51));
        labelExcel.setText("Tabla de datos Excel:");
        getContentPane().add(labelExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 200, 50));

        botonImportar.setBackground(new java.awt.Color(255, 204, 0));
        botonImportar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonImportar.setForeground(new java.awt.Color(0, 0, 0));
        botonImportar.setText("Importar");
        botonImportar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botonImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonImportarActionPerformed(evt);
            }
        });
        getContentPane().add(botonImportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 70, 30));
        getContentPane().add(labelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabla_usuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_usuariosMouseClicked


    }//GEN-LAST:event_tabla_usuariosMouseClicked

    private void botonExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExportarActionPerformed

        JFileChooser leeArchivo = new JFileChooser();

        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos Excel", "xls", "xlsx");

        leeArchivo.setFileFilter(filtro);

        int retorno = leeArchivo.showOpenDialog(this);

        if (retorno == JFileChooser.APPROVE_OPTION) {

            System.out.println("Has elegido abrir el archivo: " + leeArchivo.getSelectedFile().getAbsolutePath());

            File archivo = leeArchivo.getSelectedFile();

            String txt = usoUsuarios.exportarTabla(archivo, tabla_usuarios);

            JOptionPane.showMessageDialog(this, txt);
        }

    }//GEN-LAST:event_botonExportarActionPerformed

    private void botonImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonImportarActionPerformed
        JFileChooser leeArchivo = new JFileChooser();

        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos Excel", "xls", "xlsx");

        leeArchivo.setFileFilter(filtro);

        int retorno = leeArchivo.showOpenDialog(this);

        if (retorno == JFileChooser.APPROVE_OPTION) {

            System.out.println("Has elegido abrir el archivo: " + leeArchivo.getSelectedFile().getAbsolutePath());

            File archivo = leeArchivo.getSelectedFile();

            String txt = usoUsuarios.importarTabla(tabla_usuarios, archivo);

            JOptionPane.showMessageDialog(this, txt);
        }
    }//GEN-LAST:event_botonImportarActionPerformed

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
            java.util.logging.Logger.getLogger(listadoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listadoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listadoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listadoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listadoUsuarios().setVisible(true);
            }
        });
    }

    public static int id_usuario;
    private UsoUsuarios usoUsuarios;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonExportar;
    private javax.swing.JButton botonImportar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelExcel;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelWallpaper;
    private javax.swing.JTable tabla_usuarios;
    // End of variables declaration//GEN-END:variables
}
