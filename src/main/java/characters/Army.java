package characters;

import java.util.*;
import java.util.function.Supplier;

public class Army {

    protected List<Warrior> troops;

    public Army() {
        this.troops = new ArrayList<>();
    }

    public List<Warrior> getTroops() {
        return troops;
    }

    public Army addUnits(Supplier<Warrior> factory, int quantity) {
        for (int i = 0; i < quantity; i++) {
            troops.add(factory.get());
        }
        return this;
    }

    public void setArmyToWarrior(Army army, Warrior warrior) {
        warrior.setArmy(army);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + troops.size();
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
}
