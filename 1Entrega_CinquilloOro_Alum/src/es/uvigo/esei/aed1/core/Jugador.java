package es.uvigo.esei.aed1.core;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Representa un jugador, identificado por su nombre y su mano de cartas
 *
 */
public class Jugador {

    private String nombre;
    private List<Carta> manoDeCartas;
    private int puntosJugadores;
       
    public List<Carta> getManoDeCartas() {
        return manoDeCartas;
    }

    /**
     * Crea un jugador sin cartas
     *
     * @param nombre el nombre del jugador
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.manoDeCartas = new LinkedList<>();// crea una mano vacía
        this.puntosJugadores=0;//estructura con puntos vacios
    }

    /**
     * Añade una carta a la mano del jugador
     *
     * @param carta la carta a añadir
     */
    public void insertarCartaALaMano(Carta carta) {
        this.manoDeCartas.add(carta);
    }

    /**
     * Quita una carta de la mano
     *
     * @param pos La posicion de la carta a quitar en la mano
     * @return La carta cojida
     */
    public Carta cojerCarta(int pos) {
        Carta toRet = manoDeCartas.get(pos);
        manoDeCartas.remove(toRet);
        return toRet;

    }

    /**
     * Devuelve el nombre del jugador
     *
     * @return el nombre, como String
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Devuelve los puntos de un jugador
     *
     * @return los puntos , como entero
     */
    public int getPuntosJugadores() {
        return puntosJugadores;
    }

    /**
     * Comprueba si existe un cinco de cualquier palo en la mano del jugador
     *
     * @return Un booleano que indica si existe algun 5
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

    public boolean noTieneCartas() {
        return manoDeCartas.isEmpty();
    }

    @Override
    /**
     * Devuelve el nombre del jugador y las cartas de su mano, como string
     *
     * @return los datos del jugador como String
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Jugador :  ").append(this.nombre).append("\n");
        for (Carta i : this.manoDeCartas) {
            sb.append(i.toString()).append("\t");
        }
        return sb.toString();
    }

    /**
     * Muestra las cartas del jugador
     *
     * @return
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
    
    
    /**
     * Añade puntos al jugador 
     *
     */
    
    public void addPuntos(int x){
        
        this.puntosJugadores += x;
        
      
    }
    
     
   
}
