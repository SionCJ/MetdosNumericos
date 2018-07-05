package interpolacion;

import java.util.Scanner;


public class Neville{    
 double xi[]={1.0, 1.3, 1.6, 1.9, 2.2};
 double fxi[]={0.7651977, 0.6200860, 0.4554022, 0.2818186, 0.1103623};
        
    public Neville() {
       
    }

    public double evaluar(double x) {

        int n = xi.length - 1;
       
        double[][] f = new double[n+1][n+1];
        double resultado = 0;


        for (int i = 0; i < f.length; i++) {
            f[i][0] = fxi[i];
        }


        

        System.out.println("x = " + x);
        System.out.println("");

        for (int k = 1; k <= n; k++) {

            System.out.println("--------");
            System.out.println("K=" + k);
            System.out.println("--------");
            
            for (int i = 0; i < ((n+1) - k); i++) {

                System.out.println("f["+i+"]["+k+"] = "+(((x - xi[i + k]) * f[i][k - 1] - (x-xi[i]) * f[i+1][k-1]) / (xi[i]-xi[i+k])));
                f[i][k] = ((x - xi[i + k]) * f[i][k - 1] - (x-xi[i]) * f[i+1][k-1]) / (xi[i]-xi[i+k]);

            }
            

        }

        return resultado;

    }

   public static void main(String[] args) {
     Neville r = new Neville();
     Scanner in = new Scanner(System.in);
     double dato;
     
     System.out.println("Metodo de Neville\n");
     System.out.println("Teclee el dato a interpolar:\n");
     dato = in.nextDouble();
     r.evaluar(dato);
        
     
        
        
        
    }
   
}
