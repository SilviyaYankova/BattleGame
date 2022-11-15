package characters;

import battles.Battle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BattleTest {

    @DisplayName("Two warriors fight")
    @ParameterizedTest(name = "[{index}] {0} fights against {1}, expected  result = {2}")
    @MethodSource("testTwoWarriorFight")
    void testTwoWarriorFight(Warrior warrior1, Warrior warrior2, boolean expected) {

        var test = Battle.fight(warrior1, warrior2);

        assertEquals(expected, test);
    }

    public static List<Arguments> testTwoWarriorFight() {
        return List.of(
                arguments(new Warrior(), new Knight(), false),
                arguments(new Warrior(), new Warrior(), true),
                arguments(new Knight(), new Warrior(), true),
                arguments(new Knight(), new Knight(), true)
                );
    }
}