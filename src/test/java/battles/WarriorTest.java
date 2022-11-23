package battles;

import org.example.battles.Battle;
import org.example.characters.Army;
import org.example.characters.Vampire;
import org.example.characters.WarriorImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class WarriorTest {
    @DisplayName("Two armies fight")
    @ParameterizedTest(name = "[{index}] {0} fights against {1}, expected  result = {2}")
    @MethodSource("testArmiesFight")
    void testArmiesFight(Army army1, Army army2, boolean expected) {

        var test = Battle.fight(army1, army2);

        assertEquals(expected, test);
    }

    public static List<Arguments> testArmiesFight() {

        return List.of(
                arguments(new Army().addUnits(WarriorImpl::new, 1),
                          new Army().addUnits(WarriorImpl::new, 2),
                          false),
                arguments(new Army().addUnits(WarriorImpl::new, 2),
                          new Army().addUnits(WarriorImpl::new, 3),
                          false),
                arguments(new Army().addUnits(WarriorImpl::new, 5),
                          new Army().addUnits(WarriorImpl::new, 7),
                          false),
                arguments(new Army().addUnits(WarriorImpl::new, 20),
                          new Army().addUnits(WarriorImpl::new, 11),
                          true),
                arguments(new Army().addUnits(WarriorImpl::new, 10),
                          new Army().addUnits(WarriorImpl::new, 11),
                          true),
                arguments(new Army().addUnits(WarriorImpl::new, 11),
                          new Army().addUnits(WarriorImpl::new, 7),
                          true)
        );
    }
}
