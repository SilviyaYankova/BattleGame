package org.example.characters;

import org.example.commands.CanProcessCommand;
import org.example.commands.ChampionHitCommand;
import org.example.commands.Command;
import org.example.decorators.WarriorInArmy;
import org.example.weapons.Weapon;

public class Healer extends WarriorImpl implements CanProcessCommand {
    private static int ATTACK = 0;
    private static int HEAL_POWER = 2;

    public Healer() {
        super(60);
    }

    public int getHealPower() {
        return HEAL_POWER;
    }

    public static void setHealPower(int healPower) {
        HEAL_POWER = healPower;
    }

    @Override
    public int getAttack() {
        return ATTACK;
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

    @Override
    public void equipWeapon(Weapon weapon) {
        getWeapons().add(weapon);
        setHealth(Math.max(0, getHealth() + weapon.getHealth()));
        setHealPower(Math.max(0, getHealPower() + weapon.getHealPower()));

    }
}
