package org.example.demos;

import org.example.battles.Battle;
import org.example.characters.*;

public class Main {
    public static void main(String[] args) {

        var firstAyArmy = new Army();
        firstAyArmy.addUnits(Lancer::new, 1);
        firstAyArmy.addUnits(Defender::new, 1);
        firstAyArmy.addUnits(WarriorImpl::new, 1);
        firstAyArmy.addUnits(Knight::new, 1);

        var secondArmy = new Army();
        secondArmy.addUnits(WarriorImpl::new, 1);
        secondArmy.addUnits(Knight::new, 1);
        secondArmy.addUnits(Lancer::new, 1);
        secondArmy.addUnits(Defender::new, 1);


        boolean fight = Battle.fight(firstAyArmy, secondArmy);
        System.out.println(fight);
    }
}
