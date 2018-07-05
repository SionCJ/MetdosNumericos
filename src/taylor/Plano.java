
package taylor;
import general.Funcion;
import general.Transformacion;
import java.awt.Color;
import java.awt.Graphics;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
/* @author Sion
 */
public class Plano extends javax.swing.JPanel{
    protected Color colorEjes, colorPincel;

    protected double xMin, xMax, yMin, yMax;
    protected int numPtos, alto, ancho, anchoBorde;
    protected Transformacion Tx, Ty;
    protected boolean rejilla, ejes;
    protected ArrayList<Funcion> funciones;
    private Graphics graph;
    
    public Plano(){
        xMin = -10;    xMax = 10;
        yMin = -10;    yMax = 10;
        numPtos = 10;
        Tx = new Transformacion(xMin, xMax, 0, this.getWidth()-1);
        Ty = new Transformacion(yMin, yMax, 0, this.getHeight()-1);
        rejilla = true;
        ejes = true;
        colorEjes = Color.orange;
        anchoBorde = 0;
        funciones = new ArrayList();
        
        setBackground(Color.white);
    }
    public Plano(double xmin, double xmax, double ymin, double ymax) throws ArithmeticException {
        xMin = xmin;    xMax = xmax;
        yMin = ymin;    yMax = ymax;
        numPtos = 10;
        rejilla = true;
        ejes = true;
        colorEjes = Color.orange;
        anchoBorde = 0;
        funciones = new ArrayList();
        Tx = new Transformacion(xMin, xMax, 0, this.getWidth()-1);
        Ty = new Transformacion(yMin, yMax, 0, this.getHeight()-1);
        
        setBackground(Color.white);
    }
    
    public void setPuerto(double xmin, double xmax, double ymin, double ymax) throws ArithmeticException {
        if( xmin==xmax )
            throw new ArithmeticException();
        xMin = xmin;    xMax = xmax;
        yMin = ymin;    yMax = ymax;
    }
    
    /* @param area
     * @throws ArithmeticException
     */
    public void setPuerto(Rectangulo area) throws ArithmeticException {
        if( area.xmin==area.xmax || area.ymin==area.ymax )
            throw new ArithmeticException();
        xMin = area.xmin;    xMax = area.xmax;
        yMin = area.ymin;    yMax = area.ymax;
    }

    public void setRejilla(boolean rejilla) {
        this.rejilla = rejilla;
    }

    public Transformacion getTx() {
        return Tx;
    }

    public Transformacion getTy() {
        return Ty;
    }
        
    public void setEjes(boolean ejes) {
        this.ejes = ejes;
    }
    
    public void setColorEjes(Color color) {
        colorEjes = color;
    }

    public void setColorPincel(Color colorPincel) {
        this.colorPincel = colorPincel;
        graph.setColor(colorPincel);
    }
    
    public void setAnchoBorde(int anchoBorde) {
        if( anchoBorde>=0 && anchoBorde<11)
            this.anchoBorde = anchoBorde;
    }

    public void setNumPtos(int numPtos) {
        this.numPtos = numPtos;
    }

    public int getNumPtos() {
        return numPtos;
    }
    
    public void setGraph(Graphics g){
        graph = g;
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        graph = g;
        alto = this.getHeight();
        ancho = this.getWidth();
        Tx.setTransformacion(xMin, xMax, 0, ancho-1);
        Ty.setTransformacion(yMin, yMax, 0, alto-1);
        
        if( rejilla )
            dibujarRejilla(g);
        if( ejes )
            dibujarEjes(g);
        graficarFunciones(g);
    }
    
    public void addFuncion(Funcion f){
        funciones.add(f);
    }
    
    public void eliminarFunciones(){
        funciones = new ArrayList();
    }
    
    public void graficarFunciones(Graphics g) {
        double dx, xi, yAprox;
        int px, py, px2, py2, i;
        Funcion func;
        
        dx = (xMax-xMin)/(numPtos-1);
        
        for(int index=0; index<funciones.size(); index++)
        {
            xi = xMin-dx;
            func = funciones.get(index);
            g.setColor( func.getColor() );
                            System.out.println("g: "+g);
            
            for(i=0; i<numPtos; i++){
                xi = xi+dx;
                px = Tx.transforma(xi);
                px2 = Tx.transforma(xi+dx);
                
                yAprox = func.evaluar(xi);
                if( new Double(yAprox).isNaN() ){
                    continue;
                }
                py = alto - Ty.transforma(yAprox);
                py2 = alto - Ty.transforma( func.evaluar(xi+dx) );
                
                g.drawLine(px, py, px2, py2);
            }
        } // Fin recorrido vector<Funcion>
    }
    
    public void graficarFuncion(Funcion f) {
        double dx, xi, yi;
        int px, py, px2, py2, i;
        Graphics g = this.getGraphics();
        
        g.setColor( f.getColor() );
        dx = (xMax-xMin)/(numPtos-1);
        xi = xMin-dx;
        
        for(i=0; i<numPtos; i++){
            xi = xi+dx;
            px = Tx.transforma(xi);
            px2 = Tx.transforma(xi+dx);

            yi = f.evaluar(xi);
            py = alto - Ty.transforma(yi);
            py2 = alto - Ty.transforma( f.evaluar(xi+dx) );

            g.drawLine(px, py, px2, py2);
        }
        
    }
    
    public void drawPoint(double x, double y, int size){
        graph.fillOval(Tx.transforma(x)-size/2, yInv(Ty.transforma(y))-size/2, size, size);
    }
    
    public void dibujarLinea(double x1, double y1, double x2, double y2){
        graph.drawLine(Tx.transforma(x1), yInv(Ty.transforma(y1)), Tx.transforma(x2), yInv(Ty.transforma(y2)));
    }
    
    public void drawRect(double x, double y, double width, double height){
        graph.drawRect(Tx.transforma(x), yInv(Ty.transforma(y)), Tx.transforma(width), yInv(Ty.transforma(height)) );
    }
    
    public void drawOval(double x, double y, double width, double height){
        graph.drawOval(Tx.transforma(x), yInv(Ty.transforma(y)), Tx.transforma(width), yInv(Ty.transforma(height)) );
    }
    
    public void fillPolygon(double[] ptosX, double[] ptosY, int nPtos){
        int[] X = new int[ptosX.length];
        int[] Y = new int[ptosY.length];
        
        for(int i=0; i<ptosX.length; i++)
            X[i] = Tx.transforma(ptosX[i]);
        for(int i=0; i<ptosY.length; i++)
            Y[i] = yInv( Ty.transforma(ptosY[i]) );
        graph.fillPolygon(X, Y, nPtos);
    }
    
    public void drawPolygon(double[] ptosX, double[] ptosY, int nPtos){
        int[] X = new int[ptosX.length];
        int[] Y = new int[ptosY.length];
        for(int i=0; i<ptosX.length; i++)
            X[i] = Tx.transforma(ptosX[i]);
        for(int i=0; i<ptosY.length; i++)
            Y[i] = yInv( Ty.transforma(ptosY[i]) );
        graph.drawPolygon(X, Y, nPtos);
    }
    
    private int yInv(int y){
        return alto - y - 1;
    }
    
    public void dibujarEjes(Graphics g){
        g.setColor(colorEjes);
        double ejeX, ejeY;
        int ladoEjeX=1, ladoEjeY=1;
        if( xMin>0 )
            ejeY = xMin;
        else if( xMax<0 ){
            ejeY = xMax;
            ladoEjeY = -1;
        }
        else{
            ejeY = 0;
            if( Tx.transforma(ejeY)>ancho-13 ){
                ladoEjeY = -1;
            }
        }
        
        if( yMin>0 ){ 
            ejeX = yMin;
            ladoEjeX = -1;
        }
        else if( yMax<0 )
            ejeX = yMax;
        else{
            ejeX = 0;
            if( Ty.transforma(ejeX)<13 ){
                ladoEjeX = -1;
            }
        }
        
        int i, TxInt, TyEn0, TyInt, TxEn0, numInterv;
        double rango, intervalo, ptoInterv;
        String strnum;
        
        // EJE X
        numInterv = ancho/40;
        rango = xMax-xMin;
        for(i=1; rango<numInterv; i*=10)
            rango *= 10;
        intervalo = Math.ceil(rango/numInterv);
        intervalo /= i;
        TyEn0 = Ty.transforma(ejeX);
        TxEn0 = Tx.transforma(ejeY);
        for( ptoInterv = -intervalo; ptoInterv>=xMin-intervalo/10; ptoInterv-=intervalo){
            TxInt = Tx.transforma(ptoInterv);
            g.drawLine(TxInt, yInv(TyEn0), TxInt, yInv(TyEn0-10*ladoEjeX));
            strnum = formatear(ptoInterv, intervalo);
            g.drawString(strnum, TxInt-10, yInv(TyEn0-25*ladoEjeX));
        }
        for( ptoInterv = intervalo; ptoInterv<=xMax+intervalo/10; ptoInterv+=intervalo){
            TxInt = Tx.transforma(ptoInterv);
            g.drawLine(TxInt, yInv(TyEn0), TxInt, yInv(TyEn0-10*ladoEjeX));
            strnum = formatear(ptoInterv, intervalo);
            g.drawString(strnum, TxInt-10, yInv(TyEn0-25*ladoEjeX));
        }
        
        // EJE Y
        numInterv = alto/40;
        rango = yMax-yMin;
        for(i=1; rango<numInterv; i*=10)
            rango *= 10;
        intervalo = Math.ceil(rango/numInterv);
        intervalo /= i;
        for(ptoInterv = -intervalo ; ptoInterv>=yMin; ptoInterv-=intervalo){
            TyInt = this.getHeight()-Ty.transforma(ptoInterv);
            g.drawLine(TxEn0, TyInt, TxEn0+10*ladoEjeY, TyInt);
            strnum = formatear(ptoInterv, intervalo);
            g.drawString(strnum, TxEn0+25*ladoEjeY, TyInt);
        }
        for(ptoInterv = intervalo ; ptoInterv<=yMax; ptoInterv+=intervalo){
            TyInt = this.getHeight()-Ty.transforma(ptoInterv);
            g.drawLine(TxEn0, TyInt, TxEn0+10*ladoEjeY, TyInt);
            strnum = formatear(ptoInterv, intervalo);
            g.drawString(strnum, TxEn0+25*ladoEjeY, TyInt);
        }
        
        g.drawLine(Tx.transforma(xMin), yInv(Ty.transforma(ejeX)), Tx.transforma(xMax), yInv(Ty.transforma(ejeX)));   // X
        g.drawLine(Tx.transforma(ejeY), yInv(Ty.transforma(yMin)), Tx.transforma(ejeY), yInv(Ty.transforma(yMax)));        // Y
    }
    
    public void dibujarRejilla(Graphics g) /*throws ArithmeticException*/ {
        g.setColor( new Color(235,235,235) );
        int i, TxInt, TyInt, numInterv;
        double rango, intervalo, ptoInterv;
        
        // Eje X
        numInterv = ancho/40;
        rango = xMax-xMin;
        for(i=1; rango<numInterv; i*=10)
            rango *= 10;
        intervalo = Math.ceil(rango/numInterv);
        intervalo /= i;
        for( ptoInterv=-intervalo; ptoInterv>=xMin; ptoInterv-=intervalo){
            TxInt = Tx.transforma(ptoInterv);
            g.drawLine(TxInt, 0, TxInt, alto); // rejilla Y
        }
        for( ptoInterv=intervalo; ptoInterv<=xMax; ptoInterv+=intervalo){
            TxInt = Tx.transforma(ptoInterv);
            g.drawLine(TxInt, 0, TxInt, alto); // rejilla Y
        }
            
        // EJE Y
        numInterv = alto/40;
        rango = yMax-yMin;
        for(i=1; rango<numInterv; i*=10)
            rango *= 10;
        intervalo = Math.ceil(rango/numInterv);
        intervalo /= i;
        
        for(ptoInterv = -intervalo ; ptoInterv>=yMin; ptoInterv-=intervalo){
            TyInt = this.getHeight()-Ty.transforma(ptoInterv);
            g.drawLine(0, TyInt, ancho, TyInt);   // rejilla X
        }
        
        for(ptoInterv = intervalo ; ptoInterv<=yMax; ptoInterv+=intervalo){
            TyInt = this.getHeight()-Ty.transforma(ptoInterv);
            g.drawLine(0, TyInt, ancho, TyInt);   // rejilla X
        }
    }
    
    private String formatear(double num, double intervalo){
        String strnum;
        
        if( intervalo>10 ){
            if( num>Long.MAX_VALUE || num<Long.MIN_VALUE ){
                String strDouble = String.valueOf(num);
                System.out.println("strDouble = "+strDouble);
                BigDecimal bdNum = new BigDecimal(strDouble);
                strnum = ""+bdNum.round(MathContext.UNLIMITED);
            }
            else {
                long auxPto = Math.round(num);
                strnum = String.valueOf(auxPto);
            }
        }
        else{
            strnum = String.format("%.3f", num);
            int k, index = strnum.indexOf('.');
            for(k=strnum.length()-1;  k>=index; k--){
                if( strnum.charAt(k)!='0' )
                    break;
            }
            if( k==index )
                strnum = strnum.substring(0,k);
            else if( k!=strnum.length()-1 )
                strnum = strnum.substring(0,k+1);
        }
        return strnum;
    }
}
