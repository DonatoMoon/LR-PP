package Menu.Commands;

import Compositions.Composition;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class FilterTracksCommand implements Command {
    private final List<Composition> compositions;
    private static final Logger logger = Logger.getLogger(FilterTracksCommand.class.getName());

    public FilterTracksCommand(List<Composition> compositions) {
        this.compositions = compositions;
    }

    @Override
    public void execute() {
        logger.info("Виконання команди фільтрації треків");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Виберіть критерій фільтрації:");
        System.out.println("[1] За назвою (зростання)");
        System.out.println("[2] За назвою (спадання)");
        System.out.println("[3] За роком (зростання)");
        System.out.println("[4] За роком (спадання)");

        int choice = scanner.nextInt();

        Comparator<Composition> comparator;
        switch (choice) {
            case 1:
                comparator = Comparator.comparing(Composition::getTitle);
                logger.info("Фільтрація за назвою (зростання)");
                break;
            case 2:
                comparator = Comparator.comparing(Composition::getTitle).reversed();
                logger.info("Фільтрація за назвою (спадання)");
                break;
            case 3:
                comparator = Comparator.comparingInt(Composition::getYear);
                logger.info("Фільтрація за роком (зростання)");
                break;
            case 4:
                comparator = Comparator.comparingInt(Composition::getYear).reversed();
                logger.info("Фільтрація за роком (спадання)");
                break;
            default:
                System.out.println("Неправильний вибір!");
                logger.warning("Неправильний вибір при фільтрації треків");
                return;
        }

        compositions.sort(comparator);
        compositions.forEach(System.out::println);
        logger.info("Фільтрація треків завершена");
    }

}
