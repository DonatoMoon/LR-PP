package Compositions;

public class PopComposition extends Composition {
    private boolean isDanceOriented;
    private String predominantInstrument;

    public PopComposition(String title, String artist, int duration, String genre, int releaseYear, boolean isDanceOriented, String predominantInstrument) {
        super(title, artist, duration, genre, releaseYear);
        this.isDanceOriented = isDanceOriented;
        this.predominantInstrument = predominantInstrument;
    }

    public boolean isDanceOriented() {
        return isDanceOriented;
    }

    public void setDanceOriented(boolean isDanceOriented) {
        this.isDanceOriented = isDanceOriented;
    }

    public String getPredominantInstrument() {
        return predominantInstrument;
    }

    public void setPredominantInstrument(String predominantInstrument) {
        this.predominantInstrument = predominantInstrument;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %-10b %-20s", isDanceOriented, predominantInstrument);
    }
}
