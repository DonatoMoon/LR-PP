
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static long MIN_CREDIT_CARD_NUMBER = 1234567890123456L;
    private static long MAX_CREDIT_CARD_NUMBER = 5876543210987658L;
    private static String NAME = "Андрій";
    private static List<Customer> loadCustomersFromFile(String filename) throws Exception {
        List<Customer> customers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                Customer customer = new Customer(
                        Integer.parseInt(parts[0].trim()),
                        parts[1].trim(),
                        parts[2].trim(),
                        parts[3].trim(),
                        parts[4].trim(),
                        Long.parseLong(parts[5].trim()),
                        Double.parseDouble(parts[6].trim())
                );
                customers.add(customer);
            }
        }
        return customers;
    }

    private static void displayCustomersByName(List<Customer> customers) {
        for (Customer customer : customers) {
            if (customer.getValue("name").equals(NAME)) {
                System.out.println(customer.toString());
            }
        }
    }



    private static void displayCustomersByCreditCardRange(List<Customer> customers) {
        for (Customer customer : customers) {
            long cardNumber = (long) customer.getValue("creditCardNumber");
            if (cardNumber >= MIN_CREDIT_CARD_NUMBER && cardNumber <= MAX_CREDIT_CARD_NUMBER) {
                System.out.println(customer.toString());
            }
        }
    }

    private static void displayCustomersWithDebt(List<Customer> customers) {
        List<Customer> debtCustomers = new ArrayList<>();
        for (Customer customer : customers) {
            double balance = (double) customer.getValue("balance");
            if (balance < 0) {
                debtCustomers.add(customer);
            }
        }
        System.out.println("Кількість покупців із заборгованістю: " + debtCustomers.size());
        for (Customer customer : debtCustomers) {
            System.out.println(customer.toString());
        }
    }

    public static void main(String[] args) throws Exception {
        List<Customer> customers = loadCustomersFromFile("C:\\Users\\ASUS\\OneDrive\\Рабочий стол\\Politech\\3 sem\\PP\\LR-PP\\src\\customers.txt");

        System.out.println("Список покупців із ім'ям " + NAME + ": ");
        displayCustomersByName(customers);

        System.out.println("\nСписок покупців із номером кредитної картки в інтервалі " + MIN_CREDIT_CARD_NUMBER + " до " + MAX_CREDIT_CARD_NUMBER + " :");
        displayCustomersByCreditCardRange(customers);

        System.out.println("\nСписок покупців із заборгованістю:");
        displayCustomersWithDebt(customers);
    }
}
