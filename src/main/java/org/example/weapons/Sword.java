package org.example.weapons;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Sword implements Weapon {
    int health;
    int attack;
}
