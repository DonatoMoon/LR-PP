package Attacks;

import Droids.Droid;
import utilities.DamageType;

public class FireBreath extends Attack {
    public FireBreath() {
        super("Вогняне дихання", 30, 90, DamageType.ENERGY);
    }
    @Override
    public void Boost(Droid target) {}
}