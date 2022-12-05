package org.example.battles;

import lombok.extern.slf4j.Slf4j;
import org.example.characters.Army;
import org.example.characters.Warrior;

@Slf4j
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
            log.atDebug().log("{} vs {}", warrior1.unwrap(), warrior2.unwrap());
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

        int round = 1;
        while (it1.hasNext() && it2.hasNext()) {
            Warrior warrior1 = it1.next();
            Warrior warrior2 = it2.next();

            log.atDebug().log("Army1 {} fights Army2 {}", army1.getTroops().size(), army2.getTroops().size());
            System.out.println("Round: " + round);
            log.atDebug().log("{} {attack = {}} hits {} {attack = {}}", warrior1.unwrap(), warrior1.getAttack(),
                              warrior2.unwrap(), warrior2.getAttack());

            fight(warrior1, warrior2);

            if (warrior1.isAlive()) {
                log.atDebug().log("Army2 is trying to move units...");

                army2.moveUnits();

                if (army2.getWarlord() != null) {
                    it2 = army2.fistsAliveIterator();
                }
            } else {
                log.atDebug().log("Army1 is trying to move units...");

                army1.moveUnits();

                if (army1.getWarlord() != null) {
                    it1 = army1.fistsAliveIterator();
                }
            }
            round++;
            log.atDebug().log("");
        }

        return it1.hasNext();
    }

    public static boolean straightFight(Army army1, Army army2) {
        boolean res;
        int round = 1;
        while (true) {
            army1.moveUnits();
            army2.moveUnits();
            var it1 = army1.iterator();
            var it2 = army2.iterator();
            log.atDebug().log("Round: {}", round);
            log.atDebug().log("{} vs {}", army1.getTroops().size(), army2.getTroops().size());

            if (!it1.hasNext()) {
                res = false;
                break;
            }

            if (!it2.hasNext()) {
                res = true;
                break;
            }

            while (it1.hasNext() && it2.hasNext()) {
                Warrior warrior1 = it1.next();
                Warrior warrior2 = it2.next();
                log.atDebug().log("{} {attack = {}} hits {} {attack = {}}",
                                  warrior1, warrior1.getAttack(), warrior2, warrior2.getAttack());
                fight(warrior1, warrior2);

                log.atDebug().log("");
            }
            round++;
        }
        return res;
    }
}
