package demos;

import characters.Army;
import characters.Knight;
import characters.Warrior;

public class Main {
    public static void main(String[] args) {

        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Warrior::new, 3);
        army2.addUnits(Knight::new, 3);
        army1.addUnits(Knight::new, 3);

        System.out.println();

    }
}
