package org.example.handlers;

import org.example.characters.Warrior;

public interface HealHandler {
    void setNextHealHandler(HealHandler nextHealHandler);

    void heal(Warrior warrior);
}
