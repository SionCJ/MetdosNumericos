/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion;

import general.DoublePar;
import general.EnumFuncion;
import general.Funcion;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JOptionPane;
import taylor.Plano;

public class PanelIntegracion extends javax.swing.JPanel {
    HijoPlano plano;
    IntegralNumerica integral;
    /* Crea new form PanelIntegracion
     */
    public PanelIntegracion() {
        initComponents();
        plano = new HijoPlano();
        plano.setMinimumSize(new java.awt.Dimension(500, 450));
        plano.setPreferredSize(new java.awt.Dimension(500, 450));
        add(plano, java.awt.BorderLayout.CENTER);
        integral = new IntegralNumerica( new Funcion(EnumFuncion.INT1, new Color(0,204,51)), 0, 1);
//        spinEjeXmax.setVisible(false);
//        spinEjeXmin.setVisible(false);
//        plano.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseEntered(java.awt.event.MouseEvent evt) {
//                spinEjeXminMouseEntered(evt);
//            }
//            public void mouseExited(java.awt.event.MouseEvent evt) {
//                spinEjeXminMouseExited(evt);
//            }
//        });
//        spinEjeXmax.addChangeListener(new javax.swing.event.ChangeListener() {
//            public void stateChanged(javax.swing.event.ChangeEvent evt) {
//                spinEjeXminStateChanged(evt);
//            }
//        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup = new javax.swing.ButtonGroup();
        pnlControles = new javax.swing.JPanel();
        pnlIntegral = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        spinLimiteInf = new javax.swing.JSpinner();
        spinLimiteSup = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnElegirFuncion = new javax.swing.JButton();
        lblIntegral = new javax.swing.JLabel();
        pnlMetodo = new javax.swing.JPanel();
        spinNumIntervalos = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        rbtnCompuesto = new javax.swing.JRadioButton();
        rbtnSimple = new javax.swing.JRadioButton();
        cmboxMetodo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        pnlSolucion = new javax.swing.JPanel();
        btnIntegrar = new javax.swing.JButton();
        txtfSolucion = new javax.swing.JTextField();
        pnlVista = new javax.swing.JPanel();
        spinXmin = new javax.swing.JSpinner();
        lblX = new javax.swing.JLabel();
        spinXmax = new javax.swing.JSpinner();
        btnAceptarVista = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new java.awt.BorderLayout());

        pnlControles.setPreferredSize(new java.awt.Dimension(300, 300));
        pnlControles.setLayout(new javax.swing.BoxLayout(pnlControles, javax.swing.BoxLayout.Y_AXIS));

        pnlIntegral.setBackground(new java.awt.Color(255, 255, 255));
        pnlIntegral.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51)), "Funcion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        pnlIntegral.setPreferredSize(new java.awt.Dimension(262, 130));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Limites");

        spinLimiteInf.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), null, null, Double.valueOf(1.0d)));

        spinLimiteSup.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(1.0d), null, null, Double.valueOf(1.0d)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("a:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("b");

        btnElegirFuncion.setBackground(new java.awt.Color(255, 255, 255));
        btnElegirFuncion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/flecha1.png"))); // NOI18N
        btnElegirFuncion.setToolTipText("Elegir Funcion");
        btnElegirFuncion.setBorder(null);
        btnElegirFuncion.setOpaque(false);
        btnElegirFuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirFuncionActionPerformed(evt);
            }
        });

        lblIntegral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/integracion/int1.png"))); // NOI18N

        javax.swing.GroupLayout pnlIntegralLayout = new javax.swing.GroupLayout(pnlIntegral);
        pnlIntegral.setLayout(pnlIntegralLayout);
        pnlIntegralLayout.setHorizontalGroup(
            pnlIntegralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIntegralLayout.createSequentialGroup()
                .addGroup(pnlIntegralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlIntegralLayout.createSequentialGroup()
                        .addContainerGap(38, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(spinLimiteInf, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinLimiteSup, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlIntegralLayout.createSequentialGroup()
                        .addGroup(pnlIntegralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(pnlIntegralLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(lblIntegral)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnElegirFuncion)))
                .addContainerGap())
        );
        pnlIntegralLayout.setVerticalGroup(
            pnlIntegralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIntegralLayout.createSequentialGroup()
                .addGroup(pnlIntegralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIntegral)
                    .addGroup(pnlIntegralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnElegirFuncion)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(pnlIntegralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinLimiteInf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinLimiteSup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(25, 25, 25))
        );

        btnElegirFuncion.getAccessibleContext().setAccessibleName("Elegir Funcion");

        pnlControles.add(pnlIntegral);

        pnlMetodo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Metodo de solucion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        pnlMetodo.setPreferredSize(new java.awt.Dimension(277, 150));

        spinNumIntervalos.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(4), Integer.valueOf(1), null, Integer.valueOf(1)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Numero de intervalos");

        btnGroup.add(rbtnCompuesto);
        rbtnCompuesto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbtnCompuesto.setSelected(true);
        rbtnCompuesto.setText("compuesto");
        rbtnCompuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnCompuestoActionPerformed(evt);
            }
        });

        btnGroup.add(rbtnSimple);
        rbtnSimple.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbtnSimple.setText("simple");
        rbtnSimple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnSimpleActionPerformed(evt);
            }
        });

        cmboxMetodo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmboxMetodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Trapecio", "Simpson 1/3", "Simpson 3/8" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Metodo de integracion:");

        javax.swing.GroupLayout pnlMetodoLayout = new javax.swing.GroupLayout(pnlMetodo);
        pnlMetodo.setLayout(pnlMetodoLayout);
        pnlMetodoLayout.setHorizontalGroup(
            pnlMetodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMetodoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMetodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMetodoLayout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(spinNumIntervalos, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(pnlMetodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlMetodoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addGap(18, 18, 18)
                    .addGroup(pnlMetodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(rbtnCompuesto)
                        .addComponent(rbtnSimple)
                        .addComponent(cmboxMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlMetodoLayout.setVerticalGroup(
            pnlMetodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMetodoLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(pnlMetodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(spinNumIntervalos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(pnlMetodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlMetodoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnlMetodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cmboxMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(rbtnSimple)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(rbtnCompuesto)
                    .addContainerGap(61, Short.MAX_VALUE)))
        );

        pnlControles.add(pnlMetodo);

        pnlSolucion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Solucion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        pnlSolucion.setPreferredSize(new java.awt.Dimension(278, 124));
        pnlSolucion.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 20));

        btnIntegrar.setText("Integrar");
        btnIntegrar.setPreferredSize(new java.awt.Dimension(80, 23));
        btnIntegrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIntegrarActionPerformed(evt);
            }
        });
        pnlSolucion.add(btnIntegrar);

        txtfSolucion.setEditable(false);
        txtfSolucion.setBackground(new java.awt.Color(230, 255, 230));
        txtfSolucion.setPreferredSize(new java.awt.Dimension(220, 23));
        pnlSolucion.add(txtfSolucion);

        pnlControles.add(pnlSolucion);

        pnlVista.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vista", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        pnlVista.setPreferredSize(new java.awt.Dimension(397, 100));
        pnlVista.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 20));

        spinXmin.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(-5.0d), null, null, Double.valueOf(1.0d)));
        spinXmin.setPreferredSize(new java.awt.Dimension(90, 20));
        pnlVista.add(spinXmin);

        lblX.setText("<  X  <");
        pnlVista.add(lblX);

        spinXmax.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(5.0d), null, null, Double.valueOf(1.0d)));
        spinXmax.setPreferredSize(new java.awt.Dimension(90, 20));
        pnlVista.add(spinXmax);

        btnAceptarVista.setText("Aceptar");
        btnAceptarVista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarVistaActionPerformed(evt);
            }
        });
        pnlVista.add(btnAceptarVista);

        pnlControles.add(pnlVista);

        add(pnlControles, java.awt.BorderLayout.LINE_START);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIntegrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIntegrarActionPerformed
//        func = new Funcion(EnumFuncion.INT1);
        double limInf = (double) spinLimiteInf.getValue();
        double limSup = (double) spinLimiteSup.getValue();
        int numInt = (int) spinNumIntervalos.getValue();
        double resultado=0;
        
//        if( limInf==limSup ){
//            JOptionPane.showMessageDialog(null, "Los puntos no deben ser iguales", "Error en Datos", JOptionPane.ERROR_MESSAGE);
//        }
//        else 
        if( limInf>limSup ){
//        System.out.println("Intercambiando puntos");
            double aux = limInf;
            limInf = limSup;
            limSup = aux;
            spinLimiteInf.setValue(limInf);
            spinLimiteSup.setValue(limSup);
        }
        
        integral = new IntegralNumerica( integral.getFuncion(), limInf, limSup);
        switch( cmboxMetodo.getSelectedIndex() ){
            // TRAPECIO SELECCIONADO
            case 0: if( rbtnSimple.isSelected() )
                        resultado = integral.calcularTrapecio(1);
                    else
                        resultado = integral.calcularTrapecio(numInt);
                break;
            // SIMPSON 1/3 SELECCIONADO
            case 1: if( rbtnSimple.isSelected() )
                        resultado = integral.calcularSimpson_1tercio(1);
                    else
                        resultado = integral.calcularSimpson_1tercio(numInt);
                break;
            // SIMPSON 3/8 SELECCIONADO
            case 2: if( rbtnSimple.isSelected() )
                        resultado = integral.calcularSimpson_3octavos(1);
                    else
                        resultado = integral.calcularSimpson_3octavos(numInt);
                break;
        }
        
        double rango = limSup-limInf;        
        spinXmin.setValue(limInf-rango/20);
        spinXmax.setValue(limSup+rango/20);
        establecerVista();
        
        txtfSolucion.setText(""+resultado);
        plano.eliminarFunciones();
        plano.addFuncion( integral.getFuncion() );
        plano.repaint();
//        plano.update(plano.getGraphics());
    }//GEN-LAST:event_btnIntegrarActionPerformed

    private void btnAceptarVistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarVistaActionPerformed
        establecerVista();
        plano.repaint();
    }//GEN-LAST:event_btnAceptarVistaActionPerformed

    private void rbtnSimpleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnSimpleActionPerformed
        spinNumIntervalos.setEnabled(false);
    }//GEN-LAST:event_rbtnSimpleActionPerformed

    private void rbtnCompuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnCompuestoActionPerformed
        spinNumIntervalos.setEnabled(true);
    }//GEN-LAST:event_rbtnCompuestoActionPerformed

    private void btnElegirFuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirFuncionActionPerformed
        integral = FuncionChooser.showDialog(btnElegirFuncion);
        Funcion func = integral.getFuncion();
        lblIntegral.setIcon( func.getImagen() );
        general.DoublePar limites = integral.getLimites();
        spinLimiteInf.setValue( limites.pto1 );
        spinLimiteSup.setValue( limites.pto2 );
//        JOptionPane.showMessageDialog(null, ""+func.evaluar(2));
    }//GEN-LAST:event_btnElegirFuncionActionPerformed
    
    private void establecerVista(){
        double xmin, xmax, rango;
        Funcion func = integral.getFuncion();
        try{
//            xmin = Double.parseDouble( txtf_xMin.getText() );
//            xmax = Double.parseDouble( txtf_xMax.getText() );
            xmin = (double) spinXmin.getValue();
            xmax = (double) spinXmax.getValue();
            if( xmin==xmax ){
                JOptionPane.showMessageDialog(null, "Los puntos no deben ser iguales", "Error en Datos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if( xmin>xmax ){
                double aux = xmin;
                xmin = xmax;
                xmax = aux;
//                txtf_xMin.setText(""+xmin);
//                txtf_xMax.setText(""+xmax);
                spinXmin.setValue(xmin);
                spinXmax.setValue(xmax);
            }
            rango = xmax-xmin;
            DoublePar minMax = func.minMax(xmin, xmax, plano.getWidth()/2 );
            System.out.println("yMin = "+minMax.pto1+"\tyMax = "+minMax.pto2);
            System.out.println("Rango "+rango);
            plano.setNumPtos( plano.getWidth()/2 );
            System.out.println("yMin - rango = "+(minMax.pto1-rango) );
            //plano.setPuerto(xmin-rango/5, xmax+rango/5, minMax.pto1-rango, minMax.pto2+rango);
            if( minMax.pto1>0 )
                plano.setPuerto(xmin, xmax, 0, minMax.pto2);
            else if( minMax.pto2<0 )
                plano.setPuerto(xmin, xmax, minMax.pto1, 0);
            else
                plano.setPuerto(xmin, xmax, minMax.pto1, minMax.pto2);
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Los datos deben ser numericos", "Error en Datos", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args){
        javax.swing.JFrame v = new javax.swing.JFrame();
        v.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        v.add(new PanelIntegracion());
        v.pack();
        v.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarVista;
    private javax.swing.JButton btnElegirFuncion;
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JButton btnIntegrar;
    private javax.swing.JComboBox cmboxMetodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblIntegral;
    private javax.swing.JLabel lblX;
    private javax.swing.JPanel pnlControles;
    private javax.swing.JPanel pnlIntegral;
    private javax.swing.JPanel pnlMetodo;
    private javax.swing.JPanel pnlSolucion;
    private javax.swing.JPanel pnlVista;
    private javax.swing.JRadioButton rbtnCompuesto;
    private javax.swing.JRadioButton rbtnSimple;
    private javax.swing.JSpinner spinLimiteInf;
    private javax.swing.JSpinner spinLimiteSup;
    private javax.swing.JSpinner spinNumIntervalos;
    private javax.swing.JSpinner spinXmax;
    private javax.swing.JSpinner spinXmin;
    private javax.swing.JTextField txtfSolucion;
    // End of variables declaration//GEN-END:variables

    private class HijoPlano extends Plano {

        public HijoPlano() {
            super();
        }
        @Override
        public void paint(Graphics g){
            super.paint(g);
            
            double ptosPoligonos[][][] = integral.getPoligonos();
            if( ptosPoligonos!=null ){
//                plano.setColorPincel( new Color(198,226,255) );
                plano.setColorPincel( new Color(232,238,244) );
                
                for(int i=0; i<ptosPoligonos.length; i++){
                    plano.fillPolygon( ptosPoligonos[i][0], ptosPoligonos[i][1], 4);
                }
                plano.setColorPincel( new Color(0,153,204) );
                for(int i=0; i<ptosPoligonos.length; i++){
                    plano.drawPolygon( ptosPoligonos[i][0], ptosPoligonos[i][1], 4);
                }
//                plano.dibujarRejilla( g );
                plano.dibujarEjes( g );
                plano.graficarFuncion( integral.getFuncion() );
            }
        }
    }
}
