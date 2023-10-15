package Attacks;

import Droids.Droid;
import utilities.DamageType;

public class StatBoostAttack extends Attack {
    private String boostedStat;
    private double boostMod;
    public StatBoostAttack(String name, int damage, int accuracy, DamageType damageType, String boostedStat, double boostMod) {
        super(name, damage, accuracy, damageType);
        this.boostedStat = boostedStat;
        this.boostMod = boostMod;
    }
    public String getBoostedStat(){
        return boostedStat;
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