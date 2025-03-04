package com.example.simulation.actions.spawn_action;

import com.example.simulation.Coordinates;
import com.example.simulation.GameMap;
import com.example.simulation.entities.*;

import java.util.function.Supplier;

public interface Spawnable {
    static void createEntity(Supplier<Entity> entitySupplier, int count, GameMap gameMap) {

        for (int i = 0; i < count; i++) {
            Coordinates coordinates = RandomAvailableCoordinateGenerator.generate(gameMap);

            if (!(AvailableCellsChecker.hasAvailableCells(gameMap))) {
                return;
            }
            Entity entity = entitySupplier.get();

            if (entity instanceof Creature creature) {
                creature.setCoordinates(coordinates);
            }

            gameMap.setEntity(coordinates, entity);
        }
    }
}
