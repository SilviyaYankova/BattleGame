package org.example.characters;

import org.example.commands.CanProcessCommand;
import org.example.commands.ChampionHitCommand;
import org.example.commands.Command;
import org.example.decorators.WarriorInArmy;
import org.example.weapons.Weapon;

public class Healer extends WarriorImpl implements CanProcessCommand {
    private static final int HEAL_POWER = 2;

    public Healer() {
        super(60);
    }

    @Override
    public void hit(Warrior opponent) {
        // do nothing
    }

    public int getHealPower() {
        int newHealPower = 0;
        if (!getWeapons().isEmpty()) {
            for (Weapon weapon : getWeapons()) {
                newHealPower += weapon.getHealPower();
            }
        }
        return Math.max(0, HEAL_POWER + newHealPower);
    }

    @Override
    public void processCommand(Command command, WarriorInArmy sender) {
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
