package Droids;

import Attacks.HeadAttack;
import Attacks.HealingWave;
import Attacks.ShellDefense;
import Attacks.WaterJet;

import java.util.Arrays;

public class TurtleDroid extends Droid {
    public TurtleDroid() {
        super(80, 60, 50, 5, 10, 20, Arrays.asList(
                new ShellDefense(),
                new HeadAttack(),
                new WaterJet(),
                new HealingWave()
        ));
    }
}