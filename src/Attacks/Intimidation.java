package Attacks;
import utilities.DamageType;
public class Intimidation extends StatBoostAttack {
    public Intimidation() {
        super("Intimidation", 0, 100, DamageType.NONE, "physicalDefense", 0.5);
    }
}