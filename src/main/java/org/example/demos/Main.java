package org.example.demos;

import org.example.battles.Battle;
import org.example.characters.*;
import org.example.decorators.WarriorInArmy;

public class Main {
    public static void main(String[] args) {

        var firstAyArmy = new Army()
                .addUnits(WarriorImpl::new, 1)
                .addUnits(Lancer::new, 1)
                .addUnits(Healer::new, 1)
                .addUnits(Defender::new, 2);

        var secondArmy = new Army()
                .addUnits(Vampire::new, 3)
                .addUnits(WarriorImpl::new, 1)
                .addUnits(Healer::new, 1)
                .addUnits(Lancer::new, 2);


        boolean fight = Battle.straightFight(firstAyArmy, secondArmy);
        System.out.println(fight);
    }
}
