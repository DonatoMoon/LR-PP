import java.util.Arrays;
import java.util.List;
public class Droid {
    protected int health;
    protected int physicalAttack;
    protected int energyAttack;
    protected int physicalDefense;
    protected int energyDefense;
    protected int speed;
    protected List<Attack> attacks;
    public Droid(int health, int physicalAttack, int energyAttack, int physicalDefense, int energyDefense,  int speed,  List<Attack> attacks) {
        this.health = health;
        this.physicalAttack = physicalAttack;
        this.energyAttack = energyAttack;
        this.physicalDefense = physicalDefense;
        this.energyDefense = energyDefense;
        this.speed = speed;
        this.attacks = attacks;
    }
    public int getHealth(){
        return health;
    }
    public int getPhysicalDefense() {
        return physicalDefense;
    }
    public int getEnergyDefense() {
        return energyDefense;
    }
    public int getSpeed(){
        return speed;
    }
    public List<Attack> getAttacks() {
        return attacks;
    }
    public void healDroid(int healValue) {this.health += healValue;}
    public void increasePhysicalAttack(double boostMod) {
        this.physicalAttack *= boostMod;
    }
    public void increaseEnergyAttack(double boostMod) {
        this.energyAttack *= boostMod;
    }
    public void increasePhysicalDefense(double boostMod) {
        this.physicalDefense *= boostMod;
    }
    public void increaseEnergyDefense(double boostMod) {
        this.energyDefense *= boostMod;
    }
    public void increaseSpeed(double boostMod) {
        this.speed *= boostMod;
    }

    public void takeDamage(int damage) {
        if (damage > 0) {
            health -= damage;
            if (health < 0) {
                health = 0;
            }
        }
    }
}
class DragonDroid extends Droid {
    public DragonDroid() {
        super(100, 50, 20, 10, 15, 15, Arrays.asList(
                new FireBreath(),
                new DoubleTailAttack(),
                new WingAttack(),
                new Bite()
        ));
    }
}
class TurtleDroid extends Droid {
    public TurtleDroid() {
        super(80, 60, 5, 5, 10, 20, Arrays.asList(
                new ShellDefense(),
                new Headbutt(),
                new WaterJet(),
                new HealingWave()
        ));
    }
}