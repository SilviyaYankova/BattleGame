package battles;

import org.example.battles.Battle;
import org.example.characters.*;
import org.example.weapons.Weapon;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WizardTest {

    @Test
    @DisplayName("1. Wizard vs Wizard, both without attack")
    void wizardVsWizardWithoutAttacks() {
        Wizard wizard1 = new Wizard(2);
        Wizard wizard2 = new Wizard(2);
        assertTrue(Battle.fight(wizard1, wizard2));
    }

    @Test
    @DisplayName("2. Adding un allowed weapon to wizard")
    void wizardWithUnAllowedWeapon() {
        Wizard wizard1 = new Wizard(2);
        Wizard wizard2 = new Wizard(2);

        wizard1.equipWeapon(Weapon.newShield());

        assertEquals(0, wizard1.getWeapons().size());
    }

    @Test
    @DisplayName("3. Wizard with weapon vs Wizard without weapon")
    void wizardWithWeaponVsWizardWithoutWeapon() {
        Wizard wizard1 = new Wizard(2);
        Wizard wizard2 = new Wizard(2);

        wizard1.equipWeapon(Weapon.newShield());

        assertTrue(Battle.fight(wizard1, wizard2));
    }

    @Test
    @DisplayName("4. Wizard with weapons")
    void wizardWithWeapons() {
        Wizard wizard1 = new Wizard(2);
        Wizard wizard2 = new Wizard(2);

        wizard1.equipWeapon(Weapon.newMagicWand());
        wizard2.equipWeapon(Weapon.newMagicWand());

        assertTrue(Battle.fight(wizard1, wizard2));
    }





















    @Test
    @DisplayName("1.")
    void one() {
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

        army1.moveUnits();
        army2.moveUnits();

        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    @DisplayName("2.")
    void two() {
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

        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    @DisplayName("3.")
    void three() {
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
    @DisplayName("4.")
    void four() {
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
}
