package org.example.demos;

import org.example.battles.Battle;
import org.example.characters.*;

public class Main {
    public static void main(String[] args) {
        Army army1 = new Army()
                .addUnits(Lancer::new, 1)
                .addUnits(Healer::new, 1);

        Army army2 = new Army()
                .addUnits(WarriorImpl::new, 1)
                .addUnits(Healer::new, 1);

        System.out.println(Battle.straightFight(army1, army2));
    }
}
