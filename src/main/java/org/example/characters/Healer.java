package org.example.characters;

import org.example.commands.CanProcessCommand;
import org.example.commands.ChampionHitCommand;
import org.example.commands.Command;
import org.example.decorators.WarriorInArmy;

public class Healer extends WarriorImpl implements CanProcessCommand {
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
    public void processCommand(Command  command, WarriorInArmy sender) {
        if (command instanceof ChampionHitCommand) {
            heal(sender);
        }
    }

    private void heal(Warrior warrior) {
        if (warrior instanceof WarriorInArmy w) {
            w.healBy(getHealPower());
        }
    }
}
