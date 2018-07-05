package general;

import java.awt.Color;
import javax.swing.Icon;

public class Funcion {
    protected Color colorFunc;
    protected EnumFuncion func;
    Icon imagen;

    public Icon getImagen() {
        return imagen;
    }

    public void setImagen(Icon imagen) {
        this.imagen = imagen;
    }
    
    public Funcion(EnumFuncion f, Color color){
        func = f;
        colorFunc = color;
        System.out.println("COlor = "+color);
    }
    
    public Funcion(String f, Color color){
        func = EnumFuncion.SIN;
        colorFunc = color;
    }
    
    public Funcion(EnumFuncion f){
        func = f;
        colorFunc = Color.black;
    }
    public Funcion(String f){
        func = EnumFuncion.SIN;
        colorFunc = Color.black;
    }
    
    public void setColor(Color newColor){
        colorFunc = newColor;
    }
    public void setFuncion(EnumFuncion f){
        func = f;
    }
    
    public double evaluar(double x) {
        double fx;
        //System.out.print("f("+x+") = ");
        switch(func){
            case SIN: fx = Math.sin(x);
                break;
            case COS: fx = Math.cos(x);
                break;
            case EXP: fx = Math.exp(x);
                break;
            case EXP_INV: fx = Math.exp(-x);
                break;
            case SINH: fx = Math.sinh(x);
                break;
            case COSH: fx = Math.cosh(x);
                break;
            case RAIZ_1: fx = Math.pow(x,3) + 4*Math.pow(x,2) - 10;
                break;
            case RAIZ_2: fx = Math.pow(x,3) - x - 1;
                break;
            case RAIZ_3: fx = Math.exp(x)- Math.pow(x,2) + 3*x - 2;
                break;
            case RAIZ_4: fx = (4*x - 7) / ( (x-2)*(x-2) );
                break;
            case RAIZ_5: fx = Math.pow(x,4) + 2*Math.pow(x,2) - x - 3;
                break;
            case AUX: fx = Math.pow(x,3) + 4*x*x  - 10;
                break;
            case DERIV_1: fx = 3*Math.pow(x,2) + 8*x;
                break;
            case DERIV_2: fx = 3*Math.pow(x,2) - 1;
                break;
            case DERIV_3: fx = Math.exp(x) - 2*x + 3;
                break;
            case DERIV_4: fx = (6 - 4*x) / Math.pow((x-2), 3);
                break;
            case DERIV_5: fx = 4*Math.pow(x,3) + 4*x  - 1;
                break;
                
            case FX_PF1: fx = Math.pow(x, 4) + 2*Math.pow(x, 2) - x -3;
                break;
            case GX_A1: //double base = 3 + x - 2*Math.pow(x, 2);
                        //double exp = 1.0/4;
                //System.out.println(" -> "+base+" ^ "+exp );
                fx = Math.pow( 3 + x - 2*Math.pow(x, 2), 1.0/4 );
                break;
            case GX_A2: fx = Math.sqrt( (x + 3 - Math.pow(x, 4))/2.0 );
                break;
            case GX_A3: fx = Math.sqrt( (x + 3)/(Math.pow(x, 2) + 2) );
                break;
            case GX_A4: fx = (3*Math.pow(x, 4) + 2*Math.pow(x, 2) + 3) / (4*Math.pow(x, 3) + 4*x -1);
                break;
                
            case FX_PF2: fx = Math.pow(x, 3) + 4*Math.pow(x, 2) - 10;
                break;
            case GX_B1: fx = x - Math.pow(x, 3) - 4*Math.pow(x, 2) + 10;
                break;
            case GX_B2: fx = Math.sqrt( (10/x - 4*x) );
                break;
            case GX_B3: fx = Math.sqrt( 10 - Math.pow(x, 3) ) / 2;
                break;
            case GX_B4: fx = Math.sqrt( 10/(4+x) );
                break;
                
            case FX_PF3: fx = Math.pow(x, 3) - x - 1;
                break;
            case GX_C: fx = Math.sqrt( 1 + 1/x );
                break;
                
            case INT1: fx = Math.pow( Math.E, Math.pow(x,2) );
                break;
            case INT2: fx = Math.pow( Math.E, x)/ x;
                break;
            case INT3: fx = Math.pow(x, 3) / ( 1+Math.sqrt(x) );
                break;
            case INT4: fx = 1 / Math.sqrt(2*Math.PI) * Math.pow( Math.E, -Math.pow(x, 2)/2 );
                break;
            case INT5: fx = Math.sin(x);
                break;
                
            default: fx = x;
        }
        //ystem.out.println(""+fx);
        
        return fx;
    }
    
    public DoublePar minMax(double xmin, double xmax, int numPtos){
        double dx, xi, yi, yMin, yMax;
        dx = (xmax-xmin)/(numPtos-1);
        xi = xmin;
        yMin=Double.MAX_VALUE; yMax=Double.MIN_VALUE;
        for(int i=1; i<=numPtos; i++){
            yi = evaluar(xi);
            if( new Double(yi).isNaN() )
                continue;
            if( yMin>yi )
                yMin = yi;
            if( yMax<yi )
                yMax = yi;
            xi = xi+dx;
        }
        return new DoublePar(yMin, yMax);
    }
    
    public Color getColor() {
        return colorFunc;
    }
    
    protected double factorial(double num){
        double fact = 1;
        for(double i=num; i>1; i--){
            fact *= i;
        }
        return fact;
    }
}
