package org.example.battles;

import org.example.characters.Army;
import org.example.characters.Warrior;
import org.example.handlers.HealHandler;
import org.example.handlers.HealHandlerImpl;

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
                healWarriorIfPossible(warrior2);

                warrior2.hit(warrior1);
                healWarriorIfPossible(warrior1);
            }
        }

        return warrior1.isAlive();
    }

    private static void healWarriorIfPossible(Warrior warrior2) {
        HealHandler healHandler = new HealHandlerImpl();
        healHandler.heal(warrior2);
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
}
