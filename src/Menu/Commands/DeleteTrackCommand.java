package Menu.Commands;

import Compositions.*;
import java.util.List;
import java.util.Scanner;

public class DeleteTrackCommand implements Command {
    private final List<Composition> compositions;
    public DeleteTrackCommand(List<Composition> compositions) {
        this.compositions = compositions;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть назву композиції для видалення: ");
        String title = scanner.nextLine();
        compositions.removeIf(comp -> comp.getTitle().equalsIgnoreCase(title));
        System.out.println("Композицію видалено.");
    }
}
