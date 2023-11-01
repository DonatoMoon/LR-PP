package apartment;

import appliance.Appliance;
import java.util.*;
import java.util.stream.Collectors;

public class Apartment {
    private List<Appliance> appliances;

    public Apartment() {
        this.appliances = new ArrayList<>();
    }

    public void addAppliance(Appliance appliance) {
        appliances.add(appliance);
    }

    public int calculateTotalPower() {
        return appliances.stream().mapToInt(Appliance::getPower).sum();
    }

    // ... (other methods remain the same)

    public void findAppliancesByPower(int minPower, int maxPower) {
        List<Appliance> foundAppliances = appliances.stream()
                .filter(a -> a.getPower() >= minPower && a.getPower() <= maxPower)
                .collect(Collectors.toList());

        // Do something with found appliances, e.g., print them
        System.out.println("Знайдені прилади:");
        for (Appliance a : foundAppliances) {
            System.out.println("Прилад з потужністю: " + a.getPower());
        }
    }

    public void sortAppliancesCommandByPower() {
        appliances.sort(Comparator.comparingInt(Appliance::getPower));
        System.out.println("Appliances sorted by power:");
        for (Appliance a : appliances) {
            System.out.println("Appliance with power: " + a.getPower());
        }
    }

}
