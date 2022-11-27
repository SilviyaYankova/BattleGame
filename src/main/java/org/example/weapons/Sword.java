package org.example.weapons;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Sword implements Weapon {
    int health;
    int attack;

}
