/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sist_ecuaciones;

import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;

/**
 *
 * @author Sion
 */
public class ImagenMathText extends MathText {
    Color foreground, background;
    
    public ImagenMathText(){
        super();
        foreground = Color.BLACK;
        background = Color.WHITE;
    }
    public ImagenMathText(String formula, int size){
        super(formula, size);
        foreground = Color.BLACK;
        background = Color.WHITE;
    }
    public ImagenMathText(String formula){
        super(formula);
        foreground = Color.BLACK;
        background = Color.WHITE;
    }
    public ImagenMathText(int size){
        super(size);
        foreground = Color.BLACK;
        background = Color.WHITE;
    }

    public Color getForeground() {
        return foreground;
    }

    public void setForeground(Color foreground) {
        this.foreground = foreground;
    }

    public Color getBackgrond() {
        return background;
    }

    public void setBackgrond(Color backgrond) {
        this.background = backgrond;
    }
    
    public Image imgFraccion(String num, String den){
        return TeXFormula.createBufferedImage("\\frac{"+num+"}{"+den+"}", TeXConstants.STYLE_DISPLAY, size, foreground, background);
    }
    
    public Image imgMatriz(double[][] matriz){
        System.out.println("\nDibujando Matriz...");
        int i, j;
        StringBuilder strFormula = new StringBuilder("\\begin{pmatrix}");
        for(i=0; i<matriz.length-1; i++){
            for(j=0; j<matriz[0].length-1; j++)
                strFormula.append(matriz[i][j]).append("&");
            strFormula.append(matriz[i][j]).append("\\\\");
        }
        for(j=0; j<matriz[0].length-1; j++){
            System.out.println("<-> "+i+","+j+": "+matriz[i][j]);
            strFormula.append(matriz[i][j]).append("&");
        }
        System.out.println("<-> "+i+","+j+": "+matriz[i][j]);
        strFormula.append(matriz[i][j]).append("\\end{pmatrix}");
        System.out.println(" Matriz Dibujada");
        
        Image img = TeXFormula.createBufferedImage(
                strFormula.toString(), TeXConstants.STYLE_DISPLAY, size, foreground, background);
        System.out.println(" Retornando matriz");
        return img;
    }
    
    public Image imgMatrizAmpliada(double[][] matriz){
        System.out.println("\nDibujando Matriz...");
        int i, j;
        StringBuilder strFormula = new StringBuilder("\\begin{pmatrix}");
        for(i=0; i<matriz.length-1; i++){
            for(j=0; j<matriz[0].length-1; j++)
                strFormula.append(matriz[i][j]).append("&");
            strFormula.append("|&");
            strFormula.append(matriz[i][j]).append("\\\\");
        }
        for(j=0; j<matriz[0].length-1; j++){
            System.out.println("<-> "+i+","+j+": "+matriz[i][j]);
            strFormula.append(matriz[i][j]).append("&");
        }
        System.out.println("<-> "+i+","+j+": "+matriz[i][j]);
        strFormula.append("|&");
        strFormula.append(matriz[i][j]).append("\\end{pmatrix}");
        System.out.println(" Matriz Dibujada");
        
        Image img = TeXFormula.createBufferedImage(
                strFormula.toString(), TeXConstants.STYLE_DISPLAY, size, foreground, background);
        System.out.println(" Retornando matriz");
        return img;
//        return TeXFormula.createBufferedImage(
//                strFormula.toString(), TeXConstants.STYLE_DISPLAY, size, foreground, background);
    }
    
    public Image imgMatrizAmpliada(double[][] matriz, int div){
        System.out.println("\nDibujando Matriz...");
        int i, j;
        StringBuilder strFormula = new StringBuilder("\\begin{pmatrix}");
        if( div<0 || div>matriz[0].length )
            div=0;
        for(i=0; i<matriz.length-1; i++){
            for(j=0; j<div; j++)
                strFormula.append(matriz[i][j]).append("&");
            strFormula.append("|&");
            for(j=div; j<matriz[0].length-1; j++)
                strFormula.append(matriz[i][j]).append("&");
            strFormula.append(matriz[i][j]).append("\\\\");
        }
        for(j=0; j<div; j++){
            System.out.println("<-> "+i+","+j+": "+matriz[i][j]);
            strFormula.append(matriz[i][j]).append("&");
        }
        System.out.println("<-> "+i+","+j+": "+matriz[i][j]);
        strFormula.append("|&");
        for(j=div; j<matriz[0].length-1; j++){
            System.out.println("<-> "+i+","+j+": "+matriz[i][j]);
            strFormula.append(matriz[i][j]).append("&");
        }
        strFormula.append(matriz[i][j]).append("\\end{pmatrix}");
        System.out.println(" Matriz Dibujada");
        
        Image img = TeXFormula.createBufferedImage(
                strFormula.toString(), TeXConstants.STYLE_DISPLAY, size, foreground, background);
        System.out.println(" Retornando matriz");
        return img;
//        return TeXFormula.createBufferedImage(
//                strFormula.toString(), TeXConstants.STYLE_DISPLAY, size, foreground, background);
    }
    
    public Image getImage(){
        return TeXFormula.createBufferedImage(formula, TeXConstants.STYLE_DISPLAY, size, foreground, background);
    }
    
    public Image getImgFormula(String strFormula){
        return TeXFormula.createBufferedImage(strFormula, TeXConstants.STYLE_DISPLAY, size, foreground, background);
    }
    
    public static void main(String[] args){
        double mat[][] = { {1,2,3,4}, {5,6,7,8}, {9,10,11,12} };
        //System.out.println("\\frac{"+6+"}{"+7+"}");
        //System.out.println("Matriz:\n" + MathText.dibujarMatriz(mat));
        javax.swing.JFrame v = new javax.swing.JFrame();
        v.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        v.setLayout(new java.awt.FlowLayout());
        v.add( new JLabel( new ImageIcon(new ImagenMathText().imgMatriz(mat)) ) );
        v.add( new JLabel( new ImageIcon(new ImagenMathText().imgMatriz(mat)) ) );
        v.pack();
        v.setVisible(true);
    }
}
