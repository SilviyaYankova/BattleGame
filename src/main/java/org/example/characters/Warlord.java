package org.example.characters;

import org.example.weapons.Weapon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Warlord extends WarriorImpl {
    private static final int ATTACK = 3;
    private static final int DEFENSE = 2;

    public Warlord() {
        super(100);
    }

    @Override
    public int getAttack() {
        int bonusAttack = getWeapons().stream().mapToInt(Weapon::getAttack).sum();
        return Math.max(0, ATTACK + bonusAttack);
    }

    public int getDefense() {
        int bonusDefence = getWeapons().stream().mapToInt(Weapon::getDefense).sum();
        return Math.max(0, DEFENSE + bonusDefence);
    }

    @Override
    public void receiveDamage(int attack) {
        if (attack > getDefense()) {
            super.receiveDamage(Math.max(0, attack - getDefense()));
        }
    }

    Iterator<Warrior> moveUnits(Iterable<Warrior> army) {
        List<Warrior> list = new ArrayList<>();
        for (Warrior warrior : army) {
            if (warrior != this) {
                list.add(warrior);
            }
        }

        List<Warrior> lancers = list.stream().filter(w -> w instanceof Lancer).toList();
        List<Warrior> healers = list.stream().filter(w -> w instanceof Healer).toList();
        List<Warrior> others = list.stream()
                                   .filter(w -> !(w instanceof Lancer ||
                                           w instanceof Healer)).toList();

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
        result.add(this);
        return result.iterator();
    }
}
