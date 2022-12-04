package org.example.decorators;

import org.example.characters.Healer;
import org.example.characters.Lancer;
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
    public int getInitialHealth() {
        return warrior.getInitialHealth();
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
        WarriorInArmy warriorBehind = getWarriorBehind();
        if (this.unwrap() instanceof Healer &&
                warriorBehind != null &&
                warriorBehind.unwrap() instanceof Healer) {
            if (!(opponent.unwrap() instanceof Lancer) && warriorBehind.isAlive()) {
                warrior.setHealth(0);
            }
        }
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

    @Override
    public void processCommand(Command command, Warrior sender) {
        if (warrior instanceof CanProcessCommand w) {
            w.processCommand(command, sender);
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
        warrior.equipWeapon(weapon);
    }
}
