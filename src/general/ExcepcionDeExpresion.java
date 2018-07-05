/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

/**
 *
 * @author Sion
 */
public class ExcepcionDeExpresion extends Exception {

    /**
     * Creates a new instance of <code>ExcepcionDeExpresion</code> without
     * detail message.
     */
    public ExcepcionDeExpresion() {
    }

    /**
     * Constructs an instance of <code>ExcepcionDeExpresion</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcepcionDeExpresion(String msg) {
        super(msg);
    }
}
