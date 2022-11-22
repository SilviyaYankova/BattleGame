package org.example.characters;

import org.example.interfaces.HasWarriorBehind;
import org.example.interfaces.Warrior;

import java.util.*;
import java.util.function.Supplier;

public class Army {
    protected List<Warrior> troops;
    private WarriorInArmyDecorator tail;

    static class WarriorInArmyDecorator implements Warrior, HasWarriorBehind {
        Warrior warrior;
        Warrior nextWarrior;

        public WarriorInArmyDecorator(Warrior warrior) {
            this.warrior = warrior;
        }

        private void setNextWarrior(Warrior nextWarrior) {
            this.nextWarrior = nextWarrior;
        }

        @Override
        public Warrior getWarriorBehind() {
            return nextWarrior;
        }

        @Override
        public int getAttack() {
            return warrior.getAttack();
        }

        @Override
        public int getHealth() {
            return warrior.getHealth();
        }

        @Override
        public void hit(Warrior opponent) {
            warrior.hit(opponent);
        }

        @Override
        public void receiveDamage(int attack) {
            warrior.receiveDamage(attack);
        }
    }


    public Army() {
        this.troops = new ArrayList<>();
    }

    public Army addUnits(Supplier<Warrior> factory, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Warrior warrior = factory.get();
            WarriorInArmyDecorator wrapped = new WarriorInArmyDecorator(warrior);

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
