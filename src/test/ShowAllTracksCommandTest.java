package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Compositions.*;
import Menu.Commands.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ShowAllTracksCommandTest {

    @Test
    void testExecuteWithEmptyList() {
        List<Composition> compositions = Collections.emptyList();
        ShowAllTracksCommand command = new ShowAllTracksCommand(compositions);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        command.execute();

        String expectedOutput = "Список композицій порожній.\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testExecuteWithNonEmptyList() {
        List<Composition> compositions = Arrays.asList(
                new Composition("Composition 1", "Artist 1", 180, "Genre 1", 2021),
                new Composition("Composition 2", "Artist 2", 300, "Genre 2", 2022)
        );
        ShowAllTracksCommand command = new ShowAllTracksCommand(compositions);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        command.execute();

        String expectedOutput = String.format(
                "%-30s %-20s %-13s %-15s %-15s\n----------------------------------------------------------------------------------------------\n%s\n%s\n",
                "Назва", "Виконавець", "Тривалість", "Жанр", "Рік випуску",
                compositions.get(0).toString(),
                compositions.get(1).toString()
        );
        assertEquals(expectedOutput, outContent.toString());
    }
}