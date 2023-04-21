package es.uvigo.esei.aed1.iu;

import es.uvigo.esei.aed1.core.Jugador;
import es.uvigo.esei.aed1.core.Mesa;
import java.util.List;
import java.util.LinkedList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Representacion de la interfaz de usuario del juego Cinquillo-Oro
 * 
 */
public class IU {

    private final Scanner teclado;
   
    public IU() {
        teclado = new Scanner(System.in).useDelimiter("\r?\n");
    }

    /**
     * Lee un numero del teclado
     *
     * @param msg El mensaje a visualizar
     * @return El numero, como entero
     */
    public int leeNum(String msg) {
        do {
            System.out.print(msg);
            try {
                return teclado.nextInt();
            } catch (InputMismatchException exc) {
                teclado.next();
                System.out.println("Entrada no valida. Debe ser un entero.");
            }
        } while (true);
    }

    /**
     * Lee un string del teclado
     *
     * @param msg El mensaje a visualizar
     * @return El string
     */
    public String leeString(String msg) {
        System.out.print(msg);
        return teclado.next();
    }

    /**
     * Lee un string de teclado
     *
     * @param msg El mensaje a visualizar
     * @param permiteVacio Si el string leido puede estar vacia
     * @return El string
     */
    public String leeString(String msg, boolean permiteVacio) {
        String toRet = " ";
        do {
            if (toRet.isEmpty()) {
                System.out.println("La cadena no puede estar vacia");
            }
            toRet = leeString(msg).trim();
        } while (!permiteVacio && toRet.isEmpty());
        return toRet;
    }

    /**
     * Lee un string del teclado
     *
     * @param msg El mensaje a visualizar, con formato
     * @param args Los datos a incluir en el mensaje 
     * @return el string 
     */
    public String leeString(String msg, Object... args) {
        System.out.printf(msg, args);
        return teclado.next();
    }

    /**
     * Muesta un string por pantalla
     *
     * @param msg El mensaje a mostrar
     */
    public void mostrarMensaje(String msg) {
        System.out.println(msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            // Codigo para que tarde 1s entre lineas
            //Simplemente para que no ponga 10 lineas en 1s
        }
    }

    /**
     * Muestra un string con formato por pantalla
     *
     * @param msg El mensaje a visualizar, con formato
     * @param args Los datos a incluir en el mensaje
     */
    public void mostrarMensaje(String msg, Object... args) {
        System.out.printf(msg, args);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            // Codigo para que tarde 1s entre lineas
            //Simplemente para que no ponga 10 lineas en 1s
        }
    }

    /**
     * Pide por pantalla el numero de jugadores y sus datos
     *
     * @return Una Lista de jugadores
     */
    public List<Jugador> pedirDatosJugadores() {
        List<Jugador> jugadores = new LinkedList<>();
        int numJugadores;
        String nombre;
        do {
            numJugadores = leeNum("Introduzca el numero "
                    + "de jugadores(3 o 4): ");
        } while (numJugadores < 3 || numJugadores > 4);

        for (int i = 0; i < numJugadores; i++) {
            nombre = leeString("Introduzca el nombre del jugador " + (i + 1)+": ", false);
            Jugador nuevo = new Jugador(nombre);
            jugadores.add(nuevo);
        }
        return jugadores;
    }

    /**
     * Muestra un jugador por pantalla
     *
     * @param jugador El jugador a mostrar
     */
    public void mostrarJugador(Jugador jugador) {
        mostrarMensaje(jugador.toString()+"\n");
    }

    /**
     * Muestra una lista de jugadores por pantalla
     *
     * @param listaJugadores Los jugadores a mostrar
     */
    public void mostrarJugadores(List<Jugador> listaJugadores) {
        for (Jugador jugador : listaJugadores) {
            mostrarJugador(jugador);
        }
    }
    
    /**
     * Genera un entero entre 0 (incluido) y el limite proporcionado (excluido)
     * 
     * @param limite el limite del numero a generar
     * @return El numero generado
     * @throws IllegalArgumentException si el limite no es superior a 0
     */
    public static int numeroRandom(int limite) {
        Random rng = new Random(System.currentTimeMillis());
        return rng.nextInt(limite);
    }
    
    /**
     * Muestra una mesa por pantalla
     *
     * @param mesa La mesa a mostrar
     */
    public void mostrarMesa(Mesa mesa) {
        mostrarMensaje("Estado de la mesa:\n"+mesa.toString());
    }
    
}
