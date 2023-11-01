import apartment.Apartment;
import command.*;
import menu.Menu;
public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Apartment apartment = new Apartment();

        System.out.println("Програма Домашні Прилади");
        menu.addCommand(1, "Add new appliance", new AddApplianceCommand(apartment));
        menu.addCommand(2, "Calculate total power", new CalculatePowerCommand(apartment));
        menu.addCommand(3, "Sort appliances by power", new SortAppliancesCommand(apartment));
        menu.addCommand(4, "Find appliances by power", new FindAppliancesCommand(apartment));

        while (true) {
            menu.executeCommand();
        }
    }
}
