package general;

/* @author Sion
 */
public class Transformacion {
    public double a, b;
    
    public Transformacion(){
        a = b = 0;
    }
    public Transformacion(double p1Inf, double p1Sup, double p2Inf, double p2Sup){
        a = (p2Sup-p2Inf) / (p1Sup-p1Inf);
        b = p2Inf - a*p1Inf;
    }
    
    public void setTransformacion(double p1Inf, double p1Sup, double p2Inf, double p2Sup){
        a = (p2Sup-p2Inf) / (p1Sup-p1Inf);
        b = p2Inf - a*p1Inf;
    }
    
    public int transforma(double x){
        return (int)(a*x + b);
    }
    
    @Override
    public String toString(){
        return ""+a+"(x) + "+b;
    }
}
