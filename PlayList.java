import java.util.ArrayList;
import java.util.Random;
public class PlayList{
    public static int MAX_NUMBER_SONGS = 6; // for easy testing
    private String listName; //This is the ‘name’ of your playList
    private ArrayList<Song> songs;
    private ArrayList<Integer> stars;//how many stars each song has
    private ArrayList<Song> copysong;
    private ArrayList<Integer> copystar;
    //Note: songs and stars are parallel ArrayLists
    public PlayList(String name){
        listName = name;
        songs = new ArrayList<Song>();
        stars = new ArrayList<Integer>();
    }//There should be only 1 constructor that takes a parameter representing the name of the playList
    
    public double averageRating(){
        double sum = 0;
        for (int star : stars){
            sum += star;
        }
        return sum/stars.size();
    }// returns the average star rating for the  list
    public ArrayList<Song> getSongs(){
        return songs;
    }// returns the songs
    public double averageRating(Artist artist){
        double sum = 0;
        double counter = 0;
        for (int i = 0 ; i < songs.size(); i++){
            if (songs.get(i).getArtist().equals(artist)){
                sum += stars.get(i);
                counter++;
            }
        }
        if(counter == 0){
            return 0;
        }
        return sum / counter;
    }// returns the mean star rating associated with artist
    public Song[] getSongs(Artist artist){
        int counter = 0;
        for(Song s : songs)
            if(s.getArtist().equals(artist))
                counter++;
        Song[] songarray = new Song[counter];
        int i = 0;
        for(Song s : songs){
            if(s.getArtist().equals(artist)){
                songarray[i] = s;
                i++;
            }
        }
        return songarray;
    }// returns an array populated by the songs of parameter artist
    public ArrayList<Artist> getArtist(String songName){
        ArrayList<Artist> artistlist = new ArrayList<Artist>();
        for(Song s : songs)
            if(s.getName().equals(songName))
            artistlist.add(s.getArtist());
        return artistlist;
    }// returns an ArrayList of all Artists associated with the String songName (This could be multiple musicians. Cover songs etc..)
    private int indexOf(Song someSong){
        for(int i = 0; i < songs.size(); i++)
            if(songs.get(i).equals(someSong))
            return i;
        return -1;
    }
    public String toString(){
        return "Playlist[listName: "+ listName+ ", Songs:  "+songs+ "]";
    }//returns an appropriate String representation of the PlayList
    
    
    public void swap(Song song1 ,  Song song2 ){
        int s1 = indexOf(song1);
        int s2 = indexOf(song2);
        int placeholder1 = stars.get(s2);
        songs.set(s2, song1);
        stars.set(s2, stars.get(s1));
        songs.set(s1, song2);
        stars.set(s1, placeholder1);
    }// switches positions of these two (maintain parallelism!)
    public boolean add(Song _song , int _stars){
        if(songs.size() < MAX_NUMBER_SONGS){
            songs.add(_song);
            return stars.add(_stars);
        }
        return false;
    }//adds data if number of song is less than MAX_NUMBER_SONGS
    public void removeSong(Song song){
        for(int i = 0 ; i < songs.size(); i++){
            if(songs.get(i).equals(song)){
                songs.remove(i);
                stars.remove(i);
                i--;
            }
        }
    }//removes all occurrences of song by artist. There could be multiple instances of song
    public void removeArtist(Artist artist ){
        for(int i = 0 ; i < songs.size(); i++){
            if(songs.get(i).getArtist().equals(artist)){
                songs.remove(i);
                stars.remove(i);
                i--;
            }
        }
    }//removes all elements associated with artist
    public void removeLowStars(int cutOff){
        for(int i = 0 ; i < songs.size(); i++){
            if(stars.get(i) <= cutOff){
                stars.remove(i);
                songs.remove(i);
                i--;
            }
        }
    }//removes all elements associated with a star rating less than cutOff

    public ArrayList<Integer> getStars(){
        return stars;
    }  //returns the stars  ArrayList
    
    
    public PlayList sortByRating(){
        PlayList sorted = new PlayList("sorted");
        
        copysong = new ArrayList<Song>();
        for(Song copy:songs)
            copysong.add(copy);
            
        
        copystar = new ArrayList<Integer>();
        for(int copy:stars)
            copystar.add(copy); 
            
        for(int j = 0 ; j < copystar.size()-1; j++){
            int base = j;
            int max = j;
            for(int i = j+1 ; i < copystar.size(); i++){
                if(copystar.get(max) < copystar.get(i)){
                    max = i;
                }
            }
            swaplocation(base,max);
            
        }
        
        for(int i = 0; i < songs.size(); i++){
            sorted.add(copysong.get(i),copystar.get(i));
        }
        return sorted;
    }
    public void swaplocation(int place1 ,  int place2 ){
        int placeholder1 = copystar.get(place1);
        Song placeholder2 = copysong.get(place1);
        int position = place2;
        copystar.set(place1, copystar.get(place2));
        copystar.set(position, placeholder1);
        copysong.set(place1, copysong.get(place2));
        copysong.set(position, placeholder2);
    }//different from swap, im swapping by index.
    
    public PlayList shuffle(){
        PlayList shuffled = new PlayList("shuffled");
        copysong = new ArrayList<Song>();
        for(Song copy:songs)
            copysong.add(copy);
        ArrayList<Song> shuffledsong = new ArrayList<Song>(); 
        
        copystar = new ArrayList<Integer>();
        for(int copy:stars)
            copystar.add(copy);
        ArrayList<Integer> shuffledstar = new ArrayList<Integer>();
        
        
        int length = copystar.size();
        Random rand = new Random();
        for(int i = 0 ; i < length; i++ ){
            int random = rand.nextInt(length-i);
            shuffledsong.add(copysong.get(random));
            copysong.remove(random);
            shuffledstar.add(copystar.get(random));
            copystar.remove(random);
        }
        
        for(int i = 0; i < shuffledsong.size(); i++){
            shuffled.add(shuffledsong.get(i),shuffledstar.get(i));
        }
        return shuffled;
    }
}