package com.example.simulation.actions.spawn_action;

import com.example.simulation.GameMap;
import com.example.simulation.MapConsoleRenderer;
import com.example.simulation.actions.Action;
import com.example.simulation.entities.Grass;

public class RespawnGrassAction implements Action {
    private static final int COUNT_GRASS = 5;

    @Override
    public void execute(GameMap gameMap) {
        Spawnable.createEntity(Grass::new, COUNT_GRASS, gameMap);
        MapConsoleRenderer.render(gameMap);
    }
}
