package com.example.simulation.actions.spawn_action;

import com.example.simulation.Coordinates;
import com.example.simulation.Map;
import com.example.simulation.entities.*;

public interface Spawnable {
    static void createEntity(Class <? extends Entity> entity, int count, Map map) {

        for (int i = 0; i < count; i++) {
            Coordinates coordinates;

            if (!(AvailableCellsChecker.hasAvailableCells(map))) {
                return;
            }

            if (entity.equals(Rock.class)){
                coordinates = RandomAvailableCoordinateGenerator.generate(map);
                Rock rock = new Rock();
                map.setEntity(coordinates, rock);

            } else if (entity.equals(Tree.class)) {
                coordinates = RandomAvailableCoordinateGenerator.generate(map);
                Tree tree = new Tree();
                map.setEntity(coordinates, tree);

            } else if (entity.equals(Grass.class)) {
                coordinates = RandomAvailableCoordinateGenerator.generate(map);
                Grass grass = new Grass();
                map.setEntity(coordinates, grass);

            } else if (entity.equals(Herbivore.class)) {
                coordinates = RandomAvailableCoordinateGenerator.generate(map);
                Herbivore herbivore = new Herbivore(coordinates);
                herbivore.setCoordinates(coordinates);
                map.setEntity(coordinates, herbivore);

            } else if (entity.equals(Predator.class)) {
                coordinates = RandomAvailableCoordinateGenerator.generate(map);
                Predator predator = new Predator(coordinates);
                predator.setCoordinates(coordinates);
                map.setEntity(coordinates, predator);
            }
        }
    }
}
