package Compositions;

public class RockComposition extends Composition {
    private String subgenre;
    private boolean isAcoustic;

    public RockComposition(String title, String artist, int duration, String genre, int releaseYear, String subgenre, boolean isAcoustic) {
        super(title, artist, duration, genre, releaseYear);
        this.subgenre = subgenre;
        this.isAcoustic = isAcoustic;
    }

    public String getSubgenre() {
        return subgenre;
    }

    public void setSubgenre(String subgenre) {
        this.subgenre = subgenre;
    }

    public boolean isAcoustic() {
        return isAcoustic;
    }

    public void setAcoustic(boolean isAcoustic) {
        this.isAcoustic = isAcoustic;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %-15s %-10b", subgenre, isAcoustic);
    }
}
