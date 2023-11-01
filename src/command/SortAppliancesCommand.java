package command;
import apartment.Apartment;
public class SortAppliancesCommand implements Command {
    private final Apartment apartment;

    public SortAppliancesCommand(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public void execute() {
        System.out.println("Прилади відсортовані за потужністю:");
        apartment.sortAppliancesCommandByPower();
    }
}
