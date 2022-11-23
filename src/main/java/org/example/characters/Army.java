package org.example.characters;


import org.example.decorators.WarriorInArmyDecoratorImpl;

import java.util.*;
import java.util.function.Supplier;

public class Army {
    protected List<Warrior> troops;
    private WarriorInArmyDecoratorImpl tail;

    public Army() {
        this.troops = new ArrayList<>();
    }

    public Army addUnits(Supplier<Warrior> factory, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Warrior warrior = factory.get();
            WarriorInArmyDecoratorImpl wrapped = new WarriorInArmyDecoratorImpl(warrior);

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

        Iterator<Warrior> iterator = troops.iterator();
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

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + troops.size();
    }
}
