package es.uvigo.esei.aed1.core;

import java.util.Stack;
import es.uvigo.esei.aed1.iu.IU;
 
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
    public Baraja(){
        this.cartas = new Stack<>();
        Carta.Palos palos[] = Carta.Palos.values();
        for (int i = 1; i <= 12; i++) {
            for (Carta.Palos palo : palos) {
                this.cartas.push(new Carta(i, palo));
            }
        }
    }

    /**
     * Saca una carta de la baraja
     * 
     * @return una Carta de la Baraja, como Carta
     */
    public Carta sacarCarta(){
        return this.cartas.pop();
    }
  
    /**
     * Comprueba si la baraja no tiene cartas
     * 
     * @return un booleano segun este vacia 
     */
    public boolean isEmpty(){
        return this.cartas.empty();
    }
    
    /**
     * Baraja la baraja
     * 
     */
    public void barajar(){
        Stack<Carta> aux = new Stack<>();
        Stack<Carta> resultado = new Stack<>();
        int numCartas = cartas.size();//Numero maximo de cartas
        int numCartasAQuitar;
        while (!this.isEmpty()) {
            numCartasAQuitar = IU.numeroRandom(numCartas);
            //Quitamos un num aleatorio de cartas entre 0 y el maximo -1
            for (int i = 0; i < numCartasAQuitar; i++) {
                aux.push(this.sacarCarta());
            }                
    
            //Ponemos la siguiente carta en una baraja barajada
            resultado.push(this.sacarCarta());  
            
            //Devolvemos las cartas quitadas a aux al original
            while (!aux.empty()) {
                this.cartas.push(aux.pop());
            }
            //Decrementamos el numero de cartas maximo que podemos quitar 
            numCartas--;        
        }
        this.cartas = resultado;    
    }
}