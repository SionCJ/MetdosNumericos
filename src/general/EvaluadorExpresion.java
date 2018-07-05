package general;

import java.util.Queue;
import java.util.Stack;

public class EvaluadorExpresion {
    private String expresion;
    private Stack operadores, operandos;
    private Queue expPosfija;
    
    public EvaluadorExpresion(String expresion){
        this.expresion = expresion;
    }
    
    public void aPostfijo() throws ExcepcionDeExpresion{
        char car;
        String token="";
        for(int i=0; i<expresion.length(); i++){
            car = expresion.charAt(i);
            switch( car ){
                case 's':   case 'c':
                case 't':   case 'e':
                case 'p':
                    token += car + expresion.charAt(++i) + expresion.charAt(++i);
                    switch( token ){
                        case "sin": case "cos": case "tan":
                        case "cot": case "sec": case "csc":
                        case "exp": case "pow":
                                operadores.push(token);
                            break;
                        default: throw new ExcepcionDeExpresion();
                            
                    }
                    break;
                case 'l':
                    token += car + expresion.charAt(++i);
                    if( token.equals("ln") )
                        operadores.push(token);
                    else
                        throw new ExcepcionDeExpresion();
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                case '^':
                case '!':
                case '(':
                case ')':
                    operadores.push(""+car);
                    break;
                default:
                    while( car>47 && car<58 ){
                        token += car;
                        car = expresion.charAt(++i);
                    }
                    if( token.isEmpty() )
                        throw new ExcepcionDeExpresion();
                    else
                        expPosfija.add(token);
            }
        }
    }
    
    private void apilarOperador(String op){
        
    }
}
