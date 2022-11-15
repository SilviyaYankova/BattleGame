package battles;

import characters.Army;
import characters.Warrior;

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
        Warrior attacker = army1.getFighter();
        Warrior defender = army2.getFighter();

        while (army1.isAlive() && army2.isAlive()) {
            boolean attackerWins = Battle.fight(attacker, defender);

            if (attackerWins) {
                army2.troops.remove(defender);
                if (army2.isAlive()) {
                    defender = army2.getFighter();
                }
            } else {
                army1.troops.remove(attacker);
                if (army1.isAlive()) {
                    attacker = army1.getFighter();
                }
            }
        }
        return !army1.troops.isEmpty();
    }

}
