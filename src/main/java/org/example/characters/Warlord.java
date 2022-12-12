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

        List<Warrior> aliveUnits = new ArrayList<>();
        for (Warrior warrior : army) {
            if (warrior != this) {
                aliveUnits.add(warrior);
            }
        }

        Warrior wizard = aliveUnits.stream().filter(w -> w instanceof Wizard).findFirst().orElse(null);

        if (wizard != null && !deadUnits.isEmpty()) {
            for (Warrior deadWarrior : deadUnits) {
                log.atDebug().log("\t - Dead warrior: {}", deadWarrior);

                WarriorInArmy wiz = new WarriorInArmy(wizard);

                wiz.processCommand(ResurrectWarriorCommand.INSTANCE, deadWarrior);

                if (deadWarrior.isAlive() && !(deadWarrior instanceof Warlord)) {
                    aliveUnits.add(0, deadWarrior);
                }
                else {
                    if (!(deadWarrior instanceof Warlord)) {
                    log.atDebug().log("\t - {} cannot be resurrected", deadWarrior);
                    }
                }
            }
        }

        List<Warrior> lancers = aliveUnits.stream().filter(w -> w instanceof Lancer).toList();
        List<Warrior> healers = aliveUnits.stream().filter(w -> w instanceof Healer).toList();
        List<Warrior> others = aliveUnits.stream()
                                   .filter(w -> !(w instanceof Lancer ||
                                           w instanceof Healer || w instanceof Wizard)).toList();

        List<Warrior> rearrangedArmy = new ArrayList<>();

        if (!lancers.isEmpty()) {
            lancers.stream().limit(1).findFirst().ifPresent(rearrangedArmy::add);
        } else {
            others.stream().limit(1).findFirst().ifPresent(rearrangedArmy::add);
        }

        if (!healers.isEmpty()) {
            rearrangedArmy.addAll(healers);
        }

        if (lancers.size() > 1) {
            for (int i = 1; i < lancers.size(); i++) {
                rearrangedArmy.add(lancers.get(i));
            }
        }

        if (others.size() > 1) {
            if (rearrangedArmy.get(0) instanceof Lancer) {
                rearrangedArmy.addAll(others);
            } else {
                for (int i = 1; i < others.size(); i++) {
                    rearrangedArmy.add(others.get(i));
                }
            }
        }

        if (this.isAlive()) {
            rearrangedArmy.add(this);
        }
        if (wizard != null) {
            rearrangedArmy.add(wizard);
        }
        return rearrangedArmy.iterator();
    }
}
