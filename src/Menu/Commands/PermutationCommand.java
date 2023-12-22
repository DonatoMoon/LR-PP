package Menu.Commands;

import Compositions.*;
import java.util.logging.Logger;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PermutationCommand implements Command {
    private final List<Composition> compositions;
    private static final Logger logger = Logger.getLogger(PermutationCommand.class.getName());

    public PermutationCommand(List<Composition> compositions) {
        this.compositions = compositions;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть назву першої композиції: ");
        String firstTitle = scanner.nextLine();
        System.out.print("Введіть назву другої композиції: ");
        String secondTitle = scanner.nextLine();

        logger.info("Спроба перестановки між '" + firstTitle + "' і '" + secondTitle + "'");

        Composition firstComposition = findCompositionByTitle(firstTitle);
        Composition secondComposition = findCompositionByTitle(secondTitle);

        if (firstComposition != null && secondComposition != null) {
            int firstIndex = compositions.indexOf(firstComposition);
            int secondIndex = compositions.indexOf(secondComposition);
            Collections.swap(compositions, firstIndex, secondIndex);

            System.out.println("Перестановка відбулася успішно.");
            logger.info("Перестановка між '" + firstTitle + "' і '" + secondTitle + "' відбулася успішно.");
        } else {
            System.out.println("Не вдалося знайти обидві композиції.");
            logger.warning("Не вдалося знайти одну або обидві композиції: '" + firstTitle + "', '" + secondTitle + "'");
        }
    }


    private Composition findCompositionByTitle(String title) {
        for (Composition composition : compositions) {
            if (composition.getTitle().equalsIgnoreCase(title)) {
                return composition;
            }
        }
        return null;
    }
}
