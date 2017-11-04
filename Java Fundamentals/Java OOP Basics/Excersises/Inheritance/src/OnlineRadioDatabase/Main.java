package OnlineRadioDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(reader.readLine());

        Playlist playlist = new Playlist();

        for (int i = 0; i < n; i++) {

            String[] newSong = reader.readLine().split(";");
            try {
                Song song = new Song(newSong[0], newSong[1], newSong[2]);
                playlist.addSong(song);
            } catch (InvalidSongException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(playlist.toString());
    }

}
