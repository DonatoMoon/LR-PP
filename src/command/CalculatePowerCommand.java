package command;
import apartment.Apartment;

public class CalculatePowerCommand implements Command {
    private final Apartment apartment;

    public CalculatePowerCommand(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public void execute() {
        int totalPower = apartment.calculateTotalPower();
        System.out.println("Загальна потужність всіх приладів: " + totalPower);
    }
}
