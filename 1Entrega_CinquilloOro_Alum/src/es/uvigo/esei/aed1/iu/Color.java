/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uvigo.esei.aed1.iu;


/**
 * Clase completamente auxiliar para meter colores decorativos
 * @author Daniel Fabian Rodriguez Lorenzo
 */
public class Color {
    public static final String RESET = "\033[0m";  //Resetea el cambio de color
    public static final String ORO = "\033[0;33m"; //Amarillo
    public static final String BASTOS = "\033[0;32m"; //Verde
    public static final String ROJO = "\033[0;31m"; //Rojo
    public static final String ESPADAS = "\033[0;34m";// azul
    public static final String COPAS = "\033[1;31m"; //rojo anaranjado, tecnicamente rojo bold
    
    
    /**
     * Pone color al mensaje
     * 
     * @param mensaje el mensaje a colorizar
     * @param color el color a usar, USAR LOS STATIC DE LA CLASE COLOR 
     * @return el mensaje colorizado
     */
    public static String colorizar(String mensaje, String color){
        if(!color.equals(ORO) && !color.equals(BASTOS)
                && !color.equals(ROJO) && !color.equals(ESPADAS) 
                && !color.equals(COPAS)){
            //Si color no es uno valido
            return mensaje;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(color).append(mensaje).append(RESET);
        return sb.toString();
    }
    
    /**
     * Pone color a la carta
     * 
     * @param mensaje la carta como String
     * @param numPalo el palo a colorizarsería 
     * @return La carta con colores
     */
    public static String colorizar(String mensaje, int numPalo){
        String toRet;
        switch (numPalo) {
            case 0:
                toRet = colorizar(mensaje, ORO);
                break;
            case 1:
                toRet = colorizar(mensaje, ESPADAS);
                break;
            case 2:
                toRet = colorizar(mensaje, COPAS);
                break;
            case 3:
                toRet = colorizar(mensaje, BASTOS);
                break;
            default:
                toRet = mensaje;
        }
        return toRet;
    }
}
