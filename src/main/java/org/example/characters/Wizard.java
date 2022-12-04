package org.example.characters;

import lombok.extern.slf4j.Slf4j;
import org.example.commands.CanProcessCommand;
import org.example.commands.Command;
import org.example.commands.ResurrectWarriorCommand;
import org.example.weapons.MagicWand;
import org.example.weapons.Weapon;

@Slf4j
public class Wizard extends WarriorImpl implements CanProcessCommand {
    private int resurrectionPowers;
    private static final int ATTACK = 0;
    private static final int MAX_COUNT_RESURRECTION = 1;

    public Wizard(int resurrectionPowers) {
        super(10);
        this.resurrectionPowers = resurrectionPowers;
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    public int getResurrectionPowers() {
        return resurrectionPowers;
    }

    private void setResurrectionPowers(int resurrectionPowers) {
        this.resurrectionPowers = resurrectionPowers;
    }

    public int getMinResurrectionsLeft() {
        return MAX_COUNT_RESURRECTION;
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        if (weapon instanceof MagicWand) {
            super.equipWeapon(weapon);
        }
    }

    @Override
    public void processCommand(Command command, Warrior sender) {
        if (command instanceof ResurrectWarriorCommand) {
            resurrect(sender);
        }
    }

    private void resurrect(Warrior sender) {
        int initialHealth = sender.getInitialHealth();
        if (getResurrectionPowers() > getMinResurrectionsLeft()) {
            log.atDebug().log("Wizard is resurrecting warrior;");
            log.atDebug().log("Wizard before resurrection: {}", getResurrectionPowers());
            sender.setHealth(initialHealth);
            setResurrectionPowers(getResurrectionPowers() - 1);
            log.atDebug().log("\t - {} is resurrected", sender);
            log.atDebug().log("Wizard after resurrection: {}", getResurrectionPowers());
        } else {
            log.atDebug().log("\t - {} cannot be resurrected", sender);
        }

        if (getResurrectionPowers() == getMinResurrectionsLeft() && sender instanceof Warlord) {
            log.atDebug().log("Wizard is resurrecting warrior;");
            log.atDebug().log("Wizard before resurrection: {}", getResurrectionPowers());
            sender.setHealth(initialHealth);
            setResurrectionPowers(getResurrectionPowers() - 1);
            log.atDebug().log("\t - {} is resurrected", sender);
            log.atDebug().log("Wizard after resurrection: {}", getResurrectionPowers());
        }
    }

    @Override
    public void hit(Warrior opponent) {
        if (opponent instanceof Wizard) {
            super.hit(opponent);
        }
    }
}
