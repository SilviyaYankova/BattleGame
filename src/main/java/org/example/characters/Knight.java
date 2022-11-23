package org.example.characters;

public class Knight extends WarriorImpl {
    private static final int ATTACK = 7;

    @Override
    public int getAttack() {
        return ATTACK;
    }

    @Override
    public void hit(Warrior opponent) {
        super.hit(opponent);
    }
}
