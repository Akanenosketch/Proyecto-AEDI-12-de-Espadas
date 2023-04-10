/**
 * Representa el juego del Cinquillo-Oro, con sus reglas (definidas en el documento Primera entrega). 
 * Se recomienda una implementación modular.
 */

package es.uvigo.esei.aed1.core;

import es.uvigo.esei.aed1.iu.IU;
import java.util.List; 

/**
 * La clase que representa el juego del Cinquillo-Oro
 * 
 */
public class Juego{
    private final IU iu;
    //Un par de ideas random para tatiana/natalia
    // Una funcion booleana EN JUGADOR que mire si puede colocar alguna 
    //carta de la mano en la mesa, usando la de cartaValida de la Mesa en un while de busqueda lineal y usando la de buscarincos de la primera entrega primero
    //Un ifelse aqui el juego (colocadlo donde podais y cuando haga mi parte lo meto) que llame a la funcion
    //una funcion para lo de pedir la carta que use la cartaValida de mesa
    // Por estetica, usar el serr si no puede poner carta
    //lo de pasar turno seguramente lo mire yo en mi parte, pq lo vuestro son funciones y un ifelse metido en mi parte
    
    
    public Juego(IU iu){
        this.iu = iu;

    }
    /**
     * Inicia el juego
     * 
     */
    public void jugar(){
        List<Jugador> listaJugadores = iu.pedirDatosJugadores();
        Baraja baraja = new Baraja();
        baraja.barajar();
        baraja.repartircartas(listaJugadores);
        iu.mostrarJugadores(listaJugadores);
        iu.mostrarMensaje("El jugador que comenzara la partida es: \n");
        iu.mostrarMensaje(listaJugadores.get(iu.elegirJugadorInicial(listaJugadores)).getNombre());
        //lo anterior solo se harua al principio, salvo barajar y repartir
        
        
        //Aqui me pongo yo - Fabi
        //Ignorad mis comentarios, estoy haciendo ideas
        
//Los/as jugadores/as van jugando por turnos (colocando cartas en la mesa) hasta
//que la partida termine. La partida termina cuando un/a jugador/a coloca todas sus
//cartas en la mesa. Al terminar la partida, se debe indicar el nombre del jugador que
//ha resultado ganador.
        // while que no pare mientras haya cartas con un fore  que ejecute cosas (reset auto en el fore?)
        //comprobar si un iterador deja hacer ese tipo de modificaciones
        //como lanzar la noguedanexc? hay que parar el juego cuando pase o se puede liar luego con el as
        //sacar y meter una carta para comprobar? no estan ordenadas da igual
        
    }

        
    
}
