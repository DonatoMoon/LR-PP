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
        if((Math.random() * 100) <= this.getAccuracy())
        {
            return this.getDamage() - this.getDefenseValue(target);
        }
        else
        {
            return 0;
        }
    }
    public abstract void Boost(Droid target);
}
class StatBoostAttack extends Attack {
    private String boostedStat;
    private double boostMod;
    public StatBoostAttack(String name, int damage, int accuracy, DamageType damageType, String boostedStat, double boostMod) {
        super(name, damage, accuracy, damageType);
        this.boostedStat = boostedStat;
        this.boostMod = boostMod;
    }
    @Override
    public void Boost(Droid target) {
        switch (boostedStat) {
            case "health":
                target.healDroid((int)boostMod);
                break;
            case "physicalAttack":
                target.increasePhysicalAttack(boostMod);
                break;
            case "energyAttack":
                target.increaseEnergyAttack(boostMod);
                break;
            case "physicalDefense":
                target.increasePhysicalDefense(boostMod);
                break;
            case "energyDefense":
                target.increaseEnergyDefense(boostMod);
                break;
            case "speed":
                target.increaseSpeed(boostMod);
                break;
            default:
                break;
        }
    }

}
class FireBreath extends Attack {
    public FireBreath() {
        super("Вогняне дихання", 30, 90, DamageType.ENERGY);
    }
    @Override
    public void Boost(Droid target) {}
}
class DoubleTailAttack extends Attack {
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
class WingAttack extends Attack {
    public WingAttack() {
        super("Wing Attack", 25, 85, DamageType.PHYSICAL);
    }
    @Override
    public void Boost(Droid target) {}
}

class Bite extends Attack {
    public Bite() {
        super("Bite", 35, 80, DamageType.PHYSICAL);
    }
    @Override
    public void Boost(Droid target) {}
}


class Headbutt extends Attack {
    public Headbutt() {
        super("Head butt", 30, 10, DamageType.PHYSICAL);
    }
    @Override
    public void Boost(Droid target) {}
}
class ShellDefense extends StatBoostAttack {
    public ShellDefense() {
        super("Shell Defense", 0, 100, DamageType.NONE, "physicalDefense", 1.5);
    }
}
class WaterJet extends Attack {
    public WaterJet() {
        super("WaterJet", 45, 70, DamageType.ENERGY);
    }
    @Override
    public void Boost(Droid target) {}
}

class HealingWave extends StatBoostAttack {
    public HealingWave() {
        super("Healing Wave", 0, 90, DamageType.NONE, "health", 50);
    }
}
