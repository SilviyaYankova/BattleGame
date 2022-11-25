package org.example.commands;

import org.example.decorators.WarriorInArmy;

public interface CanProcessCommand {
    default void processCommand(Command command, WarriorInArmy sender) {
    }
}
