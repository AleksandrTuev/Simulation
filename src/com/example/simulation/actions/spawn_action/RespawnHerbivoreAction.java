package com.example.simulation.actions.spawn_action;

import com.example.simulation.Map;
import com.example.simulation.MapConsoleRenderer;
import com.example.simulation.actions.Action;
import com.example.simulation.entities.*;

public class RespawnHerbivoreAction implements Action {
    private static final int COUNT_HERBIVORE = 1;

    @Override
    public void execute(Map map) {
        Spawnable.createEntity(Herbivore.class, COUNT_HERBIVORE, map);
        MapConsoleRenderer.render(map);
    }
}
