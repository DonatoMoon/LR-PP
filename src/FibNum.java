/**
 * Клас FibNum представляє об'єкт, який обчислює числа Фібоначчі та суму перших N чисел Фібоначчі.
 */
public class FibNum {
    private int n;      // Порядковий номер числа Фібоначчі
    private long value; // Значення числа Фібоначчі

    /**
     * Конструктор класу FibNum, який ініціалізує об'єкт та обчислює значення числа Фібоначчі за заданим порядковим номером.
     *
     * @param n Порядковий номер числа Фібоначчі, яке потрібно обчислити.
     */
    public FibNum(int n) {
        this.n = n;
        this.value = getValue(n);
    }

    /**
     * Приватний метод для обчислення значення числа Фібоначчі за заданим порядковим номером.
     *
     * @param n Порядковий номер числа Фібоначчі.
     * @return Значення числа Фібоначчі з порядковим номером n.
     */
    private long getValue(int n) {
        if (n <= 1) return n;

        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long next = a + b;
            a = b;
            b = next;
        }
        return b;
    }

    /**
     * Статичний метод для обчислення суми перших N чисел Фібоначчі.
     *
     * @param n Кількість чисел Фібоначчі для обчислення суми.
     * @return Сума перших N чисел Фібоначчі.
     */
    public static long sumFirstNNumbers(int n) {
        if (n <= 1) return n;

        long a = 0, b = 1, sum = 1;
        for (int i = 1; i < n; i++) {
            long next = a + b;
            sum += next;
            a = b;
            b = next;
        }
        return sum;
    }
}

