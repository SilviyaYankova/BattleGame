package characters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Supplier;

public class Army {

    public Collection<Warrior> troops;

    public Army() {
        this.troops = new ArrayList<>();
    }

    public Army addUnits(Supplier<Warrior> factory, int quantity) {
        for (int i = 0; i < quantity; i++) {
            troops.add(factory.get());
        }
        return this;
    }

    public Warrior getFighter() {
        return troops.iterator().next();
    }

    public boolean isAlive() {
        return troops.iterator().hasNext();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + troops.size();
    }
}
