package integracion;

import general.DoublePar;
import general.Funcion;

public class IntegralNumerica {
    Funcion funcion;
    double limInf, limSup;
    double[][][] ptosPoligonos;
    
    public IntegralNumerica(Funcion f, double limInferior, double limSuperior){
        funcion = f;
        limInf = limInferior;       limSup = limSuperior;
    }

    public Funcion getFuncion() {
        return funcion;
    }
    
    public DoublePar getLimites() {
        return new DoublePar(limInf, limSup);
    }
    
    public double calcularTrapecio(int numInterv){
        ptosPoligonos = new double[numInterv][2][4];
        double h, r=0;
        double w = limInf;
        int i;
        
        h=(limSup-limInf)/numInterv;
        r += (h/2)*funcion.evaluar(limInf);
        
        for(i=1; i<=numInterv; i++){
            if( i==numInterv ){
                r+=(h/2)*funcion.evaluar(limSup);
                w = limSup;
            }
            else
                r+=(h/2)*2*funcion.evaluar( w+=h );
            
            // LOS 4 PUNTOS X
            ptosPoligonos[i-1][0][0] = w-h;
            ptosPoligonos[i-1][0][1] = w-h;
            ptosPoligonos[i-1][0][2] = w;
            ptosPoligonos[i-1][0][3] = w;
            // LOS 4 PUNTOS Y
            ptosPoligonos[i-1][1][1] = funcion.evaluar(w-h);
            ptosPoligonos[i-1][1][2] = funcion.evaluar(w);
        }
             
//              System.out.println("Aproximacion: "+r+"\n");
        return r;
    }
    
    public double calcularSimpson_1tercio(int numInterv){
     	int n;
     	n = numInterv;
    	double X0, X1, X2, S, R=0, H;
    	H = (limSup-limInf)/n;
    	S = H/2;
    	X0 = limInf;
    	X1 = X0+S;
    	X2 = X1+S;
        ptosPoligonos = new double[n*2][2][4];
        
        for(int i=0, j; i<n; i++){
            R = R + H*( funcion.evaluar(X0) + 4*funcion.evaluar(X1) + funcion.evaluar(X2) ) / 6;
            for(j=0; j<2; j++){
                // LOS 4 PUNTOS X
                ptosPoligonos[i*2+j][0][0] = X0+S*j;
                ptosPoligonos[i*2+j][0][1] = X0+S*j;
                ptosPoligonos[i*2+j][0][2] = X1+S*j;
                ptosPoligonos[i*2+j][0][3] = X1+S*j;
                // LOS 4 PUNTOS Y
                ptosPoligonos[i*2+j][1][1] = funcion.evaluar(X0+S*j);
                ptosPoligonos[i*2+j][1][2] = funcion.evaluar(X1+S*j);
            }
            
            X0=X2; X1=X0+S; X2=X1+S;
        } 
        return R;
    }
    
    public double calcularSimpson_3octavos(int numInterv){
        ptosPoligonos = new double[numInterv*3][2][4];
        int n, i, j;
        double sum1, sum2, h, x;
        
        n = numInterv*3;
        h = (limSup-limInf)/n;
            
        sum1 = 0;   x = limInf+h;
        // 3[ SUM( f(yi) + f(zi) ) ]
        for(i=1; i<=n-2; i+=3, x+=3*h){
            sum1 += funcion.evaluar(x) + funcion.evaluar(x+h);
//        System.out.println("  x"+i+" = f("+x+") = "+funcion.evaluar(x));
//        System.out.println("  x"+(i+1)+" = f("+(x+h)+") = "+funcion.evaluar(x+h));
//        System.out.println(funcion.evaluar(x) + funcion.evaluar(x+h)+" = "+funcion.evaluar(x)+" + "+funcion.evaluar(x+h));
//        System.out.println("  sum = "+sum1);
        
            for(j=-1; j<2; j++){
                // LOS 4 PUNTOS X
                ptosPoligonos[i+j][0][0] = x+j*h;
                ptosPoligonos[i+j][0][1] = x+j*h;
                ptosPoligonos[i+j][0][2] = x+j*h+h;
                ptosPoligonos[i+j][0][3] = x+j*h+h;
                // LOS 4 PUNTOS Y
                ptosPoligonos[i+j][1][1] = funcion.evaluar(x+j*h);
                ptosPoligonos[i+j][1][2] = funcion.evaluar(x+j*h+h);
            }
        }
        
        sum2 = 0;   x = limInf+3*h;
        // 2[ SUM( f(xi) ) ]
        for( i=3; i<=n-3; i+=3, x+=3*h){
            sum2 += funcion.evaluar(x);
        }
//        System.out.println("A = "+limInf+"\tB = "+limSup);
//        System.out.println("h = "+h+"\tsum1 = "+sum1+"\tsum2 = "+sum2);
        System.out.println(" -->  3.0/8*"+h+"*( "+funcion.evaluar(limInf)+" + 3*"+sum1+" + 2*"+sum2+" + "+funcion.evaluar(limSup) );
        System.out.println(" = "+ ( 3.0/8*h*( funcion.evaluar(limInf) + 3*sum1 + 2*sum2 + funcion.evaluar(limSup) ) ));
        
//        JOptionPane.showMessageDialog(null, "Simpson 3/8");
//        System.out.println("ptosPoligX[1] = "+ptosPoligonos[1][0][1]+"\tptosPoligY[1] = "+ptosPoligonos[1][1][1]);
        
        return 3.0/8*h*( funcion.evaluar(limInf) + 3*sum1 + 2*sum2 + funcion.evaluar(limSup) );
    }
    
    public double[][][] getPoligonos(){
        return ptosPoligonos;
    }
}
