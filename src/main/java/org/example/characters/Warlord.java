package org.example.characters;

import lombok.extern.slf4j.Slf4j;
import org.example.commands.ResurrectWarriorCommand;
import org.example.decorators.WarriorInArmy;
import org.example.weapons.Weapon;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
public class Warlord extends Defender {
    private static final int ATTACK = 4;

    public Warlord() {
        super(100);
    }

    @Override
    public int getAttack() {
        return ATTACK + getWeapons().stream().mapToInt(Weapon::getAttack).sum();
    }

    @Override
    public int getDefense() {
        return super.getDefense();
    }

    @Override
    public void receiveDamage(int attack) {
        super.receiveDamage(attack);
    }

    Iterator<Warrior> moveUnits(Iterable<Warrior> army, List<Warrior> deadUnits) {
        log.atDebug().log("Warlord is moving units...");

        List<Warrior> list = new ArrayList<>();
        for (Warrior warrior : army) {
            if (warrior != this) {
                list.add(warrior);
            }
        }

        Warrior wizard = list.stream().filter(w -> w instanceof Wizard).findFirst().orElse(null);

        if (!deadUnits.isEmpty() && wizard != null) {
            for (Warrior deadWarrior : deadUnits) {
                log.atDebug().log("\t - Dead warrior: {}", deadWarrior);
                WarriorInArmy wiz = new WarriorInArmy(wizard);
                wiz.processCommand(ResurrectWarriorCommand.INSTANCE, deadWarrior);
                if (deadWarrior.isAlive() && !(deadWarrior instanceof Warlord)) {
                    list.add(0, deadWarrior);
                } else {
                    if (!(deadWarrior instanceof Warlord)) {
                    log.atDebug().log("\t - {} cannot be resurrected", deadWarrior);
                    }
                }
            }
        }

        List<Warrior> lancers = list.stream().filter(w -> w instanceof Lancer).toList();
        List<Warrior> healers = list.stream().filter(w -> w instanceof Healer).toList();
        List<Warrior> others = list.stream()
                                   .filter(w -> !(w instanceof Lancer ||
                                           w instanceof Healer || w instanceof Wizard)).toList();

        List<Warrior> result = new ArrayList<>();

        if (!lancers.isEmpty()) {
            lancers.stream().limit(1).findFirst().ifPresent(result::add);
        } else {
            others.stream().limit(1).findFirst().ifPresent(result::add);
        }

        if (!healers.isEmpty()) {
            result.addAll(healers);
        }

        if (lancers.size() > 1) {
            for (int i = 1; i < lancers.size(); i++) {
                result.add(lancers.get(i));
            }
        }

        if (others.size() > 1) {
            if (result.get(0) instanceof Lancer) {
                result.addAll(others);
            } else {
                for (int i = 1; i < others.size(); i++) {
                    result.add(others.get(i));
                }
            }

        }

        if (this.isAlive()) {
            result.add(this);
        }
        if (wizard != null) {
            result.add(wizard);
        }
        return result.iterator();
    }
}
