package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Compositions.*;
import Menu.Commands.*;

public class DeleteTrackCommandTest {

    @Test
    public void testExecuteWithExistingTrack() {
        List<Composition> compositions = new ArrayList<>();
        compositions.add(new Composition("Composition 1", "Artist 1", 180, "Genre 1", 2021));
        compositions.add(new Composition("Composition 2", "Artist 2", 240, "Genre 2", 2022));

        DeleteTrackCommand command = new DeleteTrackCommand(compositions);

        ByteArrayInputStream inputStream = new ByteArrayInputStream("Composition 1".getBytes());
        System.setIn(inputStream);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        command.execute();

        System.setIn(System.in);
        System.setOut(System.out);

        assertEquals(1, compositions.size());
        assertEquals("Composition 2", compositions.get(0).getTitle());
    }

    @Test
    public void testExecuteWithNonExistingTrack() {
        List<Composition> compositions = new ArrayList<>();
        compositions.add(new Composition("Composition 1", "Artist 1", 180, "Genre 1", 2021));
        compositions.add(new Composition("Composition 2", "Artist 2", 240, "Genre 2", 2022));

        DeleteTrackCommand command = new DeleteTrackCommand(compositions);

        ByteArrayInputStream inputStream = new ByteArrayInputStream("Composition 3".getBytes());
        System.setIn(inputStream);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        command.execute();

        System.setIn(System.in);
        System.setOut(System.out);

        assertEquals(2, compositions.size());
    }
}