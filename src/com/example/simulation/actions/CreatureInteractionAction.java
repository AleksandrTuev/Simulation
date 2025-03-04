package com.example.simulation.actions;

import com.example.simulation.GameMap;
import com.example.simulation.MapConsoleRenderer;
import com.example.simulation.entities.Creature;
import com.example.simulation.entities.Entity;

public class CreatureInteractionAction implements Action {
    @Override
    public void execute(GameMap gameMap) {
        if (isEmptyMap(gameMap)) {
            System.out.println("Карта не заполнена сущностями");
            return;
        }

        while (isLivingCreatures(gameMap)) {
            for (Entity entity : gameMap.getEntities().values()) {
                if (entity instanceof Creature creature) {
                    creature.act(gameMap);
                }
            }
            System.out.println();
            MapConsoleRenderer.render(gameMap);
        }
    }

    private boolean isEmptyMap(GameMap gameMap) {
        return gameMap.getEntities().isEmpty();
    }

    private boolean isLivingCreatures(GameMap gameMap) {
        for (Entity entity : gameMap.getEntities().values()) {
            if (entity instanceof Creature) {
                return true;
            }
        }
        return false;
    }
}
