package Compositions;

public class Composition {
    private String title;
    private String artist;
    private int duration;
    private String genre;
    private int releaseYear;

    public Composition(String title, String artist, int duration, String genre, int releaseYear) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return releaseYear;
    }

    @Override
    public String toString() {
        return String.format("%-30s %-20s %-13d %-15s %-15s", title, artist, duration, genre, releaseYear);
    }

}