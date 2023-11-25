package Menu.Commands;

import Compositions.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LoadTracksCommand implements Command {
    private final List<Composition> compositions;

    public LoadTracksCommand(List<Composition> compositions) {
        this.compositions = compositions;
    }

    @Override
    public void execute() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("D:\\Politech\\3 sem\\PP\\LR-PP\\src\\Menu\\Commands\\tracks.json")) {
            List<Composition> loadedCompositions = gson.fromJson(reader, new TypeToken<List<Composition>>(){}.getType());
            compositions.clear();
            compositions.addAll(loadedCompositions);
            System.out.println("Композиції завантажено.");
        } catch (IOException e) {
            System.out.println("Помилка при завантаженні композицій: " + e.getMessage());
        }
    }
}
