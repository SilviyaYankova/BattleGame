package battles;

import characters.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class Duel {
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
                arguments(new Knight(), new Warrior(), true),
                arguments(new Warrior(), new Warrior(), true),
                arguments(new Knight(), new Knight(), true),
                arguments(new Warrior(), new Warrior(), true),
                arguments(new Warrior(), new Knight(), false),
                arguments(new Defender(), new Rookie(), true),
                arguments(new Defender(), new Vampire(), true),
                arguments(new Vampire(), new Defender(), false),
                arguments(new Warrior(), new Vampire(), true)
        );
    }

    @DisplayName("Three warriors fight")
    @ParameterizedTest(name = "[{index}] {0} fights against {1}, expected  result = {2}")
    @MethodSource("testThreeWarriorFight")
    void testThreeWarriorFight(Warrior warrior1, Warrior warrior2, Warrior warrior3, boolean expected) {

        Battle.fight(warrior1, warrior2);
        var test = Battle.fight(warrior2, warrior3);

        assertEquals(expected, test);
    }

    public static List<Arguments> testThreeWarriorFight() {
        return List.of(
                arguments(new Warrior(), new Knight(), new Warrior(), false),
                arguments(new Defender(), new Rookie(), new Warrior(), false)
        );
    }
}
