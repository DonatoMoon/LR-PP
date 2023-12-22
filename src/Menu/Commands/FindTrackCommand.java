package Menu.Commands;

import Compositions.*;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
public class FindTrackCommand implements Command {
    private final List<Composition> compositions;
    private static final Logger logger = Logger.getLogger(FindTrackCommand.class.getName());

    public FindTrackCommand(List<Composition> compositions) {
        this.compositions = compositions;
    }
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть назву або виконавця для пошуку: ");
        String query = scanner.nextLine();
        logger.info("Пошук композицій за запитом: " + query);

        boolean found = compositions.stream()
                .filter(comp -> comp.getTitle().equalsIgnoreCase(query) || comp.getArtist().equalsIgnoreCase(query))
                .peek(comp -> logger.info("Знайдена композиція: " + comp))
                .count() > 0;

        if (!found) {
            System.out.println("Композиції не знайдено.");
            logger.info("Композиції за запитом '" + query + "' не знайдено.");
        }
    }

}
