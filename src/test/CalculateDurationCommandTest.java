package test;
import Compositions.*;
import Menu.Commands.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculateDurationCommandTest {

    @Test
    void testCalculateTotalDuration() {
        List<Composition> compositions = Arrays.asList(
                new Composition("Composition 1", "Artist 1", 180, "Genre 1", 2021),
                new Composition("Composition 2", "Artist 2", 18, "Genre 2", 2022),
                new Composition("Composition 3", "Artist 3", 1800, "Genre 3", 2023)
        );
        CalculateDurationCommand command = new CalculateDurationCommand(compositions);

        int expectedDuration = 1998; // Expected total duration
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        command.execute();

        String expectedOutput = "Загальна тривалість композицій: " + expectedDuration + " секунд";
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    void testCalculateDurationWithEmptyList() {
        CalculateDurationCommand command = new CalculateDurationCommand(Collections.emptyList());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        command.execute();

        String expectedOutput = "Загальна тривалість композицій: 0 секунд";
        assertEquals(expectedOutput, outContent.toString().trim());
    }
}
