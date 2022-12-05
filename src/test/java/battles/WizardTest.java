package battles;

import characters.Rookie;
import org.example.battles.Battle;
import org.example.characters.*;
import org.example.weapons.Weapon;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WizardTest {

    @Test
    @DisplayName("1. Wizard vs Wizard, both without attack")
    void wizardVsWizardWithoutAttacksShouldReturnFalse() {
        Wizard wizard1 = new Wizard(2);
        Wizard wizard2 = new Wizard(2);
        assertFalse(Battle.fight(wizard1, wizard2));
    }

    @Test
    @DisplayName("2. Adding un allowed weapon to wizard")
    void wizardWithUnAllowedWeaponShouldReturnTrue() {
        Wizard wizard1 = new Wizard(2);
        Wizard wizard2 = new Wizard(2);

        wizard1.equipWeapon(Weapon.newShield());

        assertEquals(0, wizard1.getWeapons().size());
        assertEquals(0, wizard2.getWeapons().size());
    }

    @Test
    @DisplayName("3. Wizard with weapon vs Wizard without weapon")
    void wizardWithWeaponVsWizardWithoutWeaponShouldReturnTrue() {
        Wizard wizard1 = new Wizard(2);
        Wizard wizard2 = new Wizard(2);

        wizard1.equipWeapon(Weapon.newMagicWand());

        assertTrue(Battle.fight(wizard1, wizard2));
    }

    @Test
    @DisplayName("4. Wizards with weapons")
    void wizardsWithWeaponsShouldReturnTrue() {
        Wizard wizard1 = new Wizard(2);
        Wizard wizard2 = new Wizard(2);

        wizard1.equipWeapon(Weapon.newMagicWand());
        wizard2.equipWeapon(Weapon.newMagicWand());

        assertTrue(Battle.fight(wizard1, wizard2));
    }


    @Test
    @DisplayName("5. Equal armies of wizards and warlords")
    void equalArmiesOfWizardsAndWarlordsShouldReturnTrue() {
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

        assertTrue(Battle.fight(army1, army2));
    }


    @Test
    @DisplayName("6. Stronger Wizard in the second army")
    void strongerWizardInTheSecondArmyShouldReturnFalse() {
        var army1 = new Army()
                .addUnits(() -> new Wizard(1), 1)
                .addUnits(Warlord::new, 1);

        var army2 = new Army()
                .addUnits(() -> new Wizard(2), 1)
                .addUnits(Warlord::new, 1);

        army1.equipWarriorAtPosition(0, Weapon.newMagicWand());
        army2.equipWarriorAtPosition(0, Weapon.newMagicWand());

        army1.moveUnits();
        army2.moveUnits();

        assertFalse(Battle.fight(army1, army2));
    }


    @Test
    @DisplayName("7. Armies with knight, vampire")
    void armyOneFightsWithArmyTwoWithVampireShouldReturnTrue() {
        var army1 = new Army()
                .addUnits(() -> new Wizard(1), 1)
                .addUnits(Knight::new, 1)
                .addUnits(Warlord::new, 1);

        var army2 = new Army()
                .addUnits(() -> new Wizard(2), 1)
                .addUnits(Warlord::new, 1)
                .addUnits(Vampire::new, 1);

        army1.equipWarriorAtPosition(0, Weapon.newMagicWand());
        army2.equipWarriorAtPosition(0, Weapon.newMagicWand());

        army1.moveUnits();
        army2.moveUnits();

        assertTrue(Battle.fight(army1, army2));
    }


    @Test
    @DisplayName("8. Stronger first army wizards without Magic wand")
    void strongerFirstArmyWizardsWithoutMagicWandShouldReturnTrue() {
        var army1 = new Army()
                .addUnits(WarriorImpl::new, 2)
                .addUnits(() -> new Wizard(2), 2)
                .addUnits(Lancer::new, 3)
                .addUnits(Defender::new, 1)
                .addUnits(Warlord::new, 1);

        var army2 = new Army()
                .addUnits(Warlord::new, 5)
                .addUnits(Vampire::new, 1)
                .addUnits(() -> new Wizard(3), 1)
                .addUnits(Knight::new, 1);

        army1.moveUnits();
        army2.moveUnits();

        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    @DisplayName("9. Stronger first army - Wizard with Magic wand")
    void strongerFirstArmyWizardWithMagicWandShouldReturnTrue() {
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

        army2.equipWarriorAtPosition(0, Weapon.newMagicWand());

        army1.moveUnits();
        army2.moveUnits();

        assertTrue(Battle.fight(army1, army2));
    }


    @Test
    @DisplayName("10. Stronger first army, both Wizards with Magic wand")
    void strongerFirstArmyWizardsWithMagicWandShouldReturnTrue() {
        var army1 = new Army()
                .addUnits(() -> new Wizard(1), 1)
                .addUnits(WarriorImpl::new, 2)
                .addUnits(Lancer::new, 3)
                .addUnits(Healer::new, 2)
                .addUnits(Defender::new, 1)
                .addUnits(Warlord::new, 1);

        var army2 = new Army()
                .addUnits(() -> new Wizard(1), 1)
                .addUnits(Warlord::new, 5)
                .addUnits(Vampire::new, 1)
                .addUnits(Healer::new, 3)
                .addUnits(Knight::new, 1);

        army1.equipWarriorAtPosition(0, Weapon.newMagicWand());
        army2.equipWarriorAtPosition(0, Weapon.newMagicWand());

        army1.moveUnits();
        army2.moveUnits();

        assertTrue(Battle.fight(army1, army2));
    }


    @Test
    @DisplayName("11. Straight fight battle")
    void straightFightBattleShouldReturnTrue() {
        var army1 = new Army()
                .addUnits(WarriorImpl::new, 2)
                .addUnits(() -> new Wizard(1), 5)
                .addUnits(Lancer::new, 3)
                .addUnits(Defender::new, 1)
                .addUnits(Warlord::new, 1);

        var army2 = new Army()
                .addUnits(Warlord::new, 5)
                .addUnits(() -> new Wizard(1), 5)
                .addUnits(Vampire::new, 1)
                .addUnits(Rookie::new, 1)
                .addUnits(Knight::new, 1);

//        army1.equipWarriorAtPosition(0, Weapon.newSword());
        army2.equipWarriorAtPosition(0, Weapon.newShield());

        army1.equipWarriorAtPosition(2, Weapon.newMagicWand());
        army2.equipWarriorAtPosition(1, Weapon.newMagicWand());

        army1.moveUnits();
        army2.moveUnits();

        assertTrue(Battle.straightFight(army1, army2));

    }
}
