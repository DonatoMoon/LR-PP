package Menu.Commands;
public class ShowAllTracksCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Виведення усіх композицій...");
    }
}

