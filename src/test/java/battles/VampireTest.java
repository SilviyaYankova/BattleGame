package battles;

import org.example.battles.Battle;
import org.example.characters.Army;
import org.example.characters.Defender;
import org.example.characters.Vampire;
import org.example.characters.WarriorImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class VampireTest {
    @DisplayName("Two armies fight")
    @ParameterizedTest(name = "[{index}] {0} fights against {1}, expected  result = {2}")
    @MethodSource("testArmiesFight")
    void testArmiesFight(Army army1, Army army2, boolean expected) {

        var test = Battle.fight(army1, army2);

        assertEquals(expected, test);
    }

    public static List<Arguments> testArmiesFight() {

        return List.of(
                arguments(new Army()
                                  .addUnits(Defender::new, 2)
                                  .addUnits(Vampire::new, 2)
                                  .addUnits(WarriorImpl::new, 1),
                          new Army()
                                  .addUnits(WarriorImpl::new, 2)
                                  .addUnits(Defender::new, 2)
                                  .addUnits(Vampire::new, 3),
                          false),
                arguments(new Army()
                                  .addUnits(Defender::new, 5)
                                  .addUnits(Vampire::new, 6)
                                  .addUnits(WarriorImpl::new, 7),
                          new Army()
                                  .addUnits(WarriorImpl::new, 6)
                                  .addUnits(Defender::new, 6)
                                  .addUnits(Vampire::new, 6),
                          false),
                arguments(new Army()
                                  .addUnits(Defender::new, 2)
                                  .addUnits(Vampire::new, 3)
                                  .addUnits(WarriorImpl::new, 4),
                          new Army()
                                  .addUnits(WarriorImpl::new, 4)
                                  .addUnits(Defender::new, 4)
                                  .addUnits(Vampire::new, 3),
                          false),
                arguments(new Army()
                                  .addUnits(Defender::new, 11)
                                  .addUnits(Vampire::new, 3)
                                  .addUnits(WarriorImpl::new, 4),
                          new Army()
                                  .addUnits(WarriorImpl::new, 4)
                                  .addUnits(Defender::new, 4)
                                  .addUnits(Vampire::new, 13),
                          true),
                arguments(new Army()
                                  .addUnits(Defender::new, 9)
                                  .addUnits(Vampire::new, 3)
                                  .addUnits(WarriorImpl::new, 8),
                          new Army()
                                  .addUnits(WarriorImpl::new, 4)
                                  .addUnits(Defender::new, 4)
                                  .addUnits(Vampire::new, 13),
                          true),
                arguments(new Army()
                                  .addUnits(Vampire::new, 1)
                                  .addUnits(WarriorImpl::new, 4),
                          new Army()
                                  .addUnits(Vampire::new, 3)
                                  .addUnits(WarriorImpl::new, 2),
                          true)

        );
    }
}
