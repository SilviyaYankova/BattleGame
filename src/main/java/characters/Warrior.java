package characters;

public class Warrior {
    private int attack;
    private int health;

    public Warrior() {
        this.attack = 5;
        this.health = 50;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getAttack() {
        return attack;
    }

    protected void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

}
