package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Compositions.*;
import Menu.Commands.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FindTrackCommandTest {

    @Test
    public void testExecuteWithMatchingQuery() {
        List<Composition> compositions = new ArrayList<>();
        compositions.add(new Composition("Composition 1", "Artist 1", 180, "Genre 1", 2021));
        compositions.add(new Composition("Composition 2", "Artist 2", 240, "Genre 2", 2022));

        FindTrackCommand command = new FindTrackCommand(compositions);

        ByteArrayInputStream inputStream = new ByteArrayInputStream("Composition 1".getBytes());
        System.setIn(inputStream);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        command.execute();

        System.setIn(System.in);
        System.setOut(System.out);

        assertEquals("Введіть назву або виконавця для пошуку:", outputStream.toString().trim());
    }

    @Test
    public void testExecuteWithNoMatchingQuery() {
        List<Composition> compositions = new ArrayList<>();
        compositions.add(new Composition("Composition 1", "Artist 1", 180, "Genre 1", 2021));
        compositions.add(new Composition("Composition 2", "Artist 2", 240, "Genre 2", 2022));

        FindTrackCommand command = new FindTrackCommand(compositions);

        ByteArrayInputStream inputStream = new ByteArrayInputStream("Composition 2".getBytes());
        System.setIn(inputStream);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        command.execute();

        System.setIn(System.in);
        System.setOut(System.out);

        assertEquals("Введіть назву або виконавця для пошуку:", outputStream.toString().trim());
    }
}