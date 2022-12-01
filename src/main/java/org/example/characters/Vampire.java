package org.example.characters;

import org.example.weapons.Weapon;

public class Vampire extends WarriorImpl {

    private static final int ATTACK = 4;
    private static final int VAMPIRISM = 50;

    public Vampire() {
        super(40);
    }

    @Override
    public int getAttack() {
        int newAttack = 0;
        if (!getWeapons().isEmpty()) {
            for (Weapon weapon : getWeapons()) {
                newAttack += weapon.getAttack();
            }
        }

        return Math.max(0, ATTACK + newAttack);
    }

    public int getVampirism() {
        int newVampirism = 0;
        if (!getWeapons().isEmpty()) {
            for (Weapon weapon : getWeapons()) {
                newVampirism += weapon.getVampirism();
            }
        }

        return Math.max(0, VAMPIRISM + newVampirism);
    }

    @Override
    public void hit(Warrior opponent) {
        int healthBeforeAttacked = opponent.getHealth();
        opponent.receiveDamage(getAttack());
        int healthAfterAttacked = opponent.getHealth();
        int damage = healthBeforeAttacked - healthAfterAttacked;
        int percentages = 100;
        int healPoints = damage * getVampirism() / percentages;
        healBy(healPoints);
    }
}
