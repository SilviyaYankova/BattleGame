package org.example.characters;

import org.example.weapons.Weapon;

public class Defender extends WarriorImpl {
    private static final int ATTACK = 3;
    private static final int DEFENSE = 2;

    public Defender() {
        super(60);
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

    public int getDefense() {
        int newDefence = 0;
        if (!getWeapons().isEmpty()) {
            for (Weapon weapon : getWeapons()) {
                newDefence += weapon.getDefense();
            }
        }

        return Math.max(0, DEFENSE + newDefence);
    }

    @Override
    public void receiveDamage(int attack) {
        if (attack > getDefense()) {
            super.receiveDamage(Math.max(0, attack - getDefense()));
        }
    }
}
