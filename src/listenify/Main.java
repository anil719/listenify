package listenify;

import java.util.*;

public class Main {
   public static List<Album> albums = new ArrayList<>();
    public static void main(String[] args) {

        //System.out.println("Hello world!");
        Album album = new Album("RRR", "Keera vani" );
        album.addSongToAlbum("Komuram Bheemudo", 4.0);
        album.addSongToAlbum("Natu Natu", 5.0);
        album.addSongToAlbum("Dosti", 5.0);
        album.addSongToAlbum("Yettara jenda", 5.0);
        album.addSongToAlbum("Komma Uyyala", 3.0);
        albums.add(album);

        album = new Album("Veerayya", "chiru");
        album.addSongToAlbum("Boss Party", 4.0);
        album.addSongToAlbum("bale Banjara", 3.0);
        album.addSongToAlbum("Chala Kastam", 5.0);
        albums.add(album);

        LinkedList<Song> playList1 = new LinkedList<>();
        albums.get(0).addSongToPlaylist("Ravana",playList1);
        albums.get(0).addSongToPlaylist("Kodite Kottali", playList1);

        albums.get(1).addSongToPlaylist("Pranamam", playList1);
        albums.get(1).addSongToPlaylist("Pakka Local", playList1);

        //print the List that has been added
        play(playList1);
    }

    private static void play(LinkedList<Song> playList1) {

        if (playList1.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }
        ListIterator<Song> listIterator = playList1.listIterator();
        Scanner sc = new Scanner(System.in);
        printMenu();

        System.out.println("Now playing " + listIterator.next());

        boolean forward = true;

        boolean Quit = false;

        while(!Quit){
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 0 :            //stop looping
                Quit = true;
                break;

                case 1:     // play next Song
                    if(!forward){
                        listIterator.next();
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println(listIterator.next().toString());
                    }else {
                        System.out.println("You are at last Song");
                    }
                break;

                case 2:       //play previous song
                    if(forward){
                        listIterator.previous();
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println(listIterator.previous().toString());
                    }else{
                        System.out.println("You are at the First song");
                    }
                break;

                case 3:             //replay current song
                    if(forward){
                        System.out.println(listIterator.previous().toString());
                        forward = false;
                    }
                    else{
                        System.out.println(listIterator.next().toString());
                        forward = true;
                    }
                break;

                case 4:         //printAll Songs
                    printSongs(playList1);
                break;

                case 5:
                  printMenu();
                break;

                case 6:
                    //Delete a song
                    if (playList1.size() > 0)
                    {
                        System.out.println(listIterator.previous().toString() + " has been removed from the playlist.");
                        listIterator.remove();
                        if (playList1.size()>0 && listIterator.hasPrevious())
                        {
                            System.out.println("Now playing " + listIterator.previous().toString());
                        }
                        else if (playList1.size()>0 && listIterator.hasNext())
                        {
                            System.out.println("Now playing " + listIterator.next().toString());
                        }
                    } else
                    {
                        System.out.println("The playlist is already empty.");
                    }
                break;
            }
        }
    }

    private static void printSongs(LinkedList<Song> playList1) {
        ListIterator<Song> listIterator = playList1.listIterator();
        while(listIterator.hasNext()){
            System.out.println(listIterator.next().toString());
        }
    }

    private static void printMenu() {
        System.out.println("Show All Available Options\n Press");
        System.out.println("0 - to Quit\n" +
                           "1 - to play Next Song\n" +
                           "2 - to play Previous Song\n"+
                           "3 - to replay the current Song\n" +
                           "4 - to List of All Songs\n" +
                           "5 - print All Available Options\n"+
                           "6 - delete curr Song\n "
                            );
    }
}