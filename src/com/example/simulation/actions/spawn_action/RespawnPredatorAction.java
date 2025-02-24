package com.example.simulation.actions.spawn_action;

import com.example.simulation.Map;
import com.example.simulation.MapConsoleRenderer;
import com.example.simulation.actions.Action;
import com.example.simulation.entities.Predator;

public class RespawnPredatorAction implements Action {
    private static final int COUNT_PREDATOR = 1;
    @Override
    public void execute(Map map) {
        Spawnable.createEntity(Predator.class, COUNT_PREDATOR, map);
        MapConsoleRenderer.render(map);
    }
}
