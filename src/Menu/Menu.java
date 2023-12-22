package Menu;
import java.util.logging.Logger;
import Menu.Commands.*;
import Compositions.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private final Map<String, Command> commands = new HashMap<>();
    private static final Logger logger = Logger.getLogger(Menu.class.getName());
    private final List<Composition> compositions;
    public Menu(List<Composition> compositions) {
        this.compositions = compositions;
    }
    public void setupCommands() {
        commands.put("1", new LoadTracksCommand(compositions));
        commands.put("2", new ShowAllTracksCommand(compositions));
        commands.put("3", new CalculateDurationCommand(compositions));
        commands.put("4", new PermutationCommand(compositions));
        commands.put("5", new FilterTracksCommand(compositions));
        commands.put("6", new FindTrackCommand(compositions));
        commands.put("7", new DeleteTrackCommand(compositions));
        commands.put("0", new ExitCommand());
    }

    public void show() {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.println("\nMenu:");
            System.out.println("[1] Завантажити композиції на диск");
            System.out.println("[2] Показати усі композиції");
            System.out.println("[3] Підрахувати довжину усіх композицій");
            System.out.println("[4] Переставити композиції");
            System.out.println("[5] Відсортувати композиції");
            System.out.println("[6] Знайти трек");
            System.out.println("[7] Видалити трек");

            System.out.println("[0] Exit");
            System.out.print("Оберіть дію: ");
            input = scanner.nextLine();
            logger.info("Користувач обрав дію: " + input);
            Command command = commands.get(input);
            if (command != null) {
                command.execute();
            } else {
                System.out.println("Некоректна дія, спробуйте ще раз");
                logger.warning("Некоректна дія: " + input);
            }
        } while (!input.equals("0"));
    }
    public Map<String, Command> getCommands() {
        return commands;
    }
}
