/*
 * Representa a un jugador, identificado por el nombre y sus cartas de la mano
 * Estructura mano: se utilizará un TAD adecuado
 * Funcionalidad: Añadir carta a la mano, convertir a String el objeto Jugador (toString)
 */
package es.uvigo.esei.aed1.core;

import lista.*;

public class Jugador {

    private String nombre;
    private int numJugador;
    private Lista<Carta> manoDeCartas;

    /*
    *Método constructor para la clase jugador, crea cada jugador para que todos 
    *no tengan cartas.
     */
    public Jugador(String nombre, int numJugador) {
        this.nombre = nombre;
        this.numJugador = numJugador;
        this.manoDeCartas = new ListaEnlazada<>();// crea una mano vací
    }

    public void insertarCartaALaMano(Carta carta) {
        manoDeCartas.insertarFinal(carta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Jugador ").append(this.numJugador).append(" : ");
        sb.append(this.nombre).append("\n");
        for (Carta i : manoDeCartas) {
            sb.append(i).append("\n");
        }
        return sb.toString();
    }
}
