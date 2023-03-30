/**
 * Representa el juego del Cinquillo-Oro, con sus reglas (definidas en el documento Primera entrega). 
 * Se recomienda una implementación modular.
 */

package es.uvigo.esei.aed1.core;

import es.uvigo.esei.aed1.iu.IU;
import java.util.Collection; 


public class Juego{
    private final IU iu;
    
    
    public Juego(IU iu){
        this.iu = iu;

    }

    public void jugar(){
        Collection<Jugador> listaJugadores = iu.pedirDatosJugadores();
    }

        
    
}
