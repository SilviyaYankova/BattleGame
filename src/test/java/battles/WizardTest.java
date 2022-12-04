package battles;

import org.example.battles.Battle;
import org.example.characters.*;
import org.example.weapons.Weapon;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WizardTest {

    @Test
    @DisplayName("1.")
    void one(){
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
    void two(){
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
}
