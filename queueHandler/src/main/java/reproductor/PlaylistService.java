package reproductor;

import umg.edu.gt.data_structure.queue.manual.QueueLinked;
import model.Song;

public class PlaylistService {

    private QueueLinked<Song> eliteSong = new QueueLinked<>();
    private QueueLinked<Song> normalSong = new QueueLinked<>();

    private int totalSongsPlayed = 0;

    public void addSong(Song song) {

        if (song.getPriority() == 1) {
            eliteSong.enqueue(song);
        } else {
            normalSong.enqueue(song);
        }

        String titulo = song.getTitle();
        String cantante = song.getArtist();

        System.out.println("Agregando la cancion " + titulo + " de " + cantante);
    }

    public void playAll() {

        System.out.println("Iniciando...");
        int totalSecondsPlayed = 0;

        while (!eliteSong.isEmpty() || !normalSong.isEmpty()) {

            Song current;

            if (!eliteSong.isEmpty()) {
                current = eliteSong.dequeue();
            } else {
                current = normalSong.dequeue();
            }

            System.out.println("Estas escuchando: " + current.getTitle() +
                    " [" + current.getArtist() + "] (" +
                    current.getDuration() + "s)");

            for (int i = 1; i <= current.getDuration(); i++) {

                int tamanioBarra = 10;
                int progreso = (i * tamanioBarra) / current.getDuration();

                String barra = "";

                for (int j = 0; j < tamanioBarra; j++) {
                    if (j < progreso) {
                        barra += "#";
                    } else {
                        barra += "-";
                    }
                }

                System.out.println("Escuchando: " + current.getTitle() +
                        " [" + barra + "] " +
                        i + "s / " + current.getDuration() + "s");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Reproducción interrumpida");
                }
            }

            totalSongsPlayed++;
            totalSecondsPlayed += current.getDuration();

            System.out.println("Finalizo: " + current.getTitle());
        }

        System.out.println("Finalizo la reproduccion");
        System.out.println("Tiempo total: " + totalSecondsPlayed + " segundos");
        System.out.println("Total de canciones: " + totalSongsPlayed);
    }
}