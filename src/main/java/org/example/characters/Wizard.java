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
    private static final int RESURRECTION_RESERVED_FOR_WARLORD = 1;

    public Wizard(int resurrectionPowers) {
        super(10);
        this.resurrectionPowers = resurrectionPowers;
    }

    @Override
    public int getAttack() {
        return ATTACK + getWeapons().stream().mapToInt(Weapon::getAttack).sum();
    }

    public int getResurrectionPowers() {
        return resurrectionPowers;
    }

    private void setResurrectionPowers(int resurrectionPowers) {
        this.resurrectionPowers = resurrectionPowers;
    }

    public int getResurrectionReservedForWarlord() {
        return RESURRECTION_RESERVED_FOR_WARLORD;
    }

    private boolean hasAttack() {
        return getAttack() > 0;
    }

    @Override
    public void hit(Warrior opponent) {
        if (hasAttack()) {
            opponent.receiveDamage(getAttack());
        }

        if (!hasAttack() && opponent instanceof Wizard && !((Wizard) opponent).hasAttack()) {
            setHealth(0);
        }
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        if (weapon instanceof MagicWand) {
            super.equipWeapon(weapon);
            setResurrectionPowers(resurrectionPowers + getWeapons().stream().mapToInt(Weapon::getHealPower).sum());
        }
    }


    @Override
    public void processCommand(Command command, Warrior deadWarrior) {
        if (command instanceof ResurrectWarriorCommand) {
            resurrect(deadWarrior);
        }
    }

    private void resurrect(Warrior deadWarrior) {
        int initialHealth = deadWarrior.getInitialHealth();
        if (getResurrectionPowers() > getResurrectionReservedForWarlord()) {
            log.atDebug().log("Wizard is resurrecting warrior;");
            log.atDebug().log("Wizard before resurrection: {}", getResurrectionPowers());

            deadWarrior.setHealth(initialHealth);
            setResurrectionPowers(getResurrectionPowers() - 1);

            log.atDebug().log("\t - {} is resurrected", deadWarrior);
            log.atDebug().log("Wizard after resurrection: {}", resurrectionPowers);
        } else if (getResurrectionPowers() == getResurrectionReservedForWarlord() && deadWarrior instanceof Warlord) {
            log.atDebug().log("Wizard is resurrecting warlord...");
            log.atDebug().log("Wizard before resurrection: {}", getResurrectionPowers());

            deadWarrior.setHealth(initialHealth);
            setResurrectionPowers(getResurrectionPowers() - 1);

            log.atDebug().log("\t - {} is resurrected", deadWarrior);
            log.atDebug().log("Wizard after resurrection: {}", getResurrectionPowers());
        } else {
            log.atDebug().log("Wizard's resurrections reserved for Warlord: {}", getResurrectionPowers());
        }
    }
}
