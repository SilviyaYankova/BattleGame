package battles;

import characters.Rookie;
import org.example.battles.Battle;
import org.example.characters.*;
import org.example.weapons.*;
import org.example.weapons.SuperWeapon;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.example.weapons.Weapon.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WeaponTest {

    @Test
    @DisplayName("1. ")
    void one() {
        Warrior warrior = new WarriorImpl();
        warrior.equipWeapon(newSword());

        Warrior vampire = new Vampire();
        vampire.equipWeapon(newMagicWand());

        assertFalse(Battle.fight(warrior, vampire));
    }

    @Test
    @DisplayName("2. ")
    void two() {
        Warrior warrior1 = new Defender();
        warrior1.equipWeapon(newShield());

        Warrior warrior2 = new Lancer();
        warrior2.equipWeapon(newGreatAxe());

        assertFalse(Battle.fight(warrior1, warrior2));
    }

    @Test
    @DisplayName("3. ")
    void three() {
        Warrior warrior1 = new Healer();
        warrior1.equipWeapon(newMagicWand());

        Warrior warrior2 = new Knight();
        warrior2.equipWeapon(newKatana());

        assertFalse(Battle.fight(warrior1, warrior2));
    }

    @Test
    @DisplayName("4. ")
    void four() {
        Warrior warrior1 = new Defender();
        warrior1.equipWeapon(newShield());
        warrior1.equipWeapon(newMagicWand());

        Warrior warrior2 = new Vampire();
        warrior1.equipWeapon(newShield());
        warrior2.equipWeapon(newKatana());

        assertFalse(Battle.fight(warrior1, warrior2));
    }

    @Test
    @DisplayName("5. ")
    void five() {
        Weapon weapon_1 = newMagicWand();
        Weapon weapon_2 = newGreatAxe();

        Army myArmy = new Army();
        myArmy.addUnits(Knight::new, 1);
        myArmy.addUnits(Lancer::new, 1);

        Army enemyArmy = new Army();
        enemyArmy.addUnits(Vampire::new, 1);
        enemyArmy.addUnits(Healer::new, 1);

        myArmy.equipWarriorAtPosition(0, weapon_1);
        myArmy.equipWarriorAtPosition(1, weapon_2);

        enemyArmy.equipWarriorAtPosition(0, weapon_1);
        enemyArmy.equipWarriorAtPosition(1, weapon_2);

        assertTrue(Battle.fight(myArmy, enemyArmy));
    }

    @Test
    @DisplayName("6. ")
    void six() {
        Weapon weapon_1 = newSword();
        Weapon weapon_2 = newGreatAxe();

        Army myArmy = new Army();
        myArmy.addUnits(Defender::new, 1);
        myArmy.addUnits(WarriorImpl::new, 1);

        Army enemyArmy = new Army();
        enemyArmy.addUnits(Knight::new, 1);
        enemyArmy.addUnits(Healer::new, 1);

        myArmy.equipWarriorAtPosition(0, weapon_2);
        myArmy.equipWarriorAtPosition(1, weapon_2);

        enemyArmy.equipWarriorAtPosition(0, weapon_1);
        enemyArmy.equipWarriorAtPosition(1, weapon_2);

        assertTrue(Battle.fight(myArmy, enemyArmy));
    }

    @Test
    @DisplayName("7. ")
    void seven() {
        Weapon weapon_1 = newKatana();
        Weapon weapon_2 = newShield();

        Army myArmy = new Army();
        myArmy.addUnits(Defender::new, 2);

        Army enemyArmy = new Army();
        enemyArmy.addUnits(Knight::new, 1);
        enemyArmy.addUnits(Vampire::new, 1);

        myArmy.equipWarriorAtPosition(0, weapon_1);
        myArmy.equipWarriorAtPosition(1, weapon_1);

        enemyArmy.equipWarriorAtPosition(0, weapon_1);
        enemyArmy.equipWarriorAtPosition(1, weapon_1);

        assertFalse(Battle.fight(myArmy, enemyArmy));
    }

    @Test
    @DisplayName("8. ")
    void eight() {
        Weapon weapon_1 = new SuperWeapon(-20, 6, 1, 40, -2);
        Weapon weapon_2 = new SuperWeapon(20, -2, 2, -55, 3);

        Army myArmy = new Army();
        myArmy.addUnits(Knight::new, 3);

        Army enemyArmy = new Army();
        enemyArmy.addUnits(WarriorImpl::new, 1);
        enemyArmy.addUnits(Defender::new, 2);

        myArmy.equipWarriorAtPosition(0, weapon_1);
        myArmy.equipWarriorAtPosition(1, weapon_1);
        myArmy.equipWarriorAtPosition(2, weapon_2);

        enemyArmy.equipWarriorAtPosition(0, weapon_1);
        enemyArmy.equipWarriorAtPosition(1, weapon_2);
        enemyArmy.equipWarriorAtPosition(2, weapon_2);

        assertTrue(Battle.fight(myArmy, enemyArmy));
    }

    @Test
    @DisplayName("9. ")
    void nine() {
        Weapon weapon_1 = new SuperWeapon(-20, 1, 1, 40, -2);
        Weapon weapon_2 = new SuperWeapon(20, 2, 2, -55, 3);

        Army myArmy = new Army();
        myArmy.addUnits(Vampire::new, 3);

        Army enemyArmy = new Army();
        enemyArmy.addUnits(WarriorImpl::new, 1);
        enemyArmy.addUnits(Defender::new, 2);

        myArmy.equipWarriorAtPosition(0, weapon_1);
        myArmy.equipWarriorAtPosition(1, weapon_1);
        myArmy.equipWarriorAtPosition(2, weapon_2);

        enemyArmy.equipWarriorAtPosition(0, weapon_1);
        enemyArmy.equipWarriorAtPosition(1, weapon_2);
        enemyArmy.equipWarriorAtPosition(2, weapon_2);

        assertFalse(Battle.fight(myArmy, enemyArmy));
    }

    @Test
    @DisplayName("10. ")
    void ten() {
        Weapon weapon_1 = newKatana();
        Weapon weapon_2 = newShield();

        Army myArmy = new Army();
        myArmy.addUnits(Vampire::new, 2);
        myArmy.addUnits(Rookie::new, 2);

        Army enemyArmy = new Army();
        enemyArmy.addUnits(WarriorImpl::new, 1);
        enemyArmy.addUnits(Defender::new, 2);

        myArmy.equipWarriorAtPosition(0, weapon_1);
        myArmy.equipWarriorAtPosition(1, weapon_1);
        myArmy.equipWarriorAtPosition(2, weapon_2);

        enemyArmy.equipWarriorAtPosition(0, weapon_1);
        enemyArmy.equipWarriorAtPosition(1, weapon_2);
        enemyArmy.equipWarriorAtPosition(2, weapon_2);

        assertTrue(Battle.fight(myArmy, enemyArmy));
    }

    @Test
    @DisplayName("11. ")
    void eleven() {
        Weapon weapon_1 = newSword();
        Weapon weapon_2 = newGreatAxe();

        Army myArmy = new Army();
        myArmy.addUnits(Vampire::new, 3);

        Army enemyArmy = new Army();
        enemyArmy.addUnits(WarriorImpl::new, 1);
        enemyArmy.addUnits(Defender::new, 1);

        myArmy.equipWarriorAtPosition(0, weapon_2);
        myArmy.equipWarriorAtPosition(1, weapon_2);
        myArmy.equipWarriorAtPosition(2, weapon_2);

        enemyArmy.equipWarriorAtPosition(0, weapon_1);
        enemyArmy.equipWarriorAtPosition(1, weapon_1);

        assertTrue(Battle.fight(myArmy, enemyArmy));
    }

    @Test
    @DisplayName("12. ")
    void twelve() {
        Weapon weapon_1 = newKatana();
        Weapon weapon_2 = newMagicWand();

        Army myArmy = new Army();
        myArmy.addUnits(Rookie::new, 3);

        Army enemyArmy = new Army();
        enemyArmy.addUnits(Defender::new, 1);
        enemyArmy.addUnits(Healer::new, 1);

        myArmy.equipWarriorAtPosition(0, weapon_1);
        myArmy.equipWarriorAtPosition(1, weapon_1);
        myArmy.equipWarriorAtPosition(2, weapon_1);

        enemyArmy.equipWarriorAtPosition(0, weapon_2);
        enemyArmy.equipWarriorAtPosition(1, weapon_2);

        assertFalse(Battle.fight(myArmy, enemyArmy));
    }
}