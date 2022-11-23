package battles;

import characters.*;
import org.example.battles.Battle;
import org.example.characters.Defender;
import org.example.characters.Knight;
import org.example.characters.Vampire;
import org.example.characters.WarriorImpl;
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
    void testTwoWarriorFight(WarriorImpl warrior1, WarriorImpl warrior2, boolean expected) {

        var test = Battle.fight(warrior1, warrior2);

        assertEquals(expected, test);
    }

    public static List<Arguments> testTwoWarriorFight() {
        return List.of(
                arguments(new WarriorImpl(), new Knight(), false),
                arguments(new Knight(), new WarriorImpl(), true),
                arguments(new WarriorImpl(), new WarriorImpl(), true),
                arguments(new Knight(), new Knight(), true),
                arguments(new WarriorImpl(), new WarriorImpl(), true),
                arguments(new WarriorImpl(), new Knight(), false),
                arguments(new Defender(), new Rookie(), true),
                arguments(new Defender(), new Vampire(), true),
                arguments(new Vampire(), new Defender(), false),
                arguments(new WarriorImpl(), new Vampire(), true)
        );
    }

    @DisplayName("Three warriors fight")
    @ParameterizedTest(name = "[{index}] {0} fights against {1}, expected  result = {2}")
    @MethodSource("testThreeWarriorFight")
    void testThreeWarriorFight(WarriorImpl warrior1, WarriorImpl warrior2, WarriorImpl warrior3, boolean expected) {

        Battle.fight(warrior1, warrior2);
        var test = Battle.fight(warrior2, warrior3);

        assertEquals(expected, test);
    }

    public static List<Arguments> testThreeWarriorFight() {
        return List.of(
                arguments(new WarriorImpl(), new Knight(), new WarriorImpl(), false),
                arguments(new Defender(), new Rookie(), new WarriorImpl(), false)
        );
    }
}
