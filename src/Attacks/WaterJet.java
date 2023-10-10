package Attacks;
import Droids.Droid;
import utilities.DamageType;
public class WaterJet extends Attack {
    public WaterJet() {
        super("WaterJet", 45, 70, DamageType.ENERGY);
    }
    @Override
    public void Boost(Droid target) {}
}