package battles;

import characters.Warrior;

public class Battle {

    /**
     * Two warriors fights or warrior fights knight
     * params warriorOne and warriorTwo
     * First warrior always attack first, if the second warrior is still alive, he will attack first warrior
     * @return true if first warrior is alive or false if not
     */
    public static boolean fight(Warrior warriorOne, Warrior warriorTwo) {
        while (warriorOne.isAlive() && warriorTwo.isAlive()) {

            warriorTwo.setHealth(warriorTwo.getHealth() - warriorOne.getAttack());

            if (!warriorTwo.isAlive()) {
                break;
            }

            warriorOne.setHealth(warriorOne.getHealth() - warriorTwo.getAttack());
        }

        return warriorOne.isAlive();
    }
}
