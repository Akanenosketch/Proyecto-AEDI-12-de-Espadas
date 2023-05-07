package es.uvigo.esei.aed1.core;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Representa un jugador, identificado por su nombre y su mano de cartas.
 *
 */
public class Jugador {

    private String nombre;
    private List<Carta> manoDeCartas;
    private int puntos;

    /**
     * Crea un jugador sin cartas y con 0 puntos.
     *
     * @param nombre el nombre del jugador.
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.manoDeCartas = new LinkedList<>();// crea una mano vacía
        this.puntos = 0;
    }
    
    /**
     * Devuelve el nombre del jugador.
     *
     * @return el nombre, como String.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Devuelve los puntos del jugador.
     * 
     * @return Los puntos, como entero.
     */
    public int getPuntos(){
        return this.puntos;
    }
    
    /**
     * Incrementa los puntos del jugador.
     * 
     * @param puntos los puntos a añadir.
     */
    public void addPuntos(int puntos){
        this.puntos += puntos;
    }
    
    /**
     * Añade una carta a la mano del jugador.
     *
     * @param carta la carta a añadir.
     */
    public void insertarCartaALaMano(Carta carta) {
        this.manoDeCartas.add(carta);
    }
    
    /**
     * Quita una carta de la mano.
     *
     * @param pos La posicion de la carta a quitar en la mano.
     * @return La carta cojida.
     */
    public Carta cojerCarta(int pos) {
        return this.manoDeCartas.remove(pos);
    }
    
    /**
     * Quita las cartas que queden en la mano del jugador.
     *
     * @return las cartas restantes de la mano del jugador en forma de Stack.
     */
    public Stack quitarCartasManoDeCartas() {
        Stack<Carta> cartasMano = new Stack<>();
        while (!this.noTieneCartas()) {
            cartasMano.push(this.cojerCarta(0));
        }
        return cartasMano;
    }
    
    /**
     * Comprueba si el jugador no tiene mas cartas.
     *
     * @return true si el jugador no tiene cartas.
     */
    public boolean noTieneCartas() {
        return this.manoDeCartas.isEmpty();
    }

    /**
     * Cuenta el numero de cartas del jugador.
     *
     * @return El numero de cartas de la mano.
     */
    public int getNumCartas() {
        return this.manoDeCartas.size();
    }

    /**
     * Comprueba si el jugador tiene cartas validas, esto es, si alguna es
     * colocable en la mesa.
     *
     * @param mesa la mesa de juego donde se comprueba la validez de las cartas.
     * @return true si puede colocar alguna carta.
     */
    public boolean tieneCartasValidas(Mesa mesa) {
        boolean cartaValida = this.tieneCincos();
        Iterator<Carta> it = this.manoDeCartas.iterator();
        while (!cartaValida && it.hasNext()) {
            cartaValida = mesa.cartaValida(it.next());
        }
        return cartaValida;
    }
    
    /**
     * Comprueba si existe un cinco de cualquier palo en la mano del jugador.
     *
     * @return Un booleano que indica si existe algun 5.
     */
    public boolean tieneCincos() {
        boolean encontrado = false;
        Iterator<Carta> ite = this.manoDeCartas.iterator();
        while (ite.hasNext() && !encontrado) {
            if (ite.next().getNumero() == 5) {
                encontrado = true;
            }
        }
        return encontrado;
    }
    
    @Override
    /**
     * Devuelve el nombre del jugador, sus puntos y las cartas de su mano, como string.
     *
     * @return los datos del jugador como String.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Jugador :  ").append(this.getNombre()).append("\t ");
        sb.append("Puntos: ").append(this.getPuntos()).append("\n");
        for (Carta i : this.manoDeCartas) {
            sb.append(i.toString()).append("\t");
        }
        return sb.toString();
    }

    /**
     * Muestra las cartas del jugador para escojer una para colocar.
     *
     * @return las cartas activas.
     */
    public String cartasActivas() {
        StringBuilder sb = new StringBuilder();
        int size = manoDeCartas.size();
        for (int i = 0; i < size; i++) {
            sb.append(i + 1).append(") ");
            sb.append(manoDeCartas.get(i).toString());
            sb.append("   ");
        }
        sb.append("\n");
        return sb.toString();
    }
}
