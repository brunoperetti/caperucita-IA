# TP Inteligencia Artificial: Caperucita
_Trabajo práctico realizado para la cátedra de Inteligencia Artificial, de 5to año de Ingeniería en Sistemas de Información, UTN FRSF._

## Objetivo

Construir un agente inteligente, para comprender como éste se relaciona con el mundo en el cual se desenvuelve y cómo utiliza las técnicas vistas en clase para tomar las decisiones sobre las acciones que puede emprender.


## Descripción
Desarrolle un agente capaz de jugar al siguiente videojuego.
Caperucita roja debe ir a visitar a su abuela atravesando el bosque donde se puede encontrar el lobo. En el camino Caperucita tiene que juntar los dulces que le va a llevar a su abuela y por último juntar las flores. El campo de flores lleva a Caperucita directamente a la casa de su abuela, por lo tanto, una vez que llega a esa posición el juego termina. Cada dulce que junta, le asigna más puntos al jugador, en caso de que Caperucita llegue al campo de flores sin ningún dulce, el jugador termina el juego sin lograr ningún punto. En cuanto al lobo, éste puede aparecer escondido entre los árboles, no tiene una posición fija, sino que se mueve por el bosque. Caperucita tiene que ir con mucho cuidado para no quedar en la celda donde está el lobo, porque en esa circunstancia caerá en las mentiras del mismo y el jugador pierde una vida y tiene que volver a empezar (es decir, si ya tenía juntado dulces, pierde todo y vuelve a su posición inicial), el agente inicialmente tiene 3 vidas.
Una cuestión importante es que Caperucita se mueve en línea recta desde su posición hasta el final del camino, es decir, en lugar de ir avanzando por celdas contiguas, el avance es hasta encontrar el fin del camino. Por ejemplo, si consideramos la posición de caperucita con los valores (fila, columna), para la imagen que se observa en la figura 1, caperucita está en la posición (6, 12), en caso de ir a la izquierda, quedará en la posición (6,7) y si se mueve hacia arriba (6,12) queda en la posición (3,12).

## Solución

![image](https://user-images.githubusercontent.com/44849522/120841050-6603c000-c541-11eb-9b3f-5054082e2fe0.png)

Código en java basado en el framework FAIA, e interfaces gráficas realizadas con la librería Swing.

## Instrucciones

1. Descargar el [framework FAIA](https://code.google.com/archive/p/faia/), e importar junto con el proyecto.
2. Elegir posición inicial y uno de los 3 escenarios pre-cargados, en la clase CaperucitaEnvironmentState.java
3. Elegir una estrategia de búsqueda del agente (Profundidad, anchura, costo uniforme, o heurística) en la clase CaperucitaAgent.java
