package Droids;

import Attacks.Bite;
import Attacks.DoubleTailAttack;
import Attacks.Intimidation;
import Attacks.WaterJet;

import java.util.Arrays;

public class WaterSnakeDroid extends Droid {
    public WaterSnakeDroid() {
        super(80, 30, 40, 20, 20, 30, Arrays.asList(
                new WaterJet(),
                new DoubleTailAttack(),
                new Bite(),
                new Intimidation()
        ));
    }
}