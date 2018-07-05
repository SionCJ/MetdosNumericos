package taylor;

public class Rectangulo {
    public double xmin, xmax, ymin, ymax;
    
    public Rectangulo(double xMin, double xMax, double yMin, double yMax){
        if( xmin<=xmax ){
            xmin = xMin;    xmax = xMax;
        }
        else{
            xmin = xMax;    xmax = xMin;
        }
        if( yMin<=yMax ){
            ymin = yMin;    ymax = yMax;
        }
        else{
            ymin = yMax;    xmax = yMin;
        }
    }
    
    public double getX_Incio(){
        return xmin;
    }
    public double getX_Fin(){
        return xmax;
    }
    public double getY_Inicio(){
        return ymin;
    }
    public double getY_Fin(){
        return ymax;
    }
    
    public double getAlto(){
        return (ymax - ymin);
    }
    
    public double getAncho(){
        return (xmax - xmin);
    }
}
