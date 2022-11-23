package org.example.characters;

public class Defender extends WarriorImpl {
    private static final int ATTACK = 3;
    private static final int DEFENSE = 2;

    public Defender() {
        super(60);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    public int getDefense() {
        return DEFENSE;
    }

    @Override
    public void receiveDamage(int attack) {
        if (attack > getDefense()) {
            super.receiveDamage(Math.max(0, attack - getDefense()));
        }
    }
}
