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
    private int numCartas;
    private Lista<Carta> manoDeCartas = new ListaEnlazada<>();
    /*
    *Método constructor para la clase jugador, crea cada jugador para que todos 
    *no tengan cartas.
    */
    public Jugador(String nombre,int numJugador, int numCartas){
        this.nombre = nombre;
        this.numJugador = numJugador;
        this.numCartas = 0; 
        this.manoDeCartas = new ListaEnlazada<>();
         // mano vacía
    }
    
    public void insertarCarta(Carta carta){
        manoDeCartas.insertarFinal(carta);
    }
    
    
}
