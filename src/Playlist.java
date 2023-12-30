import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Playlist implements TrackActions,AlbumActions{
    protected String title;
    protected int numTracks;
    protected int numAlbums;
    protected ArrayList<Track> tracks;
    protected ArrayList<Album> albums;

    public Playlist(String title, int numTracks, int numAlbums) {
        this.title = title;
        this.numTracks = numTracks;
        this.numAlbums = numAlbums;
        this.tracks = new ArrayList<>();
        this.albums = new ArrayList<>();
    }

    public Playlist(Playlist other){
        this.title = other.title;
        this.numTracks = other.numTracks;
        this.tracks = other.tracks;
        this.numAlbums = other.numAlbums;
        this.albums = other.albums;
    }

    public Playlist(){}

    public void addTrack(Track track) {
        tracks.add(track);
    }

    public void setTracks(ArrayList<Track> newTracks) {
        tracks = newTracks;
    }

    public void deleteTrack() {
        Scanner scanner = new Scanner(System.in);
        while (true){

            try{
                System.out.println("Введите номер трека, который хотите удалить:");
                int number = scanner.nextInt();
                if (number < 1 || number > tracks.size()){
                    throw new IndexOutOfBoundsException("Некорректный номер трека");
                }
                this.tracks.remove(number - 1);
                break;
            }

            catch (IndexOutOfBoundsException e) {
                System.err.println("Ошибка удаления трека: " + e.getMessage());
            }

        }
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }

    public void setAlbums(ArrayList<Album> newAlbums) {
        albums = newAlbums;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nИнформация о плейлисте:\n");
        stringBuilder.append("Название: ").append(title).append("\n");
        stringBuilder.append("Кол-во треков: ").append(numTracks).append("\n");
        stringBuilder.append("Кол-во альбомов: ").append(numAlbums).append("\n");
        stringBuilder.append("Треки: \n");
        for (Track track : tracks){
            stringBuilder.append(track.toString()).append("\n");
        }
        stringBuilder.append("Альбомы: \n");
        for (Album album : albums) {
            stringBuilder.append(album.toString()).append("\n");
        }

        return stringBuilder.toString();
    }

    public void deleteAlbum() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Введите номер альбома, котоырй хотите удалить: ");
                int number = scanner.nextInt();
                if (number < 1 || number > albums.size()){
                    throw new IndexOutOfBoundsException("Некорректный номер альбома");
                }
                albums.remove(number - 1);
                break;
            }
            catch (IndexOutOfBoundsException e) {
                System.err.println("Ошибка удаления альбома: " + e.getMessage());
            }
        }
    }

    public void sortingByListens() {
        Collections.sort(tracks, (a, b) -> Integer.compare(b.getListens(), a.getListens()));
    }

    public void findTrackByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название трека для поиска: ");
        String trackToFind = scanner.nextLine();

        boolean found = false;
        for (Track track : tracks) {
            if (track.getTitle().equals(trackToFind)) {
                System.out.println("Трек найден: " + track.toString());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Трек не найден.");
        }
    }
}