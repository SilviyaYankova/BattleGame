package org.example.weapons;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GreatAxe implements Weapon {
    int health;
    int attack;
    int defense;
    int vampirism;
}
