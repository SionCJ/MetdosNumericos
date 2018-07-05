package taylor;

import general.EnumFuncion;
import general.Funcion;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
/**
 * @author Sion
 */
public final class PanelGrafica extends javax.swing.JPanel {

    private DefaultTableModel tblmodelDatos;
    private int gradoMax;
    Funcion funcionReal;
    private int gradoAct;
    Timer timer;
    
    public PanelGrafica() {
        initComponents();
        
        funcionReal = new Funcion(EnumFuncion.SIN, Color.black);
        tblmodelDatos = new DefaultTableModel();
        gradoMax = -1;
        java.awt.event.ActionListener timerGrafica = new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                repintarGrafica();
            }
        };
        timer = new Timer(1000, timerGrafica);
        gradoAct = 2;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jComboBox1 = new javax.swing.JComboBox();
        pnlComponentes = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblFuncion = new javax.swing.JLabel();
        cboxFuncion = new javax.swing.JComboBox();
        lblCotaInf = new javax.swing.JLabel();
        txtfCotaInf = new javax.swing.JTextField();
        lblCotaSup = new javax.swing.JLabel();
        txtfCotaSup = new javax.swing.JTextField();
        lblNumPuntos = new javax.swing.JLabel();
        txtfNumPuntos = new javax.swing.JTextField();
        pnl_subOpcGraficar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnColorG1 = new javax.swing.JButton();
        btnColorG2 = new javax.swing.JButton();
        btnColorG3 = new javax.swing.JButton();
        btnColorG4 = new javax.swing.JButton();
        chboxGrado1 = new javax.swing.JCheckBox();
        chboxGrado2 = new javax.swing.JCheckBox();
        chboxGrado3 = new javax.swing.JCheckBox();
        chboxGrado4 = new javax.swing.JCheckBox();
        spinGrado2 = new javax.swing.JSpinner();
        spinGrado3 = new javax.swing.JSpinner();
        spinGrado4 = new javax.swing.JSpinner();
        spinGrado1 = new javax.swing.JSpinner();
        btnGraficar = new javax.swing.JButton();
        chboxFuncReal = new javax.swing.JCheckBox();
        pnlAnimacion = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAnimar = new javax.swing.JButton();
        spinGradoAnimacion = new javax.swing.JSpinner();
        btnColorAnimacion = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        prBarAnimacion = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        pnlGrafica = new javax.swing.JPanel();
        plano = new taylor.DatosPlano();
        scrllPn_TblDatos = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setLayout(new java.awt.GridBagLayout());

        pnlComponentes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        pnlComponentes.setAutoscrolls(true);
        pnlComponentes.setLayout(new javax.swing.BoxLayout(pnlComponentes, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setLayout(new java.awt.GridBagLayout());

        lblFuncion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFuncion.setText("Funcion    ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weighty = 0.01;
        jPanel1.add(lblFuncion, gridBagConstraints);

        cboxFuncion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "seno", "coseno", "e^x", "e^-x", "senh", "cosh" }));
        cboxFuncion.setPreferredSize(new java.awt.Dimension(80, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel1.add(cboxFuncion, gridBagConstraints);

        lblCotaInf.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCotaInf.setText("Cota Inf    ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.01;
        jPanel1.add(lblCotaInf, gridBagConstraints);

        txtfCotaInf.setText("-10");
        txtfCotaInf.setAlignmentY(0.0F);
        txtfCotaInf.setMinimumSize(new java.awt.Dimension(40, 20));
        txtfCotaInf.setPreferredSize(new java.awt.Dimension(80, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(txtfCotaInf, gridBagConstraints);

        lblCotaSup.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCotaSup.setText("Cota Sup    ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.01;
        jPanel1.add(lblCotaSup, gridBagConstraints);

        txtfCotaSup.setText("10");
        txtfCotaSup.setPreferredSize(new java.awt.Dimension(80, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(txtfCotaSup, gridBagConstraints);

        lblNumPuntos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumPuntos.setText("Num. de puntos    ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.01;
        jPanel1.add(lblNumPuntos, gridBagConstraints);

        txtfNumPuntos.setText("10");
        txtfNumPuntos.setPreferredSize(new java.awt.Dimension(80, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(txtfNumPuntos, gridBagConstraints);

        pnlComponentes.add(jPanel1);

        pnl_subOpcGraficar.setBorder(javax.swing.BorderFactory.createTitledBorder("Graficar"));
        pnl_subOpcGraficar.setLayout(new java.awt.GridBagLayout());

        jLabel3.setText("Grado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        pnl_subOpcGraficar.add(jLabel3, gridBagConstraints);

        btnColorG1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnColorG1.setForeground(new java.awt.Color(255, 0, 0));
        btnColorG1.setText("C");
        btnColorG1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorG1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.25;
        pnl_subOpcGraficar.add(btnColorG1, gridBagConstraints);

        btnColorG2.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        btnColorG2.setForeground(java.awt.Color.magenta);
        btnColorG2.setText("C");
        btnColorG2.setEnabled(false);
        btnColorG2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorG2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        pnl_subOpcGraficar.add(btnColorG2, gridBagConstraints);

        btnColorG3.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        btnColorG3.setForeground(new java.awt.Color(0, 153, 51));
        btnColorG3.setText("C");
        btnColorG3.setEnabled(false);
        btnColorG3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorG3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        pnl_subOpcGraficar.add(btnColorG3, gridBagConstraints);

        btnColorG4.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        btnColorG4.setForeground(java.awt.Color.blue);
        btnColorG4.setText("C");
        btnColorG4.setEnabled(false);
        btnColorG4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorG4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        pnl_subOpcGraficar.add(btnColorG4, gridBagConstraints);

        chboxGrado1.setSelected(true);
        chboxGrado1.setText("Graf 1");
        chboxGrado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chboxGrado1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.01;
        pnl_subOpcGraficar.add(chboxGrado1, gridBagConstraints);

        chboxGrado2.setText("Graf 2");
        chboxGrado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chboxGrado2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weighty = 0.01;
        pnl_subOpcGraficar.add(chboxGrado2, gridBagConstraints);

        chboxGrado3.setText("Graf 3");
        chboxGrado3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chboxGrado3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weighty = 0.01;
        pnl_subOpcGraficar.add(chboxGrado3, gridBagConstraints);

        chboxGrado4.setText("Graf 4");
        chboxGrado4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chboxGrado4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weighty = 0.01;
        pnl_subOpcGraficar.add(chboxGrado4, gridBagConstraints);

        spinGrado2.setModel(new javax.swing.SpinnerNumberModel(7, 0, null, 1));
        spinGrado2.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnl_subOpcGraficar.add(spinGrado2, gridBagConstraints);

        spinGrado3.setModel(new javax.swing.SpinnerNumberModel(9, 0, null, 1));
        spinGrado3.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnl_subOpcGraficar.add(spinGrado3, gridBagConstraints);

        spinGrado4.setModel(new javax.swing.SpinnerNumberModel(11, 0, null, 1));
        spinGrado4.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnl_subOpcGraficar.add(spinGrado4, gridBagConstraints);

        spinGrado1.setModel(new javax.swing.SpinnerNumberModel(5, 0, null, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.25;
        pnl_subOpcGraficar.add(spinGrado1, gridBagConstraints);

        btnGraficar.setText("Graficar");
        btnGraficar.setPreferredSize(new java.awt.Dimension(81, 23));
        btnGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.weighty = 0.1;
        pnl_subOpcGraficar.add(btnGraficar, gridBagConstraints);

        chboxFuncReal.setText("Graficar función Real");
        chboxFuncReal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chboxFuncRealActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.weighty = 0.3;
        pnl_subOpcGraficar.add(chboxFuncReal, gridBagConstraints);

        pnlComponentes.add(pnl_subOpcGraficar);

        pnlAnimacion.setBorder(javax.swing.BorderFactory.createTitledBorder("Animacion"));
        pnlAnimacion.setLayout(new java.awt.GridBagLayout());

        jLabel4.setText("Intervalo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 0.25;
        pnlAnimacion.add(jLabel4, gridBagConstraints);

        jLabel5.setText("Grado 2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 0.3;
        pnlAnimacion.add(jLabel5, gridBagConstraints);

        btnAnimar.setText("Iniciar");
        btnAnimar.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        btnAnimar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnimarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.weighty = 0.25;
        pnlAnimacion.add(btnAnimar, gridBagConstraints);

        spinGradoAnimacion.setPreferredSize(new java.awt.Dimension(60, 26));
        spinGradoAnimacion.setValue(5);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 0.4;
        pnlAnimacion.add(spinGradoAnimacion, gridBagConstraints);

        btnColorAnimacion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnColorAnimacion.setForeground(java.awt.Color.blue);
        btnColorAnimacion.setText("Color grafica");
        btnColorAnimacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorAnimacionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.weighty = 0.25;
        pnlAnimacion.add(btnColorAnimacion, gridBagConstraints);

        jLabel6.setText("Grado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 0.2;
        pnlAnimacion.add(jLabel6, gridBagConstraints);

        jLabel7.setText("al");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.25;
        pnlAnimacion.add(jLabel7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlAnimacion.add(jSeparator1, gridBagConstraints);

        jLabel2.setText("Grado actual:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.2;
        pnlAnimacion.add(jLabel2, gridBagConstraints);

        prBarAnimacion.setPreferredSize(new java.awt.Dimension(146, 18));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weighty = 0.2;
        pnlAnimacion.add(prBarAnimacion, gridBagConstraints);

        jLabel1.setText("Progreso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.weighty = 0.2;
        pnlAnimacion.add(jLabel1, gridBagConstraints);

        pnlComponentes.add(pnlAnimacion);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(pnlComponentes, gridBagConstraints);

        pnlGrafica.setLayout(new java.awt.BorderLayout());

        plano.setMinimumSize(new java.awt.Dimension(100, 100));
        pnlGrafica.add(plano, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(pnlGrafica, gridBagConstraints);

        scrllPn_TblDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        scrllPn_TblDatos.setPreferredSize(new java.awt.Dimension(375, 180));

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "x", "VALOR REAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrllPn_TblDatos.setViewportView(tblDatos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(scrllPn_TblDatos, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnColorG4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorG4ActionPerformed
        javax.swing.JColorChooser colorChoser = new javax.swing.JColorChooser();
        Color color = colorChoser.showDialog(null, "Color de la funcion", Color.blue);
        btnColorG4.setForeground(color);
    }//GEN-LAST:event_btnColorG4ActionPerformed

    private void btnColorG3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorG3ActionPerformed
        javax.swing.JColorChooser colorChoser = new javax.swing.JColorChooser();
        Color color = colorChoser.showDialog(null, "Color de la funcion", Color.green);
        btnColorG3.setForeground(color);
    }//GEN-LAST:event_btnColorG3ActionPerformed

    private void btnColorG2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorG2ActionPerformed
        javax.swing.JColorChooser colorChoser = new javax.swing.JColorChooser();
        Color color = colorChoser.showDialog(null, "Color de la funcion", Color.magenta);
        btnColorG2.setForeground(color);
    }//GEN-LAST:event_btnColorG2ActionPerformed

    private void chboxGrado4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chboxGrado4ActionPerformed
        spinGrado4.setEnabled( chboxGrado4.isSelected() );
        btnColorG4.setEnabled( chboxGrado4.isSelected() );
    }//GEN-LAST:event_chboxGrado4ActionPerformed

    private void chboxGrado3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chboxGrado3ActionPerformed
        spinGrado3.setEnabled( chboxGrado3.isSelected() );
        btnColorG3.setEnabled( chboxGrado3.isSelected() );
    }//GEN-LAST:event_chboxGrado3ActionPerformed

    private void chboxGrado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chboxGrado2ActionPerformed
        spinGrado2.setEnabled( chboxGrado2.isSelected() );
        btnColorG2.setEnabled( chboxGrado2.isSelected() );
    }//GEN-LAST:event_chboxGrado2ActionPerformed

    private void chboxGrado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chboxGrado1ActionPerformed
        spinGrado1.setEnabled( chboxGrado1.isSelected() );
        btnColorG1.setEnabled( chboxGrado1.isSelected() );
    }//GEN-LAST:event_chboxGrado1ActionPerformed

    private void btnGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficarActionPerformed
        double cotaInf, cotaSup;
        int numPtos, item;

        try{
            cotaInf = Double.parseDouble( txtfCotaInf.getText() );
            cotaSup = Double.parseDouble( txtfCotaSup.getText() );
            numPtos = Integer.parseInt( txtfNumPuntos.getText() );

            if( cotaInf>cotaSup ){
                double aux = cotaInf;
                cotaInf = cotaSup;
                cotaSup = aux;
                txtfCotaInf.setText(""+cotaInf);
                txtfCotaSup.setText(""+cotaSup);
            }else if( cotaInf==cotaSup ) {
                JOptionPane.showMessageDialog(null, "Las Cotas son iguales", "Error",
                    JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon( getClass().getResource("recursos/error.png") ));
                return;
            }

            item = cboxFuncion.getSelectedIndex();
            EnumFuncion func;
            switch(item){
                case 0: func = EnumFuncion.SIN;
                break;
                case 1: func = EnumFuncion.COS;
                break;
                case 2: func = EnumFuncion.EXP;
                break;
                case 3: func = EnumFuncion.EXP_INV;
                break;
                case 4: func = EnumFuncion.SINH;
                break;
                case 5: func = EnumFuncion.COSH;
                break;
                default: func = EnumFuncion.SIN;
            }

            plano.eliminarFunciones();
            funcionReal = new Funcion(func, Color.black);
            if( chboxGrado1.isSelected() )
                plano.addFuncion( new AproxFuncion(func, (int) spinGrado1.getValue(), btnColorG1.getForeground() ));
            if( chboxGrado2.isSelected() )
                plano.addFuncion( new AproxFuncion(func, (int) spinGrado2.getValue(), btnColorG2.getForeground() ));
            if( chboxGrado3.isSelected() )
                plano.addFuncion( new AproxFuncion(func, (int) spinGrado3.getValue(), btnColorG3.getForeground() ));
            if( chboxGrado4.isSelected() )
                plano.addFuncion( new AproxFuncion(func, (int) spinGrado4.getValue(), btnColorG4.getForeground() ));

            // Buscando maximo y minimo
            double yMin, yMax;
            if( (cotaSup-cotaInf)>3.1461 && (func==EnumFuncion.SIN || func==EnumFuncion.COS) ){
                yMin = -2;
                yMax = 2;
            }
            else{
                double dx, xi, yi;
                dx = (cotaSup-cotaInf)/(numPtos-1);
                xi = cotaInf;
                yMin=Double.MAX_VALUE; yMax=Double.MIN_VALUE;

                for(int i=1; i<=numPtos; i++){
                    switch(item){
                        case 0: yi = Math.sin(xi);  break;
                        case 1: yi = Math.cos(xi);  break;
                        case 2: yi = Math.exp(xi);  break;
                        case 3: yi = Math.exp(-xi);  break;
                        case 4: yi = Math.sinh(xi);  break;
                        case 5: yi = Math.cosh(xi);  break;
                        default: yi = Math.sin(xi);
                    }
                    if( yMin>yi )
                        yMin = yi;
                    if( yMax<yi )
                        yMax = yi;
                    xi = xi+dx;
                }
            }

            plano.setPuerto(cotaInf, cotaSup, yMin, yMax);
            plano.setNumPtos(numPtos);
            Double[][] tablaDatos = new Double[numPtos][2];
            {
                double dx, xi;
                dx = (cotaSup-cotaInf)/(numPtos-1);
                xi = cotaInf-dx;
                for(int i=0; i<numPtos; i++){
                    xi += dx;
                    tablaDatos[i][0] = xi;
                    tablaDatos[i][1] = funcionReal.evaluar(xi);
                }
            }

            String[] nombCols = new String[4];
            nombCols[0] = ""+(int)spinGrado1.getValue();
            nombCols[1] = ""+(int)spinGrado2.getValue();
            nombCols[2] = ""+(int)spinGrado3.getValue();
            nombCols[3] = ""+(int)spinGrado4.getValue();
            this.update( plano.getGraphics() );
            tblmodelDatos = new DefaultTableModel(tablaDatos, new String [] {"x", "Valor real"} );
            tablaDatos = plano.getDatos();
            for(int i=0; i<tablaDatos.length; i++ ){
                tblmodelDatos.addColumn( "Grado "+nombCols[i], tablaDatos[i]);
            }
            tblDatos.setModel( tblmodelDatos );
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Los datos deben ser numéricos", "Error en datos", JOptionPane.ERROR_MESSAGE);
            txtfCotaInf.requestFocus();
        }
    }//GEN-LAST:event_btnGraficarActionPerformed

    private void btnAnimarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimarActionPerformed
        EnumFuncion func;
        gradoMax = (int)spinGradoAnimacion.getValue();
        
        if( gradoMax<0 )
            JOptionPane.showMessageDialog(null, "No hay grados seleccionados", "Error", JOptionPane.ERROR_MESSAGE);
        else{
            
            try{
                func = functionSelected();
                setPuertoPlano(func);
                timer.start();
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Los datos deben ser numéricos", "Error en datos", JOptionPane.ERROR_MESSAGE);
                txtfCotaInf.requestFocus();
            }
        }
    }//GEN-LAST:event_btnAnimarActionPerformed

    private void btnColorG1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorG1ActionPerformed
        javax.swing.JColorChooser colorChoser = new javax.swing.JColorChooser();
        Color color = colorChoser.showDialog(null, "Color de la funcion", Color.red);
        btnColorG1.setForeground(color);
    }//GEN-LAST:event_btnColorG1ActionPerformed

    private void chboxFuncRealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chboxFuncRealActionPerformed
        this.update( plano.getGraphics() );
    }//GEN-LAST:event_chboxFuncRealActionPerformed

    private void btnColorAnimacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorAnimacionActionPerformed
        javax.swing.JColorChooser colorChoser = new javax.swing.JColorChooser();
        Color color = colorChoser.showDialog(null, "Color de la funcion", Color.blue);
        btnColorAnimacion.setForeground(color);
    }//GEN-LAST:event_btnColorAnimacionActionPerformed
        
    private void repintarGrafica(){
        int incremBar;
        EnumFuncion func;
        
        func = functionSelected();
        incremBar = 100/(gradoMax-1);
        plano.eliminarFunciones();
        plano.addFuncion( new AproxFuncion(func, gradoAct, btnColorAnimacion.getForeground() ));
        if( gradoAct<gradoMax )
            plano.setTitle("Grado: "+gradoAct);
        this.update( plano.getGraphics() );

        if( gradoAct<gradoMax ){
            prBarAnimacion.setValue(prBarAnimacion.getValue()+incremBar);
            jLabel2.setText("Grado actual:  "+gradoAct);
            gradoAct++;
        }
        else if( gradoAct==gradoMax ){
            jLabel2.setText("Grado actual:  "+gradoAct);
            prBarAnimacion.setValue(100);
            gradoAct++;
        }
        else{
            jLabel2.setText("Grado actual:  2");
            prBarAnimacion.setValue(0);
            gradoAct = 2;
            timer.stop();
            JOptionPane.showMessageDialog(null, "Animación terminada", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            
        }
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        if( chboxFuncReal.isSelected() ){
            plano.graficarFuncion( funcionReal );
            System.out.println("CheckBox seleccionado");
        }
    }
        
    private void setPuertoPlano(EnumFuncion func){
        double cotaInf, cotaSup;
        int numPtos;
            
        cotaInf = Double.parseDouble( txtfCotaInf.getText() );
        cotaSup = Double.parseDouble( txtfCotaSup.getText() );
        numPtos = Integer.parseInt( txtfNumPuntos.getText() );

        if( cotaInf>cotaSup ){
            double aux = cotaInf;
            cotaInf = cotaSup;
            cotaSup = aux;
            txtfCotaInf.setText(""+cotaInf);
            txtfCotaSup.setText(""+cotaSup);
        }else if( cotaInf==cotaSup ) {
            JOptionPane.showMessageDialog(null, "Las Cotas son iguales", "Error",
                JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon( getClass().getResource("recursos/error.png") ));
            return;
        }

        // Buscando maximo y minimo
        double yMin, yMax;
        if( (cotaSup-cotaInf)>3.1461 && (func==EnumFuncion.SIN || func==EnumFuncion.COS) ){
            yMin = -2;
            yMax = 2;
        }
        else{
            double dx, xi, yi;
            int item = cboxFuncion.getSelectedIndex();
            dx = (cotaSup-cotaInf)/(numPtos-1);
            xi = cotaInf;
            yMin=Double.MAX_VALUE; yMax=Double.MIN_VALUE;

            for(int j=1; j<=numPtos; j++){
                switch(item){
                    case 0: yi = Math.sin(xi);  break;
                    case 1: yi = Math.cos(xi);  break;
                    case 2: yi = Math.exp(xi);  break;
                    case 3: yi = Math.exp(-xi);  break;
                    case 4: yi = Math.sinh(xi);  break;
                    case 5: yi = Math.cosh(xi);  break;
                    default: yi = Math.sin(xi);
                }
                if( yMin>yi )
                    yMin = yi;
                if( yMax<yi )
                    yMax = yi;
                xi = xi+dx;
            }
        }
        plano.setPuerto(cotaInf, cotaSup, yMin, yMax);
        plano.setNumPtos(numPtos);
    }
    
    private EnumFuncion functionSelected(){
        int item = cboxFuncion.getSelectedIndex();
        EnumFuncion func;
        switch(item){
            case 0: func = EnumFuncion.SIN;
                break;
            case 1: func = EnumFuncion.COS;
                break;
            case 2: func = EnumFuncion.EXP;
                break;
            case 3: func = EnumFuncion.EXP_INV;
                break;
            case 4: func = EnumFuncion.SINH;
                break;
            case 5: func = EnumFuncion.COSH;
                break;
            default: func = EnumFuncion.SIN;
        }
        
        return func;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnimar;
    private javax.swing.JButton btnColorAnimacion;
    private javax.swing.JButton btnColorG1;
    private javax.swing.JButton btnColorG2;
    private javax.swing.JButton btnColorG3;
    private javax.swing.JButton btnColorG4;
    private javax.swing.JButton btnGraficar;
    private javax.swing.JComboBox cboxFuncion;
    private javax.swing.JCheckBox chboxFuncReal;
    private javax.swing.JCheckBox chboxGrado1;
    private javax.swing.JCheckBox chboxGrado2;
    private javax.swing.JCheckBox chboxGrado3;
    private javax.swing.JCheckBox chboxGrado4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCotaInf;
    private javax.swing.JLabel lblCotaSup;
    private javax.swing.JLabel lblFuncion;
    private javax.swing.JLabel lblNumPuntos;
    private taylor.DatosPlano plano;
    private javax.swing.JPanel pnlAnimacion;
    private javax.swing.JPanel pnlComponentes;
    private javax.swing.JPanel pnlGrafica;
    private javax.swing.JPanel pnl_subOpcGraficar;
    private javax.swing.JProgressBar prBarAnimacion;
    private javax.swing.JScrollPane scrllPn_TblDatos;
    private javax.swing.JSpinner spinGrado1;
    private javax.swing.JSpinner spinGrado2;
    private javax.swing.JSpinner spinGrado3;
    private javax.swing.JSpinner spinGrado4;
    private javax.swing.JSpinner spinGradoAnimacion;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtfCotaInf;
    private javax.swing.JTextField txtfCotaSup;
    private javax.swing.JTextField txtfNumPuntos;
    // End of variables declaration//GEN-END:variables

    /*private void graficarFuncion(Graphics g) {
        double xMax, xMin, dx, xi, yAprox;
        int px, py, px2, py2, i, numPtos, altoPnl;
        String strValor;
        
        strValor = txtfCotaInf.getText();
        xMin = Double.parseDouble(strValor);
        strValor = txtfCotaSup.getText();
        xMax = Double.parseDouble(strValor);
        strValor = txtfNumPuntos.getText();
        numPtos = Integer.parseInt(strValor);
        
        dx = (xMax-xMin)/(numPtos-1);
        xi = xMin-dx;
        altoPnl = this.getHeight();
        for(i=1; i<numPtos; i++){
                xi = xi+dx;
                
                px = Tx.getTransf(xi);
                px2 = Tx.getTransf(xi+dx);
                py = altoPnl - Ty.getTransf(yAprox);
                g.drawLine(px, py, px2, py2);
                tablaDatos[i-1][posGrado+2] = yAprox;
            }
            xi = xi+dx;
            yAprox = senoTaylor(xi, grado);
            tablaDatos[i-1][posGrado+2] = yAprox;
    }*/
}
