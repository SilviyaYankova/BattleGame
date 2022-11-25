package org.example.battles;

import org.example.characters.Army;
import org.example.characters.Lancer;
import org.example.characters.Warrior;
import org.example.characters.WarriorImpl;
import org.example.decorators.WarriorInArmy;

import java.util.Iterator;
import java.util.List;

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
            fight(it1.next(), it2.next());
        }

        return it1.hasNext();
    }

    public static boolean straightFight(Army army1, Army army2) {
        int count = 1;
        while (true) {
            Iterator<WarriorInArmy> it1 = army1.nextAliveIterator();
            Iterator<WarriorInArmy> it2 = army2.nextAliveIterator();
            System.out.println("Round: " + count);

            boolean first = it1.hasNext();
            boolean second = it2.hasNext();

            if (!first) return false;
            if (!second) return false;

            while (first && second) {
                Warrior warrior1 = it1.next().getWarrior();
                Warrior warrior2 = it2.next().getWarrior();
                fight(warrior1, warrior2);
                System.out.println(warrior1 + " -> " + warrior2);
                first = it1.hasNext();
                second = it2.hasNext();
            }
            count += 1;
            System.out.println();

        }
    }
}
