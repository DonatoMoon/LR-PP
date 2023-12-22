package test;

import Compositions.PopComposition;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PopCompositionTest {

    @Test
    public void testIsDanceOriented() {
        PopComposition composition = new PopComposition("Title", "Artist", 180, "Genre", 2021, true, "Guitar");

        boolean isDanceOriented = composition.isDanceOriented();

        assertTrue(isDanceOriented);
    }

    @Test
    public void testSetDanceOriented() {
        PopComposition composition = new PopComposition("Title", "Artist", 180, "Genre", 2021, true, "Guitar");

        composition.setDanceOriented(false);

        boolean isDanceOriented = composition.isDanceOriented();

        assertFalse(isDanceOriented);
    }

    @Test
    public void testGetPredominantInstrument() {
        PopComposition composition = new PopComposition("Title", "Artist", 180, "Genre", 2021, true, "Guitar");

        String predominantInstrument = composition.getPredominantInstrument();

        assertEquals("Guitar", predominantInstrument);
    }

    @Test
    public void testSetPredominantInstrument() {
        PopComposition composition = new PopComposition("Title", "Artist", 180, "Genre", 2021, true, "Guitar");

        composition.setPredominantInstrument("Piano");

        String predominantInstrument = composition.getPredominantInstrument();

        assertEquals("Piano", predominantInstrument);
    }

    @Test
    public void testToString() {
        PopComposition composition = new PopComposition("Title", "Artist", 180, "Genre", 2021, true, "Guitar");

        String compositionString = composition.toString();

        String expectedString = "Title                          Artist               180           Genre           2021            true       Guitar              ";
        assertEquals(expectedString, compositionString);
    }
}