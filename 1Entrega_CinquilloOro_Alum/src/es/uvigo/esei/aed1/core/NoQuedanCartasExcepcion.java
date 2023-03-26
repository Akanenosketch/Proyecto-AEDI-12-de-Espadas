package es.uvigo.esei.aed1.core;

/**
 * Una excepcion no controlada para gestionar cuando no quedan cartas.
 * @author Daniel Fabian Rodriguez Lorenzo
 */
public class NoQuedanCartasExcepcion extends RuntimeException {

    public NoQuedanCartasExcepcion() {
        super();
    }

    public NoQuedanCartasExcepcion(String msg) {
        super(msg);
    }
}
