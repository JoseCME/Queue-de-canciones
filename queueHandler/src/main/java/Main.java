import model.Song;
import reproductor.PlaylistService;

public class Main {

	public Main() {
		
	}

	public static void main(String[] args) {
		
		PlaylistService Playlist = new PlaylistService();
		Song s1 = new Song("Luna", "Peso Pluma", 5, 2);// cancion normal 5 segundos en cola
		Song s2 = new Song("Siento que merezco mas", "Latin Mafia", 4, 2);  //cancion normal 9 segundos en cola
		Song s3 = new Song("Querido amigo", "Paulo Londra", 7, 2); //cancion normal 16 segundos en cola
		Song s4 = new Song("Sinfonía No. 5 en do menor", "Ludwig van Beethoven,", 4, 1); //cancion alta 20 segundos en cola
		Playlist.addSong(s1); //Esta entra primero 
		// quedaria  como 1.Luna
		Playlist.addSong(s2);// Esta entra segundo 
		// quedaria  como 1.Luna 2.Siento que merezco mas
		Playlist.addSong(s3);  //Esta entra tercera 
		// quedaria  como 1.Luna 2.Siento que merezco mas 3.Querido amigo
		
		Playlist.addSong(s4); //esta sonaria de primero por la prioridad
		// quedaria  como 1.Sinfonía No. 5 2.Luna 3.Siento que merezco mas 4.Querido amigo
		
		Playlist.playAll();
		
	}

}
