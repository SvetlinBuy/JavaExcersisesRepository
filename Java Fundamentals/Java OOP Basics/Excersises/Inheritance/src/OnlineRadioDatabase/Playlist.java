package OnlineRadioDatabase;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private List<Song> playlist;
    private long totalSeconds = 0;

    public Playlist() {
        this.playlist = new ArrayList<>();
    }

    public void addSong(Song song){

        int hours = Integer.parseInt(song.getSongLength().split(":")[0]);
        int seconds = 0;

        if(song.getSongLength().split(":").length == 2){
            seconds = Integer.parseInt(song.getSongLength().split(":")[1]);
        }

        this.playlist.add(song);
        this.totalSeconds += hours * 60 + seconds;

        System.out.println("Song added.");

    }

    private String getPlayListLengh(){


        long hours = totalSeconds / 60 / 60;
        long minutes = (totalSeconds / 60) - (hours * 60);
        long seconds = totalSeconds % 60;

        return hours + "h " + minutes +"m " + seconds + "s";

    }


    @Override
    public String toString() {
        return "Songs added: " + playlist.size()
                + "\nPlaylist length: " + getPlayListLengh();
    }


}
