package com.example.simulation.actions.spawn_action;

import com.example.simulation.GameMap;
import com.example.simulation.MapConsoleRenderer;
import com.example.simulation.actions.Action;
import com.example.simulation.entities.*;

public class SpawnAction implements Action {
    private static final int AMOUNT_GRASS = 20;
    private static final int AMOUNT_ROCK = 1;
    private static final int AMOUNT_TREE = 1;
    private static final int AMOUNT_HERBIVORE = 15;
    private static final int AMOUNT_PREDATOR = 5;
    private GameMap gameMap;

    @Override
    public void execute(GameMap gameMap) {
        this.gameMap = gameMap;
        setupEntitiesPositions();
        MapConsoleRenderer.render(gameMap);
    }

    private void setupEntitiesPositions() {
        Spawnable.createEntity(Rock::new, AMOUNT_ROCK, gameMap);
        Spawnable.createEntity(Tree::new, AMOUNT_TREE, gameMap);
        Spawnable.createEntity(Grass::new, AMOUNT_GRASS, gameMap);
        Spawnable.createEntity(Herbivore::new, AMOUNT_HERBIVORE, gameMap);
        Spawnable.createEntity(Predator::new, AMOUNT_PREDATOR, gameMap);
    }
}
