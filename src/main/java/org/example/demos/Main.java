package org.example.demos;

import org.example.battles.Battle;
import org.example.characters.*;
import org.example.weapons.Weapon;

public class Main {
    public static void main(String[] args) {

        var army1 = new Army()
                .addUnits(WarriorImpl::new, 2)
                .addUnits(() -> new Wizard(2), 1)
                .addUnits(Lancer::new, 3)
                .addUnits(Defender::new, 1)
                .addUnits(Warlord::new, 1);

        var army2 = new Army()
                .addUnits(Warlord::new, 5)
                .addUnits(Vampire::new, 1)
                .addUnits(() -> new Wizard(3), 1)
                .addUnits(Knight::new, 1);

        army2.equipWarriorAtPosition(0, Weapon.newShield());

        army1.moveUnits();
        army2.moveUnits();

        System.out.println(Battle.fight(army1, army2));
    }
}
