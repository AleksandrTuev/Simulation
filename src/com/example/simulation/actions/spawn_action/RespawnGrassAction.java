package com.example.simulation.actions.spawn_action;

import com.example.simulation.Map;
import com.example.simulation.MapConsoleRenderer;
import com.example.simulation.actions.Action;
import com.example.simulation.entities.Grass;

public class RespawnGrassAction implements Action {
    private static final int COUNT_GRASS = 5;

    @Override
    public void execute(Map map) {
        Spawnable.createEntity(Grass.class, COUNT_GRASS, map);
        MapConsoleRenderer.render(map);
    }
}
