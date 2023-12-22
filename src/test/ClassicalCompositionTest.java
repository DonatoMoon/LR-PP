package test;

import Compositions.ClassicalComposition;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClassicalCompositionTest {

    @Test
    public void testGetPeriod() {
        ClassicalComposition composition = new ClassicalComposition("Title", "Artist", 180, "Genre", 2021, "Baroque", "Concerto");

        String period = composition.getPeriod();

        assertEquals("Baroque", period);
    }

    @Test
    public void testSetPeriod() {
        ClassicalComposition composition = new ClassicalComposition("Title", "Artist", 180, "Genre", 2021, "Baroque", "Concerto");

        composition.setPeriod("Classical");

        String period = composition.getPeriod();

        assertEquals("Classical", period);
    }

    @Test
    public void testGetCompositionType() {
        ClassicalComposition composition = new ClassicalComposition("Title", "Artist", 180, "Genre", 2021, "Baroque", "Concerto");

        String compositionType = composition.getCompositionType();

        assertEquals("Concerto", compositionType);
    }

    @Test
    public void testSetCompositionType() {
        ClassicalComposition composition = new ClassicalComposition("Title", "Artist", 180, "Genre", 2021, "Baroque", "Concerto");

        composition.setCompositionType("Symphony");

        String compositionType = composition.getCompositionType();

        assertEquals("Symphony", compositionType);
    }

    @Test
    public void testToString() {
        ClassicalComposition composition = new ClassicalComposition("Title", "Artist", 180, "Genre", 2021, "Baroque", "Concerto");

        String compositionString = composition.toString();

        String expectedString = "Title                          Artist               180           Genre           2021            Baroque         Concerto       ";
        assertEquals(expectedString, compositionString);
    }
}