package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import Compositions.*;
import Menu.Commands.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PermutationCommandTest {

    @Test
    public void testExecuteWithValidCompositions() {
        List<Composition> compositions = new ArrayList<>();
        compositions.add(new Composition("Composition 1", "Artist 1", 180, "Genre 1", 2021));
        compositions.add(new Composition("Composition 2", "Artist 2", 240, "Genre 2", 2022));
        compositions.add(new Composition("Composition 3", "Artist 3", 300, "Genre 3", 2023));


        PermutationCommand command = new PermutationCommand(compositions);

        String input = "Composition 1\nComposition 3\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        command.execute();

        System.setIn(System.in);
        System.setOut(System.out);

        assertEquals("Введіть назву першої композиції: Введіть назву другої композиції: Перестановка відбулася успішно.", outputStream.toString().trim());

        assertEquals("Composition 3", compositions.get(0).getTitle());
        assertEquals("Composition 2", compositions.get(1).getTitle());
        assertEquals("Composition 1", compositions.get(2).getTitle());
    }

    @Test
    public void testExecuteWithInvalidCompositions() {
        List<Composition> compositions = new ArrayList<>();
        compositions.add(new Composition("Composition 1", "Artist 1", 180, "Genre 1", 2021));
        compositions.add(new Composition("Composition 2", "Artist 2", 240, "Genre 2", 2022));
        compositions.add(new Composition("Composition 3", "Artist 3", 300, "Genre 3", 2023));


        PermutationCommand command = new PermutationCommand(compositions);

        String input = "Composition 1\nInvalid Composition\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        command.execute();

        System.setIn(System.in);
        System.setOut(System.out);

        assertEquals("Введіть назву першої композиції: Введіть назву другої композиції: Не вдалося знайти обидві композиції.", outputStream.toString().trim());

        assertEquals("Composition 1", compositions.get(0).getTitle());
        assertEquals("Composition 2", compositions.get(1).getTitle());
        assertEquals("Composition 3", compositions.get(2).getTitle());
    }
}