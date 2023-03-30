/**
 * Representa la interfaz del juego del Cinquillo-Oro, en este proyecto va a ser una entrada/salida en modo texto
 * Se recomienda una implementación modular.
 */
package es.uvigo.esei.aed1.iu;

import es.uvigo.esei.aed1.core.Jugador;
import java.util.Collection;
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
    public Collection<Jugador> pedirDatosJugadores() {
        Collection<Jugador> jugadores = new LinkedList<>();
        int numJugadores;
        String nombre;
        do {
            numJugadores = Integer.parseInt(leeString("Introduce el numero"
                    + " de jugadores a introducir (3 o 4)"));
        } while (numJugadores < 3 || numJugadores > 4);

        for (int i = 0; i < numJugadores; i++) {
            nombre = leeString("Introduce el nombre del jugador " + (i + 1));
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
        //EL toString de jugador ya esta implementado creo
    }
    /**
     * Muestra una coleccion de jugadores por pantalla
     * @param jugadores 
     */
    public void mostrarJugadores(Collection<Jugador> jugadores) {
        //Recomiendo hacer un bucle y usar la de arriba
    }

}
