package Menu.Commands;

import Compositions.*;
import java.util.List;

public class ShowAllTracksCommand implements Command {
    private final List<Composition> compositions;

    public ShowAllTracksCommand(List<Composition> compositions) {
        this.compositions = compositions;
    }

    @Override
    public void execute() {
        if (compositions.isEmpty()) {
            System.out.println("Список композицій порожній.");
            return;
        }
        System.out.printf("%-30s %-20s %-13s %-15s %-15s\n", "Назва", "Виконавець", "Тривалість", "Жанр", "Рік випуску");
        System.out.println("----------------------------------------------------------------------------------------------");
        for (Composition comp : compositions) {
            System.out.println(comp);
        }
    }
}
