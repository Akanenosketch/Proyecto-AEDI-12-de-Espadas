package es.uvigo.esei.aed1.core;

import es.uvigo.esei.aed1.iu.Decorador;
import es.uvigo.esei.aed1.iu.IU;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * La clase que representa el juego del Cinquillo-Oro.
 *
 */
public class Juego {

    private final IU iu;
    private Baraja baraja;
    private List<Jugador> listaJugadores;
    private Mesa mesa;
    private final int puntosPartida = 4;
    private int puntosAsDeOros;

    /**
     * Crea el juego.
     *
     * @param iu la clase de iu que se usara.
     */
    public Juego(IU iu) {
        this.iu = iu;
        this.baraja = new Baraja();
        this.listaJugadores = new LinkedList();
        this.mesa = new Mesa();
        this.puntosAsDeOros = 2;
    }

    /**
     * Inicia el juego.
     *
     */
    public void jugar() {

        //Comienzo del juego y lectura de jugadores
        iu.mostrarMensaje("Comenzando juego de Cinquillo Oro"
                + "\nSe recomienda jugar en pantalla completa");
        listaJugadores = iu.pedirDatosJugadores();

        boolean asColocado = false;
        do {  //Bucle del juego, repite partidas hasta que se pone el as

            asColocado = partida();

        } while (!asColocado);

        iu.mostrarMensaje("Se ha acabado el juego\n");

        ganadorDeLaPartida();
    }

    /**
     * Juega una partida.
     *
     * @return Si se ha colocado el as en la mesa durante la partida.
     */
    private boolean partida() {
        boolean asEnMesa = false;

        //Prepara la partida y escoje la posicion inicial
        int posActual = prepararPartida();

        boolean continuar = true;
        Jugador jugador;

        do {  //Bucle para 1 turno de partida

            //Comprobacion de posicion valida
            if (posActual >= listaJugadores.size()) {
                posActual = 0;
            }

            jugador = listaJugadores.get(posActual);

            iu.mostrarMensaje("Juega: ");
            iu.mostrarJugador(jugador);
            iu.mostrarMesa(mesa);

            if (jugador.tieneCartasValidas(mesa)) { //Puede colocar carta
                Carta actual = leerCarta(jugador);
                mesa.insertar(actual);

                if (actual.esAsDeOros()) { //Comprobacion del as
                    iu.mostrarMensajeDestacado("El jugador " + jugador.getNombre()
                            + " ha colocado el As de Oros en la mesa");
                    asEnMesa = true;
                    jugador.addPuntos(this.puntosAsDeOros);
                }
            } else { //No puede colocar carta
                iu.mostrarMensajeError("El jugador " + jugador.getNombre()
                        + " no tiene cartas validas, pasando turno\n");
            }

            if (jugador.noTieneCartas()) { //Acaba la partida
                iu.mostrarMensajeDestacado("El jugador " + jugador.getNombre()
                        + " ha ganado la partida");
                continuar = false;
                jugador.addPuntos(this.puntosPartida);
            } else { //Continua el siguiente jugador
                posActual++;
            }
        } while (continuar);
        finalizarPartida();
        return asEnMesa;
    }

    /**
     * Finaliza la partida.
     * 
     */
    private void finalizarPartida() {
        devolverABaraja();
        incrementarPuntosAsDeOros();
    }

    /**
     * Prepara la partida.
     *
     * @return La posicion del jugador que comenzara.
     */
    private int prepararPartida() {

        iu.mostrarMensaje("Preparando la partida y "
                + "repartiendo cartas, por favor espere");
        baraja.barajar();
        repartircartas();
        iu.mostrarJugadores(listaJugadores);

        int posInicial = elegirJugadorInicial();

        while (!listaJugadores.get(posInicial).tieneCartasValidas(mesa)) {
            iu.mostrarMensajeError("El jugador seleccionado ( " + listaJugadores.get(posInicial).getNombre()
                    + " ) no tiene cartas validas\n"
                    + "Seleccionando otro jugador inicial ");
            posInicial++;
        }

        iu.mostrarMensajeDestacado("El jugador que comenzara la partida es:\t"
                + listaJugadores.get(posInicial).getNombre());

        return posInicial;
    }
    
    /**
     * Muestra todas las cartas del jugador y da a elegir cual poner en la mesa.
     * Se comprobara que la carta elegida se puede colocar en la mesa.
     *
     * @param jugador El jugador a insertar carta.
     * @return La carta a insertar.
     */
    private Carta leerCarta(Jugador jugador) {
        Carta cartaLeida = null;
        do {
            if (cartaLeida != null) {
                iu.mostrarMensajeError("La Carta seleccionada no es valida\n");
                iu.mostrarMesa(mesa);
                iu.mostrarMensaje("Seleccione una carta valida");
                jugador.insertarCartaALaMano(cartaLeida);
            }
            int opt = iu.leerCarta(jugador);
            cartaLeida = jugador.cojerCarta(opt);

        } while (!mesa.cartaValida(cartaLeida));
        return cartaLeida;
    }

    /**
     * Reparte todas las cartas de la baraja a los jugadores.
     *
     */
    private void repartircartas() {
        while (!baraja.isEmpty()) {
            for (Jugador jugador : listaJugadores) {
                jugador.insertarCartaALaMano(baraja.sacarCarta());
            }
        }
    }

    /**
     * Devuelve la posicion del jugador (aleatorio) que comenzara la partida.
     *
     * @return La posicion del jugador a comenzar.
     */
    private int elegirJugadorInicial() {
        final int size = listaJugadores.size();
        return IU.numeroRandom(size);
    }

    /**
     * Incrementa los puntos que da el As de Oros en 2 unidades.
     *
     */
    private void incrementarPuntosAsDeOros() {
        this.puntosAsDeOros += 2;
    }
    
    /**
     * Devuelve las cartas de los jugadores y la mesa a la baraja.
     * 
     */
    private void devolverABaraja() {

        Stack<Carta> cartas = new Stack<>();
        for (Jugador jugadores : listaJugadores) {
            cartas.addAll(jugadores.quitarCartasManoDeCartas());
        }
        baraja.prepararBaraja(mesa.quitarCartasDeLaMesa(), cartas);
    }

    /**
     * Muestra por pantalla al ganador/es de la partida.
     *
     */
    private void ganadorDeLaPartida() {
        int maxPuntos = 0;
        int numGanadores = 0;
        //Busca el maximo de puntos y el numero de ganadores
        for (Jugador jugador : listaJugadores) {
            if (maxPuntos == jugador.getPuntos()) {
                numGanadores++;
            } else if (maxPuntos < jugador.getPuntos()) {
                maxPuntos = jugador.getPuntos();
                numGanadores = 1;
            }
        }

        StringBuilder ganadores = new StringBuilder();
        if (numGanadores > 1) {
            ganadores.append("Hay un empate a ").append(maxPuntos).append(" puntos ");
            ganadores.append("entre los jugadores:\n");
        } else {
            ganadores.append("El jugador que gana con ").append(maxPuntos);
            ganadores.append(" puntos es: \t");
        }

        Jugador jugador;
        Iterator<Jugador> it = listaJugadores.iterator();
        while (it.hasNext() && numGanadores > 0) {
            jugador = it.next();
            if (maxPuntos == jugador.getPuntos()) {
                ganadores.append(Decorador.colorizar(jugador.getNombre(), Decorador.VIOLETA));
                ganadores.append("\n");
                numGanadores--;
            }
        }
        iu.mostrarMensajeDestacado(ganadores.toString());
    }
}
