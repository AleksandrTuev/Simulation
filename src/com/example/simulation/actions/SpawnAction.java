package com.example.simulation.actions;

import com.example.simulation.Coordinates;
import com.example.simulation.Map;
import com.example.simulation.entities.*;

public class SpawnAction implements Action{
    private static final int COEFFICIENT = 3;
    private Map map;
    @Override
    public void execute(Map map) {
        this.map = map;
        createGrass();
        createHerbivore();
    }

    private void createGrass() {
        Coordinates coordinates;
        int countGrass = getNumberHerbivores() * COEFFICIENT;

        for (int i = 0; i < countGrass; i++) {
            coordinates = RandomAvailableCoordinateGenerator.generate(map);
            Grass grass = new Grass();
            map.setEntity(coordinates, grass);

//            if ((i + 1) % 10 == 0) {
//                coordinates = RandomAvailableCoordinateGenerator.generate(map);
//                Herbivore herbivore = new Herbivore(coordinates);
//                map.setEntity(coordinates, herbivore);
//            }
        }
    }

    private void createHerbivore() {
        Coordinates coordinates;
        int count = getNumberHerbivores();

        if (count % 3 == 0) {
            coordinates = RandomAvailableCoordinateGenerator.generate(map);
            Herbivore herbivore = new Herbivore(coordinates);
            map.setEntity(coordinates, herbivore);
        }
    }

    private int getNumberHerbivores() {
        int count = 0;

        for (Entity entity : map.getEntities().values()) {
            if (entity instanceof Herbivore) {
                count++;
            }
        }
        return count;
    }
}
