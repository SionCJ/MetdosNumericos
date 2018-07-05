/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion;

import general.EnumFuncion;
import general.Funcion;

/**
 *
 * @author Sion
 */
public class FuncionChooser extends javax.swing.JDialog {
    static IntegralNumerica integral = new IntegralNumerica( new Funcion(EnumFuncion.X), -1, 1 );
    
    public FuncionChooser(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        btngroupFunciones = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblIntegral1 = new javax.swing.JLabel();
        lblIntegral2 = new javax.swing.JLabel();
        rbtnIntegral1 = new javax.swing.JRadioButton();
        rbtnIntegral2 = new javax.swing.JRadioButton();
        btnAceptar = new javax.swing.JButton();
        rbtnIntegral3 = new javax.swing.JRadioButton();
        rbtnIntegral4 = new javax.swing.JRadioButton();
        rbtnIntegral5 = new javax.swing.JRadioButton();
        lblIntegral3 = new javax.swing.JLabel();
        lblIntegral4 = new javax.swing.JLabel();
        lblIntegral5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Elegir funcion");
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(350, 450));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        lblIntegral1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/integracion/int1_def.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 0.2;
        jPanel1.add(lblIntegral1, gridBagConstraints);

        lblIntegral2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/integracion/int2_def.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 0.2;
        jPanel1.add(lblIntegral2, gridBagConstraints);

        btngroupFunciones.add(rbtnIntegral1);
        rbtnIntegral1.setSelected(true);
        rbtnIntegral1.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel1.add(rbtnIntegral1, gridBagConstraints);

        btngroupFunciones.add(rbtnIntegral2);
        rbtnIntegral2.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel1.add(rbtnIntegral2, gridBagConstraints);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.weightx = 0.3;
        jPanel1.add(btnAceptar, gridBagConstraints);

        btngroupFunciones.add(rbtnIntegral3);
        rbtnIntegral3.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 0.4;
        jPanel1.add(rbtnIntegral3, gridBagConstraints);

        btngroupFunciones.add(rbtnIntegral4);
        rbtnIntegral4.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        jPanel1.add(rbtnIntegral4, gridBagConstraints);

        btngroupFunciones.add(rbtnIntegral5);
        rbtnIntegral5.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel1.add(rbtnIntegral5, gridBagConstraints);

        lblIntegral3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/integracion/int3_def.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.2;
        jPanel1.add(lblIntegral3, gridBagConstraints);

        lblIntegral4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/integracion/int4.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 0.2;
        jPanel1.add(lblIntegral4, gridBagConstraints);

        lblIntegral5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/integracion/int5_def.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 0.2;
        jPanel1.add(lblIntegral5, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        Funcion f = null;
        java.awt.Color color = new java.awt.Color(0,204,51);
        System.out.println("Color Choose= "+color);
        if( rbtnIntegral1.isSelected() ){
            f = new Funcion(EnumFuncion.INT1, color);
            f.setImagen( lblIntegral1.getIcon() );
            integral = new IntegralNumerica(f, 0, 1);
        }
        else if( rbtnIntegral2.isSelected() ){
            f = new Funcion(EnumFuncion.INT2, color);
            f.setImagen( lblIntegral2.getIcon() );
            integral = new IntegralNumerica(f, 2, 4);
        }
        else if( rbtnIntegral3.isSelected() ){
            f = new Funcion(EnumFuncion.INT3, color);
            f.setImagen( lblIntegral3.getIcon() );
            integral = new IntegralNumerica(f, 1, 2);
        }
        else if( rbtnIntegral4.isSelected() ) {
            f = new Funcion(EnumFuncion.INT4, color);
            f.setImagen( lblIntegral4.getIcon() );
            integral = new IntegralNumerica(f, -1, 1);
        }
        else{
            f = new Funcion(EnumFuncion.INT5, color);
            f.setImagen( lblIntegral5.getIcon() );
            integral = new IntegralNumerica(f, -Math.PI, Math.PI);
        }
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    public static IntegralNumerica showDialog(java.awt.Component parent){
        FuncionChooser dialog = new FuncionChooser(new javax.swing.JFrame(), true);
        java.awt.Point p = parent.getLocation();
        dialog.setLocation(p.x+parent.getWidth(), p.y+parent.getHeight());
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        dialog.setVisible(true);
        return integral;
    }
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
            java.util.logging.Logger.getLogger(FuncionChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FuncionChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FuncionChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FuncionChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FuncionChooser dialog = new FuncionChooser(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.ButtonGroup btngroupFunciones;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblIntegral1;
    private javax.swing.JLabel lblIntegral2;
    private javax.swing.JLabel lblIntegral3;
    private javax.swing.JLabel lblIntegral4;
    private javax.swing.JLabel lblIntegral5;
    private javax.swing.JRadioButton rbtnIntegral1;
    private javax.swing.JRadioButton rbtnIntegral2;
    private javax.swing.JRadioButton rbtnIntegral3;
    private javax.swing.JRadioButton rbtnIntegral4;
    private javax.swing.JRadioButton rbtnIntegral5;
    // End of variables declaration//GEN-END:variables
}
