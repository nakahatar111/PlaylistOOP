import java.util.ArrayList;
public class Artist{
    private String artistName;
    private ArrayList<Song> songs;
    public Artist(String name){
        songs = new ArrayList<Song>();
        artistName = name;
    }
    
    public void addSong(String song){
        songs.add(new Song(this, song));
    } //Create a song object (see above) and add it to the arraylist. Here’s the first line.  : add-song
    public String toString(){
        return "Artist[ArtistName : " + artistName + "Songs : " +songs+"]"; 
    }
    public boolean equals(Artist other){
        return artistName.equals(other.artistName);
    } //returns true if the names (only) are the same
    public ArrayList<Song> getSongs(){
        return songs;
    }
    public String getName(){
        return artistName;
    }
}