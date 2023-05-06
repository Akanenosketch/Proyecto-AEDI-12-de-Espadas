package es.uvigo.esei.aed1.core;

import es.uvigo.esei.aed1.iu.Decorador;

/**
 * Representa una carta de la baraja española, con valor y palo.
 *
 */
public class Carta {

    /**
     * Un enumerado que representa los Palos de la baraja española.
     * 
     */
    public static enum Palos {
        OROS, ESPADAS, COPAS, BASTOS
    };
    
    private int numero;
    private Palos palo;

    /**
     * Crea una carta.
     *
     * @param numero el numero de la carta (1 a 12).
     * @param palo el palo de la carta (Oros, Espadas, Copas o Bastos).
     */
    public Carta(int numero, Palos palo) {
        this.numero = numero;
        this.palo = palo;
    }

    /**
     * Devuelve el numero de la carta.
     *
     * @return El numero de la carta, como entero.
     */
    public int getNumero() {
        return this.numero;
    }

    /**
     * Devuelve el palo de la carta.
     *
     * @return El palo de la carta, como Palo.
     */
    public Palos getPalo() {
        return this.palo;
    }

    /**
     * Compara this con otra carta.
     *
     * @param otra La carta a comparar.
     * @return devuelve true si y solo si el numero y el palo son iguales.
     */
    public boolean iguales(Carta otra) {
        return this.getNumero() == otra.getNumero()
                && this.getPalo() == otra.getPalo();
    }

    /**
     * Comprueba si this es el as de oros.
     * 
     * @return true si this es igual al as de oros.
     */
    public boolean esAsDeOros(){
        return this.iguales(new Carta(1, Palos.OROS));
    }
    
    @Override
    /**
     * Devuelve la carta como un string "Numero de Palo".
     *
     * @return La carta como string.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getNumero()).append(" de ");
        sb.append(this.getPalo().name().toLowerCase());
        return Decorador.colorizar(sb.toString(), palo.ordinal());
    }   
}