package org.example.characters;

public class Vampire extends WarriorImpl {

    private static final int ATTACK = 4;
    private static final int VAMPIRISM = 50;

    public Vampire() {
        super(40);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    public int getVampirism() {
        return VAMPIRISM;
    }

    @Override
    public void hit(Warrior opponent) {
        int healthBeforeAttacked = opponent.getHealth();
        super.hit(opponent);
        int healthAfterAttacked = opponent.getHealth();
        int damage = healthBeforeAttacked - healthAfterAttacked;
        int percentages = 100;
        int healPoints = damage * getVampirism() / percentages;
        healBy(healPoints);
    }
}
