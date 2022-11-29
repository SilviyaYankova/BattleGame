package org.example.weapons;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Katana implements Weapon {
    int health;
    int attack;
    int defense;
    int vampirism;
}
