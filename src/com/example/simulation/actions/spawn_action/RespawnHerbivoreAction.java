package com.example.simulation.actions.spawn_action;

import com.example.simulation.GameMap;
import com.example.simulation.MapConsoleRenderer;
import com.example.simulation.actions.Action;
import com.example.simulation.entities.*;

public class RespawnHerbivoreAction implements Action {
    private static final int COUNT_HERBIVORE = 1;

    @Override
    public void execute(GameMap gameMap) {
        Spawnable.createEntity(Herbivore.class, COUNT_HERBIVORE, gameMap);
        MapConsoleRenderer.render(gameMap);
    }
}
