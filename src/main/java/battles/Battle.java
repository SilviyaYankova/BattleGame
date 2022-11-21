package battles;

import characters.Army;
import characters.Warrior;

import java.util.Iterator;

public class Battle {

    /**
     * Fighting between warriors
     *
     * @param warrior1 attacks first;
     * @param warrior2 attacks second
     * @return true if first warrior is alive or false if not
     */
    public static boolean fight(Warrior warrior1, Warrior warrior2) {

        while (warrior1.isAlive() && warrior2.isAlive()) {

            warrior1.hit(warrior2);

            if (warrior2.isAlive()) {
                warrior2.hit(warrior1);
            }
        }

        return warrior1.isAlive();
    }

    /**
     * Fighting between armies
     *
     * @param army1 attacks first;
     * @param army2 attacks second
     * @return true if first army wins or false if not
     */
    public static boolean fight(Army army1, Army army2) {
        var it1 = army1.fistsAliveIterator();
        var it2 = army2.fistsAliveIterator();

        Warrior warrior1 = it1.next();
        Warrior warrior2 = it2.next();
        army1.setArmyToWarrior(army1, warrior1);
        army2.setArmyToWarrior(army2, warrior2);

        while (it1.hasNext() && it2.hasNext()) {
            fight(it1.next(), it2.next());
        }

        return it1.hasNext();
    }
}
