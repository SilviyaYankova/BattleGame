package org.example.characters;

import org.example.weapons.Weapon;

public class Defender extends WarriorImpl {
    private static int ATTACK = 3;
    private static int defense = 2;

    public Defender() {
        super(60);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    @Override
    public void setAttack(int attack) {
        Defender.ATTACK = attack;
    }

    public int getDefense() {
        return defense;
    }

    public static void setDefense(int defense) {
        Defender.defense = defense;
    }

    @Override
    public void receiveDamage(int attack) {
        if (attack > getDefense()) {
            super.receiveDamage(Math.max(0, attack - getDefense()));
        }
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        getWeapons().add(weapon);
        setHealth(Math.max(0, getHealth() + weapon.getHealth()));
        setAttack(Math.max(0, getAttack() + weapon.getAttack()));
        setDefense(Math.max(0, getDefense() + weapon.getDefense()));

    }
}
