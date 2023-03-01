package techPanther.vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;
import techPanther.controlador.usoEquipos;

/**
 *
 * @author Kendrick
 */
public class graficaEstatus extends javax.swing.JFrame {

    /**
     * Creates new form Administrador
     */
    public graficaEstatus() {
        initComponents();

        //Extraemos el nomrbe del usuario proveniente del Login.
        user = Login.user;

        setResizable(false);
        setTitle("Agregar Cliente - Sesión de " + user);

        //Inicializamos el objeto usoUsuarios
        usoEquipos = new usoEquipos();

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

        //Obtenemos los estatus de los equipos
        int[] estatus = usoEquipos.seleccionarEstatus();

        nuevo = estatus[0];
        enRevision = estatus[1];
        reparado = estatus[2];
        noReparado = estatus[3];
        entregado = estatus[4];

    }

    //Inicializamos el icono
    @Override
    public Image getIconImage() {

        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icono.png"));
        return retValue;
    }

    public int valorMayor(int valor_nuevo, int valor_revision, int valor_reparado, int valor_noReparado, int valor_entregado) {

        if (valor_nuevo > valor_entregado && valor_nuevo > valor_noReparado && valor_nuevo > valor_reparado && valor_nuevo > valor_revision) {

            return valor_nuevo;

        } else if (valor_noReparado > valor_entregado && valor_noReparado > valor_nuevo && valor_noReparado > valor_reparado
                && valor_noReparado > valor_revision) {

            return valor_noReparado;

        } else if (valor_nuevo > valor_entregado && valor_nuevo > valor_noReparado && valor_nuevo > valor_reparado
                && valor_nuevo > valor_revision) {

            return valor_nuevo;

        } else if (valor_reparado > valor_entregado && valor_reparado > valor_noReparado && valor_reparado > valor_nuevo
                && valor_reparado > valor_revision) {

            return valor_reparado;
        } else {

            return valor_revision;
        }
    }

    public void paint(Graphics g) {

        super.paint(g);

        int cantidad_total = valorMayor(nuevo,enRevision,reparado,noReparado,entregado);

        int largo_nuevo = nuevo * 200 / cantidad_total;
        int largo_revision = enRevision * 200 / cantidad_total;
        int largo_reparado = reparado * 200 / cantidad_total;
        int largo_noReparado = noReparado * 200 / cantidad_total;
        int largo_entregado = entregado * 200 / cantidad_total;

        g.setColor(new Color(255, 255, 255));
        g.fillRect(130, 150, largo_nuevo, 30);
        g.drawString("Nuevo Ingreso", 25, 170);

        g.setColor(new Color(51, 153, 255));
        g.fillRect(130, 200, largo_revision, 30);
        g.drawString("En Revisión", 25, 220);

        g.setColor(new Color(0, 140, 0));
        g.fillRect(130, 250, largo_reparado, 30);
        g.drawString("Reparado", 25, 270);

        g.setColor(new Color(140, 0, 0));
        g.fillRect(130, 300, largo_noReparado, 30);
        g.drawString("No Reparado", 25, 320);

        g.setColor(new Color(255, 255, 50));
        g.fillRect(130, 350, largo_entregado, 30);
        g.drawString("Entregado", 25, 370);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
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

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("By TechPanther  @  2022");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, -1, -1));
        getContentPane().add(labelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(graficaEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(graficaEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(graficaEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(graficaEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new graficaEstatus().setVisible(true);
            }
        });
    }

    int nuevo, enRevision, reparado, noReparado, entregado;
    private usoEquipos usoEquipos;
    private String user;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelWallpaper;
    // End of variables declaration//GEN-END:variables
}
