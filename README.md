# Queue

---

##  Cómo Compilar la Librería

Antes de compilar el handler, lo que hice fue instalar la librería de la Queue localmente en el repositorio de Maven `.m2`. Para eso ejecuté:

```bash
mvn clean install
```

Esto empaquetó la librería y la guardó en `.m2/repository/`, dejándola disponible como dependencia para el handler.

---

##  Cómo Compilar el Handler

Con la librería ya disponible en `.m2`, lo que hice fue situarme dentro del proyecto del handler y ejecutar:

```bash
mvn clean package
```

Esto me generó el **Fat JAR** en la carpeta `target/`, ya que en las dependencias del `pom.xml` lo definí para que me hiciera el fat jar incluyendo todas las dependencias dentro de un solo archivo `.jar`.

---

##  Cómo Ejecutar desde Consola

Al momento de compilar el handler se creó el archivo `fat.jar` dentro de la carpeta `target/`. Me situé a esa dirección desde la terminal y al estar en la carpeta ejecuté:

```bash
cd target
java -jar elnombredeljar-fat.jar
```

---

##  Explicación del Diseño

Como adicional para hacerlo más visual, lo que hice fue que al momento de usar el método `addSong` agregué un output donde dice las canciones que se agregaron y en qué orden, para ver si funciona la prioridad. También dejé comentarios en el código para verificar si la lógica es buena o no.


---

##  Decisiones Técnicas

Lo que hice fue crear dos tipos de prioridades: `eliteSong` y `normalSong`. La canción que se tomará como prioridad la identifiqué con el valor `1` y la normal con el valor `2`. Al momento de crear la canción en `addSong` definí que debe especificarse cuál de las dos es.

---

##  Cómo Implementé la Prioridad en la Librería

Lo que hice fue verificar cómo se usaba la clase `enqueue` y me di cuenta de que debía hacer un método donde el nodo, que es nuestra entrada principal, se conectara a la cabeza y luego pudiera implementarlo como la nueva cabeza. En el handler definí que si el valor es `1` se trata de un `eliteSong` y se agrega a esa cola. Si es `2` se incluye a `normalSong`. Siempre puse que si `eliteSong` está vacía, que empiece a vaciar `normalSong`.

```java

if (!eliteSongQueue.isEmpty()) {
    currentSong = eliteSongQueue.dequeue();
} else {
    currentSong = normalSongQueue.dequeue();
}
```

---

##  Cómo Manejé la Simulación de Duración

Usé una barra de progreso visual. La manera en que manejé la simulación fue validando una variable con la duración de la canción, y cuando esa variable llegaba al mismo valor que la duración de la canción, se detuviera y siguiera con la siguiente canción, como una Playlist. También agregué `Thread.sleep()` para simular los segundos que pasan de manera realista.

