package es.uvigo.esei.aed1.core;

/**
 * Una excepcion no controlada para gestionar cuando no quedan cartas.
 * 
 */
public class NoQuedanCartasExcepcion extends RuntimeException {
    /**
     * Crea una nuena NoQuedanCartasExcepcion 
     * 
     */
    public NoQuedanCartasExcepcion() {
        super();
    }
    /**
     * Crea una nuena NoQuedanCartasExcepcion con un mensaje
     * 
     * @param msg El mensaje de la excepcion
     */
    public NoQuedanCartasExcepcion(String msg) {
        super(msg);
    }
}
