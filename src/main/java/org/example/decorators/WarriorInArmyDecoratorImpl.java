package org.example.decorators;

import org.example.characters.Warrior;

public class WarriorInArmyDecoratorImpl implements Warrior, WarriorInArmyDecorator {
    Warrior warrior;
    Warrior nextWarrior;

    public WarriorInArmyDecoratorImpl(Warrior warrior) {
        this.warrior = warrior;
    }

    public void setNextWarrior(Warrior nextWarrior) {
        this.nextWarrior = nextWarrior;
    }

    @Override
    public Warrior getWarriorBehind() {
        return nextWarrior;
    }

    @Override
    public int getAttack() {
        return warrior.getAttack();
    }

    @Override
    public int getHealth() {
        return warrior.getHealth();
    }

    @Override
    public void hit(Warrior opponent) {
        warrior.hit(opponent);
    }

    @Override
    public void receiveDamage(int attack) {
        warrior.receiveDamage(attack);
    }

    @Override
    public void healBy(int healPoints) {
        warrior.healBy(healPoints);
    }

    @Override
    public void heal(Warrior opponent) {
        warrior.heal(opponent);
    }

}
