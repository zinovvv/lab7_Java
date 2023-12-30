import java.util.Scanner;
public class Track extends DisplayItem implements Cloneable{
    private String title;
    private String artist;
    private int duration;
    private int year;
    private String genre;

    private int listens;

    private static int trackCount;

    public Track(String title, String artist, int duration, int year, String genre, int listens){
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.year = year;
        this.genre = genre;
        this.listens = listens;
        ++trackCount;
    }

    public Track(Track other){
        this.title = other.title;
        this.artist = other.artist;
        this.duration = other.duration;
        this.year = other.year;
        this.genre = other.genre;
        this.listens = other.listens;
    }

    public Track(){}

    public static Track InputTrack(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Название трека: ");
        String title = scanner.nextLine();

        System.out.print("Исполнитель: ");
        String artist = scanner.nextLine();

        System.out.print("Жанр трека: ");
        String genre = scanner.nextLine();

        System.out.print("Продолжительность трека (в секундах): ");
        int duration = scanner.nextInt();

        System.out.print("Год выпуска трека: ");
        int year = scanner.nextInt();

        ++trackCount;

        return new Track(title, artist, duration, year, genre,0);
    }

    public static Track InputShortTrack(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Название трека: ");
        String title = scanner.nextLine();

        System.out.print("Жанр трека: ");
        String genre = scanner.nextLine();

        System.out.print("Продолжительность трека (в секундах): ");
        int duration = scanner.nextInt();

        ++trackCount;

        return new Track(title, "", duration, 0, genre,0);

    }

    @Override
    public void DisplayInfo(){
        System.out.println("\nНазвание: " + title);
        System.out.println("Исполнитель: " + artist);
        System.out.println("Продолжительность: " + duration + " секунд");
        System.out.println("Год выпуска: " + year);
        System.out.println("Жанр: " + genre);
    }

    @Override
    public String toString(){
        return "\nНазвание: " + title + "\nИсполнитель: " + artist +
                "\nПродолжительность: " + duration +
                "\nГод выпуска: " + year +
                "\nЖанр: " + genre +
                "\nКол-во прослушиваний: " + listens;
    }

    public void OutputShortTrack(){
        System.out.printf("%-25s Продолжительность: %d сек\tЖанр: %s\tКол-во прослушиваний: %d%n", title, duration, genre,listens);
    }

    public int getListens(){
        return listens;
    }

    public String getTitle(){ return title; }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return (Track) super.clone();
    }
}
