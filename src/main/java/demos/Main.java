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

        System.out.println(Battle.fight(knights, warriors));
//        System.out.println(Battle.fight(warriors, knights));
    }
}
