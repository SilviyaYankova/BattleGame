package org.example.demos;

import org.example.battles.Battle;
import org.example.characters.*;

public class Main {
    public static void main(String[] args) {

        var firstAyArmy = new Army()
                .addUnits(Defender::new, 1)
                .addUnits(Healer::new, 1)
                .addUnits(Vampire::new, 1)
                .addUnits(Lancer::new, 1)
                .addUnits(Healer::new, 1)
                .addUnits(WarriorImpl::new, 1);

        var secondArmy = new Army()
                .addUnits(WarriorImpl::new, 1)
                .addUnits(Lancer::new, 1)
                .addUnits(Healer::new, 1)
                .addUnits(Defender::new, 1)
                .addUnits(Vampire::new, 1)
                .addUnits(Healer::new, 1);

        boolean fight = Battle.straightFight(firstAyArmy, secondArmy);
        System.out.println(fight);
    }
}
