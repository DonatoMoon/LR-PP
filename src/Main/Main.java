package Main;

import Menu.Menu;

import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<Compositions.Composition> compositions = new ArrayList<>();
        Menu menu = new Menu(compositions);
        menu.setupCommands();
        menu.show();
    }
}
