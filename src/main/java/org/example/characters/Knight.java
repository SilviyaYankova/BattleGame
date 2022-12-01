package org.example.characters;

import org.example.weapons.Weapon;

public class Knight extends WarriorImpl {
    private static final int ATTACK = 7;

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

    @Override
    public void hit(Warrior opponent) {
        super.hit(opponent);
    }
}
