package characters;

public class Vampire extends Warrior {

    private static final int ATTACK = 4;
    private static final int VAMPIRISM = 50;

    public Vampire() {
        super(40);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    @Override
    public void hit(Warrior opponent) {
        if (opponent.getClass() == Defender.class) {
            setHealth(
                    getHealth() +
                            (getAttack() - ((Defender) opponent).getDefense()) * VAMPIRISM / 100
            );
        } else {
            setHealth(getHealth() + getAttack() * VAMPIRISM / 100);
        }
        super.hit(opponent);
    }
}
