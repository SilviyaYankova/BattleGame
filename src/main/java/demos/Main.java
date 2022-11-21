package demos;

import battles.Battle;
import characters.*;

public class Main {
    public static void main(String[] args) {

        var firstAyArmy = new Army();
        firstAyArmy.addUnits(Lancer::new, 1);
        firstAyArmy.addUnits(() -> new Vampire(), 1);


        var secondArmy = new Army();
        secondArmy.addUnits(Warrior::new, 1);
//        secondArmy.addUnits(Knight::new, 1);


        boolean fight = Battle.fight(firstAyArmy, secondArmy);
        System.out.println(fight);
    }
}
