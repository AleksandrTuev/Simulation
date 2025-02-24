package com.example.simulation.actions.spawn_action;

import com.example.simulation.Map;
import com.example.simulation.MapConsoleRenderer;
import com.example.simulation.actions.Action;
import com.example.simulation.entities.*;

public class SpawnAction implements Action {
    private static final int AMOUNT_GRASS = 20;
    private static final int AMOUNT_ROCK = 1;
    private static final int AMOUNT_TREE = 1;
    private static final int AMOUNT_HERBIVORE = 15;
    private static final int AMOUNT_PREDATOR = 5;
    private Map map;

    @Override
    public void execute(Map map) {
        this.map = map;
        setupEntitiesPositions();
        MapConsoleRenderer.render(map);
    }

    private void setupEntitiesPositions() {
        Spawnable.createEntity(Rock.class, AMOUNT_ROCK, map);
        Spawnable.createEntity(Tree.class, AMOUNT_TREE, map);
        Spawnable.createEntity(Grass.class, AMOUNT_GRASS, map);
        Spawnable.createEntity(Herbivore.class, AMOUNT_HERBIVORE, map);
        Spawnable.createEntity(Predator.class, AMOUNT_PREDATOR, map);
    }
}
