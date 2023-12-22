package Menu.Commands;

import java.util.logging.Logger;

public class ExitCommand implements Command {
    private static final Logger logger = Logger.getLogger(ExitCommand.class.getName());

    @Override
    public void execute() {
        logger.info("Виконується команда виходу з програми");

        System.out.println("Вихід...");
        System.exit(0);
    }
}
