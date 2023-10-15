package Attacks;

import Droids.Droid;
import utilities.DamageType;
public abstract class Attack {
    private String name;
    private int damage;
    private int accuracy;
    private DamageType damageType;
    public Attack(String name, int damage, int accuracy, DamageType damageType) {
        this.name = name;
        this.damage = damage;
        this.accuracy = accuracy;
        this.damageType = damageType;
    }
    public String getName() {
        return name;
    }
    public int getDamage() {
        return damage;
    }
    @Override
    public String toString() {
        return "\t[ Урон: "+damage+" | Точність: "+accuracy+" | Тип атаки: "+damageType+" ]";
    }
    public int getAccuracy() {
        return accuracy;
    }
    public int getDefenseValue(Droid target) {
        if (damageType == DamageType.PHYSICAL) {
            return target.getPhysicalDefense();
        } else if (damageType == DamageType.ENERGY) {
            return target.getEnergyDefense();
        } else {
            return 0;
        }
    }
    public int performAttack(Droid target){
        if(this.getDamage()!=0) {
            if ((Math.random() * 100) <= this.getAccuracy()) {
                return this.getDamage() - this.getDefenseValue(target);
            } else {
                return 0;
            }
        }
        else{
            return -1;
        }
    }
    public abstract void Boost(Droid target);
}
