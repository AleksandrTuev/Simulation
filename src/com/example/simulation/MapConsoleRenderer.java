package com.example.simulation;

import com.example.simulation.entities.*;

public class MapConsoleRenderer {
    private final String UNICODE_HERBIVORE = "🐇";
    private final String UNICODE_ROCK = "🪨";
    private final String UNICODE_TREE = "🌳";
    private final String UNICODE_GRASS = "🍀";
    private final String UNICODE_PREDATOR = "🦁";
    private final String UNICODE_EMPTY_CELL = "🏿";

    public void render(Map map){
    Coordinates coordinates;

        for (int i = 1; i < map.getRows() + 1; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 1; j < map.getColumns() + 1; j++) {
                coordinates = new Coordinates(i, j);

                if (!(map.getEntities().containsKey(coordinates))){
                    line.append(UNICODE_EMPTY_CELL);

                } else {
                    Entity entity = map.getEntity(coordinates);

                    if (entity instanceof Rock){
                        line.append(UNICODE_ROCK);
                    } else if (entity instanceof Tree) {
                        line.append(UNICODE_TREE);
                    } else if (entity instanceof Grass) {
                        line.append(UNICODE_GRASS);
                    } else if (entity instanceof Herbivore) {
                        line.append(UNICODE_HERBIVORE);
                    } else if (entity instanceof Predator) {
                        line.append(UNICODE_PREDATOR);
                    }
                }
            }
            System.out.println(line);
        }
    }
}
