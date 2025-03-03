package es.uvigo.esei.aed1.iu;

/**
 * Clase completamente auxiliar para meter cosas decorativas.
 *
 */
public class Decorador {

    private static final String RESET = "\033[0m";  //Resetea el cambio de color, NO SE USA PUBLICO

    public static final String ROJO = "\033[0;31m";    //Rojo
    public static final String VIOLETA = "\033[0;35m"; //Violeta

    public static final String COPAS = "\033[1;31m";   //rojo anaranjado, tecnicamente rojo bold
    public static final String BASTOS = "\033[0;32m";  //Verde
    public static final String ORO = "\033[0;33m";     //Amarillo
    public static final String ESPADAS = "\033[0;34m"; //Azul

    /**
     * Flag para activar las Decoraciones
     */
    private static final boolean ACTIVAR_DECORAROR = true;

    /**
     * Pone color al mensaje. No funciona si el mensaje tiene un \n. Si el
     * decorador esta deshabilitado devuelve el mensaje como esta.
     *
     * @param mensaje el mensaje a colorizar.
     * @param color el color a usar, USAR LOS STATIC DE LA CLASE.
     * @return el mensaje colorizado.
     */
    public static String colorizar(String mensaje, String color) {

        if (!ACTIVAR_DECORAROR) {
            return mensaje;
        }
        if (!color.equals(ORO) && !color.equals(BASTOS)
                && !color.equals(ROJO) && !color.equals(ESPADAS)
                && !color.equals(COPAS) && !color.equals(VIOLETA)) {
            //Si color no es uno valido
            return mensaje;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(color).append(mensaje).append(RESET);
        return sb.toString();
    }

    /**
     * Pone color a la carta. Si el decorador esta deshabilitado devuelve el
     * mensaje como esta.
     *
     * @param mensaje la carta como String.
     * @param numPalo el palo a colorizar.
     * @return La carta con colores.
     */
    public static String colorizar(String mensaje, int numPalo) {
        String toRet;
        if (!ACTIVAR_DECORAROR) {
            return mensaje;
        }
        switch (numPalo) {
            case 0:
                toRet = colorizar(mensaje, ORO);
                break;
            case 1:
                toRet = colorizar(mensaje, ESPADAS);
                break;
            case 2:
                toRet = colorizar(mensaje, COPAS);
                break;
            case 3:
                toRet = colorizar(mensaje, BASTOS);
                break;
            default:
                toRet = mensaje;
        }
        return toRet;
    }

    /**
     * Añade un retardo de 1s. Si el decorador esta deshabilitado no hace nada.
     *
     */
    public static void delay() {
        if (ACTIVAR_DECORAROR) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                // Codigo para que tarde 1s entre lineas
                //Simplemente para que no ponga 10 lineas en 1s
            }

        }
    }
}
