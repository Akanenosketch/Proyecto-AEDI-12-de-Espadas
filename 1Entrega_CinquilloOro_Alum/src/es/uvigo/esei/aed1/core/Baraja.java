/*
* Representa la baraja española pero con 8 y 9, en total 48 cartas, 4 palos, valores de las cartas de 1 a 12. 
* Estructura: se utilizará un TAD adecuado
* Funcionalidad: barajar las cartas, devolver la carta situada encima del montón de cartas
 */
package es.uvigo.esei.aed1.core;
import java.util.Collection;
import java.util.Random;
import java.util.Stack;


/**
 * Representa una Baraja española de 48 cartas con 4 palos y valores de 1 a 12 
 * @author Daniel Fabián Rodriguez Lorenzo && Adrian Rey Perez
 */
public class Baraja {
    private Stack<Carta> cartas; 
    
    /**
     * Crea una nueva Baraja con las 48 cartas 
     */
    public Baraja(){
        this.cartas = new Stack<>();
        Carta.Palos palos[] = Carta.Palos.values();
        for (int i = 1; i <= 12; i++) {
            for (int j = 0; j < 4; j++) {
                this.cartas.push(new Carta(i , palos[j]));
            }
        }
    }
    /**
     * Saca una carta de la baraja
     * @return una Carta de la Baraja, como Carta
     * @throws NoQuedanCartasExcepcion si la Baraja esta vacia
     */
    public Carta sacarCarta() throws NoQuedanCartasExcepcion{
        if(this.cartas.empty()){ 
            throw new NoQuedanCartasExcepcion("No puedes cojer "
                    + "cartas de una baraja vacia");
        }
        return this.cartas.pop();
    }
    
    /**
     * Baraja la baraja
     */
    public void barajar(){
        Stack<Carta> aux = new Stack<>();
        Stack<Carta> resultado = new Stack<>();
        int numCartas = 48; //Numero maximo de cartas
        Random rnd = new Random(System.currentTimeMillis());
        boolean quedanCartas = true;
        int numCartasAQuitar;
        while (quedanCartas) {
            try {
                numCartasAQuitar = rnd.nextInt(numCartas);
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
            
            } catch (NoQuedanCartasExcepcion exc) {
                quedanCartas = false;
                this.cartas = resultado;
            }
        }
    }

        

    /**
     * Reparte todas las cartas de la baraja a los jugadores
     * @param jugadores Los jugadores que reciben las cartas
     */
    public void repartircartas(Collection<Jugador> jugadores) {
        boolean quedanCartas = true;

        while (quedanCartas) {
            try {
                for (Jugador jugador : jugadores) {
                    jugador.insertarCartaALaMano(this.sacarCarta());
                }
            } catch (NoQuedanCartasExcepcion exc) {
                quedanCartas = false;
            }
        }
    }
}