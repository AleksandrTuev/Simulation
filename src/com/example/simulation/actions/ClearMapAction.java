package com.example.simulation.actions;

import com.example.simulation.GameMap;
import com.example.simulation.MapConsoleRenderer;

public class ClearMapAction implements Action {
    @Override
    public void execute(GameMap gameMap) {
        gameMap.removeEntities();
        MapConsoleRenderer.render(gameMap);
    }
}
