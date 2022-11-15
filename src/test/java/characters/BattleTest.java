package characters;

import battles.Battle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {

    Warrior warrior;
    Warrior knight;

    @BeforeEach
    void createCharacters() {
        warrior = new Warrior();
        knight = new Knight();
    }

    @Test
    @DisplayName("1. Fight")
    void whenWarriorFightsAgainstKnightExpectWarriorLoses() {
        assertFalse(Battle.fight(warrior, knight));
    }

    @Test
    @DisplayName("2. Fight")
    void whenKnightFightsAgainstWarriorExpectKnightWins() {
        Warrior slevin = new Warrior();

        assertTrue(Battle.fight(knight, slevin));
    }

    @Test
    @DisplayName("3. Fight")
    void whenWarriorFightsAgainstWarriorExpectFirstWarriorWins() {
        Warrior mars = new Warrior();

        Battle.fight(warrior, mars);

        assertTrue(warrior.isAlive());
    }

    @Test
    @DisplayName("4. Fight")
    void whenKnightFightsAgainstWarrior2ExpectKnightWins() {
        Battle.fight(knight, warrior);

        assertTrue(knight.isAlive());
    }

    @Test
    @DisplayName("5. Fight")
    void whenWarriorFightsAgainstWarrior2ExpectFirstWarriorWins() {
        Warrior wife = new Warrior();

        Battle.fight(warrior, wife);

        assertFalse(wife.isAlive());
    }

    @Test
    @DisplayName("6. Fight")
    void whenWarriorFightsAgainstKnight2ExpectWarriorLoses() {
        Battle.fight(warrior, knight);

        assertTrue(knight.isAlive());
    }

    @Test
    @DisplayName("7. Fight")
    void whenWarriorFightsAgainstKnightAndKnightFightsAgainstWarriorKnightsLoses() {
        Warrior unitThree = new Warrior();

        boolean fight = Battle.fight(warrior, knight);
        boolean fight1 = Battle.fight(knight, unitThree);
        assertFalse(fight);
        assertFalse(fight1);
    }
}