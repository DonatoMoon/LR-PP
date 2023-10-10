package Attacks;

import Droids.Droid;
import utilities.DamageType;

public class DoubleTailAttack extends Attack {
    public DoubleTailAttack() {
        super("Подвійний удар хвостом", 20, 80, DamageType.PHYSICAL);
    }
    @Override
    public int performAttack(Droid target) {
        return this.getDamage()*2 - this.getDefenseValue(target);
    }
    @Override
    public void Boost(Droid target) {}
}