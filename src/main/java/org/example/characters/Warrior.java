package org.example.characters;

import org.example.weapons.Weapon;

import java.util.List;

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

    void equipWeapon(Weapon weapon);

    List<Weapon> getWeapons();
}
