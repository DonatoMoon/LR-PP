package Menu.Commands;

import Compositions.*;
import java.util.List;
import java.util.Scanner;

public class FindTrackCommand implements Command {
    private final List<Composition> compositions;
    public FindTrackCommand(List<Composition> compositions) {
        this.compositions = compositions;
    }
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть назву або виконавця для пошуку: ");
        String query = scanner.nextLine();
        compositions.stream()
                .filter(comp -> comp.getTitle().equalsIgnoreCase(query) || comp.getArtist().equalsIgnoreCase(query))
                .forEach(System.out::println);
    }
}
