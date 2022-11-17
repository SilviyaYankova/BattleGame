package demos;

import battles.Battle;
import characters.Army;
import characters.Defender;
import characters.Vampire;
import characters.Warrior;

public class Main {
    public static void main(String[] args) {

        Army army = new Army().addUnits(Defender::new, 5)
                              .addUnits(Vampire::new, 6)
                              .addUnits(Warrior::new, 7);

        Army army2 = new Army().addUnits(Warrior::new, 6)
                               .addUnits(Defender::new, 6)
                               .addUnits(Vampire::new, 6);

        Battle.fight(army, army2);

    }
}
