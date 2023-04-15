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

### Segunda entrega

La segunda práctica tiene como fecha límite el 24 de abril, y la defenderemos en una tutoría grupal un dia por decidir de esa semana (el martes no u cagamos en AL). Dentro de esa tutoría grupal se valorará también el **grado de implicación de cada miembro del grupo en el proyecto** es decir, las notas de cada uno afecta a la nota grupal. Esta segunda parte consiste en añadir las funcionalidades para hechar una partida .

Los puntos a trabajar durante esta entrega son los siguientes (hago copia-pega por pereza):
  
- [x] Cambios posibles sugeridos en la tutoria. 

- [x] Crear la mesa de juego, inicialmente vacía (el fichero con la clase Mesa, inicialmente vacía, se os proporciona). @adrixprietox

- [ ] Los/as jugadores/as van jugando por turnos (colocando cartas en la mesa) hastaque la partida termine. La partida termina cuando un/a jugador/a coloca todas sus cartas en la mesa. @DanielFabianRL 

- [x] En cada turno de juego se debe mostrar i) el estado de la mesa y ii) las cartas de la mano del jugador/a activo/a. @thekingofwar03

- [ ] Si el/la jugador/a activo/a puede colocar alguna carta en la mesa, se le debe preguntar qué carta quiere colocar. Si es posible, se coloca en la mesa. Si no es posible, se le informa y se le pide que escoja otra carta. Una vez colocada pasa el turno al siguiente jugador/a. @Akanenosketch & @SugarStorm22
  
- [ ] Si el/la jugador/a activo/a no puede colocar ninguna carta en la mesa, se informa y pasa el turno al siguiente jugador/a. @Akanenosketch & @SugarStorm22
  
- [ ] Al terminar la partida, se debe indicar el nombre del jugador/a o jugadores/as que ha resultado ganador. @DanielFabianRL

### Recomendaciones (antes de que alguien la cague y tengamos que dar hostias)
- Cada punto en la branch de la entrega y cuando se confirme que funciona se hace pull request al main.

- No lo hagais a última hora, un fallo 20 minutos antes de la entrega es un asesinato asegurado.

- Respetar las dependencias de los apartados a menos que los de teoría sean gilipollas.

- Ante la duda pedid ayuda con el codigo, hay que asegurar que funciona. (Si da fallos después de hacer la pull request se revierte y se corrige aunque cada branch contiene una copia del stable).


#### Dependencias de apartados

TODO pero primero crear la mesa, luego sin orden mostrarla y la funcion de que el jugador coloque carta, y por ultimo el codigo para ir jugando
> Gráfica de dependencia de los apartados (ya lo haré)

