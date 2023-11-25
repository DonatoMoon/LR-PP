package Menu;

import Menu.Commands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private final Map<String, Command> commands = new HashMap<>();

    public void setupCommands() {
        commands.put("1", new LoadTracksCommand());
        commands.put("2", new ShowAllTracksCommand());
        commands.put("3", new CalculateDurationCommand());
        commands.put("4", new PermutationCommand());
        commands.put("5", new FilterTracksCommand());
        commands.put("6", new FindTrackCommand());
        commands.put("7", new DeleteTrackCommand());
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
            Command command = commands.get(input);
            if (command != null) {
                command.execute();
            } else {
                System.out.println("Некоректна дія, спробуйте ще раз");
            }
        } while (!input.equals("0"));
    }
}
