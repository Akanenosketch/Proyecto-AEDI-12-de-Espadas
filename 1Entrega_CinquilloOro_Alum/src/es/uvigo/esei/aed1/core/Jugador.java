/*
 * Representa a un jugador, identificado por el nombre y sus cartas de la mano
 * Estructura mano: se utilizará un TAD adecuado
 * Funcionalidad: Añadir carta a la mano, convertir a String el objeto Jugador (toString)
 *
 */
package es.uvigo.esei.aed1.core;

import java.util.LinkedList;
import java.util.List;

/**
 * Representa un jugador, identificado por su nombre y su mano de cartas
 * @author Tatiana María Quintas Rodríguez
 */
public class Jugador {

    private String nombre;

    private List<Carta> manoDeCartas;

    /**
     * Crea un jugador sin cartas
     * @param nombre el nombre del jugador
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.manoDeCartas = new LinkedList<>();// crea una mano vacía
    }

    /**
     * Añade una carta a la mano del jugador
     * @param carta la carta a añadir
     */
    public void insertarCartaALaMano(Carta carta) {
        this.manoDeCartas.add(carta);
    }

    
    @Override
    /**
     * Devuelve el nombre del jugador y las cartas de su mano, como string
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Jugador ").append(" : ");
        sb.append(this.nombre).append("\n");
        for (Carta i : manoDeCartas) {
            sb.append(i).append("\n");
        }
        return sb.toString();
    }
}
