package com.example.simulation.actions.spawn_action;

import com.example.simulation.Coordinates;
import com.example.simulation.Map;
import com.example.simulation.MapConsoleRenderer;
import com.example.simulation.actions.Action;
import com.example.simulation.entities.Grass;
import com.example.simulation.entities.Predator;

public class RespawnPredatorAction implements Action {
    private static final int COUNT_PREDATOR = 1;
    @Override
    public void execute(Map map) {
        createPredator(map);
        MapConsoleRenderer.render(map);
    }

    private void createPredator(Map map) {
        Coordinates coordinates;

        for (int i = 0; i < COUNT_PREDATOR; i++) {
            coordinates = RandomAvailableCoordinateGenerator.generate(map);
            Predator predator = new Predator(coordinates);
            map.setEntity(coordinates, predator);
        }
    }
}
