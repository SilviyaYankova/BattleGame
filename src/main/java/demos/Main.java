package demos;

import battles.Battle;
import characters.Army;
import characters.Knight;
import characters.Warrior;

public class Main {
    public static void main(String[] args) {

        var knights = new Army();
        knights.addUnits(Knight::new, 3);

        var warriors = new Army();
        warriors.addUnits(Warrior::new, 3);

//        System.out.println(Battle.fight(knights, warriors));
//        System.out.println(Battle.fight(warriors, knights));

        var army3 = new Army();
        army3.addUnits(Warrior::new, 20);
        army3.addUnits(Knight::new, 5);

        var army4 = new Army();
        army4.addUnits(Warrior::new, 30);
        System.out.println(Battle.fight(army3, army4));
    }
}
