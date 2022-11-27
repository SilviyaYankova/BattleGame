package org.example.weapons;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Katana implements Weapon {
    int health;
    int attack;
    int defense;
    int vampirism;
}
