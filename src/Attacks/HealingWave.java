package Attacks;

import utilities.DamageType;

public class HealingWave extends StatBoostAttack {
    public HealingWave() {
        super("Healing Wave", 0, 90, DamageType.NONE, "health", 50);
    }
}