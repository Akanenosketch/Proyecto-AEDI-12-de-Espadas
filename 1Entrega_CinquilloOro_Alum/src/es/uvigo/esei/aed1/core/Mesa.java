/*
* Representa la Mesa de juego. 
* Estructura: se utilizar� un TAD adecuado. Piensa que hay 4 palos y de cada palo se pueden colocar cartas 
* por cualquiera de los dos extremos (un array con 4 doblescolas parece lo m�s adecuado). La DobleCola se coment� en clase de teor�a
* Funcionalidad: saber si es posible colocar una carta en la mesa, colocar una carta en la mesa, mostrar la mesa
 */
package es.uvigo.esei.aed1.core;

import java.util.LinkedList;
import java.util.Deque;

public class Mesa {

    private Deque<Carta>[] palos;

    /*TOdo esto venia de base menos este gran comentario 
    Funciones a implementar segun el enunciado:
    Funcion que diga si es posible colocar una carta (natalia & tatiana)
    por ejemplo public boolean cartaValida(Carta carta)
    
    Para lo del array de doblecolas casi seguro hace falta usar .ordinal en el enum del palo
    preguntadme por el .ordinal y os lo explico
     */
 
    /**
     * Crea la Mesa vacia
     * 
     */
    public Mesa() {
        final int SIZE = Carta.Palos.values().length;
        palos = new Deque[SIZE];
        for (int i = 0; i < SIZE; i++) {
            palos[i] = new LinkedList();
        }
    }

    /**
     * Inserta una carta en la mesa
     * 
     * @param carta La carta a colocar
     */
    public void insertar( Carta carta) {
        int PALO = carta.getPalo().ordinal();
        if (carta.getNumero()<5) {
            palos[PALO].addFirst(carta);
        }
        else {
            palos[PALO].addLast(carta);
        }
    }

    /**
     * Devuelve el estado de la mesa, como String
     * 
     * @return La mesa comoString
     */
    public String toString() {
        Carta.Palos[] palo = Carta.Palos.values();
        final int SIZE = palo.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            sb.append("Palo de ").append(palo[i].name()).append(":\t");
            for (Carta carta : palos[i]) {
                sb.append(carta.getNumero()).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
