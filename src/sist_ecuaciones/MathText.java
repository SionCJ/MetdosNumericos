
package sist_ecuaciones;

import javax.swing.JLabel;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

public class MathText {
    int size;
    String formula;
    
    public MathText(){
        size = 12;
    }
    public MathText(String formula, int size){
        this.size = size;
        this.formula = formula;
    }
    public MathText(String formula){
        this.size = 12;
        this.formula = formula;
    }
    public MathText(int size){
        this.size = size;
        formula = "";
    }
    
    public void limpiar(){
        formula = "";
    }
    public void addMultX(){
        formula += "\\cdot";
    }
    public void addSubindice(String ind){
        formula += "_{"+ind+"}";
    }
    public void addSupindice(String ind){
        formula += "^{"+ind+"}";
    }
    public void addFraccion(String num, String den){
        formula += "\\frac{"+num+"}{"+den+"}";
    }
    public void add(String formula){
        this.formula += formula;
    }
    
    public String getFormula(){
        return formula;
    }
    
    public TeXIcon dibujarFraccion(String num, String den){
        //BufferedImage b = new BufferedImage (ti.getIconWidth(), ti.getIconHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        //ti.paintIcon (new JLabel (), b.getGraphics (), 0, 0);
        return dibujarFormula("\\frac{"+num+"}{"+den+"}");
    }
    
    public TeXIcon dibujarMatriz(double[][] matriz){
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
        
        return dibujarFormula(strFormula.toString());
    }
    
    public TeXIcon dibujarMatrizAmpliada(double[][] matriz){
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
        return dibujarFormula(strFormula.toString());
    }
    
    public TeXIcon dibujarFormula(String strFormula){
        System.out.println("\nDibujando Formula... "+strFormula);
        return new TeXFormula(strFormula).createTeXIcon(TeXConstants.STYLE_DISPLAY, size);
    }
    
    public TeXIcon dibujarFormula(){
        System.out.println("\nDibujando Formula... "+formula);
        return new TeXFormula(formula).createTeXIcon(TeXConstants.STYLE_DISPLAY, size);
    }
    
    public void setSize(int size){
        this.size = size;
    }
    
    public static void main(String[] args){
        double mat[][] = { {1,2,3,4}, {5,6,7,8}, {9,10,11,12} };
        //System.out.println("\\frac{"+6+"}{"+7+"}");
        //System.out.println("Matriz:\n" + MathText.dibujarMatriz(mat));
        javax.swing.JFrame v = new javax.swing.JFrame();
        v.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        v.setLayout(new java.awt.FlowLayout());
        v.add( new JLabel( new MathText().dibujarMatriz(mat) ) );
        v.add( new JLabel( new MathText().dibujarMatriz(mat) ) );
        v.pack();
        v.setVisible(true);
    }
}
