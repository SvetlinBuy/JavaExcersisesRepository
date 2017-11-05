package OnlineRadioDatabase;

public class Song {

    private String artistName;
    private String songName;
    private String songLength;
    private int songMinutes;
    private int songSeconds;

    public Song(String artistName, String songName, String songLength) throws InvalidArtistNameException, InvalidSongNameException, InvalidSongLengthException {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setSongLength(songLength);
    }

    private void setArtistName(String artistName) throws InvalidArtistNameException {

        if (artistName.length() < 3 || artistName.length() > 20) {

            throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }

        this.artistName = artistName;
    }

    private void setSongName(String songName) throws InvalidSongNameException {

        if (songName.length() < 3 || songName.length() > 30) {
            throw new InvalidSongNameException("Song name should be between 3 and 30 symbols.");
        }
        this.songName = songName;
    }

    private void setSongLength(String songLength) throws InvalidSongLengthException {

        String[] lengthTokens = songLength.split(":");
        int minutes;
        int seconds;
        try {
            minutes = Integer.valueOf(lengthTokens[0]);
            seconds = Integer.valueOf(lengthTokens[1]);
        } catch (Exception e) {
            throw new InvalidSongLengthException("Invalid song length.");
        }

        this.setSongMinutes(minutes);
        this.setSongSeconds(seconds);
        this.songLength = songLength;

    }

    private void setSongMinutes(int songMinutes) throws InvalidSongMinutesException {

        if(songMinutes < 0 || songMinutes > 14){

            throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
        }

        this.songMinutes = songMinutes;
    }

    private void setSongSeconds(int songSeconds) throws InvalidSongSecondsException {

        if(songSeconds < 0 || songSeconds > 59){
            throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
        }

        this.songSeconds = songSeconds;
    }

    protected String getSongLength() {
        return songLength;
    }
}
