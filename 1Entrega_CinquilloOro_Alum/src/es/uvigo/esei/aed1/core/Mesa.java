/*
* Representa la Mesa de juego. 
* Estructura: se utilizar� un TAD adecuado. Piensa que hay 4 palos y de cada palo se pueden colocar cartas 
* por cualquiera de los dos extremos (un array con 4 doblescolas parece lo m�s adecuado). La DobleCola se coment� en clase de teor�a
* Funcionalidad: saber si es posible colocar una carta en la mesa, colocar una carta en la mesa, mostrar la mesa
 */
package es.uvigo.esei.aed1.core;



import java.util.ArrayDeque;
import java.util.Deque;


public class Mesa {
    
    private Deque<Carta>[]palos;
    
    /*TOdo esto venia de base menos este gran comentario 
    la mesa piden que tenga un array con 4 posiciones de DOBLECOLAS, 
    esto no lo hemos dado nunca, preguntar dudas por el grupo
    Funciones a implementar segun el enunciado:
    Funcion que diga si es posible colocar una carta
    por ejemplo public boolean cartaValida(Carta carta)
    Funcion que coloque una carta en la mesa
    por ejemplo public void colocarCarta(Carta carta)
    Funcion que muestre la mesa, es el toString, lo hace adri rey
    
    Para lo del array de doblecolas casi seguro hace falta usar .ordinal en el enum del palo
    preguntame por el .ordinal y te lo explico
    */
    
    //constructor
    public Mesa(){
       palos = new ArrayDeque [4];
        for (int i = 0; i < palos.length; i++) {
            palos[i]= new ArrayDeque<>();   
        }
    }

    //a�adir m�s funcionalidades
    public void insertar ( Carta carta) {
        
        
            if (carta.getNumero()<5) {
                palos[carta.getPalo().ordinal()].addFirst(carta);
            }
            else {
                palos[carta.getPalo().ordinal()].addLast(carta);
        }
            
        }
    }
        
   
    // mostrar el estado de la mesa
    /* COMENTADO PARA PODER COMPILAR EL RESTO
    public String toString(){
        //Esto lo hace adri rey
    }*/

