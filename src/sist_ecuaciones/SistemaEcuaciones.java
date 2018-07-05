
package sist_ecuaciones;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JLabel;

import org.scilab.forge.jlatexmath.TeXConstants;

public class SistemaEcuaciones {
    int n, m;
    double[][] matriz;
    double[] vecSol;
    ArrayList<Image> imgPasos;
    
    public SistemaEcuaciones(double[][] matriz, double[] solucion){
        this.matriz = matriz;
        vecSol = solucion;
        n = matriz.length;
        m  = matriz[0].length;
        imgPasos = new ArrayList<>();
    }
    
    public double[] gauss() throws ExcepcionSistemaSinSolucion{
        int i, j, p, k;
        double t;
        ImagenMathText imlatex = new ImagenMathText(15);
        DiseñadorImagen gestorImg;
        Image imgTemp;
        
        double[][] matrizAmpl = new double[n][n+1];
        for(i=0; i<n; i++){
            for(j=0; j<n; j++)
                matrizAmpl[i][j] = matriz[i][j];
            matrizAmpl[i][j] = vecSol[i];
        }
        System.out.println("\n");
   	mostrarMatrizAmpliada(matrizAmpl);
        //gestorImg = new DiseñadorImagen( crearImagenDeTexto("Matriz Ampliada") );
        System.out.println("SE: dibujando matriz");
        imgPasos.add( DiseñadorImagen.pegarHorizontalmente((BufferedImage) crearImagenDeTexto("Matriz Ampliada"), (BufferedImage) imlatex.imgMatrizAmpliada(matrizAmpl), 0) );
        System.out.println("SE: matriz dibujada");
        //imgPasos.add( imlatex.imgMatrizAmpliada(matrizAmpl) );
        imgPasos.add( crearImagenDeTexto("Escalonamiento:") );
   	System.out.println("\n");
   	 
        for (i = 0; i<n; i++){
            p = i;
            if( matrizAmpl[p][i] == 0){
                System.out.println("Entre if: matriz["+p+"]["+i+"] = "+matrizAmpl[p][i]);
                for( k=i; k<n; k++){
                    if( matrizAmpl[k][i]!=0 ){
                        p = k;
                        break;
                    }
                }
                if( k==n )
                    throw new ExcepcionSistemaSinSolucion("El sistema no tiene solucion unica");
            }
            if (p != i){
                for (j = 0; j <n+1; j++){
                    t = matrizAmpl[i][j];
                    matrizAmpl[i][j] = matrizAmpl[p][j];
                    matrizAmpl[p][j] = t;
                }
                imlatex.limpiar();
                imlatex.add("E");           imlatex.addSubindice(""+(i+1));
                imlatex.add(" <--> E");     imlatex.addSubindice(""+(p+1));
                gestorImg = new DiseñadorImagen((BufferedImage) imlatex.getImage());
                gestorImg.agregarDerecha((BufferedImage) imlatex.imgMatrizAmpliada(matrizAmpl), 1);
                imgPasos.add( gestorImg.getImagen() );
            }
            
            for (j = i+1; j<n; j++){
                t = matrizAmpl[j][i] / matrizAmpl[i][i];
                for (k = 0; k < n+1; k++){
                    System.out.println("paso ("+j+")-> "+matrizAmpl[j][k]+" - "+t+" * "+matrizAmpl[i][k]);
                    matrizAmpl[j][k] = matrizAmpl[j][k] - t * matrizAmpl[i][k];
                }
                imlatex.limpiar();
                imlatex.add("E");           imlatex.addSubindice(""+(j+1));
                imlatex.add("-"+t+"E");     imlatex.addSubindice(""+(i+1));
                imlatex.add("->E");         imlatex.addSubindice(""+(j+1));
                imgTemp = imlatex.getImage();
                gestorImg = new DiseñadorImagen((BufferedImage) imgTemp);
                gestorImg.agregarDerecha((BufferedImage) imlatex.imgMatrizAmpliada(matrizAmpl), 1);
                System.out.println("\n");
           	mostrarMatrizAmpliada(matrizAmpl);
                imgPasos.add( gestorImg.getImagen() );
           	System.out.println("\n");
            }
        }
        
        if( matrizAmpl[n-1][n-1]==0 )
            throw new ExcepcionSistemaSinSolucion("El sistema no tiene solucion unica");
        
        double[] resultado = new double[n];
        double sum;
        String strFormula;
        resultado[n-1] = matrizAmpl[n-1][n] / matrizAmpl[n-1][n-1];
        gestorImg = new DiseñadorImagen( (BufferedImage) crearImagenDeTexto("Sustitucion"));
        gestorImg.agregarDerecha((BufferedImage) crearImagenDeTexto("hacia"), 0.5, 5);
        gestorImg.agregarDerecha((BufferedImage) crearImagenDeTexto("atras:"), 0.5, 5);
        imgPasos.add( gestorImg.getImagen() );
        imlatex.limpiar();
        imlatex.add("x");   imlatex.addSubindice(""+n);
        imlatex.add("=");
        imlatex.addFraccion(""+matrizAmpl[n-1][n], ""+matrizAmpl[n-1][n-1]);
        imlatex.add("="+resultado[n-1]);
        //imgPasos.add( imlatex.dibujarFormula() );
        imgPasos.add( imlatex.getImage() );
        imlatex.limpiar();

        for (int f=n-2; f>=0; f--){
            sum = 0;
            imlatex.limpiar();
            imlatex.add(matrizAmpl[f][n]+"-[ ");
            for (int i1 = n-1; i1 > f; i1--){
                sum += matrizAmpl[f][i1] * resultado[i1];
                
                if( matrizAmpl[f][i1]<0 )
                    imlatex.add( "("+matrizAmpl[f][i1]+")x" );
                else
                    imlatex.add( ""+matrizAmpl[f][i1]+"x" );
                imlatex.addSubindice( ""+(i1+1) );
                if( i1!=f+1 )
                    imlatex.add(" + ");
            }
            resultado[f] = (matrizAmpl[f][n] - sum) / matrizAmpl[f][f];
            
            imlatex.add(" ]");
            strFormula = imlatex.getFormula();
            imlatex.limpiar();
            imlatex.add("x");   imlatex.addSubindice(""+(f+1));
            imlatex.add("=");
            imlatex.addFraccion(strFormula, ""+matrizAmpl[f][f]);
            imlatex.add("="+resultado[f]);
            imgPasos.add( imlatex.getImage() );
            System.out.println("FORMULA: "+imlatex.getFormula());
        }
        
        gestorImg = new DiseñadorImagen( (BufferedImage) imlatex.getImgFormula("X = "));
        gestorImg.agregarDerecha((BufferedImage) imlatex.imgMatriz(new double[][]{resultado}), 0.5);
        gestorImg.agregarIzquierda((BufferedImage) crearImagenDeTexto("Vector Solucion: "), 0.5);
        imgPasos.add( gestorImg.getImagen() );
        for(int r=0;r<resultado.length;r++)
        	System.out.println("\nX"+(r+1)+":"+resultado[r]);
        
        return resultado;
    }
    
    public double[] pivoteoEscalonado()
    {
        ImagenMathText imlatex = new ImagenMathText(15);
        int i, j;
        double[][] matrizAmpl = new double[n][n+1];
        for(i=0; i<n; i++){
            for(j=0; j<n; j++)
                matrizAmpl[i][j] = matriz[i][j];
            matrizAmpl[i][j] = vecSol[i];
        }
        System.out.println("\n");
        mostrarMatrizAmpliada(matrizAmpl);
        BufferedImage imgTexto = (BufferedImage) crearImagenDeTexto("Matriz Ampliada");
        BufferedImage imgMatriz = (BufferedImage) imlatex.imgMatrizAmpliada(matrizAmpl);
        imgPasos.add( DiseñadorImagen.pegarHorizontalmente( imgTexto, imgMatriz, 0) );
        //imgPasos.add( imlatex.imgMatriz(matrizAmpl) );
        System.out.println("\n");

        imgPasos.add( crearImagenDeTexto("Pivoteo") );
        matrizAmpl = pivote(matrizAmpl);

        DiseñadorImagen gestorImg = new DiseñadorImagen( (BufferedImage) crearImagenDeTexto("Sustitucion"));
        gestorImg.agregarDerecha((BufferedImage) crearImagenDeTexto("hacia"), 0.5, 5);
        gestorImg.agregarDerecha((BufferedImage) crearImagenDeTexto("atras:"), 0.5, 5);
        imgPasos.add( gestorImg.getImagen() );
        return sustitucionHaciaAtras(matrizAmpl);
    }
    
    public double[][] pivote(double[][] matrizAmpl){
        int i, j, k, maxr;
        double t, pivot;
        ImagenMathText imlatex = new ImagenMathText(15);
        DiseñadorImagen gestorImg;
	
        //JOptionPane.showMessageDialog(null, "i="+i+" n="+n);
        for (i=0; i < n; i++){ 
            maxr= i;		

            for (j= i+1; j < n; j++)
                if (Math.abs(matrizAmpl[j][i]) > Math.abs(matrizAmpl[maxr][i]))
                    maxr= j;
            if (maxr != i){
                for (k=i; k <= n; k++){
                    t= matrizAmpl[i][k];    
                    matrizAmpl[i][k] = matrizAmpl[maxr][k];
                    matrizAmpl[maxr][k] = t;   
                }
                imlatex.limpiar();
                imlatex.add("E");           imlatex.addSubindice(""+(i+1));
                imlatex.add(" <--> E");     imlatex.addSubindice(""+(maxr+1));
                gestorImg = new DiseñadorImagen((BufferedImage) imlatex.getImage());
                gestorImg.agregarDerecha((BufferedImage) imlatex.imgMatrizAmpliada(matrizAmpl), 1);
                imgPasos.add( gestorImg.getImagen() );
            }
            for (j= i+1; j <n; j++){
            	pivot = matrizAmpl[j][i]/(matrizAmpl[i][i]);
              	for (k= n; k >=i; k--){
                  	matrizAmpl[j][k]=matrizAmpl[j][k]-matrizAmpl[i][k]*pivot;                         
              	}
              	
                gestorImg = new DiseñadorImagen((BufferedImage) crearImagenPaso(j, i, pivot, 15));
                gestorImg.agregarDerecha((BufferedImage) imlatex.imgMatrizAmpliada(matrizAmpl), 1);
           	mostrarMatrizAmpliada(matrizAmpl);
                imgPasos.add( gestorImg.getImagen() );
                
             System.out.println("\n");
              mostrarMatrizAmpliada(matrizAmpl);
              System.out.println("\n");
            }
        }
        return matrizAmpl;
    }
    
    public double[] sustitucionHaciaAtras(double[][] matrizAmpl){
        double[] resultado = new double[n];
        ImagenMathText imlatex = new ImagenMathText(15);
        String strFormula;

        resultado[n-1] = matrizAmpl[n-1][n] / matrizAmpl[n-1][n-1];
        
        imlatex.limpiar();
        imlatex.add("x");   imlatex.addSubindice(""+n);
        imlatex.add("=");
        imlatex.addFraccion(""+matrizAmpl[n-1][n], ""+matrizAmpl[n-1][n-1]);
        imlatex.add("="+resultado[n-1]);
        imgPasos.add( imlatex.getImage() );
        imlatex.limpiar();
        
        for (int f = n-2; f >= 0; f--){
            double sum = 0;
            imlatex.limpiar();
            imlatex.add(matrizAmpl[f][n]+"-[ ");

            for (int i1=n-1; i1>f; i1--){
                sum += matrizAmpl[f][i1] * resultado[i1];
                
                crearImagenTermino(imlatex, matrizAmpl[f][i1], i1+1);
                if( i1!=f+1 )
                    imlatex.add(" + ");
            }

            resultado[f] = (matrizAmpl[f][n] - sum) / matrizAmpl[f][f];
            
            imlatex.add(" ]");
            strFormula = imlatex.getFormula();
            imlatex.limpiar();
            imlatex.add("x");   imlatex.addSubindice(""+(f+1));
            imlatex.add("=");
            imlatex.addFraccion(strFormula, ""+matrizAmpl[f][f]);
            imlatex.add("="+resultado[f]);
            imgPasos.add( imlatex.getImage() );
        }	
        
        DiseñadorImagen gestorImg = new DiseñadorImagen( (BufferedImage) imlatex.getImgFormula("X = "));
        gestorImg.agregarDerecha((BufferedImage) imlatex.imgMatriz(new double[][]{resultado}), 0.5);
        gestorImg.agregarIzquierda((BufferedImage) crearImagenDeTexto("Vector Solucion"), 0.5);
        imgPasos.add( gestorImg.getImagen() );
        for(int r=0;r<resultado.length;r++)
        	System.out.println("\nX"+(r+1)+":"+resultado[r]);
        
        return resultado;
    }
    
    public double[] gaussJordan() throws ExcepcionSistemaSinSolucion{
	int i, j, p=0, k;
        double t,x;
        double[][] matrizAmpl = new double[n][n+1];
        ImagenMathText imlatex = new ImagenMathText(15);
        DiseñadorImagen gestorImg;
        
        for(i=0; i<n; i++){
            for(j=0; j<n; j++)
                matrizAmpl[i][j] = matriz[i][j];
            matrizAmpl[i][j] = vecSol[i];
        }
        BufferedImage imgTexto = (BufferedImage) crearImagenDeTexto("Matriz Ampliada");
        BufferedImage imgMatriz = (BufferedImage) imlatex.imgMatrizAmpliada(matrizAmpl);
        imgPasos.add( DiseñadorImagen.pegarHorizontalmente( imgTexto, imgMatriz, 0) );
        imgPasos.add( crearImagenDeTexto("Escalonamiento") );
            
        for (i = 0; i < n; i++){
            p = i;//0,
            if( matrizAmpl[p][i] == 0){
                for (k = i; k <n+1; k++){
                    if ( matrizAmpl[k][i] != 0){
                        p = k;
                        break;
                    }
                }
                if( k==n )
                    throw new ExcepcionSistemaSinSolucion("El sistema no tiene solucion unica");
            }
            if (p != i){
                for (j = 0; j <n+1; j++){
                    t = matrizAmpl[i][j];//00=2, 01=3
                    matrizAmpl[i][j] = matrizAmpl[p][j];
                    matrizAmpl[p][j] = t;//
                }
                imlatex.limpiar();
                imlatex.add("E");           imlatex.addSubindice(""+(i+1));
                imlatex.add(" <--> E");     imlatex.addSubindice(""+(p+1));
                gestorImg = new DiseñadorImagen((BufferedImage) imlatex.getImage());
                gestorImg.agregarDerecha((BufferedImage) imlatex.imgMatrizAmpliada(matrizAmpl), 1);
                imgPasos.add( gestorImg.getImagen() );
            }
            
            for (j = i + 1; j<n; j++){//I=o, J=2
                t = matrizAmpl[j][i] / matrizAmpl[i][i];//4
                for (k = 0; k < n+1; k++){//0,1
                    matrizAmpl[j][k] = matrizAmpl[j][k] - t * matrizAmpl[i][k];
                }
                gestorImg = new DiseñadorImagen((BufferedImage) crearImagenPaso(j, i, t, 15));
                gestorImg.agregarDerecha((BufferedImage) imlatex.imgMatrizAmpliada(matrizAmpl), 1);
           	mostrarMatrizAmpliada(matrizAmpl);
                imgPasos.add( gestorImg.getImagen() );
              mostrarMatrizAmpliada(matrizAmpl);
            }
        }
//Aqui lo mio (Cambiar por unos los de la diagonal)
//int y= ec-1;{//2
        gestorImg = new DiseñadorImagen( (BufferedImage) crearImagenDeTexto("Simplificando"));
        gestorImg.agregarDerecha((BufferedImage) crearImagenDeTexto("diagonal"), 0.5, 4);
        imgPasos.add( gestorImg.getImagen() );
        gestorImg = new DiseñadorImagen((BufferedImage) imlatex.getImgFormula(""));
	for (int X=n-1; X>-1;X--){//0 
            double div = matrizAmpl[X][X];//5
            for (int u=n;u>X-1;u--){//0 X=-1
                matrizAmpl[X][u] = matrizAmpl[X][u]/div;
            }	//0,0	
            imlatex.limpiar();
            imlatex.add("E");           imlatex.addSubindice(""+(X+1));
            imlatex.add("/"+div);
            imlatex.add("->E");         imlatex.addSubindice(""+(X+1));
            gestorImg.agregarArriba((BufferedImage) imlatex.getImage(), 1);
	}
        gestorImg.agregarDerecha((BufferedImage) imlatex.imgMatrizAmpliada(matrizAmpl), 0.5);
        imgPasos.add( gestorImg.getImagen() );
        
        // REDUCCION HACIA ATRAS
        imgPasos.add( crearImagenDeTexto("Reduccion:") );
        int N=-1;
        double div;
        for (i = n-1; i>0; i--){
            N++;
            for( j = n-N-1; j>0; j--){
                div = matrizAmpl[j-1][i]/matrizAmpl[i][i];
                for(int X = n-1; X>-1; X--){
                    matrizAmpl[j-1][X+1] = matrizAmpl[j-1][X+1]-(div*matrizAmpl[i][X+1]);
                }
                gestorImg = new DiseñadorImagen((BufferedImage) crearImagenPaso(j, i, div, 15));
                gestorImg.agregarDerecha((BufferedImage) imlatex.imgMatrizAmpliada(matrizAmpl), 1);
           	mostrarMatrizAmpliada(matrizAmpl);
                imgPasos.add( gestorImg.getImagen() );
              mostrarMatrizAmpliada(matrizAmpl);
            }
        }

        double[] resultado = new double[n];
        resultado[n - 1] = matrizAmpl[n - 1][n] / matrizAmpl[n - 1][n- 1];

        for (int f = n-2; f>=0; f--){
            double sum = 0;
            for (int i1 = n - 1; i1 > f; i1--)
                sum += matrizAmpl[f][i1] * resultado[i1];
            resultado[f] = (matrizAmpl[f][n] - sum) / matrizAmpl[f][f];
        }
        
        gestorImg = new DiseñadorImagen( (BufferedImage) imlatex.getImgFormula("X = "));
        gestorImg.agregarDerecha((BufferedImage) imlatex.imgMatriz(new double[][]{resultado}), 0.5);
        gestorImg.agregarIzquierda((BufferedImage) crearImagenDeTexto("Vector\tSolucion"), 0.5);
        imgPasos.add( gestorImg.getImagen() );
        
        for(int r=0;r<resultado.length;r++)
        	System.out.println("X"+(r+1)+":"+resultado[r]);
        
        return resultado;
    }
    
    public double[] inversa() throws ExcepcionSistemaSinSolucion{
	int i, j, p=0, k;
        double t,x;
        double[][] matrizAmpl = new double[n][n*2];
        ImagenMathText imlatex = new ImagenMathText(15);
        DiseñadorImagen gestorImg;
        
        for(i=0; i<n; i++){
            for(j=0; j<n; j++)
                matrizAmpl[i][j] = matriz[i][j];
            matrizAmpl[i][i+n] = 1;
        }
        imgPasos.add( crearImagenDeTexto("Matriz Ampliada") );
        imgPasos.add( imlatex.imgMatrizAmpliada(matrizAmpl, n) );
        imgPasos.add( crearImagenDeTexto("Escalonamiento:") );
        
        for (i = 0; i < n; i++){
            p = i;//0,
            if ( matrizAmpl[p][i] == 0){
                for (k = i; k <n; k++){
                    if( matrizAmpl[k][i] != 0 ){
                        p = k;
                        break;
                    }
                }
                if( k==n )
                    throw new ExcepcionSistemaSinSolucion("El sistema no tiene solucion unica");
            }
            if (p != i){
                for (j = 0; j <n*2; j++){
                    t = matrizAmpl[i][j];//00=2, 01=3
                    matrizAmpl[i][j] = matrizAmpl[p][j];
                    matrizAmpl[p][j] = t;//
                }
                imlatex.limpiar();
                imlatex.add("E");           imlatex.addSubindice(""+(i+1));
                imlatex.add(" <--> E");     imlatex.addSubindice(""+(p+1));
                gestorImg = new DiseñadorImagen((BufferedImage) imlatex.getImage());
                gestorImg.agregarDerecha((BufferedImage) imlatex.imgMatrizAmpliada(matrizAmpl), 1);
                imgPasos.add( gestorImg.getImagen() );
            }
            
            for (j = i + 1; j < n; j++){//I=o, J=2
                t = matrizAmpl[j][i] / matrizAmpl[i][i];//4
                for (k = 0; k < n*2; k++){//0,1
                    System.out.println("j="+j+"\tk="+k+"\ti="+i);
                    //JOptionPane.showMessageDialog(null, "j="+j+"\tk="+k+"\ti="+i);
                    matrizAmpl[j][k] = matrizAmpl[j][k] - t * matrizAmpl[i][k];
                }
                gestorImg = new DiseñadorImagen((BufferedImage) crearImagenPaso(j, i, t, 15));
                gestorImg.agregarDerecha((BufferedImage) imlatex.imgMatrizAmpliada(matrizAmpl, n), 1);
                imgPasos.add( gestorImg.getImagen() );
              mostrarMatrizInversa(matrizAmpl);
            }
}
//Aqui lo mio (Cambiar por unos los de la diagonal)
//int y= ec-1;{//2
        gestorImg = new DiseñadorImagen( (BufferedImage) crearImagenDeTexto("Simplificando"));
        gestorImg.agregarDerecha((BufferedImage) crearImagenDeTexto("diagonal"), 0.5, 4);
        imgPasos.add( gestorImg.getImagen() );
	for (int X=n-1; X>-1;X--){//0 
		double div = matrizAmpl[X][X];//5
		for (int u=n*2-1; u>X-1; u--){//0 X=-1
			matrizAmpl[X][u] = matrizAmpl[X][u]/div;
		}	//0,0	
	}
        imgPasos.add( imlatex.imgMatrizAmpliada(matrizAmpl, n) );
              mostrarMatrizInversa(matrizAmpl);
//Aqui termina
//Inversa
        imgPasos.add( crearImagenDeTexto("Reduccion:") );
        int N=-1;    
        for (i = n-1; i>0; i--){
            N++;
            for(j = n-N-1; j>0; j--){
                double div = matrizAmpl[j-1][i]/matrizAmpl[i][i];
                for (int X = n*2-1; X>-1; X--){
                    matrizAmpl[j-1][X] = matrizAmpl[j-1][X]-(div*matrizAmpl[i][X]);
                }
                gestorImg = new DiseñadorImagen((BufferedImage) crearImagenPaso(j, i, div, 15));
                gestorImg.agregarDerecha((BufferedImage) imlatex.imgMatrizAmpliada(matrizAmpl, n), 1);
                imgPasos.add( gestorImg.getImagen() );
              mostrarMatrizInversa(matrizAmpl);
            }
        }

        double[] resultado = new double[n];
        resultado[n-1] = matrizAmpl[n-1][n] / matrizAmpl[n-1][n-1];

//        for (int f = n-2; f >= 0; f--){
//            double sum = 0;
//
//            for (int i1 = n - 1; i1 > f; i1--){
//                sum += matrizAmpl[f][i1] * resultado[i1];
//            }
//
//            resultado[f] = (matrizAmpl[f][n] - sum) / matrizAmpl[f][f];
//        }
        double sum;
        for( i=0; i<n; i++){
            sum = 0;
            for( k=0; k<n; k++){
                sum += matrizAmpl[i][k+n] * vecSol[k];
                System.out.println("mat["+i+"]["+(k+n)+" * vecSol["+k+"]");
                System.out.println(matrizAmpl[i][k+n]+" * "+vecSol[k]+" = "+sum);
            }
            resultado[i] =  sum;
        }
        gestorImg = new DiseñadorImagen( (BufferedImage) imlatex.getImgFormula("X = "));
        gestorImg.agregarDerecha((BufferedImage) imlatex.imgMatriz(new double[][]{resultado}), 0.5);
        gestorImg.agregarIzquierda((BufferedImage) crearImagenDeTexto("Vector Solucion"), 0.5);
        imgPasos.add( gestorImg.getImagen() );
        
        return resultado;
    }
    public void mostrarMatriz(){
	for(int i=0; i<n; i++){
            System.out.println("\n");
            for(int j=0; j<n; j++)
       		System.out.printf("%15f",matriz[i][j]);
       	}
    }
    
    public void mostrarMatrizAmpliada(double s[][]){
        for(int i=0;i<n;i++){
            System.out.println("\n");
            for(int j=0;j<n+1;j++)
                System.out.printf("%15f",s[i][j]);
        }
    }
    public void mostrarMatrizInversa(double s[][]){
        for(int i=0;i<n;i++){
            System.out.println("\n");
            for(int j=0;j<n*2;j++)
                System.out.printf("%15f",s[i][j]);
        }
    }

    public double[] cholesky() throws ExcepcionSistemaSinSolucion{
        if( !(esSimetrica() && esDefinidaPositiva() ) )
            throw new ExcepcionSistemaSinSolucion("El sistema no cumple con las caracteristicas");
        int i, j, k;
        double sum;
        double[][] low = new double[n][n];
        String strFormula;
        ImagenMathText imlatex = new ImagenMathText(15);
        imgPasos.add( crearImagenDeTexto("Matriz Coeficientes") );
        imgPasos.add( imlatex.imgMatriz(matriz) );
        imgPasos.add( crearImagenDeTexto("Matriz L:") );
        
        low[0][0] = Math.sqrt(matriz[0][0]);
        System.out.println("Paso 1: L[0,0]="+low[0][0]);
        System.out.println("Paso 2:");
        for(i=1; i<n; i++){
            low[i][0] = matriz[i][0]/low[0][0];
        System.out.println(" L["+i+","+0+"]="+low[i][0]);
        }
        System.out.println("Paso 3:");
        for(i=1; i<n-1; i++){
            sum = 0;
            for(k=0; k<i; k++){
                sum += low[i][k]*low[i][k];
        System.out.println("     L["+i+","+k+"]="+low[i][k]+"\tsum="+sum);
            }
        System.out.println("\n M["+i+","+i+"]="+matriz[i][i]+"\tsum="+sum);
            low[i][i] = Math.sqrt(matriz[i][i]-sum);
        System.out.println("  Paso 4: L["+i+","+i+"]="+low[i][i]);
            
        System.out.println("  Paso 5:");
            for(j=i+1; j<n; j++){
                sum = 0;
                for(k=0; k<i; k++)
                    sum += low[j][k]*low[i][k];
                low[j][i] = (matriz[j][i] - sum) / low[i][i];
        System.out.println("   L["+j+","+i+"]="+low[j][i]);
            }
        }
        sum = 0;
        for(k=0; k<i; k++){
            sum += low[i][k]*low[i][k];
        System.out.println("   6: L["+i+","+k+"]="+low[i][k]+"\tsum="+sum);
        }
        low[i][i] = Math.sqrt(matriz[i][i]-sum);
        System.out.println("Paso 6: L["+i+","+i+"]="+low[i][i]);
        
        imgPasos.add( imlatex.imgMatriz(low) );
        
        DiseñadorImagen gestorImg = new DiseñadorImagen( (BufferedImage) crearImagenDeTexto("Sustitucion"));
        gestorImg.agregarDerecha((BufferedImage) crearImagenDeTexto("hacia"), 0.5, 5);
        gestorImg.agregarDerecha((BufferedImage) crearImagenDeTexto("adelante:"), 0.5, 5);
        imgPasos.add( gestorImg.getImagen() );
        double[] Y = new double[n];
        Y[0] = vecSol[0]/low[0][0];
        System.out.println("Paso 7: Y[0]="+Y[0]);
        System.out.println("Paso 8:");
        for(i=1; i<n; i++){
            imlatex.limpiar();
            imlatex.add( vecSol[i]+"-[ " );
            for(k=0, sum=0; k<i; k++){
                sum += low[i][k]*Y[k];
                crearImagenTermino(imlatex, low[i][k], k+1);
        System.out.println("   8: L["+i+","+k+"]="+low[i][k]+"*Y["+k+"]="+Y[k]+"\tsum="+sum);
            }
            imlatex.add(" ]");
            Y[i] = (vecSol[i] - sum)/low[i][i];
            
            strFormula = imlatex.getFormula();
            imlatex.limpiar();
            imlatex.add("x");   imlatex.addSubindice(""+(i+1));
            imlatex.add("=");
            imlatex.addFraccion(strFormula, ""+low[i][i]);
            imlatex.add("="+Y[i]);
            imgPasos.add( imlatex.getImage() );
        System.out.println("  Y["+i+"]="+Y[i]);
        }
        
        gestorImg = new DiseñadorImagen( (BufferedImage) crearImagenDeTexto("Sustitucion"));
        gestorImg.agregarDerecha((BufferedImage) crearImagenDeTexto("hacia"), 0.5, 5);
        gestorImg.agregarDerecha((BufferedImage) crearImagenDeTexto("atras:"), 0.5, 5);
        imgPasos.add( gestorImg.getImagen() );
        double[] X = new double[n];
        X[n-1] = Y[n-1]/low[n-1][n-1];
        System.out.println("Paso 9: X["+(n-1)+"]="+X[n-1]);
        System.out.println("  Paso 10:");
        for(i=n-2; i>=0; i--){
            imlatex.limpiar();
            imlatex.add( Y[i]+"-[ " );
            for(k=i, sum=0; k<n; k++){
                sum += low[k][i]*X[k];
                crearImagenTermino(imlatex, low[k][i], i+1);
            }
            imlatex.add( " ]" );
            X[i] = (Y[i] - sum)/low[i][i];
            
            strFormula = imlatex.getFormula();
            imlatex.limpiar();
            imlatex.add("x");   imlatex.addSubindice(""+(i+1));
            imlatex.add("=");
            imlatex.addFraccion(strFormula, ""+low[i][i]);
            imlatex.add("="+X[i]);
            imgPasos.add( imlatex.getImage() );
        System.out.println("  X["+i+"]="+X[i]);
        }
        
        gestorImg = new DiseñadorImagen( (BufferedImage) imlatex.getImgFormula("X = "));
        gestorImg.agregarDerecha((BufferedImage) imlatex.imgMatriz(new double[][]{X}), 0.5);
        gestorImg.agregarIzquierda((BufferedImage) crearImagenDeTexto("Vector Solucion: "), 0.5);
        imgPasos.add( gestorImg.getImagen() );
        
        return X;
    }
    
    public Fraccion[] choleskyFracc() throws ExcepcionSistemaSinSolucion{
        System.out.println("\nCholesky\n");
        if( !(esSimetrica() && esDefinidaPositiva() ) )
            throw new ExcepcionSistemaSinSolucion("El sistema no cumple con las caracteristicas");
        int i, j, k;
        Fraccion sum;
        Fraccion[][] low = new Fraccion[n][n];
        Fraccion[][] matrizF = new Fraccion[n][n];
        Fraccion[] vecSolF = new Fraccion[n];
        for( i=0; i<n; i++){
            for(j=0; j<m; j++){
                matrizF[i][j] = new Fraccion(matriz[i][j]);
            }
            vecSolF[i] = new Fraccion(vecSol[i]);
        }
        
        low[0][0] = new Fraccion( Math.sqrt(matrizF[0][0].getValor()) );
        System.out.println("Paso 1: L[0,0]="+low[0][0]);
        System.out.println("Paso 2:");
        for(i=1; i<n; i++){
            low[i][0] = matrizF[i][0].entre(low[0][0]);
        System.out.println(" L["+i+","+0+"]="+low[i][0]);
        }
        System.out.println("Paso 3:");
        for(i=1; i<n-1; i++){
            sum = new Fraccion(0);
            for(k=0; k<i; k++){
                sum = sum.mas( low[i][k].por(low[i][k]) );
        System.out.println("     L["+i+","+k+"]="+low[i][k]+"\tsum="+sum);
            }
        System.out.println("\n M["+i+","+i+"]="+matrizF[i][i]+"\tsum="+sum);
            low[i][i] = new Fraccion( Math.sqrt( matrizF[i][i].menos(sum).getValor() ) );
        System.out.println("  Paso 4: L["+i+","+i+"]="+low[i][i]);
            
        System.out.println("  Paso 5:");
            for(j=i+1; j<n; j++){
                sum = new Fraccion(0);
                for(k=0; k<i; k++)
                    sum = sum.mas( low[j][k].por(low[i][k]) );
                low[j][i] = matrizF[j][i].menos(sum).entre(low[i][i]);
        System.out.println("   L["+j+","+i+"]="+low[j][i]);
            }
        }
        sum = new Fraccion(0);
        for(k=0; k<i; k++){
            sum = sum.mas( low[i][k].por(low[i][k]) );
        System.out.println("   6: L["+i+","+k+"]="+low[i][k]+"\tsum="+sum);
        }
        low[i][i] = new Fraccion( Math.sqrt( matrizF[i][i].menos(sum).getValor() ) );
        System.out.println("Paso 6: L["+i+","+i+"]="+low[i][i]);
        
        Fraccion[] Y = new Fraccion[n];
        Y[0] = vecSolF[0].entre(low[0][0]);
        System.out.println("Paso 7: Y[0]="+Y[0]);
        System.out.println("Paso 8:");
        for(i=1; i<n; i++){
            sum = new Fraccion(0);
            for(k=0; k<i; k++){
                sum = sum.mas( low[i][k].por(Y[k]) );
        System.out.println("   8: L["+i+","+k+"]="+low[i][k]+"*Y["+k+"]="+Y[k]+"\tsum="+sum);
            }
            Y[i] = vecSolF[i].menos(sum).entre(low[i][i]);
        System.out.println("  Y["+i+"]="+Y[i]);
        }
        
        Fraccion[] X = new Fraccion[n];
        X[n-1] = Y[n-1].entre(low[n-1][n-1]);
        System.out.println("Paso 9: X["+(n-1)+"]="+X[n-1]);
        System.out.println("Paso 10:");
        for(i=n-2; i>=0; i--){
            sum = new Fraccion(0);
            for(k=i+1; k<n; k++){
                sum = sum.mas( low[k][i].por(X[k]) );
        System.out.println("   10: L["+i+","+k+"]="+low[i][k]+"*Y["+k+"]="+Y[k]+"\tsum="+sum);
            }
        System.out.println("   ->10: i="+i+"\tsum="+sum);
            X[i] = Y[i].menos(sum).entre(low[i][i]);
        System.out.println("  X["+i+"]="+X[i]);
        }
        
        System.out.println(" Vector X sin reducir");
        for(i=0; i<n; i++){
            System.out.println(X[i]);
            X[i].reducir();
        }
        
        return X;
    }
    
    private Image crearImagenDeTexto(String texto){
        JLabel label = new JLabel(texto);
        org.scilab.forge.jlatexmath.TeXFormula texFormula = new org.scilab.forge.jlatexmath.TeXFormula(texto);
        Color color = new Color(102,153,255);
//        label.setFont(new java.awt.Font("Consolas", java.awt.Font.BOLD, 15));
//        java.awt.Dimension dim = label.getPreferredSize();
//        System.out.println("Dim: "+dim);
//        System.out.println("Size: "+label.getSize());
//        BufferedImage img = new BufferedImage (dim.width, (int) (dim.height*1.4), BufferedImage.TYPE_4BYTE_ABGR);
//        java.awt.Graphics2D g2d = img.createGraphics();
//        g2d.setColor(Color.black);
//        g2d.setFont(new java.awt.Font("Consolas", java.awt.Font.PLAIN, 15));
//        g2d.drawString(texto, 1, dim.height);
//        JOptionPane.showMessageDialog(null, "hola", "imagen", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(img));
        return org.scilab.forge.jlatexmath.TeXFormula.createBufferedImage(texto, TeXConstants.STYLE_DISPLAY, 15, color, Color.white);
    }
    
    private Image crearImagenPaso(int i, int piv, double factor, int size){
        ImagenMathText imlatex = new ImagenMathText(size);
        imlatex.add("E");           imlatex.addSubindice(""+(i+1));
        imlatex.add("-"+factor+"E");     imlatex.addSubindice(""+(piv+1));
        imlatex.add("->E");         imlatex.addSubindice(""+(i+1));
        return imlatex.getImage();
    }
    private void crearImagenTermino( ImagenMathText imglatex, double var, int subindice){
        if( var<0 )
            imglatex.add( "("+var+")x" );
        else
            imglatex.add( ""+var+"x" );
        imglatex.addSubindice( ""+subindice );
    }
    private boolean esDefinidaPositiva(){
        return true;
    }
    private boolean esSimetrica(){
        for(int i=0, j; i<n; i++){
            for(j=0; j<=i; j++){
                if( matriz[i][j]!=matriz[j][i] )
                    return false;
            }
        }
        return true;
    }

    public ArrayList getPasos() {
        return imgPasos;
    }
}
