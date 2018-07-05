package taylor;

import general.Funcion;
import java.awt.Graphics;

public class DatosPlano extends Plano{
    Double[][] tablaDatos;
    javax.swing.JLabel txtTitle;
    
    public DatosPlano(){
        super(-10, 10, -10, 10);
        txtTitle = new javax.swing.JLabel();
        add(txtTitle);
    }
    
    @Override
    public void graficarFunciones(Graphics g) {
        double dx, xi, yi;
        int px, py, px2, py2, i;
        Funcion func;
        tablaDatos = new Double[funciones.size()][numPtos];
        
        dx = (xMax-xMin)/(numPtos-1);
        
        for(int index=0; index<funciones.size(); index++)
        {
            xi = xMin-dx;
            func = funciones.get(index);
            g.setColor( func.getColor() );
        
            for(i=1; i<numPtos; i++){
                xi = xi+dx;
                px = Tx.transforma(xi);
                px2 = Tx.transforma(xi+dx);
                
                yi = func.evaluar(xi);
                py = alto - Ty.transforma(yi);
                py2 = alto - Ty.transforma( func.evaluar(xi+dx) );
                
                g.drawLine(px, py, px2, py2);
                tablaDatos[index][i-1] = yi;
            }
            xi = xi+dx;
            yi = func.evaluar(xi);
            tablaDatos[index][i-1] = yi;
        } // Fin recorrido vector<Funcion>
    }
    
    public Double[][] getDatos(){
        return tablaDatos;
    }
    
    public void setTitle(String title){
        txtTitle.setText(title);
    }
}
