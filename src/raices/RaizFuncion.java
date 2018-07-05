/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. */
package raices;
import general.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/* @author Sion */
public class RaizFuncion {
    private DefaultTableModel tblmodelDatos;
    Funcion f;
    
    public RaizFuncion(Funcion func){
        f = func;
        tblmodelDatos = new DefaultTableModel();
    }

    public void setFuncion(Funcion f) {
        this.f = f;
    }

    public DefaultTableModel getTblmodelDatos() {
        return tblmodelDatos;
    }
    
    public double biseccion(double a,double b, double tolerancia, int numIter) throws RaizNotFoundException{
        double p=0, fp;
        int i;
        Object[] fila = new Object[6];
        double antp = 0;
        tblmodelDatos.setColumnIdentifiers( new String[]{"i","ai","bi","Pi","f(Pi)","|P-P(i-1)| / |Pi|"} );
        System.out.println("\n\nEjecutandose: Biseccion [RaizFuncion]");
            //try{
        for(i=1; i<=numIter; i++){
            p = a + (b-a)/2;
                fp = f.evaluar(p);
            fila[0] = i;    fila[1] = a;   fila[2] = b;
            fila[3] = p;    fila[4] = fp;   fila[5] = (b-a)/2;
            //fila[5] = Math.abs(p-antp)/Math.abs(p);
            tblmodelDatos.addRow(fila);
            //if( fp==0 || Math.abs(p-antp)/Math.abs(p)<tolerancia )
            if( fp==0 || (b-a)/2<tolerancia )
                break;
            antp = p;
            if( f.evaluar(a)*fp > 0 )
                a = p;
            else
                b = p;
        }
        System.out.println("\nSe ejecuto: Biseccion [RaizFuncion]");
        if( i>numIter )
            throw new RaizNotFoundException("Raiz NO encontrada\nEl metodo fracaso despues de "+numIter+" intendtos");
            //}catch(ArithmeticException ex){
              //  System.out.println("Excepcion Aritmetica: "+ex.getMessage());
            //}
        return p;
        
    }
    
    public double secante(double p0,double p1, double tolerancia, int numIter) throws RaizNotFoundException{
        //System.out.println(" Metodo Secante\n");
        int i;
        double y0, y1, pi=0;
        Object[] fila = new Object[6];
        
        y0=f.evaluar(p0);   y1 = f.evaluar(p1);
        tblmodelDatos.setColumnIdentifiers( new String[]{"i","Pi","Pi+1","f(Pi)","f(Pi+1)","|P-Pi|"} );
        //System.out.println(" i "+"\t   Pi"+"\t   Pi+1"+"\t    f(Pi)"+"   f(Pi+1)"+"   |P-Pi|");
        for( i=2; i<numIter; i++){
            pi = p1 - y1*(p1-p0)/(y1-y0);
            if( Math.abs(pi-p1)<tolerancia )
                break;
            fila[0] = i-1;    fila[1] = p0;   fila[2] = p1;
            fila[3] = y0;    fila[4] = y1;   fila[5] = Math.abs(pi-p1);
            tblmodelDatos.addRow(fila);
            //System.out.printf(" %2d\t%f %f %f %f %f\n", i-1, p0, p1, y0, y1, Math.abs(pi-p1));
            p0 = p1;    p1 = pi;
            y0 = y1;    y1 = f.evaluar(pi);
        }
        fila[0] = i-1;    fila[1] = p0;   fila[2] = p1;
        fila[3] = y0;    fila[4] = y1;   fila[5] = Math.abs(pi-p1);
        tblmodelDatos.addRow(fila);
        //System.out.printf(" %2d\t%f %f %f %f %f\n", i-1, p0, p1, y0, y1, Math.abs(pi-p1));
        if( i==numIter )
            throw new RaizNotFoundException("Raiz NO encontrada\nEl metodo fracaso despues de "+numIter+" intendtos");
        return pi;
    }
    
    public double reglaFalsa2(double p0,double p1, double tolerancia, int numIter) throws RaizNotFoundException{
        System.out.println(" Metodo Secante\n");
        int i;
        double y0, y1, pi=0, y2;
        Object[] fila = new Object[8];
        
        y0=f.evaluar(p0);   y1 = f.evaluar(p1);
        tblmodelDatos.setColumnIdentifiers( new String[]{"i","a","b","f(a)","f(b)","c","f(c)","|c-b|"} );
        for( i=2; i<numIter; i++){
            pi = p1 - y1*(p1-p0)/(y1-y0);
            if( Math.abs(pi-p1)<tolerancia )
                break;
            y2 = f.evaluar(pi);
            fila[0] = i;        fila[1] = p0;   fila[2] = p1;
            fila[3] = y0;       fila[4] = y1;   
            fila[5] = pi;       fila[6] = y2;   fila[7] = Math.abs(pi-p1);
            tblmodelDatos.addRow(fila);
            if( y2*y1<0 ){
                p0 = p1;
                y0 = y1;
            }
            p1 = pi;
            y1 = f.evaluar(pi);
        }
        if( i==numIter )
            throw new RaizNotFoundException("Raiz NO encontrada\nEl metodo fracaso despues de "+numIter+" intendtos");
        return pi;
    }
    /*
    public double biseccion(double a, double b, double tolerancia, int numIter){
        double pi=0;
        
    	tblmodelDatos=new DefaultTableModel(); //Tamaño del arreglo
    	double T=0.0;	//toleranciaancia que resulta de las operaciones
    	double X, R, S;
    	double Pi=0.0; //Columna P de i (4)
    	int i, lim=0;	//Variable por si las iteraciones es igual a 1
    	    	
    	//Llenado de primera columna (i)
    	int e=1;
    	for(int l=0;l<numIter;l++){  
    		//tblmodelDatos[l][0] = e*1.0;
    		e++;
    		
    	}
    	//      numIter C
    	//tblmodelDatos[0][1]= a;
    	//tblmodelDatos[0][2]= b;
    	
    	//Llenado de las demas casillas
    
    	if (numIter==1){
            Pi=a+((b-a)/2);
            //tblmodelDatos[0][3]=Pi; 
            X= (Pi*Pi*Pi)+(4*(Pi*Pi))-10;
            //tblmodelDatos[0][4]=X;
    			
            T=1.0;
            //tblmodelDatos[0][5]= T;	
    		//	System.out.println("Aun no se ha encontrado la raiz");
    		//	System.out.println("\nLa raiz encontrada fue: "+Pi); 	
    			
        }
        else {
            for (i=0;i<numIter;i++){
    		//tblmodelDatos[i][2]=b;
    		//tblmodelDatos[i][1]=a;
    		Pi = a + ( (b-a)/2 );
    		tblmodelDatos[i][3]=Pi; 
    		X= (Pi*Pi*Pi)+(4*(Pi*Pi))-10;
    		tblmodelDatos[i][4]=X;
    		lim++;
    			
    		if (lim<2){
                    R=(a*a*a)+(4*(a*a))-10;
                    S=R*X;
                    if (S<0){
    			b = tblmodelDatos[i][3];
    						//tblmodelDatos[i+1][2]=B;
    			T=1.0;
    			tblmodelDatos [i][5]=T;
                    } else {
    			a = tblmodelDatos[i][3];
    						//tblmodelDatos[i+1][1]=A;
    			T=1.0;
    			tblmodelDatos [i][5]=T;
                    }
    		}
                else {
                    T=(tblmodelDatos[i-1][3]-tblmodelDatos[i][3])/tblmodelDatos[i][3];
                    tblmodelDatos [i][5]=T;
                    if (T<0){
    			T = T*(-1);
    			tblmodelDatos [i][5]=T;
                    }
                    if (T<tolerancia){
    					//System.out.println("La raiz es "+tblmodelDatos[i][3]);
    			break;
                    }
                    else{
                        R=(a*a*a)+(4*(a*a))-10;
    			S=R*X;
                        if (S<0)
                            b = tblmodelDatos[i][3];
                        else
                            a = tblmodelDatos[i][3];
                    }
                }
            }
    	}
    	if(numIter==1){
    		System.out.println("Aun no se ha encontrado la raiz");
    		System.out.println("\nLa raiz encontrada fue: "+Pi);
    	}
    	else{
    		if (T>tolerancia){
    	
		    	System.out.println("La raiz encontrada fue:"+Pi+" Y falta para encontrarla");
		    }
            else {
    		System.out.println("La raiz encontrada fue:"+Pi);
            }
    	}
       
        return pi;
    }
    */
    
    
    public double newton(double p0, double tolerancia, int numIter, Funcion fprima) throws RaizNotFoundException{
        int i;
        double pi = 0, fp0, fprim_p0;
        Object[] fila = new Object[6];
        
        tblmodelDatos.setColumnIdentifiers( new String[]{"i","P","f(P)","f'(P)","Pi","|Pi-P|"} );
        //fila[0] = 0;            fila[1] = p0;   fila[2] = fp0;
        //fila[3] = fprim_p0;     fila[4] = pi;   fila[5] = Math.abs(pi-p0);
        for( i=1; i<=numIter; i++){
            fp0 = f.evaluar(p0);
            fprim_p0 = fprima.evaluar(p0);
            pi = p0 - fp0/fprim_p0;
            fila[0] = i;            fila[1] = p0;   fila[2] = fp0;
            fila[3] = fprim_p0;     fila[4] = pi;   fila[5] = Math.abs(pi-p0);
            tblmodelDatos.addRow(fila);
            if( Math.abs(pi-p0)<tolerancia )
                break;
            p0 = pi;
        }
        if( i>numIter )
            throw new RaizNotFoundException("Raiz NO encontrada\nEl metodo fracaso despues de "+numIter+" intendtos");
        
        return pi;
    }
    
    public double reglaFalsa(double a, double b, double tolerancia, int numIter) throws RaizNotFoundException{
        
        double fa,fb,fc,c;
        int i;
        Double[] fila = new Double[7];
        boolean ex=false;
        tblmodelDatos.setColumnIdentifiers( new String[]{"i","a","b","f(a)","f(b)","c","f(c)"} );
        
        for(i=0;i<numIter;i++){
            fila[0] = new Double(i+1);
            fila[1] = a;      fila[2] = b;
            fila[3] = fa = f.evaluar(a);
            fila[4] = fb = f.evaluar(b);
            fila[5] = c  = a - ( ( fa*(b-a) )/(fb-fa) );
                //fc=Math.pow(c,3)+4*(Math.pow(c,2))-10;
            fila[6] = fc = f.evaluar(c);
            tblmodelDatos.addRow(fila);
          //si  (b-a)<tol. salir (tomar como raíz c)
            if( Math.abs(b-a)<tolerancia ){
                ex=true;
            	break;
            }  
            else{
                if(fa*fc<0)
                    b=c;
                if(fa*fc>0)
                    a=c;
                if(fa*fc==0){
                    ex=true;
                    break;
                }
            }
        }
        if(ex==false)
            throw new RaizNotFoundException("Fallo despues de "+i+" iteraciones\n");
        	
        return a;
    }

    public double reglaFalsaModificada(double a, double b, double tolerancia, int numIter) throws RaizNotFoundException{
        int i;
        boolean ex = false;
        double fa,fb,fw,w,F,G, antFw;
        Object[] fila = new Object[8];
        tblmodelDatos.setColumnIdentifiers( new String[]{"i","a","b","f(a)","f(b)","w","f(w)","|w-a|"} );
        
        fa = f.evaluar(a);
        fb = f.evaluar(b);
        F=fa;
        G=fb;
        w=a;
        fila[5]=w;
        antFw = F;
        for(i=0;i<numIter;i++){
            fila[0]=i+1;
            fila[1]=a;
            fila[2]=b;
            fila[3]=F;
            fila[4]=G;
            w = (G*a-F*b)/(G-F);
            fw = f.evaluar(w);
            fila[6] = fw;
            if( i+1!=numIter ){
                System.out.println("i+1 = "+(i+1));
                fila[5] = w;
            }
            //System.out.println("Agregando fila "+i+"\n -> "+fila);
            fila[7] = Math.abs(w-a);
            tblmodelDatos.addRow(fila);
            if( Math.abs(w-a)<tolerancia ){
                ex=true;
                break;
            }
            else{
                if( fa*fw<0 ){
                    b=w;
                    G=fw;
                    if( antFw*fw>0 )
    			F=F/2;
    		}
    		else{
                    a=w;
                    F=fw;
                    if( antFw*fw>0 )
                	G=G/2;
    		}
            }
            antFw = fw;
    	}
    	if( ex==false )
            throw new RaizNotFoundException("Fallo despues de "+i+" iteraciones");
        
        return w;
    }
    
    public double puntoFijo(double p0, double tolerancia, double numIter, Funcion gx) throws RaizNotFoundException{
        double pi;
        Object[] fila = new Object[4];
        int i;
        tblmodelDatos.setColumnIdentifiers( new String[]{"i","pi","f(pi)","|pi-p0|"} );
        
        for( i=1; i<=numIter; i++){
            pi = gx.evaluar(p0);
//            if( new Double(pi).isNaN() ){
//                System.out.println("f("+p0+") = "+gx.evaluar(p0));
//                throw new RaizNotFoundException("Terminado debido a un NaN");
//            }
            fila[0] = i;    fila[1] = p0;
            fila[2] = pi;    fila[3] =  Math.abs(pi-p0);
            tblmodelDatos.addRow(fila);
            if( Math.abs(pi-p0)<tolerancia )
                return pi;
            p0 = pi;
        }
        throw new RaizNotFoundException("Fallo despues de "+(i-1)+" iteraciones");
    }
    
    public static void main(String[] args){
        RaizFuncion rf = new RaizFuncion( new Funcion(EnumFuncion.RAIZ_4) );
        try {
            //System.out.println("Resultado = "+rf.secante(new Funcion(EnumFuncion.RAIZ_1), 1,2, 0.0001, 20)+"\n");
            //System.out.println("Resultado = "+rf.secante(new Funcion(EnumFuncion.RAIZ_2), 1,2, 0.0001, 20)+"\n");
            //System.out.println("Resultado = "+rf.secante(new Funcion(EnumFuncion.RAIZ_3), 0,1, 0.00001, 20)+"\n");
            System.out.println("Resultado = "+rf.secante( 2, 2.5, 0.0001, 20)+"\n");
            //System.out.println("Resultado = "+rf.secante(new Funcion(EnumFuncion.RAIZ_5), 1,3, 0.0001, 20)+"\n");
            //System.out.println("Resultado = "+rf.secante(new Funcion(EnumFuncion.AUX), 1.2,1.6, 0.001, 20)+"\n");
        } catch (RaizNotFoundException ex) {
            Logger.getLogger(RaizFuncion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
