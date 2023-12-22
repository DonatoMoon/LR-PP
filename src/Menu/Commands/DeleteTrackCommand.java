package Menu.Commands;

import Compositions.*;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class DeleteTrackCommand implements Command {
    private final List<Composition> compositions;
    private static final Logger logger = Logger.getLogger(DeleteTrackCommand.class.getName());

    public DeleteTrackCommand(List<Composition> compositions) {
        this.compositions = compositions;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть назву композиції для видалення: ");
        String title = scanner.nextLine();
        logger.info("Намагаюся видалити композицію з назвою: " + title);

        boolean removed = compositions.removeIf(comp -> comp.getTitle().equalsIgnoreCase(title));

        if (removed) {
            System.out.println("Композицію видалено.");
            logger.info("Композиція з назвою '" + title + "' успішно видалена.");
        } else {
            System.out.println("Композицію не знайдено.");
            logger.warning("Композицію з назвою '" + title + "' не знайдено.");
        }
    }

}
