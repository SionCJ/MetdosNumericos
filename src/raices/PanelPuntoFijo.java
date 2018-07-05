/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raices;

import general.EnumFuncion;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Sion
 */
public class PanelPuntoFijo extends javax.swing.JPanel {

    /**
     * Creates new form PanelPuntoFijo
     */
    public PanelPuntoFijo() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupFxPtoFijo = new javax.swing.ButtonGroup();
        groupGxPtoFijo = new javax.swing.ButtonGroup();
        pnlFxPtoFijo = new javax.swing.JPanel();
        rbtnFx1Pf = new javax.swing.JRadioButton();
        rbtnFx2Pf = new javax.swing.JRadioButton();
        rbtnFx3Pf = new javax.swing.JRadioButton();
        lblFx3Pf = new javax.swing.JLabel();
        lblFx1Pf = new javax.swing.JLabel();
        lblFx2Pf = new javax.swing.JLabel();
        scllPnGxPtoFijo = new javax.swing.JScrollPane();
        pnlGxPtoFijo = new javax.swing.JPanel();
        rbtnGx1Pf = new javax.swing.JRadioButton();
        rbtnGx2Pf = new javax.swing.JRadioButton();
        rbtnGx3Pf = new javax.swing.JRadioButton();
        rbtnGx4Pf = new javax.swing.JRadioButton();
        lblGx1Pf = new javax.swing.JLabel();
        lblGx2Pf = new javax.swing.JLabel();
        lblGx3Pf = new javax.swing.JLabel();
        lblGx4Pf = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Funcion", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        setMinimumSize(new java.awt.Dimension(163, 389));

        pnlFxPtoFijo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        groupFxPtoFijo.add(rbtnFx1Pf);
        rbtnFx1Pf.setSelected(true);
        rbtnFx1Pf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnFx1PfActionPerformed(evt);
            }
        });
        pnlFxPtoFijo.add(rbtnFx1Pf, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 7, -1, -1));

        groupFxPtoFijo.add(rbtnFx2Pf);
        rbtnFx2Pf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnFx2PfActionPerformed(evt);
            }
        });
        pnlFxPtoFijo.add(rbtnFx2Pf, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 46, -1, -1));

        groupFxPtoFijo.add(rbtnFx3Pf);
        rbtnFx3Pf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnFx3PfActionPerformed(evt);
            }
        });
        pnlFxPtoFijo.add(rbtnFx3Pf, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 85, -1, -1));

        lblFx3Pf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/taylor/recursos/fxPf3.png"))); // NOI18N
        pnlFxPtoFijo.add(lblFx3Pf, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 85, -1, -1));

        lblFx1Pf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/taylor/recursos/fxPf1.png"))); // NOI18N
        pnlFxPtoFijo.add(lblFx1Pf, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 12, -1, -1));

        lblFx2Pf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/taylor/recursos/fx1.png"))); // NOI18N
        pnlFxPtoFijo.add(lblFx2Pf, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 46, -1, -1));

        scllPnGxPtoFijo.setBorder(javax.swing.BorderFactory.createTitledBorder("Elegir funcion g(x)"));

        pnlGxPtoFijo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        groupGxPtoFijo.add(rbtnGx1Pf);
        rbtnGx1Pf.setSelected(true);
        pnlGxPtoFijo.add(rbtnGx1Pf, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 13, -1, -1));

        groupGxPtoFijo.add(rbtnGx2Pf);
        pnlGxPtoFijo.add(rbtnGx2Pf, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 66, -1, -1));

        groupGxPtoFijo.add(rbtnGx3Pf);
        pnlGxPtoFijo.add(rbtnGx3Pf, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 123, -1, -1));

        groupGxPtoFijo.add(rbtnGx4Pf);
        pnlGxPtoFijo.add(rbtnGx4Pf, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 181, -1, -1));

        lblGx1Pf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/taylor/recursos/gx1Pf1.png"))); // NOI18N
        pnlGxPtoFijo.add(lblGx1Pf, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, -1, -1));

        lblGx2Pf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/taylor/recursos/gx2Pf1.png"))); // NOI18N
        pnlGxPtoFijo.add(lblGx2Pf, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 57, -1, -1));

        lblGx3Pf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/taylor/recursos/gx3Pf1.png"))); // NOI18N
        pnlGxPtoFijo.add(lblGx3Pf, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 116, -1, -1));

        lblGx4Pf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/taylor/recursos/gx4Pf1.png"))); // NOI18N
        pnlGxPtoFijo.add(lblGx4Pf, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 175, -1, -1));

        scllPnGxPtoFijo.setViewportView(pnlGxPtoFijo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scllPnGxPtoFijo)
            .addComponent(pnlFxPtoFijo, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlFxPtoFijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(scllPnGxPtoFijo, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnFx1PfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnFx1PfActionPerformed
        lblGx1Pf.setIcon( new ImageIcon(getClass().getResource("/taylor/recursos/gx1Pf1.png")) );
        lblGx2Pf.setIcon( new ImageIcon(getClass().getResource("/taylor/recursos/gx2Pf1.png")) );
        lblGx3Pf.setIcon( new ImageIcon(getClass().getResource("/taylor/recursos/gx3Pf1.png")) );
        lblGx4Pf.setIcon( new ImageIcon(getClass().getResource("/taylor/recursos/gx4Pf1.png")) );
        rbtnGx2Pf.setEnabled(true);
        rbtnGx3Pf.setEnabled(true);
        rbtnGx4Pf.setEnabled(true);
    }//GEN-LAST:event_rbtnFx1PfActionPerformed

    private void rbtnFx2PfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnFx2PfActionPerformed
        lblGx1Pf.setIcon( new ImageIcon(getClass().getResource("/taylor/recursos/gx1Pf2.png")) );
        lblGx2Pf.setIcon( new ImageIcon(getClass().getResource("/taylor/recursos/gx2Pf2.png")) );
        lblGx3Pf.setIcon( new ImageIcon(getClass().getResource("/taylor/recursos/gx3Pf2.png")) );
        lblGx4Pf.setIcon( new ImageIcon(getClass().getResource("/taylor/recursos/gx4Pf2.png")) );
        rbtnGx2Pf.setEnabled(true);
        rbtnGx3Pf.setEnabled(true);
        rbtnGx4Pf.setEnabled(true);
    }//GEN-LAST:event_rbtnFx2PfActionPerformed

    private void rbtnFx3PfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnFx3PfActionPerformed
        rbtnFx3Pf.setSelected(true);
        lblGx1Pf.setIcon( new ImageIcon(getClass().getResource("/taylor/recursos/gx1Pf3.png")) );
        rbtnGx2Pf.setEnabled(false);
        rbtnGx3Pf.setEnabled(false);
        rbtnGx4Pf.setEnabled(false);
        lblGx2Pf.setIcon(null);
        lblGx3Pf.setIcon(null);
        lblGx4Pf.setIcon(null);
    }//GEN-LAST:event_rbtnFx3PfActionPerformed

    public EnumFuncion getFuncionFx(){
        if( rbtnFx1Pf.isSelected() ){
            return EnumFuncion.FX_PF1;
        }
        else if( rbtnFx2Pf.isSelected() ){
            return EnumFuncion.FX_PF2;
        }
        else
            return EnumFuncion.FX_PF3;
    }
    
    public EnumFuncion getFuncionGx(){
        if( rbtnFx1Pf.isSelected() ){
            if( rbtnGx1Pf.isSelected() )
                return EnumFuncion.GX_A1;
            else if( rbtnGx2Pf.isSelected() )
                return EnumFuncion.GX_A2;
            else if( rbtnGx3Pf.isSelected() )
                return EnumFuncion.GX_A3;
            else
                return EnumFuncion.GX_A4;
        }
        else if( rbtnFx2Pf.isSelected() ){
            if( rbtnGx1Pf.isSelected() ){
                 JOptionPane.showMessageDialog(null, "GX_B1");
                return EnumFuncion.GX_B1;
            }
            else if( rbtnGx2Pf.isSelected() )
                return EnumFuncion.GX_B2;
            else if( rbtnGx3Pf.isSelected() )
                return EnumFuncion.GX_B3;
            else
                return EnumFuncion.GX_B4;
        }
        else
            return EnumFuncion.GX_C;
    }
    
    public static void main(String[] args){
        javax.swing.JFrame v = new javax.swing.JFrame();
        v.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        v.add(new PanelPuntoFijo());
        v.pack();
        v.setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup groupFxPtoFijo;
    private javax.swing.ButtonGroup groupGxPtoFijo;
    private javax.swing.JLabel lblFx1Pf;
    private javax.swing.JLabel lblFx2Pf;
    private javax.swing.JLabel lblFx3Pf;
    private javax.swing.JLabel lblGx1Pf;
    private javax.swing.JLabel lblGx2Pf;
    private javax.swing.JLabel lblGx3Pf;
    private javax.swing.JLabel lblGx4Pf;
    private javax.swing.JPanel pnlFxPtoFijo;
    private javax.swing.JPanel pnlGxPtoFijo;
    private javax.swing.JRadioButton rbtnFx1Pf;
    private javax.swing.JRadioButton rbtnFx2Pf;
    private javax.swing.JRadioButton rbtnFx3Pf;
    private javax.swing.JRadioButton rbtnGx1Pf;
    private javax.swing.JRadioButton rbtnGx2Pf;
    private javax.swing.JRadioButton rbtnGx3Pf;
    private javax.swing.JRadioButton rbtnGx4Pf;
    private javax.swing.JScrollPane scllPnGxPtoFijo;
    // End of variables declaration//GEN-END:variables
}
