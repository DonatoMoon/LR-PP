package Attacks;

import Droids.Droid;
import utilities.DamageType;

public class WingAttack extends Attack {
    public WingAttack() {
        super("Wing Attack", 25, 85, DamageType.PHYSICAL);
    }
    @Override
    public void Boost(Droid target) {}
}