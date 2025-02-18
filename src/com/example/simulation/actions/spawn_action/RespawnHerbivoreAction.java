package com.example.simulation.actions.spawn_action;

import com.example.simulation.Coordinates;
import com.example.simulation.Map;
import com.example.simulation.MapConsoleRenderer;
import com.example.simulation.actions.Action;
import com.example.simulation.entities.*;

public class RespawnHerbivoreAction implements Action {
    private static final int COUNT_HERBIVORE = 1;

    @Override
    public void execute(Map map) {
        createHerbivore(map);
        MapConsoleRenderer.render(map);
    }

    private void createHerbivore(Map map) {
        Coordinates coordinates;

        if (!(AvailableCellsChecker.hasAvailableCells(map))) {
            return;
        }

        for (int i = 0; i < COUNT_HERBIVORE; i++) {
            coordinates = RandomAvailableCoordinateGenerator.generate(map);
            Herbivore herbivore = new Herbivore(coordinates);
            map.setEntity(coordinates, herbivore);
        }
    }
}
