import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException{

        Playlist myPlaylist = new Playlist("Любимые треки", 3, 2);
        ArrayList<Track> tracks = new ArrayList<>();
        tracks.add(new Track("Кукушка", "Виктор Цой", 400, 1986, "рок",12323900));
        tracks.add(new Track("Троянский конь", "ЛСП", 200, 2023, "поп хип-хоп",709831));
        tracks.add(new Track("Монополия", "ЛСП", 198, 2023, "поп хип-хоп",694312));
        tracks.add(new Track("Несчастные люди", "ЛСП", 210, 2023, "поп хип-хоп",902341));
        tracks.add(new Track("Вечная весна", "ЛСП", 195, 2023, "поп хип-хоп",1003123));
        tracks.add(new Track("Ураганы", "ЛСП", 189, 2023, "поп хип-хоп",1002492));
        tracks.add(new Track("Не убежал", "ЛСП", 240, 2023, "поп хип-хоп",1593283));
        tracks.add(new Track("Боди", "ЛСП", 200, 2023, "поп хип-хоп",1023949));
        tracks.add(new Track("Сикрет Плейс", "ЛСП", 203, 2023, "поп хип-хоп",2483921));
        tracks.add(new Track("Стоп Игра", "ЛСП", 240, 2023, "поп хип-хоп",724849));
        myPlaylist.setTracks(tracks);


        //Демонстрация работы программы


        //Создание плейлиста "Избранное"(Производный класс), в конструкторе вызывается конструктор базового класса
        Favorites favorites = new Favorites("Избранное", 3, 1);

        favorites.AddTrack(tracks.get(0));
        favorites.AddTrack(tracks.get(2));
        favorites.AddTrack(tracks.get(4));
        favorites.AddTrack(tracks.get(6));

        // Создаем вектор
        ArrayList<Playlist> playlists = new ArrayList<>();

        // Добавляем объекты в вектор
        playlists.add(myPlaylist);
        playlists.add(favorites);

        // Сортировка треков в плейлисте по прослушиваниям
        System.out.print("Плейлист 'Избранное' до сортировки\n");
        System.out.print(playlists.get(1).toString());
        playlists.get(1).sortingByListens();
        System.out.print("Плейлист 'Избранное' после сортировки по прослушиваниям по убыванию\n");
        System.out.print(playlists.get(1).toString());

        // Поиск трека в плейлисте
        playlists.get(0).findTrackByName();

    }
}