package com.example.simulation;

import com.example.simulation.Entitys.*;

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
            String line = "";
            for (int j = 1; j < map.getColumns() + 1; j++) {
                coordinates = new Coordinates(i, j);

                if (!(map.getEntities().containsKey(coordinates))){
                    line += UNICODE_EMPTY_CELL;

                } else {
                    Entity entity = map.getEntity(coordinates);

                    if (entity instanceof Rock){
                        line += UNICODE_ROCK;
                    } else if (entity instanceof Tree) {
                        line += UNICODE_TREE;
                    } else if (entity instanceof Grass) {
                        line += UNICODE_GRASS;
                    } else if (entity instanceof Herbivore) {
                        line += UNICODE_HERBIVORE;
                    } else if (entity instanceof Predator) {
                        line += UNICODE_PREDATOR;
                    }
                }
            }
            System.out.println(line);
        }
    }
}
