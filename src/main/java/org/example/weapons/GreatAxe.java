package org.example.weapons;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GreatAxe implements Weapon {
    int health;
    int attack;
    int defense;
    int vampirism;
}
