package Attacks;
import utilities.DamageType;
public class ShellDefense extends StatBoostAttack {
    public ShellDefense() {
        super("Shell Defense", 0, 100, DamageType.NONE, "physicalDefense", 1.5);
    }
}