/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpolacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import taylor.Plano;

/**
 *
 * @author Sion
 */
public class PanelInterpolacion extends javax.swing.JPanel {
    private int numPuntos;
    private HijoPlano plano;
    ArrayList<Double> X;
    ArrayList<Double> Y;
    private boolean metodoEra3;
    /**
     * Creates new form PanelInterpolacion
     */
    public PanelInterpolacion() {
        initComponents();
        numPuntos = tblDatos.getRowCount();
        plano = new HijoPlano();
        pnlEste.add(plano, java.awt.BorderLayout.CENTER);
        metodoEra3 = false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cboxMetodo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        spinGrado = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        txtfAproxX = new javax.swing.JTextField();
        btnCalcular = new javax.swing.JButton();
        txtfAproxY = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        spinNumPuntos = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnElegir = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtareaEvaluacion = new javax.swing.JTextArea();
        pnlEste = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPolinomio = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(400, 363));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPanel5.setMinimumSize(new java.awt.Dimension(581, 130));
        jPanel5.setPreferredSize(new java.awt.Dimension(300, 160));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        jLabel8.setPreferredSize(new java.awt.Dimension(450, 15));
        jPanel5.add(jLabel8);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Metodo");
        jLabel9.setPreferredSize(new java.awt.Dimension(110, 14));
        jPanel5.add(jLabel9);

        cboxMetodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lagrange", "Diferencias divididas", "Neville", "Hermitie" }));
        cboxMetodo.setPreferredSize(new java.awt.Dimension(150, 20));
        cboxMetodo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboxMetodoItemStateChanged(evt);
            }
        });
        jPanel5.add(cboxMetodo);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Grado del Polinomio");
        jLabel4.setPreferredSize(new java.awt.Dimension(111, 14));
        jPanel5.add(jLabel4);
        jLabel4.getAccessibleContext().setAccessibleName("");

        spinGrado.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel5.add(spinGrado);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Aproximacion de x   = ");
        jLabel3.setFocusTraversalPolicyProvider(true);
        jLabel3.setPreferredSize(new java.awt.Dimension(111, 14));
        jPanel5.add(jLabel3);

        txtfAproxX.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel5.add(txtfAproxX);

        btnCalcular.setText("Aproximar");
        btnCalcular.setPreferredSize(new java.awt.Dimension(110, 23));
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });
        jPanel5.add(btnCalcular);

        txtfAproxY.setPreferredSize(new java.awt.Dimension(150, 25));
        jPanel5.add(txtfAproxY);

        jPanel2.add(jPanel5);

        jPanel6.setPreferredSize(new java.awt.Dimension(300, 100));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Numero de puntos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.3;
        jPanel6.add(jLabel1, gridBagConstraints);

        spinNumPuntos.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(5), Integer.valueOf(1), null, Integer.valueOf(1)));
        spinNumPuntos.setPreferredSize(new java.awt.Dimension(60, 20));
        spinNumPuntos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinNumPuntosStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.34;
        gridBagConstraints.weighty = 0.02;
        jPanel6.add(spinNumPuntos, gridBagConstraints);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(300, 100));

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Double(1.0),  new Double(0.7651977),  new Boolean(true)},
                { new Double(1.3),  new Double(0.620086),  new Boolean(true)},
                { new Double(1.6),  new Double(0.4554022),  new Boolean(true)},
                { new Double(1.9),  new Double(0.2818186),  new Boolean(true)},
                { new Double(2.2),  new Double(0.1103623),  new Boolean(true)}
            },
            new String [] {
                "Xi", "f(x)", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.Double.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDatos.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tblDatos);
        tblDatos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tblDatos.getColumnModel().getColumnCount() > 0) {
            tblDatos.getColumnModel().getColumn(0).setMaxWidth(300);
            tblDatos.getColumnModel().getColumn(1).setMaxWidth(300);
            tblDatos.getColumnModel().getColumn(2).setMaxWidth(50);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.9;
        jPanel6.add(jScrollPane1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.3;
        jPanel6.add(jLabel2, gridBagConstraints);

        btnElegir.setText("Elegir datos");
        btnElegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel6.add(btnElegir, gridBagConstraints);

        jPanel2.add(jPanel6);

        jScrollPane3.setPreferredSize(new java.awt.Dimension(166, 280));

        txtareaEvaluacion.setColumns(20);
        txtareaEvaluacion.setRows(5);
        jScrollPane3.setViewportView(txtareaEvaluacion);

        jPanel2.add(jScrollPane3);

        add(jPanel2, java.awt.BorderLayout.WEST);

        pnlEste.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Obtencion del Polinomio interpolante"));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(452, 200));

        tblPolinomio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "i", "L(4,i)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblPolinomio);

        pnlEste.add(jScrollPane2, java.awt.BorderLayout.NORTH);

        add(pnlEste, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void spinNumPuntosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinNumPuntosStateChanged
        //        tblDatos.addRowSelectionInterval(0, 2);
        int nuevoNumPtos = (int)spinNumPuntos.getValue();
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tblDatos.getModel();
        if( numPuntos<nuevoNumPtos )
            for(int i=numPuntos; i<nuevoNumPtos; i++)
                model.addRow(new Vector<Double>());
        else
            for(int i=numPuntos; i>nuevoNumPtos; i--)
                model.removeRow(model.getRowCount()-1);
        numPuntos = model.getRowCount();
        //        javax.swing.JOptionPane.showMessageDialog(null,""+spinNumPuntos.getValue());
    }//GEN-LAST:event_spinNumPuntosStateChanged

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        int grado, metodo, i=0, j=0;
        double aproxX, aprox;
        
        grado = (int) spinGrado.getValue();
        try{
            aproxX = Double.parseDouble( txtfAproxX.getText() );
        }catch(NumberFormatException e){
            txtfAproxX.selectAll();
            txtfAproxX.requestFocus();
            JOptionPane.showMessageDialog(null, "La aproximacion X debe ser un número");
            return;
        }
        try{
            X = new ArrayList();
            Y = new ArrayList();
            for(i=0; i<tblDatos.getRowCount(); i++){
                if( tblDatos.getValueAt(i, 0)==null || tblDatos.getValueAt(i, 1)==null )
                    throw new NumberFormatException();
                if( (boolean) tblDatos.getValueAt(i, 2) ){
                    j = 0;
                    X.add((Double) tblDatos.getValueAt(i, 0));
                    j++;
                    Y.add((Double) tblDatos.getValueAt(i, 1));
                }
            }
//            System.out.println("X = "+X);
//            System.out.println("Y = "+Y);
            metodo = cboxMetodo.getSelectedIndex();
            PolinomioInterpolante P = new PolinomioInterpolante(X, Y, grado);
            switch(metodo){
                case 0: aprox = P.evaluarLagrange(aproxX);
                    break;
                case 1: aprox = P.evaluarDiferenciasDiv(aproxX);
                    break;
                default: aprox = P.evaluarNeville(aproxX);
            }
            X.add(aproxX);
            Y.add(aprox);

            txtfAproxY.setText(""+aprox);
            tblPolinomio.setModel( P.getTblmodelDatos() );
            txtareaEvaluacion.setText(P.getStrEvaluacion());
////            System.out.println("Despues:\nX = "+X);
////            System.out.println("Y = "+Y);
            establecerVista();
            plano.repaint();
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Dato no numérico");
            tblDatos.changeSelection(i, j, false, false);
        }
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnElegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirActionPerformed
        javax.swing.table.DefaultTableModel tblmodel = TablaChooser.showDialog(btnElegir);
        tblmodel.addColumn("", new Boolean[tblmodel.getRowCount()]);
        tblDatos.setModel(tblmodel);
        txtfAproxY.setText("");
    }//GEN-LAST:event_btnElegirActionPerformed

    private void cboxMetodoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxMetodoItemStateChanged
        
        if( cboxMetodo.getSelectedIndex()==3 ){
            tblDatos.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    { new Double(2.2),  new Double(0.5207843),  new Double(-0.0014878),  new Boolean(true) },
                    { new Double(2.4),  new Double(0.5104147),  new Double(-0.1004889),  new Boolean(true) },
                    { new Double(2.6),  new Double(0.4813306),  new Double(-0.1883635),  new Boolean(true) }
                },
                new String [] { "x", "f(x)", "f'(x)", ""}
            ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
            metodoEra3 = true;
        }
        else if( metodoEra3 ){
            tblDatos.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    { new Double(1.0),  new Double(0.7651977),  new Boolean(true)},
                    { new Double(1.3),  new Double(0.620086),  new Boolean(true)},
                    { new Double(1.6),  new Double(0.4554022),  new Boolean(true)},
                    { new Double(1.9),  new Double(0.2818186),  new Boolean(true)},
                    { new Double(2.2),  new Double(0.1103623),  new Boolean(true)}
                },
                new String [] { "x", "f(x)", ""}
            ) );
            metodoEra3 = false;
//            JOptionPane.showMessageDialog(null, "Cambie");
        }
    }//GEN-LAST:event_cboxMetodoItemStateChanged

    private void establecerVista(){
//        JOptionPane.showMessageDialog(null, "Estableciendo Vista");
        double xmin, xmax, ymin, ymax, rangoX, rangoY;
        xmin = ymin = Double.MAX_VALUE;
        xmax = ymax = Double.MIN_VALUE;
        for(int i=0; i<X.size(); i++){
//            System.out.println("X["+i+"] = "+X.get(i)+"\tY["+i+"] = "+Y.get(i));
            if( xmin>X.get(i) )
                xmin = X.get(i);
            if( xmax<X.get(i) )
                xmax = X.get(i);

            if( ymin>Y.get(i) )
                ymin = Y.get(i);
            if( ymax<Y.get(i) )
                ymax = Y.get(i);
        }
//            System.out.println("ymax = "+ymax+"\tymin = "+ymin);
//            System.out.println("xmax = "+xmax+"\txmin = "+xmin);
        rangoX = xmax - xmin;
        rangoY = ymax - ymin;
        if( rangoY==0 )
            rangoY = ymin;
        
        plano.setNumPtos( plano.getWidth()/2 );
        if( ymin>0 )
            plano.setPuerto(xmin-rangoX/10, xmax+rangoX/10, -rangoY/10, ymax+rangoY/10);
        else if( ymax<0 )
            plano.setPuerto(xmin-rangoX/10, xmax+rangoX/10, ymin-rangoY/10, rangoY/10);
        else
            plano.setPuerto(xmin-rangoX/10, xmax+rangoX/10, ymin-rangoY/10, ymax+rangoY/10);
    }

    public static void main(String[] args){
        javax.swing.JFrame v = new javax.swing.JFrame();
        v.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        v.add(new PanelInterpolacion());
        v.pack();
        v.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnElegir;
    private javax.swing.JComboBox cboxMetodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnlEste;
    private javax.swing.JSpinner spinGrado;
    private javax.swing.JSpinner spinNumPuntos;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTable tblPolinomio;
    private javax.swing.JTextArea txtareaEvaluacion;
    private javax.swing.JTextField txtfAproxX;
    private javax.swing.JTextField txtfAproxY;
    // End of variables declaration//GEN-END:variables

    private class HijoPlano extends Plano {
        public HijoPlano() {
            super();
        }
        
        @Override
        public void paint(Graphics g){
            super.paint(g);
            
            if( X!=null ){
                plano.setColorPincel(Color.red);
                int i;
                for(i=0; i<X.size()-1; i++){
                    plano.drawPoint(X.get(i), Y.get(i), 4);
                    plano.dibujarLinea(X.get(i), 0, X.get(i), Y.get(i));
                }
                plano.setColorPincel(Color.blue);
                plano.drawPoint(X.get(i), Y.get(i), 4);
                plano.dibujarLinea(X.get(i), 0, X.get(i), Y.get(i));
            }
        }
    }

}
