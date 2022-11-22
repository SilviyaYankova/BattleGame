package org.example.interfaces;

public interface Warrior {
    int getAttack();

    int getHealth();

    default boolean isAlive() {
        return getHealth() > 0;
    }

    void hit(Warrior opponent);

    void receiveDamage(int attack);
}
