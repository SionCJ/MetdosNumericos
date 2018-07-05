package taylor;
import general.EnumFuncion;
import general.Funcion;
import java.awt.Color;

public class AproxFuncion extends Funcion {
    int grado;
    
    public AproxFuncion(EnumFuncion f, int grado, Color color){
        super(f, color);
        this.grado = grado;
    }
    
    public void setGrado(int grado){
        this.grado = grado;
    }
    
    public double sinTaylor(double x){
        double aprox=0;
        for(int i=0; i<=grado; i++)
            aprox += Math.pow(-1, i) * Math.pow(x, 2*i+1) / factorial(2*i+1);
        
        return aprox;
    }
    
    public double cosTaylor(double x){
        double aprox=0;
        for(int i=0; i<=grado; i++)
            aprox += Math.pow(-1, i) * Math.pow(x, 2*i) / factorial(2*i);
        
        return aprox;
    }
    
    public double expTaylor(double x){
        double suma=0,aprox;
        for(int i=0;i<=grado;i++){
          suma += Math.pow(x,i)/factorial(i);
        }
        aprox=suma;
        return aprox;
    }
    
    public double expInvTaylor(double x){
        double suma=0,aprox;
        for(int i=0;i<=grado;i++){
            suma += Math.pow(-1,i)*(Math.pow(x,i)/factorial(i));
        }
        aprox = suma;
        return aprox;
    }
    
    public double sinhTaylor(double x){
        double suma=0,aprox;
        for(int i=0; i<=grado; i++){
          suma+= Math.pow(x,(2*i)+1)/factorial((2*i)+1);
        }
        aprox=suma;
        return aprox;
    }
    
    public double coshTaylor(double x){
        double suma=0,aprox;
        for(int i=0;i<=grado;i++){
           suma += Math.pow(x,2*i)/factorial(2*i);
        }
        aprox = suma;
        return aprox;
    }
    
    @Override
    public double evaluar(double x){
        double fx = 0;
        switch(func){
            case SIN: fx = sinTaylor(x);
                break;
            case COS: fx = cosTaylor(x);
                break;
            case EXP: fx = expTaylor(x);
                break;
            case EXP_INV: fx = expInvTaylor(x);
                break;
            case SINH: fx = sinhTaylor(x);
                break;
            case COSH: fx = coshTaylor(x);
                break;
        }
        
        return fx;
    }
}
