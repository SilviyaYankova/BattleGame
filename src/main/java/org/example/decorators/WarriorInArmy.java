package org.example.decorators;

import org.example.characters.Warrior;
import org.example.commands.CanProcessCommand;
import org.example.commands.ChampionHitCommand;
import org.example.commands.Command;

public class WarriorInArmy implements Warrior, HasWarriorBehind, CanProcessCommand {
    Warrior warrior;
    WarriorInArmy nextWarrior;

    public WarriorInArmy(Warrior warrior) {
        this.warrior = warrior;
    }

    public void setNextWarrior(WarriorInArmy nextWarrior) {
        this.nextWarrior = nextWarrior;
    }

    @Override
    public WarriorInArmy getWarriorBehind() {
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
        processCommand(ChampionHitCommand.INSTANCE, this);
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
    public void processCommand(Command command, WarriorInArmy sender) {
        if (warrior instanceof CanProcessCommand w) {
            w.processCommand(command, sender);
        }

        if (nextWarrior != null) {
            nextWarrior.processCommand(command, this);
        }
    }
}
