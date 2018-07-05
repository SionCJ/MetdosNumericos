/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taylor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author synoc
 */
public class Retardo extends Thread{
    int ms;
    public Retardo(int milis, Plano plano){
        ms  = milis;
    }
    
    public void run(){
        try {
            sleep(ms);
        } catch (InterruptedException ex) {
            Logger.getLogger(Retardo.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
