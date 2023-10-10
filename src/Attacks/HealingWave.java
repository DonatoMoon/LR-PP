package Attacks;

import utilities.DamageType;

public class HealingWave extends StatBoostAttack {
    public HealingWave() {
        super("Healing Wave", 0, 100, DamageType.NONE, "health", 50);
    }
}