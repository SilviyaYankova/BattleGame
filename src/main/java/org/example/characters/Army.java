package org.example.characters;


import org.example.decorators.WarriorInArmy;
import org.example.weapons.Weapon;

import java.util.*;
import java.util.function.Supplier;

public class Army implements Iterable<Warrior> {
    protected List<WarriorInArmy> troops;
    private WarriorInArmy head;
    private WarriorInArmy tail;
    private Warlord warlord;

    public Army() {
        this.troops = new ArrayList<>();
    }

    public Army addUnits(Warrior warrior) {
        if (warrior instanceof Warlord) {
            if (warlord != null) return null;
            warlord = (Warlord) warrior;
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

    public List<WarriorInArmy> getTroops() {
        return troops;
    }

    public Army addUnits(Supplier<Warrior> factory, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Warrior warrior = factory.get();
            if (warrior instanceof Warlord) {
                if (warlord != null) continue;
                warlord = (Warlord) warrior;
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
                    if (!champion.isAlive()){
                        return false;
                    }
                    return true;
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
            Iterator<Warrior> iterator = warlord.moveUnits(this);
            head = tail = null;

            List<WarriorInArmy> decorator = new ArrayList<>();
            troops = new ArrayList<>();
            warlord = null;

            while (iterator.hasNext()) {
                Warrior next = iterator.next();
                addUnits(next);
                decorator.add(new WarriorInArmy(next));
            }
//            troops = decorator;
        }
        return this;
    }
}
