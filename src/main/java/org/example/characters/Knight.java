package org.example.characters;

public class Knight extends WarriorImpl {
    private int attack = 7;

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public void hit(Warrior opponent) {
        super.hit(opponent);
    }

    @Override
    public void setAttack(int attack) {
        this.attack = attack;
    }
}
