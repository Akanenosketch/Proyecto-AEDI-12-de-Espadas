/**
 * Representa el juego del Cinquillo-Oro, con sus reglas (definidas en el documento Primera entrega). 
 * Se recomienda una implementación modular.
 */

package es.uvigo.esei.aed1.core;

import es.uvigo.esei.aed1.iu.IU;
import java.util.List; 


public class Juego{
    private final IU iu;
    
    
    public Juego(IU iu){
        this.iu = iu;

    }

    public void jugar(){
        List<Jugador> listaJugadores = iu.pedirDatosJugadores();
        Baraja baraja = new Baraja();
        baraja.barajar();
        baraja.repartircartas(listaJugadores);
        iu.mostrarJugadores(listaJugadores);
        iu.mostrarMensaje("El jugador que comenzara la partida es: \n");
        iu.mostrarMensaje(listaJugadores.get(iu.elegirJugadorInicial(listaJugadores)).getNombre());
    }

        
    
}
