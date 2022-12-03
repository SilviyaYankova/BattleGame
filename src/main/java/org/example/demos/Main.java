package org.example.demos;

import org.example.battles.Battle;
import org.example.characters.*;
import org.example.weapons.Weapon;

public class Main {
    public static void main(String[] args) {

        Army army1 = new Army()
                .addUnits(WarriorImpl::new, 5)
                .addUnits(Defender::new, 4)
                .addUnits(Defender::new, 5);


        Army army2 = new Army()
                .addUnits(Vampire::new, 4);


        army1.equipWarriorAtPosition(0, Weapon.newMagicWand());
        army2.equipWarriorAtPosition(0, Weapon.newMagicWand());
        System.out.println(Battle.fight(army1, army2));
    }
}
