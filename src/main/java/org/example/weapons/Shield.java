package org.example.weapons;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Shield implements Weapon {
    int health;
    int attack;
    int defense;
}
