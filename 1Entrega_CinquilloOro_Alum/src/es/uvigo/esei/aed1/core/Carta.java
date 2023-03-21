/*
 * Representa una carta, formada por un número y su palo correspondiente
 */


package es.uvigo.esei.aed1.core;
/**
 * Una clase que representa una carta de la baraja española, con valor y palo
 * @author Daniel Fabián Rodríguez Lorenzo
 */
public class Carta {
    public static enum Palos {OROS,ESPADAS,COPAS,BASTOS};
    private int numero;
    private Palos palo;
    
    /**
    * Crea una carta
    * @param numero el numero de la carta (1 a 12)
    * @param palo el palo de la carta (Oros, Espadas, Copas o Bastos)
    */
    public Carta(int numero,Palos palo){
       this.numero = numero;
       this.palo = palo;
    }
    
    /**
     * 
     * @return El numero de la carta 
     */
    public int getNumero() {
        return numero;
    }
    
    /**
     * 
     * @return El palo de la carta
     */
    public Palos getPalo() {
        return palo;
    }

    @Override
    /**
     * Devuelve la carta como un string "Numero de Palo"
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(numero).append(" de ").append(palo);
        return sb.toString();
    }   
}
