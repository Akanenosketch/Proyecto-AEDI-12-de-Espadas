/**
 * Representa la interfaz del juego del Cinquillo-Oro, en este proyecto va a ser una entrada/salida en modo texto
 * Se recomienda una implementación modular.
 */
package es.uvigo.esei.aed1.iu;

import es.uvigo.esei.aed1.core.Jugador;
import java.util.List;
import java.util.LinkedList;
import java.util.InputMismatchException;
import java.util.Scanner;




public class IU {

    private final Scanner teclado;

    public IU() {
        teclado = new Scanner(System.in).useDelimiter("\r?\n");
    }

    /**
     * Lee un num. de teclado
     *
     * @param msg El mensaje a visualizar.
     * @return El num., como entero
     */
    public int leeNum(String msg) {
        do {
            System.out.print(msg);
            try {
                return teclado.nextInt();
            } catch (InputMismatchException exc) {
                teclado.next();
                System.out.println("Entrada no válida. Debe ser un entero.");
            }
        } while (true);
    }
    
    /**
     * Lee un string. de teclado
     *
     * @param msg El mensaje a visualizar.
     * @return El string
     */
    public String leeString(String msg) {
        System.out.print(msg);
        return teclado.next();
    }
    
    /**
     * Lee un string. de teclado
     *
     * @param msg El mensaje a visualizar.
     * @param permiteVacio Si la string leida puede estar vacia
     * @return El string
     */
    public String leeString(String msg, boolean permiteVacio) {
        String toRet = " ";
        do {
            if(toRet.isEmpty()){
                System.out.println("La cadena no puede estar vacia");
            }
            toRet = leeString(msg).trim();
        } while (!permiteVacio && toRet.isEmpty());
        return toRet;
    }
    
    /**
     * Lee un string. de teclado
     * @param msg El mensaje a visualizar con formato
     * @param args Los datos a incluir en el mensaje con formato
     * @return 
     */
    public String leeString(String msg, Object... args) {
        System.out.printf(msg, args);
        return teclado.next();
    }
    
    /**
     * Muesta un string por pantalla
     * @param msg El mensaje a mostrar
     */
    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }
    
    /**
     * Muestra un string con formato por pantalla
     * @param msg El mensaje a visualizar con formato
     * @param args Los datos a incluir en el mensaje con formato
     */
    public void mostrarMensaje(String msg, Object... args) {
        System.out.printf(msg, args);
    }
    
    /**
     * Pide por pantalla el numero de jugadores y sus datos
     * @return Una coleccion de jugadores
     */
    public List<Jugador> pedirDatosJugadores() {
        List<Jugador> jugadores = new LinkedList<>();
        int numJugadores;
        String nombre;
        do {
            numJugadores = leeNum("Introduce el numero "
                    + "de jugadores a introducir (3 o 4)");
        } while (numJugadores < 3 || numJugadores > 4);

        for (int i = 0; i < numJugadores; i++) {
            nombre = leeString("Introduce el nombre del jugador " + (i + 1), false);
            Jugador nuevo = new Jugador(nombre);
            jugadores.add(nuevo);
        }
        return jugadores;
    }
    
    /**
     * Muestra un jugador por pantalla
     * @param jugador El jugador a mostrar
     */
    public void mostrarJugador(Jugador jugador) {
        
       String msg=jugador.toString();
        mostrarMensaje(msg);
        
        //En vez de usar sout usar la funcion de mostrarMensaje?
    }
    
    /**
     * Muestra una coleccion de jugadores por pantalla
     * @param listaJugadores 
     */
    public void mostrarJugadores(List<Jugador> listaJugadores) {
        for (Jugador jugador : listaJugadores ) {
             mostrarJugador(jugador);
        }
        
        //Recomiendo hacer un bucle con StringBuilder y usar la funcion de arriba 
        
    }

}
