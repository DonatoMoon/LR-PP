package Menu.Commands;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

import Compositions.*;
import java.util.List;

public class CalculateDurationCommand implements Command {
    private final List<Composition> compositions;
    private static final Logger logger = Logger.getLogger(CalculateDurationCommand.class.getName());

    public CalculateDurationCommand(List<Composition> compositions) {
        this.compositions = compositions;
    }

    @Override
    public void execute() {
        logger.info("Виконання команди розрахунку загальної тривалості композицій");

        int totalDuration = compositions.stream().mapToInt(Composition::getDuration).sum();
        System.out.println("Загальна тривалість композицій: " + totalDuration + " секунд");

        logger.info("Загальна тривалість композицій: " + totalDuration + " секунд");
    }

}