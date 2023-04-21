/**
 * Representa el juego del Cinquillo-Oro, con sus reglas (definidas en el documento Primera entrega).
 * Se recomienda una implementación modular.
 */
package es.uvigo.esei.aed1.core;

import es.uvigo.esei.aed1.iu.IU;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * La clase que representa el juego del Cinquillo-Oro
 *
 */
public class Juego {

    private final IU iu;
    private Baraja baraja;
    private List<Jugador> listaJugadores;
    private Mesa mesa;

    public Juego(IU iu) {
        this.iu = iu;
        this.baraja = new Baraja();
        this.listaJugadores = new LinkedList();
        this.mesa = new Mesa();
    }

    /**
     * Inicia el juego
     *
     */
    public void jugar() {
        iu.mostrarMensaje("Comenzando juego de Cinquillo Oro"
                +"\nSe recomienda jugar en pantalla completa");
        listaJugadores = iu.pedirDatosJugadores();

        iu.mostrarMensaje("Preparando la partida y "
                + "repartiendo cartas, por favor espere");
        baraja.barajar();
        repartircartas();
        iu.mostrarJugadores(listaJugadores);
        int pos = elegirJugadorInicial();
        iu.mostrarMensaje("El jugador que comenzara la partida es:\t"
                + listaJugadores.get(pos).getNombre());
        boolean continuar = true;
        Jugador jugador;
        while (continuar) {
            if (pos >= listaJugadores.size()) {
                pos = 0;
            }
            jugador = listaJugadores.get(pos);

            iu.mostrarMensaje("Juega: ");
            iu.mostrarJugador(jugador);
            iu.mostrarMesa(mesa);
            
            if (tieneCartasValidas(jugador)) {   
                Carta actual = leerCarta(jugador);
                mesa.insertar(actual);
            } else {
                iu.mostrarMensaje("El jugador %s no tiene cartas validas,"
                        + " pasando turno\n", jugador.getNombre());
            } 
            
            if (jugador.noTieneCartas()) { //Acaba la partida
                continuar = false;
                iu.mostrarMensaje("\n\nEl jugador %s ha ganado la partida", jugador.getNombre());
            } else { //Continua el siguiente jugador
                pos++;
            }
        }
    }
    
    
    public Carta leerCarta(Jugador jugador){
        Carta toRet = null;
        do {
            if(toRet != null){
                iu.mostrarMensaje("La carta seleccionada no es valida");
                iu.mostrarMesa(mesa);
                iu.mostrarMensaje("Seleccione una carta valida");
                jugador.insertarCartaALaMano(toRet);
            }
            int opt = -1234; //valor a reemplazar
        
            do {
                if(opt != -1234){
                        iu.mostrarMensaje("No se ha seleccionado una carta");
                }
                iu.mostrarMensaje("Cartas de la mano : \n %s", jugador.cartasActivas(jugador));
                opt = iu.leeNum("Introduzca la carta a colocar"
                            + " (el numero mostrado antes de la carta): ") - 1;
            } while (opt < 0 || opt >= jugador.getManoDeCartas().size());         
            toRet = jugador.cojerCarta(opt);
            
        } while (!mesa.cartaValida(toRet));
        return toRet;
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

    public boolean tieneCartasValidas(Jugador jugador){
        boolean cartaValida = jugador.tieneCincos();
        Iterator<Carta> it= jugador.getManoDeCartas().iterator();
        while (!cartaValida && it.hasNext()) {
           cartaValida = mesa.cartaValida(it.next());
        }

        return cartaValida;
    }
}
