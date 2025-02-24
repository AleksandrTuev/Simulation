package com.example.simulation.actions.spawn_action;

import com.example.simulation.Coordinates;
import com.example.simulation.GameMap;
import com.example.simulation.entities.*;

public interface Spawnable {
    static void createEntity(Class <? extends Entity> entity, int count, GameMap gameMap) {

        for (int i = 0; i < count; i++) {
            Coordinates coordinates;

            if (!(AvailableCellsChecker.hasAvailableCells(gameMap))) {
                return;
            }

            if (entity.equals(Rock.class)){
                coordinates = RandomAvailableCoordinateGenerator.generate(gameMap);
                Rock rock = new Rock();
                gameMap.setEntity(coordinates, rock);

            } else if (entity.equals(Tree.class)) {
                coordinates = RandomAvailableCoordinateGenerator.generate(gameMap);
                Tree tree = new Tree();
                gameMap.setEntity(coordinates, tree);

            } else if (entity.equals(Grass.class)) {
                coordinates = RandomAvailableCoordinateGenerator.generate(gameMap);
                Grass grass = new Grass();
                gameMap.setEntity(coordinates, grass);

            } else if (entity.equals(Herbivore.class)) {
                coordinates = RandomAvailableCoordinateGenerator.generate(gameMap);
                Herbivore herbivore = new Herbivore(coordinates);
                herbivore.setCoordinates(coordinates);
                gameMap.setEntity(coordinates, herbivore);

            } else if (entity.equals(Predator.class)) {
                coordinates = RandomAvailableCoordinateGenerator.generate(gameMap);
                Predator predator = new Predator(coordinates);
                predator.setCoordinates(coordinates);
                gameMap.setEntity(coordinates, predator);
            }
        }
    }
}
