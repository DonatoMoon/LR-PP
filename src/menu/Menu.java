package menu;

import command.Command;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private final Map<Integer, Command> commands = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    public void addCommand(int number, String description, Command command) {
        System.out.println(number + ". " + description);
        commands.put(number, command);
    }

    public void executeCommand() {
        System.out.print("Виберіть опцію: ");
        int choice = scanner.nextInt();
        Command command = commands.get(choice);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Неправильна опція. Будь ласка, спробуйте ще раз.");
        }
    }
}