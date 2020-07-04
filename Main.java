
import java.util.ArrayList;

public class Main
{

  public static void main(String[] args) {
    new Main() ;
  }
  
    public Main()
    {
    
    PlayList rockList = new PlayList("rock");
    // artists 
    Artist bonJovi = new Artist("Bon Jovi");
    Artist queen = new Artist("Queen");
    Artist coverArtist1 = new Artist("Squeeks McQuiggles");
    Artist rebeccaBlack = new Artist("Rebecca Black");

    Song rockYou = new Song(queen,"We Will Rock You");
    Song bitesDust = new Song(queen, "Another One Bites the Dust");
    Song livingOnPrayer = new Song( bonJovi, "Living on a Prayer");
    Song livingOnPrayer_cover = new Song(coverArtist1, livingOnPrayer.getName());
    Song loveBadName = new Song( bonJovi, "Give Love a Bad Name");
    Song fridayRB= new Song(rebeccaBlack, "Friday");

    rockList.add( livingOnPrayer, 4 );
    rockList.add( fridayRB, 1 );
    rockList.add( rockYou, 4);
    rockList.add(bitesDust, 2);
    rockList.add( livingOnPrayer_cover, 1 );
    rockList.add( loveBadName, 4 );


    System.out.println( rockList)  ;
    
/*extra credit testings*/
System.out.println(); 
System.out.println( "For sortByRating:");
System.out.println( "Original star order: " +rockList.getStars());

System.out.println( "Order after sortByRating: "+rockList.sortByRating().getStars());
System.out.println( "The actual songs are sorted accordingly as well: "+ rockList.sortByRating().getSongs());
System.out.println();
System.out.println("For shuffle:");
System.out.println("Below are 5 shuffled playlists visualized by its individual ratings (bc its shorter and easier to see that its random)");
System.out.println("shuffle 1:" + rockList.shuffle().getStars());
System.out.println("shuffle 2:" + rockList.shuffle().getStars());
System.out.println("shuffle 3:" + rockList.shuffle().getStars());
System.out.println("shuffle 4:" + rockList.shuffle().getStars());
System.out.println("shuffle 5:" + rockList.shuffle().getStars());
System.out.println();
/*
 * test playList's getSongs(Artist artist) method
 * */
Song[] bonJovisSongs= rockList.getSongs(bonJovi);

if( bonJovisSongs.length != 2)
    {
        System.out.println("playList's getSongs(Artist artist) failed test  I");

    }
else{
        System.out.println("playList's getSongs(Artist artist) passed test I");
}

if( bonJovisSongs[0].getName().equals(livingOnPrayer.getName()))
        System.out.println("playList's getSongs(Artist artist) passed test II");
else
    {
        System.out.println("playList's getSongs(Artist artist) failed test  II");

    }
        

if(Math.abs(rockList.averageRating() - 2.6666666) < .0001 )      
    System.out.println("\t CONGRATS :  averageRating() seems to work" );    
else 
    System.out.println("\t ERROR :  averageRating() is not working " );    
        
    ArrayList<Song> allSongs = rockList.getSongs() ;
    
    System.out.println ("Total of " + rockList.getSongs().size() + " songs ");

    System.out.println("Originally , allSongs[0] : " + allSongs.get(0).getName() );
    System.out.println("Originally,  allSongs[1] : "+ allSongs.get(1).getName() );  
    rockList.swap(bitesDust, rockYou ); 
    int rating1_before =rockList.getStars().get(0);
    int rating2_before =rockList.getStars().get(1);

    allSongs = rockList.getSongs() ;
    System.out.println("Just called swap (" +allSongs.get(0).getName() +"," +allSongs.get(1).getName() +")") ;
    System.out.println("Now, allSongs[0] : " + allSongs.get(0).getName() );
    System.out.println("Now,  allSongs[1] : "+ allSongs.get(1).getName());  
    Song song1_now = allSongs.get(0);
    Song song2_now = allSongs.get(1);


    int rating1_now =rockList.getStars().get(0) ;
    int rating2_now =rockList.getStars().get(1) ;
    if(rating1_now != rating1_before)
        System.out.println("\t  ** ERROR** : You did not maintain parallel ArrayLists at swap" );   
    else
        System.out.println("\t CONGRATS :  Swap did maintain parellelism" );    

    if(rating2_now != rating2_before)
        System.out.println("\t\t  ** ERROR** : You did not maintain parallel ArrayLists at swap" ); 
    else
        System.out.println("\t CONGRATS :  Swap did maintain parellelism" );    

    //remove cover artist
    
    int priorSize = rockList.getSongs().size() ;
    int priorSize_stars = rockList.getStars().size() ;

       rockList.removeSong(livingOnPrayer_cover)  ;
     if (priorSize  != rockList.getSongs().size() +1     )
        System.out.println("\t\t  ** ERROR** : removeSong() didn't remove a song" ); 
    else
        System.out.println("\t CONGRATS :  removeSong() seems to work " );    
     if (priorSize_stars  != rockList.getStars().size() +1     )
        System.out.println("\t\t  ** ERROR** : removeSong() didn't maintain parallelism" ); 
    else
        System.out.println("\t CONGRATS :  removeSong() did  maintain parallelism" );    

  

//add cover song back in 
    
    rockList.add( livingOnPrayer_cover, 1 );


    System.out.println("remove songs whose rating is 2 or lower");
    rockList.removeLowStars(2);
    System.out.println( rockList)  ;
 if(rockList.getSongs().size()  == 3)    
    {
        System.out.println("playList's removeLowStars() passed test I");
    }
    else
    {
        System.out.println("playList's removeLowStars() failed test I");
    }

 if(Math.abs(rockList.averageRating() - 4.000) < .0001 )     
    {
        System.out.println("playList's removeLowStars() passed test II");
    }
    else
    {
        System.out.println("playList's removeLowStars() failed test II");
    }



}//end of Main()

    
}
