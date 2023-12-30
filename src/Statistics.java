//Вспомогательный класс "Статистика"
import java.util.ArrayList;
import java.util.Scanner;
public class Statistics {
    //Метод для определения кол-ва прослушиваний самого популярного трека артиста
    public int listensMostPopularTrackArtist(Artist artist){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Album> albums = artist.getAlbums();
        int maxListens=0;
        for (Album album : albums) {
            ArrayList<Track> tracks = album.getTracks(); // Получаем треки в альбоме
            // Перебираем все треки в текущем альбоме
            for (Track track : tracks) {
                // Проверяем, является ли текущий трек более популярным
                if (track.getListens() > maxListens) {
                    maxListens = track.getListens();
                }
            }
        }
        return maxListens;
    }
}
