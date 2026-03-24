package org.example.solutions.command;

import org.example.solutions.GameContext;
import org.example.solutions.strategy.PlayerClassStrategy;

public class CommandFactory {
    public GameCommand createCommand(String actionType, PlayerClassStrategy strategy, GameContext context) {
        switch (actionType.toUpperCase()) {
            case "ATTACK":
                return new AttackCommand(strategy, context);
            case "CAST_SPELL":
                return new CastSpellCommand(strategy, context);
            default:
                throw new IllegalArgumentException("Unknown action: " + actionType);
        }
    }
}
