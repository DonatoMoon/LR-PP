package Droids;

import Attacks.Bite;
import Attacks.DoubleTailAttack;
import Attacks.FireBreath;
import Attacks.WingAttack;

import java.util.Arrays;

public class DragonDroid extends Droid {
    public DragonDroid() {
        super(100, 50, 20, 10, 15, 15, Arrays.asList(
                new FireBreath(),
                new DoubleTailAttack(),
                new WingAttack(),
                new Bite()
        ));
    }
}