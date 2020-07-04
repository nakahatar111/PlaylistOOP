public class Song
{
    private Artist artist;
    private String name;
    public Song( Artist _artist, String _name){
        artist = _artist;
        name = _name;
    }
    public String getName(){
        return name;
    }
    public Artist getArtist(){
        return artist;
    }
    public boolean equals(Song other){
        return name.equals(other.name) && artist.equals(other.artist);
    }//returns true if both the song objects have the same artist and name.
    public String toString(){
        return "Song[Name : " + name + "Artist : " + artist+ "]";
    }
}