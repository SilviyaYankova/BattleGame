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

        List<Warrior> unitsBehind = opponent.getArmy().getUnitsBehind(opponent, UNITS_TO_HIT);

        if (unitsBehind != null) {
            unitsBehind.forEach(w -> {
                int healthAfterAttacked = opponent.getHealth();
                int damageNext = healthBeforeAttacked - healthAfterAttacked;
                int percentages = 100;
                int attack = damageNext * getAdditionalDamage() / percentages;
                w.receiveDamage(attack);
            });
        }
    }
}

