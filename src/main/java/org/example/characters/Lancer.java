package org.example.characters;

import lombok.extern.slf4j.Slf4j;
import org.example.decorators.HasWarriorBehind;
import org.example.weapons.Weapon;

@Slf4j
public class Lancer extends WarriorImpl {
    private static final int ATTACK = 6;
    private static final int VAMPIRISM = 50;

    @Override
    public int getAttack() {
        int bonusAttack = getWeapons().stream().mapToInt(Weapon::getAttack).sum();
        return Math.max(0, ATTACK + bonusAttack);
    }

    public int getVampirism() {
        return VAMPIRISM;
    }

    @Override
    public void hit(Warrior opponent) {
        int healthBeforeAttacked = opponent.getHealth();
        opponent.receiveDamage(getAttack());

        if (opponent instanceof HasWarriorBehind opponentWithNext) {
            Warrior nextWarrior = opponentWithNext.getWarriorBehind();
            if (nextWarrior != null && nextWarrior.isAlive()) {
                int healthAfterAttacked = opponent.getHealth();
                int damageDealt = healthBeforeAttacked - healthAfterAttacked;
                int percentages = 100;
                int attack = damageDealt * getVampirism() / percentages;
                nextWarrior.receiveDamage(attack);
                log.atDebug().log("\t Lancer hits next warrior {}", nextWarrior.unwrap());
            }
        }
    }
}

