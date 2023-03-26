/*
* Representa la baraja española pero con 8 y 9, en total 48 cartas, 4 palos, valores de las cartas de 1 a 12. 
* Estructura: se utilizará un TAD adecuado
* Funcionalidad: barajar las cartas, devolver la carta situada encima del montón de cartas
 */
package es.uvigo.esei.aed1.core;
import pila.*;


/**
 * Representa una Baraja española de 48 cartas con 4 palos y valores de 1 a 12 
 * @author Daniel Fabián Rodriguez Lorenzo && Adrian Rey Perez
 */
public class Baraja {
    private Pila<Carta> cartas; 
    
    /**
     * Crea una nueva Baraja 
     */
    public Baraja(){
        cartas = new EnlazadaPila<>();
        Carta.Palos palos[] = Carta.Palos.values();
        for (int i = 1; i <= 12; i++) {
            for (int j = 0; j < 4; j++) {
                cartas.push(new Carta(i , palos[j]));
            }
        }
    }
    /**
     * 
     * @return Una carta de la baraja 
     */
    public Carta sacarCarta(){
        if(cartas.tamaño() == 0){ 
            throw new NoQuedanCartasExcepcion("No puedes cojer "
                    + "cartas de una baraja vacia");
        }
        return cartas.pop();
    }
    
    public void barajar(){
    //TODO
    
    }
    
   
}
