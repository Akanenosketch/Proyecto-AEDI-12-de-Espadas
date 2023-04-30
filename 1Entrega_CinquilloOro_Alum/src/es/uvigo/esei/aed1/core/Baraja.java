package es.uvigo.esei.aed1.core;

import java.util.Stack;
import es.uvigo.esei.aed1.iu.IU;
import java.util.LinkedList;

/**
 * Representa una Baraja española de 48 cartas con 4 palos y valores de 1 a 12
 *
 */
public class Baraja {

    private Stack<Carta> cartas;

    /**
     * Crea una nueva Baraja con las 48 cartas
     *
     */
    public Baraja() {
        this.cartas = new Stack<>();
        Carta.Palos palos[] = Carta.Palos.values();
        for (Carta.Palos palo : palos) {
            for (int i = 1; i <= 12; i++) {
                this.cartas.push(new Carta(i, palo));
            }
        }
    }

    /**
     * Saca una carta de la baraja
     *
     * @return una Carta de la Baraja, como Carta
     */
    public Carta sacarCarta() {
        return this.cartas.pop();
    }
    
    /**
     * Comprueba si la baraja no tiene cartas
     *
     * @return un booleano segun este vacia
     */
    public boolean isEmpty() {
        return this.cartas.empty();
    }

    /**
     * Baraja la baraja
     *
     */
    public void barajar() {
        //Creamos una lista auxiliar 
        LinkedList<Carta> aux = new LinkedList<>();
        
        //Vaciamos la baraja a la lista auxiliar
        while (!this.isEmpty()) {
            aux.add(this.sacarCarta());
        }
        
        while (!aux.isEmpty()) {
            int numCartasLista = aux.size(); //numero de cartas en la lista auxiliar
            //la carta que se va a cojer, elegida aleatoriamente, limitado por el numero maximo
            int cartaACojer = IU.numeroRandom(numCartasLista);
            this.cartas.push(aux.remove(cartaACojer));        
        }
    }
    
}
