package Menu.Commands;

import Compositions.*;
import java.util.List;

public class CalculateDurationCommand implements Command {
    private final List<Composition> compositions;

    public CalculateDurationCommand(List<Composition> compositions) {
        this.compositions = compositions;
    }

    @Override
    public void execute() {
        int totalDuration = compositions.stream().mapToInt(Composition::getDuration).sum();
        System.out.println("Загальна тривалість композицій: " + totalDuration + " секунд");
    }
}
