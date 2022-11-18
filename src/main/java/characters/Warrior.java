package characters;

public class Warrior {
    private static final int ATTACK = 5;
    private int health;
    private final int initialHealth;

    public Warrior() {
        this(50);
    }

    protected Warrior(int health) {
        this.initialHealth = health;
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    private void setHealth(int health) {
        this.health = Math.min(initialHealth, health);
    }

    protected void healBy(int healPoints) {
        setHealth(getHealth() + healPoints);
    }

    public int getAttack() {
        return ATTACK;
    }

    public boolean isAlive() {
        return this.getHealth() > 0;
    }

    public void hit(Warrior opponent) {
        opponent.receiveDamage(getAttack());
    }

    protected void receiveDamage(int attack) {
        setHealth(health - attack);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {health = " + health + "}";
    }
}
