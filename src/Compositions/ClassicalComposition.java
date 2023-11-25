package Compositions;

public class ClassicalComposition extends Composition {
    private String period;
    private String compositionType;

    public ClassicalComposition(String title, String artist, int duration, String genre, int releaseYear, String period, String compositionType) {
        super(title, artist, duration, genre, releaseYear);
        this.period = period;
        this.compositionType = compositionType;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getCompositionType() {
        return compositionType;
    }

    public void setCompositionType(String compositionType) {
        this.compositionType = compositionType;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %-15s %-15s", period, compositionType);
    }
}
