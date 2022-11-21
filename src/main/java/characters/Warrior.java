package characters;

public class Warrior {
    private static final int ATTACK = 5;
    private int health;
    private final int initialHealth;
    private Army army;

    public Warrior() {
        this(50);
    }

    protected Warrior(int health) {
        this.initialHealth = health;
        this.health = health;
        this.army = new Army();
    }

    public int getAttack() {
        return ATTACK;
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

    public boolean isAlive() {
        return getHealth() > 0;
    }

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {health = " + health + "}";
    }

    public void hit(Warrior opponent) {
        opponent.receiveDamage(getAttack());
    }

    protected void receiveDamage(int attack) {
        setHealth(health - attack);
    }
}
