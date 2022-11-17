package characters;

public class Defender extends Warrior {
    private static final int ATTACK = 3;
    private static final int DEFENSE = 2;

    public Defender() {
        super(60);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    public int getDefense() {
        return DEFENSE;
    }

    @Override
    protected void receiveDamage(int attack) {
        if (attack >= getAttack()) {
            super.receiveDamage(attack - getDefense());
        }
    }
}
