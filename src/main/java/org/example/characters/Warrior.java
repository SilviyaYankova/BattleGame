package org.example.characters;

public interface Warrior {
    int getAttack();

    int getHealth();
    void setHealth(int health);

    default boolean isAlive() {
        return getHealth() > 0;
    }

    void hit(Warrior opponent);

    void receiveDamage(int attack);

    void healBy(int healPoints);

    Warrior getWarrior();
}
