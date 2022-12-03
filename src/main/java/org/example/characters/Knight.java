package org.example.characters;

import org.example.weapons.Weapon;

public class Knight extends WarriorImpl {
    private static final int ATTACK = 7;

    @Override
    public int getAttack() {
        int bonusAttack = getWeapons().stream().mapToInt(Weapon::getAttack).sum();
        return Math.max(0, ATTACK + bonusAttack);
    }

    @Override
    public void hit(Warrior opponent) {
        super.hit(opponent);
    }
}
