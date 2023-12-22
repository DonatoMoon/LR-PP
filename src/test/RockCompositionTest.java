package test;

import Compositions.RockComposition;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RockCompositionTest {

    @Test
    public void testGetSubgenre() {
        RockComposition composition = new RockComposition("Title", "Artist", 180, "Genre", 2021, "Classic Rock", true);

        String subgenre = composition.getSubgenre();

        assertEquals("Classic Rock", subgenre);
    }

    @Test
    public void testSetSubgenre() {
        RockComposition composition = new RockComposition("Title", "Artist", 180, "Genre", 2021, "Classic Rock", true);

        composition.setSubgenre("Alternative Rock");

        String subgenre = composition.getSubgenre();

        assertEquals("Alternative Rock", subgenre);
    }

    @Test
    public void testIsAcoustic() {
        RockComposition composition = new RockComposition("Title", "Artist", 180, "Genre", 2021, "Classic Rock", true);

        boolean isAcoustic = composition.isAcoustic();

        assertTrue(isAcoustic);
    }

    @Test
    public void testSetAcoustic() {
        RockComposition composition = new RockComposition("Title", "Artist", 180, "Genre", 2021, "Classic Rock", true);

        composition.setAcoustic(false);

        boolean isAcoustic = composition.isAcoustic();

        assertFalse(isAcoustic);
    }

    @Test
    public void testToString() {
        RockComposition composition = new RockComposition("Title", "Artist", 180, "Genre", 2021, "Classic Rock", true);

        String compositionString = composition.toString();

        String expectedString = "Title                          Artist               180           Genre           2021            Classic Rock    true      ";
        assertEquals(expectedString, compositionString);
    }
}