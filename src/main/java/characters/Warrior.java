package characters;

public class Warrior {
    private static final int ATTACK = 5;
    private int health;

    public Warrior() {
        this(50);
    }

    public Warrior(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    private void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return ATTACK;
    }

    public boolean isAlive() {
        return this.getHealth() > 0;
    }

    public void hit(Warrior opponent) {
        if (opponent.getClass() == Defender.class) {
            if (getAttack() >= opponent.getAttack()) {
            opponent.receiveDamage(
                    getAttack() - ((Defender) opponent).getDefense());
            }
        } else {
            opponent.receiveDamage(getAttack());
        }
    }

    private void receiveDamage(int attack) {
        setHealth(health - attack);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {health = " + health + "}";
    }
}
