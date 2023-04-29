# Proyecto-AEDI-12-de-Espadas
Este repositorio se empleará para el desarrollo del proyecto de AEDI que es una versión sin GUI(menudos aburridos) y modificada para la realización del programa.

**Nota:** Solo los colaboradores tendrán acceso al repositorio (sujeto a cambios a finales de cuatri, el quien lo pase a publico antes del fin del proyecto le damos de hostias).

### **Nota 2:** LEER TODO CODIGO Y ENTENDERLO ANTES DE CAMBIAR COSAS

### **Nota 3:** Si hay dudas pedir ayuda en el grupo antes de montar la marimorena

## ¿En qué consiste el juego?

Si muy bien, ¿qué diablos hace esto aquí? Para no tener que abrir los pdfs cada 5 minutos para saber que hay que hacer.
El juego que hay que elaborar es una de las variantes del cinquillo, denominada ***Cinquillo-Oro*** y consiste en abrir los mazos que tenemos dentro de una baraja española con los 5's de cada mazo (espadas, oros, palos, copas para el que no sepa). Los jugadores deberán de colocar una carta con un valor inmediatamente superior o inferior a las que se encuentran en la mesa de juego o, si tienen un cinco, abrir otro mazo.

![image](https://user-images.githubusercontent.com/90091466/226657303-e5799d83-6f5b-4176-85d0-ff8396225b81.png)
> Ejemplo del cinquillo

En el Cinquillo-Oro el primer jugador es un jugador aleatorio que debe poner un 5 y los turnos van en orden levogiro, los jugadores podrán pasar (perder turno) cuando no tengan cartas para añadir a los mazos o un 5 para abrir uno nuevo(se sabe por experiencia).

Para este proyecto la baraja empleada no es la española, sino una baraja random de los chinos que tiene 12 cartas por mazo, un total de 48 cartas. El primer jugador. que debe poner un 5 cualquiera, se escoge de forma aleatoria y se continuan los turnos en sentido levogiro.

### Tercera entrega

La tercera práctica tiene como fecha límite el 8 de mayo, y la defenderemos en una tutoría grupal un dia por decidir de esa semana (es semana de examenes asi que nos jodemos). Dentro de esa tutoría grupal se valorará también el **grado de implicación de cada miembro del grupo en el proyecto** es decir, las notas de cada uno afecta a la nota grupal. Esta segunda parte consiste en añadir las funcionalidades para hechar una partida .

Los puntos a trabajar durante esta entrega son los siguientes (no son los directos de la entrega para separar mas):
  
- [ ] Cambios posibles sugeridos en la tutoria y mantenimiento del codigo. @DanielFabianRL

- [ ] Un bucle que continue jugando muentras no se haya puesto el as, con un if para comprobar si se puso el as (hacer un asDeOros static? Hacer una funcion         esAsDeOros?) que sume los puntos y mande que pare la partida.  @SugarStorm22 

- [ ] Hacer funcion prepararBaraja?, que vacie la mesa y las manos de los jugadores y las meta en la baraja (Hace falta funcion para meter cartas a la baraja y para sacarlas de la mesa seguramente). @Akanenosketch

- [ ] Crear puntosPartida (siempre sera 4) y puntosAsDeOros (empieza en 2 y aumenta en 2 cada partida). Al ganador de la partida se le suman puntosPartida, y a quien ponga el as se le suman los del as. Meter atributo puntos en jugador y metodos necesarios. @adrixprietox

- [ ] mostrar ganador/es al acabar (con funcion mostrarJugadores?). @thekingofwar03


### Recomendaciones (antes de que alguien la cague y tengamos que dar hostias)
- Cada punto en la branch de la entrega y cuando se confirme que funciona se hace pull request al main.

- No lo hagais a última hora, un fallo 20 minutos antes de la entrega es un asesinato asegurado.

- Ante la duda pedid ayuda con el codigo, hay que asegurar que funciona. (Si da fallos después de hacer la pull request se revierte y se corrige aunque cada branch contiene una copia del stable).


#### Dependencias de apartados

Cambios de tutoria primero, luego creacion de los puntos y preparar la baraja, y por ultimo la estructura y el mostrarGanador
