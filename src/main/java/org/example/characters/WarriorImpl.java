package org.example.characters;

import org.example.weapons.Weapon;

import java.util.ArrayList;
import java.util.List;

public class WarriorImpl implements Warrior {
    private static int ATTACK = 5;
    private int health;
    private final int initialHealth;
    Warrior warrior;
    List<Weapon> weapons;

    public WarriorImpl() {
        this(50);
    }

    public WarriorImpl(Warrior warrior) {
        this(50);
        this.warrior = warrior;
    }

    protected WarriorImpl(int health) {
        this.initialHealth = health;
        this.health = health;
        weapons = new ArrayList<>();
    }

    @Override
    public Warrior getWarrior() {
        return warrior;
    }

    @Override
    public List<Weapon> getWeapons() {
        return weapons;
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    public void setAttack(int attack) {
        ATTACK = attack;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void healBy(int healPoints) {
        setHealth(getHealth() + healPoints);
    }

    @Override
    public void hit(Warrior opponent) {
        opponent.receiveDamage(getAttack());
    }

    @Override
    public void receiveDamage(int attack) {
        if (attack > 0) {
            setHealth(health - attack);
        }
    }


    @Override
    public void equipWeapon(Weapon weapon) {
        getWeapons().add(weapon);
        setHealth(Math.max(0, getHealth() + weapon.getHealth()));
        setAttack(Math.max(0, getAttack() + weapon.getAttack()));
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {health = " + health + "}";
    }
}
