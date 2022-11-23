package org.example.characters;

public class Healer extends WarriorImpl {
    private static final int ATTACK = 0;
    private static final int HEAL_POWER = 2;

    public Healer() {
        super(60);
    }

    public int getHealPower() {
        return HEAL_POWER;
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    @Override
    public void heal(Warrior warrior) {
        warrior.healBy(getHealPower());
    }
}
