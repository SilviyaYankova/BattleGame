package org.example.demos;

import org.example.battles.Battle;
import org.example.characters.*;
import org.example.weapons.Weapon;

public class Main {
    public static void main(String[] args) {

        var army1 = new Army()
                .addUnits(() -> new Wizard(0), 1)
                .addUnits(Warlord::new, 1);

        var army2 = new Army()
                .addUnits(() -> new Wizard(0), 1)
                .addUnits(Warlord::new, 1);

        army1.equipWarriorAtPosition(0, Weapon.newMagicWand());
        army2.equipWarriorAtPosition(0, Weapon.newMagicWand());

        army1.moveUnits();
        army2.moveUnits();

        System.out.println(Battle.fight(army1, army2));
    }
}
