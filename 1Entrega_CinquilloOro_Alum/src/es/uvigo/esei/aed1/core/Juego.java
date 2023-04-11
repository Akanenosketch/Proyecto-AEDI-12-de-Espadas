/**
 * Representa el juego del Cinquillo-Oro, con sus reglas (definidas en el documento Primera entrega). 
 * Se recomienda una implementación modular.
 */

package es.uvigo.esei.aed1.core;

import es.uvigo.esei.aed1.iu.IU;
import java.util.LinkedList;
import java.util.List; 

/**
 * La clase que representa el juego del Cinquillo-Oro
 * 
 */
public class Juego{
    private final IU iu;
    private Baraja baraja;
    private List<Jugador> listaJugadores;
    //Un par de ideas random para tatiana/natalia
    // Una funcion booleana en juego? que mire si puede colocar alguna 
    //carta de la mano en la mesa, usando la de cartaValida de la Mesa en un while de busqueda lineal y usando la de buscarincos de la primera entrega primero
    //Un ifelse aqui el juego (colocadlo donde podais y cuando haga mi parte lo meto) que llame a la funcion
    //una funcion para lo de pedir la carta que use la cartaValida de mesa
    //lo de pasar turno seguramente lo mire yo en mi parte, pq lo vuestro son funciones y un ifelse metido en mi parte
    
    
    public Juego(IU iu){
        this.iu = iu;
        this.baraja = new Baraja();
        this.listaJugadores = new LinkedList();
    }
    /**
     * Inicia el juego
     * 
     */
    public void jugar(){
        listaJugadores = iu.pedirDatosJugadores();
        baraja.barajar();
        repartircartas();
        iu.mostrarJugadores(listaJugadores);
        //Se mueven los jugadores en la lista para que el que inicia este en indice 0
        for (int i = 0; i < elegirJugadorInicial(); i++) {
            listaJugadores.add(listaJugadores.remove(0));
        }
        iu.mostrarMensaje("El jugador que comenzara la partida es: \n");
        iu.mostrarMensaje(listaJugadores.get(0).getNombre());
        //lo anterior solo se harua al principio, salvo barajar y repartir

        
        //Aqui me pongo yo - Fabi
        //Ignorad mis comentarios, estoy haciendo ideas
        
//Los/as jugadores/as van jugando por turnos (colocando cartas en la mesa) hasta
//que la partida termine. La partida termina cuando un/a jugador/a coloca todas sus
//cartas en la mesa. Al terminar la partida, se debe indicar el nombre del jugador que
//ha resultado ganador.
        // while que no pare mientras haya cartas con un fore  que ejecute cosas (reset auto en el fore?)
        //comprobar si un iterador deja hacer ese tipo de modificaciones
        //if para parar el bucle, funcion para ver si quedan?
        //Hace falta funcion para que un jugador saque carta,
    }
    
    /**
    * Reparte todas las cartas de la baraja a los jugadores
    *  
    */
    public void repartircartas() {
        while (!baraja.isEmpty()) {
            for (Jugador jugador : listaJugadores) {
                jugador.insertarCartaALaMano(baraja.sacarCarta());
            }
        }
    }
        
    /**
     * Devuelve la posicion del jugador aleaatorio que comenzara la partida
     * 
     * @return La posicion del jugador a comenzar
     */
    public int elegirJugadorInicial() {
        final int size = listaJugadores.size();
        int posicion = IU.numeroRandom(size);
        while (!listaJugadores.get(posicion).tieneCincos()) {
            posicion++;
            if (posicion >= size) {
                posicion = 0;
            }
        }
        return posicion;
    }
}
