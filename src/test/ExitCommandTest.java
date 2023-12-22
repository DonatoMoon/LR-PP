package test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Compositions.*;
import Menu.Commands.*;

public class ExitCommandTest {

    @Test
    public void testExecute() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ExitCommand command = new ExitCommand();

        command.execute();

        System.setOut(System.out);

        assertEquals("Вихід...", outputStream.toString().trim());
    }
}