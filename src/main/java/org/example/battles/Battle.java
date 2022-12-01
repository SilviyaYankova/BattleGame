package org.example.battles;

import org.example.characters.Army;
import org.example.characters.Lancer;
import org.example.characters.Warlord;
import org.example.characters.Warrior;
import org.example.decorators.WarriorInArmy;

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

        while (it1.hasNext() && it2.hasNext()) {
            Warrior warrior1 = it1.next();
            Warrior warrior2 = it2.next();

            fight(warrior1, warrior2);

            if (warrior1.isAlive()) {
                army2.moveUnits();
                WarriorInArmy warrior = army2.getTroops().get(army2.getTroops().size() - 1);
                if (warrior.unwrap() instanceof Warlord) {
                    it2 = army2.fistsAliveIterator();
                }
            } else {
                army1.moveUnits();
                WarriorInArmy warrior = army1.getTroops().get(army1.getTroops().size() - 1);
                if (warrior.unwrap() instanceof Warlord){
                    it1 = army1.fistsAliveIterator();
                }
            }

        }

        return it1.hasNext();
    }

    public static boolean straightFight(Army army1, Army army2) {
        boolean res;
        while (true) {
            var it1 = army1.iterator();
            var it2 = army2.iterator();

            if (!it1.hasNext()) {
                res = false;
                break;
            }

            if (!it2.hasNext()) {
                res = true;
                break;
            }

            while (it1.hasNext() && it2.hasNext()) {
                fight(it1.next(), it2.next());
            }
        }
        return res;
    }
}
