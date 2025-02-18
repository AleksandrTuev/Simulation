package com.example.simulation.actions.spawn_action;

import com.example.simulation.Coordinates;
import com.example.simulation.Map;
import com.example.simulation.MapConsoleRenderer;
import com.example.simulation.actions.Action;
import com.example.simulation.entities.Grass;

public class RespawnGrassAction implements Action {
    private static final int COUNT_GRASS = 5;

    @Override
    public void execute(Map map) {
        createGrass(map);
        MapConsoleRenderer.render(map);
    }

    private void createGrass(Map map) {
        Coordinates coordinates;

        if (!(AvailableCellsChecker.hasAvailableCells(map))) {
            return;
        }

        for (int i = 0; i < COUNT_GRASS; i++) {
            coordinates = RandomAvailableCoordinateGenerator.generate(map);
            Grass grass = new Grass();
            map.setEntity(coordinates, grass);
        }
    }
}
