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
    }

    /**
     * Añade una carta a la mano del jugador
     *
     * @param carta la carta a añadir
     */
    public void insertarCartaALaMano(Carta carta) {
        this.manoDeCartas.add(carta);
    }

    public void borrarCarta(Carta carta) {
        this.manoDeCartas.remove(carta);
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

    public String cartasActivas(Jugador jugador) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jugador.getManoDeCartas().size() - 1; i++) {
            sb.append(i + 1).append(".-");
            sb.append(jugador.getManoDeCartas().get(i).toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
