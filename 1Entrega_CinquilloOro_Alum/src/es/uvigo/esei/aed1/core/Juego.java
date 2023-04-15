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
    private Mesa mesa;
    //Un par de ideas random para tatiana/natalia
    // Una funcion booleana que mire si el jugador puede colocar alguna 
    //carta de la mano en la mesa, usando la de cartaValida de la Mesa  y la de buscarincos de la primera entrega 
    //Un ifelse aqui en jugar (colocadlo donde podais y cuando haga mi parte lo meto) que llame a la funcion
    //una funcion para lo de pedir la carta 
    //lo de pasar turno seguramente lo mire yo en mi parte, pq lo vuestro son funciones y un ifelse metido en mi parte
    
    public Juego(IU iu){
        this.iu = iu;
        this.baraja = new Baraja();
        this.listaJugadores = new LinkedList();
        this.mesa = new Mesa();
    }
    /**
     * Inicia el juego
     * 
     */
    public void jugar(){
        iu.mostrarMensaje("Comenzando juego de Cinquillo Oro");
        listaJugadores = iu.pedirDatosJugadores();
       
        iu.mostrarMensaje("Preparando la partida y "
                + "repartiendo cartas, por favor espere");        
        baraja.barajar();
        repartircartas();
        iu.mostrarJugadores(listaJugadores);
        int pos = elegirJugadorInicial();
        iu.mostrarMensaje("El jugador que comenzara la partida es:\t"
                +listaJugadores.get(pos).getNombre());
        //lo anterior solo se harua al principio, salvo barajar y repartir
        
        boolean continuar = true;
        Jugador jugador;
        while (continuar) {
            if(pos >= listaJugadores.size()){
                pos = 0;
            }
            jugador = listaJugadores.get(pos);
            iu.mostrarMensaje("Estado de la Mesa");
            iu.mostrarMesa(mesa);
            iu.mostrarMensaje("Juega: ");
            iu.mostrarJugador(jugador);
            
            //INSERTAR CODIGO INSERTAR CARTA TODO AQUI
            //Borrar la linea siguiente
            if(pos == 0) throw new RuntimeException("Bucle infinito momento");
            
            
            
            
            if (jugador.noTieneCartas()) { //Acaba la partida
                continuar = false;
                iu.mostrarMensaje("El jugador %s ha ganado la partida",jugador.getNombre() );
            } else { //Continua al siguiente jugador
                pos++;
            }
        }
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
     * Devuelve la posicion del jugador (aleatorio) que comenzara la partida
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
