package org.example.weapons;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MagicWand implements Weapon {
    int health;
    int attack;
    int healPower;
}
