package Menu.Commands;

import Compositions.Composition;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FilterTracksCommand implements Command {
    private final List<Composition> compositions;

    public FilterTracksCommand(List<Composition> compositions) {
        this.compositions = compositions;
    }

    @Override
    public void execute() {
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
                break;
            case 2:
                comparator = Comparator.comparing(Composition::getTitle).reversed();
                break;
            case 3:
                comparator = Comparator.comparingInt(Composition::getYear);
                break;
            case 4:
                comparator = Comparator.comparingInt(Composition::getYear).reversed();
                break;
            default:
                System.out.println("Неправильний вибір!");
                return;
        }

        compositions.sort(comparator);
        compositions.forEach(System.out::println);
    }
}
