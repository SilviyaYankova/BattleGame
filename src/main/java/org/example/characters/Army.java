package org.example.characters;


import org.example.decorators.WarriorInArmy;

import java.util.*;
import java.util.function.Supplier;

public class Army {
    protected List<WarriorInArmy> troops;
    private WarriorInArmy tail;

    public Army() {
        this.troops = new ArrayList<>();
    }

    public List<WarriorInArmy> getTroops() {
        return troops;
    }

    public void setTroops(List<WarriorInArmy> troops) {
        this.troops = troops;
    }

    public Army addUnits(Supplier<Warrior> factory, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Warrior warrior = factory.get();
            WarriorInArmy wrapped = new WarriorInArmy(warrior);

            if (tail != null) {
                tail.setNextWarrior(wrapped);
            }
            tail = wrapped;
            troops.add(wrapped);
        }
        return this;
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

    public Iterator<Warrior> nextAliveIterator() {
        return new NextAliveIterator();
    }

    class NextAliveIterator implements Iterator<Warrior> {
        Iterator<WarriorInArmy> iterator = troops.iterator();

        WarriorInArmy nextAlive;

        @Override
        public boolean hasNext() {
            while (iterator.hasNext()) {
                nextAlive = iterator.next();
                if (nextAlive.isAlive()) return true;
            }
            return false;
        }

        @Override
        public Warrior next() {
            return nextAlive.unwrap();
        }
    }


    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + troops.size();
    }
}
