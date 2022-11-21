package characters;

import java.util.List;

public class Lancer extends Warrior {
    private static final int ATTACK = 6;
    private static final int ADDITIONAL_DAMAGE = 50;
    private static final int UNITS_TO_HIT = 1;

    @Override
    public int getAttack() {
        return ATTACK;
    }

    public int getAdditionalDamage() {
        return ADDITIONAL_DAMAGE;
    }

    @Override
    public void hit(Warrior opponent) {
        int healthBeforeAttacked = opponent.getHealth();
        super.hit(opponent);
        int healthAfterAttacked = opponent.getHealth();
        int damage = healthBeforeAttacked - healthAfterAttacked;

        List<Warrior> troops = opponent.getArmy().getTroops();

        int enemiesBehind = troops.indexOf(opponent) + UNITS_TO_HIT;

        if (enemiesBehind < troops.size()) {
            Warrior nextWarrior = troops.get(enemiesBehind);
            int percentages = 100;
            int attack = damage * getAdditionalDamage() / percentages;
            nextWarrior.receiveDamage(attack);
        }
    }
}

