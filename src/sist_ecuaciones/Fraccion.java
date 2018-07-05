
package sist_ecuaciones;

public class Fraccion {
    private long num, den;
    
    public Fraccion(long numerador, long denominador){
        num = numerador;    den = denominador;
    }
    
    public Fraccion(long numerador){
        num = numerador;    den = 1;
    }
    
    public Fraccion(double valor){
        long f_num, f_den;
        int index, exp, lenStrFrac, num_size, signo;
        String strFracc, strEntero, strDecimal;

        f_den = 1;
        strFracc = String.valueOf(valor);
        System.out.print(" --- strFracc = "+strFracc);
        index = strFracc.indexOf(".");
        if( index==-1 ){
            num = Long.parseLong(strFracc);
            den = 1;
        }
        else{
            strEntero = strFracc.substring(0,index);
            strDecimal = strFracc.substring(index+1);
            strFracc = strEntero+strDecimal;
            lenStrFrac = strFracc.length();
//            if( lenStrFrac>9 ){
//                num_size = 9;
//            }else
//                num_size = lenStrFrac;
            exp = lenStrFrac-index;
            for(int i=0; i<exp; i++)
                f_den *= 10;
            System.out.print("\tstrFracc="+strFracc+"\tden="+f_den);
        System.out.print("\t Parseando... ");
            f_num = Long.parseLong(strFracc);
        System.out.println("\t Convertido = "+strFracc);
        num = f_num;
        den = f_den;
        Fraccion auxF = new Fraccion(num, den);
        auxF.reducir();
        num = auxF.num;
        den = auxF.den;
        }
    }
    
    public Fraccion mas(Fraccion f){
        long n, d;
        n = num*f.den + den*f.num;
        d = den*f.den;
        //cout << f <<endl;
        return new Fraccion(n,d);
    }
    
    public Fraccion menos(Fraccion f){
        long n, d;
        n = num*f.den - den*f.num;
        d = den*f.den;
        //cout << f <<endl;
        return new Fraccion(n,d);
    }
    
    public Fraccion por(Fraccion f){
        return new Fraccion(num*f.num, den*f.den);
    }
    
    public Fraccion entre(Fraccion f){
        long newNum = num*f.den;
        long newDen = den*f.num;
        if( newDen<0 ){
            newNum *= -1;
            newDen *= -1;
        }
        return new Fraccion(newNum, newDen);
    }
    
    public void igual(Fraccion f){
        num = f.num;
        den = f.den;
    }
    
    public boolean esIgual(Fraccion f){
        Fraccion temp = this.menos(f);
        return temp.num==0;
    }
    
    public void reducir(){
        if( num==0 ){
            den = 1;
            return;
        }
        int i, signo;
        long factor, entero, auxnum, raizNum, v, nuevoNum, nuevoDen;
        if( num<0 ){
            num *= -1;
            signo = -1;
        }
        else
            signo = 1;
        entero = num/den;
        auxnum = num - den*entero;
        if( auxnum==0 ){
            //prlongf(" Ent = %d \n", entero);
            nuevoNum = entero*signo;
            nuevoDen = 1;
        }
        else{
        //prlongf(" Mixta => %d %d/%d\n", entero, auxnum,den);
            raizNum = (long)Math.sqrt(auxnum);
        //prlongf("Raiz %d \n", raizNum);
            factor = 1;
            for(i=1, v=0; i<=raizNum; i++){
                if( auxnum%i==0 ){
                    v++;
            //prlongf("%d x %d \tdiv=%d", auxnum/i, i, den/(auxnum/i));
                    if( den%(auxnum/i)==0 ){
                        factor = auxnum/i;
                    //prlongf("\t\tfact1= %d", factor);
                        break;
                    }else if( den%i==0 ){
                        factor = i;
                    //prlongf("\t\tfact2= %d", factor);
                    }
                    //prlongf("\tfact= %d\n", factor);
                }
            }
            //prlongf("\n\nfactor =  %d\n", factor);
            //prlongf("%d iteraciones\t\t%d verificaciones\n", i, v);
            nuevoNum = num/factor*signo;
            nuevoDen = den/factor;
        }
        num = nuevoNum;
        den = nuevoDen;
    }
    
    public double getValor(){
        return ((double)num)/den;
    }
    
    @Override
    public String toString(){
        if( den==1 )
            return ""+num;
        else
            return num+"/"+den;
    }
    
    
//    private int redondear(string numero, int pos){
//        int redondeo;
//        if( numero.length()>10 ){
//            numero[pos+1] = '\0';
//        }
//        if( atoi(&numero[pos])>4 )
//            redondeo = 1;
//        else
//            redondeo = 0;
//
//        return redondeo;
//    }
}
