package org.example.characters;

public class WarriorImpl implements Warrior {
    private static final int ATTACK = 5;
    private int health;
    private final int initialHealth;
    Warrior warrior;

    public WarriorImpl() {
        this(50);
    }

    protected WarriorImpl(int health) {
        this.initialHealth = health;
        this.health = health;
    }

    public WarriorImpl(Warrior warrior) {
        this(50);
        this.warrior = warrior;
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    @Override
    public int getHealth() {
        return health;
    }

    private void setHealth(int health) {
        this.health = Math.min(initialHealth, health);
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
    public String toString() {
        return getClass().getSimpleName() + " {health = " + health + "}";
    }
}
