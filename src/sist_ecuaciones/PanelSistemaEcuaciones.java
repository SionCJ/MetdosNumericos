
package sist_ecuaciones;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.scilab.forge.jlatexmath.TeXIcon;

public class PanelSistemaEcuaciones extends javax.swing.JPanel {
    private javax.swing.JTextField celdas[][];
    private javax.swing.JLabel vars[][];

    public PanelSistemaEcuaciones() {
        initComponents();
//        javax.swing.JButton btn = new javax.swing.JButton("4");
//        btn.setLocation(20,20);
//        btn.setPreferredSize(new Dimension(40,20));
//        btn.set
//        btn.setBounds(20, 20, 100, 20);
//                pnlMatrizEntrada.add(btn);
        celdas = new javax.swing.JTextField[2][3];
        vars = new javax.swing.JLabel[2][3];
        for(int i=0, j; i<2; i++){
            for(j=0; j<2; j++){
                celdas[i][j] = new javax.swing.JTextField();
                //celdas[i][j].setPreferredSize(new Dimension(40, 20));
                celdas[i][j].setBounds(75*j+20, 30*i+20, 40, 20);
                pnlMatrizEntrada.add(celdas[i][j]);
                System.out.println("x = "+(75*j+20)+"\ty = "+(30*i+20));
                
                vars[i][j] = new javax.swing.JLabel("x"+(j+1));
                //vars[i][j].setPreferredSize(new Dimension(20, 20));
                vars[i][j].setBounds(75*j+65, 30*i+20, 20, 20);
                pnlMatrizEntrada.add(vars[i][j]);
            }
        }
        for(int i=0; i<2; i++){
            celdas[i][2] = new javax.swing.JTextField();
            celdas[i][2].setBounds(195, 30*i+20, 40, 20);
            pnlMatrizEntrada.add(celdas[i][2]);

            vars[i][2] = new javax.swing.JLabel("=");
            vars[i][2].setBounds(170, 30*i+20, 20, 20);
            pnlMatrizEntrada.add(vars[i][2]);
        }
        celdas[0][0].setText("1");
        celdas[0][1].setText("1");
        celdas[0][2].setText("13");
        celdas[1][0].setText("1");
        celdas[1][1].setText("-1");
        celdas[1][2].setText("1");
        //pnlMatrizEntrada.setSize(170, 80);
        pnlMatrizEntrada.setPreferredSize(new Dimension(170, 80));
        System.out.println("PreferredSize: = "+pnlMatrizEntrada.getPreferredSize());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCotroles = new javax.swing.JPanel();
        lblDescripcion = new javax.swing.JLabel();
        lblMetodo = new javax.swing.JLabel();
        cboxMetodo = new javax.swing.JComboBox();
        spinEcuaciones = new javax.swing.JSpinner();
        spinColumnas = new javax.swing.JSpinner();
        lblEcuaciones = new javax.swing.JLabel();
        lblColumnas = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        pnlMatrizEntrada = new javax.swing.JPanel();
        btnAceptarDimension = new javax.swing.JButton();
        btnCalcular = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblVectorSolucion = new javax.swing.JLabel();
        pnlBackPasos = new javax.swing.JPanel();
        scrollpnPasos = new javax.swing.JScrollPane();
        pnlFrontPasos = new javax.swing.JPanel();
        lblSolucion = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        pnlCotroles.setPreferredSize(new java.awt.Dimension(490, 358));

        lblDescripcion.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        lblDescripcion.setText("Solucion de sistemas de ecuaciones");

        lblMetodo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMetodo.setText("Metodo de solucion");

        cboxMetodo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboxMetodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gauss", "Gauss-Jordan", "Matriz inversa", "Pivoteo escalonado", "Choleski" }));

        spinEcuaciones.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        spinEcuaciones.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(2), Integer.valueOf(1), null, Integer.valueOf(1)));

        spinColumnas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        spinColumnas.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(2), Integer.valueOf(1), null, Integer.valueOf(1)));

        lblEcuaciones.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblEcuaciones.setText("Ecuaciones:");

        lblColumnas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblColumnas.setText("Columnas:");

        scrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Entradas del Sistema", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        pnlMatrizEntrada.setPreferredSize(new java.awt.Dimension(460, 400));
        pnlMatrizEntrada.setLayout(null);
        scrollPane.setViewportView(pnlMatrizEntrada);

        btnAceptarDimension.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAceptarDimension.setText("Aceptar");
        btnAceptarDimension.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarDimensionActionPerformed(evt);
            }
        });

        btnCalcular.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vector Solucion:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), java.awt.Color.red)); // NOI18N
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        lblVectorSolucion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(lblVectorSolucion);

        javax.swing.GroupLayout pnlCotrolesLayout = new javax.swing.GroupLayout(pnlCotroles);
        pnlCotroles.setLayout(pnlCotrolesLayout);
        pnlCotrolesLayout.setHorizontalGroup(
            pnlCotrolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCotrolesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlCotrolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addGroup(pnlCotrolesLayout.createSequentialGroup()
                        .addGroup(pnlCotrolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescripcion)
                            .addGroup(pnlCotrolesLayout.createSequentialGroup()
                                .addComponent(lblMetodo)
                                .addGap(18, 18, 18)
                                .addComponent(cboxMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCotrolesLayout.createSequentialGroup()
                                .addComponent(lblEcuaciones)
                                .addGap(18, 18, 18)
                                .addComponent(spinEcuaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(lblColumnas)
                                .addGap(18, 18, 18)
                                .addComponent(spinColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(btnAceptarDimension, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnlCotrolesLayout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCotrolesLayout.setVerticalGroup(
            pnlCotrolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCotrolesLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lblDescripcion)
                .addGap(18, 18, 18)
                .addGroup(pnlCotrolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCotrolesLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblMetodo))
                    .addComponent(cboxMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pnlCotrolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinEcuaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblColumnas)
                    .addComponent(spinColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptarDimension)
                    .addComponent(lblEcuaciones))
                .addGap(43, 43, 43)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnCalcular)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(pnlCotroles, java.awt.BorderLayout.WEST);

        pnlBackPasos.setBackground(new java.awt.Color(255, 255, 255));
        pnlBackPasos.setPreferredSize(new java.awt.Dimension(400, 620));
        pnlBackPasos.setLayout(new javax.swing.BoxLayout(pnlBackPasos, javax.swing.BoxLayout.LINE_AXIS));

        pnlFrontPasos.setBackground(new java.awt.Color(255, 255, 255));
        pnlFrontPasos.setLayout(null);

        lblSolucion.setBackground(new java.awt.Color(255, 0, 0));
        lblSolucion.setFont(new java.awt.Font("Yu Mincho", 0, 18)); // NOI18N
        lblSolucion.setForeground(new java.awt.Color(51, 204, 0));
        lblSolucion.setText("Solucion paso a paso:");
        pnlFrontPasos.add(lblSolucion);
        lblSolucion.setBounds(0, 0, 200, 30);

        scrollpnPasos.setViewportView(pnlFrontPasos);

        pnlBackPasos.add(scrollpnPasos);

        add(pnlBackPasos, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarDimensionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarDimensionActionPerformed
        int f = (int) spinEcuaciones.getValue();
        int c = (int) spinColumnas.getValue();
        System.out.println("Btn Aceptar...");
        if( f==celdas.length && c==celdas[0].length-1 )
            return;
        pnlMatrizEntrada.removeAll();
        celdas = new javax.swing.JTextField[f][c+1];
        vars = new javax.swing.JLabel[f][c+1];
        for(int i=0, j; i<f; i++){
            for(j=0; j<c; j++){
                celdas[i][j] = new javax.swing.JTextField();
                //celdas[i][j].setPreferredSize(new Dimension(40, 20));
                celdas[i][j].setBounds(75*j+20, 30*i+20, 40, 20);
                pnlMatrizEntrada.add(celdas[i][j]);
                System.out.println("x = "+(75*j+20)+"\ty = "+(30*i+20));
                
                vars[i][j] = new javax.swing.JLabel("x"+(j+1));
                //vars[i][j].setPreferredSize(new Dimension(20, 20));
                vars[i][j].setBounds(75*j+65, 30*i+20, 20, 20);
                pnlMatrizEntrada.add(vars[i][j]);
            }
        }
        for(int i=0; i<f; i++){
            vars[i][c] = new javax.swing.JLabel("=");
            vars[i][c].setBounds(75*c+20, 30*i+20, 20, 20);
            pnlMatrizEntrada.add(vars[i][c]);
            
            celdas[i][c] = new javax.swing.JTextField();
            celdas[i][c].setBounds(75*c+45, 30*i+20, 40, 20);
            pnlMatrizEntrada.add(celdas[i][c]);
        }
        
        pnlMatrizEntrada.setPreferredSize( new Dimension(75*c+95, 30*f+20) );
        pnlMatrizEntrada.setSize(75*c+20, 30*f+20);
        //pnlMatrizEntrada.setBounds(rect.x, rect.y, f, c);
//        System.out.println("Size : = "+pnlMatrizEntrada.getSize());
//        System.out.println("Bounds : = "+pnlMatrizEntrada.getBounds());
//        System.out.println("PreferredSize Despues: = "+pnlMatrizEntrada.getPreferredSize());
//        System.out.println("->w = "+(75*c+20)+"\t->h = "+(30*f+20));
//        System.out.println("w = "+pnlMatrizEntrada.getWidth()+"\th = "+pnlMatrizEntrada.getHeight());
        pnlMatrizEntrada.repaint();
    }//GEN-LAST:event_btnAceptarDimensionActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        int f, c, i=0, j=0;
        
        f = (int) spinEcuaciones.getValue();
        c = (int) spinColumnas.getValue();
        double matriz[][] = new double[f][c];
        double vecSol[] = new double[f];
        try{
            for(i=0; i<f; i++){
                for(j=0; j<c; j++){
                    matriz[i][j] = Double.parseDouble( celdas[i][j].getText() );
                    System.out.println("M["+i+","+j+"] leido");
                }
                vecSol[i] = Double.parseDouble( celdas[i][j].getText() );
                System.out.println("V["+i+","+j+"] leido");
            }

            for(i=0; i<f; i++){
                for(j=0; j<c; j++){
                    System.out.print(" "+matriz[i][j]);
                }
                System.out.println();
            }
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Los coeficientes deben ser numericos\no faltan coeficientes");
            celdas[i][j].requestFocus();
            return;
        }
        SistemaEcuaciones sistema = new SistemaEcuaciones(matriz, vecSol);
        double[] incognitas = new double[f];
        DiseñadorImagen gestorImg;
        try{   
            switch( cboxMetodo.getSelectedIndex() ){
                case 0: incognitas = sistema.gauss();
                    break;
                case 1: incognitas = sistema.gaussJordan();
                    break;
                case 2: incognitas = sistema.inversa();
                    break;
                case 3: incognitas = sistema.pivoteoEscalonado();
                    break;
                case 4: incognitas = sistema.cholesky();
                    break;
                default: Fraccion[] incognitasF = new Fraccion[f];
                    incognitasF = sistema.choleskyFracc();
                    for(i=0; i<f; i++){
                        System.out.println(""+incognitasF[i]);
                        incognitas[i] = incognitasF[i].getValor();
                    }
            }
            for( i=0; i<f; i++){
                System.out.println(""+incognitas[i]);
            }
            
            MathText imlatex = new MathText(16);
            TeXIcon icon = imlatex.dibujarFormula("X = ");
            gestorImg = new DiseñadorImagen( icon );
            icon = imlatex.dibujarMatriz(new double[][]{incognitas});
            gestorImg.agregarDerecha( DiseñadorImagen.TexIconToBuffImage(icon), 0.5);
            lblVectorSolucion.setIcon(new javax.swing.ImageIcon(gestorImg.getImagen()) );
            lblVectorSolucion.setText("");
            
        }catch(ExcepcionSistemaSinSolucion ex){
            lblVectorSolucion.setIcon(null);
            lblVectorSolucion.setText("Solucion no encontrada");
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }finally{
            pnlFrontPasos.removeAll();
            lblSolucion.setText("Solucion paso a paso: ");
            //lblSolucion.setBounds(0, 0, pnlFrontPasos.getWidth(), 30);
            lblSolucion.setLocation(0, 0);
            pnlFrontPasos.add(lblSolucion);
            
            JLabel lblMetodoSol = new JLabel("Metodo de "+cboxMetodo.getSelectedItem());
            lblMetodoSol.setFont(new java.awt.Font("Yu Mincho", 0, 18)); // NOI18N
            lblMetodoSol.setForeground(new java.awt.Color(255, 153, 0));
            lblMetodoSol.setBounds(lblSolucion.getWidth()+5, 0, pnlFrontPasos.getWidth()-lblSolucion.getWidth()-5, 30);
            pnlFrontPasos.add(lblMetodoSol);
             javax.swing.JButton btn = new javax.swing.JButton("Label");
             btn.setBounds(0, 0, 100, 30);
//            pnlFrontPasos.add( btn );
            //ArrayList<org.scilab.forge.jlatexmath.TeXIcon> pasos = sistema.getPasos();
            ArrayList<java.awt.Image> pasos = sistema.getPasos();
            JLabel lbl;
            int y = 60;
            for(i=0; i<pasos.size(); i++){
                System.out.println("Dibujando Paso "+i+"\t"+pasos.get(i));
                lbl = new JLabel(new javax.swing.ImageIcon( pasos.get(i) ));
//                d = pasos.get(i).getSize();
//                pasos.get(i).setBounds(30, 20, d.width, d.height);
                //lbl.setLocation(10, y);
                lbl.setBounds(10, y, pasos.get(i).getWidth(lbl), pasos.get(i).getHeight(lbl));
                System.out.println("Bounds Lbl "+i+lbl.getBounds());
                y += lbl.getHeight()+20;
                pnlFrontPasos.add( lbl );
                //pnlFrontPasos.add( new JLabel( new javax.swing.ImageIcon(pasos.get(i))) );
            }
                System.out.println("Nueva Dimension Panel "+new Dimension( pnlFrontPasos.getPreferredSize().width, y ));
            pnlFrontPasos.setPreferredSize(new Dimension( pnlFrontPasos.getPreferredSize().width, y ));
            pnlFrontPasos.repaint();
        }
    }//GEN-LAST:event_btnCalcularActionPerformed

    public static void main(String[] args){
        javax.swing.JFrame v = new javax.swing.JFrame();
        v.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        v.add(new PanelSistemaEcuaciones());
        v.pack();
        v.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarDimension;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JComboBox cboxMetodo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblColumnas;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblEcuaciones;
    private javax.swing.JLabel lblMetodo;
    private javax.swing.JLabel lblSolucion;
    private javax.swing.JLabel lblVectorSolucion;
    private javax.swing.JPanel pnlBackPasos;
    private javax.swing.JPanel pnlCotroles;
    private javax.swing.JPanel pnlFrontPasos;
    private javax.swing.JPanel pnlMatrizEntrada;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JScrollPane scrollpnPasos;
    private javax.swing.JSpinner spinColumnas;
    private javax.swing.JSpinner spinEcuaciones;
    // End of variables declaration//GEN-END:variables
}
