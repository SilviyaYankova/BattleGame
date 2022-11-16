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
        return List.of(arguments(new Warrior(), new Knight(), false),
                       arguments(new Warrior(), new Warrior(), true),
                       arguments(new Knight(), new Warrior(), true),
                       arguments(new Knight(), new Knight(), true));
    }

    @DisplayName("Two armies fight")
    @ParameterizedTest(name = "{0} fights against {1}, expected  result = {2}")
    @MethodSource("testArmiesFight")
    void testArmiesFight(Army army1, Army army2, boolean expected) {

        var test = Battle.fight(army1, army2);

        assertEquals(expected, test);
    }

    public static List<Arguments> testArmiesFight() {

        return List.of(
                arguments(new Army().addUnits(Warrior::new, 1),
                          new Army().addUnits(Warrior::new, 2),
                          false),
                arguments(new Army().addUnits(Warrior::new, 2),
                          new Army().addUnits(Warrior::new, 3),
                          false),
                arguments(new Army().addUnits(Warrior::new, 5),
                          new Army().addUnits(Warrior::new, 7),
                          false),
                arguments(new Army().addUnits(Warrior::new, 20),
                          new Army().addUnits(Warrior::new, 11),
                          true),
                arguments(new Army().addUnits(Warrior::new, 10),
                          new Army().addUnits(Warrior::new, 11),
                          true),
                arguments(new Army().addUnits(Warrior::new, 11),
                          new Army().addUnits(Warrior::new, 7),
                          true),
                arguments(new Army().addUnits(Warrior::new, 5)
                                    .addUnits(Defender::new, 4)
                                    .addUnits(Defender::new, 5),
                          new Army().addUnits(Warrior::new, 4),
                          true),
                arguments(new Army().addUnits(Defender::new, 5)
                                    .addUnits(Warrior::new, 20)
                                    .addUnits(Defender::new, 4),
                          new Army().addUnits(Warrior::new, 21),
                          true),
                arguments(new Army().addUnits(Warrior::new, 10)
                                    .addUnits(Defender::new, 5)
                                    .addUnits(Defender::new, 10),
                          new Army().addUnits(Defender::new, 10),
                          true),
                arguments(new Army().addUnits(Defender::new, 2)
                                    .addUnits(Warrior::new, 1)
                                    .addUnits(Defender::new, 1),
                          new Army().addUnits(Warrior::new, 5),
                          false),
                arguments(new Army().addUnits(Warrior::new, 10)
                                    .addUnits(Knight::new, 5),
                          new Army().addUnits(Warrior::new, 30),
                          false),
                arguments(new Army().addUnits(Knight::new, 3),
                          new Army().addUnits(Warrior::new, 3),
                          true)
        );
    }
}