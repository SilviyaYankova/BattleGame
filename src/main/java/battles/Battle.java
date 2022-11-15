package battles;

import characters.Warrior;

public class Battle {

    /**
     * Fighting between warriors
     * @param warriorOne always attacks first;
     * @param warriorTwo always attacks second
     * @return true if first warrior is alive or false if not
     */
    public static boolean fight(Warrior warriorOne, Warrior warriorTwo) {
        while (warriorOne.isAlive() && warriorTwo.isAlive()) {

            warriorOne.hit(warriorTwo);

            if (warriorTwo.isAlive()) {
                warriorTwo.hit(warriorOne);
            }
        }

        return warriorOne.isAlive();
    }
}
