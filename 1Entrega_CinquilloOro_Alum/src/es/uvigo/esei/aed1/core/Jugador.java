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

    /**
     * Devuelve el nombre del jugador
     * 
     * @return el nombre, como String
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
     * Busca si existe un cinco de cualquier palo en la mano del jugador
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
}
