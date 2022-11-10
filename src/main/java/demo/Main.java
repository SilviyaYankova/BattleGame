package demo;

import battles.Battle;
import characters.Knight;
import characters.Warrior;

public class Main {
    public static void main(String[] args) {
        Warrior chuck = new Warrior();
        Warrior bruce = new Warrior();
        Warrior carl = new Knight();
        Warrior dave = new Warrior();

        System.out.println(Battle.fight(chuck, bruce));
        System.out.println(Battle.fight(dave, carl));

        System.out.println();
        System.out.println(chuck.isAlive());
        System.out.println(bruce.isAlive());
        System.out.println(carl.isAlive());
        System.out.println(dave.isAlive());
    }
}
