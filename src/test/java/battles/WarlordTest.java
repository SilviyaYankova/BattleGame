package battles;

import characters.Rookie;
import org.example.battles.Battle;
import org.example.characters.*;
import org.example.weapons.Weapon;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WarlordTest {

    @Test
    @DisplayName("10. Fight")
    void tenFight() {
        Warrior unit1 = new Defender();
        Warrior unit2 = new Warlord();

        assertFalse(Battle.fight(unit1, unit2));
    }

    @Test
    @DisplayName("11. Fight")
    void elevenFight() {
        Warrior unit1 = new Warlord();
        Warrior unit2 = new Vampire();

        assertTrue(Battle.fight(unit1, unit2));
    }

    @Test
    @DisplayName("12. Fight")
    void twelveFight() {
        Warrior unit1 = new Warlord();
        Warrior unit2 = new Knight();

        assertTrue(Battle.fight(unit1, unit2));
    }

    @Test
    @DisplayName("23. Battle")
    void battle23() {
        var army1 = new Army();
        army1.addUnits(Warlord::new, 1);
        army1.addUnits(WarriorImpl::new, 2);
        army1.addUnits(Lancer::new, 2);
        army1.addUnits(Healer::new, 2);

        var army2 = new Army();
        army2.addUnits(Warlord::new, 1);
        army2.addUnits(Vampire::new, 1);
        army2.addUnits(Healer::new, 2);
        army2.addUnits(Knight::new, 2);

        army1.moveUnits();
        army2.moveUnits();

        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    @DisplayName("24. Battle")
    void battle24() {
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

        assertFalse(Battle.fight(army1, army2));
    }

    @Test
    @DisplayName("25. Battle")
    void battle25() {
        var army1 = new Army()
                .addUnits(WarriorImpl::new, 2)
                .addUnits(Lancer::new, 3)
                .addUnits(Defender::new, 1)
                .addUnits(Warlord::new, 4);

        var army2 = new Army()
                .addUnits(Warlord::new, 1)
                .addUnits(Vampire::new, 1)
                .addUnits(Rookie::new, 1)
                .addUnits(Knight::new, 1);

        army1.equipWarriorAtPosition(0, Weapon.newSword());
        army2.equipWarriorAtPosition(0, Weapon.newShield());

        army1.moveUnits();
        army2.moveUnits();

        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    @DisplayName("26. Battle")
    void battle26() {
        var army1 = new Army()
                .addUnits(WarriorImpl::new, 2)
                .addUnits(Lancer::new, 3)
                .addUnits(Defender::new, 1)
                .addUnits(Warlord::new, 1);

        var army2 = new Army()
                .addUnits(Warlord::new, 5)
                .addUnits(Vampire::new, 1)
                .addUnits(Rookie::new, 1)
                .addUnits(Knight::new, 1);

        army1.equipWarriorAtPosition(0, Weapon.newSword());
        army2.equipWarriorAtPosition(0, Weapon.newShield());

        army1.moveUnits();
        army2.moveUnits();

        assertFalse(Battle.straightFight(army1, army2));

    }
}
