package main;

import Attacks.Attack;
import Attacks.StatBoostAttack;
import Droids.Droid;

import Droids.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Main {
    private static List<Droid> droids = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Створити дроїда");
            System.out.println("2. Показати список дроїдів");
            System.out.println("3. Розпочати бій 1 на 1");
            System.out.println("4. Відтворити останній бій");
            System.out.println("0. Вийти\n");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    clearConsole();
                    createDroid(scanner);
                    break;
                case "2":
                    clearConsole();
                    showDroids();
                    break;
                case "3":
                    clearConsole();
                    startBattle(scanner);
                    break;
                case "4":
                    clearConsole();
                    replayLastBattle();
                    break;
                case "0":
                    clearConsole();
                    System.out.println("Вихід...");
                    return;
                default:
                    System.out.println("Некоректний вибір. Спробуйте ще раз.");
            }
        }
    }
    public static void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
    private static void logBattle(String logData) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("battle_log.txt", true))) {
            writer.println(logData);
        } catch (IOException e) {
            System.out.println("Не можливо записати лог бою: " + e.getMessage());
        }
    }
    private static void replayLastBattle() {
        try (BufferedReader reader = new BufferedReader(new FileReader("battle_log.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Не можливо прочитати лог бою: " + e.getMessage());
        }
    }

    private static void createDroid(Scanner scanner) {
        Droid tmpdroid = new Droid();
        System.out.println("Оберіть тип дроїда:");
        System.out.println("1. ДраконДроїд");
        tmpdroid= new DragonDroid();
        System.out.println(tmpdroid.toString());
        System.out.println("2. ЧерепахаДроїд:");
        tmpdroid= new TurtleDroid();
        System.out.println(tmpdroid.toString());
        System.out.println("2. ЗміяДроїд:");
        tmpdroid= new WaterSnakeDroid();
        System.out.println(tmpdroid.toString());

        String type = scanner.nextLine();
        Droid newDroid;

        switch (type) {
            case "1":
                newDroid = new DragonDroid();
                break;
            case "2":
                newDroid = new TurtleDroid();
                break;
            case "3":
                newDroid = new WaterSnakeDroid();
                break;
            default:
                System.out.println("Некоректний тип. Дроїда не створено.");
                return;
        }
        droids.add(newDroid);
        System.out.println("\nДроїд успішно створений!");
    }
    private static void showDroids() {
        if (droids.isEmpty()) {
            System.out.println("\nДроїди ще не створені.\n");
            return;
        }
        System.out.println("Список усіх створених дроїдів");
        for (int i = 0; i < droids.size(); i++) {
            System.out.println((i + 1) + ". " + droids.get(i).getClass().getSimpleName());
        }
    }
    private static void showAttacks(Droid droid) {
        System.out.println("\nОберіть атаку:\n");
        List<Attack> attacks = droid.getAttacks();
        for (int i = 0; i < attacks.size(); i++) {
            System.out.println((i + 1) + ". " + attacks.get(i).getName());
            System.out.println(attacks.get(i).toString());
        }
    }
    private static void startBattle(Scanner scanner) {
        if (droids.size() < 2) {
            System.out.println("\nДля битви потрібно принаймні два дроїди.\n");
            return;
        }
        System.out.println("\nОберіть першого дроїда для битви:\n");
        showDroids();
        int firstDroidIndex = Integer.parseInt(scanner.nextLine()) - 1;

        System.out.println("\nОберіть другого дроїда для битви:\n");
        showDroids();
        int secondDroidIndex = Integer.parseInt(scanner.nextLine()) - 1;

        if (firstDroidIndex < 0 || firstDroidIndex >= droids.size() || secondDroidIndex < 0 || secondDroidIndex >= droids.size()) {
            System.out.println("Некоректний вибір. Бій не розпочато.");
            return;
        }

        Droid firstDroid = droids.get(firstDroidIndex);
        Droid secondDroid = droids.get(secondDroidIndex);

        Droid fasterDroid;
        Droid slowerDroid;
        if (firstDroid.getSpeed() >= secondDroid.getSpeed()) {
            fasterDroid = firstDroid;
            slowerDroid = secondDroid;
        } else {
            fasterDroid = secondDroid;
            slowerDroid = firstDroid;
        }
        clearConsole();
        System.out.println("\nБій розпочато!\n");

        try (FileWriter writer = new FileWriter("battle_log.txt", false)) {
            // Параметр false вказує, що файл повинен бути очищений
        } catch (IOException e) {
            e.printStackTrace();
        }
        logBattle("Бій розпочато!");
        boolean isBattleOver = false;
        System.out.println(fasterDroid.getClass().getSimpleName() + ": Здоров'я - " + fasterDroid.getHealth());
        logBattle(fasterDroid.getClass().getSimpleName() + ": Здоров'я - " + fasterDroid.getHealth());
        System.out.println(slowerDroid.getClass().getSimpleName() + ": Здоров'я - " + slowerDroid.getHealth() + "\n");
        logBattle(slowerDroid.getClass().getSimpleName() + ": Здоров'я - " + slowerDroid.getHealth());

        while (!isBattleOver) {

            // ПЕРША АТАКА
            System.out.println(fasterDroid.getClass().getSimpleName() + " атакує:");
            showAttacks(fasterDroid);
            int attackChoice = Integer.parseInt(scanner.nextLine()) - 1;

            if (attackChoice < 0 || attackChoice >= fasterDroid.getAttacks().size()) {
                System.out.println("Некоректний вибір атаки. Спробуйте ще раз.");
            }

            Attack attack = fasterDroid.getAttacks().get(attackChoice);
            int damageDealt = attack.performAttack(slowerDroid);

            if(damageDealt==0){
                System.out.println("\n"+fasterDroid.getClass().getSimpleName() + " промазав атакою " + attack.getName()+"\n");
                logBattle(fasterDroid.getClass().getSimpleName() + " промазав атакою " + attack.getName());
            } else if (damageDealt==-1) {
                attack.Boost(fasterDroid);
                StatBoostAttack boostAttack = (StatBoostAttack) attack;
                System.out.println("\n"+fasterDroid.getClass().getSimpleName() + " використав " + boostAttack.getName() + ". і підвищив " + boostAttack.getBoostedStat()+"\n");
                logBattle(fasterDroid.getClass().getSimpleName() + " використав " + boostAttack.getName() + ". і підвищив " + boostAttack.getBoostedStat());
            }else{
                slowerDroid.takeDamage(damageDealt);
                System.out.println("\n"+fasterDroid.getClass().getSimpleName() + " використав " + attack.getName() + " і наніс " + damageDealt + " урона!\n");
                logBattle(fasterDroid.getClass().getSimpleName() + " використав " + attack.getName() + " і наніс " + damageDealt + " урона!");
                System.out.println(fasterDroid.getClass().getSimpleName() + ": Здоров'я - " + fasterDroid.getHealth());
                logBattle(fasterDroid.getClass().getSimpleName() + ": Здоров'я - " + fasterDroid.getHealth());
                System.out.println(slowerDroid.getClass().getSimpleName() + ": Здоров'я - " + slowerDroid.getHealth() + "\n");
                logBattle(slowerDroid.getClass().getSimpleName() + ": Здоров'я - " + slowerDroid.getHealth());
            }


            if (slowerDroid.getHealth() <= 0) {
                System.out.println(slowerDroid.getClass().getSimpleName() + " був переможений! " + fasterDroid.getClass().getSimpleName() + " перемагає!");
                logBattle(slowerDroid.getClass().getSimpleName() + " був переможений! " + fasterDroid.getClass().getSimpleName() + " перемагає!");
                isBattleOver = true;
                break;
            }

            // ДРУГА АТАКА
            System.out.println(slowerDroid.getClass().getSimpleName() + " атакує:");
            showAttacks(slowerDroid);
            attackChoice = Integer.parseInt(scanner.nextLine()) - 1;
            if (attackChoice < 0 || attackChoice >= slowerDroid.getAttacks().size()) {
                System.out.println("Некоректний вибір атаки. Спробуйте ще раз.");
            }

            attack = slowerDroid.getAttacks().get(attackChoice);
            damageDealt = attack.performAttack(fasterDroid);

            if(damageDealt!=0){
                fasterDroid.takeDamage(damageDealt);
                System.out.println("\n"+slowerDroid.getClass().getSimpleName() + " використав " + attack.getName() + " і наніс " + damageDealt + " урона!\n");
                logBattle(slowerDroid.getClass().getSimpleName() + " використав " + attack.getName() + " і наніс " + damageDealt + " урона!");
                System.out.println(fasterDroid.getClass().getSimpleName() + ": Здоров'я - " + fasterDroid.getHealth());
                logBattle(fasterDroid.getClass().getSimpleName() + ": Здоров'я - " + fasterDroid.getHealth());
                System.out.println(slowerDroid.getClass().getSimpleName() + ": Здоров'я - " + slowerDroid.getHealth() + "\n");
                logBattle(slowerDroid.getClass().getSimpleName() + ": Здоров'я - " + slowerDroid.getHealth());
            }
            else{
                System.out.println("\n"+slowerDroid.getClass().getSimpleName() + " промазав атакою " + attack.getName()+ "\n");
                logBattle(slowerDroid.getClass().getSimpleName() + " промазав атакою " + attack.getName());
            }

            if (fasterDroid.getHealth() <= 0) {
                System.out.println(fasterDroid.getClass().getSimpleName() + " був переможений! " + slowerDroid.getClass().getSimpleName() + " перемагає!");
                logBattle(fasterDroid.getClass().getSimpleName() + " був переможений! " + slowerDroid.getClass().getSimpleName() + " перемагає!");
                isBattleOver = true;
            }
        }
    }
}
