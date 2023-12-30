
import java.util.ArrayList;
import java.util.Scanner;

public class Album extends DisplayItem implements TrackActions,Cloneable{
    private String title;
    private String artist;
    private int year;
    private int numTracks;
    private ArrayList<Track> tracks;

    // Конструктор с параметрами
    public Album(String title, String artist, int year, int numTracks, ArrayList<Track> tracks) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.numTracks = numTracks;
        this.tracks = tracks;
    }

    // Конструктор копирования
    public Album(Album other) {
        this.title = other.title;
        this.artist = other.artist;
        this.year = other.year;
        this.numTracks = other.numTracks;
        this.tracks = other.tracks;
    }

    // Пустой конструктор
    public Album() {
    }

    // Ввод альбома с консоли
    public static Album inputAlbum() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Название альбома: ");
        String title = scanner.nextLine();

        System.out.print("Исполнитель: ");
        String artist = scanner.nextLine();

        System.out.print("Год выпуска альбома: ");
        int year = scanner.nextInt();

        System.out.print("Количество треков в альбоме: ");
        int numTracks = scanner.nextInt();

        ArrayList<Track> tracks = new ArrayList<>();
        for (int i = 0; i < numTracks; i++) {
            System.out.println("Введите информацию о треке #" + (i + 1));
            Track track = Track.InputShortTrack();
            tracks.add(track);
        }

        return new Album(title, artist, year, numTracks, tracks);
    }

    // Установка списка треков
    public void setTracks(ArrayList<Track> newTracks) {
        tracks = newTracks;
    }

    public void addTrack(Track track){
        tracks.add(track);
    }

    public void deleteTrack(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Введите номер трека, который хотите удалить:");
                int number = scanner.nextInt();

                if (number < 1 || number > tracks.size()) {
                    throw new IndexOutOfBoundsException("Некорректный номер трека");
                }

                tracks.remove(number - 1);
                break;
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Ошибка удаления трека: " + e.getMessage());
            }
        }
    }
    // Вывод альбома
    @Override
    public void DisplayInfo() {
        System.out.println("\nНазвание: " + title);
        System.out.println("Исполнитель: " + artist);
        System.out.println("Год выпуска: " + year);
        System.out.println("Количество треков: " + numTracks);

        for (Track track : tracks) {
            track.OutputShortTrack();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Информация об альбоме:\n");
        stringBuilder.append("Название: ").append(title).append("\n");
        stringBuilder.append("Исполнитель: ").append(artist).append("\n");
        stringBuilder.append("Год выпуска: ").append(year).append("\n");
        stringBuilder.append("Кол-во треков: ").append(numTracks).append("\n");
        for (Track track : tracks) {
            stringBuilder.append(track.toString()).append("\n");
        }
        return stringBuilder.toString();
    }


    public ArrayList<Track> getTracks(){
        return tracks;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return (Album) super.clone();
    }

    public Album deepClone() throws CloneNotSupportedException {
        Album cloned = (Album) super.clone();
        cloned.tracks = new ArrayList<>();
        for (Track track : this.tracks) {
            cloned.tracks.add((Track) track.clone());
        }
        return cloned;
    }
}
