package org.example.demos;

import org.example.battles.Battle;
import org.example.characters.*;

public class Main {
    public static void main(String[] args) {

        var army1 = new Army()
                .addUnits(WarriorImpl::new, 2)
                .addUnits(Lancer::new, 2)
                .addUnits(Defender::new, 1)
                .addUnits(Warlord::new, 3);

        var army2 = new Army()
                .addUnits(Warlord::new, 2)
                .addUnits(Vampire::new, 1)
                .addUnits(Healer::new, 5)
                .addUnits(Knight::new, 2);

        army1.moveUnits();
        army2.moveUnits();

        System.out.println(Battle.fight(army1, army2));
    }
}
