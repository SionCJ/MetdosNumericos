
package general;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class PruebaNumerica {

    public static void main(String[] args) {
        PruebaNumerica obj = new PruebaNumerica();
        Scanner cin = new Scanner(System.in);
        String str, strFinal, strEnt;
        double num;
        int seguir = 1;
        
        int index, f_num, f_den, exp, lenStrFrac, num_size, signo;
        String strFracc, strEntero, strDecimal;
        
        while( seguir!=0 ){
            System.out.print("Numero:\t");
            num = cin.nextDouble();
            
            f_den = 1;
        strFracc = String.valueOf(num);
        System.out.println(" --- strFracc = "+strFracc);
            index = strFracc.indexOf(".");
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
            f_num = Integer.parseInt(strFracc);
            System.out.println("num="+f_num+"\tden="+f_den);
            sist_ecuaciones.Fraccion f = new sist_ecuaciones.Fraccion(f_num, f_den);
            f.reducir();
            System.out.println(""+f);
            
            System.out.println("Seguir ? 1=Si 0=No");
            seguir = cin.nextInt();
        }
    }
    private String formatear(double num, double intervalo){
        String strnum;
        
        if( intervalo>10 ){
            if( num>Long.MAX_VALUE || num<Long.MIN_VALUE ){
                System.out.println("Redondeando con BigDecimal");
                String strDouble = String.valueOf(num);
                System.out.println("strDouble = "+strDouble);
                BigDecimal bdNum = new BigDecimal(strDouble);
                System.out.println("BigDecimal = "+bdNum);
                BigDecimal bdNumRound = bdNum.round(MathContext.UNLIMITED);
                System.out.println("BigDecimal redondeado: "+bdNumRound);
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
