package org.example.characters;

import org.example.weapons.Weapon;

public class Vampire extends WarriorImpl {

    private static int ATTACK = 4;
    private static int VAMPIRISM = 50;

    public Vampire() {
        super(40);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    @Override
    public void setAttack(int attack) {
        Vampire.ATTACK = attack;
    }

    public int getVampirism() {
        return VAMPIRISM;
    }

    public void setVampirism(int vampirism) {
        Vampire.VAMPIRISM = vampirism;
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

    @Override
    public void equipWeapon(Weapon weapon) {
        getWeapons().add(weapon);
        setHealth(Math.max(0, getHealth() + weapon.getHealth()));
        setAttack(Math.max(0, getAttack() + weapon.getAttack()));
        setVampirism(Math.max(0, getVampirism() + weapon.getVampirism()));
    }
}
