package es.uvigo.esei.aed1.core;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import es.uvigo.esei.aed1.iu.Decorador;
import java.util.Stack;

/**
 * Representa la mesa de juego.
 * 
 */
public class Mesa {

    private Deque<Carta>[] palos;

    /**
     * Crea la Mesa vacia.
     *
     */
    public Mesa() {
        int size = Carta.Palos.values().length;
        palos = new Deque[size];
        for (int i = 0; i < size; i++) {
            palos[i] = new ArrayDeque(12);
        }
    }

    /**
     * Inserta una carta en la mesa, comprobando su validez previamente.
     *
     * @param carta La carta a colocar.
     * @return Devuelve true si la carta se inserto o false si la carta no es
     * valida.
     */
    public boolean insertar(Carta carta) {
        boolean esValida = cartaValida(carta);
        //si es valida la inserta
        if (esValida) {
            int palo = carta.getPalo().ordinal();
            if (carta.getNumero() < 5) {
                palos[palo].addFirst(carta);
            } else {
                palos[palo].addLast(carta);
            }
        }
        return esValida;
    }

    /**
     * Comprueba si la carta se puede insertar.
     *
     * @param carta La carta a insertar.
     * @return si se puede insertar.
     */
    public boolean cartaValida(Carta carta) {
        //Si la carta ya esta en la mesa no se puede insertar
        boolean esValida = !this.contiene(carta);

        //si no esta en la mesa la comprueba
        if (esValida) {
            int numCartaPrevia = carta.getNumero();
            //si es 5 es valida
            if (numCartaPrevia == 5) {
                esValida = true;
            } else {
                //si no es 5 comprueba la que va antes en la mesa
                Carta.Palos palo = carta.getPalo();
                if (numCartaPrevia < 5) {
                    numCartaPrevia++;
                } else {
                    numCartaPrevia--;
                }
                esValida = this.contiene(new Carta(numCartaPrevia, palo));
            }
        }
        return esValida;
    }

    /**
     * Metodo para comprobar si una carta esta en la mesa.
     *
     * @param carta la carta a comprobar.
     * @return Si la carta esta en la mesa o no.
     */
    public boolean contiene(Carta carta) {
        boolean cartaEnMesa = false;
        Iterator<Carta> it = palos[carta.getPalo().ordinal()].iterator();
        while (!cartaEnMesa && it.hasNext()) {
            cartaEnMesa = carta.iguales(it.next());
        }
        return cartaEnMesa;
    }

    /**
     * Vacía la mesa y almacena las cartas en un Stack.
     *
     * @return las cartas de la mesa.
     */
    public Stack<Carta> quitarCartasDeLaMesa() {
        int numPalos = palos.length;
        Stack<Carta> cartas = new Stack<>();
        for (int i = 0; i < numPalos; i++) {
            while (!palos[i].isEmpty()) {
                cartas.push(palos[i].removeFirst());
            }
        }
        return cartas;
    }

    /**
     * Devuelve el estado de la mesa, como String.
     *
     * @return La mesa como String.
     */
    @Override
    public String toString() {
        Carta.Palos[] palo = Carta.Palos.values();
        int numPalos = palo.length;
        StringBuilder toRet = new StringBuilder();
        
        //Para cada palo, mete sus datos en un SB, luego lo coloriza, y lo mete en 
        //el SB que se devuelve
        for (int i = 0; i < numPalos; i++) {
            //Resetea el sb actual
            StringBuilder sbPaloActual = new StringBuilder();
            //Nombre del palo
            sbPaloActual.append(String.format("%8s", palo[i].name() + ":"));
            sbPaloActual.append("  ");
            
            if (!palos[i].isEmpty()) {
                //Pone espacios en blanco en las posiciones sin carta
                int vacios = palos[i].peekFirst().getNumero() - 1;
                for (int j = 0; j < vacios; j++) {
                    sbPaloActual.append(" ").append(" ");
                }
                //Pone las cartas
                for (Carta carta : palos[i]) {
                    sbPaloActual.append(carta.getNumero()).append(" ");
                }
                //Pone espacios en blanco en las posiciones sin cartas
                vacios = 12 - palos[i].peekLast().getNumero();
                for (int j = 0; j < vacios; j++) {
                    sbPaloActual.append(" ").append(" ");
                }
            }
            //Pone el sb actual con color en toRet
            toRet.append(Decorador.colorizar(sbPaloActual.toString(), i));
            toRet.append("\n");
        }
        return toRet.toString();
    }
}
