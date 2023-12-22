package Menu.Commands;

import Compositions.*;
import java.util.List;
import java.util.logging.Logger;

public class ShowAllTracksCommand implements Command {
    private final List<Composition> compositions;
    private static final Logger logger = Logger.getLogger(CalculateDurationCommand.class.getName());

    public ShowAllTracksCommand(List<Composition> compositions) {
        this.compositions = compositions;
    }

    @Override
    public void execute() {
        logger.info("Виконання команди відображення всіх треків");

        if (compositions.isEmpty()) {
            System.out.println("Список композицій порожній.");
            logger.warning("Список композицій порожній.");
            Logger.getLogger("MyLogger").severe("Список композицій порожній.");
            return;
        }
        System.out.printf("%-30s %-20s %-13s %-15s %-15s\n", "Назва", "Виконавець", "Тривалість", "Жанр", "Рік випуску");
        System.out.println("----------------------------------------------------------------------------------------------");
        for (Composition comp : compositions) {
            System.out.println(comp);
        }
    }

}
