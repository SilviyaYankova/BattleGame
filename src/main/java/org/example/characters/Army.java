package org.example.characters;

import lombok.extern.slf4j.Slf4j;
import org.example.decorators.WarriorInArmy;
import org.example.weapons.Weapon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

@Slf4j
public class Army implements Iterable<Warrior> {
    protected List<WarriorInArmy> troops;
    protected List<Warrior> deadUnits;
    private WarriorInArmy head;
    private WarriorInArmy tail;
    private Warlord warlord;
    private Wizard wizard;

    public Army() {
        this.troops = new ArrayList<>();
        this.deadUnits = new ArrayList<>();
    }

    public Warlord getWarlord() {
        return warlord;
    }

    public List<WarriorInArmy> getTroops() {
        return troops;
    }

    public Army addUnits(Warrior warrior) {
        if (warrior instanceof Warlord) {
            if (warlord != null) return null;
            warlord = (Warlord) warrior;
        }
        if (warrior instanceof Wizard) {
            if (wizard != null) return null;
            wizard = (Wizard) warrior;
        }

        WarriorInArmy wrapped = new WarriorInArmy(warrior);
        if (head == null) {
            head = wrapped;
        } else {
            tail.setNextWarrior(wrapped);
        }
        tail = wrapped;
        troops.add(wrapped);
        return this;
    }

    public Army addUnits(Supplier<Warrior> factory, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Warrior warrior = factory.get();
            if (warrior instanceof Warlord) {
                if (warlord != null) continue;
                warlord = (Warlord) warrior;
            }
            if (warrior instanceof Wizard) {
                if (wizard != null) continue;
                wizard = (Wizard) warrior;
            }
            WarriorInArmy wrapped = new WarriorInArmy(warrior);

            if (head == null) {
                head = wrapped;
            } else {
                tail.setNextWarrior(wrapped);
            }
            tail = wrapped;
            troops.add(wrapped);
        }
        return this;
    }

    @Override
    public Iterator<Warrior> iterator() {
        return new ArmyIterator();
    }

    class ArmyIterator implements Iterator<Warrior> {
        WarriorInArmy cursor = head;

        @Override
        public boolean hasNext() {
            while (cursor != null && !cursor.isAlive()) {
                cursor = cursor.getWarriorBehind();
            }
            return cursor != null;
        }

        @Override
        public Warrior next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            WarriorInArmy res = cursor;
            cursor = cursor.getWarriorBehind();
            return res.unwrap();
        }
    }

    public Iterator<Warrior> fistsAliveIterator() {
        return new FirstAliveIterator();
    }

    class FirstAliveIterator implements Iterator<Warrior> {
        Iterator<WarriorInArmy> iterator = troops.iterator();
        Warrior champion;

        @Override
        public boolean hasNext() {
            if (champion == null || !champion.isAlive()) {
                if ((iterator.hasNext())) {
                    champion = iterator.next();
                    return champion.isAlive();
                } else {
                    return false;
                }
            }
            return true;
        }

        @Override
        public Warrior next() {
            if ((!hasNext())) {
                throw new NoSuchElementException();
            }
            return champion;
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + troops.size();
    }

    public void equipWarriorAtPosition(int position, Weapon weapon) {
        WarriorInArmy warriorInArmy = troops.get(position);
        warriorInArmy.equipWeapon(weapon);
    }

    public Army moveUnits() {
        if (warlord != null) {

            for (WarriorInArmy warrior : troops) {
                if (!warrior.isAlive()) {
                    deadUnits.add(warrior.unwrap());
                }
            }

            Iterator<Warrior> iterator = warlord.moveUnits(this, deadUnits);

            head = tail = null;

            troops = new ArrayList<>();
            deadUnits = new ArrayList<>();
            warlord = null;
            wizard = null;

            log.atDebug().log("Rearranged army:");
            while (iterator.hasNext()) {
                Warrior next = iterator.next();
                addUnits(next);
                log.atDebug().log("\t - {}", next);
            }
        }
        return this;
    }
}
