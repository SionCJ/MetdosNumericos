package interpolacion;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class PolinomioInterpolante {
//    double[] ptosX, ptosY;
    int grado;
    ArrayList<Double> ptosX, ptosY;
    DefaultTableModel tblmodelDatos;
    String strEvaluacion;
    
    public PolinomioInterpolante(ArrayList puntosX, ArrayList puntosY, int grado){
        ptosX = puntosX;
        ptosY = puntosY;
        this.grado = grado;
    }
    
    public double evaluarLagrange(double x){
        int n = ptosX.size();
        double y=0;
        double[] multiplicador = new double[n];
        Object[][] datos = new Object[n][2];
        
        for(int i=0; i<multiplicador.length; i++){
            multiplicador[i] = 1;
            for(int k=0; k<n; k++){
                if( k==i )
                    continue;
                datos[i][1] = multiplicador[i] *= (x-ptosX.get(k))/(ptosX.get(i)-ptosX.get(k));
            }
            datos[i][0] = ""+i;
        }
        
        tblmodelDatos = new DefaultTableModel( datos, new String[]{"i", "L("+(n-1)+",i)"} );
        strEvaluacion = "P"+(ptosX.size()-1)+" ("+x+") = ";
        for(int i=0; i<n-1; i++){
            y += ptosY.get(i)*multiplicador[i];
            strEvaluacion += " ("+ptosY.get(i)+") * ("+multiplicador[i]+")\n\t + ";
        }
        y += ptosY.get(n-1)*multiplicador[n-1];
        strEvaluacion += " ("+ptosY.get(n-1)+") * ("+multiplicador[n-1] + ")\n\n\t = " + y;
        
        return y;
    }
    
    public double evaluarNeville(double x) {
        int n = ptosX.size() - 1;
        double[][] f = new double[n+1][n+1];
        Object[][] datos = new Object[n+1][n+2];
        String[] nombCols = new String[n+2];

        nombCols[0] = "i";
        for (int i = 0; i < f.length; i++) {
            datos[i][0] = ""+i;
            datos[i][1] = f[i][0] = ptosY.get(i);
        }
        System.out.println("x = " + x);
        System.out.println("");

        for (int k = 1; k <= n; k++) {
            System.out.println("--------");
            System.out.println("K=" + k);
            System.out.println("--------");
            for (int i = 0; i < ((n+1) - k); i++) {
                System.out.println("f["+i+"]["+k+"] = "+(((x - ptosX.get(i+k)) * f[i][k - 1] - (x-ptosX.get(i)) * f[i+1][k-1]) / (ptosX.get(i)-ptosX.get(i+k))));
                f[i][k] = ((x - ptosX.get(i+k)) * f[i][k - 1] - (x-ptosX.get(i)) * f[i+1][k-1]) / (ptosX.get(i)-ptosX.get(i+k));
                datos[i][k+1] = f[i][k];
                nombCols[k+1] = "P "+k+",i";
            }
        }
        System.out.println("\nMatriz Neville:\n");
        for (int k = 0; k <= n; k++) {
            for (int i = 0; i<=n; i++) {
                System.out.print(f[k][i]+"\t");
            }
            System.out.println();
        }
        tblmodelDatos = new DefaultTableModel( datos, nombCols );
        strEvaluacion = "P"+(ptosX.size()-1)+" ("+x+")  =  P 0,"+(ptosX.size()-1)+"(x)\n\t  = "+f[0][n];
        
        return f[0][n];
    }
    
    public double evaluarDiferenciasDiv(double x){
        int i, k, n = ptosX.size();
        Double[][] dif = new Double[n][n+2];
        Object[][] datos = new Object[n][n+2];
        String[] nombCols = new String[n+2];
        
        for(i=0; i<n; i++){
            datos[i][0] = ""+i;
            datos[i][1] = dif[i][1] = ptosX.get(i);
            datos[i][2] = dif[i][2] = ptosY.get(i);   // F(x) = DIF 0
            nombCols[0] = "i";
            nombCols[1] = "Xi";
            nombCols[2] = "f(x) = Dif 0";
        }
        // LA DIFERENCIA 1 EMPIEZA EN LA COLUMNA 3 DE LA MATRIZ
        for(k=3; k<n+2; k++){
            for(i=0; i<n-k+2; i++){
                datos[i][k] = dif[i][k] = ( dif[i+1][k-1] - dif[i][k-1]) / ( dif[i+k-2][1] - dif[i][1] );
            }
            nombCols[k] = (k-2)+"a Dif. Div.";
        }
        System.out.println("\nMatriz Diferencias divididas:\n");
        for ( k = 0; k < n; k++) {
            for ( i = 0; i<n+2; i++) {
                System.out.print(dif[k][i]+"\t");
            }
            System.out.println();
        }
        
        tblmodelDatos = new DefaultTableModel( datos, nombCols );
        strEvaluacion = "P"+(ptosX.size()-1)+"("+x+") = "+dif[0][2];
        
        double aprox = dif[0][2], mult;
        for(i=1; i<n; i++){
            for(k=0, mult=1; k<i; k++)
                mult *= (x-ptosX.get(k));
            aprox += dif[0][2+i]*mult;
            strEvaluacion += "\n\t+ ("+dif[0][2+i]+") * ("+mult+")";
        }
        strEvaluacion += "\n\n\t = "+aprox;
        
        return aprox;
    }
    
    public double evaluarHermitie(double x, double f_prim[]){
        int n = ptosX.size();
        double Q[] = new double[2*n+1];
        double z, z2;
         for(int i=0; i<=n; i++){
             z = ptosX.get(i);
         }
         return 0;
    }

    public DefaultTableModel getTblmodelDatos() {
        return tblmodelDatos;
    }

    public String getStrEvaluacion() {
        return strEvaluacion;
    }
}
