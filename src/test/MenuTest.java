package test;

import Menu.Commands.*;
import Compositions.Composition;
import Menu.Menu;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;


public class MenuTest {

    @Test
    public void testSetupCommands() {
        List<Composition> compositions = new ArrayList<>();
        compositions.add(new Composition("Title1", "Artist1", 120, "Genre1", 2021));
        compositions.add(new Composition("Title2", "Artist2", 180, "Genre2", 2022));

        Menu menu = new Menu(compositions);

        menu.setupCommands();

        Map<String, Command> commands = menu.getCommands();
        assertNotNull(commands);
        assertEquals(8, commands.size()); // Assuming you have 8 commands in total

        assertTrue(commands.get("1") instanceof LoadTracksCommand);
        assertTrue(commands.get("2") instanceof ShowAllTracksCommand);
        assertTrue(commands.get("3") instanceof CalculateDurationCommand);
        assertTrue(commands.get("4") instanceof PermutationCommand);
        assertTrue(commands.get("5") instanceof FilterTracksCommand);
        assertTrue(commands.get("6") instanceof FindTrackCommand);
        assertTrue(commands.get("7") instanceof DeleteTrackCommand);
        assertTrue(commands.get("0") instanceof ExitCommand);
    }

}