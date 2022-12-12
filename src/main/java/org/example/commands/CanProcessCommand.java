package org.example.commands;

import org.example.characters.Warrior;
import org.example.decorators.WarriorInArmy;

public interface CanProcessCommand {
    default void processCommand(Command command, WarriorInArmy sender) {
    }

    default void processCommand(Command command, Warrior deadWarrior) {
    }
}
