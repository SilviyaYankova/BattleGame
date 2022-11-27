package org.example.demos;

import org.example.battles.Battle;
import org.example.characters.*;
import org.example.weapons.*;

import static org.example.weapons.Weapon.newGreatAxe;
import static org.example.weapons.Weapon.newShield;
import static org.example.weapons.Weapon.newKatana;
import static org.example.weapons.Weapon.newMagicWand;
import static org.example.weapons.Weapon.newSword;

public class Main {
    public static void main(String[] args) {
//
//        var ogre = new WarriorImpl();
//        var lancelot = new Knight();
//        var richard = new Defender();
//        var eric = new Vampire();
//        var freelancer = new Lancer();
//        var priest = new Healer();
//
//
//        ogre.equipWeapon(Weapon.newSword());
//        ogre.equipWeapon(Weapon.newShield());
//        ogre.equipWeapon(new WeaponImpl(50, 10, 5, 150, 8));
//        lancelot.equipWeapon(new WeaponImpl(50, 10, 5, 150, 8));
//        richard.equipWeapon(Weapon.newShield());
//        eric.equipWeapon(new WeaponImpl(50, 10, 5, 150, 8));
//        freelancer.equipWeapon(newGreatAxe());
//        freelancer.equipWeapon(Weapon.newKatana());
//        priest.equipWeapon(Weapon.newMagicWand());
//        priest.equipWeapon(Weapon.newShield());
//
//        System.out.println(ogre.getHealth());
//        System.out.println(lancelot.getAttack());
//        System.out.println(richard.getDefense());
//        System.out.println(eric.getVampirism());
//        System.out.println(freelancer.getHealth());
//        System.out.println(priest.getHealPower());
//
//        System.out.println(Battle.fight(ogre, eric));
//        System.out.println(Battle.fight(priest, richard));
//        System.out.println(Battle.fight(lancelot, freelancer));

//        var myArmy = new Army();
//        myArmy.addUnits(Knight::new, 1);
//        myArmy.addUnits(Lancer::new, 1);
//
//        var enemyArmy = new Army();
//        enemyArmy.addUnits(Vampire::new, 1);
//        enemyArmy.addUnits(Healer::new, 1);
//
//        myArmy.equipWarriorAtPosition(0, newGreatAxe());
//        myArmy.equipWarriorAtPosition(1, new WeaponImpl(50, 10, 5, 150, 8));
//
//        enemyArmy.equipWarriorAtPosition(0, newKatana());
//        enemyArmy.equipWarriorAtPosition(1, newMagicWand());
//
//        System.out.println(Battle.fight(myArmy, enemyArmy));

        Defender warrior1 = new Defender();
        warrior1.equipWeapon(newShield());

        Lancer warrior2 = new Lancer();
        warrior2.equipWeapon(newGreatAxe());

        System.out.println(Battle.fight(warrior1, warrior2));
    }
}
