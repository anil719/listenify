package listenify;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String artist;
    private String albumName;
    private List<Song> songList;

    public Album(String albumName,String artist) {
        this.artist = artist;
        this.albumName = albumName;
        this.songList = new ArrayList<>();
    }

    public boolean findSong(String title){
        for(Song s : songList){
            if(s.title.equals(title)) return true;
        }
        return false;
    }
    public String addSongToAlbum(String title, double duration){
        if(findSong(title)) return "Song already present";

        Song newSong = new Song(title, duration);
        songList.add(newSong);
        return "Song has been added successfully";
    }
    public String addSongToPlaylist(int track, LinkedList<Song> playList){
        //check if track is valid or not
        // track -> 1,2,3,4,5, . . .
        // index -> 0,1,2,3,4, . . .
        int index = track-1;
        if(index >= 0 && index < playList.size()){
            Song currSong = songList.get(index);
            playList.add(currSong);
            return "Added to PlayList successfully";
        }
        return "Invalid Track Number" ;
    }
    public String addSongToPlaylist(String title, LinkedList<Song> playList){
        for(Song s : songList){
           if(s.title.equals(title)){
             playList.add(s);
                return "Added to PlayList successfully";
            }
        }

        Song news = new Song(title, 5.0);
        playList.add(news);

        return "Added to PlayList successfully";
    }
}
