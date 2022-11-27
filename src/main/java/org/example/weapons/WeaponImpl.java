package org.example.weapons;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WeaponImpl implements Weapon{
    int health;
    int attack;
    int defense;
    int vampirism;
    int healPower;

}
