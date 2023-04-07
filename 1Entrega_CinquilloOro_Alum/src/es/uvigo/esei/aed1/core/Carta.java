package es.uvigo.esei.aed1.core;

/**
 * Representa una carta de la baraja española, con valor y palo
 * 
 */
public class Carta {
    /**
     * Un enumerado que representa los Palos de la baraja española
     */
    public static enum Palos {OROS,ESPADAS,COPAS,BASTOS};
    private int numero;
    private Palos palo;
    
    /**
    * Crea una carta
    * 
    * @param numero el numero de la carta (1 a 12)
    * @param palo el palo de la carta (Oros, Espadas, Copas o Bastos)
    */
    public Carta(int numero,Palos palo){
       this.numero = numero;
       this.palo = palo;
    }
    
    /**
     * Devuelve el numero de la carta
     * 
     * @return El numero de la carta, como entero 
     */
    public int getNumero() {
        return this.numero;
    }
    
    /**
     *  Devuelve el palo de la carta
     * 
     * @return El palo de la carta, como Palo
     */
    public Palos getPalo() {
        return this.palo;
    }

    @Override
    /**
     * Devuelve la carta como un string "Numero de Palo"
     * 
     * @return La carta como string
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getNumero()).append(" de ");
        sb.append(this.getPalo().name().toLowerCase());
        return sb.toString();
    }   
}
