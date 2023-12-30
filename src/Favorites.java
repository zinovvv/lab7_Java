import java.util.ArrayList;
import java.util.Scanner;
class Favorites extends Playlist{
    Favorites(String title, int numTracks, int numAlbums){
        super(title, numTracks, numAlbums);
    }

    void AddTrack(Track track){
        tracks.add(track);
    }

    void CallBaseAddTrack(Track track){
        super.addTrack(track);
        System.out.println("Демонстрация перегрузки метода базового класса с вызовом его из производного класса");
    }
}
