package Attacks;
import Droids.Droid;
import utilities.DamageType;
public class HeadAttack extends Attack
{
    public HeadAttack() {
        super("Head attack", 30, 100, DamageType.PHYSICAL);
    }
    @Override
    public void Boost(Droid target) {}
}