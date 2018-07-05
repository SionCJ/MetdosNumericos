package taylor;

import integracion.PanelIntegracion;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import raices.PanelRaiz;
import sist_ecuaciones.PanelSistemaEcuaciones;

public class Ventana extends javax.swing.JFrame {

    public Ventana() {
        super("Metodos Numericos");
        initComponents();
        setIconImage( new ImageIcon( getClass().getResource("recursos/icon_graph3.png") ).getImage() );
        //System.out.println(getContentPane().getPreferredSize());
        //System.out.println(getContentPane().getBounds());
        
        PanelGrafica pnlGraficas = new PanelGrafica();
        pnlAprox.add(pnlGraficas, BorderLayout.CENTER);
        
        PanelRaiz pnlRaiz = new PanelRaiz();
        pnlTabRaices.add(pnlRaiz, BorderLayout.CENTER);
        
        PanelSistemaEcuaciones pnlSistemaEc = new PanelSistemaEcuaciones();
        pnlTabSistemaEc.add(pnlSistemaEc, BorderLayout.CENTER);
        
        interpolacion.PanelInterpolacion pnlInterpolacion = new interpolacion.PanelInterpolacion();
        pnlTabInterpolacion.add(pnlInterpolacion, BorderLayout.CENTER);
        
        PanelIntegracion pnlIntegracion = new PanelIntegracion();
        pnlTabIntegracion.add(pnlIntegracion, BorderLayout.CENTER);
        //pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabPane = new javax.swing.JTabbedPane();
        pnlAprox = new javax.swing.JPanel();
        pnlTabRaices = new javax.swing.JPanel();
        pnlTabSistemaEc = new javax.swing.JPanel();
        pnlTabInterpolacion = new javax.swing.JPanel();
        pnlTabIntegracion = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);

        TabPane.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TabPane.setPreferredSize(getPreferredSize());

        pnlAprox.setAutoscrolls(true);
        pnlAprox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnlAprox.setLayout(new javax.swing.BoxLayout(pnlAprox, javax.swing.BoxLayout.LINE_AXIS));
        TabPane.addTab("Aproximacion Taylor", pnlAprox);

        pnlTabRaices.setBackground(new java.awt.Color(204, 204, 255));
        pnlTabRaices.setLayout(new java.awt.BorderLayout());
        TabPane.addTab("Raices de Funcion", pnlTabRaices);

        pnlTabSistemaEc.setLayout(new javax.swing.BoxLayout(pnlTabSistemaEc, javax.swing.BoxLayout.LINE_AXIS));
        TabPane.addTab("Sistema de ecuaciones", pnlTabSistemaEc);

        pnlTabInterpolacion.setLayout(new javax.swing.BoxLayout(pnlTabInterpolacion, javax.swing.BoxLayout.LINE_AXIS));
        TabPane.addTab("Interpolacion", pnlTabInterpolacion);

        pnlTabIntegracion.setLayout(new javax.swing.BoxLayout(pnlTabIntegracion, javax.swing.BoxLayout.LINE_AXIS));
        TabPane.addTab("Integracion Numerica", pnlTabIntegracion);

        getContentPane().add(TabPane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
                javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane TabPane;
    private javax.swing.JPanel pnlAprox;
    private javax.swing.JPanel pnlTabIntegracion;
    private javax.swing.JPanel pnlTabInterpolacion;
    private javax.swing.JPanel pnlTabRaices;
    private javax.swing.JPanel pnlTabSistemaEc;
    // End of variables declaration//GEN-END:variables
    
}
