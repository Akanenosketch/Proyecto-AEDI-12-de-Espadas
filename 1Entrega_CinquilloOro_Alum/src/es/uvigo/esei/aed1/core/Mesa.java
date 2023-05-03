package es.uvigo.esei.aed1.core;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import es.uvigo.esei.aed1.iu.Color;
import java.util.Stack;

public class Mesa {

    private Deque<Carta>[] palos;

    /**
     * Crea la Mesa vacia
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
     * Inserta una carta en la mesa, comprobando su validez previamente
     *
     * @param carta La carta a colocar
     * @return Devuelve true si la carta se inserto o false si la carta no es
     * valida
     */
    public boolean insertar(Carta carta) {
        boolean toRet = cartaValida(carta);
        //si es valida la inserta
        if (toRet) {
            int palo = carta.getPalo().ordinal();
            if (carta.getNumero() < 5) {
                palos[palo].addFirst(carta);
            } else {
                palos[palo].addLast(carta);
            }
        }
        return toRet;
    }

    /**
     * Comprueba si la carta se puede insertar
     *
     * @param carta La carta a insertar
     * @return si se puede insertar
     */
    public boolean cartaValida(Carta carta) {
        //Si la carta ya esta en la mesa no se puede insertar
        boolean toRet = !this.contiene(carta);

        //si no esta en la mesa la comprueba
        if (toRet) {
            int num = carta.getNumero();
            //si es 5 es valida
            if (num == 5) {
                toRet = true;
            } else {
                //si no es 5 comprueba la que va antes en la mesa
                Carta.Palos palo = carta.getPalo();
                if (num < 5) {
                    num++;
                } else {
                    num--;
                }
                toRet = this.contiene(new Carta(num, palo));
            }
        }
        return toRet;
    }

    /**
     * Metodo para comprobar si una carta esta en la mesa
     *
     * @param carta la carta a comprobar
     * @return Si la carta esta en la mesa o no
     */
    public boolean contiene(Carta carta) {
        boolean toRet = false;
        Iterator<Carta> it = palos[carta.getPalo().ordinal()].iterator();
        while (!toRet && it.hasNext()) {
            toRet = carta.iguales(it.next());
        }
        return toRet;
    }

    /**
     * Vacía la mesa y almacena las cartas en un Stack
     *
     * @return las cartas de la mesa
     */
    public Stack quitarCartasDeLaMesa() {
        int size = palos.length;
        Stack<Carta> cartas = new Stack<>();
        for (int i = 0; i < size; i++) {
            while (!palos[i].isEmpty()) {
                cartas.push(palos[i].removeFirst());
            }
        }
        return cartas;
    }

    /**
     * Devuelve el estado de la mesa, como String
     *
     * @return La mesa como String
     */
    @Override
    public String toString() {
        Carta.Palos[] palo = Carta.Palos.values();
        int size = palo.length;
        StringBuilder toRet = new StringBuilder();
        for (int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%8s", palo[i].name() + ":"));
            sb.append("  ");
            if (!palos[i].isEmpty()) {
                //Pone espacios en blanco en las posiciones sin carta
                int vacios = palos[i].peekFirst().getNumero() - 1;
                for (int j = 0; j < vacios; j++) {
                    sb.append(" ").append(" ");
                }
                //Pone las cartas
                for (Carta carta : palos[i]) {
                    sb.append(carta.getNumero()).append(" ");
                }
                //Pone espacios en blanco en las posiciones sin cartas
                vacios = 12 - palos[i].peekLast().getNumero();
                for (int j = 0; j < vacios; j++) {
                    sb.append(" ").append(" ");
                }
            }
            //Pone sb con color en toRet
            toRet.append(Color.colorizar(sb.toString(), i));
            toRet.append("\n");
        }
        return toRet.toString();
    }
}
