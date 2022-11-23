package org.example.characters;

public interface Warrior {
    int getAttack();

    int getHealth();

    default boolean isAlive() {
        return getHealth() > 0;
    }

    void hit(Warrior opponent);

    void receiveDamage(int attack);

    void healBy(int healPoints);

    void heal(Warrior opponent);
}
