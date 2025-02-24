package com.example.simulation;

import com.example.simulation.entities.*;

public class MapConsoleRenderer {
    private static final String UNICODE_HERBIVORE = "🐇";
    private static final String UNICODE_ROCK = "🪨";
    private static final String UNICODE_TREE = "🌳";
    private static final String UNICODE_GRASS = "🍀";
    private static final String UNICODE_PREDATOR = "🦁";
    private static final String UNICODE_EMPTY_CELL = "🏿";

    public static void render(GameMap gameMap){
    Coordinates coordinates;

        for (int i = 1; i < gameMap.getRows() + 1; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 1; j < gameMap.getColumns() + 1; j++) {
                coordinates = new Coordinates(i, j);

                if (!(gameMap.getEntities().containsKey(coordinates))){
                    line.append(UNICODE_EMPTY_CELL);
                } else {
                    Entity entity = gameMap.getEntity(coordinates);

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
