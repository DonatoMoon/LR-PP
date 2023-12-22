package test;
import Compositions.Composition;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompositionTest {

    @Test
    public void testGetTitle() {
        Composition composition = new Composition("Title", "Artist", 120, "Genre", 2021);
        assertEquals("Title", composition.getTitle());
    }

    @Test
    public void testGetArtist() {
        Composition composition = new Composition("Title", "Artist", 120, "Genre", 2021);
        assertEquals("Artist", composition.getArtist());
    }

    @Test
    public void testGetDuration() {
        Composition composition = new Composition("Title", "Artist", 120, "Genre", 2021);
        assertEquals(120, composition.getDuration());
    }

    @Test
    public void testGetGenre() {
        Composition composition = new Composition("Title", "Artist", 120, "Genre", 2021);
        assertEquals("Genre", composition.getGenre());
    }

    @Test
    public void testGetYear() {
        Composition composition = new Composition("Title", "Artist", 120, "Genre", 2021);
        assertEquals(2021, composition.getYear());
    }

    @Test
    public void testSetTitle() {
        Composition composition = new Composition("Title", "Artist", 120, "Genre", 2021);
        composition.setTitle("New Title");
        assertEquals("New Title", composition.getTitle());
    }

    @Test
    public void testSetArtist() {
        Composition composition = new Composition("Title", "Artist", 120, "Genre", 2021);
        composition.setArtist("New Artist");
        assertEquals("New Artist", composition.getArtist());
    }

    @Test
    public void testSetDuration() {
        Composition composition = new Composition("Title", "Artist", 120, "Genre", 2021);
        composition.setDuration(180);
        assertEquals(180, composition.getDuration());
    }

    @Test
    public void testSetGenre() {
        Composition composition = new Composition("Title", "Artist", 120, "Genre", 2021);
        composition.setGenre("New Genre");
        assertEquals("New Genre", composition.getGenre());
    }

    @Test
    public void testSetReleaseYear() {
        Composition composition = new Composition("Title", "Artist", 120, "Genre", 2021);
        composition.setReleaseYear(2022);
        assertEquals(2022, composition.getYear());
    }

    @Test
    public void testToString() {
        Composition composition = new Composition("Title", "Artist", 120, "Genre", 2021);
        String expected = "Title                          Artist               120           Genre           2021           ";
        assertEquals(expected, composition.toString());
    }
}