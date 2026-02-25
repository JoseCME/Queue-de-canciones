package reproductor;
import umg.edu.gt.data_structure.queue.Main;
import umg.edu.gt.data_structure.queue.manual.QueueLinked;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import model.Song;
public class PlaylistService {
	 
	private QueueLinked<Song> eliteSong = new QueueLinked<>();
	private QueueLinked<Song> normalSong = new QueueLinked<>();
	private static final Logger logger = LogManager.getLogger(Main.class);
	private int totalSongsPlayed = 0;
	
	
	public void addSong(Song song) {
		
	if (song.getPriority() == 1) {
		eliteSong.enqueue(song);
		}else {
			normalSong.enqueue(song);
		}
	
	String titulo = song.getTitle();
	String cantante = song.getArtist();
		
	logger.info("Agregando la cancion "+ titulo + " de "+cantante);
		}		
	public void playAll() {
		
		logger.info("Iniciando...");
		int totalSecondsPlayed = 0; 
		while (!eliteSong.isEmpty() || !normalSong.isEmpty()) {
			Song current;
			if (!eliteSong.isEmpty()) {
			current = eliteSong.dequeue();
			}else{
				current = normalSong.dequeue();;		
			}
			logger.info("Estas escuchando: " + current.getTitle() +" ["+ current.getArtist()+"] "+"("+ current.getDuration() +"s)");
			for (int i = 1; i <= current.getDuration();i++) {
				int tamanioBarra = 10; 
	            int progreso = (i * tamanioBarra) / current.getDuration();
	            
	            String barra = "";
	            for (int j = 0; j < tamanioBarra; j++) {
	                if (j < progreso) {
	                    barra += "#"; // 
	                } else {
	                    barra += "-"; //
	                }
	            }
				
	            logger.info("Escuchando: " + current.getTitle() + " [" + barra + "] " + i + "s / " + current.getDuration() + "s");
				try {
					Thread.sleep(1000);
				}catch (InterruptedException e) {
			        logger.error("Reproducción interrumpida");
			  }
			
		    }
			totalSongsPlayed++;
			totalSecondsPlayed += current.getDuration();
			logger.info("Finalizo: " + current.getTitle());
			
			
		
			
		}	
		logger.info("finalizo...");
		logger.info("Tiempo total de reproducción: " + totalSecondsPlayed + " segundos");
	}
	 

	
}