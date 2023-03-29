/*
 * Representa a un jugador, identificado por el nombre y sus cartas de la mano
 * Estructura mano: se utilizará un TAD adecuado
 * Funcionalidad: Añadir carta a la mano, convertir a String el objeto Jugador (toString)
 *
 *@author Tatiana María Quintas Rodríguez
 */
package es.uvigo.esei.aed1.core;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Jugador {

    private String nombre;

    private List<Carta> manoDeCartas;

    /*
    *Método constructor para la clase jugador, crea cada jugador para que todos 
    *no tengan cartas.
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.manoDeCartas = new LinkedList<>();// crea una mano vacía
    }

    public void insertarCartaALaMano(Carta carta) {
        manoDeCartas.add(carta);
    }

    @Override
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
