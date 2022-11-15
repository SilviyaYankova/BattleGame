package characters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Supplier;

public class Army {

    public Collection<Warrior> troops;

    public Army() {
        this.troops = new ArrayList<>();
    }

    public void addUnits(Supplier<Warrior> factory, int quantity) {
        for (int i = 0; i < quantity; i++) {
            troops.add(factory.get());
        }
    }

    public Warrior getWarrior() {
        return troops.iterator().next();
    }

    public boolean isAlive() {
        return troops.iterator().hasNext();
    }

}
