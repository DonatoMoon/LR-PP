package command;
import apartment.Apartment;
import appliance.Appliance;
import java.util.Scanner;

public class AddApplianceCommand implements Command {
    private final Apartment apartment;
    private final Scanner scanner = new Scanner(System.in);

    public AddApplianceCommand(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public void execute() {
        System.out.print("Введіть потужність нового приладу: ");
        int power = scanner.nextInt();
        Appliance newAppliance = new Appliance(power);
        apartment.addAppliance(newAppliance);
        System.out.println("Прилад додано.");
    }
}
