import java.util.Scanner;

/**
 * Головний клас програми для обчислення суми перших N чисел Фібоначчі.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть номер числа Фібоначчі: ");
        int n;
        do {
            n = in.nextInt();
            if (n < 0)
                System.out.print("\nВведено від'ємний номер числа Фібоначчі, введіть номер заново: ");
        } while (n < 0);

        long sum = FibNum.sumFirstNNumbers(n);
        System.out.println("Сума перших " + n + " чисел Фібоначчі дорівнює: " + sum);
    }
}


