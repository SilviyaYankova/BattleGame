package org.example.handlers;

import org.example.characters.*;
import org.example.decorators.WarriorInArmyDecorator;

public class HealHandlerImpl implements HealHandler {
    HealHandler nextHealHandler;

    @Override
    public void setNextHealHandler(HealHandler nextHealHandler) {
        this.nextHealHandler = nextHealHandler;
    }

    @Override
    public void heal(Warrior warrior) {
        if (warrior instanceof WarriorInArmyDecorator opponentWithNext) {
            Warrior nextWarrior = opponentWithNext.getWarriorBehind();
            if (nextWarrior != null && nextWarrior.getAttack() == 0) {
                    nextWarrior.heal(warrior);
            }
        }
    }
}