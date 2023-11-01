package command;
import apartment.Apartment;
import java.util.Scanner;

public class FindAppliancesCommand implements Command {
    private final Apartment apartment;
    private final Scanner scanner = new Scanner(System.in);

    public FindAppliancesCommand(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public void execute() {
        System.out.print("Введіть мінімальну потужність: ");
        int minPower = scanner.nextInt();
        System.out.print("Введіть максимальну потужність: ");
        int maxPower = scanner.nextInt();
        apartment.findAppliancesByPower(minPower, maxPower);
    }
}
