/**
 * Representa el juego del Cinquillo-Oro, con sus reglas (definidas en el documento Primera entrega).
 * Se recomienda una implementación modular.
 */
package es.uvigo.esei.aed1.core;

import es.uvigo.esei.aed1.iu.IU;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * La clase que representa el juego del Cinquillo-Oro
 *
 */
public class Juego {

    private final IU iu;
    private Baraja baraja;
    private List<Jugador> listaJugadores;
    private Mesa mesa;
    private final int puntosPartida = 4;
    private int puntosAsDeOros;
    
    public Juego(IU iu) {
        this.iu = iu;
        this.baraja = new Baraja();
        this.listaJugadores = new LinkedList();
        this.mesa = new Mesa();
        puntosAsDeOros = 0; //Se incrementan antes de la primera partida
    }

    /**
     * Inicia el juego
     *
     */
    public void jugar() {
        //esto se hace solo 1 vez
        iu.mostrarMensaje("Comenzando juego de Cinquillo Oro"
                + "\nSe recomienda jugar en pantalla completa");
        listaJugadores = iu.pedirDatosJugadores();
        
        //A partir de aqui es una partida
        
        //Preparacion partida
        iu.mostrarMensaje("Preparando la partida y "
                + "repartiendo cartas, por favor espere");
        baraja.barajar();
        repartircartas();
        iu.mostrarJugadores(listaJugadores);
        
        int pos = elegirJugadorInicial();
        
        while (!listaJugadores.get(pos).tieneCartasValidas(mesa)) {
            iu.mostrarMensajeError("El jugador seleccionado ( " + listaJugadores.get(pos).getNombre()
                        + " ) no tiene cartas validas\n"
                        + "Seleccionando otro jugador inicial ");
            pos++;
        }
        
        iu.mostrarMensajeDestacado("El jugador que comenzara la partida es:\t"
                + listaJugadores.get(pos).getNombre());
        
        
        //Partida en si
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

            //meter en algun sitio por aqui la comprobacion del as usando actual?
            
            if (jugador.tieneCartasValidas(mesa)) {
                Carta actual = leerCarta(jugador);
                mesa.insertar(actual);
            } else {
                iu.mostrarMensajeError("El jugador " + jugador.getNombre() 
                        + " no tiene cartas validas, pasando turno\n");
            }
           
            
            if (jugador.noTieneCartas()) { //Acaba la partida
                continuar = false;
                //este no funciona
                iu.mostrarMensajeDestacado("El jugador "+jugador.getNombre()
                        +" ha ganado la partida");
                //quitamos las cartas todas para devolverlas a la mesa(colo funciona cuando se implemente el bucle)
                Stack<Carta> cartas = new Stack<>();
                for (Jugador jugadores : listaJugadores) {
                   cartas.addAll(jugadores.quitarCartasManoDeCartas());
                }
                baraja.prepararBaraja(mesa.quitarCartasDeLaMesa(), cartas);
            } else { //Continua el siguiente jugador
                pos++;
            }
        }
    }

    /**
     * Muestra todas las cartas del jugador y da a elegir cual poner en la mesa.
     * Se comprobara que la carta elegida se puede colocar en la mesa
     *
     * @param jugador El jugador a insertar carta
     * @return La carta a insertar
     */
    public Carta leerCarta(Jugador jugador) {
        Carta toRet = null;
        do {
            if(toRet != null){
                iu.mostrarMensajeError("La Carta seleccionada no es valida\n");
                iu.mostrarMesa(mesa);
                iu.mostrarMensaje("Seleccione una carta valida");
                jugador.insertarCartaALaMano(toRet);
            }
            int opt = iu.leerCarta(jugador);
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
        return IU.numeroRandom(size);
    }
    
    /**
     * Incrementa los puntos que da el As de Oros en 2 unidades
     *
     */
      public void incrementarPuntosAsDeOros() {
        this.puntosAsDeOros += 2;

      }
    
}
