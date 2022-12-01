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
        int bonusAttack = getWeapons().stream().mapToInt(Weapon::getAttack).sum();
        return Math.max(0, ATTACK + bonusAttack);
    }

    public int getDefense() {
        int bonusDefence = getWeapons().stream().mapToInt(Weapon::getDefense).sum();
        return Math.max(0, DEFENSE + bonusDefence);
    }

    @Override
    public void receiveDamage(int attack) {
        if (attack > getDefense()) {
            super.receiveDamage(Math.max(0, attack - getDefense()));
        }
    }
}
