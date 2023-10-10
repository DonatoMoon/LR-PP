package Attacks;

import Droids.Droid;
import utilities.DamageType;

public class Bite extends Attack {
    public Bite() {
        super("Bite", 35, 80, DamageType.PHYSICAL);
    }
    @Override
    public void Boost(Droid target) {}
}