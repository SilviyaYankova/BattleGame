package battles;

import characters.Army;
import characters.Warrior;

public class Battle {

    /**
     * Fighting between warriors
     *
     * @param warrior1 always attacks first;
     * @param warrior2 always attacks second
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

    public static boolean fight(Army army1, Army army2) {


        return true;
    }
}
