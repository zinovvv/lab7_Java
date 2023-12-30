import java.util.ArrayList;

class MusicLibrary {
    private int numArtists;
    private int numPlaylists;
    private ArrayList<Artist> allArtists;
    private ArrayList<Playlist> allPlaylists;

    public MusicLibrary(int numArtists, int numPlaylists, ArrayList<Artist> artists, ArrayList<Playlist> playlists) {
        this.numArtists = numArtists;
        this.numPlaylists = numPlaylists;
        this.allArtists = artists;
        this.allPlaylists = playlists;
    }

    public MusicLibrary(MusicLibrary other){
        this.numArtists = other.numArtists;
        this.numPlaylists = other.numPlaylists;
        this.allArtists = other.allArtists;
        this.allPlaylists = other.allPlaylists;
    }

    public MusicLibrary() {}

    public void addArtist(Artist artist) {
        allArtists.add(artist);
    }

    public void addPlaylist(Playlist playlist) {
        allPlaylists.add(playlist);
    }

    public Artist getArtist(int index) {
        return allArtists.get(index);
    }

    public Playlist getPlaylist(int index) {
        return allPlaylists.get(index);
    }
}
