package org.example.weapons;

public interface Weapon {

    static Sword newSword() {
        return new Sword(5, 2);
    }

    static Shield newShield() {
        return new Shield(20, -1, 2);
    }

    static GreatAxe newGreatAxe() {
        return new GreatAxe(-15, 5, -2, 10);
    }

    static Katana newKatana() {
        return new Katana(-20, 6, -5, 50);
    }

    static MagicWand newMagicWand() {
        return new MagicWand(30, 3, 3);
    }

    static SuperWeapon newSuperWeapon() {
        return new SuperWeapon(0, 0, 0, 0, 0);
    }

    int getHealth();

    int getAttack();

    default int getVampirism() {
        return 0;
    }

    default int getDefense() {
        return 0;
    }

    default int getHealPower() {
        return 0;
    }
}
