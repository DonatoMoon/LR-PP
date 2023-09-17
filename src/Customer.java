
public class Customer {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private long creditCardNumber;
    private double balance;

    public Customer(int id, String surname, String name, String patronymic, String address, long creditCardNumber, double balance) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.balance = balance;
    }

    public void setValue(String name, Object value) {
        switch (name) {
            case "id":
                this.id = (int) value;
                break;
            case "surname":
                this.surname = (String) value;
                break;
            case "name":
                this.name = (String) value;
                break;
            case "patronymic":
                this.patronymic = (String) value;
                break;
            case "address":
                this.address = (String) value;
                break;
            case "creditCardNumber":
                this.creditCardNumber = (long) value;
                break;
            case "balance":
                this.balance = (double) value;
                break;
        }
    }

    public Object getValue(String name) {
        switch (name) {
            case "id":
                return id;
            case "surname":
                return surname;
            case "name":
                return this.name;  // Змінюємо тут на this.name
            case "patronymic":
                return patronymic;
            case "address":
                return address;
            case "creditCardNumber":
                return creditCardNumber;
            case "balance":
                return balance;
            default:
                return null;
        }
    }


    @Override
    public String toString() {
        return "Клієнт " + id +
                ", " + surname +
                " " + name +
                " " + patronymic +
                ", Адреса: " + address +
                ", Номер: " + creditCardNumber +
                ", Баланс: " + balance;
    }
}
