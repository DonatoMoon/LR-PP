package test;
import Menu.Menu;
import Compositions.Composition;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class MainTest {

    @Test
    public void testMain() {
        List<Composition> compositions = new ArrayList<>();
        compositions.add(new Composition("Title1", "Artist1", 120, "Genre1", 2021));
        compositions.add(new Composition("Title2", "Artist2", 180, "Genre2", 2022));

        Menu menu = new Menu(compositions);

        menu.setupCommands();
    }
}