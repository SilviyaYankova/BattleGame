package org.example.weapons;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MagicWand implements Weapon {
    int health;
    int attack;
    int healPower;
}
