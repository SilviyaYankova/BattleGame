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
        int bonusAttack = getWeapons().stream().mapToInt(Weapon::getAttack).sum();
        return Math.max(0, ATTACK + bonusAttack);
    }

    public int getVampirism() {
        int bonusVampirism = getWeapons().stream().mapToInt(Weapon::getVampirism).sum();
        return Math.max(0, VAMPIRISM + bonusVampirism);
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
