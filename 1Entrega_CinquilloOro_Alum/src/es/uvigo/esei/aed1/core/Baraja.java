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
    
    public void barajar(){
     Stack<Carta> aux = new Stack<>();
        Stack<Carta> resultado = new Stack<>();
        int chancla = 47;
        Random rnd = new Random(System.currentTimeMillis());
        boolean Hay = true;
        try {
            while (Hay) {
                int n = rnd.nextInt(chancla);
                for (int i = 0; i < n; i++) {
                    Carta auxi = cartas.pop();
                    aux.push(auxi);

                }
                resultado.push(cartas.pop());
                for (int j = 0; j < n; j++) {
                    Carta auxi = aux.pop();
                    cartas.push(auxi);

                }
                chancla--;
            }
        } catch (NoQuedanCartasExcepcion exc) {
            Hay = false;
            cartas = resultado;
        }

    }
    public void repartircartas(Collection<Jugador> jugadores) {
        boolean hay = true;

        while (hay) {
            try {
                for (Jugador jugadore : jugadores) {
                    jugadore.insertarCartaALaMano(cartas.pop());
                }
            } catch (NoQuedanCartasExcepcion exc) {
                hay = false;
            }
        }

    }
    }
    
   

