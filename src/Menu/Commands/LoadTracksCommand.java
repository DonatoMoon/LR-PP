package Menu.Commands;

import Compositions.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class LoadTracksCommand implements Command {
    private final List<Composition> compositions;
    private static final Logger logger = Logger.getLogger(CalculateDurationCommand.class.getName());
    public LoadTracksCommand(List<Composition> compositions) {
        this.compositions = compositions;
    }

    @Override
    public void execute() {
        logger.info("Початок виконання команди завантаження композицій");

        Gson gson = new Gson();
        try (FileReader reader = new FileReader("src/resources/tracks.json")) {
            List<Composition> loadedCompositions = gson.fromJson(reader, new TypeToken<List<Composition>>(){}.getType());
            compositions.clear();
            compositions.addAll(loadedCompositions);
            System.out.println("Композиції завантажено.");
            logger.info("Композиції успішно завантажено.");
        } catch (IOException e) {
            System.out.println("Помилка при завантаженні композицій: " + e.getMessage());
            logger.severe("Помилка при завантаженні композицій: " + e.getMessage());
            Logger.getLogger("MyLogger").severe("Помилка при завантаженні композицій: " + e.getMessage());
        }
    }

}
