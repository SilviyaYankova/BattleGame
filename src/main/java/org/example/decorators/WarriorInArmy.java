package org.example.decorators;

import org.example.characters.Warrior;
import org.example.commands.CanProcessCommand;
import org.example.commands.ChampionHitCommand;
import org.example.commands.Command;
import org.example.weapons.Weapon;

import java.util.List;

public class WarriorInArmy implements Warrior, HasWarriorBehind, CanProcessCommand {
    Warrior warrior;
    WarriorInArmy nextWarrior;

    public WarriorInArmy(Warrior warrior) {
        this.warrior = warrior;
    }

    @Override
    public Warrior getWarrior() {
        return warrior;
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
    public void setHealth(int health) {
        warrior.setHealth(health);
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

    public Warrior unwrap() {
        return warrior;
    }

    @Override
    public List<Weapon> getWeapons() {
        return warrior.getWeapons();
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        warrior.getWeapons().add(weapon);
    }
}
